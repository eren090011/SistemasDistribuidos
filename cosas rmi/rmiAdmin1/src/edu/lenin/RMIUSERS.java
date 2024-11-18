package edu.lenin;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public interface RMIUSERS extends Remote {
    
    // Metoodos creacion usuarios
    // Metodos cliente
    public int loginUser(String name,String password) throws RemoteException;  
    
    // Crud admin
    public boolean RegisterUser(String name,String password) throws RemoteException; 
    public Boolean DeleteUser(int id) throws RemoteException; 
    public Boolean UpdateUser(int id,String name, String password) throws RemoteException; 
    
    // info usuarios
    // obtener todos los usuarios
    public List<Object[]> getUsuarios() throws RemoteException;
    /*
    // Por objeto user
    public User Devolverusuario(String name,String password) throws RemoteException;  // return User;
    public int DevolverId(User usuario) throws RemoteException;  //return usuario.getId
    public String DevolerNombre(User usuario) throws RemoteException;  //return usuario.getName()
    public String DevolverPassword(User usuario) throws RemoteException;  //return usuario.getPassword()
    //por id usuario
    public String NombrePorId(int id);
    public String PasswordPorId(int id);*/
}