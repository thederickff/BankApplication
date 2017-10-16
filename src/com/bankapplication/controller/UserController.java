/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.util.Auth;
import com.bankapplication.model.User;
import com.bankapplication.respository.impl.UserRepository;
import java.util.ArrayList;

/**
 * @name UserController
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class UserController {

    private static UserController userCtrl;
    private UserRepository userRepository;
    private ArrayList<User> users;

    private UserController() {
        this.userRepository = new UserRepository();
    }

    /**
     * Makes the authentication by a given account number and a password
     *
     * @param accountNumber The account number of an user
     * @param password The password of an user
     * @return - Whether an user exists in the database
     */
    public boolean login(String accountNumber, String password) {
        users = userRepository.all();
        for (int i = 0; i < users.size(); i++) {
            User tempUser = users.get(i);

            if (tempUser.getAccountNumber().equals(accountNumber)
                    && tempUser.getPassword().equals(password)) {
                
                Auth.setAccountNumber(tempUser.getAccountNumber());
                Auth.setName(tempUser.getName());
                Auth.setType("admin");
                return true;
            }
        }
        return false;
    }

    public User findById(int id) {
        return userRepository.find(id);
    }

    public void store(User user) {
        userRepository.store(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void destroy(User user) {
        userRepository.destroy(user);
    }

    public static UserController getInstance() {
        if (userCtrl == null) {
            userCtrl = new UserController();
        }
        return userCtrl;
    }
    
}
