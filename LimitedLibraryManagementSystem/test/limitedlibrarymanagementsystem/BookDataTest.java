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

import java.time.LocalDate;
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
public class BookDataTest {
    
    public BookDataTest() {
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
     * Test of hashCode method, of class BookData.
     */
    @Test
    public void testHashCode() throws Exception {
        System.out.println("hashCode");
        BookData instance = new BookData();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class BookData.
     */
    @Test
    public void testEquals() throws Exception {
        System.out.println("equals");
        Object obj = null;
        BookData instance = new BookData();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class BookData.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        BookData instance = new BookData();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringFrench method, of class BookData.
     */
    @Test
    public void testToStringFrench() throws Exception {
        System.out.println("toStringFrench");
        BookData instance = new BookData();
        String expResult = "";
        String result = instance.toStringFrench();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toStringEnglish method, of class BookData.
     */
    @Test
    public void testToStringEnglish() throws Exception {
        System.out.println("toStringEnglish");
        BookData instance = new BookData();
        String expResult = "";
        String result = instance.toStringEnglish();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class BookData.
     */
    @Test
    public void testGetTitle() throws Exception {
        System.out.println("getTitle");
        BookData instance = new BookData();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class BookData.
     */
    @Test
    public void testSetTitle() throws Exception {
        System.out.println("setTitle");
        String title = "";
        BookData instance = new BookData();
        instance.setTitle(title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAuthor method, of class BookData.
     */
    @Test
    public void testGetAuthor() throws Exception {
        System.out.println("getAuthor");
        BookData instance = new BookData();
        String expResult = "";
        String result = instance.getAuthor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAuthor method, of class BookData.
     */
    @Test
    public void testSetAuthor() throws Exception {
        System.out.println("setAuthor");
        String author = "";
        BookData instance = new BookData();
        instance.setAuthor(author);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPublisher method, of class BookData.
     */
    @Test
    public void testGetPublisher() throws Exception {
        System.out.println("getPublisher");
        BookData instance = new BookData();
        String expResult = "";
        String result = instance.getPublisher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPublisher method, of class BookData.
     */
    @Test
    public void testSetPublisher() throws Exception {
        System.out.println("setPublisher");
        String publisher = "";
        BookData instance = new BookData();
        instance.setPublisher(publisher);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class BookData.
     */
    @Test
    public void testGetPrice() throws Exception {
        System.out.println("getPrice");
        BookData instance = new BookData();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class BookData.
     */
    @Test
    public void testSetPrice() throws Exception {
        System.out.println("setPrice");
        double price = 0.0;
        BookData instance = new BookData();
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookQuantity method, of class BookData.
     */
    @Test
    public void testGetBookQuantity() throws Exception {
        System.out.println("getBookQuantity");
        BookData instance = new BookData();
        int expResult = 0;
        int result = instance.getBookQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBookQuantity method, of class BookData.
     */
    @Test
    public void testSetBookQuantity() throws Exception {
        System.out.println("setBookQuantity");
        int bookQuantity = 0;
        BookData instance = new BookData();
        instance.setBookQuantity(bookQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIssuedQuantity method, of class BookData.
     */
    @Test
    public void testGetIssuedQuantity() throws Exception {
        System.out.println("getIssuedQuantity");
        BookData instance = new BookData();
        int expResult = 0;
        int result = instance.getIssuedQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIssuedQuantity method, of class BookData.
     */
    @Test
    public void testSetIssuedQuantity() throws Exception {
        System.out.println("setIssuedQuantity");
        int issuedQuantity = 0;
        BookData instance = new BookData();
        instance.setIssuedQuantity(issuedQuantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPurchaseDate method, of class BookData.
     */
    @Test
    public void testGetPurchaseDate() throws Exception {
        System.out.println("getPurchaseDate");
        BookData instance = new BookData();
        LocalDate expResult = null;
        LocalDate result = instance.getPurchaseDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPurchaseDate method, of class BookData.
     */
    @Test
    public void testSetPurchaseDate() throws Exception {
        System.out.println("setPurchaseDate");
        LocalDate purchaseDate = null;
        BookData instance = new BookData();
        instance.setPurchaseDate(purchaseDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
