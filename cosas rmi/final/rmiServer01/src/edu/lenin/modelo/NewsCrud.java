/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lenin.modelo;

import edu.lenin.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus
 */
public class NewsCrud {
    Conexion conectar =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public List listar(){
        List<News>datos = new ArrayList<>();
        String sql = "SELECT * FROM noticias";
        try {
            con= conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {  
                
                
                News nw = new News();
                
                nw.setId(rs.getInt(1));
                nw.setTitulo(rs.getString(2));
                nw.setContenido(rs.getString(3));
                nw.setIdAutor(rs.getInt(4));
                datos.add(nw);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;    
    }
    
    public boolean agregar(String titulo, String contenido,int idAutor) {
    String sql = "INSERT INTO noticias (noTitulo, noContenido, fk_autor) VALUES (?, ?,?);";
    try {
        con = conectar.getConnection();  
        ps = con.prepareStatement(sql);  
        ps.setString(1, titulo);         
        ps.setString(2, contenido);
        ps.setInt(3, idAutor); 
        ps.executeUpdate();              
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) ps.close();  
            if (con != null) con.close(); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    return true;
    }
    
    public boolean actualizar(int id, String titulo, String contenido) {
    String sql = "UPDATE noticias SET noTitulo=?, noContenido=? WHERE idNoticia=?;";
    try {
        con = conectar.getConnection();  
        ps = con.prepareStatement(sql);  
        ps.setString(1, titulo);         
        ps.setString(2, contenido);
        ps.setInt(3, id); 
        ps.executeUpdate();              
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) ps.close();  
            if (con != null) con.close(); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    return true;
    }
    
    public boolean borrar(int id) {
    String sql = "DELETE FROM noticias WHERE idNoticia=?;";
    try {
        con = conectar.getConnection();  
        ps = con.prepareStatement(sql);  
        ps.setInt(1,id);
        ps.executeUpdate();              
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) ps.close();  
            if (con != null) con.close(); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    return true;
    }
    public boolean borrarNoticiasUsuario(int id) {
    String sql = "DELETE FROM noticias WHERE fk_autor=?;";
    try {
        con = conectar.getConnection();  
        ps = con.prepareStatement(sql);  
        ps.setInt(1,id);
        ps.executeUpdate();              
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
        try {
            if (ps != null) ps.close();  
            if (con != null) con.close(); 
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    return true;
    }
    
    public List otrasNoticias(String ip,String port){
        Client client = new Client(ip,port, "nws");
     return  client.getNoticias();
    }
    
    
}
