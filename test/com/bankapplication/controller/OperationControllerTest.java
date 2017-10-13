/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

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
public class OperationControllerTest {
    
    private OperationController instance;
    
    public OperationControllerTest() {
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
     * Test of makeDeposit method, of class OperationController.
     */
    @Test
    public void testMakeDeposit() {
        System.out.println("makeDeposit");
        //instance = OperationController.getInstance();
        //instance.makeDeposit(1, 1000);
    }

    /**
     * Test of makeWithdraw method, of class OperationController.
     */
    @Test
    public void testMakeWithdraw() {
        System.out.println("makeWithdraw");
        instance = OperationController.getInstance();
        instance.makeDeposit(1, 1000);
        instance.makeWithdraw(1, 600);
        instance.makeWithdraw(1, 600);
        instance.makeWithdraw(1, 400);
        System.out.println(instance.getBalance(1));
    }

    /**
     * Test of getBalance method, of class OperationController.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        //instance = OperationController.getInstance();
        //System.out.println(instance.getBalance(1));
    }
    
}
