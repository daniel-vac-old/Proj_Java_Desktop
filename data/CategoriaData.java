/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.proj.model.Categoria;

/**
 *
 * @author Mega
 */
public class CategoriaData extends Conexao {

    public CategoriaData() throws SQLException, ClassNotFoundException {

    }

    public boolean incluir(Categoria cat) throws Exception {
        String sql = "Insert into categoria (nomecat, comissao) values (?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, cat.getNomecat());
        ps.setDouble(2, cat.getComissao());
        return ps.executeUpdate() > 0;
    }

    public ArrayList<Categoria> pesquisar(String pesq) throws Exception {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "select * from categoria where nomecat ilike '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Categoria obj = new Categoria(rs.getInt("idcat"), rs.getString("nomecat"), rs.getDouble("comissao"));
            lista.add(obj);
        }
        return lista;
    }

    public ArrayList<Categoria> pesquisarGeral() throws Exception {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "select * from categoria";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Categoria obj = new Categoria(rs.getInt("idcat"), rs.getString("nomecat"), rs.getDouble("comissao"));
            lista.add(obj);
        }
        return lista;
    }
    
    public boolean editar(Categoria cat) throws Exception{
        String sql="Update categoria set nomecat=?, comissao=? where idcat=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, cat.getNomecat());
        ps.setDouble(2, cat.getComissao());
        ps.setInt(3, cat.getIdcat());
        return ps.executeUpdate()>0;
    }
    public boolean excluir(int id) throws Exception {
        String sql="Delete from categoria where idcat=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        return ps.executeUpdate()>0;
    }
    
     public ArrayList<Categoria> carregarComboC() throws Exception {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "Select * from categoria";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Categoria obj = new Categoria(rs.getInt("idcat"), rs.getString("nomecat"), rs.getDouble("comissao"));
            lista.add(obj);
        }
        return lista;
    }
     
}
