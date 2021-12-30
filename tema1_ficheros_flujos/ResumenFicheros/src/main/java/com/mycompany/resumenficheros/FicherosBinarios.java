/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resumenficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Estefania
 */
public class FicherosBinarios {

//    File fichero = new File("aaa.dat");
//    
//  
//    DataOutputStream flujoescritura = new DataOutputStream(new FileOutputStream(fichero, true));
//    
//    FileInputStream fis = new FileInputStream(fichero);
//    DataInputStream flujolectura = new DataInputStream(fis);
    
    public static void escribirFichero(File fichero, String matricula, String marca, double deposito, String modelo) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero, true));

        dos.writeUTF(matricula);
        dos.writeUTF(marca);
        dos.writeDouble(deposito);
        dos.writeUTF(modelo);
        dos.flush();

        dos.close();
    }

    public static void leerFichero(File fichero) throws IOException {

        FileInputStream fis = new FileInputStream(fichero);
        DataInputStream dis = new DataInputStream(fis);

        while (fis.available() > 0) {
//            JOptionPane.showMessageDialog(null, "El vehiculo tiene una matrícula " + dis.readUTF()
//                    + ", su marca es " + dis.readUTF() + ", el tamaño depósito es de "
//                    + dis.readDouble() + " litros y su modelo es " + dis.readUTF(), "DATOS", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("El vehiculo tiene una matrícula " + dis.readUTF()
                    + ", su marca es " + dis.readUTF() + ", el tamaño depósito es de "
                    + dis.readDouble() + " litros y su modelo es " + dis.readUTF());
        }

        dis.close();
        fis.close();

    }

    public static File copiarFichero(File fichero, File localizacionDestino) {

//        String nombreFichero = quitarExtension(fichero.getName());
//        nombreFichero = nombreFichero + "copia";
        String nombreFichero = "copia_" + fichero.getName();

        File ficheroCopiado = new File(localizacionDestino, nombreFichero);
        try {
            DataInputStream lector = new DataInputStream(new FileInputStream(fichero));
            DataOutputStream escritor = new DataOutputStream(new FileOutputStream(ficheroCopiado));

            int tamano = 0;
            try {
                tamano = lector.available();

                byte[] buffer = new byte[tamano];
                while (lector.read(buffer) != -1) {
                    escritor.write(buffer);
                    escritor.flush();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return ficheroCopiado;
    }

    public static boolean ficheroVacio(String fichero) throws FileNotFoundException, IOException {

        boolean ficheroVacio = false;
        FileInputStream fis = new FileInputStream(fichero);
        if (fis.available() == 0) {
            ficheroVacio = true;
        }
        return ficheroVacio;
    }

}
