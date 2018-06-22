/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.matrices;
import es.discoduroderoer.arrays.Array;
/**
 * @author DiscoDurodeRoer
 */
public class Matrices {
    
    /**
     * Devuelve las posiciones adyacentes de una posicion en una matriz de int
     * @param matriz Matriz
     * @param fila Fila
     * @param columna Columna
     * @return Posiciones adyacentes
     */
    public static int[] adyacentesA(int matriz[][], int fila, int columna){
        
        int tamanio=matriz.length;
        
        int dirs[] = {1, -1, 1, 0, 1, 1, 0, 1, -1, 1, -1, 0, -1, -1, 0, -1};
        
        int posicionesValidas[]=new int[17];

        int indice2=0;
        for(int indice=0;indice<dirs.length;indice+=2){
           if(fila + dirs[indice] >= 0 && fila + dirs[indice] < tamanio && columna + dirs[indice + 1] >= 0 && columna + dirs[indice + 1] < tamanio){
              posicionesValidas[indice2] = fila + dirs[indice];
              posicionesValidas[indice2+1] = columna + dirs[indice + 1];
              indice2 += 2;
           } 
        }
        
        return Array.redimensionar(posicionesValidas, indice2);
    }
    
    /**
     * Devuelve las posiciones adyacentes de una posicion en una matriz de Objetos
     * @param matriz Matriz
     * @param fila Fila
     * @param columna Columna
     * @return Posiciones adyacentes
     */
    public static int[] adyacentesA(Object matriz[][], int fila, int columna){
        
        int tamanio=matriz.length;
        
        int dirs[] = {1, -1, 1, 0, 1, 1, 0, 1, -1, 1, -1, 0, -1, -1, 0, -1};
        
        int posicionesValidas[]=new int[17];

        int indice2=0;
        for(int indice=0;indice<dirs.length;indice+=2){
           if(fila + dirs[indice] >= 0 && fila + dirs[indice] < tamanio && columna + dirs[indice + 1] >= 0 && columna + dirs[indice + 1] < tamanio){
              posicionesValidas[indice2] = fila + dirs[indice];
              posicionesValidas[indice2+1] = columna + dirs[indice + 1];
              indice2 += 2;
           } 
        }
        
        return Array.redimensionar(posicionesValidas, indice2);
    }
    
    
    
}
