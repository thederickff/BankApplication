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
import com.github.derickfelix.bankapplication.models.Withdraw;
import com.github.derickfelix.bankapplication.views.Main;
import com.github.derickfelix.bankapplication.views.histories.DepositDetails;
import com.github.derickfelix.bankapplication.views.histories.WithdrawalDetails;
import java.util.ArrayList;
import javax.swing.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
public class DepositIntegrateTest {
    
    public DepositIntegrateTest() {
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
    public void testWithdrawalAndHistoryMethod() {
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
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);
        assertNotNull("Cannot access JButton component (jtbWithdraw)", btnWithdraw);

        txtAccountNumber.setText("5751");
        txtAccountNumber.postActionEvent();
        btnCheck.doClick();
        
        //Declare
        double amountWithdraw = 3.0;
        //Set txtAmount
        txtAmount.setText(Double.toString(amountWithdraw));
        txtAmount.postActionEvent();
        btnWithdraw.setEnabled(true);
        btnWithdraw.doClick();
        //Compare amount setted with last withdrawal
        WithdrawalDetails wd = new WithdrawalDetails(new Main(), true);
        ArrayList<Withdraw> withdrawArr = wd.getAllWithdraw();
        assertThat(withdrawArr.get(withdrawArr.size() - 1).getAmount(), equalTo(amountWithdraw));
    }
}
