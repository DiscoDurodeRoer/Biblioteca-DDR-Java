/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @author DiscoDurodeRoer
 */
public class MiSwing {

    /**
     * Oculta la cabecera
     *
     * @param tabla Tabla
     */
    public static void ocultarCabecera(JTable tabla) {
        tabla.getTableHeader().setVisible(false);

        tabla.getTableHeader().setPreferredSize(new Dimension(0, 0));

    }

    /**
     * Oculta una columna de una tabla
     *
     * @param tabla Tabla
     * @param columna Columna a ocultar
     */
    public static void ocultarColumnaJTable(JTable tabla, int columna) {

        tabla.getColumnModel().getColumn(columna).setMinWidth(0);

        tabla.getColumnModel().getColumn(columna).setMaxWidth(0);

        tabla.getColumnModel().getColumn(columna).setPreferredWidth(0);

    }

    /**
     * Centra el texto de la cabecera
     *
     * @param table Tabla
     */
    public static void centraCabecera(JTable table) {
        TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * Centra el texto de las celdas de la tabla
     *
     * @param table Tabla
     */
    public static void centrarDatos(JTable table) {

        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);

        int numColumnas = table.getColumnCount();

        for (int i = 0; i < numColumnas; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(modelocentrar);
        }
    }

    /**
     * Centra un dialogo dentro de un frame
     *
     * @param frame Frame padre
     * @param dialogo Dialogo hijo
     */
    public void centrarDialogo(JFrame frame, JDialog dialogo) {

        int x = (frame.getWidth() - dialogo.getWidth()) / 2;
        int y = (frame.getHeight() - dialogo.getHeight()) / 2;
        dialogo.setLocation(x, y);

    }

    /**
     * Centra un dialogo dentro de un frame
     *
     * @param dialogoPadre Dialogo padre
     * @param dialogoHijo Dialogo hijo
     */
    public static void centrarDialogo(JDialog dialogoPadre, JDialog dialogoHijo) {

        int x = (dialogoPadre.getWidth() - dialogoHijo.getWidth()) / 2;
        int y = (dialogoPadre.getHeight() - dialogoHijo.getHeight()) / 2;
        dialogoHijo.setLocation(x, y);

    }

    /**
     * Establece el icono del JFrame
     *
     * @param frame Frame
     * @param rutaIcono Ruta del icono a poner
     */
    public static void iconoJFrame(JFrame frame, String rutaIcono) {
        frame.setIconImage(new ImageIcon(rutaIcono).getImage());
    }

    /**
     * Añade un borde con titulo al panel pasado por parametro
     *
     * @param panel Panel
     * @param titulo Titulo del panel
     */
    public static void bordeConTitulo(JPanel panel, String titulo) {
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
    }

    /**
     * Abre un fichero pasado por parametro
     *
     * @param ruta Ruta fichero a abrir
     */
    public static void abrirFichero(String ruta) {
        Desktop ficheroAEjecutar = Desktop.getDesktop();
        try {
            ficheroAEjecutar.open(new File(ruta));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Abre un fichero pasado por parametro
     *
     * @param fichero Fichero a abrir
     */
    public static void abrirFichero(File fichero) {
        Desktop ficheroAEjecutar = Desktop.getDesktop();
        try {
            ficheroAEjecutar.open(fichero);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Abre el enlace pasado por parametro
     *
     * @param enlaceAAceder Enlace a abrir
     */
    public void enlace(String enlaceAAceder) {
        Desktop enlace = Desktop.getDesktop();
        try {
            enlace.browse(new URI(enlaceAAceder));
        } catch (IOException | URISyntaxException e) {
        }
    }

    /**
     * Activa o desactiva los controles
     *
     * @param controles Array de controles
     * @param activo True = activar, false = desactivar
     */
    public static void activa_DesactivaControles(Component[] controles, boolean activo) {

        for (int i = 0; i < controles.length; i++) {
            controles[i].setEnabled(activo);
        }

    }

    /**
     * Devuelve el codigo de un comboBox de 2 columnas (usado para BD)
     *
     * @param cmb ComboBox
     * @return Codigo
     */
    public static int devolverCodigoComboBox(JComboBox cmb) {

        String[] newSelection = (String[]) cmb.getSelectedItem();

        return Integer.parseInt(newSelection[0]);

    }

    /**
     * Devuelve el texto de un comboBox de 2 columnas (usado para BD)
     *
     * @param cmb ComboBox
     * @return Texto
     */
    public static String devolverTextoComboBox(JComboBox cmb) {

        String[] newSelection = (String[]) cmb.getSelectedItem();

        return newSelection[1];

    }

    /**
     * Si esta vacio devuelve null Útil para base de datos
     *
     * @param campo TextBox
     * @return Estado del textbox
     */
    public static String devolverEstado(JTextField campo) {

        if (campo.getText().isEmpty()) {
            return null;
        } else {
            return campo.getText();
        }

    }

    /**
     * Asigna el item segun el codigo
     *
     * @param cmb ComboBox
     * @param codigo Codigo, debe de existir dentro del combobox
     */
    public static void asignarItemCmb2Columnas(JComboBox cmb, int codigo) {

        boolean encontrado = false;

        for (int i = 1; i < cmb.getItemCount() && !encontrado; i++) {
            String[] seleccion = (String[]) cmb.getItemAt(i);

            if (codigo == Integer.parseInt(seleccion[0])) {
                cmb.setSelectedIndex(i);
                encontrado = true;
            }
        }

        if (!encontrado) {
            cmb.setSelectedIndex(0);
        }

    }

    /**
     * Extrae los valores de un array de textbox
     *
     * @param campos Array de TextBox
     * @return Valores de los TextBox
     */
    public static String[] obtenerValoresDe(JTextField[] campos) {

        String datos[] = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {

            datos[i] = campos[i].getText();

        }

        return datos;

    }

    /**
     * Introduce valores a un condjunto de textbox
     *
     * @param campos Array de textbox
     * @param datos Datos a insertar
     */
    public static void introducirValoresDe(JTextField[] campos, String[] datos) {

        for (int i = 0; i < campos.length; i++) {

            campos[i].setText(datos[i]);

        }

    }

    /**
     * Indica si hay un Internal Frame abierto dentro de un JDesktopPane
     *
     * @param principal Contenedor
     * @param frm Internal frame
     * @return True = existe
     */
    public boolean existeInternalFrameAbierto(JDesktopPane principal, JInternalFrame frm) {

        JInternalFrame[] frames = principal.getAllFrames();

        for (int i = 0; i < frames.length; i++) {

            if (frames[i] == frm) {
                return true;
            }

        }

        return false;
    }

    /**
     * Evita pegar en un textbox
     *
     * @param campo TextBox
     */
    public static void evitarPegar(JTextField campo) {

        InputMap map2 = campo.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

    }

    /**
     * Devuelve el scrollpane de un elemento
     *
     * @param component Componente que tenga incluido un JScrollPane
     * @return ScrollPane de un elemento
     */
    public static JScrollPane getScrollPane(JComponent component) {

        Container p = component.getParent();
        if (p instanceof JViewport) {
            Container gp = p.getParent();
            if (gp instanceof JScrollPane) {
                return (JScrollPane) gp;
            }
        }
        return null;

    }

}
