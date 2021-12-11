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
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * MVC Pattern -> View class 
 * Meant to be used to get output for methods in controller
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka, Giuliana Bouzon
 */
public class View {
    
    /**
     * Formats output for issued books table (method viewIssuedBookTable in controller)
     * @param map the input map to print
     * @return a String containing formatted information pulled from map
     */
    public String printIssuedBookTable(Map<String, String> map) {
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA);
        String str = res.getString("key34") + "\n\n";
      
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str += res.getString("key5") + entry.getKey() + "\n";
	    str += entry.getValue() + "\n";
        }
        return str +"test4";
    }
 
    /**
     * Formats output for issued books table (method viewIssuedBookTable in controller)
     * @param map the input map to print
     * @return a String containing formatted information pulled from map
     */
    public String printIssuedBookTableFrench(Map<String, String> map) {
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA_FRENCH);
        String str = res.getString("key34") + "\n\n";
      
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str += res.getString("key5") + entry.getKey() + "\n";
	    str += entry.getValue() + "\n";
        }
        return str + "test1";
    }

    /**
     * Formats output for books in library catalog
     * @param map the input map to print
     * @return a String containing formatted information pulled from map
     */
    public String printBookCatalog(Map<String, String> map) {
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA);
	String str = res.getString("key35") + "\n\n";
	for (Map.Entry<String, String> entry : map.entrySet()) {
	    str += String.format("%s : %s\n", res.getString("key5"), entry.getKey());
	    str += entry.getValue() + "\n";
	}
	return str + "test2";
    }
    
    /**
     * Formats output for books in library catalog
     * @param map the input map to print
     * @return a String containing formatted information pulled from map
     */
    public String printBookCatalogFrench(Map<String, String> map) {
        ResourceBundle res = ResourceBundle.getBundle("source/Source", Locale.CANADA_FRENCH);
	String str = res.getString("key35") + "\n\n";
	for (Map.Entry<String, String> entry : map.entrySet()) {
	    str += String.format("%s : %s\n", res.getString("key5"), entry.getKey());
	    str += entry.getValue() + "\n";
	}
	return str + "test3";
    }
    
    /**
     * Formats output for books in the list
     * @param books, the input list to be formatted (usually search method from Student)
     * @return a String containing formatted information pulled from list
     * @throws java.lang.Exception exception thrown
     */
    public String printBookList(List<Book> books) throws Exception { 
        books.sort((Book b1, Book b2) -> (b1.getBookSN().compareTo(b2.getBookSN())));
	String str = "";
	for (Book book : books) {
	    str += book.toString();
	    str += book.getBookData().toString() + "\n";
	}
	return str;
    }
}