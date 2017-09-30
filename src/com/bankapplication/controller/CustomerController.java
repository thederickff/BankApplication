/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.database.ConnectionManager;
import com.bankapplication.model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @name CustomerController
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class CustomerController extends Controller {

    private final String table = "`customers`";
    private LinkedList<Customer> customers;

    public CustomerController(ConnectionManager connectionManager) {
        super(connectionManager);
    }

    /**
     * It stores a customer in the database
     *
     * @param customer The customer to be stored in the database
     */
    public void store(Customer customer) {
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + table + " (`account_number`, `name`, `address`, `sex`, `born_date`, `account_type`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            // Prepare Statement
            ps = conn.prepareStatement(sql);
            ps.setString(1, customer.getAccountNumber());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, Character.toString(customer.getSex()));
            ps.setString(5, customer.getDob());
            ps.setString(6, customer.getAccountType());
            ps.setString(7, customer.getPassword());
            // Execute Staement
            ps.execute();
            // Close Connection
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Erro: " + ex);
        }
    }

    public LinkedList<Customer> getCustomers() {
        Connection conn = connectionManager.createConnection();
        String sql = "select * from " + table;
        // Intantiate a new LinkedList
        customers = new LinkedList<>();
        Customer tempCustomer;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                String acc = rs.getString("account_number");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String sex = rs.getString("sex");
                String dob = rs.getString("born_date");
                String accType = rs.getString("account_type");
                String password = rs.getString("password");

                tempCustomer = new Customer(acc, name, address, accType, sex.charAt(0), dob);
                tempCustomer.setPassword(password);
                customers.add(tempCustomer);
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return customers;
    }
}
