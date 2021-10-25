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
/*La clase BufferedWriter añade un buffer para realizar una escritura eficiente de caracteres.
Para construir un BufferedWriter necesitamos la clase FileWriter.
BufferedWriter fichero = new BufferedWriter(new FileWriter
(NombreFichero));
El siguiente ejemplo escribe 10 filas de caracteres en un fichero de texto y después de
escribir cada fila salta una línea con el método newLine().*/

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/*
* El siguiente ejemplo escribe 10 filas de caracteres en un fichero
de texto y después de escribir
* cada fila salta una línea con el método newLine().
*/
public class Ej05FileWriter {

public static void main(final String[] args) {
try{
FileWriter fw = new FileWriter("E:\\CSDAMultiplataforma\\FicherosTexto\\Filas.txt");
BufferedWriter bw = new BufferedWriter(fw);
// BufferedWriter bw = new BufferedWriter(new
//FileWriter("E:\\CSDAMultiplataforma\\FicherosTexto\\Filas.txt");
for(int i=0; i<11; i++){
bw.write("Fila número: " +i);
bw.newLine();
}
bw.close();
}catch(FileNotFoundException fne){
System.out.println("No se encuentra el fichero");
}catch(IOException ioe){
System.out.println("Error de L/E");
}
}
}
