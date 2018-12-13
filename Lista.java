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
public abstract class Lista<T> implements ListaADT<T> {

    protected Nodo<T> primero;

    public Lista() {
        this.primero = null;
    }
    
    public Iterator<T> iterator(){
        return new IteradorEE(primero);
    }
    
    public boolean estaVacia(){
        return primero==null;
    }
    
    public int calcTam(){
        return calcTam(iterator(),0);
    }
    
    private int calcTam(Iterator<T> it, int cont){
        if(it.hasNext()){
            it.next();
            return calcTam(it,cont++);
        }else
            return cont;
    }
    
    public String toString(){
        return toString(new StringBuilder(),primero);
    }
    
    private String toString(StringBuilder sb,Nodo<T> actual){
        if(actual==null)
            return sb.toString();
        else{
            sb.append(actual.getDato());
            return toString(sb,actual.getDir());
        }
    }
    
    public T quitaPrim(){
        T res;
        if(estaVacia())
            throw new NullPointerException();
        if(primero.getDir()==null){
            res=primero.getDato();
            primero=null;
        }
        else{
            res=primero.getDato();
            primero=primero.getDir();
        }
        return res;
    }
    
    public T quitaUlt(){
        if(estaVacia())
            throw new NullPointerException();
        if(primero.getDir()==null)
            return quitaPrim();
        else
            return quitaUlt(primero);  
    }
    
    private T quitaUlt(Nodo<T> actual){
        Nodo<T> aux= actual.getDir();
        T res;
        if(aux.getDir()==null){
            res= aux.getDato();
            actual.setDir(null);
            return res;
        }
        else
            return quitaUlt(actual.getDir());
    }
    
    public T quita(T dato){
        if(estaVacia())
            throw new NullPointerException();
        if(primero.getDato().equals(dato)){
            return quitaPrim();
        }
        else
            return quita(dato,primero);
        
    }
    
    private T quita(T dato, Nodo<T> actual){
        Nodo<T> aux=actual.getDir();
        if(aux!=null&& !aux.getDato().equals(dato)){
            return quita(dato, actual.getDir());
        }
        else{
            if(aux==null){
                return null;
            }
            else{
                actual.setDir(aux.getDir());
                aux.setDir(null);
                return aux.getDato();
            }       
        }
    }
    
    public boolean contiene(T dato){
        return contiene(dato,iterator());
    }
    
    private boolean contiene(T dato, Iterator<T> it){
        if(!it.hasNext())
            return false;
        else{
            if(it.next().equals(dato))
                return true; 
            else{
              it.next();
              return contiene(dato,it);
            }       
        }
    }
    
    
//    public ListaADT<T> invierteLista(){
//        if(estaVacia())
//            throw new EmptyCollectionException();
//        if(primero.getDir()==null)
//            return this;
//        else
//            return invierteLista(primero.getDir(), primero.getDato());
//    }
    
//    private ListaADT<T> invierteLista(Nodo<T> aux, T dato){
//        if(aux.getDato().equals(dato) && aux.getDir()==null)
//            return this;
//        else
//            
//            
//        
//    }
    
}