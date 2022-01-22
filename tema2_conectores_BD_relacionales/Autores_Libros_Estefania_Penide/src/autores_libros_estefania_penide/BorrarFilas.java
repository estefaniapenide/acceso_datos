package autores_libros_estefania_penide;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author 
 */
public class BorrarFilas {

    public static void borrarFila(Statement sentencia, ResultSet rstAux, BufferedReader lee) throws IOException {

        try {
            boolean repeat;
            do {
                System.out.println("¿En que tabla quiere borrar una fila?");
                System.out.println("1. Autores");
                System.out.println("2. Libros");
                int op = Integer.parseInt(lee.readLine());
                switch (op) {
                    case 1:
                        boolean existe = false;
                        System.out.println("Introduce el dni del autor:");
                        String dniAutor = lee.readLine();
                        rstAux = sentencia.executeQuery("SELECT*FROM AUTORES");
                        while (rstAux.next()) {
                            if (dniAutor.equalsIgnoreCase(rstAux.getString("dniAutor"))) {
                                existe = true;
                            }
                        }
                        if (existe) {
                            System.out.println("¿Está seguro que desea borrar este autor y todos sus libros?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            int opb = Integer.parseInt(lee.readLine());
                            if (opb == 1) {
                                sentencia.executeUpdate("DELETE FROM AUTORES WHERE (dniAutor = '" + dniAutor + "')");
                            } else {
                                System.out.println("Saliendo...");
                                break;
                            }
                        } else {
                            System.out.println("No existe ningún autor con ese dni");
                        }
                        break;
                    case 2:
                        existe = false;
                        System.out.println("Introduce el id del libro:");
                        int idLibro = Integer.parseInt(lee.readLine());
                        rstAux = sentencia.executeQuery("SELECT*FROM LIBROS");
                        while (rstAux.next()) {
                            if (idLibro == rstAux.getInt("idLibro")) {
                                existe = true;
                            }
                        }
                        if (existe) {
                            System.out.println("¿Está seguro que desea borrar este libro?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            int opb = Integer.parseInt(lee.readLine());
                            if (opb == 1) {
                                sentencia.executeUpdate("DELETE FROM LIBROS WHERE (idLibro = " + idLibro + ")");
                            } else {
                                System.out.println("Saliendo...");
                                break;
                            }
                        } else {
                            System.out.println("No existe ningún libro con ese id");
                        }
                        break;
                }
                System.out.println("¿Quieres borrar alguna otra entrada?");
                System.out.println("1. Si");
                System.out.println("2. No");
                int opr = Integer.parseInt(lee.readLine());
                if (opr == 1) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } while (repeat);
        } catch (java.sql.SQLException e) {
            System.out.println("error " + e);
            System.exit(5);
        }
    }
}
