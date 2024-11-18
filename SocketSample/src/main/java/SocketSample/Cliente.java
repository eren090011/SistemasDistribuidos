/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package SocketSample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesus
 */
public class Cliente {

    public static void main(String[] args) {
        // a quien me voy a conectar
        final String HOST = "127.0.0.1";
        final int PUERTO = 5000;
        DataInputStream in;
        DataOutputStream out;
        
        try{
            Socket sc = new Socket(HOST,PUERTO);
            
            // mensaje del servidor al cliente (read)
            in = new DataInputStream(sc.getInputStream());
            // mensaje del cliente al servidor(write)
            out = new DataOutputStream(sc.getOutputStream());
            
            // escribe el mensaje
            out.writeUTF("Hola mundo desde el cliente");
            // lee el mensaje
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }                
}

