/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.model.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author derickfelix
 */
public class CustomerControllerTest {
    
    private CustomerController instance;
    public CustomerControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of all method, of class CustomerController.
     */
    @Test
    public void testAll() {
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
    public void testSearchCustomer() {
        System.out.println("Search acccount");
        instance = CustomerController.getInstance();
        Customer customer = instance.searchCustomer(2470);
        assertTrue(customer.getName() != null);
    }
    
}
