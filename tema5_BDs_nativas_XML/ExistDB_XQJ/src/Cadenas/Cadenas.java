/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cadenas;

/**
 *
 * @author Estefania
 */
public class Cadenas {
    
    public static void menuProductos(){
    System.out.println("*************************************************************************\n"
    +"************************** TAREA EXIST XQJ PRODUCTOS *********************************\n"
    +"1.-Ver todos los productos.\n"
    +"2.-Número de productos con precio mayor que 50.\n"
    +"3.-Número de productos por cada zona.\n"
    +"4.-Productos con precio mayor que 50 y zona 10, leyendo la consulta del fichero 'miconsulta.xq'\n"
    +"5.-Crear NUEVO_EMPLE10.mxl (donde se añade la información de los empleados del departamento 10)\n"
    +"6.-Mostrar los datos del documento productos.xml, si tenemos productos en distintos documentos se mostrarán las etiquetas de todos los documentos.\n\n"
    +"0.-SALIR");
    }

    public static void fin() {
        System.out.println("PROGRAMA FINALIZADO");
    }
    
    public static void defaultMensaje(){
    System.out.println("NO HA INTRODUCIDO NINGUNA DE LAS OPCIONES");
    }
    
}
