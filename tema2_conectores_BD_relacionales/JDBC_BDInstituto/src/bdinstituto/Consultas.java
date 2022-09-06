package bdinstituto;

import Excepciones.MisExcepciones;
import java.io.*;
import java.sql.*;

/**
 *
 * @author mrnovoa
 */
public class Consultas {

    public static void consultas(BufferedReader leer, Statement s) throws IOException {

        byte opcion;
        try {
            do {
                System.out.println("\nIntroduce que desea visualizar: "
                        + "\n 1 - Asignaturas impartidas por un profesor"
                        + "\n 2 - Notas de un alumno"
                        + "\n 3 - Profesores que imparten una asignatura"
                        + "\n 0 - Cancelar \n");
                opcion = Byte.parseByte(leer.readLine());

                switch (opcion) {
                    case 1:
                        asignaturasProfesor(leer, s);
                        break;
                    case 2:
                        if (Recursos.existenciaAlumno(s)) {
                            Recursos.listaAlumnos(leer, s);
                            System.out.println("Introduce el ID del alumno: ");
                            int id_al = Integer.parseInt(leer.readLine());
                            notasAlumno(leer, s, id_al);
                        } else {
                            System.out.println("No hay alumnos en la base de datos, puede darlos de alta en el menú principal.");
                        }
                        break;
                    case 3:
                        profesoresAsignatura(leer, s);
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

    public static void notasAlumno(BufferedReader leer, Statement s, int id_alumno) throws IOException, SQLException {
        if (Recursos.existenciaAlumno(s)) {
            if (Recursos.buscarAlumno(s, id_alumno) != 0) {
                ResultSet notas = s.executeQuery("SELECT N.NOTA, A.NOMBRE, A.ID_AS FROM NOTAS AS N INNER JOIN ASIGNATURAS AS A ON N.ID_AS=A.ID_AS WHERE N.ID_AL='" + id_alumno + "'");
                if (notas.first()) {
                    System.out.println("Notas del alumno de ID " + id_alumno + ":");
                    System.out.printf("%-4s %-50s %-6s %n", "ID", "Asignatura", "Nota");
                    notas.previous();
                    while (notas.next()) {
                        System.out.printf("%-4s %-50s %-4.2f %n", notas.getInt("A.ID_AS"), notas.getString("A.NOMBRE"), notas.getFloat("N.NOTA"));
                    }
                } else {
                    System.out.println("Ese alumno no tiene ninguna nota registrada.");
                }
                notas.close();
            } else {
                System.out.println("No hay ningún alumno con ese ID.");
            }
        } else {
            System.out.println("No hay alumnos en la base de datos. Puede darlos de alta en el menú principal.");
        }
    }

    public static void asignaturasProfesor(BufferedReader leer, Statement s) throws IOException, SQLException {
        if (Recursos.existenciaProfesor(s)) {
            Recursos.listaProfesores(leer, s);
            boolean validar;
            String dni;

            do {
                System.out.println("Introduce el DNI del profesor a buscar: ");
                dni = leer.readLine();
                validar = MisExcepciones.validarDNI(dni);
            } while (validar != true);
            
            if(Recursos.buscarProfesor(s, dni)!=0){
                ResultSet asignaturas = s.executeQuery("SELECT DISTINCT APA.ID_AS, A.NOMBRE FROM ALUMNOS_PROFESORES_ASIGNATURAS AS APA INNER JOIN ASIGNATURAS AS A ON APA.ID_AS=A.ID_AS WHERE APA.DNI = '"+dni+"'");
                if(asignaturas.first()){
                    System.out.println("Asignaturas del profesor de DNI "+dni+": ");
                    asignaturas.previous();
                    while(asignaturas.next()){
                        System.out.println(" - "+asignaturas.getString("A.NOMBRE"));
                    }
                }else{
                    System.out.println("Ese profesor no imparte ninguna asignatura.");
                }
                asignaturas.close();
            }else{
                System.out.println("No hay ningún profesor con DNI "+dni);
            }
        } else {
            System.out.println("No hay profesores en la base de datos. Puede darlos de alta en el menú principal.");
        }
    }

    public static void profesoresAsignatura(BufferedReader leer, Statement s) throws IOException, SQLException {
        Recursos.listaAsignaturas(leer, s);
        System.out.println("Introduce el ID de la asignatura que desea visualizar: ");
        int id = Integer.parseInt(leer.readLine());
        
        if(Recursos.buscarAsignatura(s, id)!=0){
            ResultSet profesores = s.executeQuery("SELECT DISTINCT P.NOMBRE FROM PROFESORES AS P INNER JOIN ALUMNOS_PROFESORES_ASIGNATURAS AS APA ON P.DNI=APA.DNI WHERE APA.ID_AS='"+id+"'");
            if(profesores.first()){
                    System.out.println("Profesores que imparten la asignatura de ID "+id+": ");
                    profesores.previous();
                    while(profesores.next()){
                        System.out.println(" - "+profesores.getString("P.NOMBRE"));
                    }
                }else{
                    System.out.println("Esa asignatura no es impartida por ningún profesor.");
                }
        }else{
            System.out.println("No hay ningúna asignatura con ese ID.");
        }
        
    }
}
