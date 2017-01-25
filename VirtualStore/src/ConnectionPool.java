
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guilherme
 */
public class ConnectionPool {
    
    private DataSource dataSource;
    
    public ConnectionPool(){
        MysqlDataSource pool = new MysqlDataSource();
        pool.setUrl("jdbc:mysql://localhost/virtualstore");
        pool.setUser("root");
        pool.setPassword("root");
        this.dataSource = pool;
    }
    
    Connection getConnection() throws SQLException{
//        return DriverManager.getConnection("jdbc:mysql://localhost/virtualstore", "root", "root");
        return dataSource.getConnection();
    }
}
