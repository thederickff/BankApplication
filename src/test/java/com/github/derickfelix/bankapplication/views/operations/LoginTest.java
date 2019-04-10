/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.derickfelix.bankapplication.views.operations;

import Test.TestUtils;
import com.github.derickfelix.bankapplication.controllers.UserController;
import com.github.derickfelix.bankapplication.models.User;
import com.github.derickfelix.bankapplication.views.Login;
import com.github.derickfelix.bankapplication.views.Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
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
 * @author Li Ho
 */
public class LoginTest {
    
    public LoginTest() {
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

    /**
     * Test of login method, of class UserController.
     */
    @Test
    public void testValidLogin() {
        System.out.println("Login with Valid Credentials Test");
        String accountNumber = "0000";
        String password = "secret";
        UserController userControlInstance = new UserController();
        boolean expResult = true;
        boolean result = userControlInstance.login(accountNumber, password);
        assertEquals(expResult, result);
    }
    
    public String[] generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+4]; // words of length 4 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }
    
    @Test
    public void testInvalidLogin() {
        System.out.println("Login with Bad Credentials Test");
        String accountNumber = "";
        String password = "";
        Random random = new Random();
        UserController userControlInstance = new UserController();
        boolean expResult = false;
        boolean result;
        
        ArrayList<String> accountNoList = new ArrayList<String>();
        
        
        String[] randomPassword = generateRandomWords(10000);
        
        for(int i = 0; i < 10000; i++){
            accountNumber = String.format("%04d", random.nextInt(9999));
            accountNoList.add(accountNumber);
            password = randomPassword[i];
            if(!(accountNumber.equals("0000") && password.equals("secret"))){
                result = userControlInstance.login(accountNumber, password);
                assertEquals(expResult, result);                 
            }
        }
        System.out.println("Tested with 10 thousands of permutation and combinations of account no. and password");
        System.out.println("\nFirst 10 combinations:");
        System.out.println("\nno.\tAccount no.\tPassword");
        for(int i = 0; i < 10; i++){
            System.out.println(String.format("%2d.\t%s\t\t%s", i+1, accountNoList.get(i), randomPassword[i]));
        }
        
    }
    
    @Test
    public void testSQLInjectionAttack() {
        System.out.println("Login with SQL Injection Attack Test");
        String accountNumber = "0000' or '1'='1";
        String password = "secret";
        UserController userControlInstance = new UserController();
        boolean expResult = false;
        boolean result = userControlInstance.login(accountNumber, password);
        assertEquals(expResult, result);
        
        accountNumber = "0000";
        password = "secret' or '1'='1";
        result = userControlInstance.login(accountNumber, password);
        assertEquals("Safe from SQL Injection Attack.", expResult, result);        
        System.out.println("Safe from SQL Injection Attack.");
    }    
    
    @Test
    public void testPasswordEncrption() {
        System.out.println("Password Encryption Test");
        boolean expResult = true;
        boolean result;
        
        //Initiate frame
        Login loginFrame = new Login(new javax.swing.JFrame(), true);
        //assertNotNull(loginFrame);        
        JTextField txtAccount = (JTextField) TestUtils.getChildNamed(loginFrame, "txtAccount");
        JTextField txtPassword = (JTextField) TestUtils.getChildNamed(loginFrame, "txtPassword");        
        JButton btnLogin = (JButton) TestUtils.getChildNamed(loginFrame, "btnLogin");   
        
        txtAccount.setText("0000");txtPassword.setText("secret");
        btnLogin.doClick();

        // 1. It is encrypted of the password that is send to server, if the password value is NOT same as the value after clicked.
        // 2. It is not encrypted of the password that is send to server, if the password value IS same as the value after clicked.
        // We need to secure our BANK system to avoid hacker to get the plain password string
        if(txtPassword.getText().equals("secret")){
            result = false;
        }
        else{
            result = true;
        }
        //result = !txtPassword.getText().equals("secret");
        assertEquals("The password is not encrypted.", expResult, result);

    }     
    
}
