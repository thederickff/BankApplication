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
package com.github.derickfelix.bankapplication.respositories;

import com.github.derickfelix.bankapplication.models.Customer;
import java.util.ArrayList;


/**
 * @author derickfelix
 * Date: Oct 2, 2017
 */
public interface ICustomerRepository {

    /**
     * Gets all the customers of the database
     * 
     * @return - A List of Customers
     */
    ArrayList<Customer> all();

    /**
     * Gets a customer in the database by specifying the account number
     *
     * @param accountNumber the account number of the customer
     * @return - A Customer
     */
    Customer find(int accountNumber);

    /**
     * Updates a specific customer in the database
     *
     * @param customer the Customer to update
     */
    void update(Customer customer);

    /**
     * Stores a new customer in the database
     *
     * @param customer the Customer to be stored
     */
    void store(Customer customer);

    /**
     * Destroy a customer of the database
     *
     * @param customer the Customer to be destroyed
     */
    void destroy(Customer customer);

}
