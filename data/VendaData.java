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
import br.com.proj.model.Venda;
/**
 *
 * @author Mega
 */
public class VendaData extends Conexao{
    public VendaData() throws SQLException, ClassNotFoundException {

    }
    
    public String ultimavenda() throws Exception{
        String aux = "";
        String sql="Select idvenda from venda order by idvenda desc limit 1";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            aux = rs.getString("idvenda");
        }
        //Venda obj = new Venda(rs.getInt("idvenda"), rs.getDouble("totalvenda"));
        return aux;
    }
    
    public boolean incluir(Venda ven) throws Exception {
        String sql = "Insert into venda (totalvenda) values (?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setDouble(1, ven.getTotalvenda());
        return ps.executeUpdate() > 0;
    }
}
