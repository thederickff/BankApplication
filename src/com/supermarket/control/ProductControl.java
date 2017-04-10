/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supermarket.control;

import com.supermarket.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author derick
 */
public class ProductControl {

    private int row = 0;

    private Connection con;
    private DatabaseConf bs;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public ProductControl() {
        bs = new DatabaseConf();

    }

    public JTable search(JTable tb, String txt) {
        try {
            // TODO add your handling code here:

            con = bs.getConnection();
            String price;
            sql = "select * from " + DatabaseConf.tableProducts + " where name like '" + txt + "%'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            clear(tb);

            while (rs.next()) {

                Product p = new Product();
                p.setCode(rs.getInt("code"));
                insertString(tb, Integer.toString(p.getCode()), "Code", row);
                p.setName(rs.getString("name"));
                insertString(tb, p.getName(), "Name", row);
                p.setPrice(rs.getDouble("price"));
                price = formatNumber(p.getPrice());
                insertString(tb, price, "Price", row);
                row++;
            }
            //

            ps.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }

        return tb;
    }

    public String formatNumber(Double num) {
        String n = String.format("%.2f", num).replace('.', ',');

        return n;
    }

    public int getRow() {
        int r = 0;
        try {
            con = bs.getConnection();

            sql = "select * from " + DatabaseConf.tableProducts + "";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                r++;
            }
        } catch (SQLException e) {

        }
        return r;
    }

    private void insertString(JTable tb, String obj, String text, int row) {
        for (int i = 0; i < tb.getColumnCount(); i++) {

            if (tb.getColumnName(i).equals(text)) {
                tb.setValueAt(obj, row, i);
            }
        }
    }

    public void clear(JTable tb) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                tb.setValueAt(null, i, j);
            }
        }

        this.row = 0;

    }

    public void save(Product product) {

        try {
            con = bs.getConnection();
            sql = "insert into " + DatabaseConf.tableProducts + "(code, name, price) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());

            ps.execute();

            JOptionPane.showMessageDialog(null, "Dados salvo com sucesso!");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }

    }
}
