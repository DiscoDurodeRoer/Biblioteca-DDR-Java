/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.swing;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando
 */
public class Rellenar {
    
    /**
     * Rellena un combobox con los datos pasados
     * @param cmb ComboBox
     * @param datos Array de String con los valores a rellenar
     */
    public static void rellenaComboBox(JComboBox cmb, String datos[]){
        
        for(int i=0;i<datos.length;i++){
            cmb.addItem(datos[i]);
        }
        
    }
    
    /**
     * Rellena un combobox con datos numericos de una BD
     * @param cmb ComboBox
     * @param rs Resultset con la consulta, debe ser correcta
     * @param columna Columna de donde se sacan los datos
     */
    public static void rellenaComboBoxBDInt(JComboBox cmb, ResultSet rs, String columna){
        try {
            while(rs.next()){
                cmb.addItem(rs.getInt(columna));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiSwing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Rellena un combobox con datos de cadena de una BD
     * @param cmb ComboBox
     * @param rs Resultset con la consulta, debe ser correcta
     * @param columna Columna de donde se sacan los datos
     */
    public static void rellenaComboBoxBDString(JComboBox cmb, ResultSet rs, String columna){
        try {
            while(rs.next()){
                cmb.addItem(rs.getString(columna));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiSwing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Rellena un combobox con datos decimales de una BD
     * @param cmb ComboBox
     * @param rs Resultset con la consulta, debe ser correcta
     * @param columna Columna de donde se sacan los datos
     */
    public static void rellenaComboBoxBDDouble(JComboBox cmb, ResultSet rs, String columna){
        try {
            while(rs.next()){
                cmb.addItem(rs.getDouble(columna));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiSwing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Rellena una tabla desde BD
     * @param resultSet Resultset con la consulta, debe ser correcta
     * @param tabla Tabla
     */
    public static void rellenaTablaBD(ResultSet resultSet, DefaultTableModel tabla){
        try {
            ResultSetMetaData metadatos = resultSet.getMetaData();
            
            tabla.setColumnCount(metadatos.getColumnCount());
            
            int numeroColumnas=tabla.getColumnCount();
            
            Object[] etiquetas = new Object[numeroColumnas];

            // Se obtiene cada una de las etiquetas para cada columna
            for (int i = 0; i < numeroColumnas; i++)
            {
               // Nuevamente, para ResultSetMetaData la primera columna es la 1. 
               etiquetas[i] = metadatos.getColumnLabel(i + 1); 
            }
            
            tabla.setColumnIdentifiers(etiquetas);
            
                // Para cada registro de resultado en la consulta 
                while (resultSet.next())
                {
                    // Se crea y rellena la fila para el modelo de la tabla.
                    Object[] datosFila = new Object[tabla.getColumnCount()];
                    for (int i = 0; i < tabla.getColumnCount(); i++)
                        datosFila[i] = resultSet.getObject(i + 1);
                    tabla.addRow(datosFila);
                    
                }
                resultSet.close();
            } catch (SQLException ex) {
            Logger.getLogger(MiSwing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Rellena un DefaulTableModel con los datos de la matriz
     * @param modelo Tabla a rellenar
     * @param matriz Matriz con los datos 
     */
    public static void rellenarDTMDesdeMatriz(DefaultTableModel modelo, Object matriz[][]){
        
        //String contenido[][]=tablero.contenidoTablero();
         String filas[]=new String[matriz[0].length];
         
         for(int i=0;i<matriz.length;i++){
             for(int j=0;j<matriz[0].length;j++){
                 filas[j]=matriz[i][j].toString();
             }
             modelo.addRow(filas);
         }
         
    }
    
    
}
