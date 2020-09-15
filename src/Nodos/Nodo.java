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
public class Nodo {

    private LinkedList<Usuario> usuarios;

    public Nodo() {
        usuarios = new LinkedList();
    }

    public Usuario getUsuario(int id) {
        for (Usuario u : usuarios) {
            if (id == u.getId()) {
                return u;
            }
        }
        System.out.println("nulo");
        return null;
    }

    public Publicacion getPost(int id) {
        for (Usuario u : usuarios) {
            for (Publicacion p : u.getPosts()) {
                if (p.getId() == id) {
                    return p;
                }
            }
        }
        System.out.println("nulo");
        return null;
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    
    
}