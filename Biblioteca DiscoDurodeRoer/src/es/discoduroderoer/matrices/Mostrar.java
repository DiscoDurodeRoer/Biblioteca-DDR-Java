package es.discoduroderoer.matrices;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Mostrar {

    /**
     * Muestra los datos por consola de una matriz de int
     *
     * @param matriz Matriz a mostrar
     */
    public static void mostrarMatriz(int matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Muestra los datos por consola de una matriz de long
     *
     * @param matriz Matriz a mostrar
     */
    public static void mostrarMatriz(long matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Muestra los datos por consola de una matriz de String
     *
     * @param matriz Matriz a mostrar
     */
    public static void mostrarMatriz(String matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Muestra los datos por consola de una matriz de double
     *
     * @param matriz Matriz a mostrar
     */
    public static void mostrarMatriz(double matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Muestra por consola, el estado de la matriz
     *
     * @param matriz Matriz a mostrar
     */
    public static void mostrarMatriz(Object matriz[][]) {

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(matriz[i][j].toString() + " ");
                }
            }
            System.out.println("");
        }

        System.out.println("");

    }

    /**
     * Muestra una matriz de forma recursiva
     *
     * @param matriz Matriz a mostrar
     * @param i Fila actual
     * @param j Columna actual
     */
    public static void mostrarMatrizRec(int[][] matriz, int i, int j) {

        //Muestro el numero (sin salto de linea)
        System.out.print(matriz[i][j] + " ");

        //
        if (i != matriz.length - 1 || j != matriz[i].length - 1) {

            //Indico si llego al final de la fila
            if (j == matriz[i].length - 1) {
                //Paso a la siguiente fila
                i++;
                //Reinicio la j
                j = 0;
                //Salto de linea (solo formato)
                System.out.println("");
            } else {
                //Paso a la siguiente columna
                j++;
            }

            //Volvemos a llamar la función recursivamente
            mostrarMatrizRec(matriz, i, j);

        }

    }

}
