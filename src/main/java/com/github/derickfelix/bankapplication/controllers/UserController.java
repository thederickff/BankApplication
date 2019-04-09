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

import com.github.derickfelix.bankapplication.util.Auth;
import com.github.derickfelix.bankapplication.models.User;
import com.github.derickfelix.bankapplication.respositories.impl.UserRepository;
import java.util.ArrayList;

/**
 * @author derickfelix
 */
public class UserController {

    private static UserController userCtrl;
    private final UserRepository userRepository;
    private ArrayList<User> users;

    private UserController()
    {
        this.userRepository = new UserRepository();
    }

    /**
     * Makes the authentication by a given account number and a password
     *
     * @param accountNumber The account number of an user
     * @param password The password of an user
     * @return - Whether an user exists in the database
     */
    public boolean login(String accountNumber, String password)
    {
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

    public User findById(int id)
    {
        return userRepository.find(id);
    }

    public void store(User user)
    {
        userRepository.store(user);
    }

    public void update(User user)
    {
        userRepository.update(user);
    }

    public void destroy(User user)
    {
        userRepository.destroy(user);
    }

    public static UserController getInstance()
    {
        if (userCtrl == null) {
            userCtrl = new UserController();
        }
        return userCtrl;
    }

}
