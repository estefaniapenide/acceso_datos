import java.sql.*;
public class VerEmpleado {	
	public static void main(String[] args) {
	  try
	  {
		 //Cargar el driver
		 //Class.forName("com.mysql.jdbc.Driver");
		 
                // Establecemos la conexion con la BD
		 Connection conexion = DriverManager.getConnection ("jdbc:mysql://localhost:3307/ejemplo","root", "usbw");   
		
		//recuperar parametros de main  
//		 String dep = args[0];    //departamento
//		 String oficio = args[1]; //oficio			

		 //construimos la orden SELECT
		 String sql= "SELECT apellido, salario FROM empleados WHERE dept_no = ? AND oficio = ? ORDER BY 1";

		 // Preparamos la sentencia
		 PreparedStatement sentencia = conexion.prepareStatement(sql);
		 		 
//		 sentencia.setInt(1,Integer.parseInt(dep));
//		 sentencia.setString(2,oficio);

         sentencia.setInt(1,Integer.parseInt("30"));
		 sentencia.setString(2,"VENDEDOR");
		 	 
                 
		 ResultSet rs = sentencia.executeQuery();  
		 while (rs.next())
		       System.out.printf("%s => %.2f %n", rs.getString("apellido"),
		                     rs.getFloat("salario"));
		 		 		 		
		 rs.close();// liberar recursos
		 sentencia.close();
		 conexion.close();  
 
		  	   
	  } catch (Exception e) {e.printStackTrace();} 	

	}//fin de main

}//fin de la clase


