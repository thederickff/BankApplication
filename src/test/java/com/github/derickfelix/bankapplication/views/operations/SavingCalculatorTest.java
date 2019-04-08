/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import Test.TestUtils;
import com.github.derickfelix.bankapplication.controllers.StaffController;
import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.models.Staff;
import com.github.derickfelix.bankapplication.views.Main;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Tan Chek Wei
 */
public class SavingCalculatorTest {

    public SavingCalculatorTest() {
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
    public void savingCalculatorValidInput() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        SavingCalculator rc = new SavingCalculator(new Main(), true);
        assertNotNull(rc);
        //Find JComponent by name set in RegisterCustomer.java
        JTextField txtDepositAmount = (JTextField) TestUtils.getChildNamed(rc, "txtDepositAmount");
        JTextField txtFinalBalance = (JTextField) TestUtils.getChildNamed(rc, "txtFinalBalance");
        JTextField txtInterest = (JTextField) TestUtils.getChildNamed(rc, "txtInterest");
        JTextField txtMonth = (JTextField) TestUtils.getChildNamed(rc, "txtMonth");
        JButton jButtonCalculate = (JButton) TestUtils.getChildNamed(rc, "jButtonCalculate");

        //Check NULL of JComponent
        assertNotNull("Cannot access JTextField component (txtFinalBalance)", txtFinalBalance);
        assertNotNull("Cannot access JTextField component (txtDepositAmount)", txtDepositAmount);
        assertNotNull("Cannot access JTextField component (txtInterest)", txtInterest);
        assertNotNull("Cannot access JTextField component (txtMonth)", txtMonth);
        assertNotNull("Cannot access JButton component (jButtonCalculate)", jButtonCalculate);
        
        //Set data
        txtDepositAmount.setText("2500");
        txtInterest.setText("5");
        txtMonth.setText("12");
        
        //Post string to text field (for JTextField only)
        txtDepositAmount.postActionEvent();
        txtInterest.postActionEvent();
        txtMonth.postActionEvent();
        
        //Click Register
        jButtonCalculate.doClick();
        
        //Compare
        assertThat(Double.parseDouble(txtFinalBalance.getText()), equalTo(2627.9));
    }

    @Test(expected = java.lang.NumberFormatException.class)
    public void savingCalculatorEmptyInput() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        SavingCalculator rc = new SavingCalculator(new Main(), true);
        assertNotNull(rc);
        //Find JComponent by name set in RegisterCustomer.java
        JTextField txtDepositAmount = (JTextField) TestUtils.getChildNamed(rc, "txtDepositAmount");
        JTextField txtFinalBalance = (JTextField) TestUtils.getChildNamed(rc, "txtFinalBalance");
        JTextField txtInterest = (JTextField) TestUtils.getChildNamed(rc, "txtInterest");
        JTextField txtMonth = (JTextField) TestUtils.getChildNamed(rc, "txtMonth");
        JButton jButtonCalculate = (JButton) TestUtils.getChildNamed(rc, "jButtonCalculate");

        //Check NULL of JComponent
        assertNotNull("Cannot access JTextField component (txtFinalBalance)", txtFinalBalance);
        assertNotNull("Cannot access JTextField component (txtDepositAmount)", txtDepositAmount);
        assertNotNull("Cannot access JTextField component (txtInterest)", txtInterest);
        assertNotNull("Cannot access JTextField component (txtMonth)", txtMonth);
        assertNotNull("Cannot access JButton component (jButtonCalculate)", jButtonCalculate);
        
        //Set data
        txtDepositAmount.setText("");
        txtInterest.setText("");
        txtMonth.setText("");
        
        //Post string to text field (for JTextField only)
        txtDepositAmount.postActionEvent();
        txtInterest.postActionEvent();
        txtMonth.postActionEvent();
        
        //Click Calculate
        jButtonCalculate.doClick();
    }

    @Test(expected = java.lang.NumberFormatException.class)
    public void savingCalculatorAlphabetInput() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        SavingCalculator rc = new SavingCalculator(new Main(), true);
        assertNotNull(rc);
        //Find JComponent by name set in RegisterCustomer.java
        JTextField txtDepositAmount = (JTextField) TestUtils.getChildNamed(rc, "txtDepositAmount");
        JTextField txtFinalBalance = (JTextField) TestUtils.getChildNamed(rc, "txtFinalBalance");
        JTextField txtInterest = (JTextField) TestUtils.getChildNamed(rc, "txtInterest");
        JTextField txtMonth = (JTextField) TestUtils.getChildNamed(rc, "txtMonth");
        JButton jButtonCalculate = (JButton) TestUtils.getChildNamed(rc, "jButtonCalculate");

        //Check NULL of JComponent
        assertNotNull("Cannot access JTextField component (txtFinalBalance)", txtFinalBalance);
        assertNotNull("Cannot access JTextField component (txtDepositAmount)", txtDepositAmount);
        assertNotNull("Cannot access JTextField component (txtInterest)", txtInterest);
        assertNotNull("Cannot access JTextField component (txtMonth)", txtMonth);
        assertNotNull("Cannot access JButton component (jButtonCalculate)", jButtonCalculate);
        
        //Set data
        txtDepositAmount.setText("");
        txtInterest.setText("");
        txtMonth.setText("");
        
        //Post string to text field (for JTextField only)
        txtDepositAmount.postActionEvent();
        txtInterest.postActionEvent();
        txtMonth.postActionEvent();
        
        //Click Calculate
        jButtonCalculate.doClick();
    }
}
