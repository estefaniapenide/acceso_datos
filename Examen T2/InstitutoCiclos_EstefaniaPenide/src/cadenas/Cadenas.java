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
                + "\t\t\tINSTITUTO\n\n"
                + "1.-Altas\n"
                + "2.-Bajas\n"
                + "3.-Modificaciones\n"
                + "4.-Listados\n\n"
                + "5.-Fin");
    }

    public static void menuAltas() {
        System.out.println("------------------------------------------------------------------------\n"
                + "\t\t\tALTAS\n\n"
                + "1.-Instituto\n"
                + "2.-Ciclo\n"
                + "3.-Taller\n"
                + "4.-Relacionar Objetos\n"
                + "5.-Usos para un determinado ciclo\n\n"
                + "0.-VOLVER AL MENÚ PRINCIPAL");
    }

    public static void menuListados() {
        System.out.println("-----------------------------------------------------\n"
                + "\t\t\tLISTADOS\n\n"
                + "1.-Introduciendo por teclado dos fechas y un taller determinado, visualizar los ciclos que realizaron las prácticas en ese periodo.\n"
                + "2.-Dado un instituto, listar los ciclos que imparte.\n"
                + "3.-Dado un ciclo, listar los institutos en los que se imparte\n\n"
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
