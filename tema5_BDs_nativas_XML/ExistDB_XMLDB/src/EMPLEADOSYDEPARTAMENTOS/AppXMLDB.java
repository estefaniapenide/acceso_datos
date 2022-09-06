/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMPLEADOSYDEPARTAMENTOS;

import Cadenas.Cadenas;
import ControlData.ControlData;
import static EMPLEADOSYDEPARTAMENTOS.ConexionXMLBEmpleadosDepartamentos.coleccion;
import java.io.File;
import java.util.Scanner;
import org.xmldb.api.base.Collection;

/**
 *
 * @author a20estefaniapc
 */
public class AppXMLDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("\n1.1.Realiza una conexión con la BD para acceder al documento empleados.xml");
        ConexionXMLBEmpleadosDepartamentos.coleccion = ConexionXMLBEmpleadosDepartamentos.obtenColeccion();

        System.out.println("\n1.2.Obtener los empleados del departamento 10");
        CRUD.verempleados10();

        System.out.println("\n2.1.Implementar vercolecciones()");
        CRUD.vercolecciones();

        System.out.println("\n2.1.Implementar verrecursosdelascolecciones()");
        CRUD.verrecursosdelascolecciones();

        System.out.println("\n3.1.Crear colección y subir archivo");
        String ruta = "nuevo.xml";
        CRUD.crearcoleccionysubirarchivo(ruta);
        System.out.println(coleccion.getChildCollection("nuevaColeccion").getName());
        String recursos[] = coleccion.getChildCollection("nuevaColeccion").listResources();
        for (int i = 0; i < recursos.length; i++) {
            System.out.println("\t" + recursos[i]);
        }

        System.out.println("\n3.2.Borrar fichero");
        ruta = "nuevo.xml";
        Collection colect = coleccion.getChildCollection("nuevaColeccion");
        CRUD.borrarFichero(ruta, colect);
        System.out.println("Fichero "+ruta+" de la colección "+colect.getName()+" borrado.");

        System.out.println("\n3.3.Borrar colección");
        Collection col = coleccion.getChildCollection("nuevaColeccion");
        CRUD.borrarcoleccion(col);
        System.out.println("Colección "+col.getName()+"borrada.");

        System.out.println("\n4.Añadir documento NuevosDepartamentos.xml");
        File documento = new File("NuevosDepartamentos.xml");
        CRUD.documentoNuevoALaColeccion(documento);
        System.out.println("Documento añadido.");
        CRUD.verrecursosdelascolecciones();

        System.out.println("\n5.Crear colección y subir archivo crearcoleccysubirarchivo(String colecc, File archivo)");
        String colecc="coleccion5";
        File archivo = new File("nuevo.xml");
        CRUD.crearcoleccionysubirarchivo(colecc, archivo);
        System.out.println(coleccion.getChildCollection(colecc).getName());
        String recursosNuevaColeccion[] = coleccion.getChildCollection(colecc).listResources();
        for (int i = 0; i < recursosNuevaColeccion.length; i++) {
            System.out.println("\t" + recursosNuevaColeccion[i]);
        }

        System.out.println("\n6.Borrar el documento anterior de la colección, comprobando si existe");
        Collection c = coleccion.getChildCollection("coleccion5");
        CRUD.borrarFichero("nuevo.xml", c);
         System.out.println("Fichero nuevo.xml de la coleccion "+c.getName()+" borrado.");

        System.out.println("\n7.Actualizar el stock. Añadir 10 al stock");
        CRUD.actualizaproductos();
        System.out.println("Stock actualizado");


        System.out.println("\n8.Buscar, extraer y guardar un documento");
        CRUD.bajardocumento();
        
        System.out.println("\n9.Ejecutar consulta en fichero 'miconsulta.xq'. Productos con precio > 50 y zona 10");
        CRUD.ejecutarconsultafichero("miconsulta.xq");

        ConexionXMLBEmpleadosDepartamentos.coleccion.close();
    }

}
