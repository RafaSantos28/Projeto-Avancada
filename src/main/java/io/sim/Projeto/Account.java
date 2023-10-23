package io.sim.Projeto;

public class Account extends Thread {
    
    private double saldo;
    private String nomeCliente;
    private int senha;

    public Account(double saldo, String nome, int senha) {
        this.saldo = saldo;
        this.nomeCliente = nome;
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCliente() {
        return nomeCliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void getSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public void run() {
       
    }

}
