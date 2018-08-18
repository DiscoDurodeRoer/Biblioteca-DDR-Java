/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.clases.documentos;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Documento {
    
    //Atributos
    protected int numero;
    protected char letra;
    protected String documentoCompleto;
    
    
    //Constantes
    protected static char letrasNIF[]={'T', 'R', 'W', 'A', 'G', 'M', 'Y', 
                                'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 
                                'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    
    protected static int DIVISOR=23;
    
    
    /**
     * Devuelve el estado del atributo número
     * @return Estado numero
     */
    protected int getNumero() {
        return numero;
    }

    /**
     * Devuelve el estado del atributo letra
     * @return Estado letra
     */
    protected char getLetra() {
        return letra;
    }

    /**
     * Devuelve el estado del atributo documentoCompleto
     * @return Estado documentoCompleto
     */
    protected String getDocumentoCompleto() {
        return documentoCompleto;
    }
    
     /**
     * Genera un numero aleatorio entre dos numeros. NOTA: se incluye el minimo, pero no el maximo
     * @param minimo Número máximo
     * @param maximo Número minimo
     * @return numero entre minimo y maximo
     */
    protected static int generaNumeroAleatorio(int minimo, int maximo){
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
    
    /**
     * Devuelve el número de cifras de un número
     * @param num Número para contar
     * @return Número de cifras
     */
    protected static int cuentaCifras(int num){
        int contador=0;
        if(num==0){
            return 1;
        }else if(num>0){
             //bucle que cuenta las cifras
            while (num>0){
                num=(int)Math.floor(num/10);
                contador+=1;
            }
            return contador;
        }else{
            while (num<0){
                num=(int)Math.floor(num/10);
                contador+=1;
            }
            return contador;
        }
    }
    
    /**
     * Indica si el documento existe en el array pasado
     * @param documentos Conjunto de documentos
     * @param valor Documento buscado
     * @return True = existe el documento
     */
    protected static boolean existeDocumento(String[] documentos,String valor){
        
        boolean encontrado=false;
        
        for(int i=0;i<documentos.length && !encontrado;i++){
            
            if(documentos[i]!=null){
                if(documentos[i].equals(valor)){
                    encontrado=true;
                }
            }
            
        }
        
        return encontrado;
        
    }
    
    /**
     * Rellena con ceros un documento para que sea válido
     * @param numeroMaximo Número maximo de cifras 
     * @param numeroActual Numero pasado
     * @return String con los ceros rellenados
     */
    protected static String rellenarConCeros(int numeroMaximo, int numeroActual){
        
        int numCeros=numeroMaximo-cuentaCifras(numeroActual);
        
        String ceros="";
        
        for(int i=0;i<numCeros;i++){
            ceros+="0";
        }
        
        return ceros+String.valueOf(numeroActual);
                
    }
    
}
