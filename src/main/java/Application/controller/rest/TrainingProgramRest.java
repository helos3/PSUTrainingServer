package Application.controller.rest;

import Application.model.entities.Listener;
import Application.model.entities.Subdivision;
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
import java.util.List;

/**
 * Created by Rushan on 15.05.2016.
 */
@RestController
@RequestMapping("/data")
public class TrainingProgramRest {

    @Resource(name = "trainingProgramServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/training_program", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<TrainingProgram> programs = service.getAll();
        mapper.writeValue(out, programs);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/training_program/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        TrainingProgram program = (TrainingProgram) service.find(id);
        if (program == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(program);
        return result;
    }

    @RequestMapping(value = "/training_program", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String putSingle(@RequestBody String body,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            TrainingProgram trainingProgram = new ObjectMapper().reader(TrainingProgram.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(trainingProgram));
        }
        return result.toJSONString();
    }


    @RequestMapping(value = "/training_program/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@RequestBody String body,
                             @PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        TrainingProgram program = (TrainingProgram) service.find(id);
        if (program == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            service.remove(id);

    }
}