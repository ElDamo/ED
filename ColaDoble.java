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
public class ColaDoble {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaDobleADT cola= new ColaDobleA(6);
        cola.AgregaInicio(4);
        cola.AgregaInicio(5);
        
        
        while(!cola.isEmpty())
            System.out.println(cola.quitaInicio());
    }
    
}
