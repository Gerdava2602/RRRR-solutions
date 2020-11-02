/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;

import Nodos.Usuario;

/**
 * Nuestra propia clase lista, la cual utilizamos en todo el programa
 */
public class Lista {
    Object data;
    Lista link;
    
    public Lista(Object data) {
        this.data = data;
    }

    public Lista() {
        
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Lista getLink() {
        return link;
    }

    public void setLink(Lista link) {
        this.link = link;
    }
    
    /**
     * Metodo para añadir a la lista.
     * @param o nodo a añadir.
     */
    public void add(Object o){
        Lista l = this;
        while(l.getLink() != null){
            l = l.getLink();
        }
        Lista j = new Lista(o);
        l.setLink(j);
    }
    /**
     * Metodo para devolverse en la lista, al no ser doblemente enlazada se necesita.
     * @param actual Nodo actual
     * @param l La lista en uso
     * @return El nodo anterior al que se paso por parametro.
     */
    public Object retroceder(Object actual,Lista l) {
        
        while (l.link != null) {
            if(l.link.getData()!=actual){
                l.link = null;
                return l.getData();
            }
            l = l.link;
        }
            return 0;
    }
    
    /**
     * El metodo get que nos devuelve el objeto i en la lista
     * @param i indice del objeto a devolver
     * @return el objeto casteado a string
     */
    public String get(int i){
        Lista l = this;
        for (int j = 0; j < i; j++) {
            l = l.link;
            if (l == null) {
                return "";
            }
        }
        return (String) l.data;
    }
    
}
