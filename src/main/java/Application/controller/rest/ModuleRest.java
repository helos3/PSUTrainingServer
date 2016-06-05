package Application.controller.rest;

import Application.model.entities.AcademicDegree;
import Application.model.entities.Listener;
import Application.model.entities.Module;
import Application.model.entities.TrainingProgram;
import Application.model.services.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
public class ModuleRest {

    @Resource(name = "moduleServiceImpl")
    AbstractService service;

    @RequestMapping(value = "/module", method = RequestMethod.GET, produces = "application/json")
    public String getAll(HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final ObjectMapper mapper = new ObjectMapper();
        List<Module> modules = service.getAll();
        mapper.writeValue(out, modules);
        final byte[] data = out.toByteArray();
        return new String(data);
    }

    @RequestMapping(value = "/module/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getSingle(@PathVariable int id,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        String result = "";
        Module module = (Module) service.find(id);
        if (module == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            result = new ObjectMapper().writeValueAsString(module);
        return result;
    }

    @RequestMapping(value = "/module", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String putSingle(@RequestBody String body,
                            HttpServletRequest request,
                            HttpServletResponse response) throws Exception {
        JSONObject result = new JSONObject();
        if (body == null || "".equals(body))
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else {
            Module module = new ObjectMapper().reader(Module.class).readValue(body);
            result.put("entity_id", service.saveOrUpdate(module));
        }
        return result.toJSONString();
    }


    @RequestMapping(value = "/module/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteSingle(@PathVariable int id,
                             HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        Module module = (Module) service.find(id);
        if (module == null)
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        else
            service.remove(id);
    }
}