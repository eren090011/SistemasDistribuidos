/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.clientchatsample;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Hilo para escuchar mensajes del servidor
            new Thread(new ServerListener(input)).start();

            // Leer mensajes desde la consola para enviarlos al servidor
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            while ((userInput = consoleReader.readLine()) != null) {
                output.println(userInput); // Enviar mensaje al servidor
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ServerListener implements Runnable {
    private BufferedReader serverInput;

    public ServerListener(BufferedReader serverInput) {
        this.serverInput = serverInput;
    }

    @Override
    public void run() {
        try {
            String serverMessage;
            while ((serverMessage = serverInput.readLine()) != null) {
                System.out.println(serverMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
