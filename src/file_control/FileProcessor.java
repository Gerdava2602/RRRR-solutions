/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_control;

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
 *
 * @author German David
 */
public class FileProcessor {
    ArrayList<File> files;
    BufferedReader br;
    StringBuilder sb;

    public FileProcessor() {
        sb = new StringBuilder();
        files = new ArrayList();
    }
    
    public HashMap processor() throws IOException{
        HashMap map = new HashMap();
        extract(files.get(0));
        
        
        return map;
    }

    private void extract(File file) throws IOException {
        try {
            br = new BufferedReader(new FileReader (file));
        } catch (FileNotFoundException ex) {
            System.out.println("Hubo un problema con el file");
        }
        Pattern llaves,inicio,fin, valores;
        Matcher bloque;
        llaves = Pattern.compile("\"(.+?)\":");
        valores = Pattern.compile(": (.+)");
        inicio = Pattern.compile("\\{");
        
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
                while(count != 0 && line!=null){
                    opened = open.matcher(line);
                    closed = close.matcher(line);
                    sb.append(line+"\n");
                    if(opened.find())
                        count++;
                    if(closed.find())
                        count--;
                     line = br.readLine();
                }
                count =0;
            }else{
                line = br.readLine();
            }
        }
        System.out.println(sb.toString());
    }
    
}
