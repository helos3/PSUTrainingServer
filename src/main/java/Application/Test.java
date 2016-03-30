package Application;

import Application.model.entities.Listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;

/**
 * Created by Rushan on 30.03.2016.
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("listener");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery(Listener.QUERY_FIND_ALL, Listener.class);
        ArrayList<Listener> listeners = (ArrayList<Listener>) query.getResultList();

        System.out.println();

    }

}
