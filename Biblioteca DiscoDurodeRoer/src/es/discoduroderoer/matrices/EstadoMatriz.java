/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.matrices;

import es.discoduroderoer.matrices.Posicionar;



/**
 *
 * @author Fernando
 */
public class EstadoMatriz {
    
    /**
     * Indica si en una posicion hay un onjeto o no.
     * @param matriz Matriz a comprobar
     * @param fila Fila donde esta el dato
     * @param columna Columna donde esta el dato
     * @return True = existe un objeto válido
     */
    public static boolean existePosicion(Object matriz[][], int fila, int columna){
        
        boolean existe=false;
        
        if(matriz[fila][columna]!=null){
            existe=true;
        }
        
        return existe;
    }
    
    
    public static boolean existePosicion(Object matriz[][], int posicion){
        
        boolean existe=false;
        
        int posiciones[]=Posicionar.devolverPosiciones(matriz, posicion);
        
        if(matriz[posiciones[0]][posiciones[1]]!=null){
            existe=true;
        }
        
        return existe;
    }
    
    /**
     * Indica si una matriz esta vacia
     * @param matriz Matriz a comprobar
     * @return True = matriz vacia
     */
    public static boolean matrizVacia(Object matriz[][]){
        
        boolean vacia=true;
        
        for(int i=0;i<matriz.length && vacia;i++){
            for(int j=0;j<matriz[0].length && vacia;j++){
                if(matriz[i][j]!=null){
                    vacia=false;
                }
            }
        }
        
        return vacia;
        
    }
    
    /**
     * Indica si la matriz esta llena
     * @param matriz Matriz a comprobar
     * @return True = matriz llena
     */
    public static boolean matrizLlena(Object matriz[][]){
        
        boolean lleno=true;
        
        for(int i=0;i<matriz.length && lleno;i++){
            for(int j=0;j<matriz[0].length && lleno;j++){
                if(matriz[i][j]==null){
                    lleno=false;
                }
            }
        }
        
        return lleno;
        
    }
    
    /**
     * Comprueba si la columna de una matriz esta llena
     * @param matriz Matriz
     * @param columna Columna de la matriz
     * @return True = columna llena
     */
    public static boolean columnaLlena(Object matriz[][],int columna){
        
        boolean lleno=true;
        
        for(int i=0;i<matriz.length && lleno;i++){
            
            if(matriz[i][columna]==null){
               lleno=false;
            }
            
        }
        
        return lleno;
    
        
    }
    
    /**
     * Comprueba si la fila de una matriz esta llena
     * @param matriz Matriz
     * @param fila Fila de la matriz
     * @return True = fila llena
     */
    public static boolean filaLlena(Object matriz[][],int fila){
        
        boolean lleno=true;
        
        for(int j=0;j<matriz.length && lleno;j++){
            
            if(matriz[fila][j]==null){
               lleno=false;
            }
            
        }
        
        return lleno;
    }
    
}
