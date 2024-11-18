/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hilosampl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");
            
            Socket sc = new Socket("127.0.0.1",5000);
            
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());
            
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            
            String nombre=sn.next();
            out.writeUTF(nombre);
            ClienteHilo hilo = new ClienteHilo(in,out);
            hilo.start();
            // esperamos a que el hilo acabe pa continuar
            hilo.join();
            
        }catch(IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
