package edu.lenin;

import edu.lenin.controlador.Controlador;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsersService extends UnicastRemoteObject implements RMIUSERS {

  public UsersService() throws RemoteException {
    super();
  }

    @Override
    public List<Object[]> getUsuarios() throws RemoteException {
       Controlador c =new Controlador();
       return c.listar();
    }

    @Override
    public boolean RegisterUser(String name, String password) throws RemoteException {
        Controlador c =new Controlador(); 
        return c.agreagarUsuario(name, password);
    }

    @Override
    public boolean UpdateUser(int id, String name, String password) throws RemoteException {
        Controlador c =new Controlador();
        return c.actualizarUsuario(id, name, password);
    }

    @Override
    public boolean DeleteUser(int id) throws RemoteException {
        Controlador c=new Controlador();
        return c.eliminarUsuario(id);
    }

    @Override
    public int loginUser(String name, String password) throws RemoteException {
        Controlador c= new Controlador();
        return c.login(name, password);
    }
    
  
}
