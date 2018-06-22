/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.discoduroderoer.swing;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import es.discoduroderoer.arrays.Array;

/**
 * @author Discoduroderoer
 */
public class Limpiar {
    
    
     /**
     * Vaciamos el texto de todas las cajas de texto pasadas.
     * @param campos Array de textbox
     */
    public static void limpiaCampos(JTextField campos[]){
        
        for(int i=0;i<campos.length;i++){
            campos[i].setText("");
        }
        
    }
    
    /**
     * Vaciamos el texto de una caja de texto con un valor nulo
     * @param campo TextBox
     * @param valor Valor nulo que deseemos
     */
    public static void limpiaCampoNulo(JTextField campo, String valor){
        
        if(campo.getText().isEmpty()){
            campo.setText(valor);
        }
        
    }
    
    /**
     * Vaciamos el texto de todas las cajas de texto pasadas. Los arrays de campos y objetos deben ser iguales.
     * @param campos Array de textbox
     * @param datos datos pasados para saber el tipo de dato 
     */
    public static void limpiaCamposValorNulo(JTextField campos[], Object[] datos){
        
        if(campos.length==datos.length){

            String tipo[]=Array.tiposDatos(datos);
            
            for(int i=0;i<campos.length;i++){
                
                String tipoActual=tipo[i];
                
                switch(tipoActual){
                    case "java.lang.Byte":
                    case "java.lang.Short":
                    case "java.lang.Integer": 
                    case "java.lang.Long":
                    case "java.lang.Double":
                    case "java.lang.Float":
                        campos[i].setText(String.valueOf(0));
                    case "java.lang.String":
                    case "java.lang.Character":
                        campos[i].setText("");
                    case "java.lang.Boolean":
                        campos[i].setText(String.valueOf(false));
                        break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Error, el array de objetos y de campos debe ser igual");
        }
        
    }
    
    
    
    /**
     * Borra todas las filas de un DefaultTableModel
     * @param dtm Tabla
     */
    public static void limpiarTabla(DefaultTableModel dtm){
       
        while(!dtm.getDataVector().isEmpty()){
            dtm.removeRow(0);
        }
    }
    
    /**
     * Borra todas los datos de un DefaultTableModel
     * @param dtm Tabla
     */
    public static void limpiarDatosTabla(DefaultTableModel dtm){
       
        for(int i=0;i<dtm.getColumnCount();i++){
            for(int j=0;j<dtm.getRowCount();j++){
                dtm.setValueAt("", i, j);
            }
        }
    }
    
}
