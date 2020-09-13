/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_control;

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

    ArrayList<File> files;
    FileProcessor fp;

    public Jason() {
        files = new ArrayList();
        fp = new FileProcessor();
    }

    public Nodo convert(Nodo n, File users, File posts, File comments) throws FileNotFoundException, IOException {
        files.add(users);
        files.add(posts);
        files.add(comments);

        for (File file : files) {

            ArrayList<HashMap> maps = fp.extract(file);

            for (HashMap map : maps) {

            }
        }
        return n;
    }
}
