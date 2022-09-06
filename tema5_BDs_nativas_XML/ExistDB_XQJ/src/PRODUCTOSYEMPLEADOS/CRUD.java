/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PRODUCTOSYEMPLEADOS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

/**
 *
 * @author Estefania
 */
public class CRUD {

    public static void verproductos(XQConnection connection) {

        String consultaXQuery = "for $producto in collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc return $producto";
        try {
            XQExpression query = connection.createExpression();
            XQResultSequence result = query.executeQuery(consultaXQuery);

            System.out.println("----TODOS LOS PRODUCTOS----");
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }

        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    public static void cuentaproduc(XQConnection connection) {

        String consultaXQuery = "for $numProductos in count(collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc[precio>50]) return $numProductos";
        try {
            XQExpression query = connection.createExpression();
            XQResultSequence result = query.executeQuery(consultaXQuery);

            System.out.print("NÚMERO DE PRODUCTOS CON PRECIO SUPERIOR A 50: ");
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }

        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    public static void numporzona(XQConnection connection) {

        String consultaXQuery = "for $zona in distinct-values(collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc/cod_zona)\n"
                + "let $con := count(collection('/db/ColeccionesXML/ColeccionPruebas')/productos/produc[cod_zona = $zona])\n"
                + "return concat('ZONA: ', $zona, '- NÚM. PRODUCTOS: ', $con)";
        try {
            XQExpression query = connection.createExpression();
            XQResultSequence result = query.executeQuery(consultaXQuery);

            System.out.println("--- NÚMERO DE PRODUCTOS POR ZONA --- ");
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }

        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    public static void ejecutarconsultadefichero(XQConnection connection) {

        //miconsulta.xq
        File fichero = new File("miconsulta.xq");

        String data = "";
        try {

            Scanner myReader = new Scanner(fichero);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String consultaXQuery = data;

        try {
            XQExpression query = connection.createExpression();
            XQResultSequence result = query.executeQuery(consultaXQuery);

            System.out.println("--- PRODUCTOS CON PRECIO SUPERIOR A 50 Y DE LA ZONA 10 --- ");
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }

        } catch (XQException e) {
            e.printStackTrace();
        }

    }

    public static void creaemple10(XQConnection connection) throws IOException {

        String consultaXQuery = "for $empleados10 in collection('/db/ColeccionesXML/ColeccionPruebas')/EMPLEADOS/EMP_ROW[DEPT_NO=10] return $empleados10";
        try {
            XQExpression query = connection.createExpression();
            XQResultSequence result = query.executeQuery(consultaXQuery);

            BufferedWriter bw = new BufferedWriter(new FileWriter("NUEVO_EMPLE10.xml"));
            bw.write("<?xml version='1.0' encoding='ISO-8859-1'?>" + "\n"+"<NUEVO_EMPLE10>\n");
            while (result.next()) {
                //String cad = result.toString();
                String cad = result.getItem().getItemAsString(null);
                //System.out.println(result.getItem().getItemAsString(null));
                System.out.println(" output " + cad); // visualizamos
                bw.write(cad + "\n"); // grabamos en el fichero

            }
            
            bw.write("</NUEVO_EMPLE10>");

            bw.close(); // Cerramos el fichero el fichero

        } catch (XQException e) {
            e.printStackTrace();
        }
    }

    public static void muestraDatosProductosXML(XQConnection connection) {

        String consultaXQuery = "/productos";
        try {
            XQPreparedExpression query = connection.prepareExpression(consultaXQuery);
            XQResultSequence result = query.executeQuery();

            System.out.println("DATOS DE TODOS LOS DOCUMENTOS productos.xml");
            while (result.next()) {
                System.out.println(result.getItemAsString(null));
            }

        } catch (XQException e) {
            e.printStackTrace();
        }
    }
}
