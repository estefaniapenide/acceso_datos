/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD1Ficheros.Secuenciales.Datos.TiposPrimitivos;

/**
 *
 * @author mrnov
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//El siguiente ejemplo lee un fichero utilizando la clase Scanner.
public class Ej03FileReaderArrayPalabras {
    
public static void main(String[] args) {
File f = new File("Nombres.txt");
FileReader fr = null;
Scanner sc = null;
try{
if(f.exists()){
fr = new FileReader(f);
sc = new Scanner(fr);
//mientras no encuentre el final sigue leyendo
while(sc.hasNext()){
System.out.println(sc.next());
}
}
else

System.out.println("El fichero no existe");
}catch(FileNotFoundException fn){
System.out.println("No se encuentra el fichero");
}catch(IOException ioe){
System.out.println("Error de L/E");
}finally{
try{
sc.close();
fr.close();
}catch(IOException ioe){
System.out.println("Error al cerrar el fichero");
}
}
}
}