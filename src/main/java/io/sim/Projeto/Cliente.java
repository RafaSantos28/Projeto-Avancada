package io.sim.Projeto;

public class Cliente extends Thread{
	
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public void run() {
		System.out.println("Cliente " + this.nome + " está na fila");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente " + this.nome + " está sendo atendido");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente " + this.nome + " foi atendido");
	}
	

}