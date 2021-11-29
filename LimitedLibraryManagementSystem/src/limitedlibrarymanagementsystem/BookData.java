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

import java.time.LocalDate;
import java.util.Objects;

/**
 * Programming Patterns - Fall 2021 - Final Project.
 * @author Chilka Castro and Giuliana Bouzon
 */
public class BookData {                                                 

    //properties      
    private String title;
    private String author;
    private String publisher;
    private int bookQuantity;
    private double price;
    private int issuedQuantity;
    private LocalDate addedDate;
    
    //the default we chose: no date can be before this
    private static final LocalDate DEFAULT_DATE = LocalDate.of(2010, 1, 1);
    
    //default constructor
    public BookData() { //just for testing, not actually going to be called within the application
    	this("noTitle", "noAuthor", "noPublisher", 0, 0.0, 0, LocalDate.of(2010, 1, 1)); //default value set to jan 1st 2010
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
    public BookData(String title, String author, String publisher,
            int bookQuantity, double price, int issuedQuantity, LocalDate purchaseDate) {
	
        this.title = (title != null && !title.isEmpty()) ? title : "noTitle";
        this.author = (author != null && !author.isEmpty()) ? author : "noAuthor";
        this.publisher = (publisher != null && !publisher.isEmpty()) ? publisher : "noPublisher";
        this.price = (price > 0) ? price : 0;
        this.bookQuantity = (bookQuantity > 0) ? bookQuantity : 0;
        this.issuedQuantity = (issuedQuantity > 0) ? issuedQuantity : 0;
        this.addedDate = (purchaseDate.isAfter(DEFAULT_DATE)) ? purchaseDate : DEFAULT_DATE;
    }
    
    //copy constructor
    public BookData(BookData book) {
	this(book.title, book.author, book.publisher,  
                book.bookQuantity, book.price, book.issuedQuantity, book.addedDate);
    }
    
    @Override
    public int hashCode() {
	return Objects.hash(author, bookQuantity,issuedQuantity, price, publisher, addedDate, title);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	BookData other = (BookData) obj;
	return Objects.equals(author, other.author) && bookQuantity == other.bookQuantity
		&& issuedQuantity == other.issuedQuantity
		&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
		&& Objects.equals(publisher, other.publisher) && Objects.equals(addedDate, other.addedDate)
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

        str += String.format("%-20s : %s\n", "Title", title);
        str += String.format("%-20s : %s\n", "Author", author);
        str += String.format("%-20s : %s\n", "Publisher", publisher);
        str += String.format("%-20s : $%.2f\n", "Price", price);
        str += String.format("%-20s : %d\n", "Quantity", bookQuantity);
        str += String.format("%-20s : %d\n", "Issued Quantity", issuedQuantity);
        str += String.format("%-20s : %s\n", "Date of Purchase", addedDate.toString());

        return str;
    }

    // getters and setters

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
        return addedDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
	if (this.addedDate.isAfter(DEFAULT_DATE))
	    this.addedDate = purchaseDate;
    }
}