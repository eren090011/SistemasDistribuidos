/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica;

/**
 *  
 * @author Jesus
 */
public interface ServerInterface {  
    public boolean verificarCuenta(String id, String clave);
    public String sacarDineroDeb(String id,int cantidad);
    public String sacarDineroCred(String id,int cantidad);
    // este de consignar dinero requiere que el usuario indique donde se va a consignar el dinero
    public String consignarDinero(String id, int cantidad, String tarjeta);
    // por motivos de diseño se debe consultar el saldo de la tarjeta de credito y debito por separado
    public int consultarSaldo(String id,String tarjeta);
}
