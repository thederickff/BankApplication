/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository.impl;

import com.bankapplication.model.User;
import com.bankapplication.respository.IUserRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @name UserRepository
 * @author derickfelix
 * @date Oct 2, 2017
 */
public class UserRepository extends BaseRepository implements IUserRepository {

    private final String table = "`users`";
    private ArrayList<User> users;

    @Override
    public ArrayList<User> all() {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + table;
        // Intantiate only once
        if (users == null) {
            users = new ArrayList<>();
        } else {
            users.clear();
        }

        try {
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                users.add(userMapper(rs));
            }
            statement.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
        }
        return users;
    }

    @Override
    public User find(int id) {
        Connection conn = connectionManager.createConnection();
        String sql = "SELECT * FROM " + table + " WHERE `id` = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                return userMapper(rs);
            }

            statement.close();
            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
        return null;
    }

    @Override
    public void update(User user) {
        Connection conn = connectionManager.createConnection();
        String sql = "UPDATE " + table + " SET `name` = ?, `role` = ? WHERE `id` = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getRole());
            pstmt.setString(3, user.getUserId());
            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
    }

    @Override
    public void store(User user) {
        Connection conn = connectionManager.createConnection();
        String sql = "INSERT INTO " + table + "(`account_number`, `name`, `role`, `password`) value (?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getAccountNumber());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, user.getPassword());
            pstmt.execute();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
    }

    @Override
    public void destroy(User user) {
        Connection conn = connectionManager.createConnection();
        String sql = "DELETE FROM " + table + " WHERE `id` = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.execute();
            
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("SQLError: " + e);
        }
    }

    /**
     * Constructs a new User object
     * 
     * @param rs the result set
     * @return a new User
     * @throws SQLException 
     */
    private User userMapper(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getString("id"));
        user.setAccountNumber(rs.getString("account_number"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
