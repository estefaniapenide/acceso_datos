package gal.mrnovoa.hibernate.tests;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import gal.mrnovoa.hibernate.modelo.Autor;
import gal.mrnovoa.hibernate.modelo.Libro;

public class TestAutores {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		crearDatos();
		imprimirDatos();
	}
	

	private static void crearDatos() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		/*
		Autor autor1 = new Autor (1L, "Pablo Pérez", "Española");
		Autor autor2 = new Autor (2L, "Elena Gómez", "Mexicana");
		Autor autor3 = new Autor (3L, "Miguel López", "Chilena");
		
		em.persist(autor1);
		em.persist(autor2);
		em.persist(autor3);
		
		em.persist( new Libro (1L, "Programar en Java es fácil", autor2));
		em.persist( new Libro (2L, "Cómo vestirse con estilo", autor3));
		em.persist( new Libro (3L, "Cómo cocinar sin quemar la cocina", autor1));
		em.persist( new Libro (4L, "Programar en Cobol es divertido", autor2));
		em.persist( new Libro (5L, "Programar en Cobol no es divertido", autor2));	
		*/
		
		//prueba Fallo de NO Fijar Relaciones
		
		Libro l1 = new Libro();
		l1.setId(1L);
		l1.setTitulo("JPA e Hibernate");
		em.persist(l1);
		
		Autor a1 = new Autor(1L, "Dani", "Española");
		//a1.setLibros(Arrays.asList(l1));
		a1.addLibro(l1);
		
		System.out.println("Libros escritos (pre-save): " +a1.getLibros().size());
		em.persist(a1);
		
		em.getTransaction().commit();
		
		em.close();
		
	}

	private static void imprimirDatos() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		Autor autor = em.find(Autor.class, 1L);
		List<Libro> libros = autor.getLibros();
		
		//libros.size();//activar de nuevo, para que el Lazy se espabile
		//em.close();
		
		System.out.println("Libros escritos (post-sabe)"+libros.size());
		for (Libro libro:libros) {
			System.out.println("*"+libro.toString());
		}
		
		//System.out.println(autor);
		
		em.close();
	}

}
