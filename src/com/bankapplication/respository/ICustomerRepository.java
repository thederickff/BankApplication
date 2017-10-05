/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository;

import com.bankapplication.model.Customer;
import java.util.ArrayList;


/**
 * @name CustomerRepository
 * @author derickfelix
 * @date Oct 2, 2017
 */
public interface ICustomerRepository {

    /**
     * Gets all the customers of the database
     * 
     * @return - A List of Customers
     */
    public ArrayList<Customer> all();

    /**
     * Gets a customer in the database by specifying the account number
     *
     * @param accountNumber the account number of the customer
     * @return - A Customer
     */
    public Customer find(int accountNumber);

    /**
     * Updates a specific customer in the database
     *
     * @param customer the Customer to update
     */
    public void update(Customer customer);

    /**
     * Stores a new customer in the database
     *
     * @param customer the Customer to be stored
     */
    public void store(Customer customer);

    /**
     * Destroy a customer of the database
     *
     * @param customer the Customer to be destroyed
     */
    public void destroy(Customer customer);

}
