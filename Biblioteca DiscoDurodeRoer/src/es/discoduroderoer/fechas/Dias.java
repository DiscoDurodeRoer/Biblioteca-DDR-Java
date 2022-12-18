package es.discoduroderoer.fechas;

import static es.discoduroderoer.fechas.Anios.esBisiesto;
import static es.discoduroderoer.fechas.Meses.mesCorrecto;
import java.time.LocalDate;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Dias {

    /**
     * Devuelve el número de dias del mes pasado por parámetro Si es Febrero
     * tiene en cuenta si este año es bisiesto o no
     *
     * @param mes Mes que queremos saber el número de días
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(String mes) {

        int numeroDias = -1;
        if (mesCorrecto(mes)) {

            switch (mes.toLowerCase().trim()) {
                case "enero":
                case "marzo":
                case "mayo":
                case "julio":
                case "agosto":
                case "octubre":
                case "diciembre":
                    numeroDias = 31;
                    break;
                case "abril":
                case "junio":
                case "septiembre":
                case "noviembre":
                    numeroDias = 30;
                    break;
                case "febrero":
                    LocalDate anioActual = LocalDate.now();
                    if (esBisiesto(anioActual.getYear())) {
                        numeroDias = 29;
                    } else {
                        numeroDias = 28;
                    }
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(null, "El mes introducido no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return numeroDias;
    }

    /**
     * Devuelve el número de dias del mes (número) pasado por parámetro Si es
     * Febrero tiene en cuenta si este año es bisiesto o no Empieza por 1
     *
     * @param mes Mes que queremos saber el número de días
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(int mes) {

        int numeroDias = -1;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:
                LocalDate anioActual = LocalDate.now();                
                if (esBisiesto(anioActual.getYear())) {
                    numeroDias = 29;
                } else {
                    numeroDias = 28;
                }
                break;

        }

        return numeroDias;
    }

    /**
     * Devuelve el número de dias del mes pasado por parámetro Si es Febrero
     * tiene en cuenta el año pasado es bisiesto o no
     *
     * @param mes Mes que queremos saber el número de días
     * @param anio Año, usado para casos de años bisiestos
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(String mes, int anio) {

        int numeroDias = -1;
        switch (mes.toLowerCase().trim()) {
            case "enero":
            case "marzo":
            case "mayo":
            case "julio":
            case "agosto":
            case "octubre":
            case "diciembre":
                numeroDias = 31;
                break;
            case "abril":
            case "junio":
            case "septiembre":
            case "noviembre":
                numeroDias = 30;
                break;
            case "febrero":

                if (esBisiesto(anio)) {
                    numeroDias = 29;
                } else {
                    numeroDias = 28;
                }
                break;

        }

        return numeroDias;
    }

    /**
     * Devuelve el número de dias del mes (número) pasado por parámetro Si es
     * Febrero tiene en cuenta si este año es bisiesto o no Empieza por 1
     *
     * @param mes Mes que queremos saber el número de días
     * @param anio Año, usado para casos de años bisiestos
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(int mes, int anio) {

        int numeroDias = -1;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:
                if (esBisiesto(anio)) {
                    numeroDias = 29;
                } else {
                    numeroDias = 28;
                }
                break;

        }

        return numeroDias;
    }

    /**
     * Calcular el numero de dias entre una fecha y la actual.
     * @param dia Dia de la fecha
     * @param mes Mes de la fecha
     * @param anio Año de la fecha
     * @param incluirFin Indica si queremos incluir la propia fecha final.
     * @return 
     */
    public static int calculaDiasCalendar(int dia, int mes, int anio, boolean incluirFin) {

        Calendar inicio = Calendar.getInstance();
        inicio.set(anio, mes - 1, dia);
        inicio.set(Calendar.HOUR, 0);
        inicio.set(Calendar.HOUR_OF_DAY, 0);
        inicio.set(Calendar.MINUTE, 0);
        inicio.set(Calendar.SECOND, 0);

        Calendar actual = Calendar.getInstance();
        actual.set(Calendar.HOUR, 0);
        actual.set(Calendar.HOUR_OF_DAY, 0);
        actual.set(Calendar.MINUTE, 0);
        actual.set(Calendar.SECOND, 0);

        long finMS = actual.getTimeInMillis();
        long inicioMS = inicio.getTimeInMillis();

        int dias = (int) ((Math.abs(finMS - inicioMS)) / (86400000)); //86400000

        if (incluirFin) {
            dias++;
        }

        return dias;

    }
    
    /**
     * Calcular el numero de dias entre un calendar y la fecha actual.
     * @param inicio Fecha inicial
     * @param incluirFin Indica si queremos incluir la propia fecha final.
     * @return 
     */
    public static int calculaDiasCalendar(Calendar inicio, boolean incluirFin) {

        Calendar actual = Calendar.getInstance();
        actual.set(Calendar.HOUR, 0);
        actual.set(Calendar.HOUR_OF_DAY, 0);
        actual.set(Calendar.MINUTE, 0);
        actual.set(Calendar.SECOND, 0);

        long finMS = actual.getTimeInMillis();
        long inicioMS = inicio.getTimeInMillis();

        int dias = (int) ((Math.abs(finMS - inicioMS)) / (86400000)); //86400000

        if (incluirFin) {
            dias++;
        }

        return dias;

    }
    
    /**
     * Calcular el numero de dias entre 2 calendar.
     *
     * @param inicio Fecha inicial
     * @param fin Fecha final
     * @param incluirFin Indica si queremos incluir la propia fecha final.
     * @return
     */
    public static int calculaDiasCalendar(Calendar inicio, Calendar fin, boolean incluirFin) {

        long finMS = fin.getTimeInMillis();
        long inicioMS = inicio.getTimeInMillis();

        int dias = (int) ((Math.abs(finMS - inicioMS)) / (86400000)); //86400000

        if (incluirFin) {
            dias++;
        }

        return dias;

    }

}
