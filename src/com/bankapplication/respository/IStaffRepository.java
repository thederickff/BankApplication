/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository;

import com.bankapplication.model.Staff;
import java.util.ArrayList;

/**
 * @name IStaffRepository
 * @author derickfelix
 * @date Oct 4, 2017
 */
public interface IStaffRepository {

    /**
     * Gets all the staffs of the database
     *
     * @return - A List of Staffs
     */
    public ArrayList<Staff> all();

    /**
     * Gets a staff in the database by specifying the id
     *
     * @param id the id of the staff
     * @return - A Staff
     */
    public Staff find(int id);

    /**
     * Updates a specific staff in the database
     *
     * @param staff the Staff to update
     */
    public void update(Staff staff);

    /**
     * Stores a new staff in the database
     *
     * @param staff the Staff to be stored
     */
    public void store(Staff staff);

    /**
     * Destroy a staff of the database
     *
     * @param staff the Staff to be destroyed
     */
    public void destroy(Staff staff);

}
