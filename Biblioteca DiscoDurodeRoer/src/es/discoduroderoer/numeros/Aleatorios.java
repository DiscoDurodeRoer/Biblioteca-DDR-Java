package es.discoduroderoer.numeros;

import static es.discoduroderoer.numeros.Calculo.cuentaPrimosEntre;
import static es.discoduroderoer.numeros.Calculo.esPrimo;
import java.util.Arrays;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Aleatorios {

    public static final char CARACTERES_ESPECIALES[] = {'!', '%', '&', '(', ')', '*', '/', '-', '#', '@'};

    /**
     * Genera un numero aleatorio entre dos numeros. Entre el minimo y el maximo
     * incluidos
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */
    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    /**
     * Genera un numero real aleatorio entre dos numeros. Entre el minimo y
     * maximo
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return numero entre minimo y maximo
     */
    public static double generaNumeroRealAleatorio(int minimo, int maximo) {

        double num = Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    /**
     * Genera numeros aleatorios en un array, entre un minimo y un maximo
     *
     * @param longitud Longitud del array
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return array con numeros entre el minimo y el maximo, devuelve null si
     * la longitud es nula
     */
    public static int[] generaNumeroAleatorios(int longitud, int minimo, int maximo) {

        if (longitud < 0) {
            return null;
        } else {
            int numeros[] = new int[longitud];

            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = generaNumeroAleatorio(minimo, maximo);
            }

            return numeros;
        }

    }

    /**
     * Genera numeros aleatorios en un array no repetidos, entre el minimo y el
     * maximo.
     *
     * @param longitud Longitud del array
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return array con numeros no repetidos entre el minimo y el maximo
     */
    public static int[] generaNumeroAleatoriosNoRepetidos(int longitud, int minimo, int maximo) {

        if (longitud < 0) {
            return null;
        } else {

            if (maximo < minimo) {
                int aux = minimo;
                minimo = maximo;
                maximo = aux;
            }

            if ((maximo - minimo) >= (longitud - 1)) {

                int numeros[] = new int[longitud];
                Arrays.fill(numeros, minimo - 1);
                int i = 0;
                int num = 0;
                while (i < numeros.length) {

                    boolean repetido;
                    do {
                        repetido = false;
                        num = generaNumeroAleatorio(minimo, maximo);

                        for (int j = 0; j < numeros.length && !repetido; j++) {
                            if (numeros[j] == num) {
                                repetido = true;
                            }
                        }
                    } while (repetido);

                    numeros[i] = num;
                    i++;
                }

                return numeros;
            } else {
                return null;
            }
        }

    }

    /**
     * Genera una letra mayuscula
     *
     * @return letra mayuscula
     */
    public static char generaLetraMayus() {
        int letra = generaNumeroAleatorio('A', 'Z');
        return (char) letra;
    }

    /**
     * Genera una letra minuscula
     *
     * @return letra minuscula
     */
    public static char generaLetraMinus() {
        int letra = generaNumeroAleatorio('a', 'z');
        return (char) letra;
    }

    /**
     * Genera un caracter especial
     *
     * @return caracter especial
     */
    public static char generaLetraCaracteresEspeciales() {
        int letra = (int) Math.floor(Math.random() * CARACTERES_ESPECIALES.length);
        return (char) CARACTERES_ESPECIALES[letra];
    }

    /**
     * Genera un password, con una longitud. Mezcla numeros, minusculas,
     * mayusculas y caracteres especiales.
     *
     * @param longitud Longitud de la password
     * @return password, null si la longitud es 0 o negativa
     */
    public static String generaPassword(int longitud) {

        if (longitud <= 0) {
            return null;
        } else {
            String password = "";
            for (int i = 0; i < longitud; i++) {
                int eleccion = (int) Math.floor(Math.random() * 4);
                switch (eleccion) {
                    case 0:
                        password += Integer.toString(generaNumeroAleatorio(0, 9));
                        break;
                    case 1:
                        password += generaLetraMayus();
                        break;
                    case 2:
                        password += generaLetraMinus();
                        break;
                    case 3:
                        password += generaLetraCaracteresEspeciales();
                        break;
                }
            }
            return password;
        }
    }

    /**
     * Genera un numero primo entre el minimo y maximo incluidos
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return primo entre el minimo y maximo, -1 si no hay primos entre esos
     * dos numeros
     */
    public static int generarNumeroPrimoAzar(int minimo, int maximo) {

        if (cuentaPrimosEntre(minimo, maximo) == 0) {
            return -1;
        } else {
            int numPrimo;
            do {
                numPrimo = generaNumeroAleatorio(minimo, maximo);
            } while (!esPrimo(numPrimo));
            return numPrimo;
        }

    }

    /**
     * Genera numeros primos entre el maximo y el minimo incluidos, los devuelve
     * en un array
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return array de numeros primos
     */
    public static int[] generarNumerosPrimosEntre(int minimo, int maximo) {

        int numerosPrimos[] = new int[cuentaPrimosEntre(minimo, maximo)];

        if (numerosPrimos.length == 0) {
            return null;
        } else {

            for (int i = minimo, indice = 0; i < maximo; i++) {
                if (esPrimo(i)) {
                    numerosPrimos[indice] = i;
                    indice++;
                }
            }
        }

        return numerosPrimos;
    }

}
