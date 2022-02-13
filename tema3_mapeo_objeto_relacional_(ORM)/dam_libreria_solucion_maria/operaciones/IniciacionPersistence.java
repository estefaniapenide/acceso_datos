package teis.dam.operaciones;

import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import teis.dam.modelo.Autor;
import teis.dam.modelo.Libro;

public class IniciacionPersistence {
	// loads configuration and mappings
    private static EntityManager manager;
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
		
    public static void main(String args[]){
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
      
        Autor autor1 = new Autor("autor3","italy");
        System.out.println("autor1 "+autor1.getId());
        
        Autor autor2 = new Autor("autor4","uk");
        System.out.println("autor2 "+autor2.getId());

        Libro libro1 = new Libro("TituloLibro3",34.4f);
        System.out.println("Libro1 "+libro1.getCodigo());
        
        Libro libro2 = new Libro("TituloLibro4",12.3f);
        System.out.println("Libro2 "+libro2.getCodigo());

        autor1.addLibro(libro1);
        autor1.addLibro(libro2);

        autor2.addLibro(libro1);

        libro1.addAutor(autor1);
        libro2.addAutor(autor1);
        
        libro1.addAutor(autor2);

        manager.persist(autor1);
        manager.persist(autor2);

        manager.getTransaction().commit();
        manager.close();		

        }
}
