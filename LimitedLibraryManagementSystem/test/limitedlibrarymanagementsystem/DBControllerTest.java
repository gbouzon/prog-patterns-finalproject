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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class to test controller methods (JUnit as required)
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka Castro, Giuliana Bouzon
 */
public class DBControllerTest {
       private final Connection connection;

    /**
     * Constructor of the DBControllerTest 
     * @throws Exception exception thrown
     */
    public DBControllerTest() throws Exception {
        this.connection = DBConnection.getSingleInstance();
    }

    /**
     * Test of addBook method, of class DBController.
     */
    @Test
    public void testAddBook() throws Exception {
        //generating a random SN to avoid primary key errors
        Book book = new Book("3223423432", new BookData("A Test Book", "Test Author", "Penguin", 8, 18.29, 0, LocalDate.now())); 
        DBController controller = new DBController(new View());
        controller.addBook(book);
        
        String query = "SELECT COUNT(*) AS total FROM BOOK";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        int result = rs.getInt("total");
        //error when run this a second time since SN will be duplicated -> delete entry from book table
        assertEquals(result, 33);
    }
    
    /**
     * Test of issueBook method, of class DBController.
     */
    @Test
    public void testIssueBook() throws Exception {
        Book book = new Book("3453535343", new BookData()); 
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        boolean expResult = false;
        boolean result = controller.issueBook(book, student);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnBook method, of class DBController.
     */
    @Test (expected = Exception.class)
    public void testReturnBook() throws Exception {
        Book book = new Book("219831928319", new BookData()); 
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        controller.returnBook(book, student);                                   //throws exception because book has not been borrowed therefore cannot be returned
    }

    /**
     * Test of searchBookByTitle method, of class DBController.
     */
    @Test(expected = Exception.class)
    public void testSearchBookByTitle() throws Exception {
        String title = "hello";
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        controller.searchBookByTitle(title);
    }

    /**
     * Test of searchBookByAuthorName method, of class DBController.
     */
    @Test(expected = Exception.class)
    public void testSearchBookByAuthorName() throws Exception {
        String name = "hello";
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        controller.searchBookByAuthorName(name);
    }

    /**
     * Test of searchBookByPublisher method, of class DBController.
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testSearchBookByPublisher() throws Exception {
        String publisher = "hello";
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        controller.searchBookByPublisher(publisher);
    }

    /**
     * Test of borrow method, of class DBController.
     */
    @Test()
    public void testBorrow() throws Exception {
        Book book = new Book("3453535343", new BookData()); 
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        boolean expResult = false;
        boolean result = controller.borrow(book);
        assertEquals(expResult, result);   
    }

    /**
     * Test of toReturn method, of class DBController.
     */
    @Test
    public void testToReturn() throws Exception {
        Book book = new Book("219831928319", new BookData()); 
        Student student = new Student("1940108", new StudentData());
        DBController controller = new DBController(student, new View());
        controller.borrow(book);
        boolean expResult = true;
        boolean result = controller.toReturn(book);
        assertEquals(expResult, result);
    }  
}