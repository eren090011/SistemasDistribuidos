/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosampl;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author Jesus
 */
public class ClienteHilo extends Thread {
   private DataInputStream in;
   private DataOutputStream out;

    public ClienteHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }
    public void run(){
        
    }
}
