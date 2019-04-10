/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import Test.TestUtils;
import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.views.Main;
import com.github.derickfelix.bankapplication.views.histories.CustomerRegistration;
import javax.swing.JButton;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Li Ho
 */
public class PrintTest {
    
    public PrintTest() {
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

    @Test
    public void testPrintFunction() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        CustomerRegistration cr = new CustomerRegistration(new Main(), true);
        assertNotNull(cr);   
        JButton btnPrint = (JButton) TestUtils.getChildNamed(cr, "btnPrint");
        btnPrint.doClick();
        
        assertTrue(cr.printFunction);
                
    }
    
}
