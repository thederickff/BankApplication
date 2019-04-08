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
import com.github.derickfelix.bankapplication.views.Login;
import com.github.derickfelix.bankapplication.views.Main;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Encoder;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
/**
 *
 * @author Chek Wei
 */
public class RegisterStaffTest {
    
    private static ArrayList<Staff> staffArr;
    private StaffController cc;
    private int initialStaffCount;
    private StaffController staffCtrl;
    
    public RegisterStaffTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
//        testData = new Staff("1234", "Jack", "No.10 Jalan 10, Kampung Baru, 47000 Sungai Buloh, Selangor.", 'f', "1999-01-01", "Board of Director", "123456");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Get initial staff records
        cc = StaffController.getInstance();
        staffArr = cc.getStaffs();
        initialStaffCount = staffArr.size();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void staffRegisterValidInput() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        RegisterStaff rc = new RegisterStaff(new Main(), true);
        assertNotNull(rc);
        //Find JComponent by name set in RegisterCustomer.java
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
        txtName.setText("Jack");
        txtAddress.setText("No.10 Jalan 10, Kampung Baru, 47000 Sungai Buloh, Selangor.");
        cmbRank.setSelectedIndex(1);
        radioFemale.setSelected(true);
        cmbDay.setSelectedIndex(1);
        cmbMonth.setSelectedIndex(1);
        cmbYear.setSelectedIndex(1);
        txtPassword.setText("12345678");
        //Post string to text field (for JTextField only)
        txtName.postActionEvent();
        txtAddress.postActionEvent();
        txtPassword.postActionEvent();
        //Click Register
        btnRegister.doClick();
        //Get updated staff list
        ArrayList<Staff> newStaffArr = cc.getStaffs();
        //Compare new staff count with old staff count
//        assertEquals("Register failed", newStaffArr.size() - 1, initialStaffCount);
        assertThat(initialStaffCount, equalTo(newStaffArr.size() - 1));
    }
    
    @Test
    public void staffRegisterEmptyInput() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        RegisterStaff rc = new RegisterStaff(new Main(), true);
        assertNotNull(rc);
        //Find JComponent by name set in RegisterCustomer.java
        JButton btnRegister = (JButton) TestUtils.getChildNamed(rc, "btnReg");
        //Check NULL of JComponent
        assertNotNull("Cannot access JButton component (btnReg)", btnRegister);
        //Click Register
        btnRegister.doClick();
        //Get updated staff list
        ArrayList<Staff> newStaffArr = cc.getStaffs();
        //Compare new staff count with old staff count
//        assertEquals("Register failed", initialStaffCount, newStaffArr.size());
        assertThat(initialStaffCount, equalTo(newStaffArr.size()));
    }
    
    @Test
    public void staffRegisterLoginValidInput() {
        //Login
        UserController.getInstance().login("0000", "secret");
        //Initiate frame
        RegisterStaff rs = new RegisterStaff(new Main(), true);
        assertNotNull(rs);
        //Find JComponent by name set in RegisterCustomer.java
        JTextField txtName = (JTextField) TestUtils.getChildNamed(rs, "jtfName");
        JTextField txtAddress = (JTextField) TestUtils.getChildNamed(rs, "jtfAddress");
        JComboBox<String> cmbRank = (JComboBox<String>) TestUtils.getChildNamed(rs, "cRank");
        JRadioButton radioFemale = (JRadioButton) TestUtils.getChildNamed(rs, "jrbFemale");
        JRadioButton radioMale = (JRadioButton) TestUtils.getChildNamed(rs, "jrbMale");
        JComboBox<String> cmbDay = (JComboBox<String>) TestUtils.getChildNamed(rs, "cDay");
        JComboBox<String> cmbMonth = (JComboBox<String>) TestUtils.getChildNamed(rs, "cMonth");
        JComboBox<String> cmbYear = (JComboBox<String>) TestUtils.getChildNamed(rs, "cYear");
        JPasswordField txtPassword = (JPasswordField) TestUtils.getChildNamed(rs, "jpfPassword");
        JButton btnRegister = (JButton) TestUtils.getChildNamed(rs, "btnReg");
        
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
        txtName.setText("Jack");
        txtAddress.setText("No.10 Jalan 10, Kampung Baru, 47000 Sungai Buloh, Selangor.");
        cmbRank.setSelectedIndex(1);
        radioFemale.setSelected(true);
        cmbDay.setSelectedIndex(1);
        cmbMonth.setSelectedIndex(1);
        cmbYear.setSelectedIndex(1);
        txtPassword.setText("123");
        //Post string to text field (for JTextField only)
        txtName.postActionEvent();
        txtAddress.postActionEvent();
        txtPassword.postActionEvent();
        //Click Register
        btnRegister.doClick();
        //Get updated staff list
        ArrayList<Staff> newStaffArr = cc.getStaffs();
        //Get new staff
        Staff staff = newStaffArr.get(newStaffArr.size() - 1);
        //Compare new staff count with old staff count
//        assertEquals("Register failed", newStaffArr.size() - 1, initialStaffCount);
        assertThat(initialStaffCount, equalTo(newStaffArr.size() - 1));
        
        //login using new account
        staffCtrl = StaffController.getInstance();
        boolean loginSuccess = staffCtrl.login(staff.getAccountNumber(), "123");
        assertThat(loginSuccess, is(true));
    }
}
