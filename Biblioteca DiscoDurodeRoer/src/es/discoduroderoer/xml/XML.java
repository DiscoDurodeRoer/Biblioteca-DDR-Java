/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author DiscoDurodeRoer
 */
public class XML {

    private Document documento;
    private String nombreFichero;

    /**
     * Constructor, le pasamos el nombre del fichero
     *
     * @param nombreFichero Nombre del fichero
     */
    public XML(String nombreFichero) {

        this.nombreFichero = nombreFichero;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        DOMImplementation implementation = null;
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        documento = implementation.createDocument(null, nombreFichero, null);
        documento.setXmlVersion("1.0"); // asignamos la version
    }

    /**
     * Crea el fichero XML
     *
     * @return True = fichero creado con éxito
     */
    public boolean creaFichero() {

        boolean exito = false;

        Source source = new DOMSource(documento);
        Result result = new StreamResult(new java.io.File(nombreFichero + ".xml"));
        Transformer transformer;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            exito = true;
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return exito;

    }

    /**
     * Crea un elemento dentro de un XML
     *
     * @param dato Nombre del elemento hijo
     * @param valor Valor del elemento hijo
     * @param raiz Elemento raiz
     */
    public void CrearElemento(String dato, String valor, Element raiz) {
        Element elem = documento.createElement(dato); //creamos hijo
        Text text = documento.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor
    }

    /**
     * Devuelve el elemento raiz
     *
     * @return Estado elemento raiz
     */
    public Element obtenerRaiz() {

        //creamos una instancia de DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            documento = builder.parse(new File(nombreFichero + ".xml")); // para construir el parser
            documento.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }

        return documento.getDocumentElement();
    }

    /**
     * Devuelve una lista de nodos
     *
     * @param tagNodo Etiqueta Nodo
     * @return Lista de nodos
     */
    public NodeList listaNodos(String tagNodo) {
        return documento.getElementsByTagName(tagNodo);
    }

    public String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue(); //devuelve el valor del nodo
    }

    /**
     * Devuelve el estado del documento
     *
     * @return Estado documento
     */
    public Document getDocumento() {
        return documento;
    }

    /**
     * Modifica el estado del documento
     *
     * @param documento Valor a cambiar
     */
    public void setDocumento(Document documento) {
        this.documento = documento;
    }

    /**
     * Devuelve el contenido de un fichero XML
     *
     * @param nombreNodos Nombre de los nodos
     * @param nodo Nodo
     * @return Cadena con todo el contenido
     */
    public String leerFichero(String[] nombreNodos, String nodo) {

        //Nos devuelve la lista de nodos
        NodeList articulos = listaNodos(nodo);

        String contenido = "";

        for (int i = 0; i < articulos.getLength(); i++) {

            Node articulo = articulos.item(i);
            if (articulo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) articulo;
                for (int j = 0; j < nombreNodos.length; j++) {
                    contenido += getNodo(nombreNodos[j], elemento) + "\n";
                }

            }
        }

        contenido += "\n";

        return contenido;
    }

    /**
     * Devuelve el número de elemento que tiene un nodo
     *
     * @param e Elemento
     * @param nombreNodo Nombre de nodos
     * @return Número de elementos
     */
    public int numeroElementos(Element e, String nombreNodo) {

        NodeList nl = e.getElementsByTagName(nombreNodo);
        return nl.getLength();

    }
}
