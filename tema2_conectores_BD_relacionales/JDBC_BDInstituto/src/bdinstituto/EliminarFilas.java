package bdinstituto;

import java.io.*;
import java.sql.*;
import Excepciones.*;

/**
 *
 * @author mrnovoa
 */
public class EliminarFilas {

    public static void eliminar(BufferedReader leer, Statement s) throws IOException {
        byte opcion;
        try {
            do {
                System.out.println("\nIntroduce que desea eliminar: "
                        + "\n 1 - Eliminar profesor"
                        + "\n 2 - Eliminar alumno"
                        + "\n 0 - Cancelar \n");
                opcion = Byte.parseByte(leer.readLine());

                switch (opcion) {
                    case 1:
                        eliminarProfesor(leer, s);
                        break;
                    case 2:
                        eliminarAlumno(leer, s);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Número introducido incorrecto, reingrese la opción:");
                }

            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarProfesor(BufferedReader leer, Statement s) throws IOException, SQLException {
        boolean validar;
        String dni;

        if (Recursos.existenciaProfesor(s)) {
            Recursos.listaProfesores(leer, s);
            do {
                System.out.println("Introduce el DNI del profesor a eliminar: ");
                dni = leer.readLine();
                validar = MisExcepciones.validarDNI(dni);
            } while (validar != true);
            if (Recursos.buscarProfesor(s, dni) != 0) {
                System.out.println("Se va a eliminar el profesor de DNI " + dni + ". Para continuar pulse ENTER");
                String confirmar = leer.readLine();
                if (confirmar.equalsIgnoreCase("")) { 
                    s.executeUpdate("DELETE FROM PROFESORES WHERE DNI='" + dni + "'");
                    System.out.println("Profesor eliminado correctamente \n");
                } else {
                    System.out.println("Eliminación cancelada");
                }
                
            } else {
                System.out.println("No hay ningún profesor con ese DNI.");
            }
        } else {
            System.out.println("No hay profesores en la base de datos. Puede darlos de alta en el menú principal.");
        }

    }

    public static void eliminarAlumno(BufferedReader leer, Statement s) throws IOException, SQLException {
        if (Recursos.existenciaAlumno(s)) {
            Recursos.listaAlumnos(leer, s);
            System.out.println("Introduce el ID del alumno a eliminar: ");
            int id = Integer.parseInt(leer.readLine());
            if (Recursos.buscarAlumno(s, id) != 0) {
                System.out.println("Se va a eliminar el alumno de ID " + id + ". Para continuar pulse ENTER");
                String confirmar = leer.readLine();
                if (confirmar.equalsIgnoreCase("")) { 
                    s.executeUpdate("DELETE FROM ALUMNOS WHERE ID_AL='" + id + "'");
                    System.out.println("Alumno eliminado correctamente \n");
                } else {
                    System.out.println("Eliminación cancelada");
                }
            } else {
                System.out.println("No hay ningún alumno con ese ID.");
            }
        } else {
            System.out.println("No hay alumnos en la base de datos. Puede darlos de alta en el menú principal.");
        }

    }

}
