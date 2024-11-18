/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SocketSample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        // Este es el socket del cliente
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;
        
        // Se realiza el bind osea la conexion
        try {
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");
            // se le puede cambiar el true por un parametro que definira 
            // cuando se cierra la conexion
            while(true){
                // Se queda a la espera, es el accept
                sc  = servidor.accept();
                System.out.println("Cliente conectado");
                // mensaje del cliente al servidor (read)
                in = new DataInputStream(sc.getInputStream());
                // mensaje del servidor al cliente (write)
                out = new DataOutputStream(sc.getOutputStream());
                // se queda a la espera de que el cliente le envie algo
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                // responde el mensaje
                out.writeUTF("Hola mundo desde el servidor");
                // se cierra el cliente
                sc.close();
                System.out.println("Cliente desconectado");
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

