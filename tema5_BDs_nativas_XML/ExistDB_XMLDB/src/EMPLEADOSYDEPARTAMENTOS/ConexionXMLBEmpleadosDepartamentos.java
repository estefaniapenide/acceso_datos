/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMPLEADOSYDEPARTAMENTOS;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;

/**
 *
 * @author a20estefaniapc
 */
public class ConexionXMLBEmpleadosDepartamentos {

    public static Collection coleccion = null;

    public static Collection obtenColeccion() throws Exception {

        // Declaración del driver de XML:DB para eXist
        String driver = "org.exist.xmldb.DatabaseImpl";
        // Inicializar el driver
        Class clase = Class.forName(driver); // cargar el driver
        Database database = (Database) clase.getDeclaredConstructor().newInstance(); // Instanciamos la BD 
        DatabaseManager.registerDatabase(database); // registro de la BD 

        String uri = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionesXML";
        String user = "admin";
        String pass = "";
        Collection col = (Collection) DatabaseManager.getCollection(uri, user, pass);

        System.out.println("CONEXIÓN ESTABLECIDA\n");

        return col;
    }

}
