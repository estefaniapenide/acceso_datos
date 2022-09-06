/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRODUCTOSYEMPLEADOS;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import net.xqj.exist.ExistXQDataSource;

/**
 *
 * @author Estefania
 */
public class ConexionXQJProductos {
    
     public XQConnection createConnection() {

        XQConnection conexion = null;
        try {
            XQDataSource recurso = new ExistXQDataSource();
            recurso.setProperty("serverName", "localhost");
            recurso.setProperty("port", "8080");
 
            //Configurados puerto y servidor , creamos conexi�n.
            conexion = recurso.getConnection("admin", "");
        } catch (XQException e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
}
