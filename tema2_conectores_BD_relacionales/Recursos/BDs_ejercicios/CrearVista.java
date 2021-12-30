import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class CrearVista {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
		// Establecemos la conexion con la BD
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ejemplo", "root", "usbw");

		StringBuilder sql = new StringBuilder();
        sql.append("CREATE OR REPLACE VIEW totales ");
        sql.append("(dep, dnombre, nemp, media) AS ");
        sql.append("SELECT d.dept_no, dnombre, COUNT(emp_no), AVG(salario) ");
        sql.append("FROM departamentos d LEFT JOIN empleados e " );
        sql.append("ON e.dept_no = d.dept_no ");
        sql.append("GROUP BY d.dept_no, dnombre ");
		System.out.println(sql);
		
		Statement sentencia = conexion.createStatement();
		int filas = sentencia.executeUpdate(sql.toString());
		System.out.printf("Resultado  de la ejecucion: %d %n", filas);

		sentencia.close(); // Cerrar Statement
		conexion.close(); // Cerrar conexion

	}// fin de main
}// fin de la clase