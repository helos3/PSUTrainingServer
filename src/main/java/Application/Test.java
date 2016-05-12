package Application;

import Application.model.entities.AbstractEntity;
import Application.model.services.AbstractService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Rushan on 30.03.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "META-INF/spring_config.xml");
        AbstractService academicDegreeManager = (AbstractService) ctx.getBean("academicDegreeManagerImpl");
        List<AbstractEntity> degrees = academicDegreeManager.getAll();
        for (AbstractEntity degree: degrees) {
            System.out.println(degree.toJSON().toString());
        }

    }

}
