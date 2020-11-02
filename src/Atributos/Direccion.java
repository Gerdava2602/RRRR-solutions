/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;


public class Direccion {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
    
    /**
     * Constructor de direccion
     * @param street street
     * @param suite suite
     * @param city city
     * @param zipcode zip
     * @param geo geo
     */
    public Direccion(String street, String suite, String city, String zipcode, Geo geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public Direccion() {
        geo = new Geo();
    }
    
    /**
     * Constructor de direccion mas especifico
     * @param street street
     * @param suite suite
     * @param city city
     * @param zipcode zipcode
     * @param lat latitud
     * @param lng longitud
     */
    public Direccion(String street, String suite, String city, String zipcode, String lat, String lng) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        geo = new Geo(lat,lng);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dirección: "+"\n");
        sb.append(" street: "+street+"\n");
        sb.append(" suite: "+suite+"\n");
        sb.append(" city: "+city+"\n");
        sb.append(" zipcode: "+zipcode+"\n");
        sb.append(" "+geo.toString());
        
        return sb.toString();
    }
    
    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void createGeo() {
        this.geo = new Geo();
    }
    
    /**
     * Metodo que se utiliza para serializar
     * @return El string de el objeto serializado
     */
    public String getSerialData() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.street).append(",").append(this.suite).append(",").append(this.city).append(",").append(this.zipcode).append("\n").append(this.geo.getSerialData());
        return sb.toString();
    }
    
    
}
