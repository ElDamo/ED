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
public class Conjuntos {

    /**
     * @param args the command line arguments
     */
    
    public String ingyFra(ConjuntoADT<String> ing,ConjuntoADT<String> fra){
        if(ing==null||fra==null)
            throw new NullPointerException();
        String resp=ing.interseccion(fra).toString();
        if(resp.length()==0)
            throw new RuntimeException("No hay alumnos que hablen inglés y francés");
        else
            return resp;
    }
    
    public String soloIng(ConjuntoADT<String> ing,ConjuntoADT<String> fra,ConjuntoADT<String> otros){
        if(ing==null||fra==null||otros==null)
            throw new NullPointerException();
        String resp=ing.diferencia(fra.diferencia(otros)).toString();
        if(resp.length()==0)
            throw new RuntimeException("No hay alumnos que hablen sólo inglés");
        else
            return resp;
    }
    
    public String alMenosTres(ConjuntoADT<String> ing,ConjuntoADT<String> fra,ConjuntoADT<String> otros){
        if(ing==null||fra==null)
            throw new NullPointerException();
        String resp=ing.interseccion(fra.interseccion(otros)).toString();
        if(resp.length()==0)
            throw new RuntimeException("No hay alumnos que hablen sólo inglés");
        return resp;
    }
    
    public boolean equalsr(ConjuntoADT uno, ConjuntoADT otro){
        if(otro==null||uno==null)
            throw new NullPointerException();
        if(uno.getCardinalidad()!=otro.getCardinalidad())
            return false;
        else{
            Iterator it= uno.iterator();
            return equalsr(otro,it);
        }
    }
    
    private boolean equalsr(ConjuntoADT otro, Iterator it){
        if(!it.hasNext())
            return true;
        else{
            if(otro.contiene(it.next())){
                it.next();
                return equalsr(otro,it);
            }
            else
                return false;       
        }   
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
