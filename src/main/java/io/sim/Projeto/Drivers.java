package io.sim.Projeto;


public class Drivers extends Thread{
    
    private Car car;
    private String name;
    private boolean isRunning;
    private boolean isStopped;
    private boolean isRefueling;
    //ArrayList<Route> routes = new ArrayList<Route>();

    public Drivers(Car car, String name, boolean isRunning, boolean isStopped, boolean isRefueling) {
        this.car = car;
        this.name = name;
        this.isRunning = isRunning;
        this.isStopped = isStopped;
        this.isRefueling = isRefueling;
    }

    public Car getCar() {
        return car;
    }
    
    public String getNome() {
        return name;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public boolean isIsStopped() {
        return isStopped;
    }

    public boolean isIsRefueling() {
        return isRefueling;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void setIsStopped(boolean isStopped) {
        this.isStopped = isStopped;
    }

    public void setIsRefueling(boolean isRefueling) {
        this.isRefueling = isRefueling;
    }

    @Override
    public void run() {
        if (this.isRunning == true) {
            if (this.car.getFuel() >= 0) {
                this.car.setFuel(this.car.getFuel() - 1);
            }
        } else {
            if (this.car.getFuel() >= 0) {
                this.car.setFuel(this.car.getFuel() - 1);
            }
        }
    }

}
