package Application.model;

import Application.utils.AbstractEntity;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 18.02.2016.
 */
public class ListenerTest {

    @Test
    public void testGetValuesFromDB() throws Exception {
        Connection connection = null;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=rushan196654rZ");
        } catch (Exception e) {
        }

        ArrayList<Listener> listeners = Listener.getValuesFromDB(connection);
        for(Listener listener: listeners) {
            System.out.println(listener.toJSON());
        }
    }


}