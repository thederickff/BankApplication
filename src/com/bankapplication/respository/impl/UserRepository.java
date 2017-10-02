/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankapplication.respository.impl;

import com.bankapplication.model.User;
import com.bankapplication.respository.IUserRepository;
import java.sql.Connection;
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
        String sql = "select * from " + table;
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

                String accNumber = rs.getString("account_number");
                String name = rs.getString("name");
                String role = rs.getString("role");
                String password = rs.getString("password");

                User tempUser = new User(name, accNumber, role);
                tempUser.setPassword(password);
                users.add(tempUser);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void store(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
