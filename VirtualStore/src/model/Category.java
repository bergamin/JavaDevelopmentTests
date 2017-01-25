package model;

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class Category {
    
    private int id;
    private String name;
    private List<Product> products = new ArrayList<>();
    
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
    
}
