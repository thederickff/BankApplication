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
package com.bankapplication.controller;

import com.github.derickfelix.bankapplication.controllers.CustomerController;
import com.github.derickfelix.bankapplication.models.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author derickfelix
 */
public class CustomerControllerTest {

    private CustomerController instance;

    public CustomerControllerTest()
    {
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of all method, of class CustomerController.
     */
    @Test
    public void testAll()
    {
        System.out.println("all");
        instance = CustomerController.getInstance();
        ArrayList<Customer> customers = instance.getCustomers();

        for (int i = 0; i < customers.size(); i++) {
            Customer tempCustomer = customers.get(i);
            System.out.println("Account No: " + tempCustomer.getAccountNumber());
            System.out.println("Name: " + tempCustomer.getName());
            System.out.println("Address" + tempCustomer.getAddress());
            System.out.println("DOB: " + tempCustomer.getDob());
        }
    }

    /**
     * Test of searchCustomer method, of class CustomerController.
     */
    @Test
    public void testSearchCustomer()
    {
        System.out.println("Search acccount");
        instance = CustomerController.getInstance();
        Customer customer = instance.searchCustomer(2470);
        assertTrue(customer.getName() != null);
    }

}
