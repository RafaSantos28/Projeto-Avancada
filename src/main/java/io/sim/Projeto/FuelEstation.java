package io.sim.Projeto;

public class FuelEstation extends Thread {

    private int quantCar = 2;
    private int tempoDeAbastecimento = 2;

    public FuelEstation(int quantCar, int tempoDeAbastecimento) {
        this.quantCar = quantCar;
        this.tempoDeAbastecimento = tempoDeAbastecimento;
    }
    
    public int getQuantCar() {
        return quantCar;
    }

    public int getTempoDeAbastecimento() {
        return tempoDeAbastecimento;
    }

    public void setQuantCar(int quantCar) {
        this.quantCar = quantCar;
    }

    public void setTempoDeAbastecimento(int tempoDeAbastecimento) {
        this.tempoDeAbastecimento = tempoDeAbastecimento;
    }

    @Override
    public void run() {
        if (this.quantCar > 0) {
            this.quantCar = this.quantCar - 1;
            try {
                this.sleep(this.tempoDeAbastecimento);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
