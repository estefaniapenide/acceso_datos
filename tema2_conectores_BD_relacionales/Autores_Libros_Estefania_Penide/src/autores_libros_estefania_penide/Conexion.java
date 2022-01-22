/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autores_libros_estefania_penide;

import autores_libros_estefania_penide.CrearTablas;
import java.sql.Statement;
import controldata.ControlData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Conexion {

    public static Statement mySQL(String puerto, String usuario, String password) {

        Statement sentencia = null;

        //Para my server de mysql en casa
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:" + puerto + "/?user=" + usuario + "&password=" + password;

        /*No es necesario desde la ultima versión
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("No se encontro el driver" + driver);
            System.exit(1);
        }*/
        try {
            Connection conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement();
            System.out.println("CONEXIÓN CON MYSQL LISTA");
        } catch (SQLException e) {
            System.out.println(e + "No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }
        return sentencia;
    }

    public static Statement sqlite() {
        Statement sentencia = null;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:sqlite:./BD/SQLITE/librosSqlite.db");
            sentencia = conexion.createStatement();
            System.out.println("CONEXIÓN CON SQLITE LISTA");
        } catch (SQLException e) {
            System.out.println(e + "No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }

        return sentencia;
    }

    public static Statement apacheDerby() {
        Statement sentencia = null;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:derby:./BD/ApacheDerby/librosApache;create=true");
            sentencia = conexion.createStatement();
            System.out.println("CONEXIÓN CON APACHE DERBY LISTA");
        } catch (SQLException e) {
            System.out.println(e + "No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }

        return sentencia;
    }
    
     public static Statement h2() {
        Statement sentencia = null;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:h2:./BD/H2/librosH2");;
            sentencia = conexion.createStatement();
            System.out.println("CONEXIÓN CON H2 LISTA");
        } catch (SQLException e) {
            System.out.println(e + "No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }

        return sentencia;
    }
     
          public static Statement HSQLdb() {
        Statement sentencia = null;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:hsqldb:file:./BD/HQSLDB/librosHSQLdb");
            sentencia = conexion.createStatement();
            System.out.println("CONEXIÓN CON HSQLdb LISTA");
        } catch (SQLException e) {
            System.out.println(e + "No hay ningún Driver registrado que reconozca la URL especificada");
            System.exit(2);
        } catch (Exception e) {
            System.out.println("\n\t Se ha producido algún otro error.");
            System.exit(3);
        }

        return sentencia;
    }

}
