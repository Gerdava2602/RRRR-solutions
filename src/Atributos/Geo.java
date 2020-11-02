/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;


public class Geo {
    String latitud;
    String longitud;
    
    /**
     * Constructor de Geo
     * @param latitud latitud
     * @param longitud longitud
     */
    public Geo(String latitud, String longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Geo() {
    }

    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" Geo: "+"\n");
        sb.append("     latitud:"+latitud+"\n");
        sb.append("     longitud:"+longitud+"\n");
        return sb.toString();
    }
    
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
    
    /**
     * Metodo que se utiliza para serializar
     * @return El string de el objeto serializado
     */
    public String getSerialData() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.latitud).append(",").append(this.longitud);
        return sb.toString();
    }
    
    
}
