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
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Clase encargada de serializar y des-serializar el arbol
 */
public class Serializador {

    /**
     * Metodo encargado de serializar el arbol
     *
     * @param arbol arbol a serializar.
     * @throws UnsupportedEncodingException
     * @throws FileNotFoundException si no encuentra el archivo.
     * @throws IOException
     */
    public static void serializar(Arbol arbol) throws UnsupportedEncodingException, FileNotFoundException, IOException {
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        f.showSaveDialog(null);
        File file = new File(f.getSelectedFile(), "arbol.csv");
        StringBuilder sb = new StringBuilder();
        FileWriter writer = new FileWriter(file);
        Usuario u = arbol.getUserPtr();
        while (u != null) {
            sb.append(u.getSerialData());
            writer.write(sb.toString());
            sb.setLength(0);
            u = u.getLink();
        }
        writer.flush();
        writer.close();
    }

    /**
     * Metodo usado para des-serializar el arbol
     *
     * @param ruta ruta del archivo que contiene el arbol serializado.
     * @return el arbol ya construido.
     * @throws FileNotFoundException si no encuentra el archivo.
     * @throws IOException
     */
    public static Arbol crearArbol(String ruta) throws FileNotFoundException, IOException {
        StringBuffer sb = new StringBuffer();
        Arbol arbol = new Arbol();
        arbol.Raiz = new Nodo();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea = br.readLine();
        while (linea != null) {
            if (linea.startsWith("U")) {
                Lista uData = separador(linea);
                linea = br.readLine();
                Lista aData = separador(linea);
                linea = br.readLine();
                Lista gData = separador(linea);
                linea = br.readLine();
                Lista cData = separador(linea);
                Usuario u = new Usuario(Integer.parseInt(uData.get(1)), uData.get(3), uData.get(2), uData.get(4),
                        aData.get(0), aData.get(1), aData.get(2), aData.get(3),
                        gData.get(0), gData.get(1), uData.get(5), uData.get(6),
                        cData.get(0), cData.get(1), cData.get(2), null);
                if (arbol.getUserPtr() == null) {
                    arbol.setUserPtr(u);
                    arbol.setLastU(u);
                } else {
                    Usuario last = arbol.getLastU();
                    last.setLink(u);
                    arbol.setLastU(u);
                }
            } else if (linea.startsWith("P")) {
                Lista pData = separador(linea);
                String temp = pData.get(4).replace("/n", "\n");
                Publicacion publicacion = new Publicacion(Integer.parseInt(pData.get(1)), Integer.parseInt(pData.get(2)), pData.get(3), temp, null);
                Usuario usuario = arbol.encontrarUsuario(arbol.getUserPtr(), publicacion.getUserId());
                if (usuario.getPostPtr() == null) {
                    usuario.setPostPtr(publicacion);
                    usuario.setLastPost(publicacion);
                } else {
                    Publicacion p = usuario.getLastPost();
                    p.setLink(publicacion);
                    usuario.setLastPost(publicacion);
                }
            } else if (linea.startsWith("C")) {
                Lista cData = separador(linea);
                String temp = cData.get(4).replace("/n", "\n");
                Comentario c = new Comentario(Integer.parseInt(cData.get(1)), Integer.parseInt(cData.get(2)), cData.get(3), cData.get(5), temp, null);
                Publicacion p = arbol.encontrarPost(arbol.getUserPtr(), c.getPostId());
                if (p.getComentarioPtr() == null) {
                    p.setComentarioPtr(c);
                    p.setLastComment(c);
                } else {
                    Comentario coment = p.getLastComment();
                    coment.setLink(c);
                    p.setLastComment(c);
                }
            }
            arbol.Raiz.usuario = arbol.getUserPtr();
            linea = br.readLine();
        }
        br.close();
        return arbol;
    }

    /**
     * La implementacion de nuestro metodo parecido a split().
     *
     * @param linea la linea de donde extraera los datos.
     * @return una lista con todos los datos de esa linea.
     */
    public static Lista separador(String linea) {
        Lista lista = new Lista();
        int i = 0;
        int c = 0;
        boolean first = true;
        String sub;
        while (c < linea.length()) {
            if (linea.substring(c, c + 1).equals(",")) {
                sub = linea.substring(i, c);
                if (first) {
                    lista.setData(sub);
                    first = false;
                } else {
                    lista.add(sub);
                }
                i = c + 1;
            }
            c++;
        }
        sub = linea.substring(i, linea.length());
        lista.add(sub);
        return lista;
    }

}
