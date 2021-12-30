/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.resumenficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 *
 * @author Estefania
 */
public class GeneralFicheros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        File directorio = new File("directorio");

        File fichero1 = new File(directorio, "fichero1.txt");
        File fichero2 = new File(directorio, "fichero2.txt");
        File fichero3 = new File(directorio, "fichero3.txt");

        directorio.mkdir();
        

        try {
            fichero1.createNewFile();
            fichero2.createNewFile();
            fichero3.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        verInfoFichero(fichero1);

    }

    public static void verInfoFichero(File fichero) {
        System.out.println("INFORMACIÓN DEL FICHERO");

        if (fichero.exists()) {
            System.out.println("Nombre fichero: " + fichero.getName() + "\n"
                    + "Ruta: " + fichero.getPath() + "\n"
                    + "Ruta absoluta: " + fichero.getAbsolutePath() + "\n"
                    + "Se puede leer: " + fichero.canRead() + "\n"
                    + "Se puede escrbir: " + fichero.canWrite() + "\n"
                    + "Tamaño: " + fichero.length() + "\n"
                    + "Última modificación: " + fichero.lastModified() + "\n"
                    + "\nEs un directorio: " + fichero.isDirectory() + "\n"
                    + "Es un fichero: " + fichero.isFile() + "\n"
                    + "Nombre del directorio padre: " + fichero.getParent());
            if (fichero.isDirectory()) {
                System.out.println("Ficheros dentro del fichero: ");
                verDirectorio(fichero);
            } else {
                System.out.println("No es un directorio para listar.");
            }
        }

    }

    public static void verDirectorio(File fichero) {

        File[] listaFicheros = fichero.listFiles();
        System.out.println("Ficheros en el directorio actual: " + listaFicheros.length);
        for (int i = 0; i < listaFicheros.length; i++) {
            File f = listaFicheros[i];
            System.out.println(f.getName());
        }
    }

    public static String quitarExtension(String nombreFichero) {

        int punto = nombreFichero.lastIndexOf(".");
        nombreFichero = nombreFichero.substring(0, punto);

        return nombreFichero;

    }
}
