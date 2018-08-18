/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.arrays;

import es.discoduroderoer.numeros.Aleatorios;
import es.discoduroderoer.numeros.Validacion;

/**
 * @author Discoduroderoer
 */
public class Rellenar {

    /**
     * Rellena un array de enteros, validando cada numero
     *
     * @param array Array que queremos rellenar
     */
    public static void rellenaArray(int array[]) {

        for (int i = 0; i < array.length; i++) {
            array[i] = Validacion.validarNumero();
        }
    }

    /**
     * Rellena un array de numeros aleatorios entre un mínimo y un máximo
     *
     * @param array Array que queremos rellenar
     * @param minimo Número mínimo
     * @param maximo Número máximo
     */
    public static void rellenaArrayAleatorios(int array[], int minimo, int maximo) {

        for (int i = 0; i < array.length; i++) {
            array[i] = Aleatorios.generaNumeroAleatorio(minimo, maximo);
        }
    }

}
