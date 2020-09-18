/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_control;

import Atributos.Lista;
import Nodos.Arbol;
import Nodos.Comentario;
import Nodos.Nodo;
import Nodos.Publicacion;
import Nodos.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jason {

    Lista files;
    FileProcessor fp;
    Lista l;
    
    public Jason() {
        files = new Lista();
        fp = new FileProcessor();
    }

    public Arbol convert(Arbol a, File users, File posts, File comments) throws FileNotFoundException, IOException {
        files.add(users);
        files.add(posts);
        files.add(comments);

        Lista list = files;
        while(list != null){
            if (list.getData() != null) {
                
                l  = fp.extract((File)list.getData());
                
                while(l != null){
                    a = creaNodo(a, (HashMap)l.getData());
                    l = l.getLink();
                }
            }
            list = list.getLink();
        }
        return a;
    }

    private Arbol creaNodo(Arbol a, HashMap map) {
        if (map.containsKey("username")){
            Usuario usuario = new Usuario(Integer.parseInt((String) map.get("id")),
                                          (String)(map.get("name")),
                                          (String)(map.get("username")),
                                          (String)(map.get("email")),
                                          (String)(map.get("street")),
                                          (String)(map.get("suite")),
                                          (String)(map.get("city")),
                                          (String)(map.get("zipcode")),
                                          (String)(map.get("lat")),
                                          (String)(map.get("lng")),
                                          (String)(map.get("phone")),
                                          (String)(map.get("website")),
                                          (String)(map.get("nameC")),
                                          (String)(map.get("catchPhrase")),
                                          (String)(map.get("bs")),
                                           null);
           // a.Agregar(usuario);
            if(a.getUserPtr()==null){
                a.setUserPtr(usuario);
                a.setLastU(usuario);
            }else{
                Usuario last = a.getLastU();
                last.setLink(usuario);
                a.setLastU(usuario);
            }
                
        }else if (map.containsKey("userId")){
            
            Publicacion publicacion = new Publicacion(Integer.parseInt((String) map.get("userId")),Integer.parseInt((String) map.get("id")), (String)(map.get("title")), (String)(map.get("body")),null);
            Usuario usuario = a.encontrarUsuario(a.getUserPtr(), publicacion.getUserId());
            if(usuario.getPostPtr()==null){
                usuario.setPostPtr(publicacion);
                usuario.setLastPost(publicacion);
            }else{
                Publicacion p = usuario.getLastPost();
                p.setLink(publicacion);
                usuario.setLastPost(publicacion);
            }
            
            //a.Agregar(publicacion);

            
        }else if(map.containsKey("postId")){
            Comentario c = new Comentario(Integer.parseInt((String) map.get("postId")),Integer.parseInt((String) map.get("id")), (String)(map.get("name")), (String)(map.get("email")), (String)(map.get("body")),null);
            Publicacion p = a.encontrarPost(a.getUserPtr(), c.getPostId());
            if(p.getComentarioPtr()==null){
                p.setComentarioPtr(c);
                p.setLastComment(c);
            }else{
                Comentario coment = p.getLastComment();
                coment.setLink(c);
                p.setLastComment(c);
            }
            //a.Agregar(c);
        }
        
        return a;
    }
}
