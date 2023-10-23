package io.sim.Projeto;

import de.tudresden.sumo.cmd.Vehicle;
import de.tudresden.sumo.objects.SumoPosition2D;
import io.sim.DrivingData;
import it.polito.appeal.traci.SumoTraciConnection;

public class Car extends Vehicle implements Runnable{ //n sei se ta certo


    private SumoTraciConnection sumo;
    //Cliente para o Server Company, ja que envia dados para a planilha
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

    public void calculateDistance(double distance) {
        //System.out.println(Vehicle.getPosition("").toString());
        
    }

    @Override
    public void run(){

        this.atualizaSensores();
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

    private void atualizaSensores() {

		try {

			if (!this.getSumo().isClosed()) {
				SumoPosition2D sumoPosition2D;
				sumoPosition2D = (SumoPosition2D) sumo.do_job_get(Vehicle.getPosition(this.idAuto));

				System.out.println("AutoID: " + this.getIdAuto());
				System.out.println("RoadID: " + (String) this.sumo.do_job_get(Vehicle.getRoadID(this.idAuto)));
				System.out.println("RouteID: " + (String) this.sumo.do_job_get(Vehicle.getRouteID(this.idAuto)));
				System.out.println("RouteIndex: " + this.sumo.do_job_get(Vehicle.getRouteIndex(this.idAuto)));
				
				DrivingData _repport = new DrivingData(

						this.idAuto, this.idAuto, System.currentTimeMillis(), sumoPosition2D.x, sumoPosition2D.y,
						(String) this.sumo.do_job_get(Vehicle.getRoadID(this.idAuto)),
						(String) this.sumo.do_job_get(Vehicle.getRouteID(this.idAuto)),
						(double) sumo.do_job_get(Vehicle.getSpeed(this.idAuto)),
						(double) sumo.do_job_get(Vehicle.getDistance(this.idAuto)),

						(double) sumo.do_job_get(Vehicle.getFuelConsumption(this.idAuto)),
						// Vehicle's fuel consumption in ml/s during this time step,
						// to get the value for one step multiply with the step length; error value:
						// -2^30
						
						1/*averageFuelConsumption (calcular)*/,

						1, 3.25,

						(double) sumo.do_job_get(Vehicle.getCO2Emission(this.idAuto)),
						// Vehicle's CO2 emissions in mg/s during this time step,
						// to get the value for one step multiply with the step length; error value:
						// -2^30

						(double) sumo.do_job_get(Vehicle.getHCEmission(this.idAuto)),
						// Vehicle's HC emissions in mg/s during this time step,
						// to get the value for one step multiply with the step length; error value:
						// -2^30
						
						3,
						// the total number of persons that can ride in this vehicle
						
						3
						// the total number of persons which are riding in this vehicle

				);

				// Criar relat�rio auditoria / alertas
				// velocidadePermitida = (double)
				// sumo.do_job_get(Vehicle.getAllowedSpeed(this.idSumoVehicle));

				//this.drivingRepport.add(_repport);

				//System.out.println("Data: " + this.drivingRepport.size());
				//System.out.println("idAuto = " + this.drivingRepport.get(this.drivingRepport.size() - 1).getAutoID());
				//System.out.println(
				//		"timestamp = " + this.drivingRepport.get(this.drivingRepport.size() - 1).getTimeStamp());
				//System.out.println("X=" + this.drivingRepport.get(this.drivingRepport.size() - 1).getX_Position() + ", "
				//		+ "Y=" + this.drivingRepport.get(this.drivingRepport.size() - 1).getY_Position());
				//System.out.println("speed = " + this.drivingRepport.get(this.drivingRepport.size() - 1).getSpeed());
				//System.out.println("odometer = " + this.drivingRepport.get(this.drivingRepport.size() - 1).getOdometer());
				//System.out.println("Fuel Consumption = "
				//		+ this.drivingRepport.get(this.drivingRepport.size() - 1).getFuelConsumption());
				//System.out.println("Fuel Type = " + this.fuelType);
				//System.out.println("Fuel Price = " + this.fuelPrice);

				//System.out.println(
				//		"CO2 Emission = " + this.drivingRepport.get(this.drivingRepport.size() - 1).getCo2Emission());

				//System.out.println();
				//System.out.println("************************");
				//System.out.println("testes: ");
				//System.out.println("getAngle = " + (double) sumo.do_job_get(Vehicle.getAngle(this.idAuto)));
				//System.out
				//		.println("getAllowedSpeed = " + (double) sumo.do_job_get(Vehicle.getAllowedSpeed(this.idAuto)));
				//System.out.println("getSpeed = " + (double) sumo.do_job_get(Vehicle.getSpeed(this.idAuto)));
				//System.out.println(
				//		"getSpeedDeviation = " + (double) sumo.do_job_get(Vehicle.getSpeedDeviation(this.idAuto)));
				//System.out.println("getMaxSpeedLat = " + (double) sumo.do_job_get(Vehicle.getMaxSpeedLat(this.idAuto)));
				//System.out.println("getSlope = " + (double) sumo.do_job_get(Vehicle.getSlope(this.idAuto))
				//		+ " the slope at the current position of the vehicle in degrees");
				//System.out.println(
				//		"getSpeedWithoutTraCI = " + (double) sumo.do_job_get(Vehicle.getSpeedWithoutTraCI(this.idAuto))
				//				+ " Returns the speed that the vehicle would drive if no speed-influencing\r\n"
				//				+ "command such as setSpeed or slowDown was given.");

				//sumo.do_job_set(Vehicle.setSpeed(this.idAuto, (1000 / 3.6)));
				//double auxspeed = (double) sumo.do_job_get(Vehicle.getSpeed(this.idAuto));
				//System.out.println("new speed = " + (auxspeed * 3.6));
				//System.out.println(
				//		"getSpeedDeviation = " + (double) sumo.do_job_get(Vehicle.getSpeedDeviation(this.idAuto)));
				
				
				//sumo.do_job_set(Vehicle.setSpeedMode(this.idAuto, 0));
				//sumo.do_job_set(Vehicle.setSpeed(this.idAuto, 6.95));

				
				//System.out.println("getPersonNumber = " + sumo.do_job_get(Vehicle.getPersonNumber(this.idAuto)));
				//System.out.println("getPersonIDList = " + sumo.do_job_get(Vehicle.getPersonIDList(this.idAuto)));
				
				System.out.println("************************");

			} else {
				System.out.println("SUMO is closed...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getIdAuto() {
		return this.idAuto;
	}

	public SumoTraciConnection getSumo() {
		return this.sumo;
	}

    
}


