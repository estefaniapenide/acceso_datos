package gal.mrnovoa.hibernate.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import gal.mrnovoa.hibernate.modelo.Autor;
import gal.mrnovoa.hibernate.modelo.Comentario;
import gal.mrnovoa.hibernate.modelo.Libro;
import gal.mrnovoa.hibernate.modelo.Publicacion;
import gal.mrnovoa.hibernate.modelo.Usuario;

public class TestEjBlog_borradoUsuario {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insertar();
		imprimir();
		
		borrar(2L);
		
		imprimir();
		emf.close();

	}


	private static void borrar(long comentario) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();;
		
		Comentario c = em.find(Comentario.class, comentario);
		//opcion1
		//Publicacion pub = c.getPublicacion();
		//pub.eliminarComentario(c);
		//opcion2
		//em.remove(c);
		
		//OJO. El cascade funciona al elimnar padre-Publicacion, eliminando todos los comentarios asociados
		em.remove(c.getPublicacion());
		
		em.getTransaction().commit();
		em.close();
	}


	private static void insertar() {
		// TODO Auto-generated method stub
		Publicacion p = new Publicacion(1L, "Hoy hace sol");
		Comentario c1 = new Comentario (1L, "Aqui llueve");
		
		Comentario c2 = new Comentario(2L, "eres kk");
		p.insertarComentario(c1);
		p.insertarComentario(c2);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(p);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	private static void borrarUsuario() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Usuario u= em.find(Usuario.class, 1L);
		em.remove(u);
		
		em.getTransaction().commit();
		em.close();
	}


	private static void insertarUsuario() {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario(1L, "user");
		//Comentario c1 = new Comentario (1L, "Aqui llueve");
		
		//Comentario c2 = new Comentario(2L, "eres kk");
		//p.insertarComentario(c1);
		//p.insertarComentario(c2);
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(usuario);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	private static void imprimir() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		System.out.println("ENTRADAS DE BLOG");
		
		List<Publicacion> pubs = em.createQuery("FROM Publicacion").getResultList();
		
		if(pubs.isEmpty())
			System.out.println("Sin entradas");
		else System.out.println(pubs.size()+" entradas");
		
		for(Publicacion publi:pubs) {
		
			System.out.println("\nPublicacion: "+ publi.toString());
			if(publi.getComentarios().isEmpty())
				System.out.println("Sin comentarios");
			else {
				List<Comentario> comentarios = publi.getComentarios();
				
				System.out.println("Comentarios escritos (post-sabe)"+comentarios.size());
				for (Comentario c:comentarios) {
					System.out.println("*Comentario:"+c.toString());
				}
			}
		}
		
		em.close();
	}

}
