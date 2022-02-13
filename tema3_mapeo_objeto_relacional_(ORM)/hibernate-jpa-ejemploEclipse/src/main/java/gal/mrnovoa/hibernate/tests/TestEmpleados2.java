package gal.mrnovoa.hibernate.tests;

import java.time.LocalDate;
import java.time.Month;
//import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OneToOne;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
import javax.persistence.Persistence;

import gal.mrnovoa.hibernate.modelo.Direccion;
import gal.mrnovoa.hibernate.modelo.Empleado;

public class TestEmpleados2 {

	//OPCION2. EntityManagerFactory
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMySQL");
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		EntityManager man = emf.createEntityManager();
		
		//Empleado e = new Empleado(10L,"Perez","Pepito",new GregorianCalendar(1986,10,1).getTime());

		
		Empleado e = new Empleado(10L,"Perez","Pepito",LocalDate.of(1986,Month.OCTOBER,1));
		
		//Relacion 1ToMany
		//OPCION1
		//Direccion d = new Direccion(15L,"Calle Falsa,123","Springfield","Springfield","EEUU");
		//e.setDireccion(d);
		
		//OPCION2- indicar en la Entity Empleado
		//	@OneToOne(cascade = {CascadeType.ALL})//para que la actualización de dirección se propague en Insert/Delete..
		e.setDireccion(new Direccion(15L,"Calle Falsa,123","Springfield","Springfield","EEUU"));
		
		man.getTransaction().begin();
		//OPCION1
		//man.persist(d);
		
		man.persist(e);
		
		man.getTransaction().commit();

		man.close();//la entidad e pasa de Managed a Detached (ya no está administrada)
		
		imprimirTodo();
		
		//Como ya no está managed -> al usar gestiones de persistencia distintos con begin() y close()
		//man = emf.createEntityManager();
		
		//man.getTransaction().begin();
		
		//solucion forma2
		//e = man.merge(e);
		
		//e.setNombre("Dani");//JPA no sabe que se refiere a la misma entidad anterior
		
		//SOLUCIÓN: uso de find() o merge()->mezcla entidad noManaged y pasa a Managed
		//solucion forma1
		//man.merge(e);
		
		//man.remove(e);
		
		//man.getTransaction().commit();
		
		//man.close();
		
		//imprimirTodo();
	}


	private static void InsertInicial() {
		EntityManager man = emf.createEntityManager();
		
		Empleado e = new Empleado(10L,"Perez","Pepito",LocalDate.of(1985,Month.JUNE,6));
		man.getTransaction().begin();
		man.persist(e);
		man.getTransaction().commit();
		
		man.close();
	}

	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {	
		EntityManager man = emf.createEntityManager();
		
		List <Empleado> emps = (List<Empleado>) man.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta BD hay " + emps.size()+" empleados.");
		for(Empleado emp : emps) {
			System.out.println(emp.toString());			
		}
		
		man.close();
	}
}
