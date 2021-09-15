/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.data;

import br.com.proj.model.Usuario;
import br.com.proj.model.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.proj.model.Estoque;
/**
 *
 * @author Mega
 */
public class EstoqueData extends Conexao{
    public EstoqueData() throws SQLException, ClassNotFoundException {

    }
    
    public boolean incluir(Estoque est) throws Exception {
        String sql = "Insert into usuarioproduto (iduser, idpro, datcad, usernew) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, est.getIduser());
        ps.setInt(2, est.getIdpro());
        ps.setString(3, est.getDatcad());
        ps.setString(4, est.getDatcad());
        return ps.executeUpdate() > 0;
    }
    
    public boolean editar(Estoque est) throws Exception{
        String sql="Update usuarioproduto set datalt=?, useralt=? where idpro=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1, est.getDatalt());
        ps.setString(2, est.getUseralt());
        ps.setInt(3, est.getIdpro());
        return ps.executeUpdate()>0;
    }

}
