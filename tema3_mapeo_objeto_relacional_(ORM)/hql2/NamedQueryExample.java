package teis.dual.hibernate.hql2;
//import teis.dual.hibernate.hql2.entity.Department;
import java.util.*;
import org.hibernate.*;
import teis.dual.hibernate.hql2.entity.*;

public class NamedQueryExample {
   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();
         
         // Executing named queries
         
         List<Long> totalDept=session.createNamedQuery("get_total_dept",Long.class).getResultList();
         System.out.println("Total Department: "+totalDept.get(0));
         
         List<String> deptName=session.createNamedQuery("get_dept_name_by_id",String.class)
               .setParameter("id", 2)
               .getResultList();
         for (Object object : deptName) {
            System.out.println(object);
         }
         
         List<Department> departments=session.createNamedQuery("get_all_dept",Department.class)
               .getResultList();
         for (Department department : departments) {
            System.out.println("ID : "+department.getId()+" \tNAME : "+department.getName());
         }
         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         if (session != null) {
            session.close();
         }
      }
      HibernateUtil.shutdown();
   }
}
