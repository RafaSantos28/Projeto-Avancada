package io.sim.Projeto;

public class Account extends Thread {
    
    private String conta;
    private double saldo;
    private String tipoCliente;

    public Account(String conta, double saldo, String tipoCliente) {
        this.conta = conta;
        this.saldo = saldo;
        this.tipoCliente = tipoCliente;
    }

    public String getConta() {
        return conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void run() {
        if (this.tipoCliente.equals("Pessoa Física")) {
            if (this.saldo >= 0) {
                this.saldo = this.saldo - 1;
            }
        } else {
            if (this.saldo >= 0) {
                this.saldo = this.saldo - 1;
            }
        }
    }

}
