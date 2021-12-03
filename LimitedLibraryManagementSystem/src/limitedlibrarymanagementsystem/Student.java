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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Chilka Castro
 */
public class Student {

    //properties
    private String studentID;
    private StudentData data;
    private static int nextIssuedBookID = 1;
    private Connection connection;

    //for proofing input
    static final String ID_REGEX = "[0-9]{7}"; //id must be 7 digits long
    //Pattern.matches(nameRegex, name) -> to use for pattern matchingS

    //default constructor
    public Student() throws Exception {
        this("0000000", new StudentData()); //just for testing and debugging purposes
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Constructor with all data members
     *
     * @param studentID the ID of the student(primary key) (key -> map
     * implemented)
     * @param data the data of the student(value -> map implemented)
     */
    public Student(String studentID, StudentData data) throws Exception {
        this.connection = DBConnection.getSingleInstance();
        this.studentID = (Pattern.matches(ID_REGEX, studentID)) ? studentID : "0000000";
        this.data = new StudentData(data); //deep copy
    }

    //copy constructor
    public Student(Student student) throws Exception {
        this(student.studentID, student.data);
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Generates an integer hash code associated with an equals method
     *
     * @return and integer hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(data.hashCode(), studentID);
    }

    /**
     * Check if objects are the same or not
     *
     * @param obj the other object to be checked with for equality
     * @return True if the objects are the same and False if not
     */
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
        Student other = (Student) obj;
        return Objects.equals(data, other.data) && 
                Objects.equals(studentID, other.studentID);
    }

    /**
     * Generates a String that represents a student object
     *
     * @return a String that represents a student object
     */
    @Override
    public String toString() {
        return String.format("%-10s : %s\n", "Student ID", studentID);
    }

    public List<Book> searchBookByTitle(String title) throws Exception {
        ArrayList<Book> books = new ArrayList<>();

        String query = "SELECT * FROM BOOK WHERE UPPER(Title) = " + "'"
                + title.toUpperCase() + "';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String sn = rs.getString("SN");

            //getting BookData
            String author = rs.getString("Author");
            String publisher = rs.getString("Publisher");
            double price = rs.getDouble("Price");
            int quantity = rs.getInt("Quantity");
            int issuedQuantity = rs.getInt("IssuedQuantity");
            LocalDate date = LocalDate.parse(rs.getString("AddedDate"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //creating BookData object
            BookData data = new BookData(title, author, publisher, quantity,
                    price, issuedQuantity, date);

            //creating Book object
            Book book = new Book(sn, data);

            //populating list
            books.add(book);
        }

        st.close();     // close the statement
        return books;

    }

    /**
     * Search the book by its author's name
     *
     * @param authorName the name of the author
     * @return a list of book written by the author
     */
    public List<Book> searchBookByAuthorName(String authorName) throws Exception { //WORKS YAAAAAAY
        ArrayList<Book> books = new ArrayList<>();

        String query = "SELECT * FROM BOOK WHERE UPPER(Author) = " + "'"
                + authorName.toUpperCase() + "';";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String sn = rs.getString("SN");

            //getting BookData
            String title = rs.getString("Title");
            String publisher = rs.getString("Publisher");
            double price = rs.getDouble("Price");
            int quantity = rs.getInt("Quantity");
            int issuedQuantity = rs.getInt("IssuedQuantity");
            LocalDate date = LocalDate.parse(rs.getString("AddedDate"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //creating BookData object
            BookData data = new BookData(title, authorName, publisher,
                    quantity, price, issuedQuantity, date);

            //creating Book object
            Book book = new Book(sn, data);

            //populating list
            books.add(book);
        }
        st.close();  // close the statement
        return books;
    }

    /**
     * Search the book by its publisher
     *
     * @param publisher the publisher of the book
     * @return a list of book
     */
    public List<Book> searchBookByPublisher(String publisher) throws Exception { //WORKS YAAAAAAY
        ArrayList<Book> books = new ArrayList<>(); // a container for searched books

        String query = "SELECT * FROM BOOK WHERE UPPER(Publisher) = " + "'"
                + publisher.toUpperCase() + "';";  // create query

        Statement st = connection.createStatement();     // create statement
        ResultSet rs = st.executeQuery(query);           // execute query

        while (rs.next()) {
            String sn = rs.getString("SN");

            //getting BookData 
            String title = rs.getString("Title");
            String author = rs.getString("Author");
            double price = rs.getDouble("Price");
            int quantity = rs.getInt("Quantity");
            int issuedQuantity = rs.getInt("IssuedQuantity");
            LocalDate date = LocalDate.parse(rs.getString("AddedDate"),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            //creating BookData object
            BookData data = new BookData(title, author, publisher,
                    quantity, price, issuedQuantity, date);

            //creating Book object
            Book book = new Book(sn, data);

            // populating list
            books.add(book);
        }
        st.close(); // close the statement
        return books;
    }

    /**
     *
     * This method returns a map containing all data retrieved from the Books
     * table. The key in the map is “SN”. All books should be sorted by “SN”.
     * Use the appropriate formatting for the date and currency.
     *
     * @return
     */
    public Map<String, String> viewCatalog() throws Exception { //WORKS YAYYYYYYYYY
        return IViewable.viewCatalog();
    }

    /**
     * 
     * @param book
     * @return
     * @throws Exception 
     */
    public Boolean borrow(Book book) throws Exception {
        // Step 1:  check book if library has it
        String query = "SELECT * FROM BOOK WHERE SN =" + "'" + book.getBookSN() + "';";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        int quantity = 0;
        while (rs.next()) {
            quantity = rs.getInt("Quantity");   // check how many are available
        }

        if (quantity > 0) {
            //Step 2:  Update Book Table quantity of book and issued quantity of book
            query = "UPDATE BOOK SET Quantity = Quantity - 1, IssuedQuantity = IssuedQuantiy + 1 WHERE SN ="
                    + "'" + book.getBookSN() + "';";
            statement = connection.createStatement();
            statement.executeUpdate(query);

            // Add a row to the IssuedBook table 
            query = "INSERT * into ISSUEDBOOK(IssuedBookID, BookSN, "
                    + "StudentID, StudentContact, IssuedDate) "
                    + "VALUES(" + nextIssuedBookID++ + "," + "'" + book.getBookSN() //bookSN(foreign key -> already updated when step 2 is done)
                    + "'," + "'" + studentID + "'," + "'"
                    + data.getContactNum() + ",'" + "'"
                    + LocalDate.now().toString() + "')";
            System.out.println(query); // test

            statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            System.out.println("Book borrowed successfully");
            return true;
        }
        return false;
    }

    /**
     * 
     * @param book
     * @return
     * @throws Exception 
     */
    public Boolean toReturn(Book book) throws Exception {
        // Step 1: Check first the book from IssuedBook table
        String query = "SELECT IssuedBookID, BookSN, StudentID "
                + "FROM ISSUEDBOOK WHERE BookSN='" + book.getBookSN()
                + "' AND 'StudentID= '" + studentID + "';";

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
        if (bookSN.equals(book.getBookSN()) && stuID.equals(studentID)) {

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
    
    
    
    

    // getters and setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        if (Pattern.matches(ID_REGEX, studentID)) {
            this.studentID = studentID;
        }
    }

    public StudentData getStudentData() {
        return new StudentData(this.data);
    }

    public void setStudentData(StudentData data) {
        this.data = new StudentData(data);
    }
}
