/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.arrays;

/**
 * @author Discoduroderoer
 */
public class Ordenacion {

    /**
     * Ordena un array de enteros por el metodo de la burbuja
     *
     * @param array Array que queremos ordenar
     */
    public static void ordenacionBurbuja(int array[]) {
        int cuentaintercambios = 0;
        for (boolean ordenado = false; !ordenado;) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int variableauxiliar = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = variableauxiliar;
                    cuentaintercambios++;
                }
            }
            if (cuentaintercambios == 0) {
                ordenado = true;
            }
            cuentaintercambios = 0;
        }
    }

    /**
     * Ordena un array por el metodo de ordenacion QuickSort
     *
     * @param array Array que queremos ordenar
     * @param izq Posición del primer elemento
     * @param der Posición del último elemento
     */
    public static void ordenacionQuicksort(int array[], int izq, int der) {
        int i = izq;
        int j = der;
        int pivote = array[(i + j) / 2];
        do {
            while (array[i] < pivote) {
                i++;
            }
            while (array[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordenacionQuicksort(array, izq, j);
        }
        if (i < der) {
            ordenacionQuicksort(array, i, der);
        }
    }

    /**
     * Ordena un array de cadenas por el metodo QuickSort
     *
     * @param array Array que queremos ordenar
     * @param izq Posición del primer elemento
     * @param der Posición del último elemento
     */
    public static void ordenacionQuicksort(String array[], int izq, int der) {
        int i = izq;
        int j = der;
        int pivote = (i + j) / 2;
        do {
            while (array[i].compareToIgnoreCase(array[pivote]) < 0) {
                i++;
            }
            while (array[j].compareToIgnoreCase(array[pivote]) > 0) {
                j--;
            }
            if (i <= j) {
                String aux = array[i];
                array[i] = array[j];
                array[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j) {
            ordenacionQuicksort(array, izq, j);
        }
        if (i < der) {
            ordenacionQuicksort(array, i, der);
        }
    }

}
