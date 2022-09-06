/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EMPLEADOSYDEPARTAMENTOS;

import static EMPLEADOSYDEPARTAMENTOS.ConexionXMLBEmpleadosDepartamentos.coleccion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.CollectionManagementService;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author a20estefaniapc
 */
public class CRUD {

    public static void verempleados10() {

        try {
            // Creamos el servicio:
            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
            // creamos la consulta
            String strAction = "for $emp in /EMPLEADOS/EMP_ROW[DEPT_NO = 10] return $emp";
            // Para ejecutar la consulta se llama al método: service.query(xpath). Este método devuelve un objeto de la clase 
            //'ResourceSet' que contiene el resultado de la consulta.
            ResourceSet result = service.query(strAction);
            // Vamos avanzando en cada uno de los resultados con ayuda del método .getIterator() sobre nuestro resultado.

            ResourceIterator i = result.getIterator();

            while (i.hasMoreResources()) {// Ver si hay algo:
                // Mostrar la respuesta

                Resource r = (Resource) i.nextResource();
                System.out.println((String) r.getContent());
            }

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void vercolecciones() {

        try {

            System.out.println("Colección: " + coleccion.getName());

            int numHijas = coleccion.getChildCollectionCount();
            System.out.println(numHijas + " colecciones hijas.");
            if (numHijas > 0) {
                String nomHijas[] = coleccion.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    System.out.println("\t" + nomHijas[i]);
                }
            }

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void verrecursosdelascolecciones() {
        try {

            int numDocs = coleccion.getResourceCount();
            System.out.println(numDocs + " documentos.");
            if (numDocs > 0) {
                String nomDocs[] = coleccion.listResources();
                for (int i = 0; i < numDocs; i++) {
                    System.out.println("\t" + nomDocs[i]);
                }
            }

            int numHijas = coleccion.getChildCollectionCount();
            if (numHijas > 0) {
                String nomHijas[] = coleccion.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    Collection colecc = coleccion.getChildCollection(nomHijas[i]);
                    System.out.println("\t" + nomHijas[i]);
                    int numRecursos = colecc.getResourceCount();
                    if (numRecursos > 0) {
                        String recursosHijas[] = colecc.listResources();
                        for (int j = 0; j < numRecursos; j++) {
                            System.out.println("\t\t" + recursosHijas[j]);
                        }
                    }

                }
            }
        } catch (XMLDBException E) {
            E.printStackTrace();
        }
    }

    public static void crearcoleccionysubirarchivo(String ruta) {
        try {
            //Crear una nueva colección
            CollectionManagementService mgtService = (CollectionManagementService) coleccion.getService("CollectionManagementService", "1.0");
            mgtService.createCollection("nuevaColeccion");

            // Subir un fichero que haya en el disco duro:
            File file = new File(ruta);
            Collection col = coleccion.getChildCollection("nuevaColeccion");

            Resource resource = col.createResource(file.getName(), "XMLResource");
            resource.setContent(file);
            col.storeResource(resource);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void borrarFichero(String ruta, Collection col) {
        try {
            Resource resource = col.getResource(ruta);
            col.removeResource(resource);

        } catch (XMLDBException E) {
            E.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("No existe el fichero");
        }

    }

    public static void borrarcoleccion(Collection col) {
        try {
            //Borrar una colección
            CollectionManagementService mgtService = (CollectionManagementService) coleccion.getService("CollectionManagementService", "1.0");
            mgtService.removeCollection(col.getName());

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void documentoNuevoALaColeccion(File documento) {

        try {

            Resource resource = coleccion.createResource(documento.getName(), "XMLResource");
            resource.setContent(documento);
            coleccion.storeResource(resource);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }
    }

    public static void crearcoleccionysubirarchivo(String colecc, File archivo) {
        try {
            //Crear una nueva colección
            CollectionManagementService mgtService = (CollectionManagementService) coleccion.getService("CollectionManagementService", "1.0");
            mgtService.createCollection(colecc);

            // Subir un fichero que haya en el disco duro:
            Collection col = coleccion.getChildCollection(colecc);

            Resource resource = col.createResource(archivo.getName(), "XMLResource");
            resource.setContent(archivo);
            col.storeResource(resource);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void actualizaproductos() {

        try {

            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
            String strAction = "for $stock in /productos/produc/stock_actual\n"
                    + "return update value $stock with $stock+10";
            ResourceSet result = service.query(strAction);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }
    }

    public static void bajardocumento() {

        try {
            Collection col = coleccion.getChildCollection("BDProductosXML");
            
            XMLResource res = (XMLResource) col.getResource("zonas.xml");

            
            System.out.println("ID del documento: " + res.getDocumentId());
            // Volcado del documento a un arbol DOM
            Node document = (Node) res.getContentAsDOM();
            Source source = new DOMSource(document);
            // Volcado del documento de memoria a consola
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);
            // Volcado del documento a un fichero
            Result fichero = new StreamResult(new java.io.File("./zonas.xml"));
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, fichero);

        } catch (TransformerConfigurationException E) {
            E.printStackTrace();
        } catch (TransformerException E) {
            E.printStackTrace();

        } catch (XMLDBException E) {
            E.printStackTrace();

        }

    }

    public static void ejecutarconsultafichero(String fichero) {
        //miconsulta.xq

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(fichero));
            String linea = null;
            StringBuilder stringBuilder = new StringBuilder();
            String salto = System.getProperty("line.separator");

            while ((linea = entrada.readLine()) != null) {
                stringBuilder.append(linea);
                stringBuilder.append(salto);
            }
            String consulta = stringBuilder.toString();

            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

            ResourceSet result = service.query(consulta);

            ResourceIterator i = result.getIterator();
            while (i.hasMoreResources()) {
                Resource r = (Resource) i.nextResource();
                System.out.println((String) r.getContent());
            }

        } catch (FileNotFoundException e) {
            System.out.println("No existe el archivo " + fichero);
            e.printStackTrace();
        } catch (XMLDBException E) {
            E.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void listarDepartamentos() {

        try {
            // Creamos el servicio:
            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
            // creamos la consulta
            String strAction = "for $dep in /departamentos/DEP_ROW return $dep";
            // Para ejecutar la consulta se llama al método: service.query(xpath). Este método devuelve un objeto de la clase 
            //'ResourceSet' que contiene el resultado de la consulta.
            ResourceSet result = service.query(strAction);
            // Vamos avanzando en cada uno de los resultados con ayuda del método .getIterator() sobre nuestro resultado.

            ResourceIterator i = result.getIterator();

            while (i.hasMoreResources()) {// Ver si hay algo:
                // Mostrar la respuesta

                Resource r = (Resource) i.nextResource();
                System.out.println((String) r.getContent());
            }

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void insertarDepartamento21() {

        String dep = "21";
        String dnombre = "El 21";
        String loc = "Vigo";

        String nuevodep = "<DEP_ROW>\n<DEPT_NO>" + dep + "</DEPT_NO>\n"
                + "<DNOMBRE>" + dnombre + "</DNOMBRE>\n<LOC>" + loc + "</LOC>\n"
                + "</DEP_ROW>";

        try {

            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

            String strAction = "update insert " + nuevodep + "into/departamentos";

            ResourceSet result = service.query(strAction);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void consultarUnDepartamentos(String numDepartamento) {

        try {
            // Creamos el servicio:
            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
            // creamos la consulta
            String strAction = "for $dep in /departamentos/DEP_ROW[DEPT_NO = " + numDepartamento + "] return $dep";
            // Para ejecutar la consulta se llama al método: service.query(xpath). Este método devuelve un objeto de la clase 
            //'ResourceSet' que contiene el resultado de la consulta.
            ResourceSet result = service.query(strAction);
            // Vamos avanzando en cada uno de los resultados con ayuda del método .getIterator() sobre nuestro resultado.

            ResourceIterator i = result.getIterator();

            while (i.hasMoreResources()) {// Ver si hay algo:
                // Mostrar la respuesta

                Resource r = (Resource) i.nextResource();
                System.out.println((String) r.getContent());
            }

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void modificarDepartamento(String numDepartamento, String nombreNuevo) {

        try {

            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

            String strAction = "update value /departamentos/DEP_ROW[DEPT_NO=" + numDepartamento + "]/DNOMBRE with '" + nombreNuevo + "'";

            ResourceSet result = service.query(strAction);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

    public static void borrarDepartamento(String numDepartamento) {

        try {

            XPathQueryService service = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

            String strAction = "update delete /departamentos/DEP_ROW[DEPT_NO=" + numDepartamento + "]";

            ResourceSet result = service.query(strAction);

        } catch (XMLDBException E) {
            E.printStackTrace();
        }

    }

}
