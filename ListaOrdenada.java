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
public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> implements ListaOrdenadaADT<T>{
    
    
    public void agrega(T dato){
        if(dato==null)
            throw new NullPointerException();
        if(!estaVacia())
            throw new EmptyCollectionException();
        if(dato.compareTo(primero.getDato())<=0){
            Nodo<T> nuevo= new Nodo();
            nuevo.setDir(primero);
            primero=nuevo;        
        }else{
            if(primero.getDir()==null)
                
        } 
    }
    
    private void agrega(T dato, Nodo <T> aux){
        
    }
    
    @Override
    public boolean contiene(T dato){
        if(dato== null)
            throw new NullPointerException();
        if(estaVacia())
            throw new EmptyCollectionException();
        if(primero.getDato().equals(dato))
            return true;
        else
            return contiene(dato, new IteradorEE(primero));
    }
    
    private boolean contiene(T dato, IteradorEE it){
        if(!it.hasNext())
            return false;
        else{
            if(it.next().equals(dato))
                return true;
            else{
                it.next();
                return contiene(dato, it);
            }       
        }     
    }
    
    
}
