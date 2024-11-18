/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correo_servidor;

import correo_servidor.Server.Interfaz.InterfaceServer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesus
 */
public class Client {
    private static InterfaceServer server;
    
    public boolean conectarse(){
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (InterfaceServer) registry.lookup("Server");
            return true;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error conectando al servidor RMI", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }
    public String Login(String nombre, String password) throws RemoteException{
        this.conectarse();
        return server.Usuario(nombre, password);
    }
    public boolean esAdmin(String Nombre) throws SQLException, RemoteException{
        this.conectarse();
        return server.esAdministrador(Nombre);
    }
    
}
