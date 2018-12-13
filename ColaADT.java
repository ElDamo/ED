/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author ariz
 */
public interface ColaADT <T> {
    
    public void insertar(T dato);
    public T eliminar();
    public boolean isEmpty();
    public T consultaPrimero();
}
