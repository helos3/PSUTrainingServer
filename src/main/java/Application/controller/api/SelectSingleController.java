package Application.controller.api;

import Application.Application;
import Application.model.*;
import Application.utils.AbstractEntity;
import Application.utils.MysqlUtils;
import Application.utils.TableNames;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Rushan on 29.02.2016.
 */

//ЭТОТ КЛАСС ХУЙНЯ, НАДО ПО НОВОЙ
//@RestController
public class SelectSingleController {
    @RequestMapping(value = "/tables/{tableName}/{id}", method = RequestMethod.GET)
    public String selectCurrent(@PathVariable(value = "tableName") final String tableName,
                                @PathVariable(value = "id") final String id) throws Exception {
        Connection connection = Application.connectionPool.retrieve();
//        AbstractEntity entity;

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

    private String selectSingle(String id, Connection connection, String tableName) throws Exception{
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
