/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package introduccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author mrnovoa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            Connection connection = getConnection();


            String sql = "INSERT INTO Usuario (IdUsuario,login,nombre,ape1,ape2,password,fechaCreacion) VALUES (?,?,?,?,?,?,?)";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            java.util.Date ahora=new java.util.Date();

            preparedStatement.setInt(1,100);
            preparedStatement.setString(2,"epcasanova");
            preparedStatement.setString(3,"Estefanía");
            preparedStatement.setString(4,"Penide");
            preparedStatement.setString(5,"Casanova");
            preparedStatement.setString(6,"'1234'\"");
            preparedStatement.setTimestamp(7, new Timestamp(ahora.getTime()));


            preparedStatement.executeUpdate();


            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    static private Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3307/hibernateEj";
            String user = "root";
            String password = "usbw";

            Connection connection = DriverManager.getConnection(url, user, password);

            return connection;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
