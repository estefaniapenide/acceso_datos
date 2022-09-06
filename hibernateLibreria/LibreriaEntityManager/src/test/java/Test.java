
import com.mycompany.libreriaentitymanager.Autor;
import com.mycompany.libreriaentitymanager.Libro;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
//import javax.persistence.PersistenceContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Coolbay
 */
public class Test {
  
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
      Scanner sn = new Scanner(System.in);   
      int opcion = 0;
      do {
        System.out.println("Bienvenido, que quieres hacer? \n"
                         + "1/ Crear datos \n"
                         + "2/ Mostar datos \n"
                         + "3/ Eliminar autor \n"
                         + "4/ Eliminar libro \n"
                         + "5/ Titulo del libro \n"
                         + "6/ Nombre del autor \n"
                         + "7/ Todos los libros \n"
                         + "8/ Todos los autores con sus libros \n"
                         + "9/ Salir");
        opcion = sn.nextInt();
        
            switch(opcion){
                case 1: crearDatos();break;
                case 2: imprimirporpantalla();break;
                case 3: removeautor();break;
                case 4: removelibro();break;
                case 5: titulodellibro();break;
                case 6: nombredelautor();break;
                case 7: todoloslibros();break;
                case 8: todoslosautoresylibros();break;
            }  
        }while(opcion !=9);
     
    }
    
    private static void crearDatos(){
        Scanner sn = new Scanner(System.in); 
        EntityManager em = emf.createEntityManager();
        //System.out.println("Dime un nombre");
        //String nombre = sn.next();
       em.getTransaction().begin();
       
        Autor autor1 = new Autor(1, "Diego Perez","VivaVigo");
        Autor autor2 = new Autor(2, "Sonsoles Mendez","Asturiana");
        Autor autor3 = new Autor(3, "Sam Perro","Ruso");
        em.persist(autor1);
        em.persist(autor2);
        em.persist(autor3);
        
        
        em.persist( new Libro(1, "La vida de la sonso",19.9f,autor2));
        em.persist( new Libro(2, "Crepusculo",10.5f,autor2));
        em.persist( new Libro(3, "El libro de Kayn",19.9f,autor1));
        em.persist( new Libro(4, "El Manual de Juego",30,autor1));
        em.persist( new Libro(5, "Harry Popotter",19.9f,autor3));

        em.getTransaction().commit();
        
        em.close();
 /*
        //otra manera seria crear el autor y el libro por separado sin asignar el autor al libro 
        //primero el libro
        em.getTransaction().begin();
        Libro libro1 = new Libro();
        libro1.setCodigo(6);
        libro1.setTitulo("Loquesea libros");
        em.persist(libro1);
        //ahora creamos el autor 
        
        Autor autor4 = new Autor(4, "Olalla Pérez","Matama");
        autor4.addlibro(libro1);
        System.out.println("La autor/a "+autor4.getNombre()+" ha escrito: "+ autor4.getLibros().size()+" libro "); 
        em.persist(autor4);
        em.getTransaction().commit();
        
        em.close();
 */
    }
    
    private static void imprimirporpantalla(){
        Scanner sn = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Que autor quieres ver? Introduce su id");
        int id_autor = sn.nextInt();
        Autor autores = em.find(Autor.class, id_autor);
        List<Libro> libros = autores.getLibros();
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
        
        em.close();//Si me sale el error de LazyInitialization es porque el close está mal puesto tiene que ponerse al final de toda la operacion incluyendo el sout 
        //otra opcion es cambiar el fetch de lazy a eager
    }
    @SuppressWarnings("unchecked")
    private static void todoloslibros(){
        
        EntityManager em = emf.createEntityManager();
        
        List<Libro> libros = em.createQuery("FROM Libro ").getResultList();
        for (int i = 0; i < libros.size(); i++) {
            System.out.println("Libro "+libros.get(i).toString());
        }
        em.close();
        
       
        
    }
    private static void titulodellibro(){
        Scanner sn = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Introduce el titulo del libro");
        String titulo = sn.nextLine();
        TypedQuery<Libro> libros = em.createQuery("SELECT lib FROM Libro lib WHERE lib.titulo = :titulo", Libro.class);
        libros.setParameter("titulo", titulo);
        Libro lib = libros.getSingleResult();
        
        System.out.println(lib.toString());
        
        em.close();
                
    }
    
    private static void nombredelautor(){
        Scanner sn = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        
        System.out.println("Introduce el nombre del autor");
        String nom = sn.nextLine();
        TypedQuery<Autor> a = em.createQuery("SELECT a1 FROM Autor a1 WHERE a1.nombre = :nombre", Autor.class);
        a.setParameter("nombre", nom);
        Autor a1 = a.getSingleResult();
        
        System.out.println(a1.getLibros());
        
        em.close();
                
    }
    
    
    private static void removeautor(){
        Scanner sn = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        System.out.println("Introduce el  codigo del autor que quieras borrar");
        int cod = sn.nextInt();
        em.getTransaction().begin();
        Autor a = em.find(Autor.class, cod);
        em.remove(a);
        em.getTransaction().commit();
        
        em.close();
        
    }

    private static void removelibro(){
        Scanner sn = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        System.out.println("Introduce el  codigo del libro que quieras borrar");
        int cod = sn.nextInt();
        em.getTransaction().begin();
        Libro lib = em.find(Libro.class, cod);
        em.remove(lib);
        em.getTransaction().commit();
        
        em.close();
        
    }

    private static void todoslosautoresylibros() {
        
        EntityManager em = emf.createEntityManager();
        
        List<Autor> a = em.createQuery("FROM Autor ").getResultList();
        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i).toString()+"Tiene los libros: "+a.get(i).getLibros());
        }
        em.close();
        
        
        
    }
    
    
    
}
