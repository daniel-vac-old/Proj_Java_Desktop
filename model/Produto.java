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
public class Produto {
    private int idpro;
    private Fornecedor fornecedor;
    private Categoria categoria;
    private double preco;
    private String nomepro;
    private int quantidade;

    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNomepro() {
        return nomepro;
    }

    public void setNomepro(String nomepro) {
        this.nomepro = nomepro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto(){
        idpro = 0;
        fornecedor = new Fornecedor();
        categoria = new Categoria();
        preco = 0;
        nomepro = new String();
        quantidade = 0;
    }
    
    public Produto(int idpro, Fornecedor fornecedor, Categoria categoria, double preco, String nomepro, int quantidade) {
        this.idpro = idpro;
        this.fornecedor = fornecedor;
        this.categoria = categoria;
        this.preco = preco;
        this.nomepro = nomepro;
        this.quantidade = quantidade;
    }
    
    
    
}
