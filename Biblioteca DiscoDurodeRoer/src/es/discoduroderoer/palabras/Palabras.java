/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.palabras;

import java.util.StringTokenizer;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Palabras {

    /**
     * Cuenta el número de palabras en una cadena
     *
     * @param cadena Cadena
     * @return Número de palabras
     */
    public static int numeroPalabras(String cadena) {

        StringTokenizer texto = new StringTokenizer(cadena);

        return texto.countTokens();

    }

    /**
     * Número de caracteres en una cadena
     *
     * @param cadena Cadena donde se buscan los caracteres
     * @param caracter Caracter buscado
     * @return Número de caracteres en la cadena
     */
    public static int numeroCaracteres(String cadena, char caracter) {

        int contador = 0;

        for (int i = 0; i < cadena.length(); i++) {

            char caracterActual = cadena.charAt(i);

            if (caracter == caracterActual) {
                contador++;
            }

        }

        return contador;

    }

    /**
     * Cambia las comillas, si las hay (muy util para las instruciones SQL)
     *
     * @param texto Cadena
     * @return Si hay comilla simple modifica el texto, si no devuelve el texto
     * original
     */
    public static String remplazarComillas(String texto) {

        if (texto.indexOf('\'') != -1) {
            return texto.replaceAll("\'", "\'\'");
        }

        return texto;

    }

    /**
     * Invierte una palabra
     *
     * @param palabra Palabra a invertir
     * @param longitud Longitud de la palabra
     * @return palabra invertida
     */
    public static String invertirPalabraRec(String palabra, int longitud) {

        if (longitud == 0) {
            return palabra.charAt(longitud) + "";
        } else {
            return palabra.charAt(longitud) + (invertirPalabraRec(palabra, longitud - 1));
        }

    }

    /**
     * Contar el numero de caracteres recursivamente
     *
     * @param cadena Cadena a contar
     * @param indice Indice donde empezamos
     * @return Numero de caracteres
     */
    public static int cuentaCaracteresRec(String cadena, int indice) {
        try {
            cadena.charAt(indice);
            return 1 + cuentaCaracteresRec(cadena, indice + 1);
        } catch (IndexOutOfBoundsException ex) {
            return 0;
        }
    }

    /**
     * Mostrar una cadena recursivamente
     *
     * @param cadena Cadena a mostrar
     * @param indice Indice donde empezamos
     */
    public static void mostrarCadenaRec(String cadena, int indice) {
        try {
            char c = cadena.charAt(indice);
            System.out.print(c);
            mostrarCadenaRec(cadena, indice + 1);
        } catch (IndexOutOfBoundsException ex) {
        }
    }

}
