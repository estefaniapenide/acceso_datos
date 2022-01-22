

import java.sql.*;

public class FuncNombreMysql {
    public static void main(String[] args) throws ClassNotFoundException {
        try {

            //Class.forName("com.mysql.jdbc.Driver"); 
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ejemplo", "root", "usbw");

            // recuperar parametro de main
            String dep = "99";// args[0]; //departamento

            // MYSQL
            // CREATE FUNCTION nombre_dep(d int) RETURNS VARCHAR(15)
            /*
            use ejemplo;

            DROP FUNCTION IF EXISTS nombre_dep
            DELIMITER //
            CREATE FUNCTION nombre_dep(d int) 
            RETURNS VARCHAR(15) 
            DETERMINISTIC
            BEGIN

               DECLARE dnom VARCHAR(15) DEFAULT "";

               select  dnombre into dnom from departamentos where dept_no = d;

               RETURN dnom;

            END //

            DELIMITER ;

            select nombre_dep(10) as 'NombreDep';
            */

            // CREATE PROCEDURE datos_dep(d int, OUT nom VARCHAR(15),
            // OUT locali VARCHAR(15))
            /*
            CREATE PROCEDURE datos_dep(d int, OUT nom VARCHAR(15),
             OUT locali VARCHAR(15))

            BEGIN
                    SELECT dnombre,loc INTO nom,locali FROM departamentos 
                    WHERE dept_no = d;
           END

           call datos_dep(10,@nom,@locali);
           select @nom as 'NomDpto', @locali as 'LocDpto' ;
            */
            
            //FUNCTION
            String sql = "{ ? = call nombre_dep (?) } "; // MYSQL

            //PROCEDURE
            //String sql = "{call datos_dep(?,?,?) } "; // MYSQL

            // Preparamos la llamada
            CallableStatement llamada = conexion.prepareCall(sql);

            //PROCEDURE
//            llamada.setInt(1,Integer.parseInt(dep)); // param de entrada
//            llamada.registerOutParameter(2, Types.VARCHAR); // valor devuelto
//            llamada.registerOutParameter(3, Types.VARCHAR); // valor devuelto

            //FUNCTION
            llamada.registerOutParameter(1, Types.VARCHAR);
            llamada.setInt(2,Integer.parseInt(dep)); 
            
            llamada.executeUpdate(); // ejecutar el procedimiento
            
            //PROCEDURE
//            System.out.println("Nombre Dep: " + llamada.getString(2));
//            System.out.println("Loc Dep: " + llamada.getString(3));

            //FUNCTION
            System.out.println("Nombre Dep: " + llamada.getString(1));
            
            llamada.close();
            conexion.close();

        } catch (SQLException e) {
                e.printStackTrace();
        }
    }// fin de main
}// fin de la clase