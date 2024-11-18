/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enviarDatos;

import com.proyectocliente.client.Client;
import com.proyectocliente.client.SocketProcess;
import com.proyectocliente.java_client_socket.JavaClientSocket;
import com.proyectocliente.ui.Menu;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Enviador {
    
    // metodo para enviar los datos pa iniciar sesion
    public boolean enviarClave(String id, String clave,String operacion){
        System.out.println("Java Client Socket");
        // 1. se instancia el socket del cliente
        JavaClientSocket javaClientSocket = new JavaClientSocket (1802, "localhost");
        // metodo para crear y devolver un socket
        Socket clientSocket = javaClientSocket.get();

        // 2. se verifica si el socker que se creo esta bien
        if (clientSocket == null) {
            System.out.println("ServerSocket is null");
            return false;
        }else{
            System.out.println("Socket Creado con exito");
        }

        // 2. se crea el server
        SocketProcess client= new Client(clientSocket);
        // 3. se inicia la sesion
        if (!client.connect()) {
            // si falla detiene todo
            System.out.println("Conexion al server fallida");
            return false;
        }else{
            System.out.println("Conectado al servidor");
        }
        // se crea un array donde se guarda los datos a enviar
        ArrayList<Object> dataRequest = new ArrayList<>();
        dataRequest.add(id);
        dataRequest.add(clave);
        dataRequest.add(operacion);

        dataRequest.add(0);
        // se envia la request
        client.write(dataRequest);


        // se crea un array donde se guarda los datos a del response
        ArrayList<Object> dataResponse = (ArrayList<Object>) client.read(); 
        for (Object response : dataResponse) {
            System.out.println(response);
        }
        


         // Se cierra el cliente
        if (!client.close()) {
            System.out.println("Client close failed");
            return false;
        }
        System.out.println("Java Client Socket closed");
        if ("Acceso Concedido".equals(dataResponse.get(0))){
            return true;
        }
        return false; 
    }
    
    // metodo para enviar los datos pa consultar saldo
        public String consultarSaldo(String id,String tarjeta,String operacion){
        System.out.println("Java Client Socket");
        // 1. se instancia el socket del cliente
        JavaClientSocket javaClientSocket = new JavaClientSocket (1802, "localhost");
        // metodo para crear y devolver un socket
        Socket clientSocket = javaClientSocket.get();

        // 2. se verifica si el socker que se creo esta bien
        if (clientSocket == null) {
            System.out.println("ServerSocket is null");
            return "error";
        }else{
            System.out.println("Socket Creado con exito");
        }

        // 2. se crea el server
        SocketProcess client= new Client(clientSocket);
        // 3. se inicia la sesion
        if (!client.connect()) {
            // si falla detiene todo
            System.out.println("Conexion al server fallida");
            return "error";
        }else{
            System.out.println("Conectado al servidor");
        }
        // se crea un array donde se guarda los datos a enviar
        ArrayList<Object> dataRequest = new ArrayList<>();
        dataRequest.add(id);
        dataRequest.add(tarjeta);
        dataRequest.add(operacion);
     
      
        dataRequest.add(0);
        // se envia la request
        client.write(dataRequest);


        // se crea un array donde se guarda los datos a del response
        ArrayList<Object> dataResponse = (ArrayList<Object>) client.read(); 
        for (Object response : dataResponse) {
            System.out.println(response);
        }
        


         // Se cierra el cliente
        if (!client.close()) {
            System.out.println("Client close failed");
            return "error";
        }
       
        System.out.println("Java Client Socket closed");
        
        return(dataResponse.get(0).toString());
    }
    // metodo para enviar los datos pa retirar
    public String retirarSaldo(String id,String cantidad,String operacion){
        System.out.println("Java Client Socket");
        // 1. se instancia el socket del cliente
        JavaClientSocket javaClientSocket = new JavaClientSocket (1802, "localhost");
        // metodo para crear y devolver un socket
        Socket clientSocket = javaClientSocket.get();

        // 2. se verifica si el socker que se creo esta bien
        if (clientSocket == null) {
            System.out.println("ServerSocket is null");
            return "error";
        }else{
            System.out.println("Socket Creado con exito");
        }

        // 2. se crea el server
        SocketProcess client= new Client(clientSocket);
        // 3. se inicia la sesion
        if (!client.connect()) {
            // si falla detiene todo
            System.out.println("Conexion al server fallida");
            return "error";
        }else{
            System.out.println("Conectado al servidor");
        }
        // se crea un array donde se guarda los datos a enviar
        ArrayList<Object> dataRequest = new ArrayList<>();
        dataRequest.add(id);
        dataRequest.add(cantidad);
        dataRequest.add(operacion);
     
      
        dataRequest.add(0);
        // se envia la request
        client.write(dataRequest);


        // se crea un array donde se guarda los datos a del response
        ArrayList<Object> dataResponse = (ArrayList<Object>) client.read(); 
        for (Object response : dataResponse) {
            System.out.println(response);
        }
        


         // Se cierra el cliente
        if (!client.close()) {
            System.out.println("Client close failed");
            return "error";
        }
       
        System.out.println("Java Client Socket closed");
        
        return(dataResponse.get(0).toString());
        
    }
    
    public String ConsignarDinero(String id,String cantidad, String tarjeta,String operacion){
        System.out.println("Java Client Socket");
        // 1. se instancia el socket del cliente
        JavaClientSocket javaClientSocket = new JavaClientSocket (1802, "localhost");
        // metodo para crear y devolver un socket
        Socket clientSocket = javaClientSocket.get();

        // 2. se verifica si el socker que se creo esta bien
        if (clientSocket == null) {
            System.out.println("ServerSocket is null");
            return "error";
        }else{
            System.out.println("Socket Creado con exito");
        }

        // 2. se crea el server
        SocketProcess client= new Client(clientSocket);
        // 3. se inicia la sesion
        if (!client.connect()) {
            // si falla detiene todo
            System.out.println("Conexion al server fallida");
            return "error";
        }else{
            System.out.println("Conectado al servidor");
        }
        // se crea un array donde se guarda los datos a enviar
        ArrayList<Object> dataRequest = new ArrayList<>();
        dataRequest.add(id);
        dataRequest.add(cantidad);
        dataRequest.add(tarjeta);
        dataRequest.add(operacion);
     
      
        dataRequest.add(0);
        // se envia la request
        client.write(dataRequest);


        // se crea un array donde se guarda los datos a del response
        ArrayList<Object> dataResponse = (ArrayList<Object>) client.read(); 
        for (Object response : dataResponse) {
            System.out.println(response);
        }
        


         // Se cierra el cliente
        if (!client.close()) {
            System.out.println("Client close failed");
            return "error";
        }
       
        System.out.println("Java Client Socket closed");
        
        return(dataResponse.get(0).toString());
        
    }
}
