package autores_libros_estefania_penide;

import java.sql.*;

/**
 *
 * @author
 */
public class CrearTablas {

    public static void crearTablamMySQL(Statement sentencia) {
        try {
            sentencia.execute("CREATE DATABASE IF NOT EXISTS LIBRERIA;");
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

            System.out.println("BD LIBRERÍA LISTA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }
    }

    public static void crearTablaSQLite(Statement sentencia) {
        try {
            
            sentencia.execute("DROP TABLE IF EXISTS AUTORES");
            sentencia.execute("CREATE TABLE IF NOT EXISTS AUTORES"
                    + "(dniAutor VARCHAR(30) NOT NULL,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "nacionalidad VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (dniAutor))");

            sentencia.execute("DROP TABLE IF EXISTS LIBROS");
            sentencia.execute("CREATE TABLE IF NOT EXISTS LIBROS "
                    + "(idLibro INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                    + "titulo VARCHAR(30) NOT NULL,"
                    + "precio INT NOT NULL,"
                    + "autor VARCHAR(30) NOT NULL,"
                    + " FOREIGN KEY (autor) references AUTORES(dniAutor)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");

            System.out.println("BD LIBRERÍA LISTA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }

    }

    public static void crearTablaApacheDerby(Statement sentencia) {
        try {
            //sentencia.execute("CREATE DATABASE IF NOT EXISTS LIBRERIA;");
            //sentencia.execute("USE LIBRERIA;");
            sentencia.execute("DROP TABLE AUTORES");//No se puede usar IF EXISTS/IF NOT EXISTS
            sentencia.execute("CREATE TABLE AUTORES (\n"
                    + "dniAutor VARCHAR(30) NOT NULL,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "nacionalidad VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (dniAutor))");
                  //  + "ENGINE INNODB;");
            // sentencia.execute("DROP TABLE LIBROS");
            sentencia.execute("CREATE TABLE LIBROS"
                    + "(idLibro INETGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),\n"
                    + "titulo VARCHAR(30) NOT NULL,"
                    + "precio INT NOT NULL,"
                    + "autor VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (idLibro),"
                    + " FOREIGN KEY (autor) references AUTORES(dniAutor)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");
                //    + "ENGINE INNODB;");

            System.out.println("BD LIBRERÍA LISTA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }

    }

    public static void crearTablaH2(Statement sentencia) {
        try {

            sentencia.execute("CREATE TABLE IF NOT EXISTS AUTORES"
                    + "(dniAutor VARCHAR(30) NOT NULL,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "nacionalidad VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (dniAutor))");

            sentencia.execute("CREATE TABLE IF NOT EXISTS LIBROS "
                    + "(idLibro INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "titulo VARCHAR(30) NOT NULL,"
                    + "precio INT NOT NULL,"
                    + "autor VARCHAR(30) NOT NULL,"
                    + " FOREIGN KEY (autor) references AUTORES(dniAutor)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");

            System.out.println("BD LIBRERÍA LISTA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }

    }

    public static void crearTablaHSQLDB(Statement sentencia) {
        try {
            //sentencia.execute("CREATE DATABASE IF NOT EXISTS LIBRERIA;");
            //sentencia.execute("USE LIBRERIA;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS AUTORES "
                    + "(dniAutor VARCHAR(30) NOT NULL,"
                    + "nombre VARCHAR(30) NOT NULL,"
                    + "nacionalidad VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (dniAutor))");
                //    + "ENGINE INNODB;");
            sentencia.execute("CREATE TABLE IF NOT EXISTS LIBROS "
                    + "(idLibro INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "titulo VARCHAR(30) NOT NULL,"
                    + "precio INT NOT NULL,"
                    + "autor VARCHAR(30) NOT NULL,"
                    + "PRIMARY KEY (idLibro),"
                    + " FOREIGN KEY (autor) references AUTORES(dniAutor)"
                    + " ON DELETE CASCADE"
                    + " ON UPDATE CASCADE)");
                 //   + "ENGINE INNODB;");

            System.out.println("BD LIBRERÍA LISTA");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(5);

        }

    }
}
