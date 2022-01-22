/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package autores_libros_estefania_penide;

import controldata.ControlData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class Autores_Libros_Estefania_Penide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        Statement sentencia = null;
        ResultSet rstAux = null;

        BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));

        int op = 0;
        do {
            System.out.println("-----------------BD LIBRERÍA------------------------------");
            Menus.Conexion();
            op = Integer.parseInt(lee.readLine());

            switch (op) {
                case 1:
                    System.out.println("CONEXIÓN MYSQL\n");
                    System.out.println("PUERTO:");
                    String puerto=lee.readLine();
                    System.out.println("USUARIO:");
                    String usuario=lee.readLine();
                    System.out.println("CONTRASEÑA:");
                    String password=lee.readLine();
                    
                    sentencia=Conexion.mySQL(puerto, usuario, password);
                    
                    CrearTablas.crearTablamMySQL(sentencia);
                    
                    opciones(sentencia, rstAux, lee);
                    break;
                case 2:
                     System.out.println("CONEXIÓN SQLITE\n");
                    
                     sentencia=Conexion.sqlite();
                     
                     CrearTablas.crearTablaSQLite(sentencia);
                     
                    opciones(sentencia, rstAux, lee);
                    break;
                case 3:
                   System.out.println("CONEXIÓN APACHE DERBY\n");
                    
                   sentencia=Conexion.apacheDerby();
                   
                   CrearTablas.crearTablaApacheDerby(sentencia);
                   
                    opciones(sentencia, rstAux, lee);
                    break;
                case 4:
                     System.out.println("CONEXIÓN H2\n");
                     
                    sentencia=Conexion.h2();
                    
                    CrearTablas.crearTablaH2(sentencia);
                    opciones(sentencia, rstAux, lee);
                    break;
                case 5:
                   
                    System.out.println("CONEXIÓN HSQLDB\n");
                    sentencia=Conexion.HSQLdb();
                    CrearTablas.crearTablaHSQLDB(sentencia);
                    opciones(sentencia, rstAux, lee);
                    break;
                case 0:
                    System.out.println("PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("No ha introducido ninguna de las opciones.");
                    break;

            }

        } while (op != 0);

    }

    public static void opciones(Statement sentencia, ResultSet rstAux, BufferedReader lee) throws IOException {
        int op = 0;
        do {
            Menus.Acciones();
            op = Integer.parseInt(lee.readLine());

            switch (op) {
                case 1:
                    InsertarFilas.insertarFila(sentencia, rstAux, lee);
                    break;
                case 2:
                    BorrarFilas.borrarFila(sentencia, rstAux, lee);
                    break;
                case 3:
                    ModificarFilas.modificarFila(sentencia, rstAux, lee);
                    break;
                case 4:
                    Consultar.consulta(sentencia, rstAux, lee);
                    break;
                case 0:
                    System.out.println("Volviendo al menú de conexiones...");
                    break;
                default:
                    System.out.println("No ha introducido ninguna de las opciones.");
                    break;

            }

        } while (op != 0);

    }

}
