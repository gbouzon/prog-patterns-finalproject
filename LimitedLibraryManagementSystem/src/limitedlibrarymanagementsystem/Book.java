/*
 * The MIT License
 *
 * Copyright 2021 Chilka Castro.
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

import java.util.Date;
import java.util.Map;

/**
 *
 * 
 * @author Chilka Castro and Giuliana Bouzon
 */
public class Book {
    private String bookSN;
    private String title;
    private String author;
    private String publisher;
    private double price;
    private int bookQuantity;
    private int issuedQuantity;
    private Date purchaseDate;

    /**
     * Constructor with all data members
     * @param bookSN the serial number of the book
     * @param title the title of the book
     * @param author the author of the book
     * @param publisher the publisher of the book
     * @param price the price of the book
     * @param bookQuantity the quantity of the book 
     * @param issuedQuantity the issued quantity of the book
     * @param purchaseDate the date of purchase of the book
     */
    public Book(String bookSN, String title, String author, String publisher, 
            double price, int bookQuantity, int issuedQuantity, Date purchaseDate) {
        this.bookSN = bookSN;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.bookQuantity = bookQuantity;
        this.issuedQuantity = issuedQuantity;
        this.purchaseDate = purchaseDate;
    }

    /**
     * Generates a String that represents a book object
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
        str += String.format("%-10s : %s\n", "Date of Purchase", purchaseDate);
 
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
     * @param book
     * @param student
     * @return 
     */
    public boolean issueBook(Book book, Student student) {               // attached to borrow book of Student class
        return false;
    }
    
  
    /**
     * 
     * 	returnBook(b:Book, s:Student) and toReturn(b:Book): To return a book,      
     * check first if an entry in the issuedBooks table about the book and the 
     * student exists that will verify the studentID. The number of copies 
     * “Quantity” will be increased by one and the number of copies issued 
     * will be decreased by one. The corresponding record in IssuedBooks 
     * table is deleted from the table. The two methods return true if the
     * book was successfully returned.
     * @param book
     * @param student
     * @return 
     */
    public boolean returnBook(Book book, Student student) {                     // toReturn() method of Student associated with each other
        return false;
    }
    
    /**
     * 
     * This method returns a map containing all data retrieved from  the Books table.
     * The key in the map is “SN”. All books should be sorted by “SN”. 
     * Use the appropriate formatting for the date and currency.
     * @return 
     */
    public static Map<String, String> viewCatalog() {
       return null;
    }
    
    /**
     * Retrieves all data from IssuedBooks table and returns them as a Map.
     * The map is sorted by “SN”.
     * @return 
     */
    public static  Map<String, String> viewIssuedBooks() {
        return null;
    }
    
    // getters and setters
    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
        this.bookSN = bookSN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(int issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
