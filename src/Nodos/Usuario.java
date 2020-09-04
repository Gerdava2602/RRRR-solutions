/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import Atributos.Company;
import Atributos.Direccion;
import java.util.ArrayList;

/**
 *
 * @author German David
 */
public class Usuario extends Nodo{
    
    int id;
    String name;
    String username;
    String email;
    String phone;
    String website;
    Company company;
    Direccion direccion;
    
    public Usuario() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    

    public ArrayList getPosts() {
        return hijos;
    }

    public void createAddress() {
            this.direccion = new Direccion();
        
    }

    public void createCompany() {
            company = new Company();
        
    }
    
    

    
}
