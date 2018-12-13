/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

/**
 *
 * @author damia
 */
public class Nodo <T>{
    private T dato;
    private Nodo<T> dir;

    public Nodo() {
        dato=null;
        dir=null;
    }

    public Nodo(T dato) {
        this.dato = dato;
        dir=null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getDir() {
        return dir;
    }

    public void setDir(Nodo<T> dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Dato: " + dato + "/n";
    }
    
    
    
    
    
}
