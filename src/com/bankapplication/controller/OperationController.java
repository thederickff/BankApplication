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

    private static OperationController operationCtrl;
    private OperationRepository operationRepository;
    private ArrayList<Withdraw> withdraws;
    private ArrayList<Deposit> deposits;

    private OperationController() {
        this.operationRepository = new OperationRepository();
    }

    public boolean makeDeposit(int accountNumber, double amount) {
        this.operationRepository.deposit(accountNumber, amount);
        return true;
    }

    public boolean makeWithdraw(int accountNumber, double amount) {
        if ((float) amount <= getBalance(accountNumber)) {
            this.operationRepository.withdraw(accountNumber, amount);
            return true;
        }
        return false;
    }

    public double getBalance(int accountNumber) {
        double balance = 0;
        withdraws = this.operationRepository.withdraws(accountNumber);
        deposits = this.operationRepository.deposits(accountNumber);

        for (int i = 0; i < deposits.size(); i++) {
            balance += deposits.get(i).getAmount();
        }
        for (int i = 0; i < withdraws.size(); i++) {
            balance -= withdraws.get(i).getAmount();
        }

        return balance;
    }

    public double getPreviousDeposit(int accountNumber) {
        deposits = this.operationRepository.deposits(accountNumber);
        if (deposits.size() > 0) {
            return deposits.get(deposits.size() - 1).getAmount();
        }
        return 0;
    }

    public double getPreviousWithdraw(int accountNumber) {
        withdraws = this.operationRepository.withdraws(accountNumber);
        if (withdraws.size() > 0) {
            return withdraws.get(withdraws.size() - 1).getAmount();
        }
        return 0;
    }

    public ArrayList<Withdraw> getAllWithdraws() {
        withdraws = this.operationRepository.withdraws();
        return withdraws;
    }

    public ArrayList<Deposit> getAllDeposits() {
        deposits = this.operationRepository.deposits();
        return deposits;
    }

    public static OperationController getInstance() {
        if (operationCtrl == null) {
            operationCtrl = new OperationController();
        }
        return operationCtrl;
    }
}
