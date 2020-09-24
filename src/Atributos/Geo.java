/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;

/**
 * Se crea el objeto/diccionario Geo al cual se le atribuye la información extraída del JSON.
 * 
 */
public class Geo {
    String latitud;
    String longitud;
    /**
     * Se pasan por parámetros los atributos de Geo.
     * @param latitud
     * @param longitud 
     */
    public Geo(String latitud, String longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Geo() {
    }
    /**
     * Se sobre escribe el método toString, para escribir la información de la compañia.
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Geo: "+"\n");
        sb.append("     latitud:"+latitud+"\n");
        sb.append("     longitud:"+longitud+"\n");
        return sb.toString();
    }
    /**
     * Getters y setters
     * @return 
     */
    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    
}
