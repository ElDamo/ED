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
public interface ListaADT<T> extends Iterable<T>{
    public Iterator <T> iterator();
    public boolean estaVacia();
    public T quitaPrim();
    public T quitaUlt();
    public T quita(T dato);
    public String toString();
    public boolean contiene(T dato);
    public int calcTam();
    public T consultaPrim();
    public T consultaUlt();
    
}
