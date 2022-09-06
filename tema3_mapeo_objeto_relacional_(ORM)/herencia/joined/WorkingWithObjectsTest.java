package teis.dual.hibernate.herencia.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

//import junit.framework.JUnit4TestAdapter;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
/*
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import teis.dual.hibernate.herencia.single.Developer;
import teis.dual.hibernate.herencia.single.Employee;
import teis.dual.hibernate.herencia.single.HibernateUtil;
import teis.dual.hibernate.herencia.single.Technician;
*?
/**
 */
public class WorkingWithObjectsTest {

	//private static Log log = LogFactory.getLog(WorkingWithObjectsTest.class);

	/**
	 * Guarda la SessionFactory que se reutiliza por todos los threads.
	 * Es como si estuviera guardado a nivel de aplicación.
	 */
	private static SessionFactory sessionFactory = null;
	
	/**
	 * La Session para acceder a Hibernate. Se abrira y se cerrará una en cada test.
	 */
	private static Session session = null;

	/**
	 * La transacción donde se ejecutarán las operaciones contra Hibernate.
	 * 
	 * ¡¡¡ Siempre se deben hacer todas las operaciones dentro de una transacción. !!!
	 */
	private static Transaction tx = null;
	
	
	/**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        //junit.textui.TestRunner.run(suite());
    	sessionFactory = HibernateUtil.buildAnnotationSessionFactory();
    	
session = sessionFactory.openSession();
		
		tx = session.beginTransaction();
    	addEmployee();
    	
	tx.commit();
		
		session.close();
    }

    /**
     * Este método determina los métodos que se van a ejecutar con el test.
     *
     * @return el conjutno de test que hay que ejecutar.
     */
	/*public static junit.framework.Test suite() {
		final junit.framework.Test suite = new JUnit4TestAdapter(WorkingWithObjectsTest.class);
		return suite;
	}
	*/
	
	/**
	 * Se ejecuta una unica vez antes de todos los test.
	 * Haremos tareas de inicialización y crearemos objetos en el "contexto de aplicación".
	 */
    /*
	@BeforeClass
	public static void beforeAllTests() {
		sessionFactory = HibernateUtil.buildAnnotationSessionFactory();
	}
	
	@Before
	public void beforeTest() {
		session = sessionFactory.openSession();
		
		tx = session.beginTransaction();
	}
	
	@After
	public void afterTest() {
		tx.commit();
		
		session.close();
	}
	*/
	//@Test
	public static void addEmployee() {
		//log.info("\n\n*** addEmployee ***\n");
		System.out.println("\n\n*** addEmployee ***\n");
		
		try {
			Employee employee = new Employee("yo mismo");
			
			try {
				session.persist(employee);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			//log.debug("La clave del nuevo objeto es: " + employee.getId());
			System.out.println("La clave del nuevo objeto es: " + employee.getId());
			
			Technician technician = new Technician();
			technician.setName("Yo soy el tecnico!!!");
			technician.setExperienceYears(24);
			session.save(technician);
			//log.debug("La clave del nuevo objeto es: " + technician.getId());
			System.out.println("La clave del nuevo objeto es: " + technician.getId());
			
			Developer developer = new Developer();
			developer.setName("Yo soy el desarrollador!!!");
			developer.setExperienceYears(14);
			developer.setExpertLanguajes("Java");
			session.save(developer);
			//log.debug("La clave del nuevo objeto es: " + developer.getId());
			System.out.println("La clave del nuevo objeto es: " + developer.getId());
		
		} catch (Exception e) {
			//log.error(e);
			System.out.println(e);
		}
	}
}
