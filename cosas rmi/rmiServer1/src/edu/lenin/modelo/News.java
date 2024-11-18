/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lenin.modelo;

/**
 *
 * @author Jesus
 */
public class News {
    private int id;
    private String titulo;
    private String contenido;
    private int idAutor;
    
    public News(){
        
    }

    public News(int id, String titulo, String contenido, int idAutor) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.idAutor = idAutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }
    
    @Override
    public String toString() {
        return "News{" +
           "id=" + id +
           ", titulo='" + titulo + '\'' +
           ", contenido='" + contenido + '\'' +
           ", idAutor=" + idAutor +
           '}';
    }

    
    
}
