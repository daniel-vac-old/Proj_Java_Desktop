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
import br.com.proj.model.Fornecedor;


/**
 *
 * @author Mega
 */
public class FornecedorData extends Conexao{
    EstoqueData Est = new EstoqueData();
    public FornecedorData() throws SQLException, ClassNotFoundException {

    }
    public boolean incluir(Fornecedor forn) throws Exception {
        String sql = "Insert into fornecedor (nomefor, razfor, cnpj) values (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, forn.getNomefor());
        ps.setString(2, forn.getRazfor());
        ps.setString(3, forn.getCnpj());
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<Fornecedor> pesquisar(String pesq) throws Exception {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        String sql = "select * from fornecedor where nomefor ilike '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Fornecedor obj = new Fornecedor(rs.getInt("idfor"), rs.getString("nomefor"), rs.getString("razfor"), rs.getString("cnpj"));
            lista.add(obj);
        }
        return lista;
    }
    
    public ArrayList<Fornecedor> pesquisarGeral() throws Exception {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        String sql = "select * from fornecedor";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Fornecedor obj = new Fornecedor(rs.getInt("idfor"), rs.getString("nomefor"), rs.getString("razfor"), rs.getString("cnpj"));
            lista.add(obj);
        }
        return lista;
    }

    public boolean editar(Fornecedor forn) throws Exception{
        String sql="Update fornecedor set nomefor=?, razfor=?, cnpj=? where idfor=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, forn.getNomefor());
        ps.setString(2, forn.getRazfor());
        ps.setString(3, forn.getCnpj());
        ps.setInt(4, forn.getIdfor());
        return ps.executeUpdate()>0;
    }
    
    public boolean excluir(int id) throws Exception {
        String sql="Delete from fornecedor where idfor=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        return ps.executeUpdate()>0;
    }
    
    public ArrayList<Fornecedor> carregarComboF() throws Exception {
        ArrayList<Fornecedor> lista = new ArrayList<>();
        String sql = "Select * from fornecedor";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Fornecedor obj = new Fornecedor(rs.getInt("idfor"), rs.getString("nomefor"), rs.getString("razfor"), rs.getString("cnpj"));
            lista.add(obj);
        }
        return lista;
    }
}
