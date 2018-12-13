/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;

import java.util.Iterator;

/**
 *
 * @author damia
 */
public interface ConjuntoADT <T> extends Iterable <T>{
    
    public boolean contiene(T elem);
    public boolean estaVacio();
    public int getCardinalidad();
    public String toString();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    public boolean agrega(T elem);
    public T quita(T elem);
    public boolean equals(ConjuntoADT<T> otro);
    public boolean equalsi(ConjuntoADT<T> otro);
}
