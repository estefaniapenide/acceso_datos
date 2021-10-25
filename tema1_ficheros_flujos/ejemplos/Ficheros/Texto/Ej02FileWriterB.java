/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD1Ficheros.Secuenciales.Texto;

/**
 *
 * @author mrnov
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Ej02FileWriterB {
/*
* escribe caracteres en un fichero de nombre FichTexto01.txt
(si no existe lo crea).
* se escribe el array completo en una operación de escritura
*/
public static void main(final String[] args) throws IOException
{
File f= new File("D:\\Ciclos Formativos\\ProyectosAccesoDatos1718"
+ "\\FicherosTexto\\FichTexto02.txt");
FileWriter fw = new FileWriter(f); // crea el fichero de salida
String cadena = "Esto es una prueba de FileWriter método write escribiendo todo"
+ "el array en una unica operacion";
char[] cad = cadena.toCharArray(); // convierte un String en un array de caracteres
fw.write(cad); // se escribe el array
fw.append('*'); // añade un * al final
fw.close(); // cierra el fichero

System.out.println("Programa Finalizado");
}
}