package teis.dual.hibernate.herencia.perClass;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	//private static final Log log = LogFactory.getLog(HibernateUtil.class);
	

	public static SessionFactory buildAnnotationSessionFactory() {
		try {
			final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			
			return sessionFactory;
			
		} catch (Throwable e) {
			//log.fatal("It is not possible to build the SessionFactory", e);
			System.out.println("It is not possible to build the SessionFactory "+ e);
			throw new ExceptionInInitializerError(e);
		}
	}
}