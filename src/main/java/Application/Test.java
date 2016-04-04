package Application;

import Application.model.ejb.AcademicDegreeContainer;
import Application.model.entities.AcademicDegree;
import Application.model.entities.Listener;
import org.springframework.boot.context.embedded.InitParameterConfiguringServletContextInitializer;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.spi.InitialContextFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by Rushan on 30.03.2016.
 */
public class Test {
    public static void main(String[] args) throws Exception{
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("listener");
//        EntityManager em = emf.createEntityManager();
        InitialContext cxt = new InitialContext();
        if (cxt == null) {
            throw new Exception("Uh oh -- no context!");
        }
        Context initialContext = new InitialContext();
        Context envContext  = (Context)initialContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/dsource");
//        DataSource ds = (DataSource) cxt.lookup("java:/comp/env/jdbc/dsource");

        if (ds == null) {
            throw new Exception("Data source not found!");
        }
//        try {
//            Context context = new InitialContext(env);
//            AcademicDegreeContainer container = (AcademicDegreeContainer) context.lookup("java:global/Application/model/ejb/AcademicDegree");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ArrayList<AcademicDegree> academicDegrees =
        System.out.println();
    }

}
