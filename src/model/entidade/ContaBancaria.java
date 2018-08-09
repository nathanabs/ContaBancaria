/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entidade;

import model.exceptions.DomainException;

/**
 *
 * @author Nathan
 */
public class ContaBancaria {
    private int numero;
    private String titular;
    private double saldo;
    private double limiteSaque;

    public ContaBancaria(int numero, String titular, double saldo, double limiteSaque) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteSaque() {
        return limiteSaque;
    }

    public void setLimiteSaque(double limiteSaque) {
        this.limiteSaque = limiteSaque;
    }
    
    public void saque(double quantidade) throws DomainException{
        if(limiteSaque < quantidade){
            throw new DomainException("A quantidade excedeu o limite de saque.");
        }
        if (quantidade > saldo) {
            throw new DomainException("Não há saldo suficiente.");
        }
        this.saldo -= quantidade;
    }
    
    public void deposito(double quantidade){
        saldo += quantidade;
    }
    
    
}
