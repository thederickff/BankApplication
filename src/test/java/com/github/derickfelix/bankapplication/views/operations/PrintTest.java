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
import com.github.derickfelix.bankapplication.views.histories.DepositDetails;
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
    public void testCustomerPrintFunction() {
        System.out.println("Customer Details Printing Test");
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        CustomerRegistration cr = new CustomerRegistration(new Main(), true);
        assertNotNull(cr);   
        JButton btnPrint = (JButton) TestUtils.getChildNamed(cr, "btnPrint");
        btnPrint.doClick();
        assertTrue(cr.printFunction);     
        System.out.println("Print dialog box is poped up.");
    }
    
    @Test
    public void testDepositPrintFunction() {
        System.out.println("Deposit Details Printing Test");        
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        DepositDetails dd = new DepositDetails(new Main(), true);
        assertNotNull(dd);   
        JButton btnPrint = (JButton) TestUtils.getChildNamed(dd, "btnPrint");
        btnPrint.doClick();
        
        assertTrue(dd.printFunction);
        System.out.println("Print dialog box is poped up");
    }    
    
}
