
import model.Category;
import DAO.CategoryDAO;
import DAO.ProductDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
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
public class Tests {
    public static void main(String[] args) throws SQLException{
        try(Connection connection = new ConnectionPool().getConnection()){
            List<Category> categories = new CategoryDAO(connection).listWithProducts();
            for(Category category : categories){
                for(Product product : category.getProducts()){
                    System.out.println(category.getName() + " | " + product.getName());
                }
            }
        }
    }
    private void dataBaseExecution() throws SQLException{
        Product table = new Product("Blue table","Table with 4 legs");
        try(Connection connection = new ConnectionPool().getConnection()) {
            connection.setAutoCommit(false);
            try{
                ProductDAO dao = new ProductDAO(connection);
                dao.insert(table);
                connection.commit();
                List<Product> products = dao.list();
                for(Product product:products){
                    System.out.println(product);
                }
            }catch(Exception e){
                System.err.println("There was an error and no statement was commited into the database");
                connection.rollback();
            }
        }
        
    }
}
