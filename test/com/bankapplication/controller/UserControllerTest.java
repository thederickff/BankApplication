/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.model.User;
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
public class UserControllerTest {

    private UserController instance;

    public UserControllerTest() {
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
     * Test of login method, of class UserController.
     */
    @Test
    public void testLogin() {
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
    public void testStore() {
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
    public void testUpdate() {
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
    public void testDestroy() {
        System.out.println("Destroy");
        instance = UserController.getInstance();
        User user = new User();
        user.setUserId("4");
        //instance.destroy(user);
    }
}
