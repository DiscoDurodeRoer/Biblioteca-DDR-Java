package es.discoduroderoer.fechas;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Conversion {
    
     /**
     * Convierte una fecha a formato científico
     * Por ejemplo: 05/02/1990 = 19900205
     * @param fecha Fecha a convertir LocalDate
     * @return Fecha en formato científico
     */
    public static int deFechaANumero(LocalDate fecha){
        
        String f = String.valueOf(fecha.getYear());
        
        String formato="MM";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(formato);        
        
        if (Integer.parseInt(dateFormat.format(fecha)) < 10) {
            f+="0"+Integer.parseInt(dateFormat.format(fecha));
        }else{
            f+=Integer.parseInt(dateFormat.format(fecha));
        }
        
        formato="dd";        
        dateFormat = DateTimeFormatter.ofPattern(formato); 
        
        if (Integer.parseInt(dateFormat.format(fecha)) <10){
            f+="0"+Integer.parseInt(dateFormat.format(fecha));
        }else{
            f+=Integer.parseInt(dateFormat.format(fecha));
        }
        
        return Integer.parseInt(f);
    }
  
    /**
     * Convierte una fecha a formato científico
     * Por ejemplo: 05/02/1990 = 19900205
     * @param fecha Fecha a convertir Date
     * @return Fecha en formato científico
     */
    @Deprecated
    public static int deFechaDateANumero(Date fecha){
        
        String f = String.valueOf(fecha.getYear()+1900);
        
        String formato="MM";
         SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        
        if (Integer.parseInt(dateFormat.format(fecha)) < 10) {
            f+="0"+Integer.parseInt(dateFormat.format(fecha));
        }else{
            f+=Integer.parseInt(dateFormat.format(fecha));
        }
        
        formato="dd";
        dateFormat = new SimpleDateFormat(formato);
        
        if (Integer.parseInt(dateFormat.format(fecha)) <10){
            f+="0"+Integer.parseInt(dateFormat.format(fecha));
        }else{
            f+=Integer.parseInt(dateFormat.format(fecha));
        }
        
        return Integer.parseInt(f);
    }
    
    /**
     * Pasa de número en formato científico a fecha
     * Por ejemplo:  19900205 = 05/02/1990
     * @param numero Número en formato científico
     * @return Fecha LocalDate
     */
    public static LocalDate deNumeroAFecha(int numero){
        
        try{
            
            int anio=(int)Math.floor(numero/10000);
            
            int mes = (int)Math.floor(((numero%10000) / 100));
            
            int dia=numero%100;
            
            LocalDate fecha=LocalDate.of(anio, mes, dia);    //new Date(anio-1900, mes-1, dia);
            
            return fecha;
            
        }catch(DateTimeException e){
            JOptionPane.showMessageDialog(null, "Error, la fecha no es correcta");
            return null;
        }
    }

    /**
     * Pasa de número en formato científico a fecha
     * Por ejemplo:  19900205 = 05/02/1990
     * @param numero Número en formato científico
     * @return Fecha Date
     */
    @Deprecated
    public static Date deNumeroAFechaDate(int numero){
        
        try{
            
            int anio=(int)Math.floor(numero/10000);
            
            int mes = (int)Math.floor(((numero%10000) / 100));
            
            int dia=numero%100;
            
            Date fecha=new Date(anio-1900, mes-1, dia);
            
            return fecha;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, la fecha no es correcta");
            return null;
        }
    }
        
    /**
     * Convierte una hora a número en formato científico
     * Por ejemplo:  20:50:40 = 205040
     * @param hora Hora pasada (LocalTime)
     * @return Hora en formato científico
     */
    public static int deHoraANumero(LocalTime hora){        
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss"); 
        
        String f;
        
        if (hora.getHour()<10){
            f="0"+hora.getHour();
        }else{
            f=String.valueOf(hora.getHour());
        }
        
        if(hora.getMinute()< 10){
            f+="0"+hora.getMinute();
        }else{
            f+=hora.getMinute();
        }
        
        if(hora.getSecond()<10){
            f+="0"+hora.getSecond();
        }else{
            f+=hora.getSecond();
        }
        
        return Integer.parseInt(f);
    }
    
    /**
     * Convierte una hora a número en formato científico
     * Por ejemplo:  20:50:40 = 205040
     * @param hora Hora pasada (Date)
     * @return Hora en formato científico
     */
    @Deprecated
    public static int deHoraANumero(Date hora){
        
        SimpleDateFormat formato=new SimpleDateFormat("HH:mm:ss");
        
        String f=formato.format( hora );
        
        if (hora.getHours() <10){
            f="0"+hora.getHours();
        }else{
            f=String.valueOf(hora.getHours());
        }
        
        if(hora.getMinutes() < 10){
            f+="0"+hora.getMinutes();
        }else{
            f+=hora.getMinutes();
        }
        
        if(hora.getSeconds()<10){
            f+="0"+hora.getSeconds();
        }else{
            f+=hora.getSeconds();
        }
        
        return Integer.parseInt(f);
    }
        
    /**
     * Convierte un número en formato científico a hora
     * Por ejemplo: 205040 = 20:50:40
     * @param numero Número es científico
     * @return Hora LocalTime
     */
    public static LocalTime deNumeroAHora(int numero){
        
        int hora=(int)Math.floor(numero/10000);
        
        int minuto= (int)Math.floor((numero%10000)/100);
        
        int segundo=numero%100;
        
        LocalTime fecha=LocalTime.of(hora, minuto, segundo);
        
        return fecha;        
    }
    
    /**
     * Convierte un número en formato científico a hora
     * Por ejemplo: 205040 = 20:50:40
     * @param numero Número es científico
     * @return Hora Date
     */
    @Deprecated
    public static Date deNumeroAHoraDate(int numero){
        
        int hora=(int)Math.floor(numero/10000);
        
        int minuto= (int)Math.floor((numero%10000)/100);
        
        int segundo=numero%100;
        
        Date fecha=new Date(1,1,1,hora,minuto,segundo);
        
        return fecha;        
    }
    
}
