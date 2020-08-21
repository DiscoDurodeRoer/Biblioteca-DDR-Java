package es.discoduroderoer.numeros;

import es.discoduroderoer.expresiones_regulares.ExpresionesRegulares;
import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Conversion {

    /**
     * Convierte de decimal a binario. Solo positivos
     *
     * @param decimal Decimal a convertir
     * @return numero en formato binario, -1 si el numero es negativo
     */
    public static long decimalABinario(int decimal) {
        long binario = -1;
        int digito;
        final int DIVISOR = 2;
        for (int i = decimal, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = i % DIVISOR;
            binario += digito * Math.pow(10, j);
        }
        return binario;
    }

    /**
     * Convierte de decimal a binario. Solo positivos
     *
     * @param binario Binario a convertir en formato numerico
     * @return numero en formato decimal, -1 si no es un numero binario
     */
    public static int binarioADecimal(long binario) {

        int decimal = 0;
        int digito;
        final long DIVISOR = 10;
        for (long i = binario, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = (int) (i % DIVISOR);
            if (digito != 0 && digito != 1) {
                return -1;
            }
            decimal += digito * Math.pow(2, j);
        }
        return decimal;

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

    public static int decimalaAOctal(int decimal) {
        int octal = 0;
        int digito;
        final int DIVISOR = 8;
        for (int i = decimal, j = 0; i > 0; i /= DIVISOR, j++) {
            digito = i % DIVISOR;
            octal += digito * Math.pow(10, j);
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

    /**
     * Convierte un numero de una base a otra
     *
     * @param numero Numero a convertir
     * @param basex Base del numero a convertir
     * @param basey Base a la que queremos convertir
     * @return numero en formato decimal
     */
    public static int basexABaseY(long numero, int basex, int basey) {
        if (basex >= 2 && basex <= 10 && basey >= 2 && basey <= 10) {
            if (basex == 10 || basey == 10) {
                int decimal = 0;
                int digito;
                final long DIVISOR = basey;
                for (long i = numero, j = 0; i > 0; i /= DIVISOR, j++) {
                    digito = (int) (i % DIVISOR);
                    decimal += digito * Math.pow(basex, j);
                }
                return decimal;
            } else {
                // Lo paso a decimal
                int aDecimal = basexABaseY(numero, basex, 10);
                // Lo paso a la base deseada
                int numeroBaseY = basexABaseY(aDecimal, 10, basey);
                return numeroBaseY;
            }
        } else {
            return -1;
        }
    }

}
