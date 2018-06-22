/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.fechas;

import static es.discoduroderoer.fechas.Anios.esBisiesto;
import static es.discoduroderoer.fechas.Meses.mesCorrecto;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Dias {
   
    /**
     * Devuelve el número de dias del mes pasado por parámetro
     * Si es Febrereo tiene en cuenta si este año es bisiesto o no
     * @param mes Mes que queremos saber el número de días
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(String mes){
        
        int numeroDias=-1;
        if(mesCorrecto(mes)){
            
            switch(mes.toLowerCase().trim()){
                case "enero":
                case "marzo":
                case "mayo":
                case "julio":
                case "agosto":
                case "octubre":
                case "diciembre":
                    numeroDias=31;
                    break;
                case "abril":
                case "junio":
                case "septiembre":
                case "noviembre":
                    numeroDias=30;
                    break;
                case "febrero":
                    
                    Date anioActual=new Date();
                    if(esBisiesto(anioActual.getYear())){
                        numeroDias=29;
                    }else{
                        numeroDias=28;
                    }
                    break;               
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "El mes introducido no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return numeroDias;
    }
    
    /**
     * Devuelve el número de dias del mes (número) pasado por parámetro
     * Si es Febrereo tiene en cuenta si este año es bisiesto o no
     * Empieza por 1
     * @param mes Mes que queremos saber el número de días
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(int mes){
        
        int numeroDias=-1;
        
            switch(mes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    numeroDias=31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    numeroDias=30;
                    break;
                case 2:
                    
                    Date anioActual=new Date();
                    if(esBisiesto(anioActual.getYear())){
                        numeroDias=29;
                    }else{
                        numeroDias=28;
                    }
                    break;
                                        
            }
            
        return numeroDias;
    }
    
    /**
     * Devuelve el número de dias del mes pasado por parámetro
     * Si es Febrereo tiene en cuenta el año pasado es bisiesto o no
     * @param mes Mes que queremos saber el número de días
     * @param anio Año, usado para casos de años bisiestos
     * @return Número de días de ese mes
     */
    public static int numeroDeDiasMes(String mes, int anio){
        
        int numeroDias=-1;
        if(mesCorrecto(mes)){
            
            switch(mes.toLowerCase().trim()){
                case "enero":
                case "marzo":
                case "mayo":
                case "julio":
                case "agosto":
                case "octubre":
                case "diciembre":
                    numeroDias=31;
                    break;
                case "abril":
                case "junio":
                case "septiembre":
                case "noviembre":
                    numeroDias=32;
                    break;
                case "febrero":
                  
                    if(esBisiesto(anio)){
                        numeroDias=29;
                    }else{
                        numeroDias=28;
                    }
                    break;
                                        
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "El mes introducido no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return numeroDias;
    }
    
}
