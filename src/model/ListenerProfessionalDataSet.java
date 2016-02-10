package model;

/**
 * Created by Rushan on 10.02.2016.
 */
public class ListenerProfessionalDataSet {
    private String academicRank, academicDegree, subdivision, position;

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAcademicRank() {

        return academicRank;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public String getPosition() {
        return position;
    }

    public ListenerProfessionalDataSet(String academicRank, String academicDegree, String subdivision, String position) {

        this.academicRank = academicRank;
        this.academicDegree = academicDegree;
        this.subdivision = subdivision;
        this.position = position;
    }


}
