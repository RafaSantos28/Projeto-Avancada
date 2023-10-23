package io.sim;

import java.io.IOException;
import java.util.ArrayList;

import io.sim.Projeto.AlphaBank;
import io.sim.Projeto.Drivers;
import io.sim.Projeto.FuelEstation;
import io.sim.Projeto.Company;
import it.polito.appeal.traci.SumoTraciConnection;

public class EnvSimulator extends Thread{

    private SumoTraciConnection sumo;
	private ArrayList<Drivers> motoristas = new ArrayList<Drivers>();
	private Company company;
	private AlphaBank alphaBank;
	private FuelEstation fuelEstation;
	
    public EnvSimulator(){
		
		this.company = new Company();
		this.alphaBank = new AlphaBank();
		this.fuelEstation = new FuelEstation();
    }

    public void run(){

		/* SUMO */
		String sumo_bin = "sumo-gui";		
		String config_file = "map/map.sumo.cfg";
		
		// Sumo connection
		this.sumo = new SumoTraciConnection(sumo_bin, config_file);
		sumo.addOption("start", "1"); // auto-run on GUI show
		sumo.addOption("quit-on-end", "1"); // auto-close on end

		try {
			sumo.runServer(12345);
			for (int i = 1; i < 100; i++) {
			motoristas.add(new Drivers("Driver" + i, "CAR" + i, sumo));
			}
			for(Drivers motorista : motoristas){
				motorista.start();
			}
	 		company.start();;
			alphaBank.start();;
		 	fuelEstation.start();;			
		
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}
