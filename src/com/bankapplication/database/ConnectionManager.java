/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankapplication.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @name DatabaseConnection
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class ConnectionManager {

    private static ConnectionManager connectionManager;
    private final String driverName = "com.mysql.jdbc.Driver";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/bank_db";
    private final String username = "root";
    private final String password = "admin";
    
    private Connection connection;
    
    private ConnectionManager() {
        this.connection = null;
        try {
            Class.forName(driverName);
        } catch(ClassNotFoundException e) {
            System.out.println("Class path error: " + e);
        }
    }
    
    public Connection createConnection() {
        try {
            this.connection = (Connection) DriverManager.getConnection(connectionUrl, username, password);
            
        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex);
        }
        return this.connection;
    }
    
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL error: " + ex);
        }
    }
    
    public static ConnectionManager getInstance() {
        if (connectionManager == null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }
}
