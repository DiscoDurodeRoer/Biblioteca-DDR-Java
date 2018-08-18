package es.discoduroderoer.matrices;

import javax.swing.JOptionPane;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Operaciones {
 
    
    /**
     * Realiza el producto de dos matrices
     * @param matriz1 Matriz 1
     * @param matriz2 Matriz 2
     * @return Producto de las dos matrices
     */
    public static int[][] productoMatrices(int matriz1[][], int matriz2[][]){
        
        int matrizProducto[][]=new int [matriz1.length][matriz2[0].length];
     
        int suma;
        
        
        for (int i=0;i<matrizProducto.length;i++){
            
            
            for(int j=0;j<matrizProducto.length;j++){
                
                suma=0;
                for(int z=0;z<matrizProducto.length-1;z++){
                    
                    suma += matriz1[i][z]*matriz2[z][j];
                    JOptionPane.showMessageDialog(null, suma);
                
                }
                matrizProducto[i][j]= suma;
            }   
        }
        return matrizProducto;
        
    }
    
    /**
     * Suma dos matrices
     * @param matriz1 Matriz1
     * @param matriz2 Matriz2
     * @return Suma de la matrices
     */
    public static int[][] sumaMatrices (int matriz1[][], int matriz2[][]){
	
        int sumaMatrices[][]=new int[matriz1.length][matriz1[0].length];
        
        for (int i=0;i<sumaMatrices.length;i++){
            for (int j=0;j<sumaMatrices[0].length;j++){
                sumaMatrices[i][j]=matriz1[i][j]+matriz2[i][j];
            }
        }
        return sumaMatrices;
        
    }
    
}
