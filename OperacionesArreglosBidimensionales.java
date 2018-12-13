/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Damo
 */
public class OperacionesArreglosBidimensionales <T>{
    
    private double [][] matriz;
    private int totR,totC;
    private final int MAX=20;

    public OperacionesArreglosBidimensionales() {
        matriz= new double [MAX][MAX];
        totR=0;
        totC=0;
    }
    
    public boolean llenaMatriz(String nomArch){
        boolean resp;
        try{
            File file= new File(nomArch);
            Scanner lee=new Scanner(file);
            int i,j;
            totR=lee.nextInt();
            totC=lee.nextInt();
            for(i=0;i<totR;i++)
                for(j=0;j<totC;j++)
                    matriz[i][j]=lee.nextDouble();
            resp=true;
            lee.close();
        }
        catch(Exception e){
            resp=false;
        }
        return resp;
    }
    
    public double sumaR(){
        if(totC==0&&totR==0)
            return 0;
        else
            return sumaR(0,0);
    }
    
    public double sumaR(int r,int c){
        if(c==totC-1&&r==totR-1)
            return matriz[r][c];
        else
            if(c!=totC-1)
                return matriz[r][c]+sumaR(r,c+1);
            else 
                return matriz[r][c]+sumaR(r+1,c);
    }
    
    public double sumaC(){
        double suma=0;
        if(totC>0&&totR>0)
            suma =sumaC(0,0,suma);
        else
            suma=0;
        return suma;
    }
    
    public double sumaC(int r,int c,double suma){
        if(c==totC-1&&r==totR-1)
            return matriz[r][c]+suma;
        else
            if(r!=totR-1){
                suma+= matriz[r][c]+sumaR(r+1,c);
                return sumaC(r+1,c,suma);
            }
            else {
               suma+= matriz[r][c]+sumaR(r,c+1);
                return sumaC(r,c+1,suma); 
            }
    }
    
    public double sumaDP(){
        double suma=0;
        if(totR>0&&totC>0)
            suma=sumaDP(0,0);
        return suma;
    }
    
    private double sumaDP(int i,double suma){
        if(i==totR-1&&i==totC-1)
            return matriz[i][i]+suma;
        else{
            suma+=matriz[i][i];
            return sumaDP(i+1,suma);
        }
    }
    
    public double[][] sumaMatrices(double[][] otra,int totro, int totco){
        if(totR==totro&&totC==totco&& otra!=null){
            double[][] resp=new double[totR][totC];
            sumaMatrices(otra,0,0,resp);
            return resp;
        }else
            return null;
    }
    
    private void sumaMatrices(double [][] otra,int r,int c, double [][]resp){
        if(r<totR)
            if(c<totC){
                resp[r][c]=matriz[r][c]+otra[r][c];
                sumaMatrices(otra,r,c+1,resp);
            }else
                sumaMatrices(otra,r+1,c,resp);
    }
    
    public double[][] multMatrices(double[][] otra, int totro,int totco){
        if(totC==totro){
            double[][] resp=new double[totR][totco];
            multMatrices(otra,0,0,totco,resp);
            return resp;
        }
        else
            return null;       
    }

    private void multMatrices(double[][] otra, int r, int c, int totco, double[][] resp) {
        if(r<totR)
            if(c<totco){
                for(int i=0;i<totco;i++){
                    resp[r][c]=matriz[r+i][c]+otra[r][c+i];
                     
                }
                multMatrices(otra,r,c+1,totco,resp);
            }
        else
                multMatrices(otra,r+1,c,totco,resp);
    }
    
    
    
}
