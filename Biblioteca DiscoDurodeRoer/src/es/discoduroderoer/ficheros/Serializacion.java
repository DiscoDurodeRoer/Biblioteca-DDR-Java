/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author DiscoDurodeRoer
 */
public class Serializacion {
    
    /**
     * Escribe en un fichero serializado un objeto
     * @param fichero Fichero serializado
     * @param objeto Objeto que queremos insertar
     */
    public static void  escribirFicheroSerializado(File fichero, Object objeto){
        
        try{  
            ObjectOutputStream oos;
            MiObjectOutputStream moos;
           
            if(fichero.exists()){
                moos=new MiObjectOutputStream(new FileOutputStream(fichero, fichero.exists()));
                moos.writeObject(objeto);
                moos.close();
            }else{
                oos=new ObjectOutputStream(new FileOutputStream(fichero, fichero.exists())); 
                oos.writeObject(objeto);
                oos.close();
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Escribe en un fichero serializado un objeto
     * @param rutaFichero Ruta del fichero
     * @param objeto Objeto que queremos insertar
     */
    public static void  escribirFicheroSerializado(String rutaFichero, Object objeto){
        
        File fichero=new File(rutaFichero);
        
        try{  
            ObjectOutputStream oos;
            MiObjectOutputStream moos;
           
            if(fichero.exists()){
                moos=new MiObjectOutputStream(new FileOutputStream(fichero, fichero.exists()));
                moos.writeObject(objeto);
                moos.close();
            }else{
                oos=new ObjectOutputStream(new FileOutputStream(fichero, fichero.exists())); 
                oos.writeObject(objeto);
                oos.close();
            }

        }catch(IOException e){
            
        }
    }
    
    //Debes crear un metodo toString para personalizar los datos
    public static String leerFicheroBinarioSerializado(File fichero){
        
        String texto="";
        if(fichero.exists()){
            try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
               
            while(true){
                Object objeto= ois.readObject();
                
                texto+=objeto.toString();
            }
           
            }catch(ClassNotFoundException e){
                
            }catch(EOFException e){
                  
            }catch(IOException e){
                  
            }
        }
        return texto;
    }
    
    /**
     * Devuelve el contenido del fichero serializado
     * Debes crear un metodo toString para personalizar los datos
     * @param rutaFichero Ruta del fichero serializado
     * @return Cadena con el estado de los objetos del fichero
     */
    public static String leerFicheroBinarioSerializado(String rutaFichero){
        
        File fichero=new File(rutaFichero);
        
        String texto="";
        if(fichero.exists()){
            try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
               
            while(true){
                Object objeto= ois.readObject();
                
                texto+=objeto.toString();
            }
           
            }catch(ClassNotFoundException e){
                
            }catch(EOFException e){
                  
            }catch(IOException e){
                  
            }
        }
        return texto;
    }
    
    /**
     * Comprueba si un objeto existe en el fichero serializado
     * Se necesita el metodo equals sobrescito
     * @param fichero Fichero serializado
     * @param objeto Objeto a comprobar
     * @return True = existe
     */
    public static boolean comprobarObjetoExistente(File fichero, Object objeto){
        
        boolean existe=false;
        
        if(fichero.exists()){
            try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(fichero))){
               
            while(true){
                Object objetoActual= ois.readObject();
                
                if(objeto.equals(objetoActual)){
                    existe=true;
                }
            }
           
            }catch(ClassNotFoundException e){
                System.out.println("Clase no encontrada");
            }catch(EOFException e){
                  
            }catch(IOException e){
                  System.out.println(e.getMessage());
            }
        }
        
        return existe;
        
    }
}
