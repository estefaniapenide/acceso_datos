package ejemplo03;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

public class Main {
    
    public static void main(String[] args) {
        SessionFactory sessionFactory;

            //Configuration configuration = new Configuration();
//        configuration.configure();
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        
        //sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        sessionFactory = new Configuration().configure().buildSessionFactory();
	
        Session session = sessionFactory.openSession();

        {
            System.out.println("----------- Concatenación de Strings -----------");
            String nombre="ELISA";
            String ape1="AMADOR";
            String ape2="SERRA";

            List<Profesor> profesores= session.createQuery("SELECT p FROM Profesor p where nombre='" + nombre + "' AND  ape1='" + ape1 + "' AND  ape2='" + ape2 + "' ").list();
            
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }
        
        {
            System.out.println("----------- Parámetro posicional -----------");
            String nombre="ELISA";
            String ape1="AMADOR";
            String ape2="SERRA";

            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=?0 AND ape1=?1 AND ape2=?2");
            query.setString(0,nombre);
            query.setString(1,ape1);
            query.setString(2,ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }        

        {
            System.out.println("----------- Parámetro con nombre -----------");
            String nombre="ELISA";
            String ape1="AMADOR";
            String ape2="SERRA";

            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2");
            query.setString("nombre",nombre);
            query.setString("ape1",ape1);
            query.setString("ape2",ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }
        
        {
            System.out.println("----------- Uso de setParameter -----------");
            String nombre="ELISA";
            String ape1="AMADOR";
            String ape2="SERRA";

            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2");
            query.setParameter("nombre",nombre);
            query.setParameter("ape1",ape1);
            query.setParameter("ape2",ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }
        
        {
            System.out.println("----------- Parametros encadenados -----------");
            String nombre="ELISA";
            String ape1="AMADOR";
            String ape2="SERRA";

            Query query = session.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2")
                .setParameter("nombre",nombre)
                .setParameter("ape1",ape1)
                .setParameter("ape2",ape2);

            List<Profesor> profesores = query.list();
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }        
        
        
        session.close();


        sessionFactory.close();

    }
}
