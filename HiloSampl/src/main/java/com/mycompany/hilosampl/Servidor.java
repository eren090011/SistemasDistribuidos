/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hilosampl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // se crea el socket del server
        try{
            ServerSocket server =new ServerSocket(5000);
            Socket sc;
            System.out.println("Servidor iniciado");
            while(true){
                sc= server.accept();
                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());
                out.writeUTF("Indica tu nombre");
                // lee la request 
                String nombreCliente = in.readUTF();
                
                ServidorHilo hilo = new ServidorHilo(in,out,nombreCliente);
                //empieza un hilo
                hilo.start();
                System.out.println("Creada la conexion con el cliente "+nombreCliente);
            }
        }catch(IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        
    }
    
}
