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
public class DBController {
    //3 options: student obj, book obj OR list of books for student obj OR list of students and
    //list of books -> pick a design
    private Book bookModel; //should be arraylist I think bro
    private Student studentModel;  //same here aaaaaaaaaaaaaaaa idk
    private View view;
    private Connection connection;    

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
                                                                                                                                                                                                                                                                                                                                                                                         
    /**
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
        String query = "SELECT StudentID from Student";
        
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            if (student.getStudentID().equals(rs.getString("StudentID"))) {
                
            }
        }
        return false;
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
    public static Map<String, BookData> viewCatalog() throws Exception { //WORKS YAYYYYYYYYY
	Map<String, BookData> map = new HashMap<>();
	
	Connection connection = DBConnection.getSingleInstance();
	
	String query = "SELECT * FROM BOOK";
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery(query);
	
	while(rs.next()) {
	    //getting the key -> book sn
	    String key = rs.getString("SN");
	    
	    //getting BookData
	    String title = rs.getString("Title");
	    String author = rs.getString("Author");
	    String publisher = rs.getString("Publisher");
	    double price = rs.getDouble("Price");
	    int quantity = rs.getInt("Quantity");
	    int issuedQuantity = rs.getInt("IssuedQuantity");
	    LocalDate date = LocalDate.parse(rs.getString("AddedDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   
	    //creating object
	    BookData value = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);
	   
	    //debugging - will be deleted later
	    //System.out.println(key);
	    //System.out.println(value);
	    
	    //inserting into map
	    map.put(key, value);
	}
	return map;
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
    public void updateViewIssuedTable(Map<String, String> map) throws Exception {
       view.printIssuedBookTable(viewIssuedBooks());    //viewIssuedBooks() -> is a returned map
    }
    
    public void updateViewCatalog(Map<String, BookData> map) throws Exception {
        view.printBookCatalog(viewCatalog());           // viewCatalog() -> is a returned map    
    }
}