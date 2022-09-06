package teis.dual.hibernate.hql2;
//import gal.mrnovoa.hibernate.hql2.entity.EmployeeQ;
//import gal.mrnovoa.hibernate.hql2.entity.Department;
import java.util.*;
import org.hibernate.*;
import teis.dual.hibernate.hql2.entity.*;

public class NamedNativeQueryExample {
   @SuppressWarnings("unchecked")
   public static void main(String[] args) {
      Session session = null;
      Transaction transaction = null;
      try {
         session = HibernateUtil.getSessionFactory().openSession();
         transaction = session.beginTransaction();
         
         // Executing named native queries 
         
         List<Object> totalEmp=session.createNamedQuery("get_total_emp").getResultList();
         System.out.println("Total Employees : "+totalEmp.get(0));
         
         List<Object> totalEmpByDept=session.createNamedQuery("get_total_emp_by_dept")
               .setParameter("did", 2)
               .getResultList();
         System.out.println("Total Employees : "+totalEmpByDept.get(0));
         
         List<EmployeeQ> employees=session.createNamedQuery("get_all_emp",EmployeeQ.class)
               .getResultList();
         for (EmployeeQ employee : employees) {
            System.out.println("EMP ID : "+employee.getId()+"\t NAME : "+employee.getName()+"\tDESIGNATION : "+employee.getDesignation());
            Department department=employee.getDepartment();
            System.out.println("\t Department : "+department.getName());
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
