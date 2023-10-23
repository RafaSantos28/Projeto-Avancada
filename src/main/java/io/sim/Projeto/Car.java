package io.sim.Projeto;

import de.tudresden.sumo.cmd.Vehicle;
import de.tudresden.sumo.objects.SumoColor;
import io.sim.Auto;
import it.polito.appeal.traci.SumoTraciConnection;

public class Car extends Vehicle implements Runnable{ //n sei se ta certo


    private SumoTraciConnection sumo;
    //Cliente para o Server Company, ja que envia dados para a planilha
    private Auto auto;
	private String idAuto;
    private double distancia;
    private double combustivel;
    private double posX;
    private double posY;
    private double fuelTank = 10; // no inicio da aplicação o tanque de combustivel esta cheio
                                    //tanque decrementa a cada um litro por KM

    public Car(String id, SumoTraciConnection sumo){
        this.sumo = sumo;
        this.idAuto = id;
		SumoColor green = new SumoColor(0, 255, 0, 126);
		try {
			this.auto = new Auto(true, idAuto, green, "Driver", sumo, 1000, 1, 1, 3.25, 4, 4);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

    public double getDistancia() {
        return distancia;
    }

    public double getcombustivel() {
        return combustivel;
    }

    public double getFuel() {
        return fuelTank;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }    

	public String getIdAuto() {
		return idAuto;
	}

    public void calculateDistance(double distance) {
        //System.out.println(Vehicle.getPosition("").toString());
        
    }

	public Auto getAuto() {
		return auto;
	}

    @Override
    public void run(){
		
        //Company
        try{
            ClienteSocket cliente = new ClienteSocket();

            cliente.conectar(5000);

            cliente.enviarMensagem("Relatorio");
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


