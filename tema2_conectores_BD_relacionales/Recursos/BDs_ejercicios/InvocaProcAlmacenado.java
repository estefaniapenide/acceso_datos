/*
 * Esta clase se utiliza para invocar el procedimiento almacenado de Mysql
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Desaextremo
 */
public class InvocaProcAlmacenado {

    public static void main(String[] args) throws SQLException {
        try(
        //crea conexion
         Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ejemplo?useSSL=false", "root", "usbw")) 
        {
        //se utiliza para ejecutar proceso
        CallableStatement stmt = null;
        
        int idMensaje = 1;
        String textoMensaje= null;

            System.out.println("Creando sentencia...");
            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
            String sql = "{call getMensaje (?, ?)}";
            stmt = conexion.prepareCall(sql);

            //Bind IN parameter first, then bind OUT parameter
            
            stmt.setInt(1, idMensaje); // Asigna 1 al ide de mensaje
            // El segundo parametro es de salida; pero debe registrarse
            stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

            //Invocar el metodo execute parr ejecutar el procedimiento alamecenado 'getMensaje' y recuperar el resultado 
            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
            stmt.execute();

            //Recupera el texto del mensaje y lo imprime en la consola
            textoMensaje = stmt.getString(2);
            
            System.out.println("Mensaje con el ID:"
                    + idMensaje + " is " + textoMensaje);
            //cerrar recursos
            stmt.close();
            conexion.close();;

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

