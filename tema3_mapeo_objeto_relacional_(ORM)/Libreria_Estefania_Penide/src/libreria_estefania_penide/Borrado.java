/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria_estefania_penide;

import POO.Autor;
import POO.Libro;
import cadenas.Cadenas;
import controldata.ControlData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Estefania
 */
public class Borrado {

    public static void borrados(Scanner input, SessionFactory sessionFactory) {

        byte op = 0;
        do {
            Cadenas.menuBorrado();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    borrarAutor(input, sessionFactory);
                    break;
                case 2:
                    borrarLibro(input, sessionFactory);
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

    private static void borrarAutor(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nBORRAR AUTOR");
        System.out.println("DNI:");
        String dni = ControlData.leerDni(input);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        try {
            Autor autor = (Autor) session.get(Autor.class, dni);
            session.close();

            System.out.println("\n" + autor);
            System.out.println("\nEL AUTOR, SUS DATOS Y SUS LIBROS SERÁN BORRADOS (SI ESTOS LIBROS TAMBIÉN TIENEN OTROS AUTORES ESTOS SERÁN BORRADOS CON TODOS SUS LIBROS)\n");//MIRAR ESTO

            byte opci = 0;
            do {
                Cadenas.confirmarBorrado();
                opci = ControlData.leerByte(input);
                switch (opci) {
                    case 1:
                        Session sessionB = sessionFactory.openSession();
                        sessionB.beginTransaction();
                        sessionB.delete(autor);
                        sessionB.getTransaction().commit();
                        sessionB.close();
                        System.out.println("\nEL AUTOR HA SIDO BORRADO");
                        break;
                    case 2:
                        System.out.println("\nAUTOR NO BORRADO");
                        break;
                    default:
                        Cadenas.defaultMensajeMenu();
                        break;
                }
            } while (opci != 2 && opci != 1);

        } catch (IllegalArgumentException e) {
            System.out.println("\nEL AUTOR " + dni + " NO EXISTE Y POR LO TANTO NO PUEDE SER BORRADO");
        }

    }

    private static void borrarLibro(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nBORRAR LIBRO");
        System.out.println("TÍTULO:");
        String titulo = ControlData.leerString(input);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String c = "FROM Libro WHERE TITULO='" + titulo + "'";//Mirar bien si "TITULO" hay que coger el de la tabla o el de java. Así me funciona, pero no probé el otro.
        List<Libro> lista = session.createQuery(c).list();
        session.close();
        if (lista.size() < 1) {
            System.out.println("\nEL LIBRO '" + titulo + "' NO EXISTE Y POR LO TANTO NO PUEDE SER BORRADO");
        } else {
            for (Libro libro : lista) {
                System.out.println("\nLIBRO");
                System.out.println(libro);//Añadir que salga con el nombre del autor para ver qué libro se está borrando
                for (Autor autor : libro.getAutores()) {
                    System.out.println("AUTOR: " + autor.getNombre());
                }
                System.out.println("\nEL LIBRO, SUS DATOS Y SUS AUTORES Y EL RESTO DE LIBROS DE ESOS AUTORES SERÁN BORRADOS\n");

                byte opci = 0;
                do {
                    Cadenas.confirmarBorrado();
                    opci = ControlData.leerByte(input);
                    switch (opci) {
                        case 1:
                            Session sessionB = sessionFactory.openSession();
                            sessionB.beginTransaction();
                            sessionB.delete(libro);
                            sessionB.getTransaction().commit();
                            sessionB.close();
                            System.out.println("\nEL LIBRO HA SIDO BORRADO");
                            break;
                        case 2:
                            System.out.println("\nLIBRO NO BORRADO");
                            break;
                        default:
                            Cadenas.defaultMensajeMenu();
                            break;
                    }
                } while (opci != 2 && opci != 1);
            }

        }

    }

}
