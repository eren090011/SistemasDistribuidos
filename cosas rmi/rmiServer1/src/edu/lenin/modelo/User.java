/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.lenin.modelo;

public class User {
    private int id;
    private String name;
    private String password;
    public User(){
        
    }
    public User(int id, String name,String password ){
        id=this.id;
        name=this.name;
        password=this.password;        
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    @Override
    public String toString() {
        return "User{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", password='" + password + '\'' +
           '}';
    }

    
}

