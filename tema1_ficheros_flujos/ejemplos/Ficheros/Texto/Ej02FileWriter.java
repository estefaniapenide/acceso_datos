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
/*
* escribe caracteres en un fichero de nombre FichTexto01.txt (si no
existe lo crea).
* se escribe el array completo en una operación de escritura
*/
public class Ej02FileWriter {
public static void main(final String[] args) throws IOException
{
File f= new File("D:\\Ciclos Formativos\\ProyectosAccesoDatos1718"
+ "\\FicherosTexto\\FichTexto01.txt");

FileWriter fw = new FileWriter(f); // crea el fichero de salida
String cadena = "Esto es una prueba de FileWriter método write escribiendo caracter a caracter";
char[] cad = cadena.toCharArray(); // convierte un String en un array de caracteres
for(int i=0; i< cad.length; i++)
fw.write(cad[i]); // se escribe un caracter
fw.append('*'); // añade un * al final
fw.close(); // cierra el fichero
System.out.println("Programa Finalizado");
}
}
