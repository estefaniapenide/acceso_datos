/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bibliosunidassa;

import POO.Bibliotecas;
import POO.Libros;
import POO.LibrosOcio;
import POO.MiObjectOutputStream;
import POO.Prestamos;
import controldata.ControlData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class GestionesBiblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Bibliotecas biblioteca = new Bibliotecas();

        Scanner input = new Scanner(System.in);

        File Fbibliotecas = new File("Fbibliotecas.dat");
        File Flog = new File("Flog.txt");
        File Flibros = new File("Flibros.dat");

        try {
            Fbibliotecas.createNewFile();
            Flog.createNewFile();
            Flibros.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte op = 0;
        do {
            System.out.println(menuPrincipal());
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    altaPrestamo(input, Fbibliotecas, biblioteca, Flog);
                    break;
                case 2:
                    int numRegs = 0;
                    try {
                        numRegs = contarNumRegistrosFichero(Flibros);
                        modificarPrecioLibro(Flibros, numRegs, input,Flog,biblioteca);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.println(leerLog(Flog));
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("No ha introducido ninguna de las opciones...\n");
                    break;
            }
        } while (op != 0);

    }

    public static String menuPrincipal() {
        String menu = "GESTIONES BIBLIOTECA\n"
                + "1.-Alta préstamo libro ocio.\n"
                + "2.-Modificación precio libro\n"
                + "3.-Leer Flog\n\n"
                + "0.-Salir\n";
        return menu;
    }

    public static void altaPrestamo(Scanner input, File Fbibliotecas, Bibliotecas biblioteca, File Flog) {

        Date fechaPrestamo = null;
        Date fechaDevolucion = null;
        System.out.println("Introduzca la fecha del préstamo (dd/mm/aaaa): ");
        String fechaI = ControlData.leerFecha(input);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            fechaPrestamo = formato.parse(fechaI);       

//            StringBuilder fechaF = new StringBuilder();
//            fechaF.append(fechaI.charAt(0));
//            fechaF.append(fechaI.charAt(1));
//            
//            int fechaFin = Integer.parseInt(fechaF.toString())+15;
//            if(fechaFin>30){
//            
//            }

            //No me dió tiempo a hacer lo de fecha asi que para seguir dejando el programa funcional dejo la misma.
            fechaDevolucion = formato.parse(fechaI);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Introduzca el DNI del lector:");
        String dni = ControlData.leerDni(input);

        System.out.println("Introduzca el título del libro:");
        String titulo = ControlData.leerString(input);

        LibrosOcio libroAPrestar = null;

        if (encontrarLibroPrestamoEnBiblioteca(biblioteca, titulo)) {
            libroAPrestar = libroAPrestar(biblioteca, titulo);
            if (libroAPrestar.isEstado()) {
                Prestamos prestamo = new Prestamos(fechaPrestamo, fechaDevolucion, dni);
                libroAPrestar.getP().add(prestamo);
                try {
                    altaFbibliotecas(Fbibliotecas, prestamo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String nuevoPrestamo = "Biblioteca " + biblioteca.getCif() + " Nuevo préstamo: " + titulo + ", FP: " + fechaI + ", Lector: " + dni;
                addToLog(biblioteca, Flog, nuevoPrestamo);
                System.out.println("Libro prestado.");
                libroAPrestar.setEstado(false);
            } else {
                System.out.println("El libro " + titulo + " ya está prestado.\nNo esposible dar de alta el préstamo.\n");
            }
        }
        System.out.println("El libro NO existe en la biblioteca.\n");

    }

    public static boolean encontrarLibroPrestamoEnBiblioteca(Bibliotecas biblioteca, String titulo) {

        boolean libroOcioEncontrado = false;

        for (Libros libro : biblioteca.getL()) {
            if (libro.getTitulo().equals(titulo)) {
                if (libro instanceof LibrosOcio) {
                    libroOcioEncontrado = true;
                }
            }
        }
        return libroOcioEncontrado;
    }

    public static LibrosOcio libroAPrestar(Bibliotecas biblioteca, String titulo) {

        LibrosOcio libroOcio = null;

        for (Libros libro : biblioteca.getL()) {
            if (libro.getTitulo().equals(titulo)) {
                if (libro instanceof LibrosOcio) {
                    libroOcio = (LibrosOcio) libro;
                }
            }
        }
        return libroOcio;
    }

    public static void altaFbibliotecas(File Fbibliotecas, Prestamos prestamo) throws FileNotFoundException, IOException {

        if (Fbibliotecas.length() == 0) {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Fbibliotecas));
            oos.writeObject(prestamo);
            oos.close();

        } else {

            MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream(Fbibliotecas, true));
            moos.writeObject(prestamo);
            moos.close();

        }
    }

    public static void addToLog(Bibliotecas biblioteca, File Flog, String linea) {
        try {
            Writer escritor = new FileWriter(Flog, true);
            escritor.write(linea);
            escritor.write("\n");
            escritor.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static StringBuilder leerLog(File Flog) {

        StringBuilder textoFichero = new StringBuilder();

        try {
            Reader lector = new FileReader(Flog, Charset.forName("UTF-8"));
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

    public static int contarNumRegistrosFichero(File Flibros) throws FileNotFoundException, IOException {

        int numRegs = 0;

        RandomAccessFile raf = new RandomAccessFile(Flibros, "rw");

        numRegs = (int) Math.ceil((float) raf.length() / 140);
        raf.close();

        return numRegs;

    }

    public static void modificarPrecioLibro(File Flibros, int numRegs, Scanner input,File Flog,Bibliotecas biblioteca) throws FileNotFoundException, IOException {

        RandomAccessFile raf = new RandomAccessFile(Flibros, "rw");
        Libros libro = new Libros();
        String referencia;
        byte b = 0;

        System.out.println("Introduzc la referencia del libro a modificar :");
        referencia = ControlData.leerString(input);

        for (int i = 0; i < numRegs; i++) {
            raf.seek(i * 140);
            String ref=raf.readUTF();
            String titulo=raf.readUTF();
            float precioViejo=raf.readFloat();
            boolean estado=raf.readBoolean();

            libro = new Libros(ref, titulo, precioViejo, estado);

            if (libro.getRef().compareToIgnoreCase(referencia) == 0) {

                b = 1;

                System.out.println("Introduzca el nuevo precio(€):");
                float precio = ControlData.leerFloat(input);
                libro.setPrecio(precio);

                if (libro.getTamReal() <= libro.getTamMax()) {

                    raf.seek(i * 140);
                    raf.writeUTF(libro.getRef());
                    raf.writeUTF(libro.getTitulo());
                    raf.writeFloat(libro.getPrecio());
                    raf.writeBoolean(libro.isEstado());
                    
                    
                    String log="Cambio de precio de libro "+referencia+": Precio antiguo(€)->"+precioViejo+", Precio nuevo(€)->"+precio;
                    addToLog(biblioteca,Flog,log);

                } else {
                    System.out.println("Tamaño Excedido. Libro No modificado.\n");
                }
            }
        }
        if (b != 1) {
            System.out.println("El libro con referencia " + referencia + " NO existe.\n");
        }

    }

}
