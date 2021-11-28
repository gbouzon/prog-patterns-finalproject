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

import com.sun.jdi.connect.spi.Connection;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

/**
 * Defines Book objects according to project problem statement.
 * Programming Patterns - Fall 2021 - Final Project.
 * @author Chilka Castro and Giuliana Bouzon
 */
public class Book {                                                 

    //properties
    private String bookSN;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int bookQuantity;
    private int issuedQuantity;
    private LocalDate purchaseDate;
    
    //the default we chose: no date can be before this
    private static final LocalDate DEFAULT_DATE = LocalDate.of(2010, 1, 1);
    
    //default constructor
    public Book() { //just for testing, not actually going to be called within the application
    	this("noSN", "noTitle", "noAuthor", "noPublisher", 0.0, 0, 0, LocalDate.of(2010, 1, 1)); //default value set to jan 1st 2010
    }

    /**
     * Constructor with all data members
     *
     * @param bookSN the serial number of the book (primary key)
     * @param title the title of the book
     * @param author the author of the book
     * @param publisher the publisher of the book
     * @param price the price of the book
     * @param bookQuantity the quantity of the book
     * @param issuedQuantity the issued quantity of the book
     * @param purchaseDate the date of purchase of the book
     */
    public Book(String bookSN, String title, String author, String publisher,
            double price, int bookQuantity, int issuedQuantity, LocalDate purchaseDate) {
        this.bookSN = (bookSN != null && !bookSN.isEmpty()) ? bookSN : "noSN";
        this.title = (title != null && !title.isEmpty()) ? title : "noTitle";
        this.author = (author != null && !author.isEmpty()) ? author : "noAuthor";
        this.publisher = (publisher != null && !publisher.isEmpty()) ? publisher : "noPublisher";
        this.price = (price > 0) ? price : 0;
        this.bookQuantity = (bookQuantity > 0) ? bookQuantity : 0;
        this.issuedQuantity = (issuedQuantity > 0) ? issuedQuantity : 0;
        this.purchaseDate = (purchaseDate.isAfter(DEFAULT_DATE)) ? purchaseDate : DEFAULT_DATE;
        
    }
    
    //copy constructor
    public Book(Book book) {
	this(book.bookSN, book.title, book.author, book.publisher, book.price, book.bookQuantity, 
		book.issuedQuantity, book.purchaseDate);
    }
    

    @Override
    public int hashCode() {
	return Objects.hash(author, bookQuantity, bookSN, issuedQuantity, price, publisher, purchaseDate, title);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Book other = (Book) obj;
	return Objects.equals(author, other.author) && bookQuantity == other.bookQuantity
		&& Objects.equals(bookSN, other.bookSN) && issuedQuantity == other.issuedQuantity
		&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
		&& Objects.equals(publisher, other.publisher) && Objects.equals(purchaseDate, other.purchaseDate)
		&& Objects.equals(title, other.title);
    }

    /**
     * Generates a String that represents a book object
     *
     * @return a String that represents a book object
     */
    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s : %s\n", "SN", bookSN);
        str += String.format("%-10s : %s\n", "Title", title);
        str += String.format("%-10s : %s\n", "Author", author);
        str += String.format("%-10s : %s\n", "Publisher", publisher);
        str += String.format("%-10s : %.2f\n", "Price", price);
        str += String.format("%-10s : %d\n", "Quantity", bookQuantity);
        str += String.format("%-10s : %d\n", "Issued Quantity", issuedQuantity);
        str += String.format("%-10s : %s\n", "Date of Purchase", purchaseDate.toString());

        return str;
    }

    /**
     * Creates a new entry in the books table, adds a new book to the catalog,
     * and sets "Issued" attribute to zero and adddedDate to the current date.
     *
     * @param book
     */
    public void addBook(Book book) {

    }

    /**
     * Issues a book to a student(student information would be verified first)
     *
     * @param book
     * @param student
     * @return
     */
    public boolean issueBook(Book book, Student student) {               // attached to borrow book of Student class
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
    public static Map<String, String> viewCatalog() {
    //   Connection connection = (Connection) DBConnection.getConnectionInstance();  UNCOMMENT THIS
       return null;
    }

    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map. The
     * map is sorted by “SN”.
     *
     * @return
     */
    public static Map<String, String> viewIssuedBooks() {
        return null; // view ISSUEDBOOKS or Library Data
    }

    // getters and setters
    
    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
	if (bookSN != null && !bookSN.isEmpty())
	    this.bookSN = bookSN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
	if (title != null && !title.isEmpty())
	    this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
	if (author != null && !author.isEmpty())
	    this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
	if (publisher != null && !publisher.isEmpty())
	    this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
	if (price > 0)
	    this.price = price;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
	if (bookQuantity > 0)
	    this.bookQuantity = bookQuantity;
    }

    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(int issuedQuantity) {
	if (issuedQuantity > 0)
	    this.issuedQuantity = issuedQuantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
	if (this.purchaseDate.isAfter(DEFAULT_DATE))
	    this.purchaseDate = purchaseDate;
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
