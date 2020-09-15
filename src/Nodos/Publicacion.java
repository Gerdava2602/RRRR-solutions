/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author German David
 */
public class Publicacion extends Nodo{
    int userId;
    int id;
    String title;
    String body;
    LinkedList<Comentario> comentarios;

    public Publicacion(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        comentarios = new LinkedList();
    }

    public Publicacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Publicacion\n");
        sb.append("userId: "+userId+"\n");
        sb.append("Id: "+id+"\n");
        sb.append("Title: "+title+"\n");
        sb.append("Body: "+body+"\n");
        
        return sb.toString();
    }
    
    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LinkedList<Comentario> getComments() {
        return comentarios;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    
}