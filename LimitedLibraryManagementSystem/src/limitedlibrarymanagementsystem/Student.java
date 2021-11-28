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

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Chilka Castro
 */
public class Student {
    
    //properties
    private String studentID;
    private String name;
    private String contactNum;
    
    //for proofing input
    static final String ID_REGEX = "[0-9]{7}"; //id must be 7 digits long
    static final String CONTACT_REGEX = "[0-9]{10,20}"; //number must be between 10 and 20 digits and comprise of ONLY digits
    static final String NAME_REGEX = "^[A-Za-z-\\s]{1,50}$"; //only letters 1 - 50, allows whitespace and dashes 
    //Pattern.matches(nameRegex, name) -> to use for pattern matchingS
    
    //default constructor
    public Student() {
	this("0000000", "noName", "5141234567"); //just for testing and debugging purposes
    }

    /**
     * Constructor with all data members
     * @param studentID the ID of the student(primary key)
     * @param name the name of the Student
     * @param contactNum the contact number of the student
     */
    public Student(String studentID, String name, String contactNum) {
        this.studentID = (Pattern.matches(ID_REGEX, studentID)) ? studentID : "0000000";
        this.name = (Pattern.matches(NAME_REGEX, name)) ? name : "noName";
        this.contactNum = (Pattern.matches(CONTACT_REGEX, contactNum)) ? contactNum : "5141234567";
    }
    
    //copy constructor
    public Student(Student student) {
	this(student.studentID, student.name, student.contactNum);
    }

    
    @Override
    public int hashCode() {
	return Objects.hash(contactNum, name, studentID);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Student other = (Student) obj;
	return Objects.equals(contactNum, other.contactNum) && Objects.equals(name, other.name)
		&& Objects.equals(studentID, other.studentID);
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
     * Search the book by its title
     * @param title the title of the book
     * @return a list of book
     */
    public List<Book> searchBookByTitle(String title) {
        return null;
    }
    
    /**
     * Search the book by its author's name
     * @param name the name of the author 
     * @return a list of book written by the author
     */
    public List<Book> searchBookByAuthorName(String authorName) {
        return null;
    }
    
    /**
     * Search the book by its publisher
     * @param publisher the publisher of the book
     * @return a list of book
     */
    public List<Book> searchBookByPublisher(String publisher) {
        return null;
    }
   
    /**
     * This method returns a map containing all data retrieved from the Books table. 
     * The key in the map is “SN”. All books should be sorted by “SN”.
     * Use the appropriate formatting for the date and currency.
     * @return a map of book
     */
    public Map<String, String> viewCatalog() {
       Book.viewCatalog();
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
	if (Pattern.matches(ID_REGEX, studentID))
	    this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
	if (Pattern.matches(NAME_REGEX, name))
	    this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
	if (Pattern.matches(CONTACT_REGEX, contactNum))
	    this.contactNum = contactNum;
    }   
}