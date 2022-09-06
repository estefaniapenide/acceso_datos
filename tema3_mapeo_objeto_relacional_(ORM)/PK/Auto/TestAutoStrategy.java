package teis.dual.hibernate.PK.Auto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static teis.dual.hibernate.PK.Identity.TestIdentityStrategy.testIdentityStrategy;

public class TestAutoStrategy {

        private static EntityManager manager;
        private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
    public static void main(String args[]){
            testAutoStrategy();
    }
    
    public static void testAutoStrategy() {
//            log.info("... testIdentityStrategy ...");

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            AuthorAuto a = new AuthorAuto();
            a.setFirstName("Thorben");
            a.setLastName("Janssen");

//            log.info("Before persist");
            em.persist(a);
//            log.info("After persist");

            em.getTransaction().commit();
            em.close();
    }
}
