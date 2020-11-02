/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_control;

import Atributos.Lista;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * El procesador de archivos, el cual convertira los archivos json.
 */
public class FileProcessor {
    ArrayList<File> files;
    BufferedReader br;
    StringBuilder sb;
    

    public FileProcessor() {
        sb = new StringBuilder();
        files = new ArrayList();
    }
    
    /**
     * Motodo que extrae los datos del archivo json.
     * @param file el archivo del cual extraeremos los datos
     * @return una lista con los datos
     * @throws IOException si no encuentra el archivo.
     */
    public Lista extract(File file) throws IOException {
        Lista l = null;
        Lista interna = l;
        Pattern llaves,inicio,fin, valores;
        Matcher bloque, matcherK, matcherV;
        
        
        try {
            br = new BufferedReader(new FileReader (file));
        } catch (FileNotFoundException ex) {
            System.out.println("Hubo un problema con el file");
        }

        inicio = Pattern.compile("\\{");
        llaves = Pattern.compile("\"(.+?)\":");
        valores = Pattern.compile(": ([^\\{\\}]+)");
        HashMap map = new HashMap();
        String line = br.readLine();
        int count = 0;
        
        while(line != null){
            bloque = inicio.matcher(line);
            if(bloque.find()){
                count = 1;
                Pattern open,close;
                Matcher opened,closed;
                open = Pattern.compile("\\{");
                close = Pattern.compile("\\}");
                line = br.readLine();
                map = new HashMap();
                while(count != 0 && line!=null){
                    opened = open.matcher(line);
                    closed = close.matcher(line);
                    matcherK = llaves.matcher(line);
                    matcherV = valores.matcher(line);
                    if(matcherK.find() && matcherV.find()){
                        String value = depurar(matcherV.group(1));
                        
                        if(map.containsKey("name") && matcherK.group(1).equals("name"))
                            map.put("nameC", value);
                        else if(matcherK.group(1).equals("body")){
                            value = value.replace("\\n", "\n");
                            map.put(matcherK.group(1), value);
                        }else
                            map.put(matcherK.group(1), value);
                    }
                    sb.append(line+"\n");
                    if(opened.find())
                        count++;
                    if(closed.find())
                        count--;
                     line = br.readLine();
                }
                if(l == null){
                    l = new Lista(map);
                    interna = l;
                }else{
                    Lista n = new Lista(map);
                    interna.setLink(n);
                    interna = interna.getLink();
                }
                sb.delete(0, sb.length()-1);
                count =0;
            }else{
                line = br.readLine();
            }
        }
        return l;
    }
    
    /**
     * Metodo para suprimir las comas y puntos de lo que extrajimos en el metodo extract
     * @param group el string a depurar
     * @return el string depurado.
     */
    private String depurar(String group) {
        Pattern depura = Pattern.compile("([^\\{,\"]+)");
        Matcher matcher = depura.matcher(group);
        if(matcher.find())
            return matcher.group(1);
        return matcher.group(1);
    }
    
}