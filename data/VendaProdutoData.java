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
import br.com.proj.model.VendaProduto;
/**
 *
 * @author Mega
 */
public class VendaProdutoData extends Conexao{
    public VendaProdutoData() throws SQLException, ClassNotFoundException {

    } 
    
    public boolean incluir(VendaProduto ven) throws Exception {
        String sql = "Insert into vendaproduto (idvenda, idpro, quantidade) values (?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, ven.getIdvenda());
        ps.setInt(2, ven.getIdpro());
        ps.setInt(3, ven.getQuantidade());
        return ps.executeUpdate() > 0;
    }
    
    public ArrayList<VendaProduto> pesquisar(int pesq) throws Exception {
        ArrayList<VendaProduto> lista = new ArrayList<>();
        String sql = "Select * from vendaproduto where idpro = "+pesq;
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            VendaProduto obj = new VendaProduto(rs.getInt("idvenda"), rs.getInt("idpro"), rs.getInt("quantidade"));
            lista.add(obj);
        }
        return lista;
    }
    
}
