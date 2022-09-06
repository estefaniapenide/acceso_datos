package teis.dual.hibernate.hql2.entity;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")

// Using @NamedNativeQuery for single native sql query
@NamedNativeQuery(name = "get_total_emp", query = "select count(1) from EMPLOYEE")

// Using @NamedNativeQuery for multiple native sql queries
@NamedNativeQueries({
      // Using @NamedNativeQuery with parameter binding
      @NamedNativeQuery(name = "get_total_emp_by_dept", query = "select count(1) from EMPLOYEE where dpt_id=:did"),

      @NamedNativeQuery(name = "get_all_emp", query = "select * from EMPLOYEE",resultClass=EmployeeQ.class) 
  })
public class EmployeeQ {

   @Id
   @Column(name = "EMP_ID")
   private int id;

   @Column(name = "NAME")
   private String name;

   @Column(name = "DESIGNATION")
   private String designation;

   @ManyToOne
   @JoinColumn(name = "DPT_ID")
   private Department department;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDesignation() {
      return designation;
   }

   public void setDesignation(String designation) {
      this.designation = designation;
   }

   public Department getDepartment() {
      return department;
   }

   public void setDepartment(Department department) {
      this.department = department;
   }

}
