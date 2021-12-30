package aad_ejercicio1;

import java.sql.*;

/**
 *
 * @author 
 */
public class CrearTablas {

    public static void crearTabla(Statement sentencia) {
        try {
            sentencia.execute("CREATE DATABASE IF NOT EXISTS LIBRERIADANI;");
            sentencia.execute("USE LIBRERIADANI;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS AUTORES"
                    + "(dniAutor VARCHAR(30) NOT NULL,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "nacionalidad VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (dniAutor))"
                    + "ENGINE INNODB;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS LIBROS "
                    + "(idLibro INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "titulo VARCHAR(30) NOT NULL,"
                    + "precio INT NOT NULL,"
                    + "autor VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (idLibro),"
                    + " FOREIGN KEY (autor) references AUTORES(dniAutor)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }
    }
}
