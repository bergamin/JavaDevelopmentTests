/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Guilherme
 */
public class Product {
    
    private int id;
    private String name;
    private String description;

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setId(int id){
        this.id = id;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Product(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
}
