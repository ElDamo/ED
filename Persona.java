/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author damia
 */
public class Persona implements Comparable<Persona> {
    
    private String nombre;
    private int clave;

    public Persona() {
        this.clave=(int)Math.random();
    }

    public Persona(String nombre) {
        this();
        this.nombre = nombre;
    }

    public Persona(int clave) {
        this.clave = clave;
    }
    
    
    private int getClave(){
        return this.clave;
    }
    

    @Override
    public int compareTo(Persona o) {
        return this.clave-o.getClave();
    }

    @Override
    public String toString() {
        return "Socio: /n" + "Nombre: " + nombre + "/n clave: " + clave;
    }
    
    
        
    
    
    
    
    
    
    
    

    
    
}
