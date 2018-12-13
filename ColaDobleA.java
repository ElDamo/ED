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
public class ColaDobleA <T> implements ColaDobleADT{

    private T[] cola;
    private int inicio, fin;
    private final int MAX=20;

    public ColaDobleA() {
        cola= (T[]) new Object [MAX];
        inicio=-1;
        fin=-1;
    }
    
    public ColaDobleA(int max) {
        cola= (T[]) new Object [max];
        inicio=-1;
        fin=-1;
    }

    
    public T primeroFin() {
        if(isEmpty())
            throw new EmptyCollectionException("Cola Vacía");
        return cola[fin];
    }

    
    public T primeroInicio() {
        if(isEmpty())
            throw new EmptyCollectionException("Cola Vacía");
        return cola[inicio];
    }

    
    public boolean isEmpty() {
        return inicio==-1;
    }

    
    public Object quitaFin() {
        if(isEmpty())
            throw new EmptyCollectionException("Cola Vacía");
        T res;
        res=cola[fin];
        cola[fin]=null;
        if(inicio==fin){
            inicio=-1;
            fin=-1;
        }else{
              if(fin==0)
                  fin=cola.length-1;
              else
                  fin=(fin-1)%cola.length;
        }
        return res;
    }

    
    public T quitaInicio() {
        if(isEmpty())
            throw new EmptyCollectionException("Cola Vacía");
        T res;
        res=cola[inicio];
        cola[inicio]=null;
        if(inicio==fin){
            inicio=-1;
            fin=-1;
        }else
            inicio=(inicio+1)%cola.length;
        return res;
    }

    
    public void AgregaFin(Object dato) {
        if((fin+1)%cola.length==inicio)
            expande();
        fin=(fin+1)%cola.length;
        cola[fin]=(T)dato;
        if(inicio==-1)
            inicio=0;
    }

    
    public void AgregaInicio(Object dato) {
       if(inicio==0 && fin==cola.length-1||(inicio-1)%cola.length==fin)
           expande();
       else{
           if(isEmpty())
            inicio=0;
       }
        if(inicio==0){
            inicio=cola.length-1;
            cola[inicio]=(T) dato;
        }
        else{
            inicio=(inicio-1)%cola.length;
            cola[inicio]=(T)dato;
        }
    }
    
    
    private void expande(){
        T[] nueva=(T[]) new Object[cola.length*2];
        int i,j=0;
        for(i=inicio;i<cola.length;i++){
            nueva[j]=cola[i];
            j++;
        }
        for(i=0;i<inicio;i++){
            nueva[j]=cola[i];
            j++;
        }
        cola=nueva;
        inicio=0;
        fin=j-1;
    }
    
    
    
    

}
