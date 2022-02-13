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
public class Consultas {

    public static void consulta(Scanner input) {
        byte op = 0;
        do {
            Cadenas.menuConsultas();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    empresasEmpleados(input);
                    break;
                case 2:
                    productosEmpresa(input);
                    break;
                case 3:
                    empleadoTemporalNomina(input);
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
    
    public static void empresasEmpleados(Scanner input){}
    
    public static void productosEmpresa(Scanner input){}
    
    public static void empleadoTemporalNomina(Scanner input){}

}
