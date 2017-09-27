/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankapplication.model;

/**
 * @name Customer
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class Customer {
    private String accountNumber;
    private String name;
    private String address;
    private String accountType;
    private char sex;
    private String dob;
    private String password;

    public Customer(String accountNumber, String name, String address, String accountType, char sex, String dob) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.accountType = accountType;
        this.sex = sex;
        this.dob = dob;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
