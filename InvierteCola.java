/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

import java.util.ArrayList;
import pilas.PilaA;
import pilas.PilaADT;

/**
 *
 * @author Damo
 */
public class InvierteCola {
    
    
    public static <T> void invertir(ColaADT<T> c){
        if(c==null)
            throw new NullPointerException();
        if(c.isEmpty())
            throw new EmptyCollectionException();
        PilaADT<T> aux= new PilaA();
        while(!c.isEmpty()){
            aux.push(c.eliminar());
        }
        while(!aux.isEmpty())
            c.insertar(aux.pop());
    }
    
    public static <T> void eliminaRepetidos(ColaADT<T> c){
        if(c==null)
            throw new NullPointerException();
        if(c.isEmpty())
            throw new EmptyCollectionException();
        ArrayList<T> aux= new ArrayList();
        int j=1;
        while(!c.isEmpty())
            aux.add(c.eliminar());
        while(j<aux.size()){
            if(aux.get(j).equals(aux.get(j-1))){
                aux.remove(j);
                j--;
            }
            j++;
        }
        for(int i=0;i<aux.size();i++)
            c.insertar(aux.get(i));   
    }
    
    public static <T> void eliminaOcurrencias(T dato, ColaADT<T> c){
        if(c==null)
            throw new NullPointerException();
        if(c.isEmpty())
            throw new EmptyCollectionException();
        ColaADT<T> aux= new ColaA();
//        ArrayList<T> aux= new ArrayList();
        while(!c.isEmpty()){
            if(c.consultaPrimero().equals(dato)){
                c.eliminar();
            }
            else
                aux.insertar(c.eliminar());
//            aux.add(c.eliminar());
//        for(int i=0;i<aux.size();i++){
//            if(aux.get(i).equals(dato))
//                aux.remove(aux.get(i));    
//        }
//        for(int j=0;j<aux.size();j++){
//            c.insertar(aux.remove(j));
        }
        while(!aux.isEmpty())
            c.insertar(aux.eliminar());        
    }
    
}
