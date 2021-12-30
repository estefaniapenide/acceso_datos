/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAX;

/**
 *
 * @author mrnov
 */

import java.io.IOException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.*;
import static org.xml.sax.helpers.XMLReaderFactory.createXMLReader;

/*
* Ejemplo que crea un fichero XML con SAX a partir del fichero aleatorio
Personas.txt
*/

public class LeerFicheroXMLconSAX {
    public static void main(final String[] args) {
        try{/*
        * La extensión XMLReader es un analizador de XML.
        * El lector actúa como un cursor yendo hacia delante en el
        flujo del documento y
        * deteniéndose en cada nodo del camino.
        */
        XMLReader procesadorXML = createXMLReader();
        // esta clase es la que extiende a DefaultHandler
        GestionContenido gestor = new GestionContenido();
        // le pasa al procesador XML los eventos que van pasando en el fichero XML
        procesadorXML.setContentHandler(gestor);
        /*
        * InputSource
        * Esta clase permite una aplicación SAX para encapsular
        información acerca de una fuente de entrada
        * en un solo objeto, que puede incluir un identificador
        público, un identificador de sistema,
        * un flujo de bytes (posiblemente con una codificación
        especificada), y / o un flujo de caracteres.
        * El analizador SAX utilizará el objeto InputSource para
        determinar cómo leer la entrada XML
        * según sean caracteres, bytes.
        */
        InputSource ficheroXML = new InputSource("Personas_new.xml");
        //le pasamos al procesador el fichero a leer
        procesadorXML.parse(ficheroXML);
        }catch(SAXException se){
            System.out.println("Error SAX");
        }catch(IOException io){
            System.out.println("Error de L/E");
        }
    }// fin main
    
    }// fin clase EjemploFicheroXMLSAX01
    class GestionContenido extends DefaultHandler{
        public GestionContenido(){
        super();
    }
        
    @Override
    public void startDocument(){
        System.out.println("Comienzo del documento XML");
    }
    @Override
    public void endDocument(){
        System.out.println("Final del documento XML");
    }
    public void startElement(final String uri, final String nombre, final
        String nombreC, final Attributes aatts){
        System.out.println("Principio Elemento: " +nombre);
    }
    @Override
    public void endElement(final String uri, final String nombre, final
        String nombreC){
        System.out.println("Fin Elemento: " +nombre);
    }
    @Override
    public void characters(final char[] ch, final int inicio, final int
    longitud){
        String car = new String(ch, inicio, longitud);
        car = car.replaceAll("[\t\n]", ""); //quitar saltos de linea
        System.out.println("\tTexto: " +car);
    }
}