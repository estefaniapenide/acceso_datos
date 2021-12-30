import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertarDep {
	public static void main(String[] args) throws IOException {
		try {
			//Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost:3307/ejemplo", "root", "usbw");
			
			
		  /*Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
							"ejemplo", "ejemplo");
          */ 
			// recuperar argumentos de main
//			String dep = args[0]; // num. departamento
//			String dnombre = args[1]; // nombre
//			String loc = args[2]; // localidad
                        
                        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
                                
                                System.out.println("Introduce el Num. Dpto.: ");
                                String dep = leer.readLine();
                                
                                System.out.println("Introduce el Nom. Dpto.: ");
                                String dnombre = leer.readLine();
                                 
                                System.out.println("Introduce el Loc. Dpto.: ");
                                String loc = leer.readLine(); 
			
			//construir orden INSERT	        
	        String sql = String.format("INSERT INTO departamentos VALUES (%s, '%s', '%s')",
	        		Integer.parseInt(dep),dnombre,loc);
	        
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
