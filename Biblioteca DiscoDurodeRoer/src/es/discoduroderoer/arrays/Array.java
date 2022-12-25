/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.arrays;

import es.discoduroderoer.numeros.Numeros;
import java.util.Arrays;

/**
 * @author Discoduroderoer
 */
public class Array {

    /**
     * Indica si un número es capicua, es decir, que es el mismo número si se
     * lee igual por el principio y por el final
     *
     * @param numero
     * @return True si es capicua, false si no lo es
     */
    public static boolean esCapicua(int numero) {

        // Genero un array
        int original[] = Numeros.devuelveDigitos(numero);
        // Invertimos el array
        int invertido[] = invertirArray(original);

        // Si el array son iguales, es capicua
        return Arrays.equals(original, invertido);
    }

    /**
     * Redimensiona un array de números dando una nueva logitud, los datos
     * posteriores se borraran
     *
     * @param array Array que queremos redimensionar
     * @param nuevaLongitud La longitud que tendrá el nuevo array
     * @return Devuelve un nuevo array redimensionado
     */
    public static int[] redimensionar(int array[], int nuevaLongitud) {

        int temp[] = new int[nuevaLongitud];

        if (array.length > nuevaLongitud) {

            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[i];
            }

        } else {

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

        }

        return temp;

    }

    /**
     * Indica si dos arrays son iguales
     *
     * @param a1 Array 1
     * @param a2 Array 2
     * @param indice indice inicial
     * @return si es o no dos arrays iguales
     */
    public static boolean arraysIgualesRec(int[] a1, int[] a2, int indice) {

        if (indice == a1.length) {
            return true;
        } else if (a1[indice] != a2[indice]) {
            return false;
        } else {
            return arraysIgualesRec(a1, a2, indice + 1);
        }

    }

    /**
     * Redimensiona un array de cadenas dando una nueva logitud, los datos
     * posteriores se borraran
     *
     * @param array Array que queremos redimensionar
     * @param nuevaLongitud La longitud que tendrá el nuevo array
     * @return Devuelve un nuevo array redimensionado
     */
    public static String[] redimensionar(String array[], int nuevaLongitud) {

        String temp[] = new String[nuevaLongitud];

        if (array.length > nuevaLongitud) {

            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[i];
            }

        } else {

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

        }

        return temp;

    }

    /**
     * Redimensiona un array de doubles dando una nueva logitud, los datos
     * posteriores se borraran
     *
     * @param array Array que queremos redimensionar
     * @param nuevaLongitud La longitud que tendrá el nuevo array
     * @return Devuelve un nuevo array redimensionado
     */
    public static double[] redimensionar(double array[], int nuevaLongitud) {

        double temp[] = new double[nuevaLongitud];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }

        return temp;

    }

    /**
     * Invierte los datos de un array
     *
     * @param array Array que contiene los datos
     * @return Devuelve un nuevo array con los datos invertidos
     */
    public static int[] invertirArray(int array[]) {

        int temp[] = new int[array.length];

        for (int i = temp.length - 1, j = 0; i >= 0; i--, j++) {
            temp[i] = array[j];
        }

        return temp;
    }

    /**
     * Devuelve un String con los nombres de los tipos del array
     *
     * @param array Contiene los datos
     * @return Array con los nombres de los tipos del array
     */
    public static String[] tiposDatos(Object[] array) {

        String tipos[] = new String[array.length];

        for (int i = 0; i < array.length; i++) {

            tipos[i] = devuelveTipoDato(array[i].getClass().getName());

        }

        return tipos;

    }

    /**
     * Indica si un elemento dentro de un array esta repetido
     *
     * @param array array a comprobar
     * @return si hay o no algun elemento repetido
     */
    public static boolean elementoRepetido(int[] array) {

        // Recorremos el array la 1º vez
        for (int i = 0; i < array.length; i++) {

            // Recorremos el mismo array
            for (int j = i + 1; j < array.length; j++) {
                // Si coincide significa que hay un elemento repetido
                if (array[i] == array[j]) {
                    return true;
                }
            }

        }

        // No hay un elemento repetido
        return false;

    }

    /**
     * Indica si un elemento dentro de un array esta repetido
     *
     * @param array array a comprobar
     * @param num numero a comprobar
     * @return si hay o no algun elemento repetido
     */
    public static boolean elementoRepetido(int[] array, int num) {

        // Recorremos el mismo array
        for (int i = 0; i < array.length; i++) {
            // Si coincide significa que hay un elemento repetido
            if (array[i] == num) {
                return true;
            }
        }

        // No hay un elemento repetido
        return false;

    }

    /**
     * Indica si un elemento dentro de un array esta repetido
     *
     * @param array array a comprobar
     * @param cadena cadena a comprobar
     * @return si hay o no algun elemento repetido
     */
    public static boolean elementoRepetido(String[] array, String cadena) {

        // Recorremos el mismo array
        for (int i = 0; i < array.length; i++) {
            // Si coincide significa que hay un elemento repetido
            if (array[i].equalsIgnoreCase(cadena)) {
                return true;
            }
        }

        // No hay un elemento repetido
        return false;

    }

    /**
     * Indica si un elemento esta repetido en otro array.
     *
     * @param array1 Primer array
     * @param array2 Segundo array
     * @return si hay o no algun elemento repetido
     */
    public static boolean elementoRepetido(int[] array1, int[] array2) {

        // Recorro el primer array
        for (int i = 0; i < array1.length; i++) {

            // Recorro el segundo array
            for (int j = 0; j < array2.length; j++) {
                // Si coincide hay un elemento repetido
                if (array1[i] == array2[j]) {
                    return true;
                }
            }

        }

        // No hay elemento repetido
        return false;

    }

    /**
     * Indica cuantas veces se repite un elemento en el arrat dado
     *
     * @param array Array a comprobar
     * @param elemento Elemento a buscar
     * @return Numero de repeticiones del elemento en el array
     */
    public static int numeroElementosRepetido(int[] array, int elemento) {

        int repetidos = 0;
        for (int i = 0; i < array.length; i++) {
            // Si coincide, tenemos un repetido mas
            if (array[i] == elemento) {
                repetidos++;
            }
        }

        return repetidos;
    }

    /**
     * Indica cuantos repetidos hay en dos arrays, sin contar los que estan en
     * la misma posicion
     *
     * @param array1 Primer array
     * @param array2 Segundo array
     * @return Numero de repeticiones en ambos arrays sin contar los que estan
     * en la misma posicion
     */
    public static int numeroElementosRepetidosDistintaPosicion(int[] array1, int[] array2) {

        int repetidos = 0;
        for (int i = 0; i < array1.length; i++) {

            for (int j = 0; j < array2.length; j++) {
                // Sino es la misma posicion y son igaules, aumento los repetidos
                if (i != j && array1[i] == array2[j]) {
                    repetidos++;
                }
            }
        }
        return repetidos;
    }

    /**
     * Indico cuando elementos repetidos hay en dos arrays. Solo arrays con la
     * misma longitud y en la misma posicion.
     *
     * @param array1 Primer array
     * @param array2 Segundo array
     * @return Numero de repeticiones en ambos arrays. Devuelve -1 en caso de
     * que sean de logitudes diferentes
     */
    public static int numeroElementosRepetidosMismaPosicion(int[] array1, int[] array2) {

        // Si son de diferentes longitudes, devuelvo -1
        if (array1.length != array2.length) {
            return -1;
        }

        int repetidos = 0;

        for (int i = 0; i < array1.length; i++) {
            // Si son iguales, aumento los repetidos
            if (array1[i] == array2[i]) {
                repetidos++;
            }
        }

        return repetidos;

    }

    private static String devuelveTipoDato(String tipoCompleto) {

        String tipo;

        switch (tipoCompleto) {
            case "java.lang.Byte":
            case "java.lang.Short":
            case "java.lang.Integer":
            case "java.lang.Long":
            case "java.lang.Double":
            case "java.lang.Float":
            case "java.lang.String":
            case "java.lang.Character":
            case "java.lang.Boolean":
                tipo = tipoCompleto.substring(10);
                break;
            default:
                tipo = "Desconocido";
        }

        return tipo;

    }

    /**
     * Invierte un array de forma recursiva
     *
     * @param array Array a invertir
     * @param inicio Donde empiezo
     * @param fin Donde acabo
     */
    public static void invertirArrayRecursivo(int[] array, int inicio, int fin) {

        if (inicio < fin) {
            int aux = array[inicio];
            array[inicio] = array[fin];
            array[fin] = aux;
            invertirArrayRecursivo(array, inicio + 1, fin - 1);
        }

    }

}
