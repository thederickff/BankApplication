/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.respositories.impl;

import com.github.derickfelix.bankapplication.models.Deposit;
import com.github.derickfelix.bankapplication.models.Withdraw;
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
public class OperationRepositoryTest {
    
    public OperationRepositoryTest() {
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
     * Test of deposit method, of class OperationRepository.
     */
    @Test
    public void testDeposit() {
        System.out.println("deposit");
        int accountNumber = 0;
        double amount = 0.0;
        OperationRepository instance = new OperationRepository();
        instance.deposit(accountNumber, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraw method, of class OperationRepository.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        int accountNumber = 0;
        double amount = 0.0;
        OperationRepository instance = new OperationRepository();
        instance.withdraw(accountNumber, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deposits method, of class OperationRepository.
     */
    @Test
    public void testDeposits_0args() {
        System.out.println("deposits");
        OperationRepository instance = new OperationRepository();
        ArrayList<Deposit> expResult = null;
        ArrayList<Deposit> result = instance.deposits();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraws method, of class OperationRepository.
     */
    @Test
    public void testWithdraws_0args() {
        System.out.println("withdraws");
        OperationRepository instance = new OperationRepository();
        ArrayList<Withdraw> expResult = null;
        ArrayList<Withdraw> result = instance.withdraws();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deposits method, of class OperationRepository.
     */
    @Test
    public void testDeposits_int() {
        System.out.println("deposits");
        int accountNumber = 0;
        OperationRepository instance = new OperationRepository();
        ArrayList<Deposit> expResult = null;
        ArrayList<Deposit> result = instance.deposits(accountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withdraws method, of class OperationRepository.
     */
    @Test
    public void testWithdraws_int() {
        System.out.println("withdraws");
        int accountNumber = 0;
        OperationRepository instance = new OperationRepository();
        ArrayList<Withdraw> expResult = null;
        ArrayList<Withdraw> result = instance.withdraws(accountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
