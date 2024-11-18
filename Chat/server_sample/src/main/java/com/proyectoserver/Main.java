// Main.java
package com.proyectoserver;

import Handlers.ClientHandler;
import UI.LogServer;
import java.net.ServerSocket;
import com.proyectoserver.java_server_socket.JavaServerSocket;
import com.proyectoserver.server.Server;
import com.proyectoserver.server.SocketProcess;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Server Socket");
        // Crear la interfaz gráfica para los logs
        LogServer logServer = new LogServer();
        logServer.setLocationRelativeTo(null);  
        logServer.setVisible(true);
        

        // 1. se instancia el socket del server
        JavaServerSocket javaServerSocket = new JavaServerSocket(1802, 100);

        ServerSocket serverSocket = javaServerSocket.get();
        if (serverSocket == null) {
            System.out.println("ServerSocket is null");
            return;
        }
        while (true) {
            SocketProcess server = new Server(serverSocket);

            if (!server.bind()) {
                System.out.println("Server bind failed");
                return;
            } else {
                System.out.println("Se conectó un Usuario");
            }

            // Crear un hilo para manejar al cliente
            ClientHandler clientHandler = new ClientHandler(server, logServer);
            clientHandler.start();
            
        }
    }
}
