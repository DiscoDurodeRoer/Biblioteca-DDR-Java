/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.palabras;

import java.util.StringTokenizer;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Palabras {
    
    /**
     * Cuenta el número de palabras en una cadena
     * @param cadena Cadena
     * @return Número de palabras
     */
    public static int numeroPalabras(String cadena){
        
        StringTokenizer texto = new StringTokenizer(cadena);
        
        return texto.countTokens();
       
    }
    
    /**
     * Número de caracteres en una cadena
     * @param cadena Cadena donde se buscan los caracteres
     * @param caracter Caracter buscado
     * @return Número de caracteres en la cadena
     */
    public static int numeroCaracteres(String cadena, char caracter){
        
        int contador=0;
        
        for(int i=0;i<cadena.length();i++){
            
            char caracterActual=cadena.charAt(i);
            
            if(caracter==caracterActual){
                contador++;
            }
            
        }
        
        return contador;
        
    }
    
    /**
     * Cambia las comillas, si las hay (muy util para las instruciones SQL)
     * @param texto Cadena
     * @return Si hay comilla simple modifica el texto, si no devuelve el texto original
     */
    public static String remplazarComillas(String texto){
     
        if(texto.indexOf('\'')!=-1){
            return texto.replaceAll("\'", "\'\'");
        }
        
        return texto;
        
    }
    
    
    
}
