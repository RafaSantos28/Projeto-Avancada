package io.sim.Projeto;

public class BotPayment extends Thread {
    
    private double valorKm = 3.25;
    private int kmRodado; // para cada carro
    
    private double litroGas = 5.87; 
    private double nivelTanque; // para cada carro
    private double tamanhoDoTanque = 50; // para cada carro
    
    private double valorASerPago;// para ambos
    private Account contaPagar;
    private Account contaReceber;

    private String tipoCliente; //onde sera feito o pagamento

    public BotPayment(Account conta, Account conta2,int kmRodado, String tipoCliente) {
        this.contaReceber = conta;
        this.contaPagar = conta2; 
        this.kmRodado = kmRodado;
        this.tipoCliente = tipoCliente;
    }

    public BotPayment(Account conta, Account conta2,double nivel, String tipoCliente) {
        this.contaReceber = conta;
        this.contaPagar = conta2; 
        this.nivelTanque = nivel;
        this.tipoCliente = tipoCliente;
    }

    //para o Drivers
    public void valorParaDriver(){
        this.valorASerPago = this.kmRodado * this.valorKm;
        contaPagar.setSaldo(contaPagar.getSaldo()-valorASerPago);
        contaReceber.setSaldo(contaReceber.getSaldo()+valorASerPago);
    }

    public void valorParaFuelStation(){
        this.valorASerPago = (tamanhoDoTanque - this.nivelTanque) * this.litroGas;
        contaPagar.setSaldo(contaPagar.getSaldo()-valorASerPago);
        contaReceber.setSaldo(contaReceber.getSaldo()+valorASerPago);
    }

    @Override
    public void run() {
        if(this.tipoCliente.equals("Drivers")){
            valorParaDriver();
        }
        else if(this.tipoCliente.equals("FuelStation")){
            valorParaFuelStation();
        }

    }
}
