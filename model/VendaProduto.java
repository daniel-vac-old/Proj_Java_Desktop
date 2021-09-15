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
public class VendaProduto {
    private int idvenda;
    private int idpro;
    private int quantidade;

    public VendaProduto(){
        idvenda = 0;
        idpro = 0;
        this.quantidade = 0;
    }

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public VendaProduto(int idvenda, int idpro, int quantidade) {
        this.idvenda = idvenda;
        this.idpro = idpro;
        this.quantidade = quantidade;
    }
    
    
    
}
