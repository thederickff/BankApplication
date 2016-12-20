/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.supermercado.control;

import br.com.supermercado.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JSpinner;
import javax.swing.JTable;

/**
 *
 * @author derick
 */
public class ProdutoControl {

    private int col = 0;
    private int row = 0;
    private JTable tbProdutos;

    public JTable pesquisar(JTable tb, JSpinner spn) {
        try {
            // TODO add your handling code here:

            BaseDados bs = new BaseDados();
            Connection con = bs.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from produtos where codigo = ?");
            ps.setInt(1, (int) spn.getValue());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Produto p = new Produto();
                p.setCodigo(rs.getInt("codigo"));
                tb.setValueAt(p.getCodigo(), row, col);
                col++;
                p.setNome(rs.getString("nome"));
                tb.setValueAt(p.getNome(), row, col);
                col++;
                p.setPreco(rs.getDouble("preco"));
                tb.setValueAt(p.getPreco(), row, col);
                col = 0;
                row++;
            }
            row = 0;

            ps.close();
            rs.close();
            con.close();
            return tb;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tb;
    }
}
