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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private Connection con;
    private BaseDados bs;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public ProdutoControl(){
        bs = new BaseDados();
    }
    public JTable pesquisar(JTable tb, String txt) {
        try {
            // TODO add your handling code here:

            
            con = bs.getConnection();

            sql = "select * from produtos where nome like '" + txt + "%'";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
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
        //System.out.println("row: " + row);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                tb.setValueAt(null, i, j);
            }
        }

        this.row = 0;

    }
    public void salvarDados(Produto produto){
       
        try {
            con = bs.getConnection();
            sql = "insert into produtos(codigo, nome, preco) values(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getNome());
            ps.setDouble(3, produto.getPreco());
            
            ps.execute();
            
            JOptionPane.showMessageDialog(null, "Dados salvo com sucesso!");
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }
        
    }
}
