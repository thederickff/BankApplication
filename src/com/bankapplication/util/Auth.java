/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.util;

/**
 * @name Authenticated
 * @author derickfelix
 * @date Oct 14, 2017
 */
public class Auth {

    private static String accountNumber;
    private static String name;
    private static String type;

    public static String name() {
        return name;
    }

    public static String accountNumber() {
        return accountNumber;
    }

    public static String type() {
        return type;
    }

    public static void setAccountNumber(String accountNumber) {
        Auth.accountNumber = accountNumber;
    }

    public static void setName(String name) {
        Auth.name = name;
    }

    public static void setType(String type) {
        Auth.type = type;
    }

}
