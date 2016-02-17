package UnitTests;



import org.json.simple.JSONObject;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import static spark.Spark.*;

public class justTest {
    static Connection connection = null;

    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root&password=rushan196654rZ");
        } catch (Exception e) {
        }
        get("/hello", (req, res) -> "Hello World");
        get("/get_ranks", (req, res) -> {

            Statement stmt = null;
            ResultSet rs = null;

            JSONObject resultJson = new JSONObject();

            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT academic_degree.id,\n" +
                    "    academic_degree.name\n" +
                    "FROM mydb.academic_degree;\n");

            if (stmt.execute("SELECT academic_degree.id,\n" +
                    "    academic_degree.name\n" +
                    "FROM mydb.academic_degree;\n")) {
                rs = stmt.getResultSet();
            }
            while (rs.next()) {
                // Напечатать значения в текущей строке.
                resultJson.put(rs.getInt("academic_degree.id"), rs.getString("academic_degree.name"));
            }
            return resultJson;
        });

    }

}
