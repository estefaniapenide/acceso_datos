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

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ej01FileOutputStreamEnteros {
//ejemplo que escribe numeros enteros en un fichero
// escribe siempre datos del mismo tipo
    public static void main(String[] args) {
        // declaramos los objetos FileOutputStream y DataOutputStream
        FileOutputStream fEscritura = null;
        DataOutputStream ds = null;
        try{
            // array de enteros
            int [] array = {5, 18, 23, 12, 10, 1, 47};
            String [] nombres = {"Bea", "Ana", "Maria", "Juan",
            "Pedro","Teresa","Marta"};
            fEscritura = new
            FileOutputStream("EnterosNombres.txt", true);
            ds = new DataOutputStream(fEscritura);
            // mientras el array tenga elementos los escribimos en el fichero
            for (int i=0 ;i<array.length; i++) {
                ds.writeInt(array[i]);
                ds.writeUTF(nombres[i]);
            }
        }catch(FileNotFoundException e){
            System.out.println("No se pudo abrir el fichero Enteros.txt");
        }catch(IOException e){
            System.out.println("No se pudo escribir en el fichero Enteros.txt");
        }
        finally{
            try{
                ds.close();
                fEscritura.close();
            }
            catch(IOException e){
                System.out.println("No se pudo cerrar el fichero Enteros.txt");
            }
        }
    }
}
