/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author mrnovoa
 */
import java.sql.*;

public class EjemploSingletonMySQL {

    // Propiedades
    private static Connection conn = null;
    private String url;
    private String usuario;
    private String password;
 
    // Constructor
    private EjemploSingletonMySQL(){

        String url = "jdbc:mysql://localhost:3307/libreria";
        String usuario = "root";
        String password = "usbw";

        try{
            conn = DriverManager.getConnection(url, usuario, password);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    } // Fin constructor

    // Métodos
    public static Connection getConnection(){

        if (conn == null){
            new EjemploSingletonMySQL();
        }

        return conn;
    } // Fin getConnection   
}
