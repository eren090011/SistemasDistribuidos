/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package handlers;

import UI.ChatForm;
import com.proyectocliente.client.SocketProcess;
import java.util.ArrayList;

/**
 *
 * @author Jesus
 */
public class ServerListener implements Runnable {
    private SocketProcess serverInput;
    private ChatForm chatForm;
    

    public ServerListener(SocketProcess serverInput, ChatForm chatForm) {
        this.serverInput = serverInput;
        this.chatForm=chatForm;
        
    }

    @Override
    public void run() {
        while (true) {
            
               ArrayList<Object> dataRequest = (ArrayList<Object>) serverInput.read();
               
               if (dataRequest != null && !dataRequest.isEmpty()) {
                   // Si la respuesta que entro tiene 1 elemento, es un mensaje
                   if(dataRequest.size()<2){
                        String mensaje = dataRequest.get(0).toString();
                        agregarAlChat(mensaje);
                   }else{
                       // de lo contrario se trata de una actualizacion de la lista 
                       // se obtiene los usuarios conectados 
                       ArrayList <String> Users= (ArrayList) dataRequest.get(1);
                        // se actualiza la lista
                        actListaUsuarios(Users);
                   }
                }
        }
    }
    private void actListaUsuarios(ArrayList<String> usuariosConectados) {
        // Aca se´pone las operaciones para actualizar los usuarios, aca puse printear solo por probar que servia
        // pero puede ser cosas tipo actualizar una caja donde esten los nombres
        chatForm.actUsers(usuariosConectados);
     
}
   private void agregarAlChat(String mensaje){
       if (chatForm != null) {
            chatForm.appendMessage(mensaje);
        }
       
   }
}