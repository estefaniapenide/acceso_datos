/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.resumenficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Estefania
 */
public class FicherosSerializacionObjetos {

//        File fichero = new File("bbb.dat");
//    
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
//
//
//        FileInputStream fis = new FileInputStream(fichero);
//        ObjectInputStream ois = new ObjectInputStream(fis);
    public static void escribirFicheroSinCabecera(File fichero, Object objeto) throws IOException {

        MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream(fichero));
        moos.writeObject(objeto);
        moos.close();
    }

    public static void escribirFichero(File fichero, Object objeto) throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
        oos.writeObject(objeto);
        oos.close();
    }

    public static void leerFichero(File fichero) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(fichero);
        ObjectInputStream ois = new ObjectInputStream(fis);

        while (fis.available() > 0) {
            Object objeto = (Object) ois.readObject();
            System.out.println(objeto);
        }

        fis.close();
        ois.close();

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
