/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author a20estefaniapc
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection conexion = getConexion();
        
        String sql="INSERT INTO Usuario (IdUsuario,login,nombre,ape1,ape2,password,fechaCreacion) VALUES (?,?,?,?,?,?,?)";
        
        try{
            
        PreparedStatement prepSt = conexion.prepareStatement(sql);
        
        }catch(SQLException e){
        e.printStackTrace();
        }
    }

    static private Connection getConexion() {

        Connection conexion = null;

        String url = "jdbc:mysql://localhost:3307/hibernateej";
        String user = "root";
        String password = "usbw";

        try {

            conexion = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexion;
    }

}
