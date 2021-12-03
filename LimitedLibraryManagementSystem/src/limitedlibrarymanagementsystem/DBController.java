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
import java.util.List;
import java.util.Map;

/**
 * A DB Controller class - represents librarian access
 *
 * @author Chilka Castro and Giuliana Bouzon
 */
public class DBController implements IViewable {

    //3 options: student obj, book obj OR list of books for student obj OR list of students and
    //list of books -> pick a design
    private static Book bookLibrarianModel = null; //should be arraylist I think bro
    private Student studentModel;  //same here aaaaaaaaaaaaaaaa idk
    private View view;

    /**
     * Constructor with
     *
     * @param studentModel
     * @param view
     */
    public DBController(Student studentModel, View view) {
        this.studentModel = studentModel;
        this.view = view;
    }

    /**
     * Copy constructor
     *
     * @param dBController
     */
    public DBController(DBController dBController) {
        this(dBController.studentModel, dBController.view);
    }

    // LIBRARIAN METHODS
    /**
     * Creates a new entry in the books table, adds a new book to the catalog,
     * and sets "Issued" attribute to zero and adddedDate to the current date.
     *
     * @param book
     */
    public void addBook(Book book) throws Exception { //WORKS YAYYYYYYYYYYY
        bookLibrarianModel.addBook(book);
    }

    /**
     * HAVENT TESTED Issues a book to a student(student information would be
     * verified first) If the book is available, the number of
     * copies(“Quantity”) will be decreased by one and the number of Copies
     * issued (“Issued”) will be increased by one. A new entry in “IssuedBooks”
     * table is added. The two methods return true if the book was successfully
     * issued. table columns:
     *
     * @param book
     * @param student
     * @return
     */
    public boolean issueBook(Book book, Student student) throws Exception {  // attached to borrow book of Student class -> not yet implemented
        return bookLibrarianModel.issueBook(book, student);
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
    public boolean returnBook(Book book, Student student) throws Exception {                     // toReturn() method of Student associated with each other
        return bookLibrarianModel.returnBook(book, student);
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
        return Book.viewCatalog();  // static method in Book class
    }

    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     *
     * @return
     */
    public static Map<String, String> viewIssuedBooks() throws Exception { //not finished at allllllll - problem with table design smh ask teacher
        return bookLibrarianModel.viewIssuedBooks();
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

    //idea:
    //if arraylist of books is comprised of all the books in the database
    //search methods could just search arraylist instead of searching db
    //all we gotta do is add a method to go through db and add all the books
    //to book arraylist
    //initialize it to that method in the constructor
    //NOTE FOR SEARCH METHODS:
    //THINK OF TOKENIZING THE SEARCH KEY to avoid errors with whitespace
    //ANOTHER NOTE: SORT RESULTS FOR ^^^
    
    
    // STUDENT methods
    /**
     * Search the book by its title
     *
     * @param title the title of the book
     * @return a list of book
     */
    public List<Book> searchBookByTitle(String title) throws Exception { //WORKS YAAAAAAAAAAY
        return searchBookByTitle(title);
    }

    /**
     * Search the book by its author's name
     *
     * @param authorName the name of the author
     * @return a list of book written by the author
     */
    public List<Book> searchBookByAuthorName(String authorName) throws Exception { //WORKS YAAAAAAY
        return searchBookByAuthorName(authorName);
    }

    /**
     * Search the book by its publisher
     *
     * @param publisher the publisher of the book
     * @return a list of book
     */
    public List<Book> searchBookByPublisher(String publisher) throws Exception { //WORKS YAAAAAAY
        return studentModel.searchBookByPublisher(publisher);
    }

    /**
     * 
     * @param book
     * @return
     * @throws Exception 
     */
    public Boolean borrow(Book book) throws Exception {
        return studentModel.borrow(book);
    }
    
    /**
     * 
     * @param book
     * @return
     * @throws Exception 
     */
    public Boolean toReturn(Book book) throws Exception {
        return studentModel.toReturn(book);
    }
    
    

//    @Override
//        public void updateViewCatalog() throws Exception { // IViewable interface
//        view.printBookCatalog(viewCatalog());  // viewCatalog() returns a map
//    }
//    
//    public void updateViewBookList(List<Book> books) throws Exception {
//	view.printBookList(books); //prints book lists in a pretty and organized format ;)
//    }

}
