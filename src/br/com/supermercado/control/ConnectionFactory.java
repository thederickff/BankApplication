/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermercado.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author derick
 */
public class ConnectionFactory {
   
    public static String url = "http://localhost:3306/produtos_sm";
    public static String user = "root";
    public static String password = "admin";
    
    
    public static Connection getConnection(){
        try{
            
            
            return DriverManager.getConnection(url, user, password);
        } catch(SQLException e){
           throw new RuntimeException();
        }
        
    }
}
