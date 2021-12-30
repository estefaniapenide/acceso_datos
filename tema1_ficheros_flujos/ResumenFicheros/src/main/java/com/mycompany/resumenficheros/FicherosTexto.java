/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resumenficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 *
 * @author Estefania
 */
public class FicherosTexto {

    public static StringBuilder leerFichero(File fichero) {

        StringBuilder textoFichero = new StringBuilder();

        try {
            Reader lector = new FileReader(fichero, Charset.forName("UTF-8"));
            char[] bufer = new char[1024];
            while (lector.read(bufer) != -1) {
                textoFichero.append(bufer);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return textoFichero;

    }

    public static void escribirEnFichero(File fichero, String texto) {

        try {
            Writer escritor = new FileWriter(fichero);
            escritor.write(texto);
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //Puebras con BuffredReader y BufferedWriter
    public static void leerFicheroConBufferedReaderEscribirloArchivoTemporalBufferedWriter(File fichero) {

        int texto;
        File ficheroTemporal = new File("ficheroTemporal.txt");
        try {

            BufferedReader lector = new BufferedReader(new FileReader(fichero, Charset.forName("UTF-8")));

            BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroTemporal, Charset.forName("UTF-8")));

            while ((texto = lector.read()) != -1) {
                escritor.write(texto);
                escritor.flush();
            }
            lector.close();
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ficheroTemporal.deleteOnExit();

    }
    
    public static File combinarDosFicheros(File fichero1, File fichero2, String nombreFicheroResultante, File directorioFinal) {

        File ficheroResultante = new File(directorioFinal, nombreFicheroResultante);

        try {

            BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroResultante, Charset.forName("UTF-8")));

            BufferedReader lector1 = new BufferedReader(new FileReader(fichero1, Charset.forName("UTF-8")));

            BufferedReader lector2 = new BufferedReader(new FileReader(fichero2, Charset.forName("UTF-8")));

//            copiar(lector1, escritor);
//            copiar(lector2, escritor);
            lector1.transferTo(escritor);
            escritor.write("\n");
            lector2.transferTo(escritor);

            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ficheroResultante;
    }

    public static void copiar(BufferedReader lector, BufferedWriter escritor) {

        String mensaje = "";
        try {
            int valor = lector.read();
            while (valor != -1) {
                mensaje += ((char) valor);
            }
            escritor.write(mensaje);
            escritor.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
