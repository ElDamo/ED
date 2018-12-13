/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

/**
 *
 * @author Damo
 */
public class PilaA <T> implements PilaADT<T>{
    
    private T[] pila;
    private int tope;
    private final int MAX=20;

    public PilaA() {
        pila= (T[]) new Object[MAX];
        tope=-1;
    }


    public PilaA(int max) {
        pila = (T[]) new Object[max];
        tope=-1;
    }
    
    public boolean isEmpty(){
        return tope==-1;
    }
    
    public void push(T dato){
        if(tope==pila.length-1)
            expande();
        tope++;
        pila[tope]=dato;
    }
    
    private void expande(){
        T[] nuevo= (T[])new Object[pila.length*2];
        for(int i=0;i<=tope;i++)
            nuevo[i]=pila[i];
        pila=nuevo;
    }
    
//    public T pop(){
//        T res;
//        if(this.isEmpty())
//            res= null;
//        else{
//            res=pila[tope];
//            pila[tope]=null;
//            tope--;
//        }
//        return res;
//    }
    
    public T pop(){
        if(isEmpty())
            throw new EmptyCollectionException("Pila Vacia");
        else{
            T res=pila[tope];
            pila[tope]=null;
            tope--;
            return res;
        }           
    }
    
//    public T peek(){
//        T res;
//        if(this.isEmpty())
//            res= null;
//        else{
//            res=pila[tope];
//        }
//        return res;
//    }

    public T peek(){
        if(isEmpty())
            throw new EmptyCollectionException("Pila Vacía");
        return pila[tope];
    }
    
    
    public boolean sonIguales(PilaADT <T> otra){
        if(this==null ||otra==null)
            throw new NullPointerException();
        if(this.isEmpty()|| otra.isEmpty())
            throw new EmptyCollectionException();
        boolean resp=true;
        PilaADT <T> aux1= new PilaA();
        PilaADT <T> aux2= new PilaA();
        while(!this.isEmpty() && resp && !otra.isEmpty()){
            if(this.peek().equals(otra.peek())){
                aux1.push(this.pop());
                aux2.push(otra.pop());
            }
            else{
                resp=false;
            }       
        }
        if(!otra.isEmpty())
            resp=false;
        while(!aux1.isEmpty())
            this.push(aux1.pop());
        while(!aux2.isEmpty())
            otra.push(aux2.pop());
        return resp;
    }
    

    
}
