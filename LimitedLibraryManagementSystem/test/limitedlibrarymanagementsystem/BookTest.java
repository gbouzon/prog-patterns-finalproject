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
public class BookTest {
    
    public BookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hashCode method, of class Book.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Book instance = new Book();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Book.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Book instance = new Book();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Book.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Book instance = new Book();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBook method, of class Book.
     */
    @Test
    public void testAddBook() throws Exception {
        System.out.println("addBook");
        Book book = null;
        Book instance = new Book();
        instance.addBook(book);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of issueBook method, of class Book.
     */
    @Test
    public void testIssueBook() throws Exception {
        System.out.println("issueBook");
        Book book = null;
        Student student = null;
        Book instance = new Book();
        Boolean expResult = null;
        Boolean result = instance.issueBook(book, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnBook method, of class Book.
     */
    @Test
    public void testReturnBook() throws Exception {
        System.out.println("returnBook");
        Book book = null;
        Student student = null;
        Book instance = new Book();
        Boolean expResult = null;
        Boolean result = instance.returnBook(book, student);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewCatalog method, of class Book.
     */
    @Test
    public void testViewCatalog() throws Exception {
        System.out.println("viewCatalog");
        Map<String, String> expResult = null;
        Map<String, String> result = Book.viewCatalog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewIssuedBooks method, of class Book.
     */
    @Test
    public void testViewIssuedBooks() throws Exception {
        System.out.println("viewIssuedBooks");
        Book instance = new Book();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.viewIssuedBooks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewIssuedBooksFrench method, of class Book.
     */
    @Test
    public void testViewIssuedBooksFrench() throws Exception {
        System.out.println("viewIssuedBooksFrench");
        Book instance = new Book();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.viewIssuedBooksFrench();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookSN method, of class Book.
     */
    @Test
    public void testGetBookSN() {
        System.out.println("getBookSN");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getBookSN();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookSN method, of class Book.
     */
    @Test
    public void testSetBookSN() throws Exception {
        System.out.println("setBookSN");
        String bookSN = "";
        Book instance = new Book();
        instance.setBookSN(bookSN);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookData method, of class Book.
     */
    @Test
    public void testGetBookData() throws Exception {
        System.out.println("getBookData");
        Book instance = new Book();
        BookData expResult = null;
        BookData result = instance.getBookData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookData method, of class Book.
     */
    @Test
    public void testSetBookData() throws Exception {
        System.out.println("setBookData");
        BookData data = null;
        Book instance = new Book();
        instance.setBookData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
