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
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Chilka Castro
 */
public interface IViewable {
    public static Map<String, BookData> viewCatalog() throws Exception {
        Map<String, BookData> map = new HashMap<>();
	
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
	    BookData value = new BookData(title, author, publisher, quantity, price, issuedQuantity, date);
	   
	    //debugging - will be deleted later
	    //System.out.println(key);
	    //System.out.println(value);
	    
	    //inserting into map
	    map.put(key, value);
	}
	return map;
    }
    
    /**
     * Updates the view catalog
     * @throws Exception 
     */
    public void updateViewCatalog() throws Exception;
}
