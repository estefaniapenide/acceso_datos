/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Cadenas.Cadenas;
import Cliente.Vista.AltasVista;
import Cliente.Vista.BajasVista;
import Cliente.Vista.ConsultasVista;
import Cliente.Vista.ModificacionesVista;
import ControlData.ControlData;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class ClienteCuentas {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        byte op = 9;
        do {
            Cadenas.menuPrincipal();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    AltasVista.altas(input);
                    break;
                case 2:
                    ModificacionesVista.modificarIntereses(input);
                    break;
                case 3:
                    BajasVista.bajaCuentaPlazo(input);
                    break;
                case 4:
                    ConsultasVista.visulaizarClientesEmpiezanPorLetra("C");
                    break;
                case 5:
                    ConsultasVista.visulaizarClientesSaldoCCSuperiorImporte(200000);
                    break;
                case 6:
                    ConsultasVista.numeroClientesNumerosRojos();
                    break;
                case 7:
                    ConsultasVista.saldoMedioCuentasPlazo();
                    break;
                case 8:
                    ConsultasVista.visualizacionMovimientosCCEntreDosFechas(input);
                    break;
                case 9:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.defaultmensaje();
                    break;

            }
        } while (op != 9);
    }

}
