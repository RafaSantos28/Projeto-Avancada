package io.sim.Projeto;

import org.jasypt.util.text.BasicTextEncryptor;

public class AES {
    private BasicTextEncryptor encriptador;
    private String chaveEncriptacao = "0123456789abcdef";

    public AES(){
      encriptador = new BasicTextEncryptor();
      encriptador.setPassword(chaveEncriptacao);
    }

    public static void main(String[] args){
      AES aes = new AES();
      String mensagem = "Teste de criptografia";
      String mensagemEncriptada = aes.encripta(mensagem);
      String mensagemDecriptada = aes.decripta(mensagemEncriptada);
      System.out.println("Mensagem Original: " + mensagem);
      System.out.println("Mensagem Encriptada: " + mensagemEncriptada);
      System.out.println("Mensagem Decriptada: " + mensagemDecriptada);
    }

    public String encripta(String mensagem) {
        return this.encriptador.encrypt(mensagem);
    }
     
    public String decripta(String textoEncriptado){
      return this.encriptador.decrypt(textoEncriptado);
    }
}
