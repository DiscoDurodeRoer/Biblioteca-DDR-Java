package es.discoduroderoer.numeros;

import es.discoduroderoer.arrays.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author DiscoDurodeRoer
 */
public class Numeros {

    /**
     * Indica cual es el menor número de un array
     *
     * @param numeros Array de int
     * @return Menor número
     */
    public static int minimo(int[] numeros) {

        if (numeros == null) {
            return -1;
        } else {
            int menor = numeros[0];

            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] < menor) {
                    menor = numeros[i];
                }
            }

            return menor;
        }

    }

    /**
     * Devuelve el minimo numero de un array recursivamente
     *
     * @param numeros
     * @param indice
     * @return
     */
    public static int minimoRec(int[] numeros, int indice) {

        int minimo = Integer.MAX_VALUE;

        //Cuando el indice sea igual a la longitud del array, terminaremos la recursividad
        if (indice != numeros.length) {

            //Comparamos el 1º con el 2º, el 2º con el 3º, etc.
            minimo = Math.min(numeros[indice], minimoRec(numeros, indice + 1));

        }

        return minimo;

    }

    /**
     * Indica cual es el mayor número de un array
     *
     * @param numeros Array de int
     * @return Mayor número
     */
    public static int maximo(int[] numeros) {

        if (numeros == null) {
            return -1;
        } else {
            int mayor = numeros[0];

            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] > mayor) {
                    mayor = numeros[i];
                }
            }

            return mayor;
        }

    }

    /**
     * Indica cual es el mayor número de un array recursivamente
     *
     * @param numeros Array de int
     * @return Mayor número
     */
    public static int maximoRec(int[] numeros, int indice) {

        int maximo = Integer.MIN_VALUE;

        //Cuando el indice sea igual a la longitud del array, terminaremos la recursividad
        if (indice != numeros.length) {

            //Comparamos el 1º con el 2º, el 2º con el 3º, etc.
            maximo = Math.max(numeros[indice], maximoRec(numeros, indice + 1));

        }

        return maximo;

    }

    /**
     * Indica cual es la posicion del menor número de un array
     *
     * @param numeros Array de int
     * @return Posicion del menor número, -1 si hay algun error
     */
    public static int posicionMenorNumero(int[] numeros) {

        if (numeros == null) {
            return -1;
        } else {
            int menor = numeros[0];
            int posicion = 0;
            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] < menor) {
                    menor = numeros[i];
                    posicion = i;
                }
            }

            return posicion;
        }

    }

    /**
     * Indica cual es la posicion del mayor número de un array
     *
     * @param numeros Array de int
     * @return Posicionmayor número, -1 si hay algun error
     */
    public static int posicionMayorNumero(int[] numeros) {

        if (numeros == null) {
            return -1;
        } else {
            int mayor = numeros[0];
            int posicion = 0;
            for (int i = 1; i < numeros.length; i++) {
                if (numeros[i] > mayor) {
                    mayor = numeros[i];
                    posicion = i;
                }
            }

            return posicion;
        }

    }

    /**
     * Indica la posicion de un elemento recursivamente
     *
     * @param array
     * @param elementoBuscar
     * @param indice
     * @return
     */
    public static int posicionElementoRecursivo(int[] array, int elementoBuscar, int indice) {

        if (indice == array.length || array[indice] == elementoBuscar) {

            if (indice == array.length) {
                return -1;
            } else {
                return indice;
            }

        } else {
            return posicionElementoRecursivo(array, elementoBuscar, indice + 1);
        }

    }

    /**
     * Cuenta el numero de cifras de un numero
     *
     * @param num Número a contrar
     * @return numero de cifras
     */
    public static int cuentaCifras(int num) {

        int contador = 0;

        if (num == 0) {
            contador = 1;
        } else {

            for (int i = Math.abs(num); i > 0; i++) {
                contador++;
            }

        }

        return contador;
    }

    /**
     * Indica el numero de la serie fibonacci
     *
     * @param posicion Posición de la serie Fibonacci
     * @return Número de la serie Fibonacci
     */
    public static int numeroFibonacci(int posicion) {
        int num1 = 0, num2 = 1, suma = 1;

        for (int i = 1; i < posicion; i++) {
            //primero sumamos
            suma = num1 + num2;
            //Despues, cambiamos la segunda variable por la primera
            num1 = num2;
            //Por ultimo, cambiamos la suma por la segunda variable
            num2 = suma;
        }
        return suma;

    }

    /**
     * Devuelve el numero fibonacci dado su posicion
     *
     * @param n
     * @return
     */
    public static int fibonacciRecursivo(int n) {

        //CASO BASE, si es cero devuelve un cero
        //Puedes poner n<=0 tamvien para incluir negativos
        if (n == 0) {
            return 0;
            //CASO BASE, si es 1 devuelve un 1    
        } else if (n == 1) {
            return 1;
        } else {
            //Hago la suma
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }

    }

    public static int sumaDigitos(int numeroInicial) {

        int numero = numeroInicial;
        int suma = 0;
        int numero_solo;

        while (numeroInicial > 0) {
            numero /= 10;
            numero_solo = numeroInicial - (numero * 10);
            suma += numero_solo;
            numeroInicial = numero;
        }
        return suma;
    }

    public static int[] devuelveDigitos(int numeroInicial) {

        int numero = numeroInicial;

        int digitos[] = new int[cuentaCifras(numeroInicial)];
        int numero_solo;

        for (int i = 0; numeroInicial > 0; i++) {
            numero /= 10;
            numero_solo = numeroInicial - (numero * 10);
            digitos[i] = numero_solo;
            numeroInicial = numero;
        }
        return Array.invertirArray(digitos);

    }

    public static double redondeoDecimales(double numero, int numeroDecimales) {
        BigDecimal redondeado = new BigDecimal(numero)
                .setScale(numeroDecimales, RoundingMode.HALF_EVEN);
        return redondeado.doubleValue();
    }

    public static float redondeoDecimales(float numero, int numeroDecimales) {
        BigDecimal redondeado = new BigDecimal(numero)
                .setScale(numeroDecimales, RoundingMode.HALF_EVEN);
        return redondeado.floatValue();
    }

    /**
     * Devuelve un numero invertido
     *
     * @param num
     * @param pos
     * @return
     */
    public static int invertirNum(int num, int pos) {

        //Si es menor que 10 devuelvo el numero (el ultimo numero)
        if (num < 10) {
            return num;
        } else {
            //Cojo el modulo del numero y lo multiplico por la potencia (4 * 100) por ejemplo
            return (num % 10) * (int) Math.pow(10, pos) + (invertirNum(num / 10, pos - 1));
        }

    }

}
