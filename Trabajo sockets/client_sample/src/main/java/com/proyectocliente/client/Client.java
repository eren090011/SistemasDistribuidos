/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.proyectocliente.client;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client implements SocketProcess{
    Socket clientSocket;
    Session session;

    public Client(Socket clientSocket){
        this.clientSocket = clientSocket;
		this.session = null;

    }

    // Importante, no se inicia la sesion hasta que no se conecta
    @Override
    public boolean connect() {
        try {
            // Se acepta a la conexion
            Socket socket = this.clientSocket;
            // se inicia la sesion
            this.session = new Session(socket);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // escucha los datos que envia el server y los agrega a una lista de objetos
    @Override
    public List<Object> read(){
        // crea un array en el cual se guardara los objetos leidos
        ArrayList<Object> dataList = new ArrayList<>();
        // Permite que el bucle continue mientras sea true
        boolean next = true;
        // se crea a variable en la cual se guardara la data de cada objeto
        Object data = null;
        // valor que indicara si se debe recibir mas datos o no
        // !0 si / 0 no
        int flag = 1; 
        // mientras que se le indique continuar, continua leyendo
        while(next){
            // lee un objeto del Object input stream y lo almacena en data
            data =this.session.read();
            // compara si el objeto que se leyo es nulo
            if (data != null){
                // se intenta convertir el objeto en un numero y asignar
                // como valor de flag
                // esto por si se ingreso un "0" 
                try {
                    flag = (int) data;
                }catch(Exception e){
                    // si falla continua normal
                    flag = 1;
                }
                try {
                // Se pregunta si la flag no vale 0. se continua
                next = flag!=0;
                // Si la flag no vale 0 se agrega el objeto a la lista
                if (next) {
                    dataList.add(data);
                }
                } catch (Exception e) {
                    // si fallo algo se muestra el error
                    e.printStackTrace();
                }
            }
        }
        return dataList;
    }

    // ingresa una lista de objetos que se le enviara como peticion al server
    @Override
    public boolean write(List<Object> data) {
        // envia cada objeto de la lista 
        data.forEach(d -> this.session.write(d));
            return true;
    }

    @Override
    public boolean close() {
        // cierra la session y devuelve si fue exitoso el cierre
        boolean successful = this.session.close();
		this.session = null;
		return successful;
    }

    
}
    




