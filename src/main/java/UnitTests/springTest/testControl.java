package UnitTests.springTest;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Rushan on 24.02.2016.
 */
@RestController
public class testControl {



    @RequestMapping(value = "/logs", method = RequestMethod.POST)
    public String abc(@RequestBody String json) {
        System.out.println("json = " + json);
        return null;
    }
}
