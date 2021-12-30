import java.sql.*;

public class ProcSubida {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            //Class.forName("com.mysql.jdbc.Driver"); // Cargar el driver
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3307/ejemplo", "root",
                                "usbw");

            //conexion a ORACLE		  
            /*Class.forName ("oracle.jdbc.driver.OracleDriver");	
                 Connection conexion = DriverManager.getConnection  
         ("jdbc:oracle:thin:@localhost:1521:XE", "ejemplo", "ejemplo");  
*/

            // recuperar parametros de main
//			String dep = args[0];   //"10"; // departamento
//			String subida = args[1];//"1000"; // subida

            // construir orden DE LLAMADA
            String sql = "{ call subida_sal (?, ?) } ";

            // Preparamos la llamada
            CallableStatement llamada = conexion.prepareCall(sql);
            // Damos valor a los argumentos
//			llamada.setInt(1, Integer.parseInt(dep)); // primer argumento-dep
//			llamada.setFloat(2, Float.parseFloat(subida)); // segundo arg

            llamada.setInt(1, Integer.parseInt("10")); // primer argumento-dep
            llamada.setFloat(2, Float.parseFloat("1000")); // segundo arg

            llamada.executeUpdate(); // ejecutar el procedimiento
            System.out.println("Subida realizada....");
            llamada.close();
            conexion.close();
        } catch (SQLException e) {
                e.printStackTrace();
        }

    }// fin de main
}// fin de la clase
