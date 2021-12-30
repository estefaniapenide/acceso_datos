/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DOM;

/**
 *
 * @author mrnov
 */


import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class LecturaFicheroDOM {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf =
        DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document documento = db.parse(new File("Personas_new.xml"));
            //el método parse devuelve el documento DOM que se va a crear para el fichero XML
            
            documento.getDocumentElement().normalize();
            /*
            * el método normalize transforma el texto Unicode que
            nosotros le enviemos en texto
            * normalizado o bien, texto bajo una misma norma
            estándar, basado en la estandarización
            * de normalización Unicode descrita en Unicode Standard
            Annex #15 — Unicode Normalization
            * Forms.
            */
            
            System.out.println("Elemento raiz: "
            +documento.getDocumentElement().getNodeName());
            // getNodeName() imprime el nombre de la raiz
            //crea una lista con todos los nodos de personas
            
            NodeList personas =
            documento.getElementsByTagName("persona");
            /*
            * Por medio de este método lo que se selecciona es una
            lista de nodos cuyo elemento es
            * el especificado como parámetro; a cada uno de los
            nodos se le asigna un índice,
            * de acuerdo al orden en el que aparecen en el marcado
            del documento.
            */
            
            // recorre la lista
            for(int i=0; i< personas.getLength(); i++){
                Node persona = personas.item(i); // obtener un nodo
                if(persona.getNodeType() == Node.ELEMENT_NODE){ // tipo de nodo
                    Element elemento = (Element) persona;
                    //obtener los elementos del nodo
                    System.out.println("Clave: "
                    +getNodo("clave", elemento));
                    System.out.println("Nombre: "
                    +getNodo("nombre", elemento));
                    System.out.println("Edad: " +getNodo("edad",
                    elemento));
                }// fin if
            }// fin for
        }catch(Exception e){
        e.printStackTrace();
        }
    }// fin main
    // obtener la información de un nodo
    private static String getNodo(final String etiqueta, final Element
        elemento){
        NodeList nodo =
        elemento.getElementsByTagName(etiqueta).item(0).getChildNodes();
        /*
        * getChildNodes() para obtener una lista de los nodos hijos de
        un elemento
        */
        Node valorNodo = nodo.item(0);
        //metodo item() devuelve el valor del nodo indicado como parametro
        return valorNodo.getNodeValue(); // devuelve el valor del nodo
    }
}// fin clase
