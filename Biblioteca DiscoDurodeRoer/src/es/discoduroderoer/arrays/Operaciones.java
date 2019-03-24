/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.arrays;

/**
 * @author Discoduroderoer
 */
public class Operaciones {

    /**
     * Suma todos los enteros de un array
     *
     * @param array Array que queremos sumar
     * @return Resultado de la suma
     */
    public static int sumaArray(int array[]) {

        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }

        return suma;
    }

    /**
     * Suma todos los enteros largos de un array
     *
     * @param array Array que queremos sumar
     * @return Resultado de la suma
     */
    public static long sumaArray(long array[]) {

        long suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }

        return suma;
    }

    /**
     * Suma todos los doubles en un array
     *
     * @param array Array que queremos sumar
     * @return Resultado de la suma
     */
    public static double sumaArray(double array[]) {

        double suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }

        return suma;
    }

    /**
     * Devuelve la media de todos los numeros enteros de un array
     *
     * @param array Array que queremos hacer la media
     * @return Resultado de la media
     */
    public static double mediaArray(int array[]) {

        int suma = sumaArray(array);

        return suma / array.length;
    }

    /**
     * Devuelve la media de todos los numeros reales de un array
     *
     * @param array Array que queremos hacer la media
     * @return Resultado de la media
     */
    public static double mediaArray(double array[]) {

        double suma = sumaArray(array);

        return suma / array.length;
    }

    /**
     * Devuelve la media de todos los numeros largos de un array
     *
     * @param array Array que queremos hacer la media
     * @return Resultado de la media
     */
    public static long mediaArray(long array[]) {

        long suma = sumaArray(array);

        return suma / array.length;
    }

}
