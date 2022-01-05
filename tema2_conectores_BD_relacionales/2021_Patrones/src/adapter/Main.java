package adapter;
/*
Adapter es un patrón de diseño estructural que permite la colaboración entre objetos con interfaces incompatibles.

Ejemplos de uso: El patrón Adapter es muy común en el código Java. 
Se utiliza muy a menudo en sistemas basados en algún código heredado (legacy). 
En estos casos, los adaptadores crean código heredado con clases modernas.

Hay algunos adaptadores estándar en las principales bibliotecas de Java:

    java.util.Arrays#asList()
    java.util.Collections#list()
    java.util.Collections#enumeration()
    java.io.InputStreamReader(InputStream) (devuelve un objeto Reader)
    java.io.OutputStreamWriter(OutputStream) (devuelve un objeto Writer)
    javax.xml.bind.annotation.adapters.XmlAdapter#marshal() y #unmarshal()

Identificación: Adapter es reconocible por un constructor que toma una instancia 
de distinto tipo de clase abstracta/interfaz. Cuando el adaptador recibe una 
llamada a uno de sus métodos, convierte los parámetros al formato adecuado y 
después dirige la llamada a uno o varios métodos del objeto envuelto.
*/

public class Main {
    
    public static void main(String[] args) {
        PaypalAdapter p = new PaypalAdapter(new Paypal());
        p.pay(20);
    }

}
