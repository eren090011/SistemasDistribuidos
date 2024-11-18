/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Handlers;

import UI.LogServer;
import com.proyectoserver.server.SocketProcess;
import java.io.IOException;


import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;


/**
 *
 * @author Jesus
 */
public class ClientHandler extends Thread {
    private SocketProcess serverSocket;
    private String nombreUsuario;
    private static List<ClientHandler> clientes = Collections.synchronizedList(new ArrayList<>());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private LogServer logServer;

    public ClientHandler(SocketProcess serverSocket, LogServer logServer) {
        this.serverSocket = serverSocket;
        this.logServer = logServer;
    }

    @Override
    public void run() {
        try {
            pedirNombre();
            logEvent(nombreUsuario + " se ha conectado");
            broadcast(nombreUsuario + " se ha unido al chat", this);
            addUserLog(nombreUsuario);
            clientes.add(this);
            broadcastUserList();

            while (true) {
                ArrayList<Object> dataRequest = (ArrayList<Object>) serverSocket.listen();
                if (dataRequest != null && !dataRequest.isEmpty()) {
                    String mensaje = dataRequest.get(0).toString();
                    
                    if ("-/DISCONNECT".equals(mensaje)) {
                        break; 
                    }
                    logEvent(nombreUsuario + ": " + mensaje);
                    
                    broadcast(nombreUsuario + ": " + mensaje, this);
                   
                }
            }
        } catch (java.io.EOFException eof) {
            logEvent("Conexión cerrada por " + nombreUsuario);
        } catch (IOException e) {
            if (e instanceof SocketException) {
                logEvent("Conexión con " + nombreUsuario + " se ha cerrado inesperadamente.");
            } else {
                e.printStackTrace();
            }
        } finally {
            
            clientes.remove(this);
            logEvent(nombreUsuario + " se ha desconectado");
            broadcast("Servidor: " + nombreUsuario + " ha salido del chat", null);
            removeUserLog(nombreUsuario);
            broadcastUserList();

            
        }
    }

    private void logEvent(String event) {
        if (logServer != null) {
            logServer.appendLog( event);
        }
    }
    private void addUserLog(String UserName) {   
        if (logServer != null) {
            logServer.addUser(UserName);
        }
    }
    private void removeUserLog(String UserName) {
        if (logServer != null) {
            logServer.removeUser(UserName);
        }
    }
    
    private void pedirNombre() throws IOException{
     
   
        while (true) {
            ArrayList<Object> dataResponse = new ArrayList<>();
            dataResponse.add("Ingrese su nombre");
            dataResponse.add(0);
            serverSocket.response(dataResponse);
            ArrayList<Object> dataRequest = (ArrayList<Object>) serverSocket.listen();
            
                nombreUsuario = dataRequest.get(0).toString();
                if (!isNameTaken(nombreUsuario)) {
                    break; // Nombre único encontrado
                }
                // Enviar mensaje al cliente que el nombre ya está en uso
                 dataResponse.clear();
                 dataResponse.add("El nombre '" + nombreUsuario + "' ya está en uso. Por favor, elija otro.");
                 dataResponse.add(0);
                  serverSocket.response(dataResponse);
                //
            
        }
    }
    
    private void broadcastUserList() {
        synchronized (clientes) {
            ArrayList<String> usuariosConectados = new ArrayList<>();
            for (ClientHandler client : clientes) {
                if (client.nombreUsuario != null) {
                    usuariosConectados.add(client.nombreUsuario);
                }
            }
            for (ClientHandler client : clientes) {
                client.enviarListaUsuarios(usuariosConectados);
            }
        }
    }
    private boolean isNameTaken(String name) {
        synchronized (clientes) {
            for (ClientHandler client : clientes) {
                if (client.nombreUsuario != null && client.nombreUsuario.equals(name)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    private void broadcast(String mensaje, ClientHandler sender) {
        synchronized (clientes) {
            for (ClientHandler client : clientes) {
                if (client != sender) {
                    // Enviar el mensaje al cliente
                    client.enviarMensaje(mensaje); 
                }
            }
        }    
    }
    
    private void enviarListaUsuarios(List<String> usuarios) {
        ArrayList<Object> dataResponse = new ArrayList<>();
        dataResponse.add("lista de usuarios"); 
        dataResponse.add(usuarios); // La lista de usuarios conectados
        dataResponse.add(0); 
        serverSocket.response(dataResponse);
    }
    private void enviarMensaje(String message) {
       
        ArrayList<Object> dataResponse = new ArrayList<>();
        dataResponse.add(message);
        dataResponse.add(0);
        serverSocket.response(dataResponse);
    }
    

    
}
