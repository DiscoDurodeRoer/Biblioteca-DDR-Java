package es.discoduroderoer.numeros;

import es.discoduroderoer.expresiones_regulares.ExpresionesRegulares;
import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Conversion {

    /**
     * Convierte de binario a decimal
     *
     * @param numerobinario Cadena de 0 y 1
     * @return Valor decimal
     */
    public static int binarioADecimal(String numerobinario) {

        int res = 0;
        try {
            int longitud = numerobinario.length();
            boolean numeroCorrecto = true;
            for (int cont = 0, posicion = longitud - 1; cont <= (longitud - 1) && numeroCorrecto; cont++, posicion--) {
                if (numerobinario.charAt(cont) == '0' || numerobinario.charAt(cont) == '1') {
                    String texto = numerobinario.substring(cont, cont + 1);
                    int numero = Integer.parseInt(texto);
                    res = res + (numero * ((int) Math.pow(2, posicion)));
                } else {
                    numeroCorrecto = false;
                }
            }

            if (numeroCorrecto) {
                return res;
            } else {
                JOptionPane.showMessageDialog(null, "No has introducido un numero binario, solo puedes escribir 0 y 1", "Error", JOptionPane.ERROR_MESSAGE);
                return -1;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cadena pasada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    /**
     * Convierte de binario a decimal
     *
     * @param numerobinario Número con 0 y 1
     * @return Valor decimal
     */
    public static int binarioADecimal(int numerobinario) {

        String auxliar = String.valueOf(numerobinario);

        int res = 0;
        int longitud = auxliar.length();
        boolean numeroCorrecto = true;
        for (int cont = 0, posicion = longitud - 1; cont <= (longitud - 1) && numeroCorrecto; cont++, posicion--) {
            if (auxliar.charAt(cont) == '0' || auxliar.charAt(cont) == '1') {
                String texto = auxliar.substring(cont, cont + 1);
                int numero = Integer.parseInt(texto);
                res = res + (numero * ((int) Math.pow(2, posicion)));
            } else {
                numeroCorrecto = false;
            }
        }

        if (numeroCorrecto) {
            return res;
        } else {
            JOptionPane.showMessageDialog(null, "No has introducido un numero binario, solo puedes escribir 0 y 1", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

    }

    /**
     * Convierte de decimal a binario
     *
     * @param numero Número decimal
     * @return Cadena de 0 y 1
     */
    public static String decimalABinario(int numero) {
        String binario = "";
        String digito;
        for (int i = numero; i > 0; i /= 2) {
            if (i % 2 == 1) {
                digito = "1";
            } else {
                digito = "0";
            }

            binario = digito + binario;
        }
        return binario;
    }

    /**
     * Convierte de decimal a Octal
     *
     * @param numero Número decimal
     * @return Cadena con números octales
     */
    public static String decimalAOctal(int numero) {
        String octal = "";
        String digito;
        for (int i = numero; i > 7; i /= 8) {

            digito = String.valueOf(numero % 8);

            octal = digito + octal;
        }
        return octal;
    }

    /**
     * Convierte de decimal a hexadecimal
     *
     * @param numero Número decimal
     * @return Cadena con números hexadecimales
     */
    public static String decimalAHexadecimal(int numero) {

        String letras[] = {"A", "B", "C", "D", "E", "F"};
        String hex = "";
        String digito;
        for (int i = numero; i > 15; i /= 16) {

            if (numero % 16 >= 10) {
                digito = letras[16 - (numero % 16)];
            } else {
                digito = String.valueOf(numero % 16);
            }

            hex = digito + hex;
        }
        return hex;
    }

    /**
     * Convierte de octal a decimal
     *
     * @param numOctal Número octal
     * @return Valor decimal
     */
    public static int octalADecimal(String numOctal) {

        if (ExpresionesRegulares.validaOctal_Exp(numOctal)) {
            int decimal = 0;
            String cifra;
            for (int i = 0, j = numOctal.length() - 1; j >= 0; i++, j--) {

                cifra = String.valueOf(numOctal.charAt(i));

                decimal += Integer.parseInt(cifra) * Math.pow(8, j);

            }

            return decimal;

        } else {
            JOptionPane.showMessageDialog(null, "Error");
            return -1;
        }

    }

    /**
     * Convierte de hexadecimal a decimal
     *
     * @param hexadecimal Cadena con números hexadecimales
     * @return Valor decimal
     */
    public static int hexadecimalADecimal(String hexadecimal) {

        if (ExpresionesRegulares.validaHexadecimal_Exp(hexadecimal)) {
            int decimal = 0;
            String cifra;
            String letras[] = {"A", "B", "C", "D", "E", "F"};

            for (int i = 0, j = hexadecimal.length() - 1; j >= 0; i++, j--) {

                cifra = String.valueOf(hexadecimal.charAt(i));

                if (ExpresionesRegulares.validaNumeroEntero_Exp(cifra)) {

                    decimal += Integer.parseInt(cifra) * Math.pow(16, j);

                } else {

                    boolean encontrado = false;
                    int num = 0;

                    for (int z = 0; z < letras.length && !encontrado; z++) {
                        if (cifra.toUpperCase().equals(letras[z])) {
                            encontrado = true;
                            num = z;
                        }
                    }

                    num += 10;

                    decimal += num * Math.pow(16, j);
                }

            }

            return decimal;

        } else {
            JOptionPane.showMessageDialog(null, "Error");
            return -1;
        }

    }

}
