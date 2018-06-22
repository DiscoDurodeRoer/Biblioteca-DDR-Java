/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.discoduroderoer.clases.xml;

import java.util.ArrayList;

/**
 *
 * @author DiscoDurodeRoer
 * @param <T> Tipo de objeto
 */
public class Lista<T>{
        
    private ArrayList<T> lista;

    /**
     * Constructor por defecto
     */
    public Lista(){
        lista = new ArrayList<>();
    }

    /**
     * Añade un elemento
     * @param o Elemento a añadir
     */
    public void anadir(T o) {
        lista.add(o);
    }

    /**
     * Devuelve el estado de la lista
     * @return Estado lista
     */
    public ArrayList<T> getLista(){
        return lista;
    }
}
