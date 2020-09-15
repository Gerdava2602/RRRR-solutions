/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import java.util.LinkedList;

/**
 *
 * @author German David
 */
public class Arbol {

    public Nodo Raiz;

    public Arbol() {
        Raiz = new Nodo();
    }

    public void Agregar(Nodo hijo) {
        
            if (hijo instanceof Usuario) {
                insertarUsuario(hijo);
            } else if (hijo instanceof Publicacion) {
                insertarPublicacion(hijo);

            } else {
                insertarComentario(hijo);

            }
            
        
    }

    public void insertarUsuario(Nodo nodo) {
        Raiz.getUsuarios().add((Usuario) nodo);
        Usuario u = (Usuario)nodo;
        System.out.println(u.toString());
    }

    public void insertarPublicacion(Nodo nodo) {
        Publicacion p = (Publicacion) nodo;
        Usuario u = Raiz.getUsuario(p.getUserId());
        if (u != null) {
            System.out.println(p.toString());
            u.posts.add((Publicacion) nodo);
        }

    }

    public void insertarComentario(Nodo nodo) {
        Comentario c = (Comentario) nodo;
        Publicacion p = Raiz.getPost(c.getPostId());
        if (p != null) {
            System.out.println(c.toString());
            p.comentarios.add((Comentario) nodo);
        }

    }

}