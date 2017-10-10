/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.model.Deposit;
import com.bankapplication.model.Withdraw;
import com.bankapplication.respository.impl.OperationRepository;
import java.util.ArrayList;

/**
 * @name OperationController
 * @author derickfelix
 * @date Oct 9, 2017
 */
public class OperationController {

    private OperationRepository operationRepository;
    private ArrayList<Withdraw> withdraws;
    private ArrayList<Deposit> deposits;

    public OperationController() {
            this.operationRepository = new OperationRepository();
    }

    public void makeDeposit(int customer_id, double amount) {
        this.operationRepository.deposit(customer_id, amount);
    }

    public void makeWithdraw(int customer_id, double amount) {
        if (amount <= getBalance(customer_id)) {
            this.operationRepository.withdraw(customer_id, amount);
        } else {
            System.out.println("Error: You have not money enough!");
        }
    }
    
    public double getBalance(int customer_id) {
        double balance = 0;
        withdraws = this.operationRepository.withdraws(customer_id);
        deposits = this.operationRepository.deposits(customer_id);

        for (int i = 0; i < deposits.size(); i++) {
            balance += deposits.get(i).getAmount();
        }
        for (int i = 0; i < withdraws.size(); i++) {
            balance -= withdraws.get(i).getAmount();
        }
        
        return balance;
    }
}
