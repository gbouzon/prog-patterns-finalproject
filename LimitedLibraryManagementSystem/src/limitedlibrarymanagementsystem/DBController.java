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
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * A DB Controller class - represents librarian access
 * @author Chilka Castro and Giuliana Bouzon
 */
public class DBController implements IViewable{
    //3 options: student obj, book obj OR list of books for student obj OR list of students and
    //list of books -> pick a design
    private Book bookModel; //should be arraylist I think bro
    private Student studentModel;  //same here aaaaaaaaaaaaaaaa idk
    private View view;
    private Connection connection;    

    public DBController() {
    }
    
    /**
     * Constructor with 
     * @param booksModel
     * @param studentModel
     * @param view
     * @param connection 
     */
    public DBController(Book bookModel, Student studentModel, View view) throws Exception {
        this.bookModel = new Book(bookModel);
        this.studentModel = new Student(studentModel);
        this.view = view;
        this.connection = DBConnection.getSingleInstance();
    }
    
    /**
     * Creates a new entry in the books table, adds a new book to the catalog,
     * and sets "Issued" attribute to zero and adddedDate to the current date.
     *
     * @param book
     */
    public void addBook(Book book) throws Exception { //WORKS YAYYYYYYYYYYY
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
                                                                                                                                                                                                                                                                                                                                                                                         
    /** HAVENT TESTED
     * Issues a book to a student(student information would be verified first)
     * If the book is available, the number of copies(“Quantity”) will be decreased by one 
     * and the number of Copies issued (“Issued”) will be increased by one. 
     * A new entry in “IssuedBooks” table is added. The two methods return true if the book was successfully issued.
     * table columns: 
     * @param book
     * @param student
     * @return
     */
    public boolean issueBook(Book book, Student student) throws Exception {  // attached to borrow book of Student class -> not yet implemented
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
        
        // Step 2:  book if library has it
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
            
	    //getting BookData  // value
            title = rs.getString("Title");
	    author = rs.getString("Author");
	    publisher = rs.getString("Publisher");
	    price = rs.getDouble("Price"); 
	    quantity = rs.getInt("Quantity");
	    issuedQuantity = rs.getInt("IssuedQuantity");
	    date = LocalDate.parse(rs.getString("AddedDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   	    
        }
        //creating BookData object
        BookData data = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);

        //creating Book object
	Book bookResult = new Book(sn, data);
       
        // Full Student Checking and Book Checkiing
        if (studentResult.equals(student) && (bookResult.equals(book) && quantity > 0)) {
            // Update available Quantity and the issuedQuantity 
            query = "UPDATE BOOK SET Quantity = Quantity - 1, IssuedQuantiy = IssuedQuantity + 1"
                    + "WHERE SN=" + "'" + book.getBookSN() + "';"; 
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return true;
        }
        else {
            statement.close();
            return false;
        }
        
    }
    
    /**
     *
     * returnBook(b:Book, s:Student) and toReturn(b:Book): To return a book,
     * check first if an entry in the issuedBooks table about the book and the
     * student exists that will verify the studentID. The number of copies
     * “Quantity” will be increased by one and the number of copies issued will
     * be decreased by one. The corresponding record in IssuedBooks table is
     * deleted from the table. The two methods return true if the book was
     * successfully returned.
     *
     * @param book
     * @param student
     * @return
     */
    public boolean returnBook(Book book, Student student) {                     // toReturn() method of Student associated with each other
        return false;
    }

    /**
     *
     * This method returns a map containing all data retrieved from the Books
     * table. The key in the map is “SN”. All books should be sorted by “SN”.
     * Use the appropriate formatting for the date and currency.
     *
     * @return
     */
    public Map<String, BookData> viewCatalog() throws Exception { //WORKS YAYYYYYYYYY
        return IViewable.viewCatalog();
    }
    

    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     *
     * @return
     */
    public static Map<String, String> viewIssuedBooks() throws Exception { //not finished at allllllll - problem with table design smh ask teacher
	Map<String, String> map = new HashMap<>();
	//SN is key
	//value is str comprised of: studentid, contact and issuedate
	
	Connection connection = DBConnection.getSingleInstance();
	
	String query = "SELECT * FROM ISSUEDBOOK";
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery(query);
	
	while(rs.next()) {
	    //getting the key -> book sn
	    String key = rs.getString("SN");
	    
	    
	   
	    //debugging - will be deleted later
	    System.out.println(key);
	    //System.out.println(value);
	    
	    //inserting into map
	    //map.put(key, value);
	}
	return map;
    }
    
    // there could be many view methods -> think later
    public void updateViewIssuedTable() throws Exception {
       view.printIssuedBookTable(viewIssuedBooks());    //viewIssuedBooks() -> is a returned map
    }
    
    /**
     *
     * @throws Exception
     */
    @Override
    public void updateViewCatalog() throws Exception {  // IViewable interface
       view.printBookCatalog(viewCatalog());  // viewCatalog() returns a map
    }
    
//    public void updateViewCatalog(Map map) throws Exception {
//        view.printBookCatalog(viewCatalog());           // viewCatalog() -> is a returned map    
//    }

}




/**
 * 
 * 
 * when returning a book 
 * StudentController would call inside its toReturn(Book) method 
 * the returnBook(Book,Student) of DBController 
 * 
 * DBController
 * returnBook(Book, Student)
 *      - would check the issuedBooks table to check the book and the student who 
 *      borrowed it using the StudentID.
 *      - do the opposite now by updating the Book table -> quantity of the specific book + 1
 *      while issuedBook is -1. Then DELETE the record of that borrowing from
 *      the ISSUEDBOOKS table.(sql query)  (DELETE COULD BE DONE EITHER ON DBController ot StudentController)
 *      - if the returnBook is successful it will then return true to the toReturn method
 *      of toReturn() of StudentController and if the return is not successful then
 *      return false would be returned toReturn() method of StudentController and
 *      then the toReturn method of the StudentController would return true/false depending 
 *      on what it received from the returnBook() method of the DBController
 * 
 * 
 * 
 */