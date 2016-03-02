package Application.controller.api;

import Application.Application;
import Application.model.*;
import Application.utils.AbstractEntity;
import Application.utils.MysqlUtils;
import Application.utils.TableNames;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rushan on 11.02.2016.
 */
@RestController
public class DataController {

    @RequestMapping(value = "/data/{tablename}", method = RequestMethod.GET)
    public String getAll(@PathVariable(value = "tablename") final String tableName) throws SQLException {
        Connection connection = Application.connectionPool.retrieve();
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
        for (AbstractEntity entity : entities) {
            array.add(entity.toJSON());
        }
        return array.toString();
    }

    @RequestMapping(value = "/data/{tablename}", method = RequestMethod.PUT)
    public String add(@PathVariable(value = "tablename") final String tableName,
                      @RequestBody String json) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
        AbstractEntity entity = EntityFactory.createEntity(tableName);
        entity.fromJSON(jsonObject);
        MysqlUtils.executeUpdateQuery(connection, entity.toInsertQuery());
        return null;
    }

    @RequestMapping(value = "/data/{tablename}", method = RequestMethod.POST)
    public String updateAll(@PathVariable(value = "tablename") final String tableName,
                      @RequestBody String json) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
        //TODO: придумать что-нибудь с этим методом
//        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
//        AbstractEntity entity = EntityFactory.createEntity(tableName);
//        entity.fromJSON(jsonObject);
//        MysqlUtils.executeUpdateQuery(connection, entity.toInsertQuery());
        return null;
    }

    @RequestMapping(value = "/data/{tablename}", method = RequestMethod.DELETE)
    public String deleteAll(@PathVariable(value = "tablename") final String tableName,
                      @RequestBody String json) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
//        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
//        AbstractEntity entity = EntityFactory.createEntity(tableName);
//        entity.fromJSON(jsonObject);
        MysqlUtils.executeUpdateQuery(connection, "DELETE * FROM " + tableName);
        return null;
    }

    @RequestMapping(value = "/data/{tablename}/{id}", method = RequestMethod.DELETE)
    public String deleteSingle(@PathVariable(value = "tablename") final String tableName,
                               @PathVariable(value = "id") final String id,
                            @RequestBody String json) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
        AbstractEntity entity = EntityFactory.createEntity(tableName);
        entity.fromJSON(jsonObject);
        MysqlUtils.executeUpdateQuery(connection, entity.toDeleteQuery());
        return null;
    }

    @RequestMapping(value = "/data/{tablename}/{id}", method = RequestMethod.POST)
    public String updateSingle(@PathVariable(value = "tablename") final String tableName,
                               @PathVariable(value = "id") final String id,
                               @RequestBody String json) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
        AbstractEntity entity = EntityFactory.createEntity(tableName);
        entity.fromJSON(jsonObject);
        MysqlUtils.executeUpdateQuery(connection, entity.toUpdateQuery());
        return null;
    }


    @RequestMapping(value = "/data/{tablename}/{id}", method = RequestMethod.GET)
    public String getSingle(@PathVariable(value = "tablename") final String tableName,
                            @PathVariable(value = "id") final String id) throws SQLException {
        Connection connection = Application.connectionPool.retrieve();
        AbstractEntity entity = EntityFactory.createEntity(tableName);
        entity.setID(Integer.parseInt(id));

        switch (tableName) {
            case TableNames.LISTENER:
                entity = selectListener(connection, Integer.parseInt(id));
                break;
            case TableNames.CONTRACT:
                entity = selectContract(connection, Integer.parseInt(id));
                break;
            case TableNames.GRADUATE:
                entity = selectGraduate(connection, Integer.parseInt(id));
                break;
            case TableNames.TRAINING_PROGRAM:
                entity = selectProgram(connection, Integer.parseInt(id));
                break;
        }

        if (tableName.equals(TableNames.ACADEMIC_DEGREE) ||
                tableName.equals(TableNames.ACADEMIC_RANK) ||
                tableName.equals(TableNames.POSITION) ||
                tableName.equals(TableNames.SUBDIVISION) ||
                tableName.equals(TableNames.ACADEMIC_DEGREE) ||
                tableName.equals(TableNames.CONTRACT_STATUS) ||
                tableName.equals(TableNames.MODULE)) {
            entity = new BaseCategoryEntity(tableName);
            entity.setID(Integer.parseInt(id));
            ResultSet rs = MysqlUtils.executeSelectQuery(connection, entity.toSelectQuery());
            rs.next();
            entity = new BaseCategoryEntity(tableName) {{
                fromSelectQuery(rs);
            }};
        }
        return entity.toJSON().toString();
    }

    private Listener selectListener(Connection connection, int ID) throws SQLException {
        Listener listener = new Listener();
        listener.setID(ID);
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, listener.toSelectQuery());
        rs.next();
        listener = Listener.fromSelectQuery(rs);
        listener.getContractsFromDB(connection);
        ArrayList<Contract> contracts = listener.getContracts();
        for (Contract contract : contracts) {
            contract.getGraduateFromDB(connection);
        }
        listener.setContracts(contracts);
        return listener;
    }

    private Contract selectContract(Connection connection, int ID) throws SQLException {
        Contract contract = new Contract();
        contract.setID(ID);
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, contract.toSelectQuery());
        rs.next();
        contract = Contract.fromSelectQuery(rs);
        contract.getGraduateFromDB(connection);
        return contract;
    }

    private Graduate selectGraduate(Connection connection, int ID) throws SQLException {
        Graduate graduate = new Graduate();
        graduate.setID(ID);
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, graduate.toSelectQuery());
        rs.next();
        graduate = Graduate.fromSelectQuery(rs);
        return graduate;

    }

    private TrainingProgram selectProgram(Connection connection, int ID) throws SQLException {
        TrainingProgram trainingProgram = new TrainingProgram();
        trainingProgram.setID(ID);
        ResultSet rs = MysqlUtils.executeSelectQuery(connection, trainingProgram.toSelectQuery());
        rs.next();
        trainingProgram = TrainingProgram.fromSelectQuery(rs);
        trainingProgram.getModulesFromDB(connection);
        return trainingProgram;
    }




}
