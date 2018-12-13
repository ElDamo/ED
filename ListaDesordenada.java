/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.Iterator;

/**
 *
 * @author damia
 */
public class ListaDesordenada<T> extends Lista implements ListaDesordenadaADT<T>{

    
    public void agregaInicio(T dato){
       if(dato==null)
            throw new NullPointerException();
       if(estaVacia()){
           Nodo<T> nuevo= new Nodo<T>();
           nuevo.setDato(dato);
           primero=nuevo;
       }
       else{
           Nodo<T> nuevo= new Nodo<T>();
           nuevo.setDato(dato);
           nuevo.setDir(primero);
           primero=nuevo;
       }     
    }

    
    public void agregaFin(T dato) {
        if(dato==null)
            throw new NullPointerException();
        if(estaVacia()){
           agregaInicio(dato);
        }else
            agregaFin(dato,primero);
    }
    
    public void agregaFin(T dato,Nodo<T> aux){
        if(aux.getDir()==null){
            Nodo<T> nuevo= new Nodo<T>();
            nuevo.setDato(dato);
            aux.setDir(nuevo);
        }
        else
            agregaFin(dato,aux.getDir());
    }

    @Override
    public boolean agregaAntesQue(T ref, T dato) {
        if(estaVacia())
            throw new EmptyCollectionException();
        if(ref==null||dato== null)
            throw new NullPointerException();
        if(primero.getDato().equals(ref)){
            agregaInicio(dato);
            return true;
        }
        else
            return agregaAntesQue(ref,dato,primero);
    }
    
    private boolean agregaAntesQue(T ref, T dato,Nodo<T> aux){
        if(aux.getDir()==null)
            return false;
        if(aux.getDir().getDato().equals(ref)){
            Nodo<T> nuevo= new Nodo<T>();
            nuevo.setDato(dato);
            nuevo.setDir(aux.getDir());
            aux.setDir(nuevo);
            return true;
        }else
            return agregaAntesQue(ref,dato,aux.getDir());
    }

    
    public boolean agregaDespuesQue(T ref, T dato) {
        if(estaVacia())
            throw new EmptyCollectionException();
        if(ref==null||dato== null)
            throw new NullPointerException();
        if(primero.getDato().equals(ref)){
            agregaFin(dato);
            return true;
        }
        else
            return agregaDespuesQue(ref,dato,primero);
    }
    
    private boolean agregaDespuesQue(T ref, T dato, Nodo<T> aux){
        
    }
    
}
