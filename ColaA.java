
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
public class ColaA <T> implements ColaADT<T> {
    
    private T[] cola;
    private int inicio, fin;
    private final int MAX=20;

    public ColaA() {
        cola=(T[]) new Object [MAX];
        inicio=-1;
        fin=-1;
    }
    
    public ColaA(int max){
        cola=(T[]) new Object [max];
        inicio=-1;
        fin=-1;
    }
    
    public boolean isEmpty(){
        return inicio==-1;
    }
    
    public void insertar(T dato){
        if((fin+1)%cola.length==inicio)
            expande();
        fin=(fin+1)%cola.length;
        cola[fin]=dato;
        if(inicio==-1)
            inicio=0;
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
    
    public T eliminar(){
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
    
    public T consultaPrimero(){
        if(isEmpty())
            throw new EmptyCollectionException("Cola Vacía");
        return cola[inicio];
    }
}
