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
public class Venda {
    private int idvenda;
    private double totalvenda;

    public int getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(int idvenda) {
        this.idvenda = idvenda;
    }

    public double getTotalvenda() {
        return totalvenda;
    }

    public void setTotalvenda(double totalvenda) {
        this.totalvenda = totalvenda;
    }
    public Venda(){
        idvenda = 0;
        totalvenda = 0;
    }

    public Venda(int idvenda, double totalvenda) {
        this.idvenda = idvenda;
        this.totalvenda = totalvenda;
    }
    
    
}
