package model;

import javafx.util.Pair;

/**
 * Created by Rushan on 10.02.2016.
 */
public class ListenerProfessionalDataSet {
    private Pair<Integer, String> academicRank;
    private Pair<Integer, String> academicDegree;
    private Pair<Integer, String> subdivision;
    private Pair<Integer, String> position;

    public ListenerProfessionalDataSet(Pair<Integer, String> academicRank, Pair<Integer, String> academicDegree, Pair<Integer, String> subdivision, Pair<Integer, String> position) {
        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.subdivision = subdivision;
        this.position = position;
    }

    public Pair<Integer, String> getPosition() {
        return position;
    }

    public Pair<Integer, String> getSubdivision() {
        return subdivision;
    }

    public Pair<Integer, String> getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicRank(Pair<Integer, String> academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicDegree(Pair<Integer, String> academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setSubdivision(Pair<Integer, String> subdivision) {
        this.subdivision = subdivision;
    }

    public void setPosition(Pair<Integer, String> position) {
        this.position = position;
    }

    public Pair<Integer, String> getAcademicRank() {
        return academicRank;
    }




}
