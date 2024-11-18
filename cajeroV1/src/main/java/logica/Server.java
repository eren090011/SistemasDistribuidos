/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jesus
 */
public class Server implements ServerInterface {
    // lista de cuentas
    private List<Cuenta> cuentas;
    
    public Server() {
        this.cuentas = new ArrayList<>();
        initCuentas();
    }
    
    // getter de todas las cuentas para probar
    public List<Cuenta> getPersonas() {
        return cuentas;
    }
    
    private void initCuentas() {
        cuentas.add(new Cuenta("1234576891", "2324", 30000,30000));
        cuentas.add(new Cuenta("6543275591", "0911", 40000, 70000));
        cuentas.add(new Cuenta("55495322576", "1234", 60000,60000));
    }
    
    @Override
    public boolean  verificarCuenta(String id, String clave){
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId()==id){
                // si existe, se comprueba concuerde tambien la contraseña
                if(cuenta.getClave()== clave){
                    return true;
                // si existe la cuenta, pero la contraseña no concuerda, retorna false
                }else{
                   return false;
                }
            }           
        }
        // si no existe la cuenta, devuelve false
        return false;
    }
    @Override
    public String sacarDineroDeb(String id, int cantidad){
        if(cantidad>2000000){
            return "supero el maximo de dinero permitido en una transaccion";
        }
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId()==id){
                // se obtiene el saldo
                int saldoDeb= cuenta.getSDebito();
                if(cantidad>saldoDeb){
                    return "no tiene suficiente saldo para retirar la cantidad ingresada";
                    
                }else{
                    // si se tiene el saldo suficiente, se procede a restarse la cantidad
                    int saldoFinal = saldoDeb-cantidad;
                    // el resultado de la resta se establecera como el nuevo saldo
                    cuenta.setSDebito(saldoFinal);
                    return "dinero retirado con exito";
                }
                
            }           
        }return "error al sacar dinero de debito";
    }
    
    @Override
    public String sacarDineroCred(String id, int cantidad){
        if(cantidad>2000000){
            return "supero el maximo de dinero permitido en una transaccion";
        }
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId()==id){
                // se obtiene el saldo
                int saldoCred= cuenta.getSCredito();
                if(cantidad>saldoCred){
                    return "no tiene suficiente saldo para retirar la cantidad ingresada";
                    
                }else{
                    // si se tiene el saldo suficiente, se procede a restarse la cantidad
                    int saldoFinal = saldoCred-cantidad;
                    // el resultado de la resta se establecera como el nuevo saldo
                    cuenta.setSCredito(saldoFinal);
                    return "dinero retirado con exito";
                }
                
            }           
        }return "error al sacar dinero de credito";
    }
    
    @Override
    public String consignarDinero(String id, int cantidad,String tarjeta){
        if(cantidad>2000000){
            return "supero el maximo de dinero permitido en una transaccion";
        }
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId()==id){
                // se consigna a credito
                if(tarjeta=="credito"){
                    int saldoFinal=cuenta.getSCredito()+cantidad;
                    // el resultado de la suma se establecera como el nuevo saldo
                    cuenta.setSCredito(saldoFinal);
                    return "dinero cosignado exitosamente en la tarjeta de credito";
                }
                // se consigna a debito
                else{
                    int saldoFinal=cuenta.getSDebito()+cantidad;
                    // el resultado de la suma se establecera como el nuevo saldo
                    cuenta.setSDebito(saldoFinal);
                    return "dinero cosignado exitosmente en la tarjeta de debito";
                }
                
            }           
        }return "error al consignar dinero";
    }
    
    @Override
    public int consultarSaldo(String id,String tarjeta){
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId()==id){
                // se consigna a credito
                if(tarjeta=="credito"){
                    return cuenta.getSCredito();
                }
                // se consigna a debito
                else{
                    return cuenta.getSDebito();
                }
                
            }
         // Cuando el valor es inferior a 0 se asume que no existe la cuenta o que ocurrio un error XD
        }return -1;
    }
    
}
    
    
    
    

    

