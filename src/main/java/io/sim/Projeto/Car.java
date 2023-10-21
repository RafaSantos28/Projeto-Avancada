package io.sim.Projeto;

import de.tudresden.sumo.cmd.Vehicle;
import it.polito.appeal.traci.SumoTraciConnection;


public class Car extends Vehicle implements Runnable{ //n sei se ta certo
    
    private SumoTraciConnection sumo;

    //Cliente para o Server Company, ja que envia dados para a planilha
    private String idAuto;
    private double distancia;
    private double combustivel;
    private double fuelTank = 10; // no inicio da aplicação o tanque de combustivel esta cheio
    //tanque decrementa a cada um litro por KM
    
    private boolean engine; //adiquirir dados do veiculo no SUMO

    public Car(){
        //(String) this.sumo.do_job_get(Vehicle.getRoadID(this.idAuto)),
		//(String) this.sumo.do_job_get(Vehicle.getRouteID(this.idAuto)),
		try {   
            this.combustivel = (double) sumo.do_job_get(Vehicle.getFuelConsumption(this.idAuto));
            this.distancia = (double) sumo.do_job_get(Vehicle.getDistance(this.idAuto));
            this.engine = false;   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public double getDistancia() {
        return distancia;
    }

    public double getFuel() {
        return fuelTank;
    }

    public double getcombustivel() {
        return combustivel;
    }

    public boolean isEngine() {
        return engine;
    }

    public void calculateDistance(double distance) {
        System.out.println(Vehicle.getPosition("").toString());
        
    }

    public static void main(String[] args){
        Car car = new Car();
        new Thread(car).start();
    }

    @Override
    public void run(){
        //Pedir rota
        try{
            ClienteSocket cliente = new ClienteSocket();

            cliente.conectar(5000);

            cliente.enviarMensagem("rota");

            cliente.escutar(new ClienteSocketHandler() {
                @Override
                public void handle(String msg) {
                    System.out.println(msg);
                }
            });
        }
        catch(Exception err){}
    }
}
