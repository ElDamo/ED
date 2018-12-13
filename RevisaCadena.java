/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilas;

import java.util.ArrayList;

/**
 *
 * @author Damo
 */
public class RevisaCadena {
    
    private String exp;

    public RevisaCadena() {
    }

    public RevisaCadena(String exp) {
        this.exp = exp;
    }
    
    public boolean revisaBalanceoParentesis(){
        PilaA<Character> pila = new PilaA();
        int i,n;
        i=0;
        n=exp.length();
        boolean resp=true;
        while(i<n && resp){
            if(exp.charAt(i)=='(')
                pila.push(exp.charAt(i));
                if(exp.charAt(i)==')')
                    try{
                        pila.pop();
                    } catch(EmptyCollectionException e){
                        resp=false;
                    }
                i++;
        }
        return pila.isEmpty()&&resp;
    }
    
    public String invierteCadena(){
        StringBuilder sb= new StringBuilder();
        PilaA<Character> pila = new PilaA();
        for(int i=0;i<exp.length();i++)
            pila.push(exp.charAt(i));
        while(!pila.isEmpty()){
            sb.append(pila.pop());
        }
        return sb.toString(); 
    }
    
    public static <T> int numElementos(PilaADT <T> pila){
        PilaADT <T> aux = new PilaA();
        int cont=0;
        while(!pila.isEmpty()){
            aux.push(pila.pop());
            cont++;
        }
        while(!aux.isEmpty()){
            pila.push(aux.pop());
        }
        return cont;
    }
    
    public static <T> void invierteElementos(PilaADT <T> pila){
        ArrayList <T> aux= new ArrayList();
        if(pila!=null){
            while(!pila.isEmpty()){
                aux.add(pila.pop());
            }
            for(int i=0;i<aux.size();i++){
                pila.push(aux.get(i));
            }
        }
    }
    
    public static <T> void quitaRepetidos(PilaADT<T> pila){
        if(pila!=null && !pila.isEmpty()){
            PilaADT<T> aux= new PilaA();
            aux.push(pila.pop());
            while(!pila.isEmpty()){
                if(aux.peek().equals(pila.peek()))
                    pila.pop();
                else
                    aux.push(pila.pop()); 
            }
            while(!aux.isEmpty())
                pila.push(aux.pop());
        }
        else
            throw new EmptyCollectionException();
    }
    
    public static <T> boolean contiene(PilaADT<T> p1,PilaADT<T> p2){
        if(p1==null || p2==null)
            throw new NullPointerException();
        if(p1.isEmpty() && !p2.isEmpty())
            throw new EmptyCollectionException();
        boolean resp=true;
        ArrayList<T> auxa= new ArrayList();
        PilaADT<T> auxp= new PilaA();
        while(!p2.isEmpty())
            auxa.add(p2.pop());
        while(!p1.isEmpty()&& resp){
            if(auxa.contains(p1.peek()))
                auxp.push(p1.pop());
            else{
                resp=false;
            }
        }
        while(!auxp.isEmpty())
            p1.push(auxp.pop());
        for(int i=0;i<auxa.size();i++)
            p2.push(auxa.get(i));
        return resp;
    }
    
    public static <T> boolean sonIguales(PilaADT<T> p1, PilaADT<T> p2){
        if(p1==null ||p2==null)
            throw new NullPointerException();
        if(p1.isEmpty()|| p2.isEmpty())
            throw new EmptyCollectionException();
        boolean resp=true;
        PilaADT <T> aux1= new PilaA();
        PilaADT <T> aux2= new PilaA();
        while(!p1.isEmpty() && resp && p2.isEmpty()){
            if(p1.peek().equals(p2.peek())){
                aux1.push(p1.pop());
                aux2.push(p2.pop());
            }
            else{
                resp=false;
            }       
        }
        if(!p2.isEmpty() || !p1.isEmpty())
            resp=false;
        while(!aux1.isEmpty())
            p1.push(aux1.pop());
        while(!aux2.isEmpty())
            p2.push(aux2.pop());
        return resp;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static <T> boolean sonCasiIgualesExamenPrueba2015(PilaADT<T> p1,PilaADT<T> p2,int n){
        if(p1==null||p2==null)
            throw new NullPointerException();
        if(p1.isEmpty() || p2.isEmpty())
            throw new EmptyCollectionException();
        boolean resp=true;
        int i=0;
        PilaADT<T> aux1= new PilaA();
        PilaADT<T> aux2= new PilaA();
        while(!p1.isEmpty())
            aux1.push(p1.pop());
        while(!p2.isEmpty())
            aux2.push(p2.pop());
        while(i<n && resp && (!aux1.isEmpty()||!aux2.isEmpty())){
            if(aux1.peek().equals(aux2.peek())){
                p1.push(aux1.pop());
                p2.push(aux2.pop());
                i++;
            }
            else{
                resp=false;
            }
        }
        if(i<n)
            resp=false;
        while(!aux1.isEmpty())
            p1.push(aux1.pop());
        while(!aux2.isEmpty())
            p2.push(aux2.pop());
        return resp;
    }
    
//    public static boolean actualizaTiraje(){
//        
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        PilaADT<Integer>p=new PilaA();
        PilaADT<Integer>p1=new PilaA();
        p.push(6);
        p.push(8);
        p.push(10);
        p1.push(6);
        p1.push(8);
        p1.push(9);
        p1.push(13);
        p1.push(15);
//        RevisaCadena.invierteElementos(p);
//        for(int i=0;i<3;i++)
//            System.out.println(p.pop());
//        p.push(2);
//        p.push(2);
//        p.push(3);
//        p.push(3);
//        p.push(1);
//        RevisaCadena.quitaRepetidos(p);
//        for(int i=0;i<3;i++)
//            System.out.println(p.pop());
        System.out.println(RevisaCadena.sonCasiIgualesExamenPrueba2015(p, p1, 4));
        for(int i=0;i<5;i++){
            System.out.println(p1.pop());
        }
        for(int j=0;j<3;j++){
            System.out.println(p.pop());
        }
    }    
}
