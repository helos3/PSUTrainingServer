package Application.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rushan on 12.02.2016.
 */
public interface MySQLQueries {
    public String toInsertQuery();
    public String toUpdateQuery();
    public String toDeleteQuery();
    public String toSelectQuery();
}
