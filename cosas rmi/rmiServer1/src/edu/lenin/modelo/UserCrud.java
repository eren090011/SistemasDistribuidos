/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lenin.modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserCrud {
    Conexion conectar =new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        List<User>datos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con= conectar.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {  
                
                String password= rs.getString(3);
                User us = new User();
                
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setPassword(rs.getString(3));
                datos.add(us);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;    
    }
    
    public boolean agregar(String nombre, String password) {
    String sql = "INSERT INTO usuarios (usNombre, usPassword) VALUES (?, ?);";
    try {
        con = conectar.getConnection();  
        ps = con.prepareStatement(sql);  
        ps.setString(1, nombre);         
        ps.setString(2, password);       
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
    
    public boolean actualizar(int id, String name, String password) {
    String sql = "UPDATE usuarios SET usNombre=?, usPassword=? WHERE idUsuario=?;";
    try {
        con = conectar.getConnection();  
        ps = con.prepareStatement(sql);  
        ps.setString(1, name);         
        ps.setString(2, password);
        ps.setInt(3,id);
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
    
    // PENDIENTE AGREGAR QUE ANTES DE BORRAR EL USUARIO BORRE TODAS SUS NOTICIAS
    public boolean borrar(int id) {
    String sql = "DELETE FROM usuarios WHERE idUsuario=?;";
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
    
    public List login(String name,String password){
        List<User>datos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE usNombre=? && usPassword=?";
        try {
            con= conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, name);         
            ps.setString(2, password);
            rs=ps.executeQuery();
            
            
            while (rs.next()) {  
                User us = new User();
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setPassword(rs.getString(3));
                datos.add(us);    
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;    
    }
    
    public List nombreAutor(int id){
        List<User>datos = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE idUsuario=?";
        try {
            con= conectar.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);         
            
            rs=ps.executeQuery();
            while (rs.next()) {  
                User us = new User();
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setPassword(rs.getString(3));
                datos.add(us);    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;    
    }
    
    
}
