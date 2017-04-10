/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author derick
 */
public class DatabaseConf {
   
    public static String url = "jdbc:mysql://localhost:3306/supermarket_db";
    public static String user = "root";
    public static String password = "admin";
    public static String tableProducts = "products";
    
    public Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
  
}