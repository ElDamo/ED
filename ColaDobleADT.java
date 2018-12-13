/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coladoble;

/**
 *
 * @author damia
 */
public interface ColaDobleADT <T>{
    public T primeroFin();
    public T primeroInicio();
    public boolean isEmpty();
    public T quitaFin();
    public T quitaInicio();
    public void AgregaFin(T dato);
    public void AgregaInicio(T dato);
}
