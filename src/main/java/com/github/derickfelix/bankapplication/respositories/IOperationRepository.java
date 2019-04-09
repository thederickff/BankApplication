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

import com.github.derickfelix.bankapplication.models.Deposit;
import com.github.derickfelix.bankapplication.models.Withdraw;
import java.util.ArrayList;

/**
 *
 * @author derickfelix
 */
public interface IOperationRepository {

    /**
     * Stores a new deposit in the database
     *
     * @param customerId the customer id
     * @param amount the amount to be deposited
     */
    void deposit(int customerId, double amount);

    /**
     * Stores a new withdraw in the database
     *
     * @param customerId the customer id
     * @param amount the amount to be withdrawn
     */
    void withdraw(int customerId, double amount);

    /**
     * Gets all the deposits
     *
     * @return a list with all the deposits made
     */
    ArrayList<Deposit> deposits();

    /**
     * Gets all the withdraws
     *
     * @return a list with all the withdraws made
     */
    ArrayList<Withdraw> withdraws();

    /**
     * Gets all the deposits of a customer
     *
     * @param customerId the customer id
     * @return a list with all the deposits made by a specific customer
     */
    ArrayList<Deposit> deposits(int customerId);

    /**
     * Gets all the withdraws of a customer
     *
     * @param customerId the customer id
     * @return a list with all the withdraws made by a specific customer
     */
    ArrayList<Withdraw> withdraws(int customerId);

}
