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
public class ListaDoble <T> implements Iterable <T> {
    
    private NodoDoble<T> prim;
    private NodoDoble <T> ult;

    public ListaDoble() {
        prim=null;
        ult= null;
    }
    
    public Iterator<T> iterator(){
        return new IteradorDoble(prim);
    }
    
    public boolean estaVacia(){
        return prim==null;
    }
    
    public void agregaPrim(T dato){
        NodoDoble<T> nuevo= new NodoDoble(dato);
        if(!estaVacia()){
          nuevo.setSig(prim);
          prim.setAnt(nuevo);
        }
        else
            ult=nuevo;
        prim=nuevo;
    }
    
    public void agregaUlt(T dato){
        NodoDoble<T> nuevo= new NodoDoble(dato);
        if(!estaVacia()){
          nuevo.setAnt(ult);
          ult.setSig(nuevo);
        }
        else
            prim=nuevo;
        ult=nuevo;
    }
    
    public String toString(){
        return toString(new StringBuilder(),ult);
    }
    
    private String toString(StringBuilder sb, NodoDoble<T> apun){
        if(apun!=null){
            sb.append(apun.getDato());
            return toString(sb,apun.getAnt());
        }
        else
            return sb.toString();        
    }
    
    public T elimina(T dato){
        T resp;
        if(!estaVacia()){
            if(ult.getDato().equals(dato))
                resp=eliminaUlt();
            else{
                if(prim.getDato().equals(dato))
                    resp=eliminaPrim();
                else
                    resp=elimina(prim.getSig(),dato);
            }
        }else
            resp = null;
        return resp;
    }
    
    private T elimina(NodoDoble<T> apunt, T dato){
        if(apunt==null)
            return null; //fracaso
        else
            if(apunt.getDato().equals(dato)){
                apunt.getAnt().setSig(apunt.getSig());
                apunt.getSig().setAnt(apunt.getAnt());
                apunt.setAnt(null);
                apunt.setSig(null);
                apunt.setAnt(null);
                return apunt.getDato();
            }
        else
                return elimina(apunt.getSig(),dato);
    }
    
    public T eliminaPrim(){
        T resp;
        if(!estaVacia()){
            resp= prim.getDato();
            if(prim==null){
                prim=null;
                ult=null;
            }
            else{
                prim=prim.getSig();
                prim.getAnt().setSig(null);
                prim.setAnt(null);
            }
                
        }
        resp= null;
        return resp;
    }
    
    public T eliminaUlt(){
        T resp;
        if(!estaVacia()){
            resp= ult.getDato();
            if(prim==null){
                prim=null;
                ult=null;
            }
            else{
                ult=ult.getAnt();
                ult.getSig().setAnt(null);
                ult.setSig(null);
            }
                
        }
        resp= null;
        return resp;
    }
    
    public T contiene(T dato){
        return contiene(iterator(),dato);
    }
    
    private T contiene(Iterator <T> it, T dato){
        if(it.hasNext()){
            T aux= it.next();
            if(aux.equals(dato))
                return aux;
            else
                return contiene(it,dato);
        }
        else
            return null;
    }
    
    public boolean agregaAntesQue(T ref, T dato){
        boolean resp=false;
        if(!estaVacia())
            if(prim.getDato().equals(ref)){
                resp=true;
                agregaPrim(dato);
            }
        else
                resp=agregaAntesQue(prim.getSig(),ref,dato);
        return resp;
    }
    
    private boolean agregaAntesQue(NodoDoble<T> apunt,T ref,T dato){
        if(apunt==null)
            return false;
        else
            if(apunt.getDato().equals(ref)){
                NodoDoble<T> nuevo= new NodoDoble(dato);
                nuevo.setAnt(apunt.getAnt());
                nuevo.setSig(apunt);
                nuevo.getAnt().setSig(nuevo);
                apunt.setAnt(nuevo);
                return true;
            }
            else
                return agregaAntesQue(apunt.getSig(),ref,dato);
    }
}
