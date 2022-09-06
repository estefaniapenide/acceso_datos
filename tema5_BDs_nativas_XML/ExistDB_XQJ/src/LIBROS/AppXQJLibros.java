/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package LIBROS;

import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQMetaData;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

/**
 *
 * @author Estefania
 */
public class AppXQJLibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        XQConnection conexion = null;
        try {
            conexion = ConexionXQJLibros.obtenConexion();
            XQMetaData xqmd = conexion.getMetaData();
            System.out.println("Conexión establecida como: " + xqmd.getUserName());
            System.out.println(
                                    "Producto: " +xqmd.getProductName()+", "+"versión: " +xqmd.getXQJMajorVersion()+"."+xqmd.getXQJMinorVersion()+".\n"+
                                "Soporte para transacciones: " + (xqmd.isTransactionSupported() ? "Sí" : "No") + ".\n"
                           + "Validación con esquemas: "+ (xqmd.isSchemaValidationFeatureSupported() ? "Sí" : "No")+".\n"
                           + "Serialización: "+ (xqmd.isSerializationFeatureSupported() ? "Sí" : "No")+".\n"
            );
            
            
            //preparepareExpresion->XPath
            //createExpresion->XQuery
//            
//            String cadena1="for $con in doc('file:///F:\\asignaturas_segundo\\acceso_a_datos\\tema5_BDs_nativas_XML\\Material Complementario-20220406\\collection\\libros.xml')/bib/libro return $con";
//            
//            XQPreparedExpression consultaA = (XQPreparedExpression) conexion.createExpression(cadena1);
//            XQResultSequence resultadoA = consultaA.executeQuery();
            
            String cadena2="collection('db/apps/collection')/bib/libro";
            String cadena3="/bib/libro";
            XQPreparedExpression consulta = conexion.prepareExpression(cadena3);
            XQResultSequence resultado = consulta.executeQuery();
             
            while(resultado.next()){
                System.out.println("LIBRO:\n " +resultado.getItemAsString(null));
            }
            
            String cadena5 ="count(/bib/libro)";
            XQPreparedExpression consulta2 = conexion.prepareExpression(cadena5);
            XQResultSequence resultado2 = consulta2.executeQuery();
             
            while(resultado2.next()){
                System.out.println("TOTAL LIBROS:\n " +resultado2.getItemAsString(null));
            }
            
            
            
            
            
            
        } catch (XQException e) {
            ConexionXQJLibros.muestraErrorXQuery(e);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (XQException xe) {
                xe.printStackTrace();
            }
        }
    }
    
}
