/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import java.util.ArrayList;

/**
 *
 * @author German David
 */
public class Nodo {
    
    ArrayList hijos;
    
    public Nodo(){    
        hijos = new ArrayList();
    }
    
    public void addHijo(Nodo hijo){
        hijos.add(hijo);
    }
    
    public Nodo findId(int id){
        Usuario hijoN;
        for (Object hijo : hijos) {
            hijoN = (Usuario)hijo;
            if(hijoN.getId()== id){
                return hijoN;
            }
        }
        return null;
    }
    
}
