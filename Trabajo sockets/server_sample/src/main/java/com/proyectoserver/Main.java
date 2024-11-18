package com.proyectoserver;

import Operaciones.Cuenta;
import Operaciones.Operaciones;
import java.net.ServerSocket;
import java.util.ArrayList;

import com.proyectoserver.java_server_socket.JavaServerSocket;
import com.proyectoserver.server.Server;
import com.proyectoserver.server.SocketProcess;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            
            // inicializar cuentas
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(new Cuenta("123456", "2324", 30000,30000));
            cuentas.add(new Cuenta("654321", "0911", 40000, 70000));
            cuentas.add(new Cuenta("234567", "1234", 60000,60000));
            System.out.println("Java Server Socket");

            // 1. se instancia el socket del server
            JavaServerSocket javaServerSocket = new JavaServerSocket(1802, 100);

             // metodo para crear y devolver un socket
            ServerSocket serverSocket = javaServerSocket.get();
            // 2. se verifica si el socker que se creo esta bien
            if (serverSocket == null) {
                System.out.println("ServerSocket is null");
                return;
            }else{
                
                System.out.println("Socket Creado con exito");
            }
            while(true){
            // 2. se crea el server
            SocketProcess server = new Server(serverSocket);
            // 3. se inicia la sesion

            if (!server.bind()) {
                // si falla detiene todo
                System.out.println("Server bind failed");
                return;
            }else{
                System.out.println("Cliente conectado");
            }

            // Se guarda en una variable lo que mando el usuario
            ArrayList<Object> dataRequest = (ArrayList<Object>) server.listen(); 
            
            // una vez deja de escuchar, se crea la response
            ArrayList<Object> dataResponse = new ArrayList<>();
            Operaciones op = new Operaciones();
            
            
            int pIndex = dataRequest.size()-1;
            String operacion = dataRequest.get(pIndex).toString();
            String id = dataRequest.get(0).toString();
            String respuesta ="";
            String cantidadTexto="";
            int cantidadNumero=0;
            int saldo=0;
            String resSacar="";
            String tarjeta="";
            String resCons="";
        
            // Preguntar que operarcion es
            switch (operacion){
                case "Ingresar clave":
                    
                    String clave = dataRequest.get(1).toString();
                    respuesta= op.verificarCuenta(cuentas,id, clave);
                    dataResponse.add(respuesta); 
                    break;
                case "Consultar saldo":
                    tarjeta= dataRequest.get(1).toString();
                    saldo=op.consultarSaldo(cuentas, id, tarjeta);
                    respuesta = String.valueOf(saldo);
                    dataResponse.add(respuesta); 
                    break;
                case "Sacar dinero debito":
                    cantidadTexto= dataRequest.get(1).toString();
                    cantidadNumero=Integer.parseInt(cantidadTexto);
                    tarjeta="debito";
                    resSacar=op.sacarDineroDeb(cuentas, id, cantidadNumero);
                    if("dinero retirado con exito".equals(resSacar)){
                        saldo=op.consultarSaldo(cuentas, id, tarjeta);
                        respuesta = String.valueOf(saldo);
                    }
                    else{
                        respuesta=resSacar;
                    }
                    dataResponse.add(respuesta); 
                    break;
                case "Hacer avance":
                    cantidadTexto= dataRequest.get(1).toString();
                    cantidadNumero=Integer.parseInt(cantidadTexto);
                    tarjeta="credito";
                    resSacar=op.sacarDineroCred(cuentas, id, cantidadNumero);
                    if("dinero retirado con exito".equals(resSacar)){
                        saldo=op.consultarSaldo(cuentas, id, tarjeta);
                        respuesta = String.valueOf(saldo);
                    }
                    else{
                        respuesta=resSacar;
                    }
                    dataResponse.add(respuesta); 
                    break;
                case"Consignar dinero":
                    cantidadTexto= dataRequest.get(1).toString();
                    cantidadNumero=Integer.parseInt(cantidadTexto);
                    tarjeta= dataRequest.get(2).toString();
                    resCons=op.consignarDinero(cuentas, id, cantidadNumero, tarjeta);
                    boolean sCred= "dinero cosignado exitosamente en la tarjeta de credito".equals(resCons);
                    boolean sDeb= "dinero cosignado exitosmente en la tarjeta de debito".equals(resCons);
                    if(sCred || sDeb){
                        saldo=op.consultarSaldo(cuentas, id, tarjeta);
                        // envia el saldo nuevo
                        respuesta = String.valueOf(saldo);
                    }
                    else{
                        // envia el error
                        respuesta=resCons;
                    }
                    dataResponse.add(respuesta); 
                    break;
                default: 
                    dataResponse.add("Operacion Invalida");
                    break;
                    
                    
            }
            
            
           
            // agrega cada objeto a la respuesta
            // agrega el 0 para que el cliente lo lea como critero de parada
            dataResponse.add(0);
            // envia la response
            server.response(dataResponse);

            // cierra el server
            if (!server.close()) {
                System.out.println("Server close failed");
                return;
            }

            System.out.println("Java Server Socket closed");
            }
        

    }
}