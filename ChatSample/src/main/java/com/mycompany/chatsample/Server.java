/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatsample;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

class ClientHandler extends Thread {
    private Socket clientSocket;
    private BufferedReader input;
    private PrintWriter output;
    private String clientName;
    private static List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            //entrada se
            this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //salida
            this.output = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            // Pedir un nombre de usuario único
            requestUniqueName();

            logEvent(clientName + " se ha conectado");
            broadcast("Servidor: " + clientName + " se ha unido al chat", this);

            // Añadir este cliente a la lista de clientes conectados
            clients.add(this);

            String message;
            // Bucle para escuchar mensajes del cliente
            while ((message = input.readLine()) != null) {
                logEvent(clientName + ": " + message);
                broadcast(clientName + ": " + message, this);
            }
        } catch (IOException e) {
            // Manejar la desconexión del cliente sin imprimir el stack trace
            if (e instanceof SocketException) {
                logEvent("Conexión con " + clientName + " se ha cerrado inesperadamente.");
            } else {
                e.printStackTrace();
            }
        } finally {
            // Eliminar el cliente de la lista y cerrar la conexión
            clients.remove(this);
            logEvent(clientName + " se ha desconectado");
            broadcast("Servidor: " + clientName + " ha salido del chat", null);
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para solicitar un nombre de usuario único
    private void requestUniqueName() throws IOException {
        while (true) {
            output.println("Ingrese su nombre:");
            clientName = input.readLine();

            if (isNameTaken(clientName)) {
                output.println("El nombre '" + clientName + "' ya está en uso. Por favor, elija otro.");
            } else {
                break; // Nombre único encontrado
            }
        }
    }

    // Método para verificar si un nombre ya está en uso
    private boolean isNameTaken(String name) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client.clientName != null && client.clientName.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método para enviar un mensaje a todos los clientes conectados, excepto al remitente
    private void broadcast(String message, ClientHandler sender) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.output.println(message);
                }
            }
        }
    }

    // Método para registrar eventos en la consola del servidor
    private void logEvent(String event) {
        String timestamp = dateFormat.format(new Date());
        System.out.println("[" + timestamp + "] " + event);
    }
}

public class Server {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor esperando conexiones...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + clientSocket.getInetAddress());

                // Crear un hilo para manejar al cliente
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
