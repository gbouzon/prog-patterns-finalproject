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

import java.util.Objects;

/**
 * Defines Book objects according to project problem statement.
 * Programming Patterns - Fall 2021 - Final Project.
 * @author Chilka Castro and Giuliana Bouzon
 */
public class Book {                                                 

    //properties
    private String bookSN;
    private BookData data;
    
    //default constructor
    public Book() { //just for testing, not actually going to be called within the application
    	this("noSN", new BookData()); //default value set to jan 1st 2010
    }

    /**
     * Constructor with all data members
     *
     * @param bookSN the serial number of the book (primary key)
     */
    public Book(String bookSN, BookData data) {
        this.bookSN = (bookSN != null && !bookSN.isEmpty()) ? bookSN : "noSN";
        this.data = new BookData(data);
    }
    
    //copy constructor
    public Book(Book book) {
	this(book.bookSN, book.data);
    }
    

    @Override
    public int hashCode() {
	return Objects.hash(bookSN, data.hashCode());
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
	return Objects.equals(data, other.data) && Objects.equals(bookSN, other.bookSN);
    }

    /**
     * Generates a String that represents a book object
     *
     * @return a String that represents a book object
     */
    @Override
    public String toString() {
	return String.format("%-20s : %s\n", "SN", bookSN);
    }

    // getters and setters
    
    public String getBookSN() {
        return bookSN;
    }

    public void setBookSN(String bookSN) {
	if (bookSN != null && !bookSN.isEmpty())
	    this.bookSN = bookSN;
    }

    public BookData getBookData() {
	return new BookData(this.data);
    }
    
    public void setBookData(BookData data) {
	this.data = new BookData(data);
    }
}