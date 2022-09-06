package teis.dual.hibernate.PK.Sequence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestSequenceStrategy {

    private static EntityManager manager;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String args[]){
            testSequenceKey();
    }
    
    public static void testSequenceKey() {
//            log.info("... testIdentityStrategy ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        AuthorSequence a = new AuthorSequence();
        a.setFirstName("Thorben");
        a.setLastName("Janssen");

//            log.info("Before persist");
        em.persist(a);
//            log.info("After persist");

        em.getTransaction().commit();
        em.close();
    }
}
