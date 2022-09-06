package teis.dual.hibernate.PK.Table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static teis.dual.hibernate.PK.Identity.TestIdentityStrategy.testIdentityStrategy;

public class TestTableStrategy {

    private static EntityManager manager;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String args[]){
        testTableStrategy();
    }
    
    public static void testTableStrategy() {
//		log.info("... testTableStrategy ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        AuthorTable a = new AuthorTable();
        a.setFirstName("Thorben");
        a.setLastName("Janssen");

//		log.info("Persist new AuthorTable entity.");
        em.persist(a);

        em.getTransaction().commit();
        em.close();
    }
}
