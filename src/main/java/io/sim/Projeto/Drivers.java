package io.sim.Projeto;

import java.util.ArrayList;

import de.tudresden.sumo.cmd.Vehicle;
import de.tudresden.sumo.objects.SumoColor;
import de.tudresden.sumo.objects.SumoStringList;
import it.polito.appeal.traci.SumoTraciConnection;

public class Drivers extends Thread{
    

    private SumoTraciConnection sumo;

    private Car car ;
    private String name;
    private String msgConfirmação;
    
    private ArrayList<Route> routesExec = new ArrayList<>();
    private ArrayList<Route> routesFinalaizadas = new ArrayList<>();


    public Drivers(String name, String nomeCar, SumoTraciConnection sumo) {
        this.car = new Car(nomeCar, sumo);
        this.name = name;
        this.sumo = sumo;
        Thread t1 = new Thread(car);
        t1.start(); 
    }

    public Car getCar() {
        return car;
    }
    
    public String getNome() {
        return name;
    }

    public void setMsgConfirmação(String msgConfirmação) {
        this.msgConfirmação = msgConfirmação;
    }
    
    public String getIdCar(){
        return car.getIdAuto();
    }

    public double getKm() {
        return car.getDistancia();
    }
    
    public double getLitros() {
        return car.getFuel();
    }

    public double positionX() {
        return car.getPosX();
    }

    public double positionY() {
        return car.getPosY();
    }   

    //metodos para array
    public void rotasExecutadas(Route rota) {
        this.routesExec.remove(rota);
        this.routesFinalaizadas.add(rota);
    }

    public Route getRota(){
        return routesExec.get(0);
    }

    @Override
    public void run() {
        
        //Company
        try{
            ClienteSocket cliente = new ClienteSocket();

            cliente.conectar(5000);
            
            if(routesExec.size() == 0){
                cliente.enviarMensagem("rota");
                cliente.escutar(new ClienteSocketHandler() {
                    @Override
                    public void handle(String msg) {
                        System.out.println(msg);
                    }
                });
                this.initializeRoutes();

            }
            else if(msgConfirmação == "confirmado"){
                rotasExecutadas(getRota());
                cliente.enviarMensagem("rota finalizada");
                cliente.escutar(new ClienteSocketHandler() {
                    @Override
                    public void handle(String msg) {
                        System.out.println(msg);
                    }
                });
            }
        }
        catch(Exception err){}

        //Alpha Bank
        try{
            ClienteSocket cliente = new ClienteSocket();
                //if(Combustivel Carro <=3){
                cliente.conectar(2000);
                cliente.enviarMensagem("Driver");
                cliente.enviarMensagem("Pagar posto");
                cliente.escutar(new ClienteSocketHandler() {
                    @Override
                    public void handle(String msg) {
                            System.out.println(msg);
                    }
                }
                //}
          );
        }
        catch(Exception err){}
        
    }

    
    private void initializeRoutes() {
        SumoColor green = new SumoColor(0, 255, 0, 126);
		SumoStringList edge = new SumoStringList();
		edge.clear();

		for (String e : getRota().toString().split(" ")) {
			edge.add(e);
		}

		try {
			sumo.do_job_set(Route.add(getRota().toString(), edge));
			//sumo.do_job_set(Vehicle.add(this.auto.getIdAuto(), "DEFAULT_VEHTYPE", this.itinerary.getIdItinerary(), 0,
			//		0.0, 0, (byte) 0));
			
			sumo.do_job_set(Vehicle.addFull(getIdCar(), 				//vehID
											getRota().toString(), 	//routeID 
											"DEFAULT_VEHTYPE", 					//typeID 
											"now", 								//depart  
											"0", 								//departLane 
											"0", 								//departPos 
											"0",								//departSpeed
											"current",							//arrivalLane 
											"max",								//arrivalPos 
											"current",							//arrivalSpeed 
											"",									//fromTaz 
											"",									//toTaz 
											"", 								//line 
											3,		//personCapacity 
											3)		//personNumber
					);
			
			sumo.do_job_set(Vehicle.setColor(getIdCar(), green));
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}


	public SumoTraciConnection getSumo() {
		return this.sumo;
	}

}
