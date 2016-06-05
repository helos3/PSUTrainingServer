package Application.controller.rest;

import Application.model.entities.Listener;
import Application.model.entities.Module;
import Application.model.entities.Position;
import Application.model.entities.TrainingProgram;
import Application.model.services.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.annotations.Pos;
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
public class PositionRest {

    @Resource(name = "positionServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/position", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<Position> positions = service.getAll();
        mapper.writeValue(out, positions);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/position/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        Position position= (Position) service.find(id);
        if (position == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(position);
        return result;
    }

    @RequestMapping(value = "/position", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String putSingle(@RequestBody String body,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            Position position = new ObjectMapper().reader(Position.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(position));
        }
        return result.toJSONString();
    }


    @RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        Position position = (Position) service.find(id);
        if (position== null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            service.remove(id);
    }
}