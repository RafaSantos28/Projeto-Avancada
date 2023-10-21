package io.sim.Projeto;

public class Account extends Thread {
    
    private double saldo;
    private String nomeCliente;
    private int senha;

    public static void main( String[] args ) {
        Account conta = new Account(1000, "João", 1234);
        System.out.println(conta.getSaldo());
        System.out.println(conta.getTipoCliente());
        System.out.println(conta.getSaldo());
    
    }
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
