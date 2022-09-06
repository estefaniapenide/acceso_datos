package bdinstituto;

import java.sql.*;

/**
 *
 * @author mrnovoa
 */
public class CrearBD {

    public static void crear(Statement s) throws SQLException {

        //Creación de la base de datos
        s.execute("CREATE DATABASE IF NOT EXISTS BDInstituto");
        s.execute("USE BDInstituto");

        //Creación de la tabla de profesores
        s.execute("CREATE TABLE IF NOT EXISTS PROFESORES ("
                + "DNI CHAR(9) NOT NULL,"
                + "NOMBRE VARCHAR(30) NOT NULL,"
                + "TITULACION VARCHAR(30) NOT NULL,"
                + "PRIMARY KEY (DNI));");

        //Creación de la tabla de alumnos
        s.execute("CREATE TABLE IF NOT EXISTS ALUMNOS ("
                + "ID_AL INT(4) UNSIGNED ZEROFILL AUTO_INCREMENT NOT NULL,"
                + "CODIGO CHAR(4) NOT NULL,"
                + "NOMBRE VARCHAR(30) NOT NULL,"
                + "PRIMARY KEY (ID_AL),"
                + "UNIQUE INDEX ak1_codigoalumno (CODIGO));");

        //Creación de la tabla de asignaturas
        s.execute("CREATE TABLE IF NOT EXISTS ASIGNATURAS ("
                + "ID_AS INT(4) UNSIGNED ZEROFILL AUTO_INCREMENT NOT NULL,"
                + "CODIGO CHAR(4) NOT NULL,"
                + "NOMBRE VARCHAR(50) NOT NULL,"
                + "CICLO VARCHAR(30) NOT NULL,"
                + "PRIMARY KEY (ID_AS),"
                + "UNIQUE INDEX ak1_codigoasignatura (CODIGO));");

        //Creación de la tabla alumnos_profesores_asignaturas
        s.execute("CREATE TABLE IF NOT EXISTS ALUMNOS_PROFESORES_ASIGNATURAS ("
                + "ID_AL INT(4) UNSIGNED ZEROFILL NOT NULL,"
                + "DNI CHAR(9) NOT NULL,"
                + "ID_AS INT(4) UNSIGNED ZEROFILL NOT NULL,"
                + "PRIMARY KEY (ID_AL, ID_AS),"
                + "FOREIGN KEY (ID_AL) REFERENCES ALUMNOS(ID_AL)"
                + "             ON DELETE CASCADE"
                + "             ON UPDATE CASCADE,"
                + "FOREIGN KEY (DNI) REFERENCES PROFESORES(DNI)"
                + "             ON DELETE CASCADE"
                + "             ON UPDATE CASCADE,"
                + "FOREIGN KEY (ID_AS) REFERENCES ASIGNATURAS(ID_AS)"
                + "             ON DELETE CASCADE"
                + "             ON UPDATE CASCADE);");

        //Creación de la tabla de notas
        s.execute("CREATE TABLE IF NOT EXISTS NOTAS ("
                + "ID_AL INT(4) UNSIGNED ZEROFILL NOT NULL,"
                + "ID_AS INT(4) UNSIGNED ZEROFILL NOT NULL,"
                + "FECHA DATE NOT NULL,"
                + "NOTA FLOAT NOT NULL,"
                + "PRIMARY KEY (ID_AL, ID_AS, FECHA),"
                + "FOREIGN KEY (ID_AL) REFERENCES ALUMNOS(ID_AL)"
                + "             ON DELETE CASCADE"
                + "             ON UPDATE CASCADE,"
                + "FOREIGN KEY (ID_AS) REFERENCES ASIGNATURAS(ID_AS)"
                + "             ON DELETE CASCADE"
                + "             ON UPDATE CASCADE);");

        ResultSet asignaturas = s.executeQuery("SELECT COUNT(*) FROM ASIGNATURAS;");
        asignaturas.next();
        if (asignaturas.getInt(1) == 0) {
            //Insertamos asignaturas en la base de datos
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('001P', 'Programación', '1º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('002B', 'Bases de Datos', '1º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('003S', 'Sistemas Informáticos', '1º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('004C', 'Contornos de Desarrollo', '1º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('005L', 'Lenguaje de Marcas', '1º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('006A', 'Acceso a Datos', '2º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('007D', 'Desarrollo de Interfaces', '2º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('008P', 'Programación Multimedia y Dispositivos Móviles', '2º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('009P', 'Programación de Servicios y Procesos', '2º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('010S', 'Sistemas de Gestión Empresarial', '2º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('011B', 'Bases de Datos', '1º ASIR')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('012F', 'Fundamentos de Hardware', '1º ASIR')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('013R', 'Redes', '1 ASIR')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('014I', 'Implantación de Sistemas Operativos', '1º ASIR')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('015L', 'Lenguaje de Marcas', '1º ASIR')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('016F', 'Formación y Orientación Laboral', '1º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('017F', 'Formación y Orientación Laboral', '1º ASIR')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('018E', 'Empresa e Iniciativa Emprendedora', '2º DAM')");
            s.executeUpdate("INSERT INTO ASIGNATURAS (CODIGO, NOMBRE, CICLO) VALUES ('019E', 'Empresa e Iniciativa Emprendedora', '2º ASIR')");

        }
        
        asignaturas.close();
    }

}
