package Application;

import Application.model.entities.AbstractEntity;
import Application.model.entities.AcademicDegree;
import Application.model.entities.Contract;
import Application.model.entities.Listener;
import Application.model.services.AbstractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Rushan on 30.03.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring_config.xml");
        AbstractService academicDegreeManager = (AbstractService) ctx.getBean("academicDegreeManagerImpl");
        List<AbstractEntity> degrees = academicDegreeManager.getAll();
        for (AbstractEntity degree: degrees) {
            String buf = new ObjectMapper().writeValueAsString(degree);
            System.out.println(buf);
            AcademicDegree degree1 = new ObjectMapper().reader(AcademicDegree.class)
                    .readValue(buf);
            System.out.println(degree1.toString() + "\n");
        }

        AbstractService contractManager = (AbstractService) ctx.getBean("contractManagerImpl");
        List<AbstractEntity> contracts = contractManager.getAll();
        for (AbstractEntity contract: contracts) {
            String buf = new ObjectMapper().writeValueAsString(contract);
            System.out.println(buf);
            Contract contract1 = new ObjectMapper().reader(Contract.class).readValue(buf);
            System.out.println(contract1.toString() + "\n");
        }

        AbstractService listenerManager = (AbstractService) ctx.getBean("listenerManagerImpl");
        List<AbstractEntity> listeners = listenerManager.getAll();
        for (AbstractEntity listener: listeners) {
            String buf = new ObjectMapper().writeValueAsString(listener);
            System.out.println(buf);
            Listener listener1 = new ObjectMapper().reader(Listener.class).readValue(buf);
            System.out.println(listener1.toString() + "\n");
        }



    }

}
