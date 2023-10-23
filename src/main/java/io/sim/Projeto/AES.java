package io.sim.Projeto;

import org.jasypt.util.text.BasicTextEncryptor;

public class AES {
    private BasicTextEncryptor encriptador;
    private String chaveEncriptacao = "0123456789abcdef";

    public AES(){
      encriptador = new BasicTextEncryptor();
      encriptador.setPassword(chaveEncriptacao);
    }

    public String encripta(String mensagem) {
        return this.encriptador.encrypt(mensagem);
    }
     
    public String decripta(String textoEncriptado){
      return this.encriptador.decrypt(textoEncriptado);
    }
}
