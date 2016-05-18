package Application.controller.rest;

import Application.model.entities.AcademicDegree;
import Application.model.entities.AcademicRank;
import Application.model.entities.TrainingProgram;
import Application.model.services.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Rushan on 12.05.2016.
 */
@RestController
@RequestMapping("/data")
public class AcademicRankRest {

    @Resource(name = "academicRankServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/academic_rank", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<AcademicRank> ranks = service.getAll();
        mapper.writeValue(out, ranks);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/academic_rank/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        AcademicRank rank = (AcademicRank) service.find(id);
        if (rank == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(rank);
        return result;
    }

    @RequestMapping(value = "/academic_rank", method = RequestMethod.PUT)
    @ResponseBody
    public String putSingle(@RequestBody String body,
                          HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            AcademicRank rank = new ObjectMapper().reader(AcademicRank.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(rank));
        }
        return result.toJSONString();
    }

    @RequestMapping(value = "/academic_rank/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@RequestBody String body,
                             @PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        AcademicRank rank = (AcademicRank) service.find(id);
        if (rank == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else

            service.remove(id);
    }


}
