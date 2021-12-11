/** MIT License Copyright (c) 2021 Giuliana Bouzon, Chilka Castro

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
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Contains Data for Book objects
 * Design Pattern -> Strategy (composition)
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Giuliana Bouzon, Chilka Castro
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
    
    /**
     * Default constructor
     * @throws Exception exception thrown
     */
    public BookData() throws Exception {                                         //just for testing, not actually going to be called within the application
    	this("noTitle", "noAuthor", "noPublisher", 0, 0.0, 0, LocalDate.of(2021, 1, 1)); //default value set to jan 1st 2010
    }

    /**
     * Constructor with all data members
     * @param title the title of the book
     * @param author the author of the book
     * @param publisher the publisher of the book
     * @param price the price of the book
     * @param bookQuantity the quantity of the book
     * @param issuedQuantity the issued quantity of the book
     * @param purchaseDate the date of purchase of the book
     * @throws Exception exception thrown
     */
    public BookData(String title, String author, String publisher,
            int bookQuantity, double price, int issuedQuantity, 
            LocalDate purchaseDate) throws Exception {
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setBookQuantity(bookQuantity);
        setPrice(price);
        setIssuedQuantity(issuedQuantity);
        setPurchaseDate(purchaseDate);
    }
    
    /**
     * Copy constructor
     * @param book the book object to copy
     * @throws java.lang.Exception exception thrown
     */
    public BookData(BookData book) throws Exception {
	this(book.title, book.author, book.publisher,  
                book.bookQuantity, book.price, book.issuedQuantity, book.addedDate);
    }
    
    /**
     * Generates a hash code based on the equals method
     * @return an integer hash code
     */
    @Override
    public int hashCode() {
	return Objects.hash(author, bookQuantity,issuedQuantity, price, publisher, 
                addedDate, title);
    }

    /**
     * Checks if two objects are the same or not
     * @param obj the other object to check for equality
     * @return True if both objects are equal and False if not
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	BookData other = (BookData) obj;
	return Objects.equals(author, other.author) 
                && bookQuantity == other.bookQuantity
		&& issuedQuantity == other.issuedQuantity
		&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
		&& Objects.equals(publisher, other.publisher) 
                && Objects.equals(addedDate, other.addedDate)
		&& Objects.equals(title, other.title);
    }

    /**
     * Generates a String that represents a book object
     * @return a String that represents a book object
     */
    @Override
    public String toString() {
        String str = "";
        if (MainMenuForm.language.equals("French")) 
            str = toStringFrench();
        if (MainMenuForm.language.equals("English")) 
            str = toStringEnglish();
        return str;
    }
    
    public String toStringFrench() {
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA);
        String str = "";
        res = ResourceBundle.getBundle("source/Source", Locale.CANADA_FRENCH);
        str += String.format("%-10s  %s\n", res.getString("key7"), title);
        str += String.format("%-10s  %s\n", res.getString("key6"), author);
        str += String.format("%-10s  %s\n", res.getString("key18"), publisher);
        str += String.format("%-10s  $%.2f\n", res.getString("key8"), price);
        str += String.format("%-10s  %d\n", res.getString("key3"), bookQuantity);
        str += String.format("%-10s  %d\n", res.getString("key36"), issuedQuantity);
        str += String.format("%-10s  %s\n", res.getString("key37"), addedDate.toString());
        

        return str;
    }

   
    public String toStringEnglish() {
        String str = "";
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA);

        str += String.format("%-10s  %s\n", res.getString("key7"), title);
        str += String.format("%-10s  %s\n", res.getString("key6"), author);
        str += String.format("%-10s  %s\n", res.getString("key18"), publisher);
        str += String.format("%-10s  $%.2f\n", res.getString("key8"), price);
        str += String.format("%-10s  %d\n", res.getString("key3"), bookQuantity);
        str += String.format("%-10s  %d\n", res.getString("key36"), issuedQuantity);
        str += String.format("%-10s  %s\n", res.getString("key37"), addedDate.toString());
        
        return str;
    }
    
    // getters and setters
    /**
     * Getter of the book title
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book
     * @param title the title of the book
     * @throws Exception exception thrown
     */
    public void setTitle(String title) throws Exception {
	if (title != null && !title.isEmpty())
	    this.title = title;
        
        else 
            throw new Exception("Title cannot be empty");
    }

    /**
     * Gets the author of the book
     * @return the name of the author of the book
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the name of the author of the book
     * @param author the name of the author of the book
     * @throws java.lang.Exception exception thrown
     */
    public void setAuthor(String author) throws Exception {
	if (author != null && !author.isEmpty())
	    this.author = author;
        
        else 
            throw new Exception("Author cannot be empty");
    }

    /**
     * Gets the name publisher of the book
     * @return the name of the publisher of the book
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the name of the publisher of the book
     * @param publisher the name book's publisher
     * @throws java.lang.Exception exception thrown
     */
    public void setPublisher(String publisher) throws Exception {
	if (publisher != null && !publisher.isEmpty())
	    this.publisher = publisher;
        
        else 
            throw new Exception("Publisher cannot be empty");
    }

    /**
     * Gets the price of the book
     * @return the price of the book
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the book
     * @param price the price of the book
     * @throws java.lang.Exception exception thrown
     */
    public void setPrice(double price) throws Exception {
	if (price >= 0)
	    this.price = price;
        
        else 
            throw new Exception("Price cannot be negative");
    }

    /**
     * Gets the available quantity of the book
     * @return the available quantity of the book
     */
    public int getBookQuantity() {
        return bookQuantity;
    }

    /**
     * Sets the available quantity of the book
     * @param bookQuantity the available quantity of the book
     * @throws java.lang.Exception exception thrown
     */
    public void setBookQuantity(int bookQuantity) throws Exception {
	if (bookQuantity >= 0)
	    this.bookQuantity = bookQuantity;
        
        else 
            throw new Exception("Quantity cannot be negative");
    }

    /**
     * Gets the issued/borrowed quantity of the book
     * @return the issued/borrowed quantity of the book
     */
    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    /**
     * Sets the issued/borrowed quantity of the book
     * @param issuedQuantity the issued/borrowed quantity of the book
     * @throws java.lang.Exception exception thrown
     */
    public void setIssuedQuantity(int issuedQuantity) throws Exception {
	if (issuedQuantity >= 0)
	    this.issuedQuantity = issuedQuantity;
        
        else 
            throw new Exception("Issued Quantity cannot be negative");
    }

    /**
     * Gets the purchased/added date of the book
     * @return the purchased/added date of the book
     */
    public LocalDate getPurchaseDate() {
        return addedDate;
    }

    /**
     * Sets the purchased/added date of the book
     * @param purchaseDate the purchased/added date of the book
     */
    public void setPurchaseDate(LocalDate purchaseDate) {
	if (purchaseDate.isAfter(DEFAULT_DATE) || purchaseDate.isEqual(DEFAULT_DATE))
	    this.addedDate = purchaseDate;
    }
}