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

import com.github.derickfelix.bankapplication.controllers.OperationController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author derickfelix
 */
public class OperationControllerTest {

    private OperationController instance;

    public OperationControllerTest()
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
     * Test of makeDeposit method, of class OperationController.
     */
    @Test
    public void testMakeDeposit()
    {
        System.out.println("makeDeposit");
        //instance = OperationController.getInstance();
        //instance.makeDeposit(1, 1000);
    }

    /**
     * Test of makeWithdraw method, of class OperationController.
     */
    @Test
    public void testMakeWithdraw()
    {
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
    public void testGetBalance()
    {
        System.out.println("getBalance");
        //instance = OperationController.getInstance();
        //System.out.println(instance.getBalance(1));
    }

}
