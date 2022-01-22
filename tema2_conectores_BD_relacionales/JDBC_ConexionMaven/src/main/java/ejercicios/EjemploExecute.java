

import java.sql.*;

public class EjemploExecute {   
	
	public static void main(String[] args) throws 
	       ClassNotFoundException, SQLException {
	  
		//CONEXION A MYSQL  	       
	   //Class.forName("om.mysql.cj.jdbc.Driver");		 
	   //Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
           Connection conexion = DriverManager.getConnection    
           ("jdbc:mysql://localhost:3307/ejemplo","root", "usbw");   		   
	   
	   String sql="SELECT * FROM departamentos";
	   Statement sentencia = conexion.createStatement();		   
	   boolean valor = sentencia.execute(sql);  
	   		   
	   if(valor){
	    	ResultSet rs = sentencia.getResultSet();
	   	 while (rs.next())
	   	    System.out.printf("%d, %s, %s %n",
	   	    		rs.getInt(1), rs.getString(2), rs.getString(3));
	    	rs.close();
	   } else {
	    	int f = sentencia.getUpdateCount();
	    	System.out.printf("Filas afectadas:%d %n", f);
	   }
	   
		sentencia.close();
		conexion.close();
	}//main
}//
