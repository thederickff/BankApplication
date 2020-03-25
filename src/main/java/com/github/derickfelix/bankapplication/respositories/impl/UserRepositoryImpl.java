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
package com.github.derickfelix.bankapplication.respositories.impl;

import com.github.derickfelix.bankapplication.models.User;
import com.github.derickfelix.bankapplication.respositories.IUserRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author derickfelix
 * Date: Oct 2, 2017
 */
public class UserRepository extends BaseRepository implements IUserRepository {

    private final String table = "`users`";
    private ArrayList<User> users;

    @Override
    public ArrayList<User> all()
    {
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
    public User find(int id)
    {
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
    public void update(User user)
    {
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
    public void store(User user)
    {
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
    public void destroy(User user)
    {
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
    private User userMapper(ResultSet rs) throws SQLException
    {
        User user = new User();
        user.setUserId(rs.getString("id"));
        user.setAccountNumber(rs.getString("account_number"));
        user.setName(rs.getString("name"));
        user.setRole(rs.getString("role"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
