/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.data;

import br.com.proj.model.Categoria;
import br.com.proj.model.Fornecedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.proj.model.Produto;
import br.com.proj.data.EstoqueData;

/**
 *
 * @author Mega
 */
public class ProdutoData extends Conexao{
    public ProdutoData() throws SQLException, ClassNotFoundException {

    }
    public String idprod() throws Exception{
        String aux;
        String sql="Select idpro from produto join fornecedor on (produto.idfor = fornecedor.idfor) join categoria on (produto.idcat = categoria.idcat) order by idpro desc limit 1";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        aux = String.valueOf(rs.getInt("idpro"));
        return aux;
    }
    
    public boolean incluir(Produto pro) throws Exception{
        String sql="Insert into produto (idfor, idcat, preco, nomepro, quantidade) values (?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, pro.getFornecedor().getIdfor());
        ps.setInt(2, pro.getCategoria().getIdcat());
        ps.setDouble(3, pro.getPreco());
        ps.setString(4, pro.getNomepro());
        ps.setInt(5, pro.getQuantidade());
        return ps.executeUpdate()>0;
    }

    public ArrayList<Produto> pesquisar(String pesq) throws Exception {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "Select * from produto join fornecedor on (produto.idfor = fornecedor.idfor) join categoria on (produto.idcat = categoria.idcat) where nomepro ilike '" + pesq + "%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produto obj = new Produto(rs.getInt("idpro"), new Fornecedor(rs.getInt("idfor"), rs.getString("nomefor"), rs.getString("razfor"), rs.getString("cnpj")), new Categoria(rs.getInt("idcat"), rs.getString("nomecat"), rs.getDouble("comissao")), rs.getDouble("preco"), rs.getString("nomepro"), rs.getInt("quantidade"));
            lista.add(obj);
        }
        return lista;
    }
    
    public ArrayList<Produto> pesquisarGeral() throws Exception {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "Select * from produto join fornecedor on (produto.idfor = fornecedor.idfor) join categoria on (produto.idcat = categoria.idcat)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produto obj = new Produto(rs.getInt("idpro"), new Fornecedor(rs.getInt("idfor"), rs.getString("nomefor"), rs.getString("razfor"), rs.getString("cnpj")), new Categoria(rs.getInt("idcat"), rs.getString("nomecat"), rs.getDouble("comissao")), rs.getDouble("preco"), rs.getString("nomepro"), rs.getInt("quantidade"));
            lista.add(obj);
        }
        return lista;
    }
    
    public boolean editar(Produto pro) throws Exception{
        String sql="Update produto set idfor=?, idcat=?, preco=?, nomepro=?, quantidade=? where idpro=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, pro.getFornecedor().getIdfor());
        ps.setInt(2, pro.getCategoria().getIdcat());
        ps.setDouble(3, pro.getPreco());
        ps.setString(4, pro.getNomepro());
        ps.setInt(5, pro.getQuantidade());
        ps.setInt(6, pro.getIdpro());
        return ps.executeUpdate()>0;
    }
    
    public boolean editarvenda(int qtd, int idpro) throws Exception{
        String sql="Update produto set quantidade = quantidade-"+qtd+" where idpro=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idpro);
        return ps.executeUpdate()>0;
    }
    
    public boolean editarcompra(int qtd, int idpro) throws Exception{
        String sql="Update produto set quantidade = quantidade+"+qtd+" where idpro=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, idpro);
        return ps.executeUpdate()>0;
    }
    
    public boolean excluir(int id) throws Exception {
        String sql="Delete from produto where idpro=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        return ps.executeUpdate()>0;
    }
    
    public ArrayList<Produto> carregarComboP() throws Exception {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "Select * from produto join fornecedor on (produto.idfor = fornecedor.idfor) join categoria on (produto.idcat = categoria.idcat)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produto obj = new Produto(rs.getInt("idpro"), new Fornecedor(rs.getInt("idfor"), rs.getString("nomefor"), rs.getString("razfor"), rs.getString("cnpj")), new Categoria(rs.getInt("idcat"), rs.getString("nomecat"), rs.getDouble("comissao")), rs.getDouble("preco"), rs.getString("nomepro"), rs.getInt("quantidade"));
            lista.add(obj);
        }
        return lista;
    }
    
}
