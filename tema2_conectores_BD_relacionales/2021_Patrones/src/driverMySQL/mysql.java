/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driverMySQL;

/**
 *
 * @author mrnov
 */

import java.sql.*;

/**
   * Eliminar STU ID = 6
 */

public class mysql {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs=null;

                 // 1. Registro del controlador
        try {
            //En los nuevos .jar no hace falta ya
           // Class.forName("com.mysql.cj.jdbc.Driver");
                         // 2. Defina SQL
            String sql = "select * from empregados";
                         // 3. Obtener el objeto de conexión
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa?useSSL=false&serverTimezone=UTC", "root", "root");
                         // 4. Obtener la declaración de objetos SQL
            stmt = conn.createStatement();
                         // 5. Ejecutar SQL
            rs = stmt.executeQuery(sql);
                         // 6. Resultados de procesamiento
                         //6.1 Deja que el cursor se mueva hacia abajo una línea
            rs.next();
                         //6.2 Obtener datos
            // int id=rs.getInt(1);
            String nif = rs.getString("NIFE");
            String name = rs.getString("NomeE");
//            int age=rs.getInt("age");
            String cate=rs.getString("IdCateE");
            int depa=Integer.parseInt(rs.getString("IdDepaE"));

            //System.out.println(id+"--"+name+"---"+age+"--"+gender);
            System.out.println(nif+"--"+name+"---"+cate+"--"+depa);
            //+cate+"--"+depa

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //stmt.close();
             // 7. Recurso de lanzamiento
             // Evitar las anomalías de los punteros vacíos
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
