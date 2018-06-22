/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.clases.documentos;

import static es.discoduroderoer.clases.documentos.Documento.cuentaCifras;
import javax.swing.JOptionPane;

/**
 *
 * @author DiscoDurodeRoer
 */
public final class NIE extends Documento{
    
    //Atributos
    private char letraInicial;
    
    //Constantes
    protected static char letrasNIE[]={'X', 'Y', 'Z'};
    
    /**
     * Constructor por defecto
     */
    public NIE(){
        this.generarNIE();
    }
    
    /**
     * Le pasamos el NIE 
     * @param NIE NIE
     */
    public NIE(String NIE){
        
        if(validarNIE(NIE)){
            letraInicial=NIE.charAt(0);
            numero=Integer.parseInt(NIE.substring(1,NIE.length()-2));
            letra=NIE.charAt(NIE.length()-1);
            completarDocumento();
        }else{
            letraInicial=' ';
            numero=0;
            letra=' ';
            completarDocumento();
        }
    }
    
    /**
     * Completa el documento NIE
     */
    private void completarDocumento(){
        documentoCompleto=letraInicial+String.valueOf(numero)+letra;
    }
    
    /**
     * Generar un NIE aleatorio
     */
    private void generarNIE(){
        
        numero=generaNumeroAleatorio(1000000,9999999);
        
        int indiceLetraNIE=generaNumeroAleatorio(0,2);
        
        letraInicial=letrasNIE[indiceLetraNIE];
        
        numero=Integer.parseInt(String.valueOf(indiceLetraNIE)+String.valueOf(numero));
        
        letraNIF();
        
        if(indiceLetraNIE==0){
            documentoCompleto=letraInicial+String.valueOf(numero)+letra;
        }else{
            documentoCompleto=letraInicial+String.valueOf(numero).substring(1)+letra;
        }
        
    }
    
    /**
     * Devuelve un la letra NIF del NIE
     */
    private void letraNIF(){
        
        if(cuentaCifras(numero)>=7 && cuentaCifras(numero)<=8){
            
            int res=numero-(numero/DIVISOR*DIVISOR);

            letra=letrasNIF[res];
        
        }else{
            JOptionPane.showMessageDialog(null, "El NIE debe ser de 7 u 8 cifras", "", JOptionPane.ERROR_MESSAGE);
        }	
     }
    
    /**
     * Valida un documento NIE
     * @param NIE NIE
     * @return True = es válido
     */
    private boolean validarNIE(String NIE){
        
        if(NIE.length()==9){
    
            try{
    
                if(NIE.charAt(0)=='X' || NIE.charAt(0)=='Y' || NIE.charAt(0)=='Z'){

                    int indiceNIE;
                    switch(NIE.charAt(0)){
                        case 'Y':
                            indiceNIE=1;
                            NIE=NIE.replace('Y', '1');
                            break;
                        case 'Z':
                            indiceNIE=2;
                            NIE=NIE.replace('Z', '2');
                            break;
                        default:
                            indiceNIE=0;
                            NIE=NIE.replace('X', '0');
                    }
                    
                    int nie=Integer.parseInt(indiceNIE+NIE.substring(1, NIE.length()-1));
                    int res=nie-(nie/DIVISOR*DIVISOR);

                    String NIECalculado=String.valueOf(nie)+letrasNIF[res];
                    
                    return NIECalculado.replace('0', ' ').trim().equals(NIE.replace('0', ' ').trim());

                }else{
                    return false;
                }
                
        }catch(NumberFormatException e){
            return false;
        }
       }else{
           return false;
       }
        
    }
    
    /**
     * Devuelve la letra NIF de un documento NIE
     * @param NIE NIE
     * @return Letra NIF del NIE
     */
    private static char letraNIF(String NIE){
        
        int numeroNIE=Integer.parseInt(NIE);
        
        if(cuentaCifras(numeroNIE)>=7 && cuentaCifras(numeroNIE)<=8){
            
            int res=numeroNIE-(numeroNIE/DIVISOR*DIVISOR);

            return letrasNIF[res];
        
        }else{
            return ' ';
        }	
     }
    
    /**
     * Genera un NIE aleatorio
     * @return Documento NIE
     */
    public static String generarNIEAleatorio(){
        
        int numero=generaNumeroAleatorio(1000000,9999999);
        
        int indiceLetraNIE=generaNumeroAleatorio(0,2);
        
        char letraInicial=letrasNIE[indiceLetraNIE];
        
        char letra=letraNIF(String.valueOf(indiceLetraNIE)+String.valueOf(numero));
        
        return letraInicial+String.valueOf(numero)+letra;
        
    }
    
    /**
     * Genera una serie de documentos NIEs
     * @param numeroNIEs Número de NIEs para generar
     * @return Array de documentos NIEs
     */
    public static String[] generaNIEsAletorios(int numeroNIEs){
        
        String NIEs[]=new String[numeroNIEs];
        
        String nie;
        
        for(int i=0;i<NIEs.length;i++){
        
            do{
                
                nie=generarNIEAleatorio();
                
            }while(existeDocumento(NIEs,nie));
            
            NIEs[i]=nie;
            
        }
        
        return NIEs;
        
    }
    
}
