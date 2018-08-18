/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.arrays;

/**
 * @author Discoduroderoer
 */
public class Mostrar {

    /**
     * Muestra por consola un array de enteros (int)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(int array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Muestra por consola un array de cadenas (String)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(String array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Muestra por consola un array de reales (Double)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(double array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Muestra por consola un array de enteros largos (long)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(long array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Muestra por consola un array de caracteres (char)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(char array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Muestra por consola un array de bytes (byte)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(byte array[]) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Muestra por consola un array de Objetos (Object)
     *
     * @param array Array que queremos mostrar
     */
    public static void mostrarArrayConsola(Object array[]) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println("Nulo");
            } else {
                System.out.println(array[i].toString());
            }

        }
    }

    /**
     * Mostrar un array de forma recursiva
     *
     * @param array Array a mostrar
     * @param indice Indice donde me encuentro actualmente
     */
    public static void mostrarArrayRecursivo(int[] array, int indice) {

        if (indice != array.length) {
            //Mostramos el valor en ese indice
            System.out.println(array[indice]);
            //Llamamos recursivamente a la función
            mostrarArrayRecursivo(array, indice + 1);
        }

    }

}
