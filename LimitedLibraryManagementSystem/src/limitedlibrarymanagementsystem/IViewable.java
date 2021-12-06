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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Interface implements viewCatalog method
 * MVC Pattern -> Strategy (interfaces)
 * Final Project for Programming Patterns course - Fall 2021.
 * @author Chilka Castro, Giuliana Bouzon
 */
public interface IViewable {
    
    /**
     * This method returns a map containing all data retrieved from the Books
     * table.The key in the map is “SN”. All books should be sorted by “SN”.
     * @return map containing books
     * @throws java.lang.Exception exception thrown
     */
    public static Map<String, String> viewCatalog() throws Exception {
        Map<String, String> map = new TreeMap<>( (String s1, String s2) -> (s1.compareTo(s2)));	
	Connection connection = DBConnection.getSingleInstance();

	String query = "SELECT * FROM BOOK";
	Statement statement = connection.createStatement();
	ResultSet rs = statement.executeQuery(query);
	
	while(rs.next()) {
	    //getting the key -> book sn
	    String key = rs.getString("SN");
	    
	    //getting BookData
	    String title = rs.getString("Title");
	    String author = rs.getString("Author");
	    String publisher = rs.getString("Publisher");
	    double price = rs.getDouble("Price");
	    int quantity = rs.getInt("Quantity");
	    int issuedQuantity = rs.getInt("IssuedQuantity");
	    LocalDate date = LocalDate.parse(rs.getString("AddedDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
   
	    //creating object
	    BookData bvalue = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);
            String value = bvalue.toString();
	    //inserting into map
	    map.put(key, value);
	}
        if (map.isEmpty())
            throw new Exception("No books found");
	return map;
    }
}