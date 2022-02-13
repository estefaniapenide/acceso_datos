/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progrmacionsa_estefania_penide;

import Cadenas.Cadenas;
import controldata.ControlData;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Bajas {

    public static void baja(Scanner input) {
        byte op = 0;
        do {
            System.out.println("---------------------------------------------\n"
                    + "\t\tBAJAS\n\n");
            Cadenas.menuEmpleados();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    fijo(input);
                    break;
                case 2:
                    temporal(input);
                    break;
                case 0:
                    Cadenas.vueltaAnteriorMenu();
                    break;
                default:
                    Cadenas.mesajeDefaultMenu();
                    break;
            }
        } while (op != 0);

    }

    private static void fijo(Scanner input) {
    }

    private static void temporal(Scanner input) {
    }

}
