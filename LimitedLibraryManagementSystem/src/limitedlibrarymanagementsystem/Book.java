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
import java.util.Locale;
import java.util.ResourceBundle;
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
   

    /**
     * Default constructor
     * @throws java.lang.Exception exception thrown
     */
    public Book() throws Exception { 
        this("0000000", new BookData()); 
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Constructor with all data members
     *
     * @param bookSN the serial number of the book (primary key)
     * @param data the data of the book (author, publisher, etc)
     * @throws java.lang.Exception exception thrown
     */
    public Book(String bookSN, BookData data) throws Exception {
        setBookSN(bookSN);
        this.data = data;
        this.connection = DBConnection.getSingleInstance();                     // application of singeleton design pattern
    }

    /**
     * Copy constructor 
     * @param book the book to copy
     * @throws java.lang.Exception exception thrown
     */
    public Book(Book book) throws Exception {
        this(book.bookSN, new BookData(book.data)); // deep copy
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Generates a hash code that is based on the equals method
     * @return an integer hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(bookSN, data.hashCode());
    }

    /**
     * Checks if objects are equal or not
     * @param obj the other object to be checked for equality
     * @return True if both objects are the same and False if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass()) 
            return false;
        Book other = (Book) obj;
        return Objects.equals(data, other.data) 
                && Objects.equals(bookSN, other.bookSN);
    }

    /**
     * Generates a String that represents a book object
     *
     * @return a String that represents a book object
     */
    @Override
    public String toString() {
        if (MainMenuForm.language.equals("English")) {
           ResourceBundle resourceBundle = ResourceBundle.getBundle("source/Source", 
                   Locale.CANADA);
            return String.format("%-10s  %s\n", resourceBundle.getString("key5"), bookSN);
        }

        else {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("source/Source", 
                    Locale.CANADA_FRENCH);
            return String.format("%-10s  %s\n", resourceBundle.getString("key5"), bookSN);
        }
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
        
        while (rs.next()) 
            sn = rs.getString("SN");
        
        if (sn.equals(book.getBookSN()))
            throw new Exception("SN already exists");
        
        else {
            query = "INSERT into BOOK(SN,Title,Author,Publisher,Quantity,"
                    + "Price,IssuedQuantity,AddedDate) VALUES(" + "'" 
                    + book.getBookSN() + "'," + "'" 
                    + book.getBookData().getTitle() + "'" + "," + "'" 
                    + book.getBookData().getAuthor() + "'" + "," + "'" 
                    + book.getBookData().getPublisher() + "'" + "," 
                    + book.getBookData().getBookQuantity() + "," 
                    + book.getBookData().getPrice() + ","
                    + book.getBookData().getIssuedQuantity() + "," + "'" 
                    + LocalDate.now().toString() + "')";
           
            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
        }
    }

    /**
     * If student information is valid and book is available to be borrowed, 
     * the number of copies(“Quantity”) will be decreased by one 
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
     * If the student information is valid and book information for that student
     * is also valid, the number of copies “Quantity” will be increased by one 
     * and the number of copies issued will be decreased by one.The corresponding 
     * record in IssuedBooks table is deleted from the table. 
     * @param book the book to be returned
     * @param student the student who borrowed the book
     * @return true if the book was successfully returned
     * @throws java.lang.Exception exception thrown
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
     * @return a map of all the books in the library
     * @throws java.lang.Exception exception thrown
     */
    public static Map<String, String> viewCatalog() throws Exception {
        return IViewable.viewCatalog();
    }
    
    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     * @return a map of issued/borrowed books(sorted SN) in the library
     */
    public Map<String, String> viewIssuedBooks() throws Exception { 
        Map<String, String> map = new TreeMap<>((String s1, String s2) -> (s1.compareTo(s2)));
        String query = "SELECT * FROM ISSUEDBOOK";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA);
        while (rs.next()) {
            //getting the key -> book sn
            String key = rs.getString("BookSN");
            String value = res.getString("key11") + rs.getString("StudentID") + "\n" 
                    + res.getString("key30") + rs.getString("StudentName") 
                    + "\n" + res.getString("key31") + rs.getString("StudentContact") 
                    + "\n" + res.getString("key32") + rs.getString("IssuedDate") + "\n";
            
            //inserting into map
            map.put(key, value);
        }
        if (map.isEmpty())
            throw new Exception(res.getString("key33"));
        
        return map;
    }
    
    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     * @return a map of issued/borrowed books(sorted SN) in the library
     */
    public Map<String, String> viewIssuedBooksFrench() throws Exception { 
        Map<String, String> map = new TreeMap<>((String s1, String s2) -> (s1.compareTo(s2)));
        String query = "SELECT * FROM ISSUEDBOOK";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA_FRENCH);
        while (rs.next()) {
            //getting the key -> book sn
            String key = rs.getString("BookSN");
            String value = res.getString("key11") + rs.getString("StudentID") + "\n" 
                    + res.getString("key30") + rs.getString("StudentName") 
                    + "\n" + res.getString("key31") + rs.getString("StudentContact") 
                    + "\n" + res.getString("key32") + rs.getString("IssuedDate") + "\n";
            

            //inserting into map
            map.put(key, value);
        }
        if (map.isEmpty())
            throw new Exception(res.getString("key33"));
        
        return map;
    }

    // getters and setters
    
    /**
     * Gets the book's serial number
     * @return the book's serial number
     */
    public String getBookSN() {
        return bookSN;
    }

    /**
     * Sets the book's serial number
     * @param bookSN the book's serial number
     * @throws java.lang.Exception exception thrown
     */
    public void setBookSN(String bookSN) throws Exception {
        if (bookSN != null && !bookSN.isEmpty()) 
            this.bookSN = bookSN;

        else  {
             ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA);
            if (MainMenuForm.language.equals("English")) {
                throw new Exception(res.getString("key38"));     
            }
            if (MainMenuForm.language.equals("French")) {
                res = ResourceBundle.getBundle("source/Source", Locale.CANADA_FRENCH);
                throw new Exception(res.getString("key38"));     
            }
        }
    }

    /**
     * Gets the data/value of the book
     * @return the data/value of the book
     * @throws java.lang.Exception exception thrown
     */
    public BookData getBookData() throws Exception {
        return new BookData(this.data);
    }

    /**
     * Sets the data/value of the book
     * @param data the data/value of the book
     * @throws java.lang.Exception exception thrown
     */
    public void setBookData(BookData data) throws Exception {
        if (data != null)
            this.data = new BookData(data);
    }
}