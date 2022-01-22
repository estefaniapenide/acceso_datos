package autores_libros_estefania_penide;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class ModificarFilas {

    public static void modificarFila(Statement sentencia, ResultSet rstAux, BufferedReader lee) throws IOException {
        try {
            boolean existeLibro = false;
            do {
                rstAux = sentencia.executeQuery("SELECT*FROM LIBROS");
                System.out.println("idLibro\t\ttitulo\t\tprecio\t\tautor");
                System.out.println("-----------------------------------------------------");
                while (rstAux.next()) {
                    System.out.print(rstAux.getInt("idLibro") + "\t\t");
                    System.out.print(rstAux.getString("titulo") + "\t\t");
                    System.out.print(rstAux.getInt("precio") + "\t\t");
                    System.out.println(rstAux.getString("autor"));
                }
                rstAux.close();
                System.out.println("¿En que libro desea realizar la modificación?");
                System.out.print("Id Libro: ");
                int idLibro = Integer.parseInt(lee.readLine());
                //Comprobar que existe el libro
                rstAux = sentencia.executeQuery("SELECT*FROM libros");
                while (rstAux.next()) {
                    if (idLibro == rstAux.getInt("idLibro")) {
                        existeLibro = true;
                    }
                }
                if (existeLibro) {
                    System.out.println("¿Que campo desea modificar?");
                    System.out.println("1. Titulo");
                    System.out.println("2. Precio");
                    System.out.println("3. Autor");
                    System.out.println("4. Salir");
                    int opMod = Integer.parseInt(lee.readLine());
                    switch (opMod) {
                        case 1:
                            System.out.println("Escriba el nuevo título");
                            String titulo = lee.readLine();
                            sentencia.executeUpdate("UPDATE LIBROS SET titulo = '" + titulo + "' WHERE idLibro = " + idLibro + ";");
                            break;
                        case 2:
                            System.out.println("Escriba el nuevo precio");
                            int precio = Integer.parseInt(lee.readLine());
                            sentencia.executeUpdate("UPDATE LIBROS SET precio = " + precio + " WHERE idLibro = " + idLibro + ";");
                            break;
                        case 3:
                            boolean error;
                            do {
                                error = false;
                                System.out.println("Escriba el nuevo autor");
                                String autor = lee.readLine();
                                //Comprobamos que existe ese autor
                                boolean existeAutor = false;
                                rstAux = sentencia.executeQuery("SELECT*FROM autores");
                                while (rstAux.next()) {
                                    if (autor.equalsIgnoreCase(rstAux.getString("dniAutor"))) {
                                        existeAutor = true;
                                    }
                                }
                                if (existeAutor) {
                                    sentencia.executeUpdate("UPDATE LIBROS SET autor = '" + autor + "' WHERE idLibro = " + idLibro + ";");
                                } else {
                                    System.out.println("No existe ningún autor con ese dni en la base de datos");
                                    error = true;
                                }
                            } while (error);
                            break;
                        case 4:
                            System.out.println("Saliendo");
                            break;
                    }
                } else {
                    System.out.println("No existe ningún libro con ese id en la base de datos");
                }
                rstAux = sentencia.executeQuery("SELECT*FROM libros WHERE idLibro = " + idLibro);
                while (rstAux.next()) {
                    System.out.println("\nLos nuevos datos del libro son:");
                    System.out.println("\n\tId del libro: " + rstAux.getInt("idLibro"));
                    System.out.println("\n\tTitulo: " + rstAux.getString("titulo"));
                    System.out.println("\n\tPrecio: " + rstAux.getInt("precio"));
                    System.out.println("\n\tAutor: " + rstAux.getString("autor"));
                }
            } while (!existeLibro);
        } catch (java.sql.SQLException e) {
            System.out.println("Error " + e);
            System.exit(5);
        }
    }
}
