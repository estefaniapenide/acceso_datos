package gal.mrnovoa.hibernate.tests;

//import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.Month;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
import javax.persistence.Persistence;

import gal.mrnovoa.hibernate.modelo.Empleado;

public class TestEmpleadosMySQL {

	//Gestor de persistencia para operaciones CRUD 
	private static EntityManager manager;//static para poder verlo desde main
		
	//OPCION1.Usando Java EE o EJBs--apps Web
	// <persistence-unit name="Persistencia"> en persistence.xml
	//@PersistenceContext(unitName = "Persistencia")

	//USO con EJBs , pero como no estamos en apps Web->forma TRADICIONAL
	//@PersistenceUnit(unitName = )
	
	//OPCION2. EntityManagerFactory
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenciaMySQL");
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*Crear el gestor de persistencia (EM)*/
		//forma TRADICIONAL
		//emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		manager.createQuery("FROM Empleado").getMaxResults();//Sin usar de momento JPQL
		manager.createQuery("FROM Empleado").getFirstResult();
		
		//Empleado e2 = new Empleado(25L,"Rodriguez","Juan",new GregorianCalendar(1986,10,1).getTime());
		Empleado e2 = new Empleado(25L,"Rodriguez","Juan",LocalDate.of(1986,10,1));
		
		//JPA más antiguo q Java8- Uso Calendar
		//Instalando ciertos elementos, Hibernate permite uso de Java8
		
		//INSERCION
		//TRANSACCIONES - begin,..., commit
		//transaccion- posibilidad de hacer varias operaciones con la BD y no se envían/ejecutan
		//hasta hacer el commit(), y se puede hacer rollback() y dejar BD en estado anterior al begin()
		//forma atómica- o se ejecuta todo o no se ejecuta nada
		
		InsertInicial();
		
		imprimirTodo();
		
		manager.getTransaction().begin();
		
		Empleado e1 = manager.find(Empleado.class, 10L);//también será managed por hacerlo bloqueTransaccion
		e1.setNombre("Recaredo");
		e1.setApellidos("Lopez");
		manager.getTransaction().commit();
		
		imprimirTodo();
		manager.close();
	}


	private static void InsertInicial() {
		//Empleado e = new Empleado(10L,"Perez","Pepito",new GregorianCalendar(1985,6,6).getTime());
		Empleado e = new Empleado(10L,"Perez","Pepito",LocalDate.of(1985,6,6));
		manager.getTransaction().begin();
		
		manager.persist(e);
		//manager.persist(e2);
		
		manager.getTransaction().commit();
	}

	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {	
		List <Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta BD hay " + emps.size()+" empleados.");
		
		for(Empleado emp : emps) {
			System.out.println(emp.toString());			
		}
	}
}
