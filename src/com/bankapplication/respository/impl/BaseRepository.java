/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankapplication.respository.impl;

import com.bankapplication.database.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @name BaseRepository
 * @author derickfelix
 * @date Oct 2, 2017
 */
public class BaseRepository {
    protected ConnectionManager connectionManager;
    protected Statement statement;
    protected PreparedStatement pstmt;
    protected ResultSet rs;
    
    public BaseRepository() {
        this.connectionManager = ConnectionManager.getInstance();
    }
}
