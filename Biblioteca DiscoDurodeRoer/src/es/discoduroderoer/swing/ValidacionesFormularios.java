/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.swing;

import es.discoduroderoer.expresiones_regulares.ExpresionesRegulares;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Fernando
 */
public class ValidacionesFormularios {
    
    
     /**
     * Indica si los campos estan vacios
     * @param campos Array de TextBox
     * @return  true = algun campo vacio
     *          false = no hay vacios
     */
    public static boolean comprobarVacios(JTextField campos[]){
        
        boolean vacio=false;
        
        for(int i=0;i<campos.length && !vacio;i++){
            if(campos[i].getText().isEmpty()){
                vacio=true;
            }
        }
        return vacio;
    }
    
    /**
     * Indica si un campo de texto esta vacio, con un mensaje personalizado
     * @param campo TextBox
     * @param texto Texto que se muestra en caso de erro
     * @return  true = vacio
     *          false= no vacio
     */
    public static boolean comprobarVacio(JTextField campo, String texto){
        boolean vacio=false;
        
        if(campo.getText().isEmpty()){
             vacio=true;
             JOptionPane.showMessageDialog(null, texto);
        }
        return vacio;
    }
    
    /**
     * Si esta vacio, añade el valor nulo pasado por parametro 
     * @param campo TextBox
     * @param valorNulo Valor nulo que escribir
     */
    public static void comprobarVacio(JTextField campo, int valorNulo){
        
        if(campo.getText().isEmpty()){
             campo.setText(String.valueOf(valorNulo));
        }
    }
    
