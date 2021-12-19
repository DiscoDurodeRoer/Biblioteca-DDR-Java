package es.discoduroderoer.matrices;

import es.discoduroderoer.arrays.Array;

/**
 * @author DiscoDurodeRoer
 */
public class Matrices {

    /**
     * Devuelve las posiciones adyacentes de una posicion en una matriz de int
     *
     * @param matriz Matriz
     * @param fila Fila
     * @param columna Columna
     * @return Posiciones adyacentes
     */
    public static int[] adyacentesA(int matriz[][], int fila, int columna) {

        int tamanio = matriz.length;

        int dirs[] = {1, -1, 1, 0, 1, 1, 0, 1, -1, 1, -1, 0, -1, -1, 0, -1};

        int posicionesValidas[] = new int[17];

        int indice2 = 0;
        for (int indice = 0; indice < dirs.length; indice += 2) {
            if (fila + dirs[indice] >= 0 && fila + dirs[indice] < tamanio && columna + dirs[indice + 1] >= 0 && columna + dirs[indice + 1] < tamanio) {
                posicionesValidas[indice2] = fila + dirs[indice];
                posicionesValidas[indice2 + 1] = columna + dirs[indice + 1];
                indice2 += 2;
            }
        }

        return Array.redimensionar(posicionesValidas, indice2);
    }

    /**
     * Devuelve las posiciones adyacentes de una posicion concreta
     *
     * @param filas que tiene la matriz
     * @param columnas que tiene la matriz
     * @param filaOrigen de donde queremos sacar las posiciones adyacentes
     * @param columnaOrigen de donde queremos sacar las posiciones adyacentes
     * @return Matriz con las posiciones adyacentes
     */
    public static int[][] adyacentesA(int filas, int columnas, int filaOrigen, int columnaOrigen) {

        if (!(filaOrigen >= 0
                && filaOrigen <= (filas - 1)
                && columnaOrigen >= 0
                && columnaOrigen <= (columnas - 1))) {
            return null;
        }

        int numPosiciones;

        if (filaOrigen == 0 || filaOrigen == (filas - 1)) {
            if (columnaOrigen == 0 || columnaOrigen == (columnas - 1)) {
                numPosiciones = 3;
            } else {
                numPosiciones = 5;
            }
        } else {
            if (columnaOrigen == 0 || columnaOrigen == (columnas - 1)) {
                numPosiciones = 5;
            } else {
                numPosiciones = 8;
            }
        }
        
        int[][] posiciones = new int[numPosiciones][2];
        
        int indicePosicion = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if ((i != 0 || j != 0)
                        && (filaOrigen + i) >= 0
                        && (filaOrigen + i) <= (filas - 1)
                        && (columnaOrigen + j) >= 0
                        && (columnaOrigen + j) <= (columnas - 1)) {
                    posiciones[indicePosicion][0] = filaOrigen + i;
                    posiciones[indicePosicion][1] = columnaOrigen + j;
                    indicePosicion++;
                }
            }
        }
        return posiciones;
    }
}
