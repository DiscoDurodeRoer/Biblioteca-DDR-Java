/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.ficheros;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author DiscodurodeRoer
 */
public class RAF {
    
    private int tamanioRegistro; //Hay que calcularlo
    private File fichero;
    private String[][] informacion; //Contiene el tipo de dato(String, int,...) y su tamaño 
    
    /**
     * Constructor
     * @param pTamanioRegistro Tamaño decidido por registro
     * @param pFichero Fichero 
     * @param pInformacion Almacena los tipos de datos que van a almacenar en un registro
     */
    public RAF(int pTamanioRegistro, File pFichero, String [][] pInformacion){
        
        fichero=pFichero;
        tamanioRegistro=pTamanioRegistro;
        informacion=pInformacion;
    }
    
    /**
     * Indica en que posición se debe almacenar un registro
     * @param id ID
     * @return P1osición donde se debe ajustar el puntero
     */
    public long posicionRegistro(int id){
        
        return (id-1)*tamanioRegistro;
        
    }
    
    /**
     * Indica donde esta la posición final
     * @return Posición final
     */
    public long posicionFinal(){
        
        return fichero.length();
        
    }
    
    //
    /**
     * Devuelve la diferencia entre un registro y otro
     * @param id ID
     * @param distanciaDato Es a cuantos bytes esta un dato concreto al que queramos acceder
     * @return Diferencia en bytes
     */
    public long posicionDatoRegistro(int id, int distanciaDato){
        
        return ((id-1)*tamanioRegistro)+distanciaDato;
        
    }
    
    /**
     * Se pasan los datos que se quieran introducir 
     * @param id ID
     * @param datos Datos a pasar 
     */
    public void anadir(int id,String datos[]){
        
        try(RandomAccessFile raf=new RandomAccessFile(fichero, "rw")){
            
            StringBuffer buffer;
            
            raf.seek(posicionRegistro(id));
            
            for(int i=0;i<datos.length;i++){
                
                String tipo=informacion[i][0];
                
                switch(tipo){
                    case "String":
                        buffer=new StringBuffer(datos[i]);
                        buffer.setLength(Integer.parseInt(informacion[i][1]));
                        raf.writeChars(buffer.toString());
                        break;
                    case "Integer":
                        raf.writeInt(Integer.parseInt(datos[i]));
                        break;
                    case "Float":
                        raf.writeFloat(Float.parseFloat(datos[i]));
                        break;
                    case "Short":
                        raf.writeShort(Short.parseShort(datos[i]));
                        break;
                    case "Double":
                        raf.writeDouble(Double.parseDouble(datos[i]));
                        break;
                    case "Boolean":
                        raf.writeBoolean(Boolean.parseBoolean(datos[i]));
                        break;
                    default:
                        System.out.println("error");
                }
            }
            
        }catch(IOException e){
            System.out.printf(e.getMessage());
        }
        
    }
    
    /**
     * Devuelve los datos desde un ID
     * @param id ID
     * @return Datos del registro
     */
    public String[] devolverDatos(int id){
        
        try(RandomAccessFile raf=new RandomAccessFile(fichero, "rw")){
            
            String[] datos=new String[informacion.length];
            
            raf.seek(posicionRegistro(id));
            
            for(int i=0;i<informacion.length;i++){
                
                String tipo=informacion[i][0];
                
                switch(tipo){
                    case "String":
                       
                        String dato="";
                        int limite=Integer.parseInt(informacion[i][1]);
                        for(int j=0;j<limite;j++){
                             dato+=raf.readChar();
                        }
                        
                        datos[i]=dato;
                        
                        break;
                    case "Integer":
                        datos[i]=String.valueOf(raf.readInt());
                        break;
                    case "Float":
                        datos[i]=String.valueOf(raf.readFloat());
                        break;
                    case "Short":
                        datos[i]=String.valueOf(raf.readShort());
                        break;
                    case "Double":
                        datos[i]=String.valueOf(raf.readDouble());
                        break;
                    case "Boolean":
                        datos[i]=String.valueOf(raf.readBoolean());
                        break;
                    default:
                        System.out.println("error");
                }
            }
            
            return datos;
            
        }catch(IOException e){
            return null;
        }
        
        
    }
    
    //
    /**
     * suponiendo que para eliminar un registro
     * Hay que cambiar un valor a true (normalmente es el ultimo)
     * @param id ID
     */
    public void borrar(int id){
        
        try(RandomAccessFile raf=new RandomAccessFile(fichero, "rw")){
            
            long pos=(id-1)*tamanioRegistro;
            raf.seek(pos+(tamanioRegistro-1));
            
            raf.writeBoolean(true);
            
        }catch(IOException e){
            
        }
        
    }
    
    /**
     * Comprobamos si un registro esta borrado
     * @param id ID
     * @return True = esta borrado el registro
     */
    public boolean comprobarBorrado(int id){
        
        try(RandomAccessFile raf=new RandomAccessFile(fichero, "rw")){
            
            long pos=(id-1)*tamanioRegistro;
            raf.seek(pos+(tamanioRegistro-1));
            
            return raf.readBoolean();
           
            
        }catch(IOException e){
            
        }
        return true;
    }
    
    //Solo si el el primer registro es un codigo numerico
    public boolean comprobarIDExistente(int id){
        
        boolean existe=false;
        
        try(RandomAccessFile raf=new RandomAccessFile(fichero, "rw")){
            
            long pos=(id-1)*tamanioRegistro;
            raf.seek(pos);

            int idActual=raf.readInt();
            if(idActual==id){
                existe=true;
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        return existe;
    }
    
}
