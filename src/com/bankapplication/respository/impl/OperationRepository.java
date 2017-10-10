/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository.impl;

import com.bankapplication.model.Deposit;
import com.bankapplication.model.Withdraw;
import com.bankapplication.respository.IOperationRepository;
import java.sql.Connection;
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
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + depositTable + " (`customer_id`, `deposit_amount`) VALUES (?, ?)";
        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            pstmt.setDouble(2, amount);

            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
    }

    @Override
    public void withdraw(int customerId, double amount) {
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + withdrawTable + " (`customer_id`, `withdraw_amount`) VALUES (?, ?)";
        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            pstmt.setDouble(2, amount);

            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
    }

    @Override
    public ArrayList<Deposit> deposits() {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + depositTable;
        // Intantiate only once
        if (deposits == null) {
            deposits = new ArrayList<>();
        } else {
            deposits.clear();
        }
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                deposits.add(depositMapper(rs));
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return deposits;
    }

    @Override
    public ArrayList<Withdraw> withdraws() {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + depositTable;
        // Intantiate only once
        if (withdraws == null) {
            withdraws = new ArrayList<>();
        } else {
            withdraws.clear();
        }
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                withdraws.add(withdrawMapper(rs));
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return withdraws;
    }

    @Override
    public ArrayList<Deposit> deposits(int customerId) {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + depositTable + " WHERE `customer_id` = ?";
        // Intantiate only once
        if (deposits == null) {
            deposits = new ArrayList<>();
        } else {
            deposits.clear();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();
           
            while (rs.next()) {
                deposits.add(depositMapper(rs));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return deposits;
    }

    @Override
    public ArrayList<Withdraw> withdraws(int customerId) {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + withdrawTable + " WHERE `customer_id` = ?";
        // Intantiate only once
        if (withdraws == null) {
            withdraws = new ArrayList<>();
        } else {
            withdraws.clear();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                withdraws.add(withdrawMapper(rs));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return withdraws;
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
