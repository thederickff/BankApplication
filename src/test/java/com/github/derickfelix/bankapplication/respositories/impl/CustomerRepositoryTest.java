/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.respositories.impl;

import com.github.derickfelix.bankapplication.models.Customer;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JT
 */
public class CustomerRepositoryTest {
    
    public CustomerRepositoryTest() {
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
     * Test of all method, of class CustomerRepository.
     */
    @Test
    public void testAll() {
        System.out.println("all");
        CustomerRepository instance = new CustomerRepository();
        ArrayList<Customer> expResult = null;
        ArrayList<Customer> result = instance.all();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class CustomerRepository.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int accountNumber = 0;
        CustomerRepository instance = new CustomerRepository();
        Customer expResult = null;
        Customer result = instance.find(accountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CustomerRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Customer customer = null;
        CustomerRepository instance = new CustomerRepository();
        instance.update(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of store method, of class CustomerRepository.
     */
    @Test
    public void testStore() {
        System.out.println("store");
        Customer customer = null;
        CustomerRepository instance = new CustomerRepository();
        instance.store(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class CustomerRepository.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        Customer customer = null;
        CustomerRepository instance = new CustomerRepository();
        instance.destroy(customer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
