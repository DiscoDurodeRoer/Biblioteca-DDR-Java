/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.ficheros;

import static es.discoduroderoer.ficheros.Rutas.ficherosRecursivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author DiscoDurodeRoer
 */
public class Texto {
    
    /**
     * Devuelve un String con el contenido del fichero
     * @param rutaFichero Ruta del fichero de texto
     * @return Contenido del fichero
     */
    public static String leeFicheroCaracteres(String rutaFichero){
        
        String contenido="";
        try(FileReader fr=new FileReader(rutaFichero)){
            
            int c;
            while((c=fr.read())!= -1){
                contenido+=(char)c;
            }
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return contenido;
    }
    
    /**
     * Devuelve un String con el contenido del fichero
     * @param fichero Fichero de texto
     * @return Contenido del fichero
     */
    public static String leeFicheroCaracteres(File fichero){
        
        String contenido="";
        try(FileReader fr=new FileReader(fichero)){
            
            int c;
            while((c=fr.read())!= -1){
                contenido+=(char)c;
            }
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return contenido;
    }
    
    /**
     * Devuelve un String con el contenido del Fichero usando Bufferes
     * @param rutaFichero Ruta del fichero
     * @return Contenido del fichero
     */
    public static String leeFicheroCaracteresBuf(String rutaFichero){
        
        String contenido="";
        try(BufferedReader br=new BufferedReader(new FileReader(rutaFichero))){
            
            String c;
            while((c=br.readLine())!= null){
                contenido+=c+"\n";
            }
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return contenido;
    }
    
    /**
     * Devuelve un String con el contenido del Fichero usando Bufferes
     * @param fichero Fichero de texto
     * @return Contenido del fichero
     */
    public static String leeFicheroCaracteresBuf(File fichero){
        
        String contenido="";
        try(BufferedReader br=new BufferedReader(new FileReader(fichero))){
            
            String c;
            while((c=br.readLine())!= null){
                contenido+=c+"\n";
            }
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return contenido;
    }
    
    /**
     * Escribe el String pasado a un fichero
     * @param rutaFichero Ruta del fichero
     * @param contenido Cadena que le queremos escribir
     * @param anadir True = Añade desde el final , false = sobrescribe todo el fichero (como si empezará de nuevo)
     */
    public static void escribirFicheroCaracteres(String rutaFichero, String contenido, boolean anadir){
        
        try(FileWriter fw=new FileWriter(rutaFichero, anadir)){
            
            fw.write(contenido);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Escribe el String pasado a un fichero
     * @param fichero Fichero de texto
     * @param contenido Cadena que le queremos escribir
     * @param anadir True = Añade desde el final , false = sobrescribe todo el fichero (como si empezará de nuevo)
     */
    public static void escribirFicheroCaracteres(File fichero, String contenido, boolean anadir){
        
        try(FileWriter fw=new FileWriter(fichero, anadir)){
            
            fw.write(contenido);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Escribe el String pasado a un fichero con buferes
     * @param rutaFichero Ruta del fichero
     * @param contenido Cadena que le queremos escribir
     * @param anadir True = Añade desde el final , false = sobrescribe todo el fichero (como si empezará de nuevo)
     */
    public static void escribirFicheroCaracteresBuf(String rutaFichero, String contenido, boolean anadir){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(rutaFichero, anadir))){
            
            bw.write(contenido);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Escribe el String pasado a un fichero con buferes
     * @param fichero Ruta del fichero
     * @param contenido Cadena que le queremos escribir
     * @param anadir True = Añade desde el final , false = sobrescribe todo el fichero (como si empezará de nuevo)
     */
    public static void escribirFicheroCaracteresBuf(File fichero, String contenido, boolean anadir){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fichero, anadir))){
            
            bw.write(contenido);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Escribe el String pasado a un fichero, respetando los espacios
     * @param rutaFichero Ruta del fichero
     * @param contenido Cadena que le queremos escribir
     * @param anadir True = Añade desde el final , false = sobrescribe todo el fichero (como si empezará de nuevo)
     */
    public static void escribirFicheroCaracteresEspacios(String rutaFichero, String contenido, boolean anadir){
        
        try(PrintWriter pw=new PrintWriter(new FileWriter(rutaFichero, anadir))){
            
            pw.write(contenido);
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     * Muestra por consola el contenido de un fichero respetando lo espacios 
     * @param fichero Ruta del fichero
     * @param contenido Cadena que le queremos escribir
     * @param anadir True = Añade desde el final , false = sobrescribe todo el fichero (como si empezará de nuevo)
     */
    public static void escribirFicheroCaracteresEspacios(File fichero, String contenido, boolean anadir){
        
        try(PrintWriter pw=new PrintWriter(new FileWriter(fichero, anadir))){
            
            for(int i=0;i<contenido.length();i++){
                
                char caracter=contenido.charAt(i);
                
                if(String.valueOf(caracter).equals("\n")){
                    pw.println();
                }else{
                    pw.print(caracter);
                }
            }
            
        }catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    /**
     * Escribo el contenido de una matriz de String en un fichero(respeto espacios para que se vea mejor)
     * @param fichero Fichero 
     * @param matriz Matriz con los datos a mostrar
     */
    public static void escribirFicherosCaracteresMatrices(File fichero, String matriz[][]){
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                escribirFicheroCaracteresBuf(fichero, matriz[i][j]+" ", true);
            }
        }
        
    }
    
    /**
     * Copia dos ficheros de textos
     * @param rutaFicheroOrigen Ruta de fichero origen
     * @param rutaFicheroDestino Ruta de fichero destino 
     */
    public static void copiarFicherosCaracteres(String rutaFicheroOrigen, String rutaFicheroDestino){
        
        String contenido=leeFicheroCaracteresBuf(rutaFicheroOrigen);
        escribirFicheroCaracteresBuf(rutaFicheroDestino, contenido, false);
       
    }
    
    /**
     * Copia dos ficheros de textos 
     * @param ficheroOrigen Fichero origen
     * @param ficheroDestino Fichero destino
     */
    public static void copiarFicherosCaracteres(File ficheroOrigen, File ficheroDestino){
        
        String contenido=leeFicheroCaracteresBuf(ficheroOrigen);
        escribirFicheroCaracteresBuf(ficheroDestino, contenido, false);
       
    }
    
    /**
     * Devuelve el numero de filas que hay en un fichero de texto
     * @param rutaFichero Ruta fichero
     * @return Número de líneas
     */
    public static int numeroLineasFicheroCaracteres(String rutaFichero){
        
        int contador=0;
        try(BufferedReader br=new BufferedReader(new FileReader(rutaFichero))){
            
            while(br.readLine()!=null){
                contador++;    
            }
            
        }catch(EOFException e ){
            System.out.println(e.getMessage());
        }catch(IOException e ){
            System.out.println(e.getMessage());
        }
        return contador;
    }
    
    /**
     * Devuelve todos los caracteres de un fichero en un array de char
     * @param rutaFichero Ruta del fichero
     * @return Array de char
     */
    public static char[] deFicheroTextoACaracteres(String rutaFichero){
        
        String contenido=leeFicheroCaracteresBuf(rutaFichero);
        
        char caracteres[]=contenido.toCharArray();
        
        return caracteres;
    }
    
    /**
     * Devuelve todos los caracteres de un fichero en un array de char
     * @param fichero Fichero
     * @return Array de char
     */
    public static char[] deFicheroTextoACaracteres(File fichero){
        
        String contenido=leeFicheroCaracteresBuf(fichero);
        
        char caracteres[]=contenido.toCharArray();
        
        return caracteres;
        
    }
    
    /**
     * Inserta un array de String en un fichero
     * @param rutaFichero Ruta del fichero
     * @param array Array de String donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(String rutaFichero, String[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(rutaFichero))){
            
            for(int i=0;i<array.length;i++){
                if (separador.equals("\n")){
                    bw.write(array[i]);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
                
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Inserta un array de String en un fichero
     * @param fichero Fichero de texto
     * @param array Array de String donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(File fichero, String[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fichero))){
            
            for(int i=0;i<array.length;i++){
                if (separador.equals("\n")){
                    bw.write(array[i]);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        
    }
    
    /**
     * Inserta un array de int en un fichero
     * @param rutaFichero Ruta del fichero
     * @param array Array de int donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(String rutaFichero, int[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(rutaFichero))){
            
            for(int i=0;i<array.length;i++){
                if (separador.equals("\n")){
                    bw.write(array[i]);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    /**
     * Inserta un array de int en un fichero
     * @param fichero Ruta del fichero
     * @param array Array de int donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(File fichero, int[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fichero))){
            
            for(int i=0;i<array.length;i++){
                if (separador.equals("\n")){
                    bw.write(array[i]);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inserta un array de double en un fichero
     * @param rutaFichero Ruta fichero de texto
     * @param array Array de double donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(String rutaFichero, double[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(rutaFichero))){
            
            for(int i=0;i<array.length;i++){
                bw.write(array[i]+separador);
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inserta un array de double en un fichero
     * @param fichero Ruta del fichero
     * @param array Array de double donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(File fichero, double[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fichero))){
            
            for(int i=0;i<array.length;i++){
                if (separador.equals("\n")){
                    bw.write(array[i]+separador);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inserta un array de char en un fichero
     * @param rutaFichero Ruta del fichero
     * @param array Array de char donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(String rutaFichero, char[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(rutaFichero))){
            
            for(int i=0;i<array.length;i++){
                if (separador.equals("\n")){
                    bw.write(array[i]);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Inserta un array de char en un fichero
     * @param fichero Fichero
     * @param array Array de char donde estan los ficheros
     * @param separador Separador entre dato y dato
     */
    public static void deArrayAFicheroCaracteres(File fichero, char[] array, String separador){
        
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(fichero))){
            
            for(int i=0;i<array.length;i++){
               if (separador.equals("\n")){
                    bw.write(array[i]);
                    bw.newLine();
                }else{
                    bw.write(array[i]+separador);
                }
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
   
    /**
     * 
     * @param fichero Fichero
     * @return Array de String de palabras
     */
    public static String[] deFicheroAPalabras(File fichero){
        
        String contenido=leeFicheroCaracteresBuf(fichero);
        
        StringTokenizer srText = new StringTokenizer(contenido);
        
        String palabras[]=new String[srText.countTokens()];
        
        for(int i=0;srText.hasMoreElements();i++){
            palabras[i]=srText.nextElement().toString();
        }
        
        return palabras;
        
    }
    
    /**
     * Devuelve las palabras de un fichero
     * @param rutaFichero Ruta del fichero
     * @return Array de String
     */
    public static String[] deFicheroAPalabras(String rutaFichero){
        
        String contenido=leeFicheroCaracteresBuf(rutaFichero);
        
        StringTokenizer srText = new StringTokenizer(contenido);
        
        String palabras[]=new String[srText.countTokens()];
        
        for(int i=0;srText.hasMoreElements();i++){
            palabras[i]=srText.nextElement().toString();
        }
        
        return palabras;
        
    }
    
    /**
     * Copia el contenido de un textarea a un fichero
     * @param textArea TextArea donde esta el texto
     * @param rutaFichero Ruta del fichero
     */
    public static void deTextAreaAFichero(JTextArea textArea, String rutaFichero){
        
        escribirFicheroCaracteresEspacios(rutaFichero, textArea.getText(), false);
        
    }
    
    /**
     * Copia el contenido de un textarea a un fichero
     * @param textArea TextArea donde esta el texto
     * @param fichero Ruta del fichero
     */
    public static void deTextAreaAFichero(JTextArea textArea, File fichero){
        
        escribirFicheroCaracteresEspacios(fichero, textArea.getText(), false);
        
    }
    
    /**
     * Copia el contenido de un textarea a un fichero
     * @param textArea TextArea donde se quiere escribir
     * @param rutaFichero Ruta del fichero donde esta el texto
     */
    public static void deFicheroATextArea(JTextArea textArea, String rutaFichero){
        
        String contenido=leeFicheroCaracteresBuf(rutaFichero);
        
        textArea.setText(contenido);
        
    }
    
    /**
     * Copia el contenido de un textarea a un fichero
     * @param textArea TextArea donde se quiere escribir
     * @param fichero Ruta del fichero donde esta el texto
     */
    public static void deFicheroATextArea(JTextArea textArea, File fichero){
        
        String contenido=leeFicheroCaracteresBuf(fichero);
        
        textArea.setText(contenido);
        
    }
    
    /**
     * Escribe en un fichero de texto los ficheros recursivos de un directorio dado
     * @param fichero Ruta del fichero origen
     * @param separador Separador entre dato y dato 
     * @param destino Ruta del fichero destino
     */
    public static void ficherosRecursivosFicheroTexto(File fichero, String separador, File destino){
        
        String contenido=ficherosRecursivos(fichero,separador);
        
        escribirFicheroCaracteres(destino, contenido, false);
        
    }

    /**
     * Mezcla dos ficheros de caracteres
     * @param rutaFichero1 Ruta fichero 1
     * @param rutaFichero2 Ruta fichero 2
     * @param rutaFicheroFinal Ruta fichero final 
     */
    public static void mezclarFicherosCaracteres(String rutaFichero1, String rutaFichero2, String rutaFicheroFinal){
        
        String contenido=leeFicheroCaracteresBuf(rutaFichero1)+leeFicheroCaracteresBuf(rutaFichero2);
        escribirFicheroCaracteresBuf(rutaFicheroFinal, contenido, false);
        
    }
    
}
