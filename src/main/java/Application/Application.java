package Application;

import Application.utils.ConnectionPool;
import com.mysql.jdbc.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

/**
 * Created by Rushan on 25.02.2016.
 */
@SpringBootApplication
public class Application {
//    public static ConnectionPool connectionPool;
    public static void main(String[] args) throws SQLException{
//        Driver driver = new com.mysql.jdbc.Driver();
//        String url = "jdbc:mysql://127.0.0.1:3306/?user=testuser&password=testuser12345";
//        connectionPool = new ConnectionPool(url, driver, 5);

        SpringApplication.run(Application.class, args);
    }
}
