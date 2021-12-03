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
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Defines Book objects according to project problem statement. Programming
 * Patterns - Fall 2021 - Final Project.
 *
 * @author Chilka Castro and Giuliana Bouzon
 */
public class Book {

    //properties
    private String bookSN;
    private BookData data;
    private Connection connection;
    private static int nextIssuedBookID = 1;

    //default constructor
    public Book() throws Exception { //just for testing, not actually going to be called within the application
        this("noSN", new BookData()); //default value set to jan 1st 2010
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Constructor with all data members
     *
     * @param bookSN the serial number of the book (primary key)
     */
    public Book(String bookSN, BookData data) throws Exception {
        this.bookSN = (bookSN != null && !bookSN.isEmpty()) ? bookSN : "noSN";
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
        return String.format("%-20s : %s\n", "SN", bookSN);
    }

    /**
     * 
     * @param book
     * @throws Exception 
     */
    public void addBook(Book book) throws Exception {
        String query = "INSERT into BOOK(SN,Title,Author,Publisher,Quantity,"
                + "Price,IssuedQuantity,AddedDate) VALUES(" + "'" + book.getBookSN() + "',"
                + "'" + book.getBookData().getTitle() + "'" + "," + "'" + book.getBookData().getAuthor()
                + "'" + "," + "'" + book.getBookData().getPublisher() + "'" + ","
                + book.getBookData().getBookQuantity() + "," + book.getBookData().getPrice() + ","
                + book.getBookData().getIssuedQuantity() + "," + "'" + LocalDate.now().toString() + "')";
        //test
        System.out.println(query);
        //added date in db is NOT the same as purchased date in book(refers to the date a student
        //purchases it whilst addeddate is when the book is added to the library catalog) -> be careful

        Statement statement = connection.createStatement();
        statement.executeUpdate(query);

        statement.close();
        System.out.println("Book successfully added to database");
    }

    /**
     * 
     * @param book
     * @param student
     * @return
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

        StudentData studentData = new StudentData(studentName, contact);   // value
        Student studentResult = new Student(studentID, studentData);

        // Step 2:  Check book if library has it
        query = "SELECT * FROM BOOK WHERE SN =" + "'" + book.getBookSN() + "';";
        statement = connection.createStatement();
        rs = statement.executeQuery(query);

        String sn = "";
        String title = "";
        String author = "";
        String publisher = "";
        double price = 0;
        int quantity = 0;
        int issuedQuantity = 0;
        LocalDate date = null;
        while (rs.next()) {
            sn = rs.getString("SN");  // key
            title = rs.getString("Title");              //getting BookData  // value
            author = rs.getString("Author");
            publisher = rs.getString("Publisher");
            price = rs.getDouble("Price");
            quantity = rs.getInt("Quantity");
            issuedQuantity = rs.getInt("IssuedQuantity");
            date = LocalDate.parse(rs.getString("AddedDate"), 
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        }
        //creating BookData object
        BookData data = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);

        //creating Book object
        Book bookResult = new Book(sn, data);

        // Full Check of Book and Student
        if (studentResult.equals(student) && (bookResult.equals(book) && quantity > 0)) {
            // Update available Quantity and the issuedQuantity 
            query = "UPDATE BOOK SET Quantity = Quantity - 1, IssuedQuantiy = IssuedQuantity + 1"
                    + "WHERE SN=" + "'" + book.getBookSN() + "';";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            // Insert a row in the issuedBook table 
            
            // Add a row to the IssuedBook table 
            query = "INSERT * into ISSUEDBOOK(IssuedBookID, BookSN, "
                    + "StudentID, StudentContact, IssuedDate) "
                    + "VALUES(" + nextIssuedBookID++ + "," + "'" + book.getBookSN() //bookSN(foreign key -> already updated when step 2 is done)
                    + "'," + "'" + studentID + "'," + "'"
                    + student.getStudentData().getContactNum() + ",'" + "'"
                    + LocalDate.now().toString() + "')";
            System.out.println(query); // test
            statement.close();
            return true;
        } else {
            statement.close();
            return false;
        }

    }

    public Boolean returnBook(Book book, Student student) throws Exception {
         // Step 1: Check first the book from IssuedBook table
        String query = "SELECT IssuedBookID, BookSN, StudentID "
                + "FROM ISSUEDBOOK WHERE BookSN='" + book.getBookSN()
                + "' AND 'StudentID= '" + student.getStudentID() + "';";

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        int issuedBookID = 0;
        String bookSN = "";
        String stuID = "";
        while (rs.next()) {
            issuedBookID = rs.getInt("IssuedBookID");
            bookSN = rs.getString("BookSN");
            stuID = rs.getString("stuID");
        }

        // Step 2 : Verify the bookSN and the stuID
        if (bookSN.equals(book.getBookSN()) && stuID.equals(student.getStudentID())) {

            //Step 3:  Update Book Table quantity of book and issued quantity of book
            query = "UPDATE BOOK SET Quantity = Quantity + 1, "
                    + "IssuedQuantity = IssuedQuantiy - 1 WHERE SN ="
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

    public static Map<String, String> viewCatalog() throws Exception {
        return IViewable.viewCatalog();
    }

    
        
         /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     *
     * @return
     */
    public Map<String, String> viewIssuedBooks() throws Exception { //not finished at allllllll - problem with table design smh ask teacher
        Map<String, String> map = new HashMap<>();
        //SN is key
        //value is str comprised of: studentid, contact and issuedate

        connection = DBConnection.getSingleInstance();
        String query = "SELECT * FROM ISSUEDBOOK";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            //getting the key -> book sn
            String key = rs.getString("SN");
            String value = rs.getString("StudentID") + rs.getString("StudentName") 
                    + rs.getString("StudentContact") + rs.getString("IssuedDate");
            
            //debugging - will be deleted later
            System.out.println(key);
            //System.out.println(value);

            //inserting into map
            map.put(key, value);
        }
        return map;
    }

    // getters and setters
    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        if (bookSN != null && !bookSN.isEmpty()) {
            this.bookSN = bookSN;
        }
    }

    public BookData getBookData() {
        return new BookData(this.data);
    }

    public void setBookData(BookData data) {
        this.data = new BookData(data);
    }
}
