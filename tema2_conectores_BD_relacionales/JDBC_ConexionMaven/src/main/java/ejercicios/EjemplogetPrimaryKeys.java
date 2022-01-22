import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemplogetPrimaryKeys {

    public static void main(String[] args) {
      try
      {
        //Class.forName("com.mysql.jdbc.Driver"); //Cargar el driver
        //Establecemos la conexion con la BD
        Connection conexion = DriverManager.getConnection  
        ("jdbc:mysql://localhost:3307/ejemplo","root", "usbw");   

        //Oracle 
        /*Class.forName ("oracle.jdbc.driver.OracleDriver");	
        Connection conexion = DriverManager.getConnection  
              ("jdbc:oracle:thin:@localhost:1521:XE", "ejemplo", "ejemplo");
        */

        DatabaseMetaData dbmd = conexion.getMetaData();//Creamos 
        //objeto DatabaseMetaData
        ResultSet resul = null;

        System.out.println("CLAVE PRIMARIA TABLA DEPARTAMENTOS:");
        System.out.println("===================================");

        //CAT	String	Nombre de la base de datos en la que reside la tabla especificada.
        //public java.sql.ResultSet getPrimaryKeys(java.lang.String cat,  
         //                                java.lang.String schema,  
         //                                java.lang.String table)  
        
         ResultSet pk = dbmd.getPrimaryKeys("EJEMPLO", null, "DEPARTAMENTOS");
        String pkDep="", separador="";

        while (pk.next()) {
           pkDep = pkDep + separador + 
               pk.getString("COLUMN_NAME");//getString(4)
           separador="+";
         }
        System.out.println("Clave Primaria: " + pkDep);

         conexion.close(); //Cerrar conexion   		  	   
      } 
      catch (SQLException e) {e.printStackTrace();}		
    }//fin de main
}
