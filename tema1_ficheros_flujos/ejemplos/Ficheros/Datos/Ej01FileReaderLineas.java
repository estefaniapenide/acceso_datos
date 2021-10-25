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


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//ejemplo que lee el fichero nombres linea a linea

//Hay una excepción EOFException cuando intentamos leer de un fichero que ya no tiene información.
public class Ej01FileReaderLineas {

    public static void main(String[] args) {
File f;
FileReader fr;
BufferedReader br = null;
try{
f = new File("Nombres.txt");
if(f.exists()){
fr = new FileReader(f);
br = new BufferedReader(fr);
String nombre; // variable donde se recupera la informacion
while((nombre = br.readLine())!= null){
System.out.println(nombre);
}
}else
System.out.println(("El fichero no existe"));
}catch(FileNotFoundException fn){
System.out.println("No se encuentra el fichero");
}catch(IOException ioe){
System.out.println("Error de L/E");
}finally{
try{
br.close();
}catch(IOException ioe){
System.out.println("Error al cerrar el fichero");
}
}
}
}