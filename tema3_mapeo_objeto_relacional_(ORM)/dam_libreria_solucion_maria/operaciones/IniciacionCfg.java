package teis.dam.operaciones;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import teis.dam.modelo.Autor;
import teis.dam.modelo.Libro;

public class IniciacionCfg {
	// loads configuration and mappings
    //c�digo deprecated
    public static void main(String args[]){
        Configuration configuration = new Configuration().configure();

        SessionFactory sessionFactory = configuration
        .buildSessionFactory();
        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //OPs
        ConsultaHQL(session);

        session.getTransaction().commit();
        session.close();		

        }
    
    public static void Inicializacion(Session session){
        Autor autor1 = new Autor("autor1","spain");
        System.out.println("autor1 "+autor1.getId());
        
        Autor autor2 = new Autor("autor2","france");
        System.out.println("autor2 "+autor2.getId());

        Libro libro1 = new Libro("TituloLibro1",34.4f);
        System.out.println("Libro1 "+libro1.getCodigo());
        
        Libro libro2 = new Libro("TituloLibro2",12.3f);
        System.out.println("Libro2 "+libro2.getCodigo());

        autor1.addLibro(libro1);
        autor1.addLibro(libro2);

        autor2.addLibro(libro1);

        libro1.addAutor(autor1);
        libro2.addAutor(autor1);
        
        libro1.addAutor(autor2);

        session.save(autor1);
        session.save(autor2);
    }
    
    public static void ConsultaHQL(Session session){
        //Streams Standard
        List<Libro> books = session.createQuery("SELECT b FROM Libro b", Libro.class).list();
        
        books.stream()
        .map(b -> b.getTitulo() + " de precio " + b.getPrecio())
        .forEach(m -> System.out.println(m));

        //Entities
//        Stream<Book> books = session.createQuery("SELECT b FROM Book b", Book.class).stream();
//books.map(b -> b.getTitle() + " was published on " + b.getPublishingDate())
//    .forEach(m -> log.info(m));

        //Scalar Values
//Stream<Object[]> books = session.createNativeQuery("SELECT b.title, b.publishingDate FROM book b").stream();
//books.map(b -> new BookValue((String)b[0], (Date)b[1]))
//    .map(b -> b.getTitle() + " was published on " + b.getPublishingDate())
//    .forEach(m -> log.info(m));

        //POJOS...bug (HHH-11029) in Hibernate 5.2.
        
//        Stream<BookValue> books = session.createQuery("SELECT new org.thoughts.on.java.model.BookValue(b.title, b.publishingDate) FROM Book b", BookValue.class).stream();
//books.map(b -> b.getTitle() + " was published on " + b.getPublishingDate())
//    .forEach(m -> log.info(m));

    }
}
