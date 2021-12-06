/*
 * The MIT License
 *
 * Copyright 2021 Chilka Castro, Giuliana Bouzon.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package limitedlibrarymanagementsystem;

import java.sql.*;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.sql.Connection;
import java.util.TreeMap;
import java.util.regex.Pattern;

/**
 * Class to define Book objects.
 * As required per final project problem statement.
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka Castro, Giuliana Bouzon
 */
public class Book {

    //properties
    private String bookSN;
    private BookData data;
    private Connection connection;
    
    static final String SN_REGEX = "[0-9-]{1,16}"; //must be between 1 and 15 digits long
    //Pattern.matches(nameRegex, name) -> to use for pattern matchingS

    //default constructor
    public Book() throws Exception { 
        this("0000000", new BookData()); 
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Constructor with all data members
     *
     * @param bookSN the serial number of the book (primary key)
     * @param data the data of the book (author, publisher, etc)
     * @throws Exception
     */
    public Book(String bookSN, BookData data) throws Exception {
        setBookSN(bookSN);
        this.data = new BookData(data);
        this.connection = DBConnection.getSingleInstance();
    }

    //copy constructor
    public Book(Book book) throws Exception {
        this(book.bookSN, book.data);
        this.connection = DBConnection.getSingleInstance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookSN, data.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Book other = (Book) obj;
        return Objects.equals(data, other.data) && Objects.equals(bookSN, other.bookSN);
    }

    /**
     * Generates a String that represents a book object
     *
     * @return a String that represents a book object
     */
    @Override
    public String toString() {
        return String.format("%s : %s\n", "SN", bookSN);
    }

    /**
     * Creates a new entry in the Books table to add a new book to the catalog. 
     * Sets “Issued” attribute to zero and addedDate to the current date. 
     * @param book the book to be added to the library catalog
     * @throws Exception 
     */
    public void addBook(Book book) throws Exception {
        //checking if book already exists in the database
        String query = "SELECT * FROM BOOK WHERE SN =" + "'" + book.getBookSN() + "';";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        String sn = "";
        
        while (rs.next()) {
            sn = rs.getString("SN");
        }
        
        if (sn.equals(book.getBookSN()))
            throw new Exception("SN already exists");
        
        else {
            query = "INSERT into BOOK(SN,Title,Author,Publisher,Quantity,"
                    + "Price,IssuedQuantity,AddedDate) VALUES(" + "'" + book.getBookSN() + "',"
                    + "'" + book.getBookData().getTitle() + "'" + "," + "'" + book.getBookData().getAuthor()
                    + "'" + "," + "'" + book.getBookData().getPublisher() + "'" + ","
                    + book.getBookData().getBookQuantity() + "," + book.getBookData().getPrice() + ","
                    + book.getBookData().getIssuedQuantity() + "," + "'" + LocalDate.now().toString() + "')";

            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
        }
    }

    /**
     * If student information is valid and book is available to be borrowed, the number of copies(“Quantity”) will be decreased by one 
     * and the number of Copies issued (“Issued”) will be increased by one. 
     * A new entry in “IssuedBooks” table is added.
     * @param book the book to be issued
     * @param student the student who wants to borrow the book
     * @return true if the book was successfully issued.
     * @throws Exception 
     */
    public Boolean issueBook(Book book, Student student) throws Exception {
         // Step 1 : Check student if student is valid
        String query = "SELECT * FROM STUDENT WHERE StudentID =" + "'"
                + student.getStudentID() + "';";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        String studentID = "";
        String studentName = "";
        String contact = "";
        while (rs.next()) {
            studentID = rs.getString("StudentID");  // key 
            studentName = rs.getString("Name");
            contact = rs.getString("Contact");
        }
        
        Student studentResult = new Student(studentID, new StudentData(studentName, contact));
        
        return studentResult.borrow(book);
    }

    /**
     * If the student information is valid and book information for that student is also valid, 
     * the number of copies “Quantity” will be increased by one and the number of copies issued will be decreased by one. 
     * The corresponding record in IssuedBooks table is deleted from the table. 
     * @param book the book to be returned
     * @param student the student who borrowed the book
     * @return true if the book was successfully returned
     * @throws Exception 
     */
    public Boolean returnBook(Book book, Student student) throws Exception {
         // Step 1: Check first the book from IssuedBook table
        String query = "SELECT IssuedBookID, BookSN, StudentID "
                + "FROM ISSUEDBOOK WHERE BookSN='" + book.getBookSN()
                + "' AND StudentID= '" + student.getStudentID() + "';";
        
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        int issuedBookID = 0;
        String SN = "";
        String stuID = "";
        while (rs.next()) {
            issuedBookID = rs.getInt("IssuedBookID");
            SN = rs.getString("BookSN");
            stuID = rs.getString("StudentID");
        }
        if (!SN.equals(book.getBookSN()) || !stuID.equals(student.getStudentID()))
            throw new Exception("Student cannot return a book they have not borrowed");

        // Step 2 : Verify the SN and the stuID
        else if (SN.equals(book.getBookSN()) && stuID.equals(student.getStudentID())) {
           
            //Step 3:  Update Book Table quantity of book and issued quantity of book
            query = "UPDATE BOOK SET Quantity = Quantity + 1, "
                    + "IssuedQuantity = IssuedQuantity - 1 WHERE SN ="
                    + "'" + book.getBookSN() + "';";
            statement = connection.createStatement();
            statement.executeUpdate(query);

            // Step 4 : Delete the record from IssuedBook Table
            query = "DELETE FROM ISSUEDBOOK WHERE IssuedBookID=" + issuedBookID + ";";
            PreparedStatement prepstmt = connection.prepareStatement(query);
            prepstmt.executeUpdate();

            return true;
        }
        return false;
    }

    /**
     * This method returns a map containing all data retrieved from the Books table.
     * @return a map
     * @throws Exception 
     */
    public static Map<String, String> viewCatalog() throws Exception {
        return IViewable.viewCatalog();
    }
    
    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     * @return a map
     */
    public Map<String, String> viewIssuedBooks() throws Exception { 
        Map<String, String> map = new TreeMap<>( (String s1, String s2) -> (s1.compareTo(s2)));
        String query = "SELECT * FROM ISSUEDBOOK";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            //getting the key -> book sn
            String key = rs.getString("BookSN");
            String value = "Student ID: " + rs.getString("StudentID") + "\n" + "Student Name: " + rs.getString("StudentName") 
                    + "\n" + "Student Contact: " + rs.getString("StudentContact") + "\n" + "Issued Date: " + rs.getString("IssuedDate") + "\n";

            //inserting into map
            map.put(key, value);
        }
        if (map.isEmpty())
            throw new Exception("No books have been issued");
        
        return map;
    }

    // getters and setters
    
    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) throws Exception {
        if (Pattern.matches(SN_REGEX, bookSN)) 
            this.bookSN = bookSN;
        
        else throw new Exception("SN is not valid");      
    }

    public BookData getBookData() throws Exception {
        return new BookData(this.data);
    }

    public void setBookData(BookData data) throws Exception {
        if (data != null)
            this.data = new BookData(data);
    }
}