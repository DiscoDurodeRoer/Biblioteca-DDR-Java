
package es.discoduroderoer.matrices;

import es.discoduroderoer.numeros.Aleatorios;

/**
 * @author DiscoDurodeRoer
 */
public class Posicionar {
    
    /**
     * Posiciona un elemento en una matriz pasandoles la posicion
     * @param matriz Matriz
     * @param posicion Posicion, por ejemplo, en una matriz 3x3 la posicion central seria 4
     * @param objeto Objeto a posicionar
     */
    public static void posicionarElementoMatriz(Object matriz[][], int posicion, Object objeto){

        int tamanio = matriz.length;

        matriz[(int)Math.floor(posicion / tamanio)][posicion % tamanio] = objeto;

}

    /**
     * Posiciona y devuelve donde lo haya posicionado
     * @param matriz Matriz
     * @param posicion Posicion, por ejemplo, en una matriz 3x3 la posicion central seria 4
     * @param objeto Objeto a posicionar
     * @return Posicion donde se ha posicionado
     */
    public static int[] devolverPosicionMatriz(Object matriz[][], int posicion, Object objeto){

        int posiciones[]=new int[2];

        int tamanio = matriz.length;

        matriz[(int)Math.floor(posicion / tamanio)][posicion % tamanio] = objeto;

        posiciones[0] = (int)Math.floor(posicion / tamanio);
        posiciones[1] = posicion % tamanio;

        return posiciones;

    }
    
    /**
     * Devuelve las posiciones (fila y columna) respecto a una posición
     * @param matriz Matriz
     * @param posicion Posicion, por ejemplo, en una matriz 3x3 la posicion central seria 4
     * @return Posiciones 
     */
    public static int[] devolverPosiciones(Object matriz[][], int posicion){
        int posiciones[]=new int[2];

        int tamanio = matriz.length;

        posiciones[0] = (int)Math.floor(posicion / tamanio);
        posiciones[1] = posicion % tamanio;

        return posiciones;
    }

    /**
     * Posiciona un elemento en una matriz aleatoriamente
     * @param matriz Matriz
     * @param objeto Objeto a posicionar
     */
    public static void posicionarElementoMatriz(Object matriz[][], Object objeto){

        int tamanio = matriz.length;
        int posicion = Aleatorios.generaNumeroAleatorio(0, (tamanio * tamanio) - 1);

        matriz[(int)Math.floor(posicion / tamanio)][posicion % tamanio] = objeto;

    }
    
    
}
