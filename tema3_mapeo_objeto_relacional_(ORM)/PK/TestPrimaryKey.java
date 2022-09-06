package teis.dual.hibernate.PK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestPrimaryKey {

    private static EntityManager manager;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String args[]){
        testPrimaryKey();
    }

    public static void testPrimaryKey() {
        //log.info("... testPrimaryKey ...");

        System.out.println("... testPrimaryKey ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Author a = new Author();
        a.setId(1L);
        a.setFirstName("Thorben");
        a.setLastName("Janssen");

        System.out.println("Persist new Author entity.");
        //log.info("Persist new Author entity.");
        em.persist(a);

        System.out.println("Call flush");
        //log.info("Call flush");
        em.flush();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        a = em.find(Author.class, 1L);
        //Assert.assertEquals(new Long(1), a.getId());
        System.out.println(a.getId());

        em.getTransaction().commit();
        em.close();
    }
}
