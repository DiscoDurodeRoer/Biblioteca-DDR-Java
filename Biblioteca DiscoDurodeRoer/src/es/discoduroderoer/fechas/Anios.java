package es.discoduroderoer.fechas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.time.LocalDate;


/**
 * @author DiscoDurodeRoer
 */
public class Anios {

    /**
     * Indica si un año es bisiesto o no
     *
     * @param anio Año
     * @return True = es bisiesto
     */
    public static boolean esBisiestoGregorian(int anio) {

        GregorianCalendar calendar = new GregorianCalendar();
        boolean esBisiesto = false;
        if (calendar.isLeapYear(anio)) {
            esBisiesto = true;
        }
        return esBisiesto;

    }

    /**
     * Indica si un año es bisiesto o no
     *
     * @param anio Año
     * @return True = es bisiesto
     */
    public static boolean esBisiesto(int anio) {

        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0);
    }
    
     /**
     * Indica la diferencia de años entre un dia concreto y la fecha actual
     * Hecho con LocalDate
     *
     * @param dia
     * @param mes
     * @param anio
     * @return
     */
    public static int calcularAnios(int dia, int mes, int anio) {

        //Fecha actual
        LocalDate actual = LocalDate.now();

        //Cojo los datos necesarios        
        int diaActual = actual.getDayOfMonth();
        int mesActual = actual.getMonthValue();
        int anioActual = actual.getYear();

        //Diferencia de años
        int diferencia = anioActual - anio;

        //Si el mes actual es menor que el que me pasan le resto 1
        //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
        //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
        if (mesActual <= mes) {
            //si
            if (mesActual == mes) {
                if (dia > diaActual) {
                    diferencia--;
                }
            } else {
                diferencia--;
            }
        }

        return diferencia;

    }
    
     /**
     * Indica la diferencia de años entre un dia concreto y la fecha actual
     * Hecho con Date
     *
     * @param dia
     * @param mes
     * @param anio
     * @return
     */
    @Deprecated
    public static int calcularAniosDate(int dia, int mes, int anio) {

        //Fecha actual
        Date actual = new Date();

        //Cojo los datos necesarios
        int diaActual = actual.getDate();
        int mesActual = actual.getMonth() + 1;
        int anioActual = actual.getYear() + 1900;

        //Diferencia de años
        int diferencia = anioActual - anio;

        //Si el mes actual es menor que el que me pasan le resto 1
        //Si el mes es igual y el dia que me pasan es mayor al actual le resto 1
        //Si el mes es igual y el dia que me pasan es menor al actual no le resto 1
        if (mesActual <= mes) {
            //si
            if (mesActual == mes) {
                if (dia > diaActual) {
                    diferencia--;
                }
            } else {
                diferencia--;
            }
        }

        return diferencia;

    }

    /**
     * Indica la diferencia de años entre un dia concreto y la fecha actual
     * Hecho con Calendar
     *
     * @param dia
     * @param mes
     * @param anio
     * @return
     */
    public static int calcularAniosCalendar(int dia, int mes, int anio) {

        //seteamo el dia mes y año
        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);

        //Dia actual
        Calendar actual = Calendar.getInstance();

        //Calcula la diferencia de años
        int diferencia = actual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

        //Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        if (inicio.get(Calendar.DAY_OF_YEAR) > actual.get(Calendar.DAY_OF_YEAR)) {
            diferencia--;
        }

        return diferencia;

    }

    /**
     * Indica la diferencia de años entre un dia concreto y la fecha actual
     * Hecho con Calendar
     *
     * @param inicio
     * @return
     */
    public static int calcularAniosCalendar(Calendar inicio) {

        //Dia actual
        Calendar actual = Calendar.getInstance();

        //Calcula la diferencia de años
        int diferencia = actual.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

        //Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        if (inicio.get(Calendar.DAY_OF_YEAR) > actual.get(Calendar.DAY_OF_YEAR)) {
            diferencia--;
        }

        return diferencia;

    }

    /**
     * Indica la diferencia de años entre dos Calendar.
     *
     * @param inicio fecha inicial
     * @param fin fecha final
     * @return
     */
    public static int calcularAniosCalendar(Calendar inicio, Calendar fin) {

        //Calcula la diferencia de años
        int diferencia = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);

        //Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        if (inicio.get(Calendar.DAY_OF_YEAR) > fin.get(Calendar.DAY_OF_YEAR)) {
            diferencia--;
        }

        return diferencia;

    }

}
