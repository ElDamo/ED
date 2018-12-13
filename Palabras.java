/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author damia
 */
public class Palabras implements Serializable{
    
    public static int CuentaPalabras(String nom){
        int cont;
        try{
           File f= new File(nom);
           FileInputStream fis= new FileInputStream(f);
           Scanner lee= new Scanner(fis);
           cont= CuentaPalabras(lee,0);
        }catch(Exception e){
            cont=-1;
        }
        return cont;
    }
    
    private static int CuentaPalabras(Scanner lee, int cont){
        if(lee.hasNext()){
            cont++;
            lee.next();
            return CuentaPalabras(lee,cont);
        }
        else
            return cont;
    }
    
    public static void main(String[] args) {
        
        try(
           FileReader fr= new FileReader(args[0])){
           BufferedReader br= new BufferedReader(fr);
           String ln;
           Scanner sc;
           long cont=0;
           while((ln=br.readLine())!=null){
               sc= new Scanner(ln);
               while(sc.hasNext()){
                   sc.next();
                   cont++;
               }
           }
          System.out.println(""); 
        }catch(Exception e){
            System.out.println("No valid file specified");
        } // Cíclico
        
        try(FileReader fr= new FileReader(args[0])){
           BufferedReader br= new BufferedReader(fr);
           String ln;
           Scanner sc;
           long cont=0;
           while((ln=br.readLine())!=null){
               sc= new Scanner(ln);
               while(sc.hasNext()){
                   sc.next();
                   cont++;
               }
           }
          System.out.println(""); 
        }catch(Exception e){
            System.out.println("No valid file specified");
        }// Recursivo
            
    }
    
}
