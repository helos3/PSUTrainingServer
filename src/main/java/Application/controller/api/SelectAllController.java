package Application.controller.api;

import Application.Application;
import Application.model.*;
import Application.utils.AbstractEntity;
import Application.utils.MysqlUtils;
import Application.utils.TableNames;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Rushan on 29.02.2016.
 */
public class SelectAllController {
    @RequestMapping(value = "/{tableName}/all", method = RequestMethod.GET)
    public String updateTable(@PathVariable(value = "tableName") final String tableName) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<? extends AbstractEntity> entities = new ArrayList<>();

        switch (tableName) {
            case TableNames.LISTENER:
                entities = Listener.getValuesFromDB(connection);
                break;
            case TableNames.CONTRACT:
                entities = Contract.getValuesFromDB(connection);
                break;
            case TableNames.GRADUATE:
                entities = Graduate.getValuesFromDB(connection);
                break;
            case TableNames.TRAINING_PROGRAM:
                entities = TrainingProgram.getValuesFromDB(connection);
                break;
        }

        if (tableName.equals(TableNames.ACADEMIC_DEGREE) ||
                tableName.equals(TableNames.ACADEMIC_RANK) ||
                tableName.equals(TableNames.POSITION) ||
                tableName.equals(TableNames.SUBDIVISION) ||
                tableName.equals(TableNames.ACADEMIC_DEGREE) ||
                tableName.equals(TableNames.CONTRACT_STATUS) ||
                tableName.equals(TableNames.MODULE)) {
            BaseCategoryEntity entity = new BaseCategoryEntity(tableName);
            entities = entity.getValuesFromDB(connection);
        }
        for (AbstractEntity entity: entities) {
            array.add(entity.toJSON());
        }

        return array.toString();
    }
}
