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
public class Fornecedor {
    private int idfor;
    private String nomefor;
    private String razfor;
    private String cnpj;

    public int getIdfor() {
        return idfor;
    }

    public void setIdfor(int idfor) {
        this.idfor = idfor;
    }

    public String getNomefor() {
        return nomefor;
    }

    public void setNomefor(String nomefor) {
        this.nomefor = nomefor;
    }

    public String getRazfor() {
        return razfor;
    }

    public void setRazfor(String razfor) {
        this.razfor = razfor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public Fornecedor(){
        idfor = 0;
        nomefor = new String();
        razfor = new String();
        cnpj = new String();
    }
    
    public Fornecedor(int idfor, String nomefor, String razfor, String cnpj) {
        this.idfor = idfor;
        this.nomefor = nomefor;
        this.razfor = razfor;
        this.cnpj = cnpj;
    }
}
