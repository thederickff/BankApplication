/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.util.Auth;
import com.bankapplication.model.Staff;
import com.bankapplication.respository.impl.StaffRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * @name StaffController
 * @author derickfelix
 * @date Oct 4, 2017
 */
public class StaffController {

    private static StaffController staffCtrl;
    private StaffRepository staffRepository;
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
