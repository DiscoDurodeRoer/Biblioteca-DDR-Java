/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.numeros;

import javax.swing.JOptionPane;

/**
 *
 * @author Fernando
 */
public class ValidacionNumeros {
   
    /**
     * Valida si la cadena introducida es un numero, hasta que no sea correcto no se deja de preguntar
     * @return numero ya validado
     */
    public static int validarNumero(){
        boolean interruptor=true;
        
        int num=0; 

        do{
            try{
                String texto=JOptionPane.showInputDialog("Introduce un número");
                num=Integer.parseInt(texto);
                interruptor = false;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No es un numero, prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(interruptor);
           

        return num;
    }
    
    /**
     * Valida si la cadena introducida es un numero, hasta que no sea correcto no se deja de preguntar
     * @param textoPersonalizado Texto que queremos que muestre en caso de error
     * @return numero ya validado
     */
    public static int validarNumero(String textoPersonalizado){
        boolean interruptor=true;
        
        int num=0; 

        do{
            try{
                String texto=JOptionPane.showInputDialog(textoPersonalizado);
                num=Integer.parseInt(texto);
                interruptor = false;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No es un numero, prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(interruptor);
           

        return num;
    }
    
    /**
     * Valida si el número esta entre el minimo y el maximo incluidos
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre el minimo y el maximo incluido
     */
    public static int validarNumeroEntre(int minimo, int maximo){
        boolean interruptor=true;
        
        int num=0; 

        do{
            try{
                String texto=JOptionPane.showInputDialog("Introduce un número");
                num=Integer.parseInt(texto);
                if(num < minimo || num > maximo){
                    JOptionPane.showMessageDialog(null, "Debes escribir un numero entre "+minimo+" y " +maximo, "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    interruptor = false;
                }
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No es un numero, prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(interruptor && (num < minimo || num > maximo));
           

        return num;
    }
    
    /**
     * Valida si el numero es un numero positivo
     * @return Número mayor o igual que 0
     */
    public static int validarNumeroPositivo(){
        boolean interruptor=true;
        
        int num=-1; 

        do{
            try{
                String texto=JOptionPane.showInputDialog("Introduce un número");
                num=Integer.parseInt(texto);
                if(num < 0){
                    JOptionPane.showMessageDialog(null, "Debes escribir un numero mayor o igual que 0", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    interruptor = false;
                }
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No es un numero, prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(interruptor && (num < 0));
           

        return num;
    }
    
    /**
     * Valida si el numero es un numero positivo
     * @param textoPersonalizado Texto que queremos que muestre en caso de error
     * @return Número mayor o igual que 0
     */
    public static int validarNumeroPositivo(String textoPersonalizado){
        boolean interruptor=true;
        
        int num=-1; 

        do{
            try{
                String texto=JOptionPane.showInputDialog(textoPersonalizado);
                num=Integer.parseInt(texto);
                if(num < 0){
                    JOptionPane.showMessageDialog(null, "Debes escribir un numero mayor o igual que 0", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    interruptor = false;
                }
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No es un numero, prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(interruptor && (num < 0));
           

        return num;
    }
    
    /**
     * Valida si el numero es negativo
     * @return numero negativo
     */
    public static int validarNumeroNegativo(){
        boolean interruptor=true;
        
        int num=0; 

        do{
            try{
                String texto=JOptionPane.showInputDialog("Introduce un número");
                num=Integer.parseInt(texto);
                if(num >= 0){
                    JOptionPane.showMessageDialog(null, "Debes escribir un numero menor que 0", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    interruptor = false;
                }
                
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "No es un numero, prueba de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(interruptor && (num >= 0));
           

        return num;
    }
    
}
