/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import Atributos.Lista;
import java.util.LinkedList;

/**
 * Se crea el árbol y se le asinga la información.
 * 
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
    /*
    public void Agregar(Nodo hijo) {
        
            if (hijo instanceof Usuario) {
                insertarUsuario(hijo);
            } else if (hijo instanceof Publicacion) {
                insertarPublicacion(hijo);

            } else {
                insertarComentario(hijo);

            }
            
        
    }
    */
    /**
     * Permite moverse en el arbol.
     */
    public void showTree(){
        Usuario ptr = userPtr;
        while(ptr!= null){
            Publicacion postPtr = ptr.getPostPtr();
            while(postPtr!=null){
                Comentario cptr= postPtr.getComentarioPtr();
                while(cptr != null){
                    System.out.println(cptr.toString());
                    cptr = cptr.link;
                }
                System.out.println(postPtr.toString());
                postPtr = postPtr.link;
            }
            System.out.println(ptr.toString());
            ptr = ptr.link;
        }
    }
    
    /*
    public void showTreeJson(){
        Usuario ptr = userPtr;
        while(ptr!= null){
            Publicacion postPtr = ptr.getPostPtr();
            while(postPtr!=null){
                Comentario cptr= postPtr.getComentarioPtr();
                while(cptr != null){
                    System.out.println(cptr.toString());
                    cptr = cptr.link;
                }
                System.out.println(postPtr.toString());
                postPtr = postPtr.link;
            }
            System.out.println(ptr.toString());
            ptr = ptr.link;
        }
    }
    */
    /*
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
    */
    /**
     * Permite la búsqueda del usuario por determinado id.
     * @param ptr
     * @param id
     * @return 
     */
    public Usuario encontrarUsuario(Usuario ptr,int id){
        if(ptr == null){
            return null;
        }else if(ptr.getId()==id){
            return ptr;
        }else{
            return encontrarUsuario(ptr.link, id);
        }
    }
    /**
     * Permite la búsqueda del post por determinado id.
     * @param ptr
     * @param postId
     * @return 
     */
    public Publicacion encontrarPost(Usuario ptr, int postId){
        if(ptr == null){
            return null;
        }else{
            Publicacion p = ptr.havePost(ptr.getPostPtr(), postId);
            if(p!=null){
                return p;
            }
            return encontrarPost(ptr.link, postId);
        }
    }
    /**
     * Getters y setters
     * @return 
     */
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
     * @return la cantidad de usuarios.
     */
    public int userSize(){
        Usuario u = userPtr;
        int count=0;
        while(u!=null){
            count++;
            u=u.link;
        }
        return count;
    }
    /**
     * @return la cantidad de Post.
     */
    public int totalPostSize(){
        int c = 0;
        Usuario u = userPtr;
        while(u != null){
            c += u.postSize();
            u = u.link;
        }
        return c;
    }
    /**
     * @return la cantidad de comentarios.
     */
    public int totalCommentSize(){
        int c = 0;
        Usuario u = userPtr;
        while(u != null){
            Publicacion p = u.postPtr;
            while (p!=null) {
                c+= p.commentsSize();
                p = p.link;
            }
            u = u.link;
        }
        return c;
    }

    public Lista getAllPosts(){
        Lista posts = new Lista();
        Usuario ptr = userPtr;
        while(ptr!= null){
            Publicacion postPtr = ptr.getPostPtr();
            while(postPtr!=null){
                posts.add(postPtr);
                postPtr = postPtr.link;
            }
            ptr = ptr.link;
        }
        return posts;
    }    
}