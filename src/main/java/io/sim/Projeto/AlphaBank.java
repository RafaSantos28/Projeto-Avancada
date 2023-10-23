package io.sim.Projeto;

import java.util.ArrayList;

public class AlphaBank extends Thread {

	private ArrayList<Account> contas;

	//Os acessos às Accounts devem ser controlados, especialmente ao atributo saldo, um único acesso por vez é 
	//permitido, para que o saldo não sofra acessos simultâneos.

	public AlphaBank() {
		this.contas = new ArrayList<Account>();
	}

	public void addAccount(Account conta) {
		this.contas.add(conta);
	}

	public Account getAccount() {
		for(Account conta : contas) {
			return conta;
		}
		return null;
	}
	

	@Override
		public void run() {
			for(Account cont : contas){
				cont.start();
			}

			new Servidor(2000,new ServidorHandler() { 
		    private BotPayment botPayment;
			public String handle(String msg) {
                //Tratar mensagens aqui. If (mensagem.equalsIgnoreCase(acao) return respostaEmJson
                if (msg.equalsIgnoreCase("pagar motorista")){
					for(Account conta : contas) {
						if(conta.getTipoCliente().equals("Company")) {
														Account contaPagar = conta;
							Account contaReceber = getAccount();
							//pegarKMcarro
							//this.botPayment = new BotPayment(contaReceber, contaPagar, /*pegarkmcarro */, conta.getTipoCliente());
							this.botPayment.start();

						}
					}
				};
                if(msg.equals("pagar posto")){
                    for(Account conta : contas) {
						if(conta.getTipoCliente().equals("Drivers")) {
							Account contaPagar = conta;
							Account contaReceber = getAccount();
							//pegarKMcarro
							//this.botPayment = new BotPayment(contaReceber, contaPagar, /*pegarkmcarro */, conta.getTipoCliente());
							this.botPayment.start();
						}
					}
                }
                return "MENSAGEM INVÁLIDA";    
                }

            }).start();
		}

}
