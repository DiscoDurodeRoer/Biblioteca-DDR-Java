/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.matrices;

import es.discoduroderoer.numeros.Aleatorios;


/**
 *
 * @author Fernando
 */
public class Rellenar {
    
    /**
     * Rellena una matriz con números aleatorios entre un mínimo y un máximo
     * @param matriz Matriz a rellenar
     * @param minimo Número mínimo
     * @param maximo Número máximo
     */
    public static void rellenarMatrizAleatorios(int matriz[][], int minimo, int maximo){
        
        for (int i=0;i<matriz.length;i++){
            for (int j=0;j<matriz[0].length;j++){
                matriz[i][j]=Aleatorios.generaNumeroAleatorio(minimo, maximo);
            }
        }
    }
    
}
