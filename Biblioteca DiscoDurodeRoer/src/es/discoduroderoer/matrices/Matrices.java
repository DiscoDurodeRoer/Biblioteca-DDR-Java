package es.discoduroderoer.matrices;

/**
 * @author DiscoDurodeRoer
 */
public class Matrices {

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
