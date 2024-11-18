package com.proyectocliente;

import UI.ChatForm;
import com.proyectocliente.client.Client;
import com.proyectocliente.client.SocketProcess;
import com.proyectocliente.java_client_socket.JavaClientSocket;
import java.io.BufferedReader;
import handlers.ServerListener;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java Client Socket");
        
        // Abre la interfaz grafica del chat
        // 1. Se instancia el socket del cliente
        JavaClientSocket javaClientSocket = new JavaClientSocket(1802, "localhost");
        Socket clientSocket = javaClientSocket.get();
        // 2. Se verifica si el socket que se creó está bien
        if (clientSocket == null) {
            System.out.println("Socket está nulo");
            return;
        } else {
            System.out.println("Socket Creado con éxito");
        }
        // 3. Se crea el cliente
        SocketProcess client = new Client(clientSocket);
        // 4. Se inicia la sesión
        if (!client.connect()) {
            System.out.println("Conexión al servidor fallida");
            return;
        } else {
            System.out.println("Conectado al servidor");
        }
        ChatForm chatForm = new ChatForm(client);
        chatForm.setLocationRelativeTo(null);
        
        // Iniciar el hilo para escuchar al servidor
        new Thread(new ServerListener(client,chatForm)).start();
        while(chatForm.getConectado()){
           chatForm.setVisible(true); 
        }
        

        
        if (!client.close()) {
            System.out.println("Fallo al cerrar el cliente");
        }
        System.out.println("Cliente cerrado");
        System.exit(0);
    }
}



