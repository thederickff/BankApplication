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
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author derick
 */
public class ProdutoControl {

    private int row = 0;

    private Connection con;
    private BaseDados bs;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public ProdutoControl() {
        bs = new BaseDados();
    }

    public JTable pesquisar(JTable tb, String txt) {
        try {
            // TODO add your handling code here:

            con = bs.getConnection();
            String preco;
            sql = "select * from produtos where nome like '" + txt + "%'";
            ps = con.prepareStatement(sql);        
            rs = ps.executeQuery();
            limpar(tb);

            while (rs.next()) {

                Produto p = new Produto();
                p.setCodigo(rs.getInt("codigo"));
                inserirString(tb, Integer.toString(p.getCodigo()), "Codigo", row);
                p.setNome(rs.getString("nome"));
                inserirString(tb, p.getNome(), "Nome", row);
                p.setPreco(rs.getDouble("preco"));
                preco = formatarNumero(p.getPreco());
                inserirString(tb, preco, "Preco", row);
                row++;
            }
            //

            ps.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }

        return tb;
    }
    public String formatarNumero(Double num){
        String n = String.format("%.2f", num).replace('.', ',');
       
        return n;
    }
    public int getRow() {
        int r = 0;
        try {
            con = bs.getConnection();

            sql = "select * from produtos";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                r++;
            }
        } catch (SQLException e) {

        }
        return r;
    }

    private void inserirString(JTable tb, String obj, String text, int row) {
        for (int i = 0; i < tb.getColumnCount(); i++) {

            if (tb.getColumnName(i).equals(text)) {
                tb.setValueAt(obj, row, i);
            }
        }
    }


    public void limpar(JTable tb) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 3; j++) {
                tb.setValueAt(null, i, j);
            }
        }

        this.row = 0;

    }

    public void salvarDados(Produto produto) {

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
