/** MIT License Copyright (c) 2021 Giuliana Bouzon

* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:

* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
*
* @author Giuliana Bouzon
*/
public class StudentController implements IViewable {
    
    //properties
    private ArrayList<Book> model;              
    private View view;
    private Student student;  // added this
    private Connection connection;    
    private static int nextIssuedBookID = 1;

//    /**
//     * Constructor with all data members
//     * @param books the collection of books
//     * @param view the view for the student controller
//     * @throws java.lang.Exception 
//     */
//    public StudentController(ArrayList<Book> books, View view) throws Exception {
//        this.model = new ArrayList<>(books);
//        this.view = view;
//        this.connection = DBConnection.getSingleInstance();
//    }
    /**
     * Constructor with all data members
     * @param books the collection of books
     * @param view the view for the student controller
     * @throws java.lang.Exception 
     */
    public StudentController(ArrayList<Book> books, Student student, View view)   // CHILKA : added the student here which will be used in the borrow and toReturn method
            throws Exception {
        this.model = new ArrayList<>(books);
        this.view = view;
        this.student = student;
        this.connection = DBConnection.getSingleInstance();
    }
    
    //idea:
    //if arraylist of books is comprised of all the books in the database
    //search methods could just search arraylist instead of searching db
    //all we gotta do is add a method to go through db and add all the books
    //to book arraylist
    //initialize it to that method in the constructor
    
    //NOTE FOR SEARCH METHODS:
    //THINK OF TOKENIZING THE SEARCH KEY to avoid errors with whitespace
    
    //ANOTHER NOTE: SORT RESULTS FOR ^^^
    
    /**
     * Search the book by its title
     * @param title the title of the book
     * @return a list of book
     */
    public List<Book> searchBookByTitle(String title) throws Exception { //WORKS YAAAAAAAAAAY
	ArrayList<Book> books = new ArrayList<>();
	
	String query = "SELECT * FROM BOOK WHERE UPPER(Title) = " + "'" + title.toUpperCase() + "';";
	
	Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	while(rs.next()) {
	    String sn = rs.getString("SN");
	    
	    //getting BookData
	    String author = rs.getString("Author");
	    String publisher = rs.getString("Publisher");
	    double price = rs.getDouble("Price");
	    int quantity = rs.getInt("Quantity");
	    int issuedQuantity = rs.getInt("IssuedQuantity");
	    LocalDate date = LocalDate.parse(rs.getString("AddedDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   
	    //creating BookData object
	    BookData data = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);
	    
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
     * @param authorName the name of the author 
     * @return a list of book written by the author
     */
    public List<Book> searchBookByAuthorName(String authorName) throws Exception { //WORKS YAAAAAAY
	ArrayList<Book> books = new ArrayList<>();
	
	String query = "SELECT * FROM BOOK WHERE UPPER(Author) = " + "'" + authorName.toUpperCase() + "';";
	
	Statement st = connection.createStatement();
	ResultSet rs = st.executeQuery(query);
	
	while(rs.next()) {
	    String sn = rs.getString("SN");
	    
	    //getting BookData
	    String title = rs.getString("Title");
	    String publisher = rs.getString("Publisher");
	    double price = rs.getDouble("Price");
	    int quantity = rs.getInt("Quantity");
	    int issuedQuantity = rs.getInt("IssuedQuantity");
	    LocalDate date = LocalDate.parse(rs.getString("AddedDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   
	    //creating BookData object
	    BookData data = new BookData(title, authorName, publisher, quantity, price, issuedQuantity, date);
	    
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
     * @param publisher the publisher of the book
     * @return a list of book
     */
    public List<Book> searchBookByPublisher(String publisher) throws Exception { //WORKS YAAAAAAY
	ArrayList<Book> books = new ArrayList<>(); // a container for searched books
	
	String query = "SELECT * FROM BOOK WHERE UPPER(Publisher) = " + "'" + publisher.toUpperCase() + "';";  // create query
	
	Statement st = connection.createStatement();     // create statement
	ResultSet rs = st.executeQuery(query);           // execute query
	
	while(rs.next()) {
	    String sn = rs.getString("SN");
	    
	    //getting BookData 
	    String title = rs.getString("Title");
	    String author = rs.getString("Author");
	    double price = rs.getDouble("Price");
	    int quantity = rs.getInt("Quantity");
	    int issuedQuantity = rs.getInt("IssuedQuantity");
	    LocalDate date = LocalDate.parse(rs.getString("AddedDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   
	    //creating BookData object
	    BookData data = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);
	    
	    //creating Book object
	    Book book = new Book(sn, data);
	    
	    // populating list
	    books.add(book);
	}
        st.close(); // close the statement
	return books;
    }
   
    /**
     * This method returns a map containing all data retrieved from the Books table. 
     * The key in the map is “SN”. All books should be sorted by “SN”.
     * Use the appropriate formatting for the date and currency.
     * @return a map of book
     */
    public Map<String, BookData> viewCatalog() throws Exception { //WORKS YAAAAAAY
        return IViewable.viewCatalog();
    }
    
    /**HAVENT TESTED
     * 
     * issueBook(b:Book, s:Student) and borrow(b:Book): To issue a book to a 
     * student, student information should be verified first.
     * 
     * If the book is available, the number of copies(“Quantity”) will be decreased by one 
     * and the number of Copies issued (“Issued”) will be increased by one. 
     * A new entry in “IssuedBooks” table is added. The two methods return
     * true if the book was successfully issued.
     * @param book
     * @return 
     */
    public Boolean borrow(Book book) throws Exception {   
        DBController librarianController = new DBController();
        
        // if true when calling the issueBook() method of DBController
        if (librarianController.issueBook(book, student)) {
            String query = "INSERT * into ISSUEDBOOK(issuedBookID, BookSN, "
                    + "StudentID, StudentContact, IssuedDate) "
                    + "VALUES(" + nextIssuedBookID++ + "," + "'" + book.getBookSN() 
                    + "'," + "'" + student.getStudentID() + "'," + "'" + 
                    student.getStudentData().getContactNum() + ",'" + "'"
                    + LocalDate.now().toString() + "')";
            System.out.println(query); // test
               
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();     
            System.out.println("Book borrowed successfully");
            return true;
        }
        return false;      // if false when calling the issueBook() method of Student controller
    }

    /**
     *
     * returnBook(b:Book, s:Student) and toReturn(b:Book): To return a book,      
     * check first if an entry in the issuedBooks table about the book and the 
     * student exists that will verify the studentID. The number of copies 
     * “Quantity” will be increased by one and the number of copies issued 
     * will be decreased by one. The corresponding record in IssuedBooks 
     * table is deleted from the table. The two methods return true if the
     * book was successfully returned.
     * @param book
     * @return 
     */
    public Boolean toReturn(Book book) {
        return false;
    }
//    
//    // there could be many view methods -> think later
//    public void updateViewCatalog(Map<String, BookData> map) throws Exception {
//        view.printBookCatalog(viewCatalog());           // viewCatalog() -> is a returned map    
//    }
    
    /**
     *
     * @throws Exception
     */
    @Override
    public void updateViewCatalog() throws Exception { // IViewable interface
        view.printBookCatalog(viewCatalog());  // viewCatalog() returns a map
    }
    
    public void updateViewBookList(List<Book> books) throws Exception {
	view.printBookList(books); //prints book lists in a pretty and organized format ;)
    }
  
}