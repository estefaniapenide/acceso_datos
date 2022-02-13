
package ejemplo04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author mrnovoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory;

        //Configuration configuration = new Configuration();
//        configuration.configure();
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        
        //sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        sessionFactory = new Configuration().configure().buildSessionFactory();
                
        Profesor profesor=new Profesor("Pau", "Ayala", "Fuentes");
        
        Session session=sessionFactory.openSession();
        session.beginTransaction();

        session.save(profesor);

        session.getTransaction().commit();
        session.close();
                
    }
}
