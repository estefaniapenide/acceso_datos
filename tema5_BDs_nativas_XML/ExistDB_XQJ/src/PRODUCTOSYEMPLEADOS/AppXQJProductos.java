/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PRODUCTOSYEMPLEADOS;

import Cadenas.Cadenas;
import ControlData.ControlData;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;

/**
 *
 * @author Estefania
 */
public class AppXQJProductos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XQException, IOException {

        Scanner input = new Scanner(System.in);

        ConexionXQJProductos exist = new ConexionXQJProductos();
        XQConnection connection = exist.createConnection();

        if (connection == null) {
            throw new IllegalArgumentException("Fallo al conectar con eXist. Los datos de conexión no son válidos");
        }

        byte op = 0;
        do {

            Cadenas.menuProductos();
            op = ControlData.leerByte(input);

            switch (op) {
                case 1:
                    CRUD.verproductos(connection);
                    break;
                case 2:
                    CRUD.cuentaproduc(connection);
                    break;
                case 3:
                    CRUD.numporzona(connection);
                    break;
                case 4:
                    CRUD.ejecutarconsultadefichero(connection);
                    break;
                case 5:
                    CRUD.creaemple10(connection);
                    break;
                case 6:
                    CRUD.muestraDatosProductosXML(connection);
                    break;
                case 0:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.defaultMensaje();
                    break;
            }

        } while (op != 0);

        if (connection != null) {
            connection.close();
        }
    }

}
