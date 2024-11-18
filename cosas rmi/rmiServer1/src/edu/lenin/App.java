package edu.lenin;

import java.rmi.RemoteException;

public class App {
    public static void main(String[] args) throws RemoteException {
        System.out.println("Hello RMI!");

        Server server = new Server("localhost", "5000");
        /*
        Client client = new Client("192.168.1.7", "2000", "usr");
        
        System.out.println(client.loginUser("cote", "cote123"));*/
        
        RMIUSERS usr =new UsersService();
        RMINEWS nws =new NewsService();
        

        // Agregar diferentes tipos de servicios
        
        server.addService("usr", usr);
        server.addService("nws", nws);

        // Desplegar los servicios
        if (server.deploy()) {
            System.out.println("Todos los servicios han sido desplegados exitosamente.");
        } else {
            System.out.println("Fallo al desplegar los servicios.");
        }
    }
}

