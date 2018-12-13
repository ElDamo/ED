/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author damia
 */
public class IteradorEE <T> implements Iterator<T> {
    
    private Nodo<T> actual;

    public IteradorEE(Nodo<T> actual) {
        this.actual = actual;
    }
    
    
    public boolean hasNext(){
        return actual!=null;
    }
    
    public T next(){
        if(!hasNext())
            throw new NoSuchElementException();
        T res= actual.getDato();
        actual=actual.getDir();
        return res;
    }
    
    public void remove(){
        throw new UnsupportedOperationException("No está disponible");
    }
}
