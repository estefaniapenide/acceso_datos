package bdinstituto;

import java.io.*;
import java.sql.*;
import Excepciones.*;

/**
 *
 * @author mrnovoa
 */
public class InsertarFilas {

    public static void insercion(BufferedReader leer, Statement s, Statement s2) throws IOException {

        byte opcion;
        try {
            do {
                System.out.println("\nIntroduce que desea insertar: "
                        + "\n 1 - Insertar profesores"
                        + "\n 2 - Insertar alumnos"
                        + "\n 3 - Insertar notas"
                        + "\n 4 - Relacionar alumno - profesor - asignatura"
                        + "\n 0 - Cancelar \n");
                opcion = Byte.parseByte(leer.readLine());

                switch (opcion) {
                    case 1:
                        insertarProfesor(leer, s);
                        break;
                    case 2:
                        insertarAlumno(leer, s);
                        break;
                    case 3:
                        addNota(leer, s, s2);
                        break;
                    case 4:
                        asignaciones(leer, s);
                        break;
                    case 0:
                        System.out.println("Alta cancelada");
                        break;
                    default:
                        System.out.println("Número introducido incorrecto, reingrese la opción:");
                }

            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void insertarProfesor(BufferedReader leer, Statement s) throws IOException, SQLException {

        boolean validar;
        String dni;

        //Introducir datos para el alta del profesor
        do {
            System.out.println("Introduce el DNI del profesor: ");
            dni = leer.readLine();
            validar = MisExcepciones.validarDNI(dni);
        } while (validar != true);

        System.out.println("Introduzca su nombre: ");
        String nombre = leer.readLine();

        System.out.println("Introduce su titulación: ");
        String titulacion = leer.readLine();

        //Alta del profesor con datos introducidos
        s.executeUpdate("INSERT INTO PROFESORES (DNI,NOMBRE,TITULACION) VALUES ('" + dni + "','" + nombre + "','" + titulacion + "')");
        System.out.println("Profesor añadido correctamente");
    }

    public static void insertarAlumno(BufferedReader leer, Statement s) throws IOException, SQLException {

        //Introducir datos para el alta del alumno
        System.out.println("Introduzca su nombre: ");
        String nombre = leer.readLine();

        boolean validar;
        String codigo;
        do {
            System.out.println("Introduce su código: ");
            codigo = leer.readLine();
            validar = MisExcepciones.validarCodigo(codigo);
        } while (validar != true);

        //Alta del alumno con datos introducidos
        s.executeUpdate("INSERT INTO ALUMNOS (CODIGO, NOMBRE) VALUES ('" + codigo + "','" + nombre + "')");
        System.out.println("Alumno añadido correctamente");
    }

    public static void addNota(BufferedReader leer, Statement s, Statement s2) throws IOException, SQLException {

        boolean validar;
        float nota;

        if (Recursos.existenciaAlumno(s)) {
            Recursos.listaAlumnos(leer, s);
            System.out.println("Introduzca el ID del alumno al que desea añadir la nota: ");
            int id_al = Integer.parseInt(leer.readLine());

            ResultSet alumno = s.executeQuery("SELECT APA.ID_AS, A.NOMBRE FROM ALUMNOS_PROFESORES_ASIGNATURAS AS APA INNER JOIN ASIGNATURAS AS A ON APA.ID_AS=A.ID_AS WHERE ID_AL='" + id_al + "'");

            if (alumno.first()) {
                System.out.println("Asignaturas del alumno de ID " + id_al + ":");
                System.out.printf("%-4s %-50s %n", "ID", "Nombre");
                alumno.previous();
                while (alumno.next()) {
                    System.out.printf("%-4s %-50s %n", alumno.getInt("APA.ID_AS"), alumno.getString("A.NOMBRE"));
                }
                System.out.println("Introduzca el ID de la asignatura a la que quiere poner la nota:");
                int id_as = Integer.parseInt(leer.readLine());
                ResultSet asignatura = s2.executeQuery("SELECT COUNT(*) FROM ALUMNOS_PROFESORES_ASIGNATURAS WHERE ID_AL='" + id_al + "' AND ID_AS='" + id_as + "'");
                asignatura.next();
                if (asignatura.getInt(1) != 0) {
                    do {
                        System.out.println("Introduce la nota: ");
                        nota = Float.parseFloat(leer.readLine());
                        validar = MisExcepciones.validarNota(nota);
                    } while (validar != true);

                    s.executeUpdate("INSERT INTO NOTAS VALUES ('" + id_al + "', '" + id_as + "', CURRENT_DATE(),'" + nota + "')");
                    System.out.println("Nota añadida correctamente");

                } else {
                    System.out.println("Esa asignatura no es una de las que cursa el alumno.");
                }
            } else {
                System.out.println("No existe ningún alumno con ese ID o no tiene ninguna asignatura asignada.");
            }

            alumno.close();

        } else {
            System.out.println("No hay ningún alumno en la base de datos. Añada uno en el menú con la opción 2.");
        }

    }

    public static void asignaciones(BufferedReader leer, Statement s) throws IOException, SQLException {
        boolean validar;
        String dni;

        if (Recursos.existenciaAlumno(s)) {
            if (Recursos.existenciaProfesor(s)) {
                Recursos.listaAlumnos(leer, s);
                System.out.println("Introduce el ID del alumno que desea matricular: ");
                int id_al = Integer.parseInt(leer.readLine());

                if (Recursos.buscarAlumno(s, id_al) != 0) {
                    Recursos.listaAsignaturas(leer, s);
                    System.out.println("Introduce el ID de la asignatura que cursará: ");
                    int id_as = Integer.parseInt(leer.readLine());

                    if (Recursos.buscarAsignatura(s, id_as) != 0) {
                        Recursos.listaProfesores(leer, s);
                        do {
                            System.out.println("Introduce el DNI del profesor que le impartirá la asignatura: ");
                            dni = leer.readLine();
                            validar = MisExcepciones.validarDNI(dni);
                        } while (validar != true);

                        if (Recursos.buscarProfesor(s, dni) != 0) {
                            s.executeUpdate("INSERT INTO ALUMNOS_PROFESORES_ASIGNATURAS VALUES ('" + id_al + "', '" + dni + "', '" + id_as + "')");
                            System.out.println("Matriculación añadida correctamente");
                        } else {
                            System.out.println("No hay ningún profesor con ese DNI.");
                        }
                    } else {
                        System.out.println("No hay ninguna asignatura con ese ID.");
                    }
                } else {
                    System.out.println("No hay ningún alumno con ese ID.");
                }
            } else {
                System.out.println("No hay profesores en la base de datos. Puede darlos de alta con la opción 1.");
            }
        } else {
            System.out.println("No hay alumnos en la base de datos. Puede darlos de alta con la opción 2.");
        }

    }

}
