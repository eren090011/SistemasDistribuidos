/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lenin.controlador;


import edu.lenin.modelo.News;
import edu.lenin.modelo.NewsCrud;
import edu.lenin.modelo.User;
import edu.lenin.modelo.UserCrud;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Controlador{
    
    UserCrud crudUs = new UserCrud();
    NewsCrud crudNews = new NewsCrud();
    User us = new User();
    News nw =new News();
    DefaultTableModel modelo = new DefaultTableModel();
    
   
    
    
    
    public List<Object[]> listar() {
        List<Object[]> datos = new ArrayList<>();
        List<User> lista = crudUs.listar();

        for (User user : lista) {
            Object[] fila = new Object[3];
            fila[0] = user.getId();
            fila[1] = user.getName();
            fila[2] = user.getPassword();
            datos.add(fila);
        }

        return datos;
    }
    
    public int login(String name, String password) {
        List<Object[]> datos = new ArrayList<>();
        List<User> lista = crudUs.login(name, password);
        if (lista.isEmpty()) {
            //System.out.println("la lista esta vacia");
            return 0;
        } else {
            //System.out.println(lista.get(0).getId());
            return lista.get(0).getId();
        }

        
    }
    
    public boolean agreagarUsuario(String nombre, String password) {
        return crudUs.agregar(nombre,password);
    }
    
    public boolean actualizarUsuario(int id, String nombre, String password){
        return crudUs.actualizar(id, nombre, password);
    }
    public boolean eliminarUsuario(int id){
        if(crudNews.borrarNoticiasUsuario(id)){
            return crudUs.borrar(id);
        }return false;
        
        
    }
    
    
    // noticias
    public List<Object[]> listaNoticias() {
        List<Object[]> datos = new ArrayList<>();
        List<News> lista = crudNews.listar();

        for (News news : lista) {
            Object[] fila = new Object[4];
            fila[0] = news.getId();
            fila[1] = news.getTitulo();
            fila[2] = news.getContenido();
            fila[3] = getNombre(news.getIdAutor());
            
            datos.add(fila);
        }

        return datos;
    }
    public boolean crearNoticia(String titulo, String contenido,int idAutor) {
        return crudNews.agregar(titulo, contenido,idAutor);
    }
    public boolean actualizarNoticia(int id, String titulo, String contenido) {
        return crudNews.actualizar(id, titulo, contenido);
    }
    public boolean eliminarNoticia(int id){
        return crudNews.borrar(id);
    }
    
    public String getNombre(int id) {
        List<Object[]> datos = new ArrayList<>();
        List<User> lista = crudUs.nombreAutor(id);
        if (lista.isEmpty()) {
            
            return "error";
        } else {
            //System.out.println(lista.get(0).getId());
            return lista.get(0).getName();
        }

        
    }
    
    
            
    
}
