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
 * @author hanzo
 */
public class WithdrawOperationTest {

    public WithdrawOperationTest() {
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

        WithdrawOperation wo = new WithdrawOperation(new Main(), true);

        assertNotNull(wo);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(wo, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(wo, "jtfName");
        JTextField txtPreviousWithdraw = (JTextField) TestUtils.getChildNamed(wo, "jtfPrevWith");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(wo, "jtbCheck");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevWith)", txtPreviousWithdraw);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);

        txtAccountNumber.setText("5751");
        int accountNum = Integer.parseInt(txtAccountNumber.getText());
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(accountNum);

        txtName.setText(customer.getName());
        txtPreviousWithdraw.setText(String.valueOf(oc.getPreviousWithdraw(accountNum)));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(accountNum)));

        txtName.postActionEvent();
        txtPreviousWithdraw.postActionEvent();
        txtTotalBalance.postActionEvent();

        assertNotNull(customer);
    }

    @Test
    public void checkAccNumWithAlphabet() {
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        WithdrawOperation wo = new WithdrawOperation(new Main(), true);

        assertNotNull(wo);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(wo, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(wo, "jtfName");
        JTextField txtPreviousWithdraw = (JTextField) TestUtils.getChildNamed(wo, "jtfPrevWith");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(wo, "jtbCheck");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevWith)", txtPreviousWithdraw);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);

        txtAccountNumber.setText("aaa");
        String accountNum = txtAccountNumber.getText();
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(Integer.parseInt(accountNum));

        txtName.setText(customer.getName());
        txtPreviousWithdraw.setText(String.valueOf(oc.getPreviousWithdraw(Integer.parseInt(accountNum))));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(Integer.parseInt(accountNum))));

        assertNotNull(customer);
    }

    @Test
    public void checkWithdrawFuncWithValidInput() {
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        WithdrawOperation wo = new WithdrawOperation(new Main(), true);

        assertNotNull(wo);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(wo, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(wo, "jtfName");
        JTextField txtPreviousWithdraw = (JTextField) TestUtils.getChildNamed(wo, "jtfPrevWith");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(wo, "jtbCheck");
        JButton btnWithdraw = (JButton) TestUtils.getChildNamed(wo, "jtbWithdraw");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevWith)", txtPreviousWithdraw);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (jtbCheck)", btnCheck);
        assertNotNull("Cannot access JButton component (jtbWithdraw)", btnWithdraw);

        txtAccountNumber.setText("5751");
        int accountNum = Integer.parseInt(txtAccountNumber.getText());
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(accountNum);
        Boolean check = true;

        assertNotNull(customer);

        txtName.setText(customer.getName());
        txtPreviousWithdraw.setText(String.valueOf(oc.getPreviousWithdraw(accountNum)));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(accountNum)));
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

    @Test
    public void checkWithdrawFuncWithLargeInput() {
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        WithdrawOperation wo = new WithdrawOperation(new Main(), true);

        assertNotNull(wo);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(wo, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(wo, "jtfName");
        JTextField txtPreviousWithdraw = (JTextField) TestUtils.getChildNamed(wo, "jtfPrevWith");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(wo, "jtbCheck");
        JButton btnWithdraw = (JButton) TestUtils.getChildNamed(wo, "jtbWithdraw");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevWith)", txtPreviousWithdraw);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (jtbCheck)", btnCheck);
        assertNotNull("Cannot access JButton component (jtbWithdraw)", btnWithdraw);

        txtAccountNumber.setText("5751");
        int accountNum = Integer.parseInt(txtAccountNumber.getText());
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(accountNum);
        Boolean check = true;

        assertNotNull(customer);
        txtName.setText(customer.getName());
        txtPreviousWithdraw.setText(String.valueOf(oc.getPreviousWithdraw(accountNum)));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(accountNum)));

        txtAmount.setText("999999");
        int withAmount = Integer.parseInt(txtAmount.getText());
        double balance = oc.getBalance(accountNum);
        btnWithdraw.doClick();
        oc.makeWithdraw(accountNum, withAmount);
        
        if(withAmount > balance){
            check = false;
        }
        
        assertTrue("Sorry, you have not money enough.", check);
        
    }
    
    @Test
    public void checkEmptyAccountNumber(){
        OperationController oc = OperationController.getInstance();
        CustomerController cc = CustomerController.getInstance();
        UserController.getInstance().login("0000", "secret");

        WithdrawOperation wo = new WithdrawOperation(new Main(), true);

        assertNotNull(wo);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(wo, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(wo, "jtfName");
        JTextField txtPreviousWithdraw = (JTextField) TestUtils.getChildNamed(wo, "jtfPrevWith");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(wo, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(wo, "jtbCheck");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevWith)", txtPreviousWithdraw);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);

        txtAccountNumber.setText("");
        String accountNum = txtAccountNumber.getText();
        btnCheck.doClick();
        Customer customer = cc.searchCustomer(Integer.parseInt(accountNum));

        txtName.setText(customer.getName());
        txtPreviousWithdraw.setText(String.valueOf(oc.getPreviousWithdraw(Integer.parseInt(accountNum))));
        txtTotalBalance.setText(String.valueOf(oc.getBalance(Integer.parseInt(accountNum))));

        txtName.postActionEvent();
        txtPreviousWithdraw.postActionEvent();
        txtTotalBalance.postActionEvent();

        assertNotNull("Account number can't be null.", customer);
    }
    

}
