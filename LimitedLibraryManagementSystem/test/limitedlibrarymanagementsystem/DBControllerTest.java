/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package limitedlibrarymanagementsystem;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author AORUS
 */
public class DBControllerTest {
    
    public DBControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addBook method, of class DBController.
     */
    @Test
    public void testAddBook() throws Exception {
        System.out.println("addBook");
        Book book = null;
        DBController instance = null;
        instance.addBook(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        DBController instance = null;
        Map<String, String> expResult = null;
        Map<String, String> result = instance.viewCatalog();
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
