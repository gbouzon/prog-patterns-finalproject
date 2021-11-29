/** MIT License Copyright (c) 2021 Giuliana Bouzon

* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:

* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.

* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package limitedlibrarymanagementsystem;

import java.util.Objects;
import java.util.regex.Pattern;

/**
*
* @author Giuliana Bouzon
*/
public class StudentData {
    
    //properties
    private String name;
    private String contactNum;
    
    //for proofing input
    static final String CONTACT_REGEX = "[0-9]{10,20}"; //number must be between 10 and 20 digits and comprise of ONLY digits
    static final String NAME_REGEX = "^[A-Za-z-\\s]{1,50}$"; //only letters 1 - 50, allows whitespace and dashes 
    //Pattern.matches(nameRegex, name) -> to use for pattern matchingS
    
    //default constructor
    public StudentData() {
	this("noName", "5141234567"); //just for testing and debugging purposes
    }

    /**
     * Constructor with all data members
     * @param studentID the ID of the student(primary key)
     * @param name the name of the Student
     * @param contactNum the contact number of the student
     */
    public StudentData(String name, String contactNum) {
        this.name = (Pattern.matches(NAME_REGEX, name)) ? name : "noName";
        this.contactNum = (Pattern.matches(CONTACT_REGEX, contactNum)) ? contactNum : "5141234567";
    }
    
    //copy constructor
    public StudentData(StudentData student) {
	this(student.name, student.contactNum);
    }

    
    @Override
    public int hashCode() {
	return Objects.hash(contactNum, name);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	StudentData other = (StudentData) obj;
	return Objects.equals(contactNum, other.contactNum) && Objects.equals(name, other.name);
    }

    /**
     * Generates a String that represents a student object
     * @return a String that represents a student object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s : %s\n", "Student name", name);
        str += String.format("%-10s : %s\n", "Contact Number", contactNum);
        
        return str;
    }
   
    // getters and setters

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