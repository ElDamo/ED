/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaenlazada;

import listas.Nodo;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author damia
 */
public class EstructuraEnlazada <T> implements Iterable<T> {
    
    private Nodo<T> prim,ult;

    public EstructuraEnlazada() {
        prim= null;
        ult= null;
    }
    
    public Iterator <T> iterator(){
        return new IteradorEE(prim);
    }
    
    public boolean estaVacia(){
        return prim==null;
    }
    
    public void agrega(T dato){
        Nodo <T> nuevo= new Nodo(dato);
        nuevo.setDir(prim);
        prim=nuevo;
        if(ult==null)
            ult=nuevo;
    }
    
    public void agregault(T dato){
        Nodo <T> nuevo= new Nodo(dato);
        if(estaVacia())
            prim=nuevo;
        else
            ult.setDir(nuevo);
        ult=nuevo;
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return toString(prim,sb);
    }
    
    private String toString(Nodo<T> ap, StringBuilder sb){
        
        if(ap!=null){
            sb.append(ap.getDato());
            return toString(ap.getDir(),sb);
        }
        else
            return sb.toString();
    }
    
    public T eliminaPrim(){
        T res;
        if(estaVacia())
            res=null;
        else{
            res=prim.getDato();
            Nodo<T> aux= prim;
            prim=prim.getDir();
            if(prim==null)
                ult=null;
            else
                aux.setDir(null);
        }
        return res;
    }
    
    public T consPrim(){
        T res= null;
        if(!estaVacia())
            res=prim.getDato();
        return res;
    }
    
    public T buscaDato(T dato){
        return buscaDato(dato,prim);
    }
    
    private T buscaDato(T dato,Nodo<T> ap){
        if(ap==null)
            return null;
        else
            if(ap.getDato().equals(dato))
                return ap.getDato();
            else
                return buscaDato(dato,ap.getDir());
    }
    
    public T eliminaUlt(){
        T res=null;
        if(!estaVacia()){
            res=ult.getDato();
            if(prim==ult){
                prim=null;
                ult=null;
            }
            else{
                Nodo <T> aux= prim;
                while(aux.getDir()!=ult)
                    aux=aux.getDir();
                aux.setDir(null);
                ult=aux;
            }
        }
        return res;
    }
    
    public T eliminaDato(T dato){
        if(prim==null||dato==null)
            throw new NullPointerException();
        else{
            if(prim.getDato().equals(dato))
                return eliminaPrim();
            else{
                if(ult.getDato().equals(dato))
                    return eliminaUlt();
                else
                    return eliminaDato(dato,prim,null);
            }
        }
    }
    
    private T eliminaDato(T dato, Nodo <T> p, Nodo<T> q){
        if(p==null)
            return null;
        else{
            if(p.getDato().equals(dato)){
                Nodo<T> aux= p.getDir();
                q.setDir(aux);
                if(p==ult)
                    ult=q;
                else
                    p.setDir(null);
            return p.getDato();
            }
            else
                return eliminaDato(dato,p.getDir(),p);
        }
    }
    
    public T eliminaAnterior(T dato){
        if(dato==null)
            throw new NullPointerException();
        if(estaVacia())
            throw new NullPointerException();
        else{
            if(prim.getDato().equals(dato))
                return null;
            else
                return eliminaAnterior(dato,prim.getDir(),prim,null);
        }
    }
    
    private T eliminaAnterior(T dato, Nodo<T> p,Nodo<T> q,Nodo<T> r){
        if(p==null)
            return null;
        else{
            if(p.getDato().equals(dato)){
                if(r==null){
                   return eliminaPrim();
                }else{
                    r.setDir(p);
                    q.setDir(null);
                    return q.getDato();
                }   
            }
            else
                return eliminaAnterior(dato,p.getDir(),p,q);
        }
        
    }
    
//    public T eliminaSiguiente(T dato){
//        if(dato==null)
//            throw new NullPointerException();
//        if(estaVacia())
//            throw new NullPointerException();
//        else{
//            if(ult.getDato().equals(ult))
//                return null;
//            else
//                return eliminaSiguiente()
//        }
//    }
    
//    public boolean insertaAntesQue(){
//        
//    }
    
    
    public int eliminaTodosRepetidosOrdenado(){
        if(estaVacia())
            throw new NoSuchElementException();
        int resp=0;
        Nodo<T> aux= prim;
        Nodo<T> aux1=aux.getDir().getDir();
        while(aux.getDir()!=null){
            if(!aux.getDato().equals(aux.getDir().getDato())){
                aux=aux.getDir();
                aux1=aux.getDir();
            }
            else{
                aux.setDir(aux1);
                aux.getDir().setDir(null);
                resp++;
            }      
        }
            
    }
    
}
