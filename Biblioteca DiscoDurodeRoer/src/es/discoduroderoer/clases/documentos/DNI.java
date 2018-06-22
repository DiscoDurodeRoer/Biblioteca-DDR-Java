/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.clases.documentos;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class DNI extends Documento{
    
    /**
     * Constructor por defecto
     */
    public DNI(){
        this.generarDNIAleatorio();
    }
    
    /**
     * Le pasamos el valor del DNI
     * @param numeroDNI Número DNI
     */
    public DNI(int numeroDNI){
        
        if(cuentaCifras(numeroDNI)>=7 && cuentaCifras(numeroDNI)<=8){
            this.numero=numeroDNI;
            letraNIF();
            completarDNI();
        }else{
            numero=0;
            letra=' ';
            documentoCompleto="";   
        }    
    }
    
    /**
     * Le pasamos un DNI cualquiera, si no es válido el DNI será una cadena vacía
     * @param DNIcompleto DNI
     */
    public DNI(String DNIcompleto){
        
        if(validarDNI(DNIcompleto)){
            
            numero=Integer.parseInt(DNIcompleto.substring(0, DNIcompleto.length()-1));
            letra=DNIcompleto.charAt(DNIcompleto.length()-1);
            completarDNI();
            
        }else{
            
            numero=0;
            letra=' ';
            documentoCompleto="";
        }
        
    }
    
    /**
     * Genera un número DNI válido
     */
    private void generarDNIAleatorio(){
        
        numero=generaNumeroAleatorio(1,99999999);
        
        letraNIF();
        
        completarDNI();
        
    }
    
    
    /**
     * Completa el DNI
     */
    private void completarDNI(){
        
        if(cuentaCifras(numero)<=7){
            documentoCompleto=rellenarConCeros(8, numero)+letra;
        }else{
            documentoCompleto=String.valueOf(numero)+letra;
        }
        
    }
    
    /**
     * Devuelve la letra NIF a partir de un número de DNI
     */
    private void letraNIF(){
        
        if(cuentaCifras(numero)<=8){
            
            int res=numero-(numero/DIVISOR*DIVISOR);

            letra=letrasNIF[res];
       
        }else{
            JOptionPane.showMessageDialog(null, "El DNI debe ser de 8 cifras minimo", "", JOptionPane.ERROR_MESSAGE);
        }	
    }
    
    /**
     * Valida si un DNI es correcto o no
     * @param DNI DNI
     * @return True = DNI es válido
     */
    private boolean validarDNI(String DNI){
        
        if(DNI.length()>=8 && DNI.length()<=9){
           try{
                
                int dni=Integer.parseInt(DNI.substring(0, DNI.length()-1));
                int res=dni-(dni/DIVISOR*DIVISOR);
          
                String DNICalculado=String.valueOf(dni)+letrasNIF[res];
               
                return DNICalculado.replace('0', ' ').trim().equals(DNI.replace('0', ' ').trim());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La cadena pasada es incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
       }else{
           JOptionPane.showMessageDialog(null, "El DNI debe ser de 8 u 9 cifras", "", JOptionPane.ERROR_MESSAGE);
           return false;
       }
        
    }
    
    /**
     * Devuelve la letra NIF de un número DNI
     * @param DNI DNI
     * @return Letra del NIF
     */
    private static char letraNIF(int DNI){
        
        if(cuentaCifras(DNI)<=8){
            final int divisor=23;

            int res=DNI-(DNI/divisor*divisor);

            return letrasNIF[res];
        }else{
            JOptionPane.showMessageDialog(null, "El DNI debe ser de 8 cifras minimo", "", JOptionPane.ERROR_MESSAGE);
            return 0;
        }	
    }
    
    /**
     * Genera un DNI aleatorio
     * @return DNI completo
     */
    private static String generaDNIAleatorio(){
        
        int numero=generaNumeroAleatorio(1,99999999);
        
        char letra=letraNIF(numero);
        
        if(cuentaCifras(numero)<=7){
            return rellenarConCeros(8, numero)+letra;
        }else{
            return String.valueOf(numero)+letra;
        }
        
    }
    
    /**
     * Genera una serie de DNI aleatorios
     * @param numeroDNIs Número de DNI generados
     * @return Arrays con DNI Aleatorios
     */
    public static String[] generaDNIsAletorios(int numeroDNIs){
        
        String DNIs[]=new String[numeroDNIs];
        
        String dni;
        
        for(int i=0;i<DNIs.length;i++){
        
            do{
                
                dni=generaDNIAleatorio();
                
            }while(existeDocumento(DNIs,dni));
            
            DNIs[i]=dni;
            
        }
        
        return DNIs;
        
    }
    
}
