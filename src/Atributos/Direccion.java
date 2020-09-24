/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;

/**
 * Se crea el objeto/diccionario llamado direccion al cual se le atribuye la información extraída del JSON.
 * 
 */
public class Direccion {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
    /**
     * Se pasan por parametros en el constructor los atributos de la direccion.
     * @param street
     * @param suite
     * @param city
     * @param zipcode
     * @param geo 
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

    public Direccion(String street, String suite, String city, String zipcode, String lat, String lng) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        geo = new Geo(lat,lng);
    }
    /**
     * Se sobre escribe el método toString, para escribir la información de la dirección.
     * @return 
     */
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
    /**
     * Getters y setters
     * @return 
     */
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
    
    
    
}
