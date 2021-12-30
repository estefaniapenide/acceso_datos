import java.sql.*;

public class InsertarEmple {
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			/*Class.forName("com.mysql.jdbc.Driver");*/			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ejemplo", "root", "usbw");
			
			
		    /*Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","ejemplo", "ejemplo");
          */
			
			
			//construir orden INSERT	        
	        String sql = "INSERT INTO empleados (emp_no, apellido, oficio,salario, dept_no) "
	        		+ " VALUES (1002, 'otro', 'EMPLEADO', 2000, 10)";
	        		
	        
	        System.out.println(sql);

	        
			//https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
	        
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas=0;
			try {
			  filas = sentencia.executeUpdate(sql.toString());
			  System.out.println("Filas afectadas: " + filas);
			} catch (SQLException e) {
				//e.printStackTrace();
				   System.out.printf("HA OCURRIDO UNA EXCEPCI�N:%n"); 
				   System.out.printf("Mensaje   : %s %n", e.getMessage()); 
				   System.out.printf("SQL estado: %s %n", e.getSQLState()); 
				   System.out.printf("C�d error : %s %n", e.getErrorCode());	    	
			}
			
			

			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// fin de main
}// fin de la clase
