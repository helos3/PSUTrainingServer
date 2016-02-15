package Application.model;

import Application.utils.JSONAble;
import javafx.util.Pair;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rushan on 10.02.2016.
 */
public class ListenerProfessionalDataSet implements JSONAble {

    private CategoryFactory.Subdivision subdivision;
    private CategoryFactory.Position position;
    private CategoryFactory.AcademicDegree academicDegree;
    private CategoryFactory.AcademicRank academicRank;

    public ListenerProfessionalDataSet(CategoryFactory.Subdivision subdivision, CategoryFactory.Position position, CategoryFactory.AcademicDegree academicDegree, CategoryFactory.AcademicRank academicRank) {
        this.subdivision = subdivision;
        this.position = position;
        this.academicDegree = academicDegree;
        this.academicRank = academicRank;
    }

    public void setSubdivision(CategoryFactory.Subdivision subdivision) {
        this.subdivision = subdivision;
    }

    public void setPosition(CategoryFactory.Position position) {
        this.position = position;
    }

    public void setAcademicDegree(CategoryFactory.AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public void setAcademicRank(CategoryFactory.AcademicRank academicRank) {
        this.academicRank = academicRank;
    }

    public ListenerProfessionalDataSet() {
        CategoryFactory factory = new CategoryFactory();
        subdivision = factory.subdivisionCreate();
        position = factory.positionCreate();
        academicRank = factory.academicRankCreate();
        academicDegree = factory.academicDegreeCreate();
    }

    public CategoryFactory.Subdivision getSubdivision() {
        return subdivision;

    }

    public CategoryFactory.Position getPosition() {
        return position;
    }

    public CategoryFactory.AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public CategoryFactory.AcademicRank getAcademicRank() {
        return academicRank;
    }

    @Override
    public JSONObject toJSON(){
        JSONObject resultJSON = new JSONObject();
        resultJSON.put("subdivision", subdivision.toJSON());
        resultJSON.put("position", position.toJSON());
        resultJSON.put("academic_degree", academicDegree.toJSON());
        resultJSON.put("academic_rank", academicRank.toJSON());
        return resultJSON;
    }

    @Override
    public void fromJSON(JSONObject inputJSON) {
        subdivision.fromJSON((JSONObject) inputJSON.get("subdivision"));
        position.fromJSON((JSONObject) inputJSON.get("position"));
        academicDegree.fromJSON((JSONObject) inputJSON.get("academic_degree"));
        academicRank.fromJSON((JSONObject) inputJSON.get("academic_rank"));
    }
}
