/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bankapplication.controller;

import com.bankapplication.database.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @name Controller
 * @author derickfelix
 * @date Sep 26, 2017
 */
public class Controller {
    protected ConnectionManager connectionManager;
    protected Statement statement;
    protected PreparedStatement ps;
    protected ResultSet rs;
    
    public Controller(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
