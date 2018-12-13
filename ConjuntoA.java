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
public class ConjuntoA<T> implements ConjuntoADT<T> {
    
    private T[] conjunto;
    private int cardinalidad;
    private final int MAX=20;

    public ConjuntoA() {
        conjunto= (T[]) new Object[MAX];
        cardinalidad=0;
    }
    
    public int getCardinalidad(){
        return this.cardinalidad;
    }
    
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto,cardinalidad);
    }
    
    public boolean contiene(T elem){
        boolean resp=true;
        Iterator <T> it= iterator();
        while(it.hasNext() && resp)
            resp=it.next().equals(elem);
        return resp;
    }
    
    private void expande(){
        T[] nuevo= (T[])new Object[conjunto.length*2];
        for(int i=0;i<=cardinalidad;i++)
            nuevo[i]=conjunto[i];
        conjunto=nuevo;
    }
    
    public boolean agrega(T elem){
        boolean resp;
        if(elem!=null && !contiene(elem)){
            if(cardinalidad==conjunto.length)
                expande();
            conjunto[cardinalidad]=elem;
            cardinalidad++;
            resp=true;
        }
        else
            resp=false;
        return resp;
    }
    
    public String toString(){
        return toString(0,new StringBuilder());
    }
    
    private String toString(int i, StringBuilder sb){
        if(i==cardinalidad)
            return sb.toString();
        else{
            sb.append(conjunto[i]).append("\n");
            return  toString(i+1,sb);
        }     
    }
    
    public T quita(T elem){
        T resp=null;
        if(elem!=null){
            int pos;
            pos=busca(elem,0);
            if(pos>=0){
                resp=conjunto[pos];
                conjunto[pos]=conjunto[cardinalidad-1];
                conjunto[cardinalidad-1]=null;
                cardinalidad--;
            }
        }
        return resp;
    }
    
    private int busca(T elem, int i){
        if(i==cardinalidad)
            return-1;
        else
            if(conjunto[i].equals(elem))
                return i;
            else
                return busca(elem,i++);
    }
    
    public ConjuntoADT<T> union(ConjuntoADT<T> otro){
        if(otro==null)
            throw new RuntimeException("Conjunto Vacío");
        ConjuntoA<T> nuevo= new ConjuntoA();
        for(int i=0;i<cardinalidad;i++)
            nuevo.conjunto[i]=conjunto[i];
        Iterator<T> it= otro.iterator();
        while(it.hasNext())
            nuevo.agrega(it.next());
        return nuevo;
    }
    
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro){
        if(otro==null)
            throw new RuntimeException("Conjunto Vacío");
        ConjuntoA<T> nuevo= new ConjuntoA();
        int j=0;
        for(int i=0;i<this.cardinalidad;i++)
            if(otro.contiene(conjunto[i])){
                nuevo.conjunto[j]=conjunto[i];
                j++;
            }
        nuevo.cardinalidad=j;
        return nuevo;
    }
    
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro){
        if(otro==null)
            throw new RuntimeException();
        int j=0;
        ConjuntoA<T> nuevo= new ConjuntoA();
        for(int i=0;i<cardinalidad;i++)
            if(otro.contiene(conjunto[i])){
                nuevo.conjunto[j]=conjunto[i];
                j++;
            }
        nuevo.cardinalidad=j;
        return nuevo;
    }
    
    public boolean estaVacio(){
        return cardinalidad==0;
    }
    
    public boolean equals(ConjuntoADT<T> otro){
        if(otro==null)
            throw new NullPointerException();
        if(cardinalidad!=otro.getCardinalidad())
            return false;
        else{
            return equals(otro,0);
        }
    }
    
    private boolean equals(ConjuntoADT<T> otro,int i){
        if(i==cardinalidad)
            return true;
        else{
            if(otro.contiene(conjunto[i])){
                return equals(otro,i+1);
            
            }else
                return false;
        }         
    }
    
    public boolean equalsi(ConjuntoADT<T> otro){
        if(otro==null)
            throw new NullPointerException();
        boolean resp=true;
        if(cardinalidad!=otro.getCardinalidad())
            resp=false;
        else{
          int i=0;
          while(i<cardinalidad && resp){
              if(otro.contiene(conjunto[i]))
                  i++;
              else
                  resp=false;
          }          
        }
        return resp;       
    }
   
}
