/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.threadsample2;

/**
 *
 * @author Jesus
 */
public class Main {

    public static void main(String[] args) {
       HiloEjemplo hiloEjemplo = new HiloEjemplo();
       hiloEjemplo.start();
       
       EjecutableEjemplo ejectuableEjemplo = new EjecutableEjemplo();
       Thread thread = new Thread(ejectuableEjemplo);
       thread.start();
       
    }
    
}
