/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.controller;

import com.bankapplication.model.Staff;
import com.bankapplication.respository.impl.StaffRepository;
import java.util.ArrayList;

/**
 * @name StaffController
 * @author derickfelix
 * @date Oct 4, 2017
 */
public class StaffController {

    private static StaffController staffCtrl;
    private StaffRepository staffRepository;

    private StaffController() {
        this.staffRepository = new StaffRepository();
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
