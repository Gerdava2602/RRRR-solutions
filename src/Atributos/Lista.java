/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;

/**
 *
 * @author German David
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
    
    public void add(Object o){
        Lista l = this;
        while(l.getLink() != null){
            l = l.getLink();
        }
        Lista j = new Lista(o);
        l.setLink(j);
    }
    
}
