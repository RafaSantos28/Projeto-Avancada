package io.sim.Projeto;

import java.io.BufferedReader;
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

    public void conectar(int porta) throws Exception{

        socket = new Socket(IP,porta);
        ou = socket.getOutputStream();

        pw = new PrintWriter(ou,true); 

        this.enviarMensagem("");
        }

    public void enviarMensagem(String msg) {
        pw.println(aes.encripta(msg));
    }

    
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
