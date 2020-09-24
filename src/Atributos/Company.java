/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Atributos;

/**
 *  Se crea el objeto Company al cual se le atribuye la información extraída del JSON. 
 * 
 */
public class Company {
    String name;
    String catchPhrase;
    String bs;
    /**
     * Constructor de la clase Company
     * @param name de la compañia
     * @param catchPhrase de la compañia
     * @param bs de la compañia
     */
    public Company(String name, String catchPhrase, String bs) {
        this.name= name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public Company() {
    }
    /**
     * Se sobre escribe el método toString, para escribir la información de la compañia.
     * @return 
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Company: "+"\n");
        sb.append(" name: "+name+"\n");
        sb.append(" catchPhrase: "+catchPhrase+"\n");
        sb.append(" bs: "+bs+"\n");
        return sb.toString();
    }
    /**
     * Getters y setters
     * @return 
     */
    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
    
    
}
