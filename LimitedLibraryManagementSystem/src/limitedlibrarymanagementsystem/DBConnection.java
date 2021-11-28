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

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * A Database Connection class for the Library Database
 * @author Chilka Castro and Giuliana Bouzon
 */
public class DBConnection {  //APPLY SINGLETON IN THIS CLASS

    private static Connection connectionInstance;

    /**
     * A method that establishes a connection to database by obtaining          
     * a Connection object
     *
     * @return a Connection (Database Connection)
     * @throws Exception exception caught(SQL Exception)
     */
    private static Connection getConnection() throws Exception {                
        Class.forName("org.sqlite.JDBC");                                       

        String url = "jdbc:sqlite:C:\\SQLite\\databases\\library.db";           
        Connection connection = DriverManager.getConnection(url);

        return connection;
    }

    /**
     * A method that creates a connectionInstance but if the connectionInstance
     * already exists then just return that connectionInstance.
     *
     * @throws Exception exception caught(SQL Exception)
     */
    public static Connection getSingleInstance() throws Exception { 
        if (connectionInstance == null) 
            connectionInstance = getConnection();
        
        return connectionInstance;
    }

    public static Connection getConnectionInstance() {
        return connectionInstance;
    }
    
}
