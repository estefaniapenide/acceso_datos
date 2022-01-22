import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class InsertaDepPreparedStatement {
    public static void main(String[] args) throws IOException {
	try {
            //Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
            // Establecemos la conexion con la BD
            Connection conexion = DriverManager.getConnection
                            ("jdbc:mysql://localhost:3307/ejemplo", "root", "usbw");

            // recuperar argumentos de main
//				String dep = args[0]; // num. departamento
//				String dnombre = args[1]; // nombre
//				String loc = args[2]; // localidad

            BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Introduce el Num. Dpto.: ");
            String dep = leer.readLine();

            System.out.println("Introduce el Nom. Dpto.: ");
            String dnombre = leer.readLine();

            System.out.println("Introduce el Loc. Dpto.: ");
            String loc = leer.readLine(); 

            // construir orden INSERT
//				String sql = "INSERT INTO departamentos VALUES "
//						+ "( ?, ?, ? )";
            String sql = "INSERT INTO departamentos VALUES "
                            + "( ?, ?, ? )";

            System.out.println(sql);  			    
            PreparedStatement sentencia = 
                            conexion.prepareStatement(sql);				
            sentencia.setInt(1, Integer.parseInt(dep));
            sentencia.setString(2, dnombre);
            sentencia.setString(3, loc);

            int filas;//
            try {
              filas = sentencia.executeUpdate();
              System.out.println("Filas afectadas: " + filas);
            } catch (SQLException e) {
                    System.out.println("HA OCURRIDO UNA EXCEPCI�N:"); 
                System.out.println("Mensaje:    "+ e.getMessage()); 
                System.out.println("SQL estado: "+ e.getSQLState()); 
            System.out.println("Cod error:  "+ e.getErrorCode());  
            }

            sentencia.close(); // Cerrar Statement
            conexion.close(); // Cerrar conexi�n

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }// fin de main
}// fin de la clase
