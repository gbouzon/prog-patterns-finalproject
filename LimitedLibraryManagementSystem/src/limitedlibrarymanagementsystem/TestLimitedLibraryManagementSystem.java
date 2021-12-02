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

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A Driver class for the Limited Library Management System
 * @author Chilka Castro and Giuliana Bouzon
 */
public class TestLimitedLibraryManagementSystem{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
	//testing shit
	View view = new View();
       
        Book book = new Book("219831928319", new BookData("The Wind-Up Bird Chronicle", "Haruki Murakami", 
                "Penguin", 8, 18.29, -1, LocalDate.EPOCH)); 
        //notice that issuedQuantity is still 0 (check BookData constructor)
        //notice that date of purchase is set to today even though we do LocalDate.EPOCH(check BookData constructor)
	
	Student student = new Student("1940108", new StudentData("Giuliana Bouzon", "5148009876"));
	
	DBController controller = new DBController(book, student, view);
	
	//testing student controller
	StudentController stController = new StudentController(new ArrayList<Book>(), student, view);  // CHILKA: modified this and added student
	
	//testing searching by title
	//stController.updateViewBookList(stController.searchBookByTitle("Intro to Java Programming"));
	
	//testing with multiple finds with search by author name
	//stController.updateViewBookList(stController.searchBookByAuthorName("Haruki Murakami"));
	//testing with only one found
	//stController.updateViewBookList(stController.searchBookByAuthorName("Lynne Cox"));
	
	//testing searching by publisher
	//testing with multiple finds
	stController.updateViewBookList(stController.searchBookByPublisher("Penguin Books"));
	//testing with only one found
	//stController.updateViewBookList(stController.searchBookByAuthorName("‎William Morrow"));
	
	//testing addbook and view catalog of dbcontroller(aka librarian perms)
	//controller.updateViewCatalog(controller.viewCatalog());
        //controller.addBook(book);
        //controller.updateViewCatalog(DBController.viewCatalog());
    }  
}