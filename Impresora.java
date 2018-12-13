/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author Damo
 */
public class Impresora {
    
    private ColaADT<Archivo> pendientes;
    private String marca;

    public Impresora() {
        this.pendientes= new ColaA();
    }

    public Impresora(String marca) {
        this();
        this.marca = marca;
    }
    
    
    
    
    
    
    
    
}
