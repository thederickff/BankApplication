/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.database.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @name UserController
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class UserController extends Controller {

    public UserController(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    /**
     * Makes the authentication by a given account number and a password
     *
     * @param accountNumber The account number of an user
     * @param password The password of an user
     * @return - Whether an user exists in the database
     */
    public boolean login(String accountNumber, String password) {
        Connection conn = connectionManager.createConnection();

        try {
            statement = (Statement) conn.createStatement();
            rs = statement.executeQuery("select * from users");

            while (rs.next()) {
                if (rs.getString("account_number").equals(accountNumber)
                        && rs.getString("password").equals(password)) {
                    return true;
                }
            }
            // Close
            conn.close();
            statement.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return false;
    }
}
