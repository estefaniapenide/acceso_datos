package autores_libros_estefania_penide;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class Consultar {

    public static void consulta(Statement sentencia, ResultSet rstAux, BufferedReader lee) throws IOException {
        try {
            System.out.println("¿Que consulta desea realizar?");
            System.out.println("1. Datos de un libro y nombre de su autor");
            System.out.println("2. Libros de un autor");
            System.out.println("3. Visualizar todos los libros");
            System.out.println("4. Visualizar todos los autores y sus libros");
            System.out.println("5. Salir");
            int opC = Integer.parseInt(lee.readLine());
            boolean existe = false;
            switch (opC) {
                case 1:
                    do {
                        System.out.println("Introduzca el título del libro");
                        String titulo = lee.readLine();
                        //Comprobacion
                        rstAux = sentencia.executeQuery("SELECT*FROM LIBROS");
                        while (rstAux.next()) {
                            if (titulo.equalsIgnoreCase(rstAux.getString("titulo"))) {
                                existe = true;
                            }
                        }
                        if (existe) {
                            rstAux = sentencia.executeQuery("SELECT*FROM libros JOIN autores ON autores.dniAutor = libros.autor WHERE titulo = '" + titulo + "'");
                            System.out.println("idLibro\t\ttitulo\t\tprecio\t\tNombre Autor");
                            System.out.println("------------------------------------------------------------------------------------");
                            while (rstAux.next()) {
                                System.out.print(rstAux.getInt("idLibro") + "\t\t");
                                System.out.print(rstAux.getString("titulo") + "\t\t");
                                System.out.print(rstAux.getInt("precio") + "\t\t");
                                System.out.println(rstAux.getString("nombre"));
                            }
                        } else {
                            System.out.println("No hay ningún libro con ese título registrado");
                        }
                    } while (!existe);
                    break;
                case 2:
                    do {
                        System.out.println("Introduzca el nombre del autor");
                        String nombre = lee.readLine();
                        //Comprobación
                        rstAux = sentencia.executeQuery("SELECT*FROM AUTORES");
                        while (rstAux.next()) {
                            if (rstAux.getString("nombre").toLowerCase().contains(nombre.toLowerCase())) {
                                existe = true;
                            }
                        }
                        if (existe) {
                            rstAux = sentencia.executeQuery("SELECT*FROM LIBROS JOIN AUTORES ON autores.dniAutor = libros.autor WHERE nombre = '" + nombre + "'");
                            System.out.println("titulo\t\tprecio");
                            System.out.println("---------------------------------------------");
                            while (rstAux.next()) {
                                System.out.print(rstAux.getString("titulo") + "\t\t");
                                System.out.println(rstAux.getInt("precio"));
                            }
                        } else {
                            System.out.println("No hay ningún autor con ese nombre registrado");
                        }
                    } while (!existe);
                    break;
                case 3:
                    rstAux = sentencia.executeQuery("SELECT*FROM LIBROS");
                    System.out.println("titulo\t\tprecio");
                    System.out.println("---------------------------------------------");
                    while (rstAux.next()) {
                        System.out.print(rstAux.getString("titulo") + "\t\t");
                        System.out.println(rstAux.getInt("precio"));
                    }
                    break;
                case 4:
                    rstAux = sentencia.executeQuery("SELECT*FROM LIBROS JOIN AUTORES ON autores.dniautor = libros.autor");
                    System.out.println("Autor\t\tLibros");
                    System.out.println("---------------------------------------------");
                    String nomAux = "";
                    while (rstAux.next()) {
                        if (nomAux.equalsIgnoreCase(rstAux.getString("nombre"))) {
                            System.out.println("\t\t" + rstAux.getString("titulo"));
                        } else {
                            System.out.print(rstAux.getString("nombre") + "\t-->\t");
                            System.out.println(rstAux.getString("titulo"));
                        }
                        nomAux = rstAux.getString("nombre");
                    }
                    break;
                case 5:
                    break;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
            System.exit(5);
        }
    }
}
