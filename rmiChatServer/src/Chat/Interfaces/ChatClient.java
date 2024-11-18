/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Chat.Interfaces;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Jesus
 */
public interface ChatClient extends Remote {
    void receiveMessage(String message) throws RemoteException;
    
}
