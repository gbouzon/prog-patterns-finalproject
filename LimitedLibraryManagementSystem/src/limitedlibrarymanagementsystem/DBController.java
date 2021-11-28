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

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Chilka Castro
 */

public class DBController {
    private ArrayList<Book> booksModel;
    private Student studentModel;      
    private View view;
    private DBConnection connection;    

    public DBController(ArrayList<Book> booksModel, Student studentModel, View view, DBConnection connection) {
        this.booksModel = booksModel;
        this.studentModel = studentModel;
        this.view = view;
        this.connection = connection;
    }
    
    // methods from Book class (Librarian access)
    public void librarianAddBook(Book book) {
        
    }
    
    public Boolean librarianIssueBook(Book book, Student student) {
        return false; // call book method
    }
    
    public Boolean librarianReturnBook(Book book, Student student) {
        return false;
    }
    
    //shared access by librarian and student
    public Map<String, String> viewCatalog() {
        return Book.viewCatalog();
    }
    
    // librarian access only
    public static Map<String, String> viewIssuedBooks() {
        return Book.viewIssuedBooks(); // static method
    }
    
    // student 
    
    public <List>Book searchBookByTitle(String title) {
        return null;
    }
    
    public <List>Book searchBookByPublisher(String name) {
        return null;
    }
    
    public Boolean borrow(Book book) {
        return false;
    }
    
    public Boolean toReturn(Book book) {
        return false;
    }
    
    // there could be many view methods
    public void updateViewIssuedTable(Map map) {
       view.printIssuedBookTable(viewIssuedBooks());    //viewIssuedBooks() -> is a returned map
    }
    
    public void updateViewCatalog(Map map) {
        view.printBookCatalog(viewCatalog());           // viewCatalog() -> is a returned map    
    }
}
