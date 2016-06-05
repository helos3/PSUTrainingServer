package Application.controller.rest;

import Application.model.entities.*;
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
public class SubdivisionRest {

    @Resource(name = "subdivisionServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/subdivision", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<Subdivision> subdivisions = service.getAll();
        mapper.writeValue(out, subdivisions);
        final byte[] data = out.toByteArray();
        return new String(data);

    }

    @RequestMapping(value = "/subdivision/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        Subdivision subdivision = (Subdivision) service.find(id);
        if (subdivision == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(subdivision);
        return result;
    }

    @RequestMapping(value = "/subdivision", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String putSingle(@RequestBody String body,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            Subdivision subdivision= new ObjectMapper().reader(Subdivision.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(subdivision));
        }
        return result.toJSONString();
    }


    @RequestMapping(value = "/subdivision/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        Subdivision subdivision = (Subdivision) service.find(id);
        if (subdivision == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            service.remove(id);
    }
}