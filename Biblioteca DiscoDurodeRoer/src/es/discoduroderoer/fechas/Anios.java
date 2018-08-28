/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.fechas;

import java.util.GregorianCalendar;

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
    public static boolean esBisiesto(int anio) {

        GregorianCalendar calendar = new GregorianCalendar();
        boolean esBisiesto = false;
        if (calendar.isLeapYear(anio)) {
            esBisiesto = true;
        }
        return esBisiesto;

    }

}
