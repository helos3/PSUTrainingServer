package Application.controller.api;

import Application.Application;
import Application.model.EntityFactory;
import Application.utils.AbstractEntity;
import Application.utils.MysqlUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;


/**
 * Created by Rushan on 25.02.2016.
 */
//@RestController
public class UpdateController {

    @RequestMapping(value = "/{tableName}/{action}", method = RequestMethod.POST)
    public String updateTable(@PathVariable(value = "tableName") final String tableName,
                      @PathVariable(value = "action") final String action,
                      @RequestBody String json) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
        AbstractEntity entity = EntityFactory.createEntity(tableName);
        entity.fromJSON(jsonObject);
        switch (action) {
            case "insert":
                MysqlUtils.executeUpdateQuery(connection, entity.toInsertQuery());
                break;
            case "update":
                MysqlUtils.executeUpdateQuery(connection, entity.toUpdateQuery());
                break;
            case "delete":
                MysqlUtils.executeUpdateQuery(connection, entity.toDeleteQuery());
                break;
        }
        return null;
    }
}
