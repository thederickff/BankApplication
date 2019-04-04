/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import Test.TestUtils;
import com.github.derickfelix.bankapplication.controllers.StaffController;
import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.models.Customer;
import com.github.derickfelix.bankapplication.models.Staff;
import com.github.derickfelix.bankapplication.views.Main;
import java.util.ArrayList;
import javax.swing.*;
import static org.hamcrest.CoreMatchers.is;
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
public class RegisterStaffTest {
    
    public RegisterStaffTest() {
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
    public void testSomeMethod() {
        //Login
        UserController.getInstance().login("0000", "secret");
         //Initiate frame
        RegisterStaff rc = new RegisterStaff(new Main(), true);
        assertNotNull(rc);
        //Find JComponent by name set in RegisterCustomer.java
        //rc.setVisible(true);
        JTextField txtName = (JTextField) TestUtils.getChildNamed(rc, "jtfName");
        JTextField txtAddress = (JTextField) TestUtils.getChildNamed(rc, "jtfAddress");
        JComboBox<String> cmbRank = (JComboBox<String>) TestUtils.getChildNamed(rc, "cRank");
        JRadioButton radioFemale = (JRadioButton) TestUtils.getChildNamed(rc, "jrbFemale");
        JRadioButton radioMale = (JRadioButton) TestUtils.getChildNamed(rc, "jrbMale");
        JComboBox<String> cmbDay = (JComboBox<String>) TestUtils.getChildNamed(rc, "cDay");
        JComboBox<String> cmbMonth = (JComboBox<String>) TestUtils.getChildNamed(rc, "cMonth");
        JComboBox<String> cmbYear = (JComboBox<String>) TestUtils.getChildNamed(rc, "cYear");
        JPasswordField txtPassword = (JPasswordField) TestUtils.getChildNamed(rc, "jpfPassword");
        JButton btnRegister = (JButton) TestUtils.getChildNamed(rc, "btnReg");
            //Check NULL of JComponent
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfAddress)", txtAddress);
        assertNotNull("Cannot access JComboBox component (cmbRank)", cmbRank);
        assertNotNull("Cannot access JRadioButton component (jrbFemale)", radioFemale);
        assertNotNull("Cannot access JRadioButton component (jrbMale)", radioMale);
        assertNotNull("Cannot access JComboBox component (cDay)", cmbDay);
        assertNotNull("Cannot access JComboBox component (cMonth)", cmbMonth);
        assertNotNull("Cannot access JComboBox component (cYear)", cmbYear);
        assertNotNull("Cannot access JPasswordField component (jpfPassword)", txtPassword);
        assertNotNull("Cannot access JButton component (btnReg)", btnRegister);
            //Set data
        txtName.setText("TANG");
        txtAddress.setText("9 JALAN 17");
        cmbRank.setSelectedIndex(1);
        radioFemale.setSelected(true);
        //radioMale.setSelected(true);
        cmbDay.setSelectedIndex(1);
        cmbMonth.setSelectedIndex(1);
        cmbYear.setSelectedIndex(1);
        txtPassword.setText("12345678");
            //Post string to text field (for JTextField only)
        txtName.postActionEvent();
        txtAddress.postActionEvent();
        txtPassword.postActionEvent();
            //Click button
        btnRegister.doClick();
            //Check record exist or not
        StaffController cc = StaffController.getInstance();
        ArrayList<Staff> staffArr = cc.getStaffs();
        assertThat("Register failed", staffArr.size(), is(1)); // fail if record size is zero.
    }
    
}
