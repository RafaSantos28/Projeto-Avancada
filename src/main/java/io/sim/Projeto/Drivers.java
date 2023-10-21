package io.sim.Projeto;

import java.util.ArrayList;

public class Drivers extends Thread{
    
    //Cliente para Alpha bank

    private Car car;
    private String name;
    private int senhaConta;
    
    //BotPayment pagara por litro de combustivel 5,87 
    private BotPayment botPayment;

    private ArrayList<Route> routesExec = new ArrayList<>();
    private ArrayList<Route> routesFinalaizadas = new ArrayList<>();


    public Drivers(Car car, String name) {
        this.car = car;
        this.name = name;
    }

    public Car getCar() {
        return car;
    }
    
    public String getNome() {
        return name;
    }

    //metodos para array
    public void getRoutesExec(){
        for(Route route : routesExec){
            System.out.println(route);
        }
    }

    public void getRoutesFinalizadas(){
        for(Route route : routesFinalaizadas){
            System.out.println(route);
        }
    }

    @Override
    public void run() {
        while(true){
            if(routesExec.size() > 0){
                Route route = routesExec.get(0);
                routesExec.remove(0);
                routesFinalaizadas.add(route);
            }
        }
    }

}
