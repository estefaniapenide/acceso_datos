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
public class Modificaciones {

    public static void modificacion(Scanner input) {
        byte op = 0;
        do {
            Cadenas.menuModificaciones();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    precioProducto(input);
                    break;
                case 2:
                    sueldoBaseEmpleado(input);
                    break;
                case 3:
                    porcentajeRetencion(input);
                    break;
                case 4:
                    importeDiaEmpleadoTemporal(input);
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

    private static void precioProducto(Scanner input){
    }

    private static void sueldoBaseEmpleado(Scanner input){
    }

    private static void porcentajeRetencion(Scanner input){
    }

    private static void importeDiaEmpleadoTemporal(Scanner input){
    }

}
