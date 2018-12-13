/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.*;

/**
 *
 * @author damia
 */
public class Club {
    
    private String nombre;
    private ListaOrdenada<Persona> socios;

    public Club() {
        this.socios= new ListaOrdenada<Persona>();
    }

    public Club(String nombre) {
        this();
        this.nombre = nombre;
    }
    
    public void altasocio(String nom){
        socios.agrega(new Persona(nom));
    }
    
    public String consultaSocio(int clave){
        if(socios.estaVacia())
            throw new EmptyCollectionException();
        else{
            Persona buscada= new Persona(clave);
            Iterator it;
            it=socios.iterator();
            return consultaSocio(buscada,it).toString();
        }   
    }
    
    private Persona consultaSocio(Persona buscada, Iterator it){
        if(!it.hasNext())
            return null;
        else{
            if(it.next().equals(buscada))
                return (Persona)it.next();
            else{
                it.next();
                return consultaSocio(buscada,it);
            }
        }
    }
    
}