    /**
     * Si esta vacio, añade el valor nulo pasado por parametro 
     * @param campo TextBox
     * @param texto Texto de error
     * @param valorNulo Valor nulo que se escribe si esta vacio el textbox
     */
    public static void comprobarVacio(JTextField campo, String texto, String valorNulo){
        
        if(campo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, texto);
            campo.setText(valorNulo);
        }
    }
    
    /**
     * Si esta vacio, añade el valor nulo pasado por parametro 
     * @param campo TextBox
     * @param valorNulo Valor nulo que se escribe si esta vacio el textbox
     */
    public static void comprobarVacio(JTextField campo, double valorNulo){
        
        if(campo.getText().isEmpty()){
            campo.setText(String.valueOf(valorNulo));
        }
    }
    
    /**
     * Si esta vacio, añade el valor nulo pasado por parametro 
      * @param campo TextBox
     * @param valorNulo Valor nulo que se escribe si esta vacio el textbox
     */
    public static void comprobarVacio(JTextField campo, char valorNulo){
        
        if(campo.getText().isEmpty()){
             campo.setText(String.valueOf(valorNulo));
        }
    }
    
    /**
     * Comprueba si hay varios TextBox que esta vacios
     * En la 1º columna van los TextBox
     * En la 2º columna van los textos personalizados de error
     * @param matriz
     * @return Cadena con todos los errores
     */
    public static String comprobarVacios(Object matriz[][]){
        
        String error="";
        
        for(int i=0;i<matriz[0].length;i++){
            JTextField c=(JTextField)matriz[0][i];
            
            if(c.getText().isEmpty()){
                error+="-"+(String)matriz[1][i]+"\n";
            }
        }
        
        return error;
        
    }
    
    /**
     * Restringe el texto solo a letras.S
     * @param evt Evento
     */
    public static void escribirSoloLetras(KeyEvent evt){
        if(!Character.isLetter(evt.getKeyChar())){
            evt.consume();
        }
    }
    
    /**
     * Restringe el texto solo a letras y espacios
     * @param evt Evento
     */
    public static void escribirSoloLetrasYEspacios(KeyEvent evt){
        if(!Character.isLetter(evt.getKeyChar()) && evt.getKeyChar()!=KeyEvent.VK_SPACE){
            evt.consume();
        }
    }
    
    /**
     * Restringe el texto solo a letras. Escribe el aviso en el JLabel pasado.
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     */
    public static void escribirSoloLetras(KeyEvent evt, JLabel etiquetaError){
        if(!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            etiquetaError.setText("Escribe solo letras");
        }else{
            etiquetaError.setText("");
        }
    }
    
    /**
     * Restringe el texto solo a letras y espacios. Escribe el aviso en el JLabel pasado.
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     */
    public static void escribirSoloLetrasYEspacios(KeyEvent evt, JLabel etiquetaError){
        if(!Character.isLetter(evt.getKeyChar()) && !(evt.getKeyChar()==KeyEvent.VK_SPACE) && !(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            etiquetaError.setText("Escribe solo letras");
        }else{
            etiquetaError.setText("");
        }
    }
    
    
    /**
     * Restringe el texto solo numeros.
     * @param evt Evento
     */
    public static void escribirSoloNumeros(KeyEvent evt){
        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
       }
    }
    
    
    
    /**
     * Restringe el texto solo numeros. Escribe el aviso en el JLabel pasado.
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     */
    public static void escribirSoloNumeros(KeyEvent evt, JLabel etiquetaError){
        if(!Character.isDigit(evt.getKeyChar()) && !(evt.getKeyChar()==KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            etiquetaError.setText("Escribe solo numeros");
       }else{
            etiquetaError.setText("");
       }
    }
    
    /**
     * Restringe el texto solo numeros decimales. Escribe el aviso en el JLabel pasado.
     * @param campo TextBox 
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     */
    public static void escribirSoloDoubles(JTextField campo, KeyEvent evt, JLabel etiquetaError){
        
        if(campo.getText().isEmpty() && (!Character.isDigit(evt.getKeyChar()) || evt.getKeyChar()=='0') ){
            evt.consume();
            etiquetaError.setText("El primer digito no puede ser un punto o un 0");
        }else{
            
            if(!Character.isDigit(evt.getKeyChar()) && (campo.getText().contains(".") || evt.getKeyChar()!='.')){
                evt.consume();
                etiquetaError.setText("Solo numeros y puntos");
            }else{
                etiquetaError.setText("");                
            }
        }

    }
    
    /**
     * Restringe el texto solo numeros decimales, con un limite de decimales. 
     * Escribe el aviso en el JLabel pasado.
     * @param campo TextBox 
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     * @param numeroDecimales Número de decimales permitidos 
     */
    public static void escribirSoloDoubles(JTextField campo, KeyEvent evt, JLabel etiquetaError, int numeroDecimales){
            
            String text=campo.getText();
            char caracter=evt.getKeyChar();
        
            //Controlo que haya un punto, si devuelve -1 no hay punto
            boolean punto;
            
            punto = text.indexOf('.') != -1;

            if(text.isEmpty() && (!Character.isDigit(caracter) || caracter=='0') ){
                evt.consume();
                etiquetaError.setText("El primer digito no puede ser un punto o un 0");
            }else{
                    if(!Character.isDigit(caracter) && (text.contains(".") || caracter!='.')){
                        evt.consume();
                        etiquetaError.setText("Solo numeros y puntos");
                    }else{
                        //Si hay punto, cojo una subcadena y compruebo si supera el limite
                        if(punto){
                            if(text.substring(text.indexOf('.')).length()>numeroDecimales){
                                evt.consume();
                                etiquetaError.setText("No puedes escribir mas decimeales");
                            }
                        }else{
                            etiquetaError.setText("");                
                        }
                    }
            }
    }
    
    /**
     * Restringe el texto solo numeros decimales, con un limite de decimales y enteros. Escribe el aviso en el JLabel pasado.
     * @param campo TextBox 
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     * @param numeroDecimales Número de decimales permitidos 
     * @param numeroEnteros Número de enteros permitidos
     */
    public static void escribirSoloDoubles(JTextField campo, KeyEvent evt, JLabel etiquetaError, int numeroEnteros, int numeroDecimales){
        
            String text=campo.getText();
            char caracter=evt.getKeyChar();
        
            //Controlo que haya un punto, si devuelve -1 no hay punto
            boolean punto;
            
            punto = campo.getText().indexOf('.') != -1;

            if(text.isEmpty() && (!Character.isDigit(caracter) || caracter=='0') ){
                evt.consume();
                etiquetaError.setText("El primer digito no puede ser un punto o un 0");
            }else{
                    if(!Character.isDigit(caracter) && (text.contains(".") || caracter!='.') && caracter!=KeyEvent.VK_BACK_SPACE){
                        evt.consume();
                        etiquetaError.setText("Solo numeros y puntos");
                    }else{
                        //Si supera el limite de enteros lo indica, si se escribe un punto obvia esta condicion
                        if(text.length()>=numeroEnteros && caracter!=46 && !punto){
                            evt.consume();
                            etiquetaError.setText("No puedes escribir mas enteros");
                        }else{
                            //Si hay punto, cojo una subcadena y compruebo si supera el limite
                            if(punto){
                                if(text.substring(text.indexOf('.')).length()>numeroDecimales){
                                    evt.consume();
                                    etiquetaError.setText("No puedes escribir mas decimales");
                                }
                            }else{
                                etiquetaError.setText("");                
                            }
                        }   
                    }   
            }
    }
    
    /**
     * Solo se puede escribir una longitud determinada.
     * @param campo TextBox
     * @param longitudMaxima Número que indica la longitud disponible
     * @param evt Evento
     */
    public static void noEscribirMasDe(JTextField campo, int longitudMaxima,KeyEvent evt){
        if(campo.getText().length()>=longitudMaxima){
                evt.consume();
        }
    }
    
    /**
     * Solo se puede escribir una longitud determinada. 
     * Escribe el aviso en un JLabel
     * @param campo TextBox 
     * @param longitudMaxima Número que indica la longitud disponible
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     * */
    public static void noEscribirMasDe(JTextField campo, int longitudMaxima,KeyEvent evt, JLabel etiquetaError){
        if(campo.getText().length()>=longitudMaxima){
                evt.consume();
                etiquetaError.setText("No mas de "+longitudMaxima+" caracteres");
       }else{
            etiquetaError.setText("");
        }
    }
    
    /**
     * Solo se puede escribir una longitud determinada en un textArea. Escribe el aviso en un JLabel
     * @param campo TextBox 
     * @param longitudMaxima Número que indica la longitud disponible
     * @param evt Evento
     * @param etiquetaError JLabel donde se imprime el error  
     */
    public static void noEscribirMasDe(JTextArea campo, int longitudMaxima,KeyEvent evt, JLabel etiquetaError){
        if(campo.getText().length()>=longitudMaxima){
            evt.consume();
            etiquetaError.setText("No mas de "+longitudMaxima+" caracteres");
       }else{
            etiquetaError.setText("");
        }
    }
    
    /**
     * Permite insertar un email y lo valida. 
     * Hasta que no se inserte un email valido, no deja de preguntar.
     * @return Email valido
     */
    public static String validarEmail(){
        
        boolean interruptor=false;
        String email;
        do{
            email=JOptionPane.showInputDialog(null, "Introduce un email");
            if(ExpresionesRegulares.validar_Mail_Exp(email)){
                interruptor=true;
            }else{
                JOptionPane.showMessageDialog(null, "Error, el email no es valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }while(!interruptor);
        
        return email;
    }
    
}
