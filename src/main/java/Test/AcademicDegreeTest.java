package Test;

import Application.model.entities.AcademicDegree;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rushan on 17.05.2016.
 */
public class AcademicDegreeTest {

    @Test
    public void toJSONJacksonTest() throws JsonProcessingException {
        AcademicDegree degree = new AcademicDegree(){{
            setId(1);
            setName("name");
        }};
        System.out.println(new ObjectMapper().writeValueAsString(degree));
    }

}