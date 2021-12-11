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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chilka Castro
 */
public class DBControllerTest {
       private final Connection connection;

    public DBControllerTest() throws Exception {
        this.connection = DBConnection.getSingleInstance();
    }
    


    /**
     * Test of addBook method, of class DBController.
     */
    @Test
    public void testAddBook() throws Exception {
        Book book = new Book("123456789", new BookData("A Test Book", "Test Author", "Penguin", 8, 18.29, 0, LocalDate.now())); 
        DBController controller = new DBController(new View());
        controller.addBook(book);
        
        String query = "SELECT * FROM BOOK WHERE SN =" + "'" + book.getBookSN() + "';";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        String sn = "";
        
        while (rs.next()) 
            sn = rs.getString("SN");
    
    }

    /**
     * Test of issueBook method, of class DBController.
     */
    @Test
    public void testIssueBook() throws Exception {
        System.out.println("issueBook");
        Book book = null;
        Student student = null;
        DBController instance = null;
        boolean expResult = false;
        boolean result = instance.issueBook(book, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnBook method, of class DBController.
     */
    @Test
    public void testReturnBook() throws Exception {
        System.out.println("returnBook");
        Book book = null;
        Student student = null;
        DBController instance = null;
        boolean expResult = false;
        boolean result = instance.returnBook(book, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewCatalog method, of class DBController.
     */
    @Test
    public void testViewCatalog() throws Exception {
        System.out.println("viewCatalog");
        Map<String, String> expResult = null;
        Map<String, String> result = DBController.viewCatalog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewIssuedBooks method, of class DBController.
     */
    @Test
    public void testViewIssuedBooks() throws Exception {
        System.out.println("viewIssuedBooks");
        Map<String, String> expResult = null;
        Map<String, String> result = DBController.viewIssuedBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateViewIssuedTable method, of class DBController.
     */
    @Test
    public void testUpdateViewIssuedTable() throws Exception {
        System.out.println("updateViewIssuedTable");
        DBController instance = null;
        String expResult = "";
        String result = instance.updateViewIssuedTable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateViewCatalog method, of class DBController.
     */
    @Test
    public void testUpdateViewCatalog() throws Exception {
        System.out.println("updateViewCatalog");
        DBController instance = null;
        String expResult = "";
        String result = instance.updateViewCatalog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateViewCatalogFrench method, of class DBController.
     */
    @Test
    public void testUpdateViewCatalogFrench() throws Exception {
        System.out.println("updateViewCatalogFrench");
        DBController instance = null;
        String expResult = "";
        String result = instance.updateViewCatalogFrench();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByTitle method, of class DBController.
     */
    @Test
    public void testSearchBookByTitle() throws Exception {
        System.out.println("searchBookByTitle");
        String title = "";
        DBController instance = null;
        List<Book> expResult = null;
        List<Book> result = instance.searchBookByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByAuthorName method, of class DBController.
     */
    @Test
    public void testSearchBookByAuthorName() throws Exception {
        System.out.println("searchBookByAuthorName");
        String authorName = "";
        DBController instance = null;
        List<Book> expResult = null;
        List<Book> result = instance.searchBookByAuthorName(authorName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByPublisher method, of class DBController.
     */
    @Test
    public void testSearchBookByPublisher() throws Exception {
        System.out.println("searchBookByPublisher");
        String publisher = "";
        DBController instance = null;
        List<Book> expResult = null;
        List<Book> result = instance.searchBookByPublisher(publisher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrow method, of class DBController.
     */
    @Test
    public void testBorrow() throws Exception {
        System.out.println("borrow");
        Book book = null;
        DBController instance = null;
        Boolean expResult = null;
        Boolean result = instance.borrow(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toReturn method, of class DBController.
     */
    @Test
    public void testToReturn() throws Exception {
        System.out.println("toReturn");
        Book book = null;
        DBController instance = null;
        Boolean expResult = null;
        Boolean result = instance.toReturn(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateViewBookList method, of class DBController.
     */
    @Test
    public void testUpdateViewBookList() throws Exception {
        System.out.println("updateViewBookList");
        List<Book> books = null;
        DBController instance = null;
        String expResult = "";
        String result = instance.updateViewBookList(books);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
