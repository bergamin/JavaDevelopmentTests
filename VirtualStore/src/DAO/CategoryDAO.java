package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class CategoryDAO {
    
    private Connection connection;

    public CategoryDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Category> list() throws SQLException {
        String sql = "SELECT * FROM Category";
        List<Category> categories = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.execute();
            createCategoriesFromSearchResult(statement, categories);
        }
        return categories;
    }

    public List<Category> listWithProducts() throws SQLException {
        String sql = "SELECT C.id          AS c_id"
                 + "\n      ,C.name        AS c_name"
                 + "\n      ,P.id          AS p_id"
                 + "\n      ,P.name        AS p_name"
                 + "\n      ,P.description AS p_description"
                 + "\n  FROM Category C"
                 + "\n INNER JOIN Product P"
                 + "\n    ON P.category_id = C.id"
                 + "\n ORDER BY C.id";
        List<Category> categories = new ArrayList<>();
        Category lastCategory = null;
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.execute();
            try(ResultSet resultSet = statement.getResultSet()){
                resultSet.beforeFirst();
                while(resultSet.next()){
                    
                    int c_id = resultSet.getInt("c_id");
                    String c_name = resultSet.getString("c_name");
                    int p_id = resultSet.getInt("p_id");
                    String p_name = resultSet.getString("p_name");
                    String p_description = resultSet.getString("p_description");
                    
                    if(lastCategory == null || lastCategory.getId() != c_id){
                        Category category = new Category(c_id,c_name);
                        categories.add(category);
                        lastCategory = category;
                    }
                    Product product = new Product(p_id,p_name,p_description);
                    lastCategory.add(product);
                }
            }
        }
        return categories;
    }
    
    private void createCategoriesFromSearchResult(PreparedStatement statement, List<Category> categories) throws SQLException{
        try(ResultSet resultSet = statement.getResultSet()){
            resultSet.beforeFirst();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id,name);
                categories.add(category);
            }
        }
    }
}
