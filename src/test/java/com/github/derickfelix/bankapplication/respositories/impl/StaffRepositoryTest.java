/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.respositories.impl;

import com.github.derickfelix.bankapplication.models.Staff;
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
public class StaffRepositoryTest {
    
    public StaffRepositoryTest() {
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
     * Test of all method, of class StaffRepository.
     */
    @Test
    public void testAll() {
        System.out.println("all");
        StaffRepository instance = new StaffRepository();
        ArrayList<Staff> expResult = null;
        ArrayList<Staff> result = instance.all();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class StaffRepository.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int id = 0;
        StaffRepository instance = new StaffRepository();
        Staff expResult = null;
        Staff result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class StaffRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Staff staff = null;
        StaffRepository instance = new StaffRepository();
        instance.update(staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of store method, of class StaffRepository.
     */
    @Test
    public void testStore() {
        System.out.println("store");
        Staff staff = null;
        StaffRepository instance = new StaffRepository();
        instance.store(staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class StaffRepository.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        Staff staff = null;
        StaffRepository instance = new StaffRepository();
        instance.destroy(staff);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
