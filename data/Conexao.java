/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author daniel
 */
public class Conexao {
    private Connection con;
    public Connection getConexao(){
        return con;
    }
    public Conexao() throws SQLException, ClassNotFoundException{
        String url="jdbc:postgresql://localhost:5432/bdpro";
        String driver = "org.postgresql.Driver";
        Class.forName(driver);
        con = DriverManager.getConnection(url,"postgres","");
    }
}
