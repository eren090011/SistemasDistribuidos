/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Jesus
 */
public class Cuenta {
    private String id;
    private String clave;
    private int sDebito;
    private int sCredito;
    
    public Cuenta(String id, String clave, int sDebito, int sCredito){
        this.id = id;
        this.clave = clave;
        this.sDebito = sDebito;
        this.sCredito = sCredito;
    }
    
    // getters
    public String getId(){
       return id;
    }
    
    public String getClave(){
        return clave;
    }
    
    public int getSDebito(){
        return sDebito;
    }
    
    public int getSCredito(){
        return sCredito;
    }
    
    // setters
    public void setSDebito(int sDebito){
        this.sDebito = sDebito;
    }
    
    public void setSCredito(int sCredito){
        this.sCredito = sCredito;
    }
    
}
