package teis.dual.hibernate.hql2;

//import teis.dual.hibernate.hql2.entity.Department;
//import teis.dual.hibernate.hql2.entity.EmployeeQ;
import java.util.*;
import org.hibernate.*;
//import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import teis.dual.hibernate.hql2.entity.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

public class HibernateUtil {
   private static StandardServiceRegistry registry;
   private static SessionFactory sessionFactory;

   public static SessionFactory getSessionFactory() {
      if (sessionFactory == null) {
         try {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            //Configuration properties
            Map<String, Object> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://localhost:3307/bdMySQL_hb_Herencia?useSSL=false");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "usbw");
            //para consultas
            settings.put(Environment.HBM2DDL_AUTO, "validate");
            //Si no están creadas
            //settings.put(Environment.HBM2DDL_AUTO, "create");
            settings.put(Environment.SHOW_SQL, true);
            
            registryBuilder.applySettings(settings);
            registry = registryBuilder.build();
            
            MetadataSources sources = new MetadataSources(registry);
            
            sources.addAnnotatedClass(Department.class);
            sources.addAnnotatedClass(EmployeeQ.class);
            
            Metadata metadata = sources.getMetadataBuilder().build();
            
            sessionFactory = metadata.getSessionFactoryBuilder().build();
         } catch (Exception e) {
            if (registry != null) {
               StandardServiceRegistryBuilder.destroy(registry);
            }
            e.printStackTrace();
         }
      }
      return sessionFactory;
   }

   public static void shutdown() {
      if (registry != null) {
         StandardServiceRegistryBuilder.destroy(registry);
      }
   }
}
