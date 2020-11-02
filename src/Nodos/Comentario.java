/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import java.util.LinkedList;

/**
 * Clase de los comentarios del arbol.
 */
public class Comentario extends Nodo{
    int postId;
    int id;
    String name;
    String email;
    String body;
    Comentario link;

    public Comentario(int postId, int id, String name, String email, String body, Comentario link) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
        this.link = link;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Comentario\n");
        sb.append("postId: "+postId+"\n");
        sb.append("Id: "+id+"\n");
        sb.append("Name: "+name+"\n");
        sb.append("Email: "+email+"\n");
        sb.append("Body: "+body+"\n");
        
        return sb.toString();
    }
    
    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    public Comentario getLink() {
        return link;
    }

    public void setLink(Comentario link) {
        this.link = link;
    }
    
    /**
     * Metodo que se utiliza para serializar
     * @return El string de el objeto serializado
     */
    public String getSerialData() {
        StringBuilder sb = new StringBuilder();
        sb.append("C").append(",").append(this.postId).append(",").append(this.id).append(",").append(this.name).append(",").append(this.body.replace("\n", "/n")).append(",").append(this.email).append("\n");
        return sb.toString();
    }
    
}