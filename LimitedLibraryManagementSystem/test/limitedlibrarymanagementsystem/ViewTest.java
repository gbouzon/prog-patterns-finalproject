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
public class ViewTest {
    
    public ViewTest() {
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
     * Test of printIssuedBookTable method, of class View.
     */
    @Test
    public void testPrintIssuedBookTable() {
        System.out.println("printIssuedBookTable");
        Map<String, String> map = null;
        View instance = new View();
        String expResult = "";
        String result = instance.printIssuedBookTable(map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printIssuedBookTableFrench method, of class View.
     */
    @Test
    public void testPrintIssuedBookTableFrench() {
        System.out.println("printIssuedBookTableFrench");
        Map<String, String> map = null;
        View instance = new View();
        String expResult = "";
        String result = instance.printIssuedBookTableFrench(map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBookCatalog method, of class View.
     */
    @Test
    public void testPrintBookCatalog() {
        System.out.println("printBookCatalog");
        Map<String, String> map = null;
        View instance = new View();
        String expResult = "";
        String result = instance.printBookCatalog(map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBookCatalogFrench method, of class View.
     */
    @Test
    public void testPrintBookCatalogFrench() {
        System.out.println("printBookCatalogFrench");
        Map<String, String> map = null;
        View instance = new View();
        String expResult = "";
        String result = instance.printBookCatalogFrench(map);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printBookList method, of class View.
     */
    @Test
    public void testPrintBookList() throws Exception {
        System.out.println("printBookList");
        List<Book> books = null;
        View instance = new View();
        String expResult = "";
        String result = instance.printBookList(books);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
