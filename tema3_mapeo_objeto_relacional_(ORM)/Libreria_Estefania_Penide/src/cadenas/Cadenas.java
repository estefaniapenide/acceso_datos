/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadenas;

/**
 *
 * @author Estefania
 */
public class Cadenas {

    public static void menuPrincipal() {
        System.out.println("----------------------------------------------\n"
                + "\t\t\tLIBRERÍA\n\n"
                + "1.-Inserción de nuevas filas\n"
                + "2.-Borrado de filas\n"
                + "3.-Consultas\n\n"
                + "0.-SALIR");
    }

    public static void menuInsercion() {
        System.out.println("------------------------------------------------------------------------\n"
                + "\t\t\tINSERCIÓN DE NUEVAS FILAS\n\n"
                + "1.-Inserción AUTOR\n"
                + "2.-Inserción LIBRO\n\n"
                + "0.-VOLVER AL MENÚ PRINCIPAL");
    }

    public static void menuBorrado() {
        System.out.println("-----------------------------------------------------\n"
                + "\t\t\tBORRADO DE FILAS\n\n"
                + "1.-Borrado AUTOR\n"
                + "2.-Borrado LIBRO\n\n"
                + "0.-VOLVER AL MENÚ PRINCIPAL");
    }

    public static void menuConsultas() {
        System.out.println("--------------------------------------------------------------------------\n"
                + "\t\t\tCONSULTAS\n\n"
                + "1.-Introduciendo el título de un LIBRO visualice sus datos\n"
                + "2.-Introduciendo el nombre de un AUTOR visualice sus LIBROS\n"
                + "3.- Visualización de TODOS los LIBROS\n"
                + "4.- Visualización  de TODOS los AUTORES con sus LIBROS\n\n"
                + "0.-VOLVER AL MENÚ PRINCIPAL");
    }

    public static void defaultMensajeMenu() {
        System.out.println("No ha introducido ninguna de las opciones.\n");
    }

    public static void fin() {
        System.out.println("PROGRAMA FINALIZADO");
    }

    public static void vueltaMenu() {
        System.out.println("Volviendo al menú anterior...\n");
    }

    public static void addAdelB(String A, String B) {
        System.out.println("AÑADIR " + A + " DEL " + B + "\n"
                + "1.-SI\n"
                + "2.-NO\n");
    }

    public static void confirmarBorrado() {
        System.out.println("CONFIRMAR BORRADO:\n"
                + "1.-SI\n"
                + "2.-NO");
    }

}
