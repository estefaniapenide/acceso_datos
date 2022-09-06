/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LIBROS;

import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQMetaData;

/**
 *
 * @author Estefania
 */
public class ConexionXQJLibros {

    public static String nomClaseDS = "net.xqj.exist.ExistXQDataSource";

    public static XQConnection obtenConexion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, XQException {
        XQDataSource xqs = (XQDataSource) Class.forName(nomClaseDS).newInstance();

        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        xqs.setProperty("user", "admin");
        xqs.setProperty("password", "");

        return xqs.getConnection();
    }

    public static void muestraErrorXQuery(XQException e) {
        System.err.println("XQuery ERROR mensaje: " + e.getMessage());
        System.err.println("XQuery ERROR causa: " + e.getCause());
        System.err.println("XQuery ERROR código: " + e.getVendorCode());
    }
}
