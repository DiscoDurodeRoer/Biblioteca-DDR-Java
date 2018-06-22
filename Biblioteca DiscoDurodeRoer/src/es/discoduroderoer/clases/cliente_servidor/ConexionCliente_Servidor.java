/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.clases.cliente_servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public final class ConexionCliente_Servidor {
    
    private Socket sc;
    private ServerSocket serverAddr;
    
    /**
     * Constructor, indicamos que tipo de conexión queremos
     * @param tipo True = cliente, false = servidor 
     */
    public ConexionCliente_Servidor(boolean tipo){
               
        if (tipo){
            conectar();
        }else{
            escucha();
        }
        
        
    }
    
    public ConexionCliente_Servidor(boolean tipo, String pHost, int pPuerto){
               
        if(tipo){
            conectar(pHost, pPuerto);
        }else{
            escucha(pPuerto);
        }
    }
    
    /**
     * Se conecta a localhost (recomendado para realizar pruebas)
     */
    private void conectar(){
        
        try {
            String host = "127.0.01";
            sc= new Socket(host, 2500);
             
            System.out.println("Conexion establecida con el servidor\n");
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Debes iniciar el servidor antes");
            System.exit(0);
        }
        
    }
    
    /**
     * Permite conectarno a un host
     * @param host dirección donde queremos conectarnos
     * @param puerto puerto donde escucha el host
     */
    private void conectar(String host, int puerto){
        
        try {
            sc= new Socket(host, puerto);
             
            System.out.println("Conexion establecida con el servidor\n");
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Debes iniciar el servidor antes");
            System.exit(0);
        }
        
    }
    
    /**
     * Escucha el servidor desde un puerto predefinido (2500)
     */
    private void escucha(){
          try {
            serverAddr = new ServerSocket(2500);
            
            System.out.println("Esperando al cliente\n");
            
            sc = serverAddr.accept();
            
            System.out.println("Conexion establecida con el cliente\n");
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Escucha desde un puerto
     * @param pPuerto puerto desde donde escuchamos
     */
    private void escucha(int pPuerto){
          try {
            serverAddr = new ServerSocket(pPuerto);
            
            System.out.println("Esperando al cliente\n");
            
            sc = serverAddr.accept();
            
            System.out.println("Conexion establecida con el cliente\n");
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Damos un String
     * @param cadena String a dar
     */
    public void darString(String cadena){
        
        DataOutputStream ostream;
        try {
            ostream = new DataOutputStream(sc.getOutputStream());
            
            ostream.writeUTF(cadena);
            
            ostream.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un int
     * @param valor Int que damos 
     */
    public void darInt(int valor){
        
        DataOutputStream ostream;
        try {
            ostream = new DataOutputStream(sc.getOutputStream());
            
            ostream.writeInt(valor);
            
            ostream.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un Double
     * @param valor Double que damos
     */
    public void darDouble(double valor){
        
        DataOutputStream ostream;
        try {
            ostream = new DataOutputStream(sc.getOutputStream());
            
            ostream.writeDouble(valor);
            
            ostream.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un BigDecimal
     * @param valor BigDecimal que damos
     */
    public void darBigDecimal(BigDecimal valor){
        
        DataOutputStream ostream;
        try {
            ostream = new DataOutputStream(sc.getOutputStream());
            
            ostream.writeInt(valor.intValue());
            
            ostream.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un booleano
     * @param estado Booleano que damos
     */
    public void darBooleano(boolean estado){
        
        DataOutputStream ostream;
        try {
            ostream = new DataOutputStream(sc.getOutputStream());
            
            ostream.writeBoolean(estado);
            
            ostream.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Recibimos un booleano
     * @return Booleano recibido 
     */
    public boolean recibirBoolean(){
        
        DataInputStream istream;
        
        boolean valor=false;
        try {
            istream = new DataInputStream(sc.getInputStream());
            
            valor=istream.readBoolean();
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valor;   
        
    }
    
    /**
     * Damos un array de int
     * @param array Array de damos
     */
    public void darArrayInt(int[] array){
        
        OutputStream ostream;
        try {
            ostream = sc.getOutputStream();
            
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            s.writeObject(array);
            
            s.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un array de Doubles
     * @param array Array de damos
     */
    public void darArrayDouble(double[] array){
        
        OutputStream ostream;
        try {
            ostream = sc.getOutputStream();
            
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            s.writeObject(array);
            
            s.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un array de String
     * @param array Array de String que damos
     */
    public void darArrayString(String[] array){
        
        OutputStream ostream;
        try {
            ostream = sc.getOutputStream();
            
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            s.writeObject(array);
            
            s.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos una matriz de String
     * @param array Matriz de String que damos
     */
    public void darMatrizString(String[][] array){
        
        OutputStream ostream;
        try {
            ostream = sc.getOutputStream();
            
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            s.writeObject(array);
            
            s.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Damos un array de booleanos
     * @param array Array de booleanos
     */
    public void darArrayBoolean(boolean[] array){
        
        OutputStream ostream;
        try {
            ostream = sc.getOutputStream();
            
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            s.writeObject(array);
            
            s.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /**
     * Recibimos un String
     * @return String recibido 
     */
    public String recibirString(){
        
        DataInputStream istream;
        
        String cadena="";
        try {
            istream = new DataInputStream(sc.getInputStream());
            
            cadena=istream.readUTF();
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cadena;   
        
    }
    
    /**
     * Recibimos un Int
     * @return Int recibido 
     */
    public int recibirInt(){
        
        DataInputStream istream;
        
        int valor=0;
        try {
            istream = new DataInputStream(sc.getInputStream());
            
            valor=istream.readInt();
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valor;   
        
    }
    
    /**
     * Recibimos un Double
     * @return Double recibido 
     */
    public double recibirDouble(){
        
        DataInputStream istream;
        
        double valor=0.0;
        try {
            istream = new DataInputStream(sc.getInputStream());
            
            valor=istream.readDouble();
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valor;   
        
    }
    
  
    
    /**
     * Recibimos un array de Int
     * @return Array de int recibido 
     */
    public int[] recibirArrayInt(){
        
        InputStream istream;
       
        int[] array=null;
        
        try {
        
            istream = sc.getInputStream();
            
            ObjectInput s = new ObjectInputStream(istream);
            
            array=(int[])s.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return array;   
        
    }
    
    /**
     * Recibimos un array de Double
     * @return Array de doubles recibido 
     */
    public double[] recibirArrayDouble(){
        
        InputStream istream;
       
        double[] array=null;
        
        try {
        
            istream = sc.getInputStream();
            
            ObjectInput s = new ObjectInputStream(istream);
            
            array=(double[])s.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return array;   
        
    }
    
    /**
     * Recibimos un array de String
     * @return Array de String recibido 
     */
    public String[] recibirArrayString(){
        
        InputStream istream;
       
        String[] array=null;
        
        try {
        
            istream = sc.getInputStream();
            
            ObjectInput s = new ObjectInputStream(istream);
            
            array=(String[])s.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return array;   
        
    }
    
    /**
     * Recibimos un array de booleanos
     * @return Array de booleanos recibido 
     */
    public boolean[] recibirArrayBoolean(){
        
        InputStream istream;
       
        boolean[] array=null;
        
        try {
        
            istream = sc.getInputStream();
            
            ObjectInput s = new ObjectInputStream(istream);
            
            array=(boolean[])s.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return array;   
        
    }
    
    /**
     * Recibimos una matriz de String
     * @return Matriz de String recibido 
     */
    public String[][] recibirMatrizString(){
        
        InputStream istream;
       
        String[][] matriz=null;
        
        try {
        
            istream = sc.getInputStream();
            
            ObjectInput s = new ObjectInputStream(istream);
            
            matriz=(String[][])s.readObject();
            
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return matriz;   
        
    }
    
    /**
     * Cierra la conexión
     */
    public void cerrarSocket(){
        try {
            sc.close();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
