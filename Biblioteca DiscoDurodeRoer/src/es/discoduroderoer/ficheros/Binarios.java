/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import es.discoduroderoer.arrays.Array;

/**
 * @author DiscoDurodeRoer
 */
public class Binarios {
 
    /**
     * Escribe en un fichero con DataOutputStream
     * @param rutaFichero Ruta donde esta el fichero
     * @param datos Datos que se quieren insertar
     */
    public static void escribirConDOS(String rutaFichero,Object[] datos){
        
        String tipos[]=Array.tiposDatos(datos);
        
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(rutaFichero, true))){
            
            for(int i=0;i<tipos.length;i++){
                
                switch(tipos[i]){
                    case "Byte":
                        dos.writeByte((Byte)datos[i]);
                        break;
                    case "Short":
                        dos.writeShort((Short)datos[i]);
                        break;
                    case "Integer":
                        dos.writeInt((int)datos[i]);
                        break;
                    case "Long":
                        dos.writeLong((Long)datos[i]);
                        break;
                    case "Character":
                        dos.writeChar((char)datos[i]);
                        break;
                    case "String":
                        dos.writeUTF((String)datos[i]);
                        break;
                    case "Double":
                        dos.writeDouble((Double)datos[i]);
                        break;
                    case "Float":
                        dos.writeFloat((Float)datos[i]);
                        break;
                    case "Boolean":
                        dos.writeBoolean((Boolean)datos[i]);
                        break;   
                }
                
            }
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        
    }
    
    /**
     * Escribe en un fichero con DataOutputStream
     * @param fichero Fichero donde se quiere escribir
     * @param datos Datos que se quieren insertar
     */
    public static void escribirConDOS(File fichero,Object[] datos){
        
        String tipos[]=Array.tiposDatos(datos);
        
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(fichero,true))){
            
            for(int i=0;i<tipos.length;i++){
                
                switch(tipos[i]){
                    case "Byte":
                        dos.writeByte((Byte)datos[i]);
                        break;
                    case "Short":
                        dos.writeShort((Short)datos[i]);
                        break;
                    case "Integer":
                        dos.writeInt((int)datos[i]);
                        break;
                    case "Long":
                        dos.writeLong((Long)datos[i]);
                        break;
                    case "Character":
                        dos.writeChar((char)datos[i]);
                        break;
                    case "String":
                        dos.writeUTF((String)datos[i]);
                        break;
                    case "Double":
                        dos.writeDouble((Double)datos[i]);
                        break;
                    case "Float":
                        dos.writeFloat((Float)datos[i]);
                        break;
                    case "Boolean":
                        dos.writeBoolean((Boolean)datos[i]);
                        break;   
                }
                
            }
        }catch(IOException e){
            
        }
        
    }
    
    /**
     * Lee un fichero con DataInputStream
     * @param rutaFichero Ruta donde esta el fichero
     * @param datos Datos que se usan para saber el tipo de datos almacenados(poner una simple muestra, por ejemplo, si es un int poner un 0, si es un String "", etc)
     * @return Cadena con el contenido del fichero
     */
    public static String leerConDIS(String rutaFichero,Object[] datos){
        
        String tipos[]=Array.tiposDatos(datos);
        
        String contenido="";
        
        try(DataInputStream dis=new DataInputStream(new FileInputStream(rutaFichero))){
            
            for(int i=0;true;i++){
                
                if(tipos.length==i){
                    i=0;
                }
                
                switch(tipos[i]){
                    case "Byte":
                        contenido+=dis.readByte()+"\n";
                        break;
                    case "Short":
                        contenido+=dis.readShort()+"\n";
                        break;
                    case "Integer":
                        contenido+=dis.readInt()+"\n";
                        break;
                    case "Long":
                        contenido+=dis.readLong()+"\n";
                        break;
                    case "Character":
                        contenido+=dis.readChar()+"\n";
                        break;
                    case "String":
                        contenido+=dis.readUTF()+"\n";
                        break;
                    case "Double":
                        contenido+=dis.readDouble()+"\n";
                        break;
                    case "Float":
                        contenido+=dis.readFloat()+"\n";
                        break;
                    case "Boolean":
                        contenido+=dis.readBoolean()+"\n";
                        break;   
                }
                
                
            }
        }catch(EOFException e){
            System.out.print(e.getMessage());
        }catch(IOException e){
            System.out.print(e.getMessage());
        }
        
        return contenido;
    }
    
    /**
     * Lee un fichero con DataInputStream
     * @param fichero Ruta donde esta el fichero
     * @param datos Datos que se usan para saber el tipo de datos almacenados(poner una simple muestra, por ejemplo, si es un int poner un 0, si es un String "", etc)
     * @return Cadena con el contenido del fichero
     */
    public static String leerConDIS(File fichero,Object[] datos){
        
        String tipos[]=Array.tiposDatos(datos);
        
        String contenido="";
        
        try(DataInputStream dis=new DataInputStream(new FileInputStream(fichero))){
            
            for(int i=0;true;i++){
                
                switch(tipos[i]){
                    case "Byte":
                        contenido+=dis.readByte()+"\n";
                        break;
                    case "Short":
                        contenido+=dis.readShort()+"\n";
                        break;
                    case "Integer":
                        contenido+=dis.readInt()+"\n";
                        break;
                    case "Long":
                        contenido+=dis.readLong()+"\n";
                        break;
                    case "Character":
                        contenido+=dis.readChar()+"\n";
                        break;
                    case "String":
                        contenido+=dis.readUTF()+"\n";
                        break;
                    case "Double":
                        contenido+=dis.readDouble()+"\n";
                        break;
                    case "Float":
                        contenido+=dis.readFloat()+"\n";
                        break;
                    case "Boolean":
                        contenido+=dis.readBoolean()+"\n";
                        break;   
                }
                
            }
        }catch(EOFException e){
            
        }catch(IOException e){
            
        }
        
        return contenido;
    }
    
    /**
     * Copia un fichero
     * @param rutaOrigen Ruta del fichero origen
     * @param rutaDestino Ruta del fichero destino
     */
    public static void copiarFicherosBinarios(String rutaOrigen, String rutaDestino){
        
         try(FileInputStream fin = new FileInputStream(rutaOrigen);
                  FileOutputStream fout = new FileOutputStream(rutaDestino)){
                
		byte[] b = new byte[4096];
		int noOfBytes = 0;

                while( (noOfBytes = fin.read(b)) != -1 ){
			fout.write(b, 0, noOfBytes);
                }
         }catch(IOException e){
             
         }
        
    }
    
    /**
     * Copia un fichero
     * @param rutaOrigen Fichero origen
     * @param rutaDestino Fichero destino
     */
    public static void copiarFicherosBinarios(File rutaOrigen, File rutaDestino){
        
          try(FileInputStream fin = new FileInputStream(rutaOrigen);
                  FileOutputStream fout = new FileOutputStream(rutaDestino)){
                
		byte[] b = new byte[4096];
		int noOfBytes = 0;

                while( (noOfBytes = fin.read(b)) != -1 ){
			fout.write(b, 0, noOfBytes);
                }
         }catch(IOException e){
             
         }
        
    }
    
    
}
