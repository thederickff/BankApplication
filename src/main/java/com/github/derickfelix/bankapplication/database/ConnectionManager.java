/*
 * The MIT License
 *
 * Copyright 2019 Derick Felix.
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
package com.github.derickfelix.bankapplication.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author derickfelix
 */
public class ConnectionManager {

    private static ConnectionManager connectionManager;
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/bank_application";
    private final String username = "root";
    private final String password = "admin";

    private Connection connection;

    private ConnectionManager()
    {
        this.connection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("Class path error: " + e);
        }
    }

    public Connection createConnection()
    {
        try {
            this.connection = (Connection) DriverManager.getConnection(connectionUrl, username, password);

        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex);
        }
        return this.connection;
    }

    public void closeConnection()
    {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex);
        }
    }

    public static ConnectionManager getInstance()
    {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
}
