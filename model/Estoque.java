/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.model;

/**
 *
 * @author Mega
 */
public class Estoque {
    private int iduser;
    private int idpro;
    private String datalt;
    private String datcad;
    private String usernew;
    private String useralt;

    public Estoque(int iduser, int idpro, String datalt, String datcad, String usernew, String useralt) {
        this.iduser = iduser;
        this.idpro = idpro;
        this.datalt = datalt;
        this.datcad = datcad;
        this.usernew = usernew;
        this.useralt = useralt;
    }
    
    public Estoque(){
        iduser = 0;
        idpro = 0;
        datalt = new String();
        datcad = new String();
        usernew = new String();
        useralt = new String();
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getDatalt() {
        return datalt;
    }

    public void setDatalt(String datalt) {
        this.datalt = datalt;
    }

    public String getDatcad() {
        return datcad;
    }

    public void setDatcad(String datcad) {
        this.datcad = datcad;
    }

    public String getUsernew() {
        return usernew;
    }

    public void setUsernew(String usernew) {
        this.usernew = usernew;
    }

    public String getUseralt() {
        return useralt;
    }

    public void setUseralt(String useralt) {
        this.useralt = useralt;
    }

   

    
}
