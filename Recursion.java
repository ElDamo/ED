/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Damo
 */
public class Recursion {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static int calculaFac(int n){
        if(n==1||n==0)
            return 1;
        
        else
            return n*calculaFac(n-1);
    }
    
    public static double sumaArreglo(double[] arre, int n){
        if(n==0)
            return 0;
        else
            return arre[n-1]+sumaArreglo(arre,n-1);
        
    }
    
    public static <T> void imprArreDI(T[] arre, int n){
        if(n>0){
            System.out.println(arre[n-1].toString());
            imprArreDI(arre,n-1);
        }     
    }
    
    public static <T> void imprArreID(T[] arre,int n, int i){
        if(i!=n){
            System.out.println(arre[i]);
            i++;
            imprArreID(arre,n,i++);
        }
        
    }
    
    public static int Particiones(int m, int n){
        int resp;
        if((m==1&& n!=1)||(n==1&&m!=1))
            return 1;
        if(m<n)
            resp=Particiones(m,m);
        else{
            if(m>n)
                resp=Particiones(m,n-1)+Particiones(m-n,n);
            else
                resp=1+Particiones(m,m-1);
        }
        return resp;
    }
    
    public static void imprimeMovimientosTorresdeHanoi(int n, String origen, String destino,String aux){
        if(n==1)
            System.out.println("Mover 1 disco de " + origen + " a "+ destino);
        else{
            imprimeMovimientosTorresdeHanoi(n-1,origen,aux,destino);
            System.out.println("Mover un disco de "+origen+" a "+destino);
            imprimeMovimientosTorresdeHanoi(n-1,aux,destino,origen);
        }
    }
    
    public static int[][] llenaCuadroMagico(int n){
        if(n<0|| n%2==0)
            throw new IllegalArgumentException();
        else{
            int[][] matriz=new int[n][n];
            return llenaCuadroMagico(matriz,n,0,n/2,1);
        }   
    }
    
    private static int[][] llenaCuadroMagico(int[][] matriz, int n, int r, int c,int val ){
       if((val-1)%5==0){
           r=r+1;
           matriz[r][c]=val;
       }
       else
           matriz[r][c]=val;
       if(val==n*n)
           return matriz;
       else
            return llenaCuadroMagico(matriz,n,(r-1)%n,(c+1)%n,val+1);   
    }
    
    
    public static void main(String[] args) {
        System.out.println(Particiones(900,900));
        String origen,destino, aux;
        origen= "Origen";
        destino= "Destino";
        aux= "Auxiliar";
        imprimeMovimientosTorresdeHanoi(10,origen,destino,aux);
    }
    
}
