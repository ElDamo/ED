/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author damia
 */
public class IteradorArreglo <T> implements Iterator<T>{
    
    private T[] coleccion;
    private int total;
    private int actual;

    public IteradorArreglo(T[] coleccion, int total) {
        this.coleccion = coleccion;
        this.total = total;
        actual=0;
    }
    
    public boolean hasNext(){
        return actual<total;
    }
    
    public T next(){
       if(!hasNext())
           throw new NoSuchElementException();
       T resul;
       resul=coleccion[actual];
       actual++;
       return resul;
    }
    
    public void remove(){
        throw new UnsupportedOperationException("No está disponible");
    }
    
    
    
    
    
    
    
    
}
