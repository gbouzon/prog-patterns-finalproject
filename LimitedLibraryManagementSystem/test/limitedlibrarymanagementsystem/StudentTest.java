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
public class StudentTest {
    
    public StudentTest() {
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
     * Test of hashCode method, of class Student.
     */
    @Test
    public void testHashCode() throws Exception {
        System.out.println("hashCode");
        Student instance = new Student();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Student.
     */
    @Test
    public void testEquals() throws Exception {
        System.out.println("equals");
        Object obj = null;
        Student instance = new Student();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByTitle method, of class Student.
     */
    @Test
    public void testSearchBookByTitle() throws Exception {
        System.out.println("searchBookByTitle");
        String title = "";
        Student instance = new Student();
        List<Book> expResult = null;
        List<Book> result = instance.searchBookByTitle(title);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByAuthorName method, of class Student.
     */
    @Test
    public void testSearchBookByAuthorName() throws Exception {
        System.out.println("searchBookByAuthorName");
        String authorName = "";
        Student instance = new Student();
        List<Book> expResult = null;
        List<Book> result = instance.searchBookByAuthorName(authorName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchBookByPublisher method, of class Student.
     */
    @Test
    public void testSearchBookByPublisher() throws Exception {
        System.out.println("searchBookByPublisher");
        String publisher = "";
        Student instance = new Student();
        List<Book> expResult = null;
        List<Book> result = instance.searchBookByPublisher(publisher);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewCatalog method, of class Student.
     */
    @Test
    public void testViewCatalog() throws Exception {
        System.out.println("viewCatalog");
        Student instance = new Student();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.viewCatalog();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrow method, of class Student.
     */
    @Test
    public void testBorrow() throws Exception {
        System.out.println("borrow");
        Book book = null;
        Student instance = new Student();
        Boolean expResult = null;
        Boolean result = instance.borrow(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toReturn method, of class Student.
     */
    @Test
    public void testToReturn() throws Exception {
        System.out.println("toReturn");
        Book book = null;
        Student instance = new Student();
        Boolean expResult = null;
        Boolean result = instance.toReturn(book);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() throws Exception {
        System.out.println("toString");
        Student instance = new Student();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentID method, of class Student.
     */
    @Test
    public void testGetStudentID() throws Exception {
        System.out.println("getStudentID");
        Student instance = new Student();
        String expResult = "";
        String result = instance.getStudentID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudentID method, of class Student.
     */
    @Test
    public void testSetStudentID() throws Exception {
        System.out.println("setStudentID");
        String studentID = "";
        Student instance = new Student();
        instance.setStudentID(studentID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStudentData method, of class Student.
     */
    @Test
    public void testGetStudentData() throws Exception {
        System.out.println("getStudentData");
        Student instance = new Student();
        StudentData expResult = null;
        StudentData result = instance.getStudentData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStudentData method, of class Student.
     */
    @Test
    public void testSetStudentData() throws Exception {
        System.out.println("setStudentData");
        StudentData data = null;
        Student instance = new Student();
        instance.setStudentData(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
