package teis.dual.hibernate.PK.Identity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestIdentityStrategy {

	private static EntityManager manager;
        private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

        public static void main(String args[]){
            testIdentityStrategy();
    }

	public static void testIdentityStrategy() {
//		log.info("... testIdentityStrategy ...");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		AuthorIdentity a = new AuthorIdentity();
		a.setFirstName("Thorben");
		a.setLastName("Janssen");
		
//		log.info("Before persist");
		em.persist(a);
//		log.info("After persist");
		
		em.getTransaction().commit();
		em.close();
	}
}
