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
public class Categoria {
    private int idcat;
    private String nomecat;
    private double comissao;

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getNomecat() {
        return nomecat;
    }

    public void setNomecat(String nomecat) {
        this.nomecat = nomecat;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
    
    public Categoria() {
        idcat = 0;
        nomecat = new String();
        comissao = 0;
    }

    public Categoria(int idcat, String nomecat, double comissao) {
        this.idcat = idcat;
        this.nomecat = nomecat;
        this.comissao = comissao;
    }
    
}
