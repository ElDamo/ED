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
public class Documento extends Archivo{
    
    private String tipoProc;

    public Documento() {
        super();
    }


    public Documento(double tamaño, String nombre, String dueño, String fecha,String tipoProc) {
        super(tamaño,nombre,dueño,fecha);
        this.tipoProc = tipoProc;
    }
    
    
    
    
    
}
