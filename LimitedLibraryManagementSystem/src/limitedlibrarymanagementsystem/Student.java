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

/**
 *
 * @author Chilka Castro
 */
public class Student {
    private String studentID;
    private String name;
    private String contactNum;

    /**
     * Constructor with all data members
     * @param studentID the ID of the student(primary key)
     * @param name the name of the Student
     * @param contactNum the contact number of the student
     */
    public Student(String studentID, String name, String contactNum) {
        this.studentID = studentID;
        this.name = name;
        this.contactNum = contactNum;
    }

    /**
     * Generates a String that represents a student object
     * @return a String that represents a student object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s : %s\n", "Student ID", studentID);
        str += String.format("%-10s : %s\n", "Student name", name);
        str += String.format("%-10s : %s\n", "Contact Number", contactNum);
        
        return str;
    }
    
    /**
     * 
     * @param title
     * @return 
     */
    public List<Book> searchBookByTitle(String title) {
        return null;
    }
    
    /**
     * 
     * @param name
     * @return 
     */
    public List<Book> searchBookByName(String name) {
        return null;
    }
    
    /**
     * 
     * @param year
     * @return 
     */
    public List<Book> searchBookByPublisher(String year) {
        return null;
    }
   
    /**
     * 
     * @return 
     */
    public Map<String, String> viewCatalog() {
        return null;
    }
    
    /**
     * 
     * issueBook(b:Book, s:Student) and borrow(b:Book): To issue a book to a 
     * student, student information should be verified first. If the book is 
     * available, the number of copies(“Quantity”) will be decreased by one 
     * and the number of Copies issued (“Issued”) will be increased by one. 
     * A new entry in “IssuedBooks” table is added. The two methods return
     * true if the book was successfully issued.
     * @param book
     * @return 
     */
    public Boolean borrow(Book book) {
      return false;
    }
    
    /**
     *
     * returnBook(b:Book, s:Student) and toReturn(b:Book): To return a book,      
     * check first if an entry in the issuedBooks table about the book and the 
     * student exists that will verify the studentID. The number of copies 
     * “Quantity” will be increased by one and the number of copies issued 
     * will be decreased by one. The corresponding record in IssuedBooks 
     * table is deleted from the table. The two methods return true if the
     * book was successfully returned.
     * @param book
     * @return 
     */
    public Boolean toReturn(Book book) {
        return false;
    }
   
    
    // getters and setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }   
}
