package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class ProductDAO {
    
    private Connection connection;
    
    public ProductDAO(Connection connection){
        this.connection = connection;
    }
    public void insert(Product product) throws SQLException{
        String sql = "insert into product (name,description) values (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS) // for returning the id in case of an insert
        ) {
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.execute();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                resultSet.first();
                product.setId(resultSet.getInt("GENERATED_KEY"));
            }
        }
    }

    public List<Product> list() throws SQLException {
        String sql = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.execute();
            createProductsFromSearchResult(statement,products);
        }
        return products;
    }

    public Iterable<Product> list(Category category) throws SQLException {
        String sql = "SELECT * FROM Product WHERE category_id = ?";
        List<Product> products = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, category.getId());
            statement.execute();
            createProductsFromSearchResult(statement,products);
        }
        return products;
    }

    private void createProductsFromSearchResult(PreparedStatement statement, List<Product> products) throws SQLException {
        try(ResultSet resultSet = statement.getResultSet()){
            resultSet.beforeFirst();
            while(resultSet.next()){
                Product product = new Product(resultSet.getString("name"),resultSet.getString("description"));
                product.setId(resultSet.getInt("id"));
                products.add(product);
            }
        }
    }
}
