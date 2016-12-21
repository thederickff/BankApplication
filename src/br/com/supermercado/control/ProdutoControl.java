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
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author derick
 */
public class ProdutoControl {

    private int col = 0;
    private int row = 0;
    private JTable tbProdutos;

    public JTable pesquisar(JTable tb, String txt) {
        try {
            // TODO add your handling code here:

            BaseDados bs = new BaseDados();
            Connection con = bs.getConnection();

            String sql = "select * from produtos where nome like '" + txt + "%'";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            limpar(tb);
            if (txt.equals("")) {
                limpar(tb);
            } else {
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
            }
            //

            ps.close();
            rs.close();
            con.close();

            return tb;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        return tb;
    }

    public void limpar(JTable tb) {
        System.out.println("row: " + row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                tb.setValueAt(null, i, j);
            }
        }

        this.row = 0;

    }
}
