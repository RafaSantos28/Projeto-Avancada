package io.sim.Projeto;

public class AlphaBank extends Thread {
	
	private Account conta;
	private double valor;
	private double saques;
	private String tipoCliente;
	
	public AlphaBank(Account conta, double valor, String tipoCliente) {
		this.conta = conta;
		this.valor = valor;
		this.tipoCliente = tipoCliente;
	}

	public Account getConta() {
		return conta;
	}

	public double getValor() {
		return valor;
	}

	public double getSaques() {
		return saques;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	@Override
	public void run() {
		if (this.tipoCliente.equals("Pessoa Física")) {
			if (this.conta.getSaldo() >= this.valor) {
				this.conta.setSaldo(this.conta.getSaldo() - this.valor);
				this.saques++;
			}
		} else {
			if (this.conta.getSaldo() >= this.valor) {
				this.conta.setSaldo(this.conta.getSaldo() - this.valor);
				this.saques++;
			}
		}
	}

}
