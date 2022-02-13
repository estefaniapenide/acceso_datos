/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package progrmacionsa_estefania_penide;

import Cadenas.Cadenas;
import controldata.ControlData;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class ProgrmacionSA_Estefania_Penide {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        byte op=0;
        do{
            Cadenas.menuPrincipal();
            op=ControlData.leerByte(input);
            switch(op){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.mesajeDefaultMenu();
                    break;
            }
        }while(op!=0);
    }
    
}
