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

/**
 *
 * @author Chilka, Giuliana Bouzon
 */
public class View {

    public String printIssuedBookTable(Map<String, String> map) {
        String str = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str += String.format("%-20s : %s\n", "SN", entry.getKey());
	    str += entry.getValue() + "\n";
        }
        return str;
    }
    
    public String printBookCatalog(Map<String, String> map) {
        String str2 = "";
        str2 += "Catalog of Books in the Library: \n";
	//System.out.println("Catalog of Books in the Library: \n");
	String str = "";
	
	for (Map.Entry<String, String> entry : map.entrySet()) {
	    str += String.format("%-20s : %s\n", "SN", entry.getKey());
	    str += entry.getValue() + "\n";
	}
	return str2 + str;
    }
    
    public String printBookList(List<Book> books) { //just to make it pretty
	String str = "";
	for (Book book : books) {
	    str += book.toString();
	    str += book.getBookData().toString() + "\n";
	}
	return str;
    }
}