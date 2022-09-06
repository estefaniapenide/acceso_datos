
package bdinstituto;

import java.io.*;
import java.sql.*;

/**
 *
 * @author mrnovoa
 */
public class BDInstituto {

    public static void main(String[] args) {
        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            Statement sentencia = conexion.createStatement();
            Statement sentencia2 = conexion.createStatement();
            CrearBD.crear(sentencia);

            BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
            byte op = 0;

            do {
                try {

                    op = Menu.principal(leer);

                    switch (op) {
                        case 1:
                            InsertarFilas.insercion(leer, sentencia, sentencia2);
                            break;
                        case 2:
                            EliminarFilas.eliminar(leer, sentencia);
                            break;
                        case 3:
                            Modificaciones.modificarNota(leer, sentencia);
                            break;
                        case 4:
                            Consultas.consultas(leer, sentencia);
                            break;
                        case 0:
                            System.out.println("-PROGRAMA CERRADO SIN ERRORES-");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción incorrecta");
                    }

                } catch (IOException e) {

                    System.out.println(e.getMessage());
                } catch (RuntimeException e) {

                    System.out.println(e.getMessage());

                } catch (Exception e) {

                    System.out.println(e.getMessage());
                }

            } while (op != 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
