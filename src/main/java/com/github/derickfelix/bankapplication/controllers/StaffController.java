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
import com.github.derickfelix.bankapplication.models.Staff;
import com.github.derickfelix.bankapplication.respositories.impl.StaffRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * @author derickfelix
 */
public class StaffController {

    private static StaffController staffCtrl;
    private final StaffRepository staffRepository;
    private List<Staff> staffs;

    private StaffController() {
        this.staffRepository = new StaffRepository();
    }

    /**
     * Makes the authentication by a given account number and a password
     *
     * @param accountNumber The account number of an user
     * @param password The password of an user
     * @return - Whether an staff exists in the database
     */
    public boolean login(String accountNumber, String password) {
        staffs = staffRepository.all();
        for (int i = 0; i < staffs.size(); i++) {
            Staff tempStaff = staffs.get(i);

            if (tempStaff.getAccountNumber().equals(accountNumber)
                    && tempStaff.getPassword().equals(password)) {
                Auth.setAccountNumber(accountNumber);
                Auth.setName(tempStaff.getName());
                Auth.setType("staff");
                return true;
            }
        }
        return false;
    }

    public void store(Staff staff) {
        staffRepository.store(staff);
    }

    public ArrayList<Staff> getStaffs() {
        return staffRepository.all();
    }

    public Staff findById(int id) {
        return staffRepository.find(id);
    }

    public void update(Staff staff) {
        staffRepository.update(staff);
    }

    public void destroy(Staff staff) {
        staffRepository.destroy(staff);
    }

    public static StaffController getInstance() {
        if (staffCtrl == null) {
            staffCtrl = new StaffController();
        }
        return staffCtrl;
    }
}
