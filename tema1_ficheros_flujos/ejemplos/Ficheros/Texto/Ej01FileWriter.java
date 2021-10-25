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

// Ejemplo: El programa almacenará unos nombres de un en un fichero en disco utilizando PrintWriter.
import java.io.File;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
// Ejemplo de utilización de las clase FileWriter y PrintWriter
public class Ej01FileWriter {
public static void main(String[] args) throws IOException {
//array de nombres

String [] nombres = {"Maria", "Ana", "Santiago", "Jorge",
"Iciar", "Isabel", "Pedro", "Manuel"};
// File f = new File("Nombres.txt");
// FileWriter fw = new FileWriter(f);
FileWriter fw = new FileWriter("Nombres.txt");
// la siguiente sentencia añade los nombres a los ficheros
// FileWriter fw = new FileWriter("Nombres.txt", true);
// PrintWriter salida = new PrintWriter(fw);
// las dos sentencias anteriores son equivalentes a la siguiente
PrintWriter salida = new PrintWriter("Nombres.txt");
for (int i = 0; i < nombres.length; i++) {
salida.println(nombres[i]);
}
salida.flush();
salida.close();
}
}

/*La llamada al método flush() garantiza que todos los datos enviados a través del buffer
de salida han sido escritos en el fichero y el método close() cierra la conexión con el
fichero y libera los recursos utilizados por ésta.
*/
