/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Operaciones;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Jesus
 */
public class Operaciones implements OperacionesInterface {
    /*// lista de cuentas
    private List<Cuenta> cuentas;
    
    public Operaciones() {
        this.cuentas = new ArrayList<>();
        initCuentas();
    }
    
    // getter de todas las cuentas para probar
    public List<Cuenta> getPersonas() {
        return cuentas;
    }
    
    private void initCuentas() {
        cuentas.add(new Cuenta("123456", "2324", 30000,30000));
        cuentas.add(new Cuenta("654321", "0911", 40000, 70000));
        cuentas.add(new Cuenta("234567", "1234", 60000,60000));
    } */
    
    @Override
    public String  verificarCuenta(List<Cuenta> cuentas,String id, String clave){
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId().equals(id)){
                // si existe, se comprueba concuerde tambien la contraseña
                if(cuenta.getClave().equals(clave)){
                    return "Acceso Concedido";
                // si existe la cuenta, pero la contraseña no concuerda
                }else{
                   return "Acceso denegado, contraseña incorrecta";
                }
            }           
        }
        // si no existe la cuenta
         return "Acceso denegado";
    }
    @Override
    public String sacarDineroDeb(List<Cuenta> cuentas, String id, int cantidad){
        if(cantidad>2000000){
            return "supero el maximo de dinero permitido en una transaccion";
        }
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId().equals(id)){
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
    public String sacarDineroCred(List<Cuenta> cuentas,String id, int cantidad){
        if(cantidad>2000000){
            return "supero el maximo de dinero permitido en una transaccion";
        }
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId().equals(id)){
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
    public String consignarDinero(List<Cuenta> cuentas,String id, int cantidad,String tarjeta){
        if(cantidad>2000000){
            return "supero el maximo de dinero permitido en una transaccion";
        }
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId().equals(id)){
                // se consigna a credito
                if("credito".equals(tarjeta)){
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
    public int consultarSaldo(List<Cuenta> cuentas,String id,String tarjeta){
        // se busca la cuenta
        for (Cuenta cuenta : cuentas){
            if(cuenta.getId().equals(id)){
                // se consigna a credito
                if("credito".equals(tarjeta)){
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
    
    
    
    

    

