/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD1Ficheros.Secuenciales.Datos;

/**
 *
 * @author mrnov
 */
//En el siguiente ejemplo se escriben números enteros.

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej03FileOutputStreamWrite {
    
public static void main(final String[] args) {
    FileOutputStream fEscritura = null;
    try{
        // array de enteros
        int [] array = {55, 185, 237, 142, 150, 21, 487};
        fEscritura = new FileOutputStream("Enteros01.txt",false);
        // mientras el array tenga elementos los escribimos en el fichero
        for (int i : array) {
        fEscritura.write(i);
        }
    }catch(FileNotFoundException e){
        System.out.println("No se pudo abrir el fichero Enteros.txt");
    }
    catch(IOException e){
        System.out.println("No se pudo escribir en el fichero Enteros.txt");
    }
    finally{
        try{
            fEscritura.close();
        }
        catch(IOException e){
            System.out.println("No se pudo cerrar el fichero Enteros.txt");
        }
    }
    }
}
