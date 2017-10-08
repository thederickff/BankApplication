/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository;

import com.bankapplication.model.Deposit;
import com.bankapplication.model.Withdraw;
import java.util.ArrayList;

/**
 *
 * @author derickfelix
 */
public interface IOperationRepository {

    /**
     * Stores a new deposit in the database
     *
     * @param customerId the customer id
     * @param amount the amount to be deposited
     */
    public void deposit(int customerId, double amount);

    /**
     * Stores a new withdraw in the database
     *
     * @param customerId the customer id
     * @param amount the amount to be withdrawn
     */
    public void withdraw(int customerId, double amount);

    /**
     * Gets all the deposits
     *
     * @return a list with all the deposits made
     */
    public ArrayList<Deposit> deposits();

    /**
     * Gets all the withdraws
     *
     * @return a list with all the withdraws made
     */
    public ArrayList<Withdraw> withdraws();

    /**
     * Gets all the deposits of a customer
     *
     * @param customerId the customer id
     * @return a list with all the deposits made by a specific customer
     */
    public ArrayList<Deposit> deposits(int customerId);

    /**
     * Gets all the withdraws of a customer
     *
     * @param customerId the customer id
     * @return a list with all the withdraws made by a specific customer
     */
    public ArrayList<Withdraw> withdraws(int customerId);

}
