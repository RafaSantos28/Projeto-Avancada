package io.sim.Projeto;

public class FuelEstation extends Thread {

    //Cliente do Alpha BAnk

    private int quantCar = 2;//quantiudade de bombas por vez
    private int tempoDeAbastecimento = 120000;//milissegundos
    private double litrosAbastecer;
    private double tamanhoTanque = 30;
    private double litrosNoTanque;
    private double quantidadeLitros;
    
    public FuelEstation(){
        this.litrosNoTanque = 0;
        this.litrosAbastecer = 0;
        this.quantidadeLitros = 0;
    }
    
    public int getQuantCar() {
        return quantCar;
    }

    public double calculoAbastecer() {
        this.quantidadeLitros = tamanhoTanque - litrosNoTanque ;
        return this.litrosAbastecer;
    } 

    @Override
    public void run() {
        try{
            ClienteSocket cliente = new ClienteSocket();

            cliente.conectar(2000);

            cliente.enviarMensagem("Fuel Station");
            cliente.escutar(new ClienteSocketHandler() {
                @Override
                public void handle(String msg) {
                    System.out.println(msg);
                }
            });
        }
        catch(Exception err){}

        while(true){
            if(this.litrosNoTanque<=3){
                this.litrosNoTanque = this.litrosNoTanque + this.litrosAbastecer;
            }
        }
    }


}
