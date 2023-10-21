package io.sim.Projeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteSocket {
    private Socket socket;
    private OutputStream ou ;

    private AES aes;

    private PrintWriter pw;

    private String IP="127.0.0.1";

    public ClienteSocket(){
        aes = new AES();
    }

    public static void main(String[] args){
        ClienteSocket cliente = new ClienteSocket();
        try{
            cliente.conectar(5000);
            
            
            cliente.enviarMensagem("quero rota");

            // cliente.escutar();
        }
        catch(Exception err){
            System.out.println(err.getMessage());
        }
    }

     /***
     * Método usado para conectar no server socket, retorna IO Exception caso dê algum erro.
     * @throws IOException
     */
    public void conectar(int porta) throws Exception{

        socket = new Socket(IP,porta);
        ou = socket.getOutputStream();

        pw = new PrintWriter(ou,true); 

        this.enviarMensagem("");
        }

    /***
     * Método usado para enviar mensagem para o server socket
     * @param msg do tipo String
     * @throws IOException retorna IO Exception caso dê algum erro.
     */
    public void enviarMensagem(String msg) {
        pw.println(aes.encripta(msg));
    }

    /**
     * Método usado para receber mensagem do servidor
     * @throws IOException retorna IO Exception caso dê algum erro.
     */
    public void escutar(ClienteSocketHandler handler){
        new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    InputStream in = socket.getInputStream();
                    InputStreamReader inr = new InputStreamReader(in);
                    BufferedReader bfr = new BufferedReader(inr);
                    String msg = "";
                    while(!"Sair".equalsIgnoreCase(msg)){
                        if(bfr.ready()){
                            String mensagem=bfr.readLine();

                            msg = aes.decripta(mensagem);

                            handler.handle(msg);
                        }
                    }
                }
                catch(Exception err){} 
            }
        }).start();

        
    }
}
