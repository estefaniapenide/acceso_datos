package ejemplo01;

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
            System.out.println("----------- Uso de list() -----------");
            List<Profesor> profesores= session.createQuery("SELECT p FROM Profesor p").list();

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        
        {
            System.out.println("----------- Uso de list() con datos escalares -----------");
            List<Object[]> listDatos = session.createQuery("SELECT p.id,p.nombre FROM Profesor p").list();

            for (Object[] datos : listDatos) {
                System.out.println(datos[0] + "--" + datos[1]);
            }
        }        
        
        {
            System.out.println("----------- Uso de list() con un único dato escalar -----------");
            List<Object[]> listDatos = session.createQuery("SELECT p.nombre FROM Profesor p").list();
           
            for (Object datos : listDatos) {
                System.out.println(datos);
            }
        }         
        
        
        {
            System.out.println("----------- Uso de uniqueResult -----------");
            Profesor profesor = (Profesor) session.createQuery("SELECT p FROM Profesor p WHERE id=101").uniqueResult();
            System.out.println("Profesor con Id 101=" + profesor.getNombre());
        }


        {
            System.out.println("----------- Mostrar una página -----------");
            int tamanyoPagina = 10;
            int paginaAMostrar = 7;

            Query query = session.createQuery("SELECT p FROM Profesor p Order By p.id");
            query.setMaxResults(tamanyoPagina);
            query.setFirstResult(paginaAMostrar * tamanyoPagina);
            List<Profesor> profesores = query.list();

            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        {
            System.out.println("----------- Calcular el nº de páginas -----------");
            int tamanyoPagina = 10;
            long numTotalObjetos = (Long) session.createQuery("SELECT count(*) FROM Profesor p").uniqueResult();
            int numPaginas =(int) Math.ceil((double)numTotalObjetos / (double)tamanyoPagina);
            
            System.out.println("Nº de páginas="+numPaginas);
        }


        {
            System.out.println("----------- Consultas con nombre -----------");
            List<Profesor> profesores = session.getNamedQuery("findAllProfesores").list();
           
            for (Profesor profesor : profesores) {
                System.out.println(profesor.toString());
            }
        }

        
        session.close();

        sessionFactory.close();

    }
}
