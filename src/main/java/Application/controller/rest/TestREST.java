package Application.controller.rest;

import Application.model.entities.AcademicDegree;
import Application.model.services.AbstractService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rushan on 11.05.2016.
 */
@RestController
public class TestREST {

    @Autowired
    AbstractService academicDegreeManager;

    @RequestMapping(value = "/data/academic_degree", method = RequestMethod.GET)
    public String getAll() throws Exception {
        JSONObject result = new JSONObject();
        List<AcademicDegree> degrees =  academicDegreeManager.getAll();
        JSONArray degreesJSON = new JSONArray();
        for (AcademicDegree degree: degrees) {
            degreesJSON.add(degree.toJSON().toString());

        }
        result.put("academic degrees",degreesJSON);
        return result.toString();
    }

}
