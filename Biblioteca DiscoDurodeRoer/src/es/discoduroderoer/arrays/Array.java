/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.arrays;

import java.util.Arrays;

/**
 * @author Discoduroderoer
 */
public class Array {

    /**
     * Indica si los números de un array son capicua, es decir, que es el mismo
     * número si se lee por el principio y por el final
     *
     * @param lista Array con numeros
     * @return True si es capicua, false si no lo es
     */
    public static boolean EsCapicua(int lista[]) {

        //creamos otro array
        int listaprueba[];
        listaprueba = new int[lista.length];

        //asignamos los valores al nuevo array
        //lo hacemos añadiendo los ultimos valores del primer array, al principio del nuevo array
        for (int i = 0, j = 1; j <= lista.length; i++, j++) {
            listaprueba[i] = lista[lista.length - j];
        }

        return Arrays.equals(lista, listaprueba);

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
