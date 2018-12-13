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
public class NodoDoble <T>{
    private T dato;
    private NodoDoble<T> ant;
    private NodoDoble<T> sig;

    public NodoDoble() {
        ant=null;
        sig=null;
    }
    
    public NodoDoble(T dato) {
        this();
        this.dato = dato;
    }
    
    public T getDato() {
        return dato;
    }

    public NodoDoble<T> getAnt() {
        return ant;
    }

    public void setAnt(NodoDoble<T> ant) {
        this.ant = ant;
    }

    public NodoDoble<T> getSig() {
        return sig;
    }

    public void setSig(NodoDoble<T> sig) {
        this.sig = sig;
    }
    
    
}
