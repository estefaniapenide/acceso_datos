import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MainTodas {
   public static void main(String[] args) throws ClassNotFoundException {
      try {
	//SQLITE
    //	  Class.forName("org.sqlite.JDBC");
    //	  Connection conexion = DriverManager.getConnection 
    //	                        ("jdbc:sqlite:D:/DB/SQLITE/ejemplo.db");  
    //derby
     //Class.forName("org.apache.derby.jdbc.EmbeddedDriver");		
     //Connection conexion =  DriverManager.getConnection("jdbc:derby:D:/DB/DERBY/ejemplo");  
  
    //hsqldb
    //Class.forName("org.hsqldb.jdbcDriver" );
    //Connection conexion = DriverManager.getConnection
    //                    ("jdbc:hsqldb:file:D:/DB/HSQLDB/ejemplo/ejemplo");  
    
    //h2
    //Class.forName("org.h2.Driver" );
    //Connection conexion = DriverManager.getConnection
    //                    ("jdbc:h2:D:/DB/H2/ejemplo/ejemplo","sa",""); 
    	  
    //mysql
    //Class.forName("com.mysql.jdbc.Driver");
    
    //Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'
    //com.mysql.cj.jdbc.Driver
//    Class.forName("com.mysql.cj.jdbc.Driver");
//    
    Connection conexion = DriverManager.getConnection 
    	             ("jdbc:mysql://localhost:3307/ejemplo?useSSL=false", "root", "usbw");

    //Oracle 
  /*  Class.forName ("oracle.jdbc.driver.OracleDriver");	
    Connection conexion = DriverManager.getConnection  
          ("jdbc:oracle:thin:@localhost:1521:XE", "ejemplo", "ejemplo");
  */
    	  
	// Preparamos la consulta
	Statement sentencia = conexion.createStatement();
      String sql = "SELECT * FROM departamentos";
	ResultSet resul = sentencia.executeQuery(sql);

	//Recorremos el resultado para visualizar cada fila
	//Se hace un bucle mientras haya registros y se van visualizando
	while (resul.next()) {
	    System.out.printf("%d, %s, %s %n", 
              resul.getInt(1), resul.getString(2), resul.getString(3));
	}

	resul.close();     // Cerrar ResultSet
	sentencia.close(); // Cerrar Statement
	conexion.close();  // Cerrar conexi�n

      } catch (SQLException e) {
	   e.printStackTrace();
      }

   }// fin de main
}// fin de la clase
