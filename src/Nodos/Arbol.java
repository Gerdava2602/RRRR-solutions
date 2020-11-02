/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import Atributos.Lista;
import java.util.LinkedList;

/**
 * El arbol que se usara para guardar la informacion.
 */
public class Arbol {

    public Nodo Raiz;
    Usuario lastU;
    Publicacion lastPost;
    Comentario lastC;
    Usuario userPtr;

    public Arbol() {
        Raiz = new Nodo();
    }

    /**
     * Metodo que te escribe todos los datos del arbol en consola.
     */
    public void showTree() {
        Usuario ptr = userPtr;
        while (ptr != null) {
            Publicacion postPtr = ptr.getPostPtr();
            while (postPtr != null) {
                Comentario cptr = postPtr.getComentarioPtr();
                while (cptr != null) {
                    cptr = cptr.link;
                }
                postPtr = postPtr.link;
            }
            ptr = ptr.link;
        }
    }

    /**
     * Metodo que encuentra un usuario dado su ID
     *
     * @param ptr primer usuario.
     * @param id id del usuario a encontrar.
     * @return el usuario si lo encuentra, o nulo sino.
     */
    public Usuario encontrarUsuario(Usuario ptr, int id) {
        if (ptr == null) {
            return null;
        } else if (ptr.getId() == id) {
            return ptr;
        } else {
            return encontrarUsuario(ptr.link, id);
        }
    }

    /**
     * Metodo usado para encontrar usuarios dada una cadena.
     *
     * @param s la cadena que se buscara en los atributos de cada usuario.
     * @return la lista de usuarios que contengan esa cadena en sus datos.
     */
    public Lista encontrarUsuarios(String s) {
        Lista l = new Lista();
        Usuario ptr = userPtr;
        while (ptr != null) {
            if (ptr.name.toLowerCase().contains(s.toLowerCase()) || ptr.phone.contains(s) || String.valueOf(ptr.id).equals(s) || ptr.username.toLowerCase().contains(s.toLowerCase()) || ptr.website.contains(s)) {
                if (l.getData() == null) {
                    l.setData(ptr);
                } else {
                    l.add(ptr);
                }
            }
            ptr = ptr.link;
        }

        return l;

    }

    /**
     * Metodo usado para encontrar publicaciones dada una cadena.
     *
     * @param s la cadena que se buscara en los atributos de cada publicacion.
     * @return la lista de publicaciones que contengan esa cadena en sus datos.
     */
    public Lista encontrarPosts(String s) {
        Lista l = new Lista();
        Lista posts = getAllPosts();
        posts = posts.getLink();
        while (posts != null) {
            Publicacion datos = (Publicacion) posts.getData();
            if (datos.body.contains(s) || String.valueOf(datos.id).equals(s) || datos.title.contains(s) || String.valueOf(datos.userId).equals(s)) {
                if (l.getData() == null) {
                    l.setData(datos);
                } else {
                    l.add(datos);
                }
            }
            posts = posts.getLink();
        }

        return l;
    }

    /**
     * Metodo que encuentra una publicacion dada su ID
     *
     * @param ptr primer usuario.
     * @param postId id de la publicacion a encontrar.
     * @return la publicacion si la encuentra, o nulo sino.
     */
    public Publicacion encontrarPost(Usuario ptr, int postId) {
        if (ptr == null) {
            return null;
        } else {
            Publicacion p = ptr.havePost(ptr.getPostPtr(), postId);
            if (p != null) {
                return p;
            }
            return encontrarPost(ptr.link, postId);
        }
    }

    public Usuario getLastU() {
        return lastU;
    }

    public void setLastU(Usuario lastU) {
        this.lastU = lastU;
    }

    public Comentario getLastC() {
        return lastC;
    }

    public void setLastC(Comentario lastC) {
        this.lastC = lastC;
    }

    public Usuario getUserPtr() {
        return userPtr;
    }

    public void setUserPtr(Usuario userPtr) {
        this.userPtr = userPtr;
    }

    public Publicacion getLastPost() {
        return lastPost;
    }

    public void setLastPost(Publicacion lastPost) {
        this.lastPost = lastPost;
    }

    /**
     * Metodo que retorna la cantidad de usuarios.
     *
     * @return cantidad de usuarios del arbol.
     */
    public int userSize() {
        Usuario u = userPtr;
        int count = 0;
        while (u != null) {
            count++;
            u = u.link;
        }
        return count;
    }

    /**
     * metodo que retorna la cantidad de publicaciones totales del arbol
     *
     * @return publicaciones totales del arbol
     */
    public int totalPostSize() {
        int c = 0;
        Usuario u = userPtr;
        while (u != null) {
            c += u.postSize();
            u = u.link;
        }
        return c;
    }
    
    /**
     * metodo que retorna la cantidad de comentarios totales del arbol
     *
     * @return comentarios totales del arbol
     */
    public int totalCommentSize() {
        int c = 0;
        Usuario u = userPtr;
        while (u != null) {
            Publicacion p = u.postPtr;
            while (p != null) {
                c += p.commentsSize();
                p = p.link;
            }
            u = u.link;
        }
        return c;
    }
    
    /**
     * Metodo que retorna una lista de todos los posts del arbol.
     * @return lista con todos los posts del arbol.
     */
    public Lista getAllPosts() {
        Lista posts = new Lista();
        Usuario ptr = userPtr;
        while (ptr != null) {
            Publicacion postPtr = ptr.getPostPtr();
            while (postPtr != null) {
                posts.add(postPtr);
                postPtr = postPtr.link;
            }
            ptr = ptr.link;
        }
        return posts;
    }

}
