/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lenin;

import edu.lenin.controlador.Controlador;
import java.rmi.RemoteException;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Jesus
 */
public class NewsService extends UnicastRemoteObject implements RMINEWS {

  public NewsService() throws RemoteException {
    super();
  }

    @Override
    public List<Object[]> getNews() throws RemoteException {
        Controlador c = new Controlador();
        return c.listaNoticias();
    }

    @Override
    public Boolean createNews(String Titulo, String Contenido, int idAutor) throws RemoteException {
        Controlador c = new Controlador();
        return c.crearNoticia(Titulo, Contenido, idAutor);
    }

    @Override
    public Boolean updateNews(int idNoticia, String Titulo, String Contenido) throws RemoteException {
        Controlador c = new Controlador();
        return c.actualizarNoticia(idNoticia, Titulo, Contenido);
    }

    @Override
    public Boolean deleteNews(int idNoticia) throws RemoteException {
        Controlador c = new Controlador();
        return c.eliminarNoticia(idNoticia);
    }

    

}