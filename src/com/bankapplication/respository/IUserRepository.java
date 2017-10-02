/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankapplication.respository;

import com.bankapplication.model.User;
import java.util.ArrayList;

/**
 * @name IUserRepository
 * @author derickfelix
 * @date Oct 2, 2017
 */
public interface IUserRepository {

    /**
     * Gets all the users of the database
     * 
     * @return - A List of User
     */
    public ArrayList<User> all();

    /**
     * Gets a user in the database by specifying the id
     *
     * @param id the id of the User
     * @return - A User
     */
    public User find(int id);

    /**
     * Updates a specific user in the database
     *
     * @param user the User to update
     */
    public void update(User user);

    /**
     * Stores a new user in the database
     *
     * @param user the User to be stored
     */
    public void store(User user);

    /**
     * Destroy a user of the database
     *
     * @param user the User to be destroyed
     */
    public void destroy(User user);

}
