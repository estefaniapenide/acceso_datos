package bdinstituto;

import java.io.*;
import java.sql.*;

/**
 *
 * @author mrnovoa
 */
public class Recursos {

    public static boolean existenciaProfesor(Statement s) throws SQLException {
        boolean existencia;
        
        ResultSet profe = s.executeQuery("SELECT COUNT(*) FROM PROFESORES");
        profe.next();
        if(profe.getInt(1)!=0){
            existencia = true;
        } else {
            existencia = false;
        }
        
        profe.close();
        
        return existencia;
    }
    
    public static boolean existenciaAlumno(Statement s) throws SQLException {
        boolean existencia;
        
        ResultSet alumno = s.executeQuery("SELECT COUNT(*) FROM ALUMNOS");
        alumno.next();
        if(alumno.getInt(1)!=0){
            existencia = true;
        } else {
            existencia = false;
        }
        
        alumno.close();
        
        return existencia;
    }
    
    public static int buscarProfesor(Statement s, String dni) throws SQLException {
        ResultSet profesor = s.executeQuery("SELECT COUNT(*) FROM PROFESORES WHERE DNI='"+dni+"'");
        profesor.next();
        int numero = profesor.getInt(1);
        
        profesor.close();
        
        return numero;
    }
    
    public static int buscarAlumno(Statement s, int id) throws SQLException {
        ResultSet alumno = s.executeQuery("SELECT COUNT(*) FROM ALUMNOS WHERE ID_AL='"+id+"'");
        alumno.next();
        int numero = alumno.getInt(1);
        
        alumno.close();
        
        return numero;
    }
    
    public static int buscarAsignatura(Statement s, int id) throws SQLException {
        ResultSet asignatura = s.executeQuery("SELECT COUNT(*) FROM ASIGNATURAS WHERE ID_AS='"+id+"'");
        asignatura.next();
        int numero = asignatura.getInt(1);
        
        asignatura.close();
        
        return numero;
    }

    public static void listaProfesores(BufferedReader leer, Statement s) throws IOException, SQLException {
        ResultSet profesores = s.executeQuery("SELECT * FROM PROFESORES;");
        
        System.out.println("---------------LISTA DE PROFESORES--------------");
        System.out.printf("%-9s %-30s %-30s %n", "DNI", "NOMBRE", "TITULACIÓN");
        
        while(profesores.next()){
            System.out.printf("%-9s %-30s %-30s %n", profesores.getString("DNI"), profesores.getString("NOMBRE"), profesores.getString("TITULACION"));
        }
        
        profesores.close();
        
    }

    public static void listaAsignaturas(BufferedReader leer, Statement s) throws IOException, SQLException {
        ResultSet asignaturas = s.executeQuery("SELECT * FROM ASIGNATURAS;");
        
        System.out.println("---------------LISTA DE ASIGNATURAS--------------");
        System.out.printf("%-4s %-6s %-50s %-30s %n", "ID", "CODIGO", "NOMBRE", "CICLO");
        
        while(asignaturas.next()){
            System.out.printf("%-4s %-6s %-50s %-30s %n", asignaturas.getInt("ID_AS"), asignaturas.getString("CODIGO"), asignaturas.getString("NOMBRE"), asignaturas.getString("CICLO"));
        }
        
        asignaturas.close();
    }
    
    public static void listaAlumnos(BufferedReader leer, Statement s) throws IOException, SQLException {
        ResultSet alumnos = s.executeQuery("SELECT * FROM ALUMNOS;");
        
        System.out.println("---------------LISTA DE ALUMNOS--------------");
        System.out.printf("%-4s %-4s %-30s %n", "ID", "CODIGO", "NOMBRE");
        
        while(alumnos.next()){
            System.out.printf("%-4s %-4s %-30s %n", alumnos.getInt("ID_AL"), alumnos.getString("CODIGO"), alumnos.getString("NOMBRE"));
        }
        
        alumnos.close();
    }
}