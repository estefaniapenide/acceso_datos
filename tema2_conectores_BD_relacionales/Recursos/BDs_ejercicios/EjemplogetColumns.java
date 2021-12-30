import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemplogetColumns {

	public static void main(String[] args) throws ClassNotFoundException {
		  try
		  {
			//Class.forName("com.mysql.cj.jdbc.Driver"); //Cargar el driver
			//Establecemos la conexion con la BD
	        Connection conexion = DriverManager.getConnection  
	            ("jdbc:mysql://localhost:3307/ejemplo","root", "usbw");   
	  
			DatabaseMetaData dbmd = conexion.getMetaData();//Creamos 
	                               //objeto DatabaseMetaData
	  		 ResultSet resul = null;
			 
	  		System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
	  		System.out.println("===================================");
	  		ResultSet columnas=null;
	  		columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);
	  		while (columnas.next()) {			   
	  		  String nombCol = columnas.getString("COLUMN_NAME"); //getString(4)
	  		  String tipoCol = columnas.getString("TYPE_NAME");   //getString(6)
	  		  String tamCol = columnas.getString("COLUMN_SIZE");  //getString(7)
	  		  String nula  = columnas.getString("IS_NULLABLE");   //getString(18)
	  					   			   
	  		  System.out.printf("Columna: %s, Tipo: %s, Tama�o: %s, �Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
	  		}

				
	  		 conexion.close(); //Cerrar conexion   		  	   
		  } 
	   catch (SQLException e) {e.printStackTrace();}		
		}//fin de main
	
}
