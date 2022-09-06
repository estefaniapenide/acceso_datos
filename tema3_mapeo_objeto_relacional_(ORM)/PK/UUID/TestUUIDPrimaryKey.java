package teis.dual.hibernate.PK.UUID;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static teis.dual.hibernate.PK.Table.TestTableStrategy.testTableStrategy;

public class TestUUIDPrimaryKey {

    private static EntityManager manager;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

    public static void main(String args[]){
        testUUIDPrimaryKeyV1();
        testUUIDPrimaryKeyV4();
    }
    
    public static void testUUIDPrimaryKeyV4() {
//		log.info("... testUUIDPrimaryKeyV4 ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        AuthorUUID a = new AuthorUUID();
        a.setFirstName("Thorben");
        a.setLastName("Janssen");

//		log.info("Persist new AuthorUUID entity.");
        em.persist(a);

//		log.info("Call flush");
        em.flush();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        UUID uuid = a.getId();

        a = em.find(AuthorUUID.class, uuid);
//		Assert.assertEquals(uuid, a.getId());

        em.getTransaction().commit();
        em.close();
    }

//	@Test
    public static void testUUIDPrimaryKeyV1() {
//		log.info("... testUUIDPrimaryKeyV1 ...");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book b = new Book();
        b.setTitle("Hibernate Tips");

//		log.info("Persist new Book entity.");
        em.persist(b);

//		log.info("Call flush");
        em.flush();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        UUID uuid = b.getId();

        b = em.find(Book.class, uuid);
//		Assert.assertEquals(uuid, b.getId());

        em.getTransaction().commit();
        em.close();
    }
}
