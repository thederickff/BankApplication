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
import com.github.derickfelix.bankapplication.models.Deposit;
import com.github.derickfelix.bankapplication.views.Main;
import com.github.derickfelix.bankapplication.views.histories.DepositDetails;
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
 * @author ivan
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

        DepositOperation DO = new DepositOperation(new Main(), true);

        assertNotNull(DO);

        JTextField txtAccountNumber = (JTextField) TestUtils.getChildNamed(DO, "jtfAccNum");
        JTextField txtName = (JTextField) TestUtils.getChildNamed(DO, "jtfName");
        JTextField txtPreviousWithdraw = (JTextField) TestUtils.getChildNamed(DO, "jtfPrevDeposit");
        JTextField txtTotalBalance = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalBalance");
        JTextField txtAmount = (JTextField) TestUtils.getChildNamed(DO, "jtfTotalAmount");
        JButton btnCheck = (JButton) TestUtils.getChildNamed(DO, "jtbCheck");
        JButton btnDeposit = (JButton) TestUtils.getChildNamed(DO, "jtbDeposit");
        assertNotNull("Cannot access JTextField component (jtfAccNum)", txtAccountNumber);
        assertNotNull("Cannot access JTextField component (jtfName)", txtName);
        assertNotNull("Cannot access JTextField component (jtfPrevWith)", txtPreviousWithdraw);
        assertNotNull("Cannot access JTextField component (jtfTotalBalance)", txtTotalBalance);
        assertNotNull("Cannot access JTextField component (jtfTotalAmount)", txtAmount);
        assertNotNull("Cannot access JButton component (btnCheck)", btnCheck);
        assertNotNull("Cannot access JButton component (jtbDeposit)", btnDeposit);

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
        //Compare amount setted with last withdrawal
        DepositDetails dd = new DepositDetails(new Main(), true);
        ArrayList<Deposit> depositArr = dd.getAllDeposit();
        assertThat(depositArr.get(depositArr.size() - 1).getAmount(), equalTo(amountDeposit));
    }
}