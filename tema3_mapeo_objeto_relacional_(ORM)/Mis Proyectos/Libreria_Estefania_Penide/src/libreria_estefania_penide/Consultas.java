/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria_estefania_penide;

import POO.Autor;
import POO.Libro;
import cadenas.Cadenas;
import controldata.ControlData;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Estefania
 */
public class Consultas {

    public static void datos(Scanner input, SessionFactory sessionFactory) {
        byte op = 0;
        do {
            Cadenas.menuConsultas();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    verLibro(input, sessionFactory);
                    break;
                case 2:
                    verLibrosAutor(input, sessionFactory);
                    break;
                case 3:
                    verLibros(input, sessionFactory);
                    break;
                case 4:
                    verAutoresLibros(input, sessionFactory);
                    break;
                case 0:
                    Cadenas.vueltaMenu();
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;
            }
        } while (op != 0);

    }

    private static void verLibro(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nINFO LIBRO");
        System.out.println("TÍTULO:");
        String titulo = ControlData.leerString(input);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String c = "FROM Libro WHERE TITULO='" + titulo + "'";
        List<Libro> lista = session.createQuery(c).list();
        session.close();
        if (lista.size() < 1) {
            System.out.println("\nEL LIBRO '" + titulo + "' NO EXISTE");
        } else {
            for (Libro libro : lista) {
                System.out.println("\nLIBRO");
                System.out.println(libro);
                for (Autor autor : libro.getAutores()) {
                    System.out.println("\nAUTOR:\n" + autor);
                }
            }
        }
    }

    private static void verLibrosAutor(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nLIBROS DE UN AUTOR");
        System.out.println("NOMBRE DEL AUTOR:");
        String nombre = ControlData.leerString(input);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String c = "FROM Autor WHERE NOMBRE='" + nombre + "'";
        List<Autor> lista = session.createQuery(c).list();
        session.close();

        if (lista.size() < 1) {
            System.out.println("\nEL AUTOR '" + nombre + "' NO EXISTE");
        } else {
            for (Autor autor : lista) {
                System.out.println("\nAUTOR: " + autor.getNombre());
                for (Libro libro : autor.getLibros()) {
                    System.out.println("\nLIBRO:\n" + libro);
                }
            }
        }

    }

    private static void verLibros(Scanner input, SessionFactory sessionFactory) {
        System.out.println("\nTODOS LOS LIBROS");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String c = "FROM Libro";
        List<Libro> lista = session.createQuery(c).list();
        session.close();

        if (lista.size() < 1) {
            System.out.println("\nNO HAY NINGÚN LIBRO REGISTRADO");
        } else {
            for (Libro libro : lista) {
                System.out.println("\n" + libro + "\n");
            }
        }
    }

    private static void verAutoresLibros(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nAUTORES Y LIBROS");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String c = "FROM Autor";
        List<Autor> lista = session.createQuery(c).list();
        session.close();

        if (lista.size() < 1) {
            System.out.println("\nNO HAY NINGÚN AUTOR REGISTRADO");
        } else {
            for (Autor autor : lista) {
                System.out.println("\nAUTOR " + autor.getNombre().toUpperCase());
                int cont = 1;
                for (Libro libro : autor.getLibros()) {
                    System.out.println("LIBRO " + cont + ":");
                    System.out.println(libro);
                    cont++;
                }
            }
        }

    }

}
