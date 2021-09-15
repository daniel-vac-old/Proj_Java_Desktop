/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.model;

/**
 *
 * @author daniel
 */
public class Usuario {

    private int idUser;
    private String nomeUser;
    private String userUser;
    private String passUser;
    private double salUser;
    private String telUser;
    private int tipoUser;
    
    

    public Usuario() {
        idUser=0;
        nomeUser = new String();
        userUser = new String();
        passUser = new String();
        salUser = 0;
        telUser = new String();
        tipoUser = 0;
    }

    public Usuario(int idUser, String nomeUser, String userUser, String passUser, double salUser, String telUser, int tipoUser) {
        this.idUser = idUser;
        this.nomeUser = nomeUser;
        this.userUser = userUser;
        this.passUser = passUser;
        this.salUser = salUser;
        this.telUser = telUser;
        this.tipoUser = tipoUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getUserUser() {
        return userUser;
    }

    public void setUserUser(String userUser) {
        this.userUser = userUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public double getSalUser() {
        return salUser;
    }

    public void setSalUser(double salUser) {
        this.salUser = salUser;
    }

    public String getTelUser() {
        return telUser;
    }

    public void setTelUser(String telUser) {
        this.telUser = telUser;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }

    
    
}