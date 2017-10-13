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
    public void deposit(int accountNumber, double amount) {
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + depositTable + " (`account_number`, `deposit_amount`) VALUES (?, ?)";
        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
            pstmt.setDouble(2, amount);

            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
    }

    @Override
    public void withdraw(int accountNumber, double amount) {
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + withdrawTable + " (`account_number`, `withdraw_amount`) VALUES (?, ?)";
        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
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
        String sql = "SELECT * FROM " + withdrawTable;
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
    public ArrayList<Deposit> deposits(int accountNumber) {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + depositTable + " WHERE `account_number` = ?";
        // Intantiate only once
        if (deposits == null) {
            deposits = new ArrayList<>();
        } else {
            deposits.clear();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
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
    public ArrayList<Withdraw> withdraws(int accountNumber) {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + withdrawTable + " WHERE `account_number` = ?";
        // Intantiate only once
        if (withdraws == null) {
            withdraws = new ArrayList<>();
        } else {
            withdraws.clear();
        }
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, accountNumber);
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
        return new Deposit(rs.getString("account_number"), rs.getDouble("deposit_amount"), rs.getDate("created_at"));
    }

    /**
     * Constructs a new Withdraw object
     *
     * @param rs the result set
     * @return a new Withdraw
     * @throws SQLException
     */
    private Withdraw withdrawMapper(ResultSet rs) throws SQLException {
        return new Withdraw(rs.getString("account_number"), rs.getDouble("withdraw_amount"), rs.getDate("created_at"));
    }
}
