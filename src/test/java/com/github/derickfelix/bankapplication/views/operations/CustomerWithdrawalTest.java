/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import Test.TestUtils;
import com.github.derickfelix.bankapplication.controllers.CustomerController;
import com.github.derickfelix.bankapplication.controllers.OperationController;
import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.models.Customer;
import com.github.derickfelix.bankapplication.views.Main;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hanzo
 */
public class CustomerWithdrawalTest {

    public CustomerWithdrawalTest() {
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
    public void newCustomerWithdrawTest() {
        //Register customer
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        RegisterCustomer rc = new RegisterCustomer(new Main(), true);

        assertNotNull(rc);

        int prevSize = cc.getCustomers().size();

        JTextField txtName = (JTextField) TestUtils.getChildNamed(rc, "jtfName");
        JTextField txtAddress = (JTextField) TestUtils.getChildNamed(rc, "jtfAddress");
        JComboBox<String> cmbAccount = (JComboBox<String>) TestUtils.getChildNamed(rc, "cAcc");
        JRadioButton radioFemale = (JRadioButton) TestUtils.getChildNamed(rc, "jrbFemale");
        JRadioButton radioMale = (JRadioButton) TestUtils.getChildNamed(rc, "jrbMale");
        JComboBox<String> cmbDay = (JComboBox<String>) TestUtils.getChildNamed(rc, "cDay");
        JComboBox<String> cmbMonth = (JComboBox<String>) TestUtils.getChildNamed(rc, "cMonth");
        JComboBox<String> cmbYear = (JComboBox<String>) TestUtils.getChildNamed(rc, "cYear");
        JPasswordField txtPassword = (JPasswordField) TestUtils.getChildNamed(rc, "jpfPassword");
        JButton btnRegister = (JButton) TestUtils.getChildNamed(rc, "btnReg");
        JButton btnClear = (JButton) TestUtils.getChildNamed(rc, "btnClr");
        JButton btnCancel = (JButton) TestUtils.getChildNamed(rc, "btnCcl");

        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfAddress)", txtAddress);
        assertNotNull("Cannot access JComboBox component (cAcc)", cmbAccount);
        assertNotNull("Cannot access JRadioButton component (jrbFemale)", radioFemale);
        assertNotNull("Cannot access JRadioButton component (jrbMale)", radioMale);
        assertNotNull("Cannot access JComboBox component (cDay)", cmbDay);
        assertNotNull("Cannot access JComboBox component (cMonth)", cmbMonth);
        assertNotNull("Cannot access JComboBox component (cYear)", cmbYear);
        assertNotNull("Cannot access JPasswordField component (jpfPassword)", txtPassword);
        assertNotNull("Cannot access JButton component (btnReg)", btnRegister);
        assertNotNull("Cannot access JButton component (btnClr)", btnClear);
        assertNotNull("Cannot access JButton component (btnCcl)", btnCancel);

        String name = "Adam";
        String address = "No. 1, Jalan Daya 11, Taman Daya, Kepong 52100, Kuala Lumpur.";
        String password = "12345678";

        txtName.setText(name);
        txtAddress.setText(address);
        cmbAccount.setSelectedIndex(1);
        radioMale.setSelected(true);
        cmbDay.setSelectedIndex(10);
        cmbMonth.setSelectedIndex(12);
        cmbYear.setSelectedIndex(2);
        txtPassword.setText(password);

        txtName.postActionEvent();
        txtAddress.postActionEvent();
        txtPassword.postActionEvent();

        btnRegister.doClick();

        int currSize = cc.getCustomers().size();
        boolean regSuccess = false;

        if (currSize - prevSize == 1) {
            regSuccess = true;
        }
        assertTrue("Register Failed", regSuccess);

        //DepositOperation
        DepositOperation DO = new DepositOperation(new Main(), true);
        assertNotNull(DO);
        
        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(DO, "jtfAccNum");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(DO, "jtbCheck");
        JButton btnDeposit = (JButton) TestUtils.getChildNamed(DO, "jtbDeposit");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (jtbCheck)", btnCheck);
        assertNotNull("Cannot access JButton component (jtbDeposit)", btnDeposit);
        
        Customer customer = cc.getCustomers().get(currSize - 1);
        assertNotNull(customer);

        UserController.getInstance().login("0000", "secret");

        txtAccountNumber.setText(customer.getAccountNumber());
        txtAccountNumber.postActionEvent();
        btnCheck.doClick();

        double amountDeposit = 1000;
        
        txtAmount.setText(Double.toString(amountDeposit));
        txtAmount.postActionEvent();
        btnDeposit.setEnabled(true);
        btnDeposit.doClick();
        
        //WithdrawOperation
        OperationController oc = OperationController.getInstance();

        WithdrawOperation wo = new WithdrawOperation(new Main(), true);

        assertNotNull(wo);
        
        JButton btnWithdraw = (JButton) TestUtils.getChildNamed(wo, "jtbWithdraw");
        assertNotNull("Cannot access JButton component (jtbWithdraw)", btnWithdraw);

        txtAccountNumber.setText(customer.getAccountNumber());
        int accountNum = Integer.parseInt(txtAccountNumber.getText());
        btnCheck.doClick();
        
        Boolean check = true;

        assertNotNull(customer);

        txtAmount.setText("50");
        int withAmount = Integer.parseInt(txtAmount.getText());
        double balance = oc.getBalance(accountNum);
        btnWithdraw.doClick();
        oc.makeWithdraw(accountNum, withAmount);
        
        if(withAmount > balance){
            check = false;
        }
        
        assertTrue("Sorry, you have not money enough.", check);


    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
