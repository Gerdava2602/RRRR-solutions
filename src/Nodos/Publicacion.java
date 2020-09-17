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
    Comentario comentarioPtr;
    Publicacion link;
    Comentario lastComment;
    
    public Publicacion(int userId, int id, String title, String body, Publicacion link) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
        this.link = link;
        
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

    public Comentario getComentarioPtr() {
        return comentarioPtr;
    }

    public void setComentarioPtr(Comentario comentarioPtr) {
        this.comentarioPtr = comentarioPtr;
    }

    public Publicacion getLink() {
        return link;
    }

    public void setLink(Publicacion link) {
        this.link = link;
    }

    public Comentario getLastComment() {
        return lastComment;
    }

    public void setLastComment(Comentario lastComment) {
        this.lastComment = lastComment;
    }
    
    public int commentsSize(){
        Comentario c = comentarioPtr;
        int count=0;
        while(c!=null){
            count++;
            c=c.link;
        }
        return count;
    }
}