/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria_estefania_penide;

import POO.Autor;
import POO.Libro;
import POO.Telefono;
import cadenas.Cadenas;
import controldata.ControlData;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Estefania
 */
public class Insercion {

    public static void inserciones(Scanner input, SessionFactory sessionFactory) {

        byte op = 0;
        do {
            Cadenas.menuInsercion();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    insertarAutor(input, sessionFactory);
                    break;
                case 2:
                    insertarLibro(input, sessionFactory);
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

    private static void insertarAutor(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nNUEVO AUTOR");
        System.out.println("DNI:");
        String dni = ControlData.leerDni(input);
        System.out.println("NOMBRE:");
        String nombre = ControlData.leerString(input);
        System.out.println("NACIONALIDAD:");
        String nacionalidad = ControlData.leerString(input);

        Autor autor = new Autor(dni, nombre, nacionalidad);

        System.out.println("NÚMERO DE TELÉFONO:");
        String telefono = ControlData.leerString(input);

        Telefono tel = new Telefono(autor.getDni(), telefono);
        autor.setTelefono(tel);

        System.out.println("\nLIBROS");
        int cont = 1;
        byte opc = 0;
        do {
            Cadenas.addAdelB("LIBRO", "AUTOR");
            opc = ControlData.leerByte(input);
            switch (opc) {
                case 1:
                    System.out.println("LIBRO " + cont + ":");
                    System.out.println("TÍTULO:");
                    String titulo = ControlData.leerString(input);
                    System.out.println("PRECIO(€):");
                    float precio = ControlData.leerFloat(input);

                    Libro libro = new Libro(titulo, precio);
                    autor.getLibros().add(libro);
                    System.out.println("LIBRO ANOTADO\n");
                    cont++;
                    break;
                case 2:
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;
            }

        } while (opc != 2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(autor);

        session.getTransaction().commit();
        session.close();

        System.out.println("EL AUTOR Y LOS LIBROS INDICADOS HAN SIDO AÑADIDOS\n");

    }

    private static void insertarLibro(Scanner input, SessionFactory sessionFactory) {

        System.out.println("\nNUEVO LIBRO");
        System.out.println("TÍTULO:");
        String titulo = ControlData.leerString(input);
        System.out.println("PRECIO(€)):");
        float precio = ControlData.leerFloat(input);

        Libro libro = new Libro(titulo, precio);

        Autor autor = new Autor();

        System.out.println("\nAUTORES");
        int cont = 1;
        byte opc = 0;
        do {
            Cadenas.addAdelB("AUTOR", "LIBRO");
            opc = ControlData.leerByte(input);
            switch (opc) {
                case 1:
                    System.out.println("AUTOR " + cont + ":");
                    System.out.println("DNI:");
                    String dni = ControlData.leerDni(input);
                    
                    Session sessionA = sessionFactory.openSession();
                    sessionA.beginTransaction();

                    try {
                        autor = (Autor) sessionA.get(Autor.class, dni);//VER SI ESTO LO IMPRIME Y QUÉ PASA CON EL NULLPOINTEREXCEPTION
                        sessionA.close();
                             
                        autor.getLibros().add(libro);

                        Session session = sessionFactory.openSession();
                        session.beginTransaction();

                        session.update(autor);

                        session.getTransaction().commit();
                        session.close();

                        System.out.println("\nAUTOR ANOTADO");
                        cont++;

                    } catch (NullPointerException e) {
                        
                        sessionA.close();//Para que se cierre en caso de haber saltado la excepción
                        
                        System.out.println("NOMBRE:");
                        String nombre = ControlData.leerString(input);
                        System.out.println("NACIONALIDAD:");
                        String nacionalidad = ControlData.leerString(input);

                        autor = new Autor(dni, nombre, nacionalidad);

                        System.out.println("NÚMERO DE TELÉFONO:");
                        String telefono = ControlData.leerString(input);

                        Telefono tel = new Telefono(autor.getDni(), telefono);
                        autor.setTelefono(tel);

                        autor.getLibros().add(libro);

                        Session session = sessionFactory.openSession();
                        session.beginTransaction();

                        session.save(autor);

                        session.getTransaction().commit();
                        session.close();

                        System.out.println("\nAUTOR ANOTADO");
                        cont++;
                    }
                    break;
                case 2:
                    break;
                default:
                    Cadenas.defaultMensajeMenu();
                    break;
            }

        } while (opc != 2);

        if (autor.getDni() == null) {

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(libro);

            session.getTransaction().commit();
            session.close();

        } 

        System.out.println("\nEL LIBRO Y LOS AUTORES INDICADOS HAN SIDO AÑADIDOS");

    }

}
