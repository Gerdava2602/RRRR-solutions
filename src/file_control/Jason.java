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

    ArrayList files;
    FileProcessor fp;
    
    public Jason() {
        files = new ArrayList();
        fp = new FileProcessor();
    }

    public Nodo convert(Nodo n, File users) throws FileNotFoundException, IOException {
        HashMap mp = new HashMap();
        fp.files.add(users);
        mp = fp.processor();
        /*
        System.out.println(line);
        Usuario user = null;
        Matcher beginningM, infoM, endingM;
        Pattern beginning, info, ending;
        boolean nuevo = false;
        int i = 0;
        info = Pattern.compile(": (.+).");
        ending = Pattern.compile("bs");
        beginning = Pattern.compile("[^a-z](id)[^a-z]");
        while (line != null) {
            beginningM = beginning.matcher(line);
            infoM = info.matcher(line);
            endingM = ending.matcher(line);
            if (beginningM.find()) {
                nuevo = true;
                user = new Usuario();

            }

            if (nuevo) {
                i++;
                if (infoM.find(1)) {
                    switch (i) {
                        case (1):
                            user.setId(Integer.parseInt(infoM.group(1)));
                            System.out.println(user.getId());
                            break;
                        case (2):
                            user.setName((infoM.group(1)));
                            System.out.println(user.getName());
                            break;
                        case (3):
                            user.setUsername((infoM.group(1)));
                            System.out.println(user.getUsername());
                            break;
                        case (4):
                            user.setEmail((infoM.group(1)));
                            System.out.println(user.getEmail());
                            break;
                        case (6):
                            user.createAddress();
                            user.getDireccion().setStreet(infoM.group(1));
                            System.out.println(user.getDireccion().getStreet());
                            break;
                        case (7):
                            user.getDireccion().setSuite(infoM.group(1));
                            System.out.println(user.getDireccion().getSuite());
                            break;
                        case (8):
                            user.getDireccion().setCity(infoM.group(1));
                            System.out.println(user.getDireccion().getCity());
                            break;
                        case (9):
                            user.getDireccion().setZipcode(infoM.group(1));
                            System.out.println(user.getDireccion().getZipcode());
                            break;
                        case (11):
                            user.getDireccion().createGeo();
                            user.getDireccion().getGeo().setLatitud(infoM.group(1));
                            System.out.println(user.getDireccion().getGeo().getLatitud());
                            break;
                        case (12):
                            user.getDireccion().getGeo().setLongitud(infoM.group(1));
                            System.out.println(user.getDireccion().getGeo().getLongitud());
                            break;
                        case (15):
                            user.setPhone((infoM.group(1)));
                            System.out.println(user.getPhone());
                            break;
                        case (16):
                            user.setWebsite((infoM.group(1)));
                            System.out.println(user.getWebsite());
                            break;
                        case (18):
                            user.createCompany();
                            user.getCompany().setName(infoM.group(1));
                            System.out.println(user.getCompany().getName());
                            break;
                        case (19):
                            user.getCompany().setCatchPhrase(infoM.group(1));
                            System.out.println(user.getCompany().getCatchPhrase());
                            break;
                        case (20):
                            user.getCompany().setBs(infoM.group(1));
                            System.out.println(user.getCompany().getBs());
                            nuevo = false;
                            i = 0;
                            break;

                    }

                }
            }
            n.addHijo(user);
            line = br.readLine();
        }

        //Posts
        br = new BufferedReader(new FileReader(posts));
        info = Pattern.compile(".+: (.+).");
        ending = Pattern.compile("}");
        beginning = Pattern.compile("[^a-z](userId)[^a-z]");
        line = br.readLine();
        i = 0;
        Publicacion post;
        post = null;
        String body = "";
        while (line != null) {
            beginningM = beginning.matcher(line);
            infoM = info.matcher(line);
            endingM = ending.matcher(line);

            if (beginningM.find()) {
                nuevo = true;
                post = new Publicacion();
            }

            if (nuevo) {
                i++;
                if(infoM.find(1)){
                switch (i) {
                    case (1):
                        post.setUserId(Integer.parseInt(infoM.group(1)));
                        user = (Usuario) n.findId(Integer.parseInt(infoM.group(1)));
                        user.addHijo(post);
                        break;
                    case (2):
                        post.setId(Integer.parseInt(infoM.group(1)));
                        break;
                    default:
                        body += infoM.group(1);
                }       
               }else{
                    if(endingM.find()){
                        nuevo = false;
                        i=0;
                    }else{
                        body += line;
                    }
                }
            }
        }
        */
        return n;
    }
}
