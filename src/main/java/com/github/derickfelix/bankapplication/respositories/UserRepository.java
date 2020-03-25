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
package com.github.derickfelix.bankapplication.respositories;

import com.github.derickfelix.bankapplication.models.User;
import java.util.ArrayList;

/**
 * @author derickfelix
 * Date: Oct 2, 2017
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
