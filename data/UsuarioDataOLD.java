/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.data;

import br.com.proj.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class UsuarioDataOLD extends Conexao {
    public UsuarioDataOLD() throws SQLException, ClassNotFoundException{}
    
//    insert into usuario (tipoUser,salUser,nomeUser,telUser,userUser,PassUser) values (1,'10.000','Daniel','(17)99999-9999','root','toor')
    public boolean incluir(Usuario obj) throws Exception{
        String sql="Insert into usuario (tipouser, saluser, nomeuser, teluser, useruser, passuser) values (?,?,?,?,?,?)";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getTipoUser());
        ps.setDouble(2, obj.getSalUser());
        ps.setString(3, obj.getNomeUser());
        ps.setString(4, obj.getTelUser());
        ps.setString(5, obj.getUserUser());
        ps.setString(6, obj.getPassUser());
        return ps.executeUpdate()>0;
    }
    public boolean editar(Usuario obj) throws Exception{
        String sql="Update usuario set tipouser=?, saluser=?, nomeuser=?, teluser=?, useruser=?, passuser =? where iduser=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1, obj.getTipoUser());
        ps.setDouble(2, obj.getSalUser());
        ps.setString(3, obj.getNomeUser());
        ps.setString(4, obj.getTelUser());
        ps.setString(5, obj.getUserUser());
        ps.setString(6, obj.getPassUser());
        ps.setInt(7, obj.getIdUser());
        return ps.executeUpdate()>0;
    }
    public ArrayList<Usuario> pesquisar(String pesq) throws Exception{
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql="select * from usuario where nomeuser ilike '"+pesq+"%'";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario obj = new Usuario(rs.getInt("iduser"), rs.getString("nomeuser"), 
                    rs.getString("useruser"), rs.getString("passuser"), 
                    rs.getDouble("saluser"), rs.getString("teluser"), 
                    rs.getInt("tipouser"));
            lista.add(obj);
        }
        return lista;
    }
    
    public ArrayList<Usuario> pesquisarGeral() throws Exception{
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql="select * from usuario";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario obj = new Usuario(rs.getInt("iduser"), rs.getString("nomeuser"), 
                    rs.getString("useruser"), rs.getString("passuser"), 
                    rs.getDouble("saluser"), rs.getString("teluser"), 
                    rs.getInt("tipouser"));
            lista.add(obj);
        }
        return lista;
    }
    
    public boolean excluir(int id) throws Exception {
        String sql="Delete from usuario where iduser=?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setInt(1,id);
        return ps.executeUpdate()>0;
    }
    /*
    public boolean validarUsuario(String usuario, String senha) throws Exception{
        String sql="SELECT * FROM tbusuarios where usuario=? and senha = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1,usuario);
        ps.setString(2,senha);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) return true;
        else return false;
    }*/
    public Usuario validarUsuario(String usuario, String senha) throws Exception{
        String sql="SELECT * FROM usuario where useruser =? and passuser = ?";
        PreparedStatement ps = getConexao().prepareStatement(sql);
        ps.setString(1,usuario);
        ps.setString(2,senha);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            Usuario obj = new Usuario();
            obj.setIdUser(rs.getInt("iduser"));
            obj.setNomeUser(rs.getString("nomeuser"));
            obj.setPassUser(rs.getString("passuser"));
            obj.setTipoUser(rs.getInt("tipouser"));
            obj.setSalUser(rs.getDouble("saluser"));
            obj.setTelUser(rs.getString("teluser"));
            obj.setUserUser(rs.getString("useruser"));
            return obj;
        }
        else return null;
    }
}