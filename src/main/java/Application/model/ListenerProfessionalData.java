package Application.model;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Rushan on 11.02.2016.
 */
public class ListenerProfessionalData {

    //TODO: понять наконец, зачем я вообще создал этот класс
    private ArrayList<CategoryFactory.Subdivision> subdivisionList;
    private ArrayList<CategoryFactory.Position> positionList;
    private ArrayList<CategoryFactory.AcademicDegree> academicDegree;
    private ArrayList<CategoryFactory.AcademicRank> academicRank;

    public ListenerProfessionalData(ResultSet rsSubdivision, ResultSet rsPosition, ResultSet rsAcademicDegree, ResultSet rsAcademicRank)
            throws SQLException {
        CategoryFactory factory = new CategoryFactory();
        while (rsSubdivision.next()) {
            CategoryFactory.Subdivision subdivision = factory.subdivisionCreate();
            subdivision.setID(rsSubdivision.getInt("id"));
            subdivision.setName(rsSubdivision.getString("name"));
            subdivisionList.add(subdivision);
        }

    }
}
