package io.sim.Projeto;

public class Car extends Thread{
    
    private double distancia;
    private String model;
    private double fuel;
    private boolean engine;
    

    public Car(double distancia, String model, double fuel, boolean engine) {
        this.distancia = distancia;
        this.model = model;
        this.fuel = fuel;
        this.engine = engine;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public boolean isEngine() {
        return engine;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public void run() {
        if (this.engine ==true) {
            if (this.fuel >= 0) {
                this.fuel = this.fuel - 1;
            }
        } else {
            if (this.fuel >= 0) {
                this.fuel = this.fuel - 1;
            }
        }
    }
}
