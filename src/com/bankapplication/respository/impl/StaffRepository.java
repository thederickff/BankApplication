/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository.impl;

import com.bankapplication.model.Staff;
import com.bankapplication.respository.IStaffRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @name StaffRepository
 * @author derickfelix
 * @date Oct 4, 2017
 */
public class StaffRepository extends BaseRepository implements IStaffRepository {

    private final String table = "`staffs`";
    private ArrayList<Staff> staffs;

    @Override
    public ArrayList<Staff> all() {
        Connection conn = connectionManager.createConnection();
        String sql = "select * from " + table;
        // Intantiate only once
        if (staffs == null) {
            staffs = new ArrayList<>();
        } else {
            staffs.clear();
        }

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                staffs.add(staffMapper(rs));
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
        return staffs;
    }

    @Override
    public Staff find(int id) {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + table + " WHERE `id` = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                return staffMapper(rs);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
        return null;
    }

    @Override
    public void update(Staff staff) {
        Connection conn = connectionManager.createConnection();
        String sql = "UPDATE " + table + "SET `name` = ?, `address` = ?, `sex` = ?, `born_date` = ?, `rank` = ? WHERE `id` = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getAddress());
            pstmt.setString(3, Character.toString(staff.getSex()));
            pstmt.setString(4, staff.getDob());
            pstmt.setString(5, staff.getRank());
            pstmt.setString(6, staff.getStaffId());
            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
    }

    @Override
    public void store(Staff staff) {
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + table + " (`account_number`, `name`, `address`, `sex`, `born_date`, `rank`, `password`) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            // Prepare Statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, staff.getAccountNumber());
            pstmt.setString(2, staff.getName());
            pstmt.setString(3, staff.getAddress());
            pstmt.setString(4, Character.toString(staff.getSex()));
            pstmt.setString(5, staff.getDob());
            pstmt.setString(6, staff.getRank());
            pstmt.setString(7, staff.getPassword());
            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
    }

    @Override
    public void destroy(Staff staff) {
        Connection conn = connectionManager.createConnection();
        String sql = "DELETE FROM " + table + " WHERE `id` = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, staff.getStaffId());
            pstmt.execute();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }

    }

    /**
     * Constructs a new Staff object
     * 
     * @param rs the result set
     * @return a new Staff
     * @throws SQLException 
     */
    private Staff staffMapper(ResultSet rs) throws SQLException {
        Staff staff = new Staff();
        staff.setAccountNumber(rs.getString("account_number"));
        staff.setName(rs.getString("name"));
        staff.setAddress(rs.getString("address"));
        staff.setSex(rs.getString("sex").charAt(0));
        staff.setDob(rs.getString("born_date"));
        staff.setRank(rs.getString("rank"));
        staff.setPassword(rs.getString("password"));
        return staff;
    }
}
