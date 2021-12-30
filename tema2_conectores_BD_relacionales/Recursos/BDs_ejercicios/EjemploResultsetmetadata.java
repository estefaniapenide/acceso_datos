

import java.sql.*;

public class EjemploResultsetmetadata {

	public static void main(String[] args) throws ClassNotFoundException {
		try {

			// conexion a ORACLE
			
			/*  Class.forName ("oracle.jdbc.driver.OracleDriver"); Connection
			  conexion = DriverManager.getConnection
			  ("jdbc:oracle:thin:@localhost:1521:XE", "ejemplo", "ejemplo");
			*/

			//Class.forName("com.mysql.cj.jdbc.Driver"); // Cargar el driver
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/ejemplo", "root", "usbw");
             
			Statement sentencia = conexion.createStatement();
			ResultSet rs = sentencia
					.executeQuery("SELECT * FROM departamentos");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int nColumnas = rsmd.getColumnCount();
			String nula;
			System.out.printf("Numero de columnas recuperadas: %d%n", nColumnas);
			for (int i = 1; i <= nColumnas; i++) {
				System.out.printf("Columna %d: %n ", i);
				System.out.printf("  Nombre: %s %n   Tipo: %s %n ",
						 rsmd.getColumnName(i),  rsmd.getColumnTypeName(i));
				if (rsmd.isNullable(i) == 0)
					nula = "NO";
				else
					nula = "SI";
				
				System.out.printf("  Puede ser nula?: %s %n ", nula);			
				System.out.printf("  Maximo ancho de la columna: %d %n",
						 rsmd.getColumnDisplaySize(i));
			}// for
			
			sentencia.close();
			rs.close();
			conexion.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// fin de main
}
