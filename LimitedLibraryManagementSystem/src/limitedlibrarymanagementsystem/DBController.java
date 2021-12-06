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

import java.util.List;
import java.util.Map;

/**
 * A DB Controller class
 * MVC Pattern -> Controller for project
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka Castro and Giuliana Bouzon
 */
public class DBController implements IViewable {

    //properties
    private static Book bookLibrarianModel; 
    private Student studentModel;  
    private View view;

    /**
     * Constructor with
     *
     * @param studentModel
     * @param view
     */
    public DBController(Student studentModel, View view) throws Exception {
        this.studentModel = studentModel;
        this.view = view;
        bookLibrarianModel = new Book();
    }
    
    //constructor for librarian use (using book() default since we don't need the values)
    public DBController(View view) throws Exception { 
        bookLibrarianModel = new Book();
        this.view = view;
    }

    /**
     * Copy constructor
     *
     * @param dBController
     */
    public DBController(DBController dBController) throws Exception {
        this(dBController.studentModel, dBController.view);
    }

    // LIBRARIAN METHODS
    
    /**
     * Creates a new entry in the Books table to add a new book to the catalog. 
     * Sets “Issued” attribute to zero and addedDate to the current date. 
     * @param book the book to be added to the library catalog
     * @throws Exception 
     */
    public void addBook(Book book) throws Exception {
        bookLibrarianModel.addBook(book);
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
    public boolean issueBook(Book book, Student student) throws Exception {  // attached to borrow book of Student class
        return bookLibrarianModel.issueBook(book, student);
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
    public boolean returnBook(Book book, Student student) throws Exception {                     // toReturn() method of Student associated with each other
        return bookLibrarianModel.returnBook(book, student);
    }

    /**
     * This method returns a map containing all data retrieved from the Books table.
     * @return a map
     * @throws Exception 
     */
    public Map<String, String> viewCatalog() throws Exception { //WORKS YAYYYYYYYYY
        return Book.viewCatalog();  // static method in Book class
    }

    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     * @return a map
     */
    public static Map<String, String> viewIssuedBooks() throws Exception { //not finished at allllllll - problem with table design smh ask teacher
        return bookLibrarianModel.viewIssuedBooks();
    }

    /**
     * Updates view (aka output) for the IssuedBook table
     * @return a formatted string
     * @throws Exception 
     */
    public String updateViewIssuedTable() throws Exception {
       return view.printIssuedBookTable(viewIssuedBooks());    //viewIssuedBooks() -> is a returned map
    }

    /**
     * Updates view (aka output) for the book table
     * @return a formatted string
     * @throws Exception 
     */
    @Override
    public String updateViewCatalog() throws Exception {  // IViewable interface
        return view.printBookCatalog(viewCatalog());  // viewCatalog() returns a map
    }
    
    // STUDENT methods
    
    /**
     * Search the book by its title
     * @param title the title of the book
     * @return a list of books with the specified title, sorted by book SN
     * @throws Exception
     */
    public List<Book> searchBookByTitle(String title) throws Exception { //WORKS YAAAAAAAAAAY
        return studentModel.searchBookByTitle(title);
    }

    /**
     * Search the book by its author's name
     * @param authorName the name of the author
     * @return a list of books written by the author, sorted by book SN
     * @throws Exception
     */
    public List<Book> searchBookByAuthorName(String authorName) throws Exception { //WORKS YAAAAAAY
        return studentModel.searchBookByAuthorName(authorName);
    }

    /**
     * Search the book by its publisher
     * @param publisher the publisher of the book
     * @return a list of books, sorted by book SN
     * @throws Exception
     */
    public List<Book> searchBookByPublisher(String publisher) throws Exception { //WORKS YAAAAAAY
        return studentModel.searchBookByPublisher(publisher);
    }

    /**
     * If the book is available to be borrowed, the number of copies(“Quantity”) will be decreased by one 
     * and the number of Copies issued (“Issued”) will be increased by one. 
     * A new entry in “IssuedBooks” table is added.
     * @param book the book to be borrowed
     * @return true if the book was successfully issued.
     * @throws Exception 
     */
    public Boolean borrow(Book book) throws Exception {
        return studentModel.borrow(book);
    }
    
    /**
     * If the book information for that student is valid, the number of copies “Quantity” will be increased by one
     * and the number of copies issued will be decreased by one. 
     * The corresponding record in IssuedBooks table is deleted from the table. 
     * @param book the book to be returned
     * @return true if the book was successfully returned
     * @throws Exception 
     */
    public Boolean toReturn(Book book) throws Exception {
        return studentModel.toReturn(book);
    }
    
    /**
     * Updates view (aka output) for methods returning list of books (search methods)
     * @param books the list of books
     * @return a formatted string
     * @throws Exception 
     */
    public String updateViewBookList(List<Book> books) throws Exception {
	return view.printBookList(books); //prints book lists in a pretty and organized format ;)
    }
}