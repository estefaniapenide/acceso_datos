package aad_ejercicio1;

import java.io.*;
import java.sql.*;

/**
 *
 * @author
 */
public class InsertarFilas {

    public static void insertarFila(Statement sentencia, ResultSet rstAux, BufferedReader lee) throws IOException {
        int cont = 0;
        boolean repeat;
        try {
            do {
                System.out.println("¿En que tabla quiere insertar una nueva fila?");
                System.out.println("1. Autores");
                System.out.println("2. Libros");
                int op = Integer.parseInt(lee.readLine());
                switch (op) {
                    case 1:
                        /*Añadimos datos de un nuevo autor*/
                        System.out.println("Teclee el dni del autor:");
                        String dni = lee.readLine();
                        System.out.println("Teclee el nombre del autor:");
                        String nombre = lee.readLine();
                        System.out.println("Teclee la nacionalidad del autor:");
                        String nacionalidad = lee.readLine();
                        sentencia.executeUpdate("INSERT INTO AUTORES (dniAutor, nombre, nacionalidad) VALUES ('" + dni + "', '" + nombre + "', '" + nacionalidad + "')");
                        /* Visualizamos la insercción*/
                        rstAux = sentencia.executeQuery("SELECT*FROM AUTORES");
                        while (rstAux.next()) {
                            cont++;
                            System.out.println("\nLos datos del autor en la fila " + cont + " son:");
                            System.out.println("\n\tDni del autor: " + rstAux.getString("dniAutor"));
                            System.out.println("\n\tNombre: " + rstAux.getString("nombre"));
                            System.out.println("\n\tNacionalidad: " + rstAux.getString("nacionalidad"));
                        }
                        cont = 0;
                        rstAux.close();
                        System.out.println("¿Quieres añadir algún libro a ese autor?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        int opExtra = Integer.parseInt(lee.readLine());
                        if (opExtra == 1) {
                            do {
                                System.out.println("Teclee el titulo del libro:");
                                String titulo = lee.readLine();
                                System.out.println("Teclee el precio del libro:");
                                int precio = Integer.parseInt(lee.readLine());
                                sentencia.executeUpdate("INSERT INTO LIBROS (idLibro, titulo, precio, autor) VALUES (" + "0" + ", '" + titulo + "', " + precio + ", '" + dni + "')");
                                /*Visualizar la inserción*/
                                rstAux = sentencia.executeQuery("SELECT*FROM LIBROS");
                                while (rstAux.next()) {
                                    cont++;
                                    System.out.println("\nLos datos del libro en la fila " + cont + " son:");
                                    System.out.println("\n\tId del libro: " + rstAux.getInt("idLibro"));
                                    System.out.println("\n\tTitulo: " + rstAux.getString("titulo"));
                                    System.out.println("\n\tPrecio: " + rstAux.getInt("precio"));
                                    System.out.println("\n\tAutor: " + rstAux.getString("autor"));
                                }
                                rstAux.close();
                                System.out.println("¿Quieres añadir más libros a ese autor?");
                                System.out.println("1. Si");
                                System.out.println("2. No");
                                opExtra = Integer.parseInt(lee.readLine());
                            } while (opExtra == 1);
                        }
                        break;
                    case 2:
                        /*Añadimos datos de un nuevo libro*/
                        boolean existe;
                        do {
                            /*Comprobamos la existencia del autor*/
                            existe = false;
                            System.out.println("Teclee el dni del autor del libro:");
                            String autor = lee.readLine();
                            rstAux = sentencia.executeQuery("SELECT*FROM autores");
                            while (rstAux.next()) {
                                if (autor.equalsIgnoreCase(rstAux.getString("dniAutor"))) {
                                    existe = true;
                                }
                            }
                            if (existe) {
                                System.out.println("Teclee el titulo del libro:");
                                String titulo = lee.readLine();
                                System.out.println("Teclee el precio del libro:");
                                int precio = Integer.parseInt(lee.readLine());
                                sentencia.executeUpdate("INSERT INTO LIBROS (idLibro, titulo, precio, autor) VALUES (" + "0" + ", '" + titulo + "', " + precio + ", '" + autor + "')");
                                /*Visualizar la inserción*/
                                rstAux = sentencia.executeQuery("SELECT*FROM LIBROS");
                                while (rstAux.next()) {
                                    cont++;
                                    System.out.println("\nLos datos del libro en la fila " + cont + " son:");
                                    System.out.println("\n\tId del libro: " + rstAux.getInt("idLibro"));
                                    System.out.println("\n\tTitulo: " + rstAux.getString("titulo"));
                                    System.out.println("\n\tPrecio: " + rstAux.getInt("precio"));
                                    System.out.println("\n\tAutor: " + rstAux.getString("autor"));
                                }
                                rstAux.close();
                                cont = 0;
                            } else {
                                System.out.println("No existe ningun autor con ese dni en la base de datos");
                            }
                        } while (!existe);
                        break;
                }
                System.out.println("¿Quieres añadir alguna otra entrada?");
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
            System.out.println("Error " + e);
            System.exit(5);
        }
    }
}
