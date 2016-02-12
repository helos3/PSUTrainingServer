package Application.model;

import java.sql.ResultSet;

import java.util.HashMap;

/**
 * Created by Rushan on 11.02.2016.
 */
public class ListenerProfessionalData {
    private HashMap<Integer, String> academicRank;
    private HashMap<Integer, String> academicDegree;
    private HashMap<Integer, String> subdivision;
    private HashMap<Integer, String> position;

    public void setAcademicRank(HashMap<Integer, String> academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicDegree(HashMap<Integer, String> academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setSubdivision(HashMap<Integer, String> subdivision) {
        this.subdivision = subdivision;
    }

    public void setPosition(HashMap<Integer, String> position) {
        this.position = position;
    }

    public HashMap<Integer, String> getAcademicRank() {

        return academicRank;
    }

    public HashMap<Integer, String> getAcademicDegree() {
        return academicDegree;
    }

    public HashMap<Integer, String> getSubdivision() {
        return subdivision;
    }

    public HashMap<Integer, String> getPosition() {
        return position;
    }

    public void fillWithDataBaseData(ResultSet academicRankRS, ResultSet academicDegreeRS, ResultSet subdivisionRS, ResultSet positionRS) {

    }

    public ListenerProfessionalData() {

    }
}
