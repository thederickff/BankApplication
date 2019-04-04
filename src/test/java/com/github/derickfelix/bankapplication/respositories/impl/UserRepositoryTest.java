/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.respositories.impl;

import com.github.derickfelix.bankapplication.models.User;
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
public class UserRepositoryTest {
    
    public UserRepositoryTest() {
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
     * Test of all method, of class UserRepository.
     */
    @Test
    public void testAll() {
        System.out.println("all");
        UserRepository instance = new UserRepository();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.all();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class UserRepository.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 0;
        UserRepository instance = new UserRepository();
        User expResult = null;
        User result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        User user = null;
        UserRepository instance = new UserRepository();
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of store method, of class UserRepository.
     */
    @Test
    public void testStore() {
        System.out.println("store");
        User user = null;
        UserRepository instance = new UserRepository();
        instance.store(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class UserRepository.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        User user = null;
        UserRepository instance = new UserRepository();
        instance.destroy(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
