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

import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.models.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author derickfelix
 */
public class UserControllerTest {

    private UserController instance;

    public UserControllerTest()
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
     * Test of login method, of class UserController.
     */
    @Test
    public void testLogin()
    {
        instance = UserController.getInstance();

        User user = new User();
        user.setName("root");
        user.setAccountNumber("0000");
        user.setRole("admin");
        user.setPassword("admin");

        assertTrue(instance.login(user.getAccountNumber(), user.getPassword()));
    }

    /**
     * Test of store method, of class UserController.
     */
    @Test
    public void testStore()
    {
        System.out.println("Store");
        instance = UserController.getInstance();
        User user = new User();
        user.setName("Bryson Balvin");
        user.setAccountNumber("1111");
        user.setRole("manager");
        user.setPassword("secret");
        //instance.store(user);
        assertEquals(user.getName(), instance.findById(2).getName());
    }

    /**
     * Test of update method, of class UserController.
     */
    @Test
    public void testUpdate()
    {
        System.out.println("Update");
        instance = UserController.getInstance();

        User user = new User();
        user.setUserId("1");
        user.setName("Will Drake");
        user.setAccountNumber("0000");
        user.setRole("admin");
        user.setPassword("admin");

        //instance.update(user);
        assertEquals(user.getName(), instance.findById(1).getName());
    }

    /**
     * Test of destroy method, of class UserController.
     */
    @Test
    public void testDestroy()
    {
        System.out.println("Destroy");
        instance = UserController.getInstance();
        User user = new User();
        user.setUserId("4");
        //instance.destroy(user);
    }
}
