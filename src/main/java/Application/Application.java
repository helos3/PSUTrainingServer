package Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.sql.SQLException;

/**
 * Created by Rushan on 25.02.2016.
 */
@SpringBootApplication
@ImportResource("spring_config.xml")
public class Application {
    public static void main(String[] args) throws SQLException{

        SpringApplication.run(Application.class, args);
    }
}
