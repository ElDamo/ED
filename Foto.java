/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colas;

/**
 *
 * @author Damo
 */
public class Foto extends Archivo{
    
    private double resolucion;

    public Foto() {
        super();
    }

    public Foto(double resolucion, double tamaño, String nombre, String dueño, String fecha) {
        super(tamaño, nombre, dueño, fecha);
        this.resolucion = resolucion;
    }
    
    
    
}
