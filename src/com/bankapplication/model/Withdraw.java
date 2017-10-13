/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankapplication.model;

import java.util.Date;

/**
 * @name Withdraw
 * @author derickfelix
 * @date Sep 27, 2017
 */
public class Withdraw {

    private String accountNumber;
    private double amount;
    private Date date;
    
    public Withdraw(String accountNumber, double amount, Date date) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.date = date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
