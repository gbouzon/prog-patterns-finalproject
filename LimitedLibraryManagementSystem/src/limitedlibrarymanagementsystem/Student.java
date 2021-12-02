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

import java.util.Objects;
import java.util.regex.Pattern;

/**
 *
 * @author Chilka Castro
 */
public class Student {
    
    //properties
    private String studentID;
    private StudentData data;
    
    //for proofing input
    static final String ID_REGEX = "[0-9]{7}"; //id must be 7 digits long
    //Pattern.matches(nameRegex, name) -> to use for pattern matchingS
    
    //default constructor
    public Student() {
	this("0000000", new StudentData()); //just for testing and debugging purposes
    }

    /**
     * Constructor with all data members
     * @param studentID the ID of the student(primary key) (key -> map implemented)
     * @param data the data of the student(value -> map implemented)
     */
    public Student(String studentID, StudentData data) {
        this.studentID = (Pattern.matches(ID_REGEX, studentID)) ? studentID : "0000000";
        this.data = new StudentData(data); //deep copy
    }
    
    //copy constructor
    public Student(Student student) {
	this(student.studentID, student.data);
    }

    /**
     * Generates an integer hash code associated with an equals method
     * @return and integer hash code 
     */
    @Override
    public int hashCode() {
	return Objects.hash(data.hashCode(), studentID);
    }

    /**
     * Check if objects are the same or not
     * @param obj the other object to be checked with for equality
     * @return True if the objects are the same and False if not
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Student other = (Student) obj;
	return Objects.equals(data, other.data) && Objects.equals(studentID, other.studentID);
    }

    /**
     * Generates a String that represents a student object
     * @return a String that represents a student object
     */
    @Override
    public String toString() {   
        return String.format("%-10s : %s\n", "Student ID", studentID);
    }
    
    // getters and setters
    
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
	if (Pattern.matches(ID_REGEX, studentID))
	    this.studentID = studentID;
    }

    public StudentData getStudentData() {
	return new StudentData(this.data);
    }
    
    public void setStudentData(StudentData data) {
	this.data = new StudentData(data);
    }
}