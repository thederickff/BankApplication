/*
 * The MIT License
 *
 * Copyright 2019 Derick Felix.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.derickfelix.bankapplication.controllers;

import com.github.derickfelix.bankapplication.models.Deposit;
import com.github.derickfelix.bankapplication.models.Withdraw;
import com.github.derickfelix.bankapplication.respositories.impl.OperationRepository;
import java.util.ArrayList;

/**
 * @author derickfelix
 */
public class OperationController {

    private static OperationController operationCtrl;
    private final OperationRepository operationRepository;
    private ArrayList<Withdraw> withdraws;
    private ArrayList<Deposit> deposits;

    private OperationController()
    {
        this.operationRepository = new OperationRepository();
    }

    public boolean makeDeposit(int accountNumber, double amount)
    {
        this.operationRepository.deposit(accountNumber, amount);
        return true;
    }

    public boolean makeWithdraw(int accountNumber, double amount)
    {
        if ((float) amount <= getBalance(accountNumber)) {
            this.operationRepository.withdraw(accountNumber, amount);
            return true;
        }
        return false;
    }

    public double getBalance(int accountNumber)
    {
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

    public double getPreviousDeposit(int accountNumber)
    {
        deposits = this.operationRepository.deposits(accountNumber);
        if (deposits.size() > 0) {
            return deposits.get(deposits.size() - 1).getAmount();
        }
        return 0;
    }

    public double getPreviousWithdraw(int accountNumber)
    {
        withdraws = this.operationRepository.withdraws(accountNumber);
        if (withdraws.size() > 0) {
            return withdraws.get(withdraws.size() - 1).getAmount();
        }
        return 0;
    }

    public ArrayList<Withdraw> getAllWithdraws()
    {
        withdraws = this.operationRepository.withdraws();
        return withdraws;
    }

    public ArrayList<Deposit> getAllDeposits()
    {
        deposits = this.operationRepository.deposits();
        return deposits;
    }

    public static OperationController getInstance()
    {
        if (operationCtrl == null) {
            operationCtrl = new OperationController();
        }
        return operationCtrl;
    }
}
