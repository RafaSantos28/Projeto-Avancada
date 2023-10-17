package io.sim.Projeto;

public class BotPayment extends Thread {
    
    private double valorKm = 3.25;
    private double valorConta;
    private double kmRodado;

    public BotPayment(double valorConta, double kmRodado) {
        this.valorConta = valorConta;
        this.kmRodado = kmRodado;
    }

    //para o Drivers
    public void calculoTrans(){
        this.valorConta = this.valorConta + (this.kmRodado * this.valorKm);    
    }

    @Override
    public void run() {
        calculoTrans();
    }
}
