/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;



/**
 *
 * @author Damián Pérez Landeros
 */
public class Solucionador {
    
    private int[][] matriz;
    private final int MAX=9;

    public Solucionador() {
        matriz= new int[MAX][MAX];
    }

    public Solucionador(int[][] matriz) {
        this.matriz = matriz;
    }
    
    public void agrega(int r, int c, int valor){
        try{
            matriz[r][c]=valor;
        }catch(IndexOutOfBoundsException e){
        }
    }
    
    
    private boolean verificaCol(int r, int c, ConjuntoADT<Integer> con){
        int num= matriz[r][c];
        if(num!=0)
            if(!con.agrega(num))
                return false;
        if(r==MAX-1){
            if(c==MAX-1)
                return true;
            else{
                con= new ConjuntoA();
                return verificaCol(0,c+1,con);
            } 
        }
        else
            return verificaCol(r+1,c,con);
    }
    
    private boolean verificaRen(int r, int c, ConjuntoADT<Integer> con){
        int num= matriz[r][c];
        if(num!=0)
            if(!con.agrega(num))
                return false;
        if(c==MAX-1){
            if(r==MAX-1)
                return true;
            else{
                con= new ConjuntoA();
                return verificaRen(r+1,0,con);
            } 
        }
        else
            return verificaRen(r,c+1,con);
    }
    
    
    
    
    
    
    
}
