/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository.impl;

import com.bankapplication.model.Deposit;
import com.bankapplication.model.Withdraw;
import com.bankapplication.respository.IOperationRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @name OperationRepository
 * @author derickfelix
 * @date Oct 8, 2017
 */
public class OperationRepository extends BaseRepository implements IOperationRepository {

    private final String depositTable = "`deposits`";
    private final String withdrawTable = "`withdraws`";
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;

    @Override
    public void deposit(int customerId, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void withdraw(int customerId, double amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Deposit> deposits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Withdraw> withdraws() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Deposit> deposits(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Withdraw> withdraws(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Constructs a new Deposit object
     *
     * @param rs the result set
     * @return a new Deposit
     * @throws SQLException
     */
    private Deposit depositMapper(ResultSet rs) throws SQLException {
        return new Deposit(rs.getString("customer_id"), rs.getDouble("deposit_amount"));
    }

    /**
     * Constructs a new Withdraw object
     *
     * @param rs the result set
     * @return a new Withdraw
     * @throws SQLException
     */
    private Withdraw withdrawMapper(ResultSet rs) throws SQLException {
        return new Withdraw(rs.getString("customer_id"), rs.getDouble("withdraw_amount"));
    }
}
