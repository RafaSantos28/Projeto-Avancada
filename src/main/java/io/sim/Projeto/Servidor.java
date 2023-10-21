package io.sim.Projeto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread{
    ServerSocket server;
    int port;
    AES aes;
    ServidorHandler handler;

    public Servidor(int port,ServidorHandler handler){
       this.port = port;
       aes = new AES();
       this.handler=handler;
    }

    // public static void main(String[] args ){
    //     Servidor servidor = new Servidor(5000);

    //     servidor.start();
    // }

    @Override
    public void run(){
        try{
            server = new ServerSocket(port);
            while(true) {
                Socket cliente = server.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

                new Thread(new Runnable() {
                @Override
                public void run(){
                try{ 
                    OutputStream ou =  cliente.getOutputStream();
                    Writer ouw = new OutputStreamWriter(ou);
                    
                    InputStream in = cliente.getInputStream();
                    InputStreamReader inr= new InputStreamReader(in);
                    
                    BufferedReader bfr = new BufferedReader(inr);

                    String msg = aes.decripta(bfr.readLine());    

                    while(!"Sair".equalsIgnoreCase(msg) && msg != null)
                    {
                        msg = aes.decripta(bfr.readLine());
                        
                        new PrintWriter(ouw,true).println(aes.encripta(handler.handle(msg)));
                        
                        System.out.println(msg);
                    }

                }
                catch(Exception err){
                    System.out.println(err.getMessage());
                }
            }}).start();
            }
        }
        catch(Exception err){}
    }

}