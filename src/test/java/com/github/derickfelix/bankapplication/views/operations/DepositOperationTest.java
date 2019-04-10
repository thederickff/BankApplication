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
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ivan
 */
public class DepositOperationTest {

    /**
     *
     */
    public DepositOperationTest() {
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
    public void checkAccNumWithValidInput() {
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        DepositOperation DO = new DepositOperation(new Main(), true);

        assertNotNull(DO);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(DO, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(DO, "jtfName");
        JTextField txtPreviousDeposit = (JTextField) TestUtils.getChildNamed(DO, "jtfPrevDeposit");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(DO, "jtbCheck");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevDeposit)", txtPreviousDeposit);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);

        txtAccountNumber.setText("10374");
        int accountNum = Integer.parseInt(txtAccountNumber.getText());
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(accountNum);

        txtName.setText(customer.getName());
        txtPreviousDeposit.setText(String.valueOf(oc.getPreviousDeposit(accountNum)));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(accountNum)));

        txtName.postActionEvent();
        txtPreviousDeposit.postActionEvent();
        txtTotalBalance.postActionEvent();

        assertNotNull(customer);
    }

    @Test
    public void checkAccNumWithInvalidInput() {
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        DepositOperation DO = new DepositOperation(new Main(), true);

        assertNotNull(DO);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(DO, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(DO, "jtfName");
        JTextField txtPreviousDeposit = (JTextField) TestUtils.getChildNamed(DO, "jtfPrevDeposit");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(DO, "jtbCheck");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevDeposit)", txtPreviousDeposit);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);

        txtAccountNumber.setText("12345");
        String accountNum = txtAccountNumber.getText();
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(Integer.parseInt(accountNum));

        txtName.setText(customer.getName());
        txtPreviousDeposit.setText(String.valueOf(oc.getPreviousDeposit(Integer.parseInt(accountNum))));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(Integer.parseInt(accountNum))));

        assertNotNull(customer);
    }

    @Test
    public void checkDepositFuncWithValidInput() {
        
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        DepositOperation DO = new DepositOperation(new Main(), true);
        JButton btnDeposit = (JButton) TestUtils.getChildNamed(DO, "jtbDeposit");
        assertNotNull(DO);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(DO, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(DO, "jtfName");
        JTextField txtPreviousDeposit = (JTextField) TestUtils.getChildNamed(DO, "jtfPrevDeposit");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(DO, "jtbCheck");
        JButton btnWithdraw = (JButton) TestUtils.getChildNamed(DO, "jtbDeposit");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevDeposit)", txtPreviousDeposit);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (jtbCheck)", btnCheck);
        assertNotNull("Cannot access JButton component (jtbWithdraw)", btnWithdraw);

        txtAccountNumber.setText("10374");
        txtAccountNumber.postActionEvent();
        btnCheck.doClick();
        
        //Declare
        double amountDeposit = 50.0;
        //Set txtAmount
        txtAmount.setText(Double.toString(amountDeposit));
        txtAmount.postActionEvent();
        btnDeposit.setEnabled(true);
        btnDeposit.doClick();

    }
    
    @Test
    public void checkEmptyAccountNumber(){
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        DepositOperation DO = new DepositOperation(new Main(), true);

        assertNotNull(DO);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(DO, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(DO, "jtfName");
        JTextField txtPreviousDeposit = (JTextField) TestUtils.getChildNamed(DO, "jtfPrevDeposit");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(DO, "jtbCheck");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevDeposit)", txtPreviousDeposit);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);

        txtAccountNumber.setText("");
        String accountNum = txtAccountNumber.getText();
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(Integer.parseInt(accountNum));

        txtName.setText(customer.getName());
        txtPreviousDeposit.setText(String.valueOf(oc.getPreviousDeposit(Integer.parseInt(accountNum))));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(Integer.parseInt(accountNum))));

        txtName.postActionEvent();
        txtPreviousDeposit.postActionEvent();
        txtTotalBalance.postActionEvent();

        assertNotNull("Account number can't be null.", customer);
    }
    
   @Test
    public void testCancelMethod() {
        //Add manually
            //Login
        UserController.getInstance().login("0000", "secret");
            //Initiate frame
        DepositOperation DO = new DepositOperation(new Main(), true);
        assertNotNull(DO);
            
        JButton btnCancel = (JButton) TestUtils.getChildNamed(DO, "btnCcl");
            //Check NULL of JComponent
        assertNotNull("Cannot access JButton component (btnCcl)", btnCancel);
        
        btnCancel.doClick();
        assertFalse("Deposit window did not dispose", DO.isDisplayable());
    }
}
