package gal.mrnovoa.hibernate.sol2;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Many2ManyTester {
	public static void main(String[] args) {
		// loads configuration and mappings
		Configuration configuration = new Configuration().configure();
		ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
		registry.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = registry.buildServiceRegistry();

		// builds a session factory from the service registry
		SessionFactory sessionFactory = configuration
				.buildSessionFactory(serviceRegistry);

		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		testSaveAllNew(session);
//		testSaveWithExistingUserAndGroup(session);
//		testDeleteUserGroup(session);
		

		session.getTransaction().commit();
		session.close();		
	}

	private static void testSaveAllNew(Session session) {
		User_sol2 user = new User_sol2("sam2", "mas", "sam@gmail.com");
		
		Group_sol2 group = new Group_sol2("Designer2");
		session.save(group);
		
		UserGroup_sol2 userGroup = new UserGroup_sol2();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
		
		user.addUserGroup(userGroup);
		
		session.save(user);
	}
	
	private static void testSaveWithExistingUserAndGroup(Session session) {
		// this user is obtained from the database with ID 1
		User_sol2 user = (User_sol2) session.get(User_sol2.class, new Long(1));

		// this group is obtained from the database with ID 1		
		Group_sol2 group = (Group_sol2) session.get(Group_sol2.class, new Long(1));
		
		UserGroup_sol2 userGroup = new UserGroup_sol2();
		userGroup.setGroup(group);
		userGroup.setUser(user);
		userGroup.setActivated(true);
		userGroup.setRegisteredDate(new Date());
				
		session.save(userGroup);		
	}
	
	private static void testDeleteUserGroup(Session session) {
		UserGroup_sol2 userGroup = new UserGroup_sol2();
		
		User_sol2 user = new User_sol2();
		user.setId(39);
		userGroup.setUser(user);
		
		Group_sol2 group = new Group_sol2();
		group.setId(25);
		userGroup.setGroup(group);
		
		session.delete(userGroup);
	}
}
