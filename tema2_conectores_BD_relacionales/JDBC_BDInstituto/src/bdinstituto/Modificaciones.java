package bdinstituto;

import Excepciones.MisExcepciones;
import java.io.*;
import java.sql.*;

/**
 *
 * @author mrnovoa
 */
public class Modificaciones {

    public static void modificarNota(BufferedReader leer, Statement s) throws IOException, SQLException {
        try {

            boolean validar;
            float nuevanota;

            if (Recursos.existenciaAlumno(s)) {
                Recursos.listaAlumnos(leer, s);
                System.out.println("\nIntroduce que alumno desea modificar: ");
                int id_alumno = Integer.parseInt(leer.readLine());
                if (Recursos.buscarAlumno(s, id_alumno) != 0) {
                    Consultas.notasAlumno(leer, s, id_alumno);
                    System.out.println("Introduce el ID de la asignatura cuya nota desea modificar: ");
                    int id_asignatura = Integer.parseInt(leer.readLine());
                    ResultSet asignaturaNota = s.executeQuery("SELECT NOTA FROM NOTAS WHERE ID_AL='" + id_alumno + "' AND ID_AS='" + id_asignatura + "'");
                    if (asignaturaNota.first()) {
                        do {
                            System.out.println("La nota actual para esa asignatura es " + asignaturaNota.getFloat("NOTA") + ". Introduce la nueva nota:");
                            nuevanota = Float.parseFloat(leer.readLine());
                            validar = MisExcepciones.validarNota(nuevanota);
                        } while (validar != true);

                        System.out.println("Se va a cambiar la nota por " + nuevanota + ". Para confirmar pulse ENTER");
                        String confirmar = leer.readLine();
                        if (confirmar.equalsIgnoreCase("")) {
                            s.executeUpdate("UPDATE NOTAS SET NOTA='" + nuevanota + "' WHERE ID_AL='" + id_alumno + "' AND ID_AS='" + id_asignatura + "'");
                            System.out.println("Nota actualizada correctamente \n");
                        } else {
                            System.out.println("Modificación cancelada");
                        }
                    } else {
                        System.out.println("No se ha encontrado ninguna asignatura con ese ID para ese alumno.");
                    }
                } else {
                    System.out.println("No hay ningún alumno con ese ID.");
                }
            } else {
                System.out.println("No hay alumnos en la base de datos. Puede darlos de alta en el menú principal.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
