package es.discoduroderoer.swing;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        /*Si necesitas coger un valor en concreto, table.getValueAt(row, column);*/
        
        if (row % 2 == 0) {
            this.setBackground(Color.RED);
        } else {
            this.setBackground(Color.GREEN);
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
    }

}
