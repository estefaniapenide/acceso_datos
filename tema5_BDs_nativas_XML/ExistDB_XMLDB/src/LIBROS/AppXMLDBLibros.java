/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LIBROS;

import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Service;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author a20estefaniapc
 */
public class AppXMLDBLibros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Collection col = null;
        try {
            col = ConexionXMLDBLibros.obtenColeccion("/apps/collection");
            System.out.println("Colección actual: " + col.getName());

            int numHijas = col.getChildCollectionCount();
            System.out.println(numHijas + " colecciones hijas.");
            if (numHijas > 0) {
                String nomHijas[] = col.listChildCollections();
                for (int i = 0; i < numHijas; i++) {
                    System.out.println("\t" + nomHijas[i]);
                }
            }
            int numDocs = col.getResourceCount();
            System.out.println(numDocs + " doocumentos.");
            if (numDocs > 0) {
                String nomDocs[] = col.listResources();
                for (int i = 0; i < numDocs; i++) {
                    System.out.println("\t" + nomDocs[i]);
                }
            }

            Service servicios[] = col.getServices();
            System.out.println("Servicios proporcionados por colección " + col.getName() + ":");
            for (int i = 0; i < servicios.length; i++) {
                System.out.println("\t" + servicios[i].getName() + " - Versión: " + servicios[i].getVersion());
            }
            
            
            XPathQueryService service = (XPathQueryService) col.getService("XPathQueryService", "1.0");
            
            String strAction = "for $lib in /bib/libro return $lib";
            ResourceSet result = service.query(strAction);
            ResourceIterator i = result.getIterator(); 
            while(i.hasMoreResources()){
            Resource r = (Resource) i.nextResource();
            System.out.println("LIBRO: "+(String) r.getContent());
            }
            
            String strAction2 = "for $lib in count(/bib/libro) return $lib";
            ResourceSet result2 = service.query(strAction2);
            ResourceIterator i2 = result2.getIterator(); 
            while(i2.hasMoreResources()){
            Resource r = (Resource) i2.nextResource();
            System.out.println("TOTAL LIBROS: "+(String) r.getContent());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (col != null) {
                    col.close();
                }
            } catch (XMLDBException e) {
                e.printStackTrace();
            }
        }
    }
    
}
