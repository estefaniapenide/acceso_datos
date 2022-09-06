/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Cadenas.Cadenas;
import Cliente.operaciones.Gestiones;
import Cliente.controldata.ControlData;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class ClienteLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        byte op = 12;
        do {
            Cadenas.menu();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    Gestiones.altaAutorLibros(input);
                    break;
                case 2:
                    Gestiones.addLibroAAutor(input);
                    break;
                case 3:
                    Gestiones.modificarDireccionAutor(input);
                    break;
                case 4:
                    Gestiones.modificarPrecioLibroDadoAutorYTitulo(input);
                    break;
                case 5:
                    Gestiones.borradoLibrosAutorCodigoLibro(input);
                    break;
                case 6:
                    Gestiones.autoresNacionalidadItaliana(input);
                    break;
                case 7:
                    Gestiones.librosAutorEntreDosFechas(input);
                    break;
                case 8:
                    Gestiones.autoresNacionalidadEspanolaMenoresDe60(input);
                    break;
                case 9:
                    Gestiones.numeroAutoresPorNacionalidad(input);
                    break;
                case 10:
                    Gestiones.mostrarLibrosAutor(input);
                    break;
                case 11:
                    Gestiones.dadoLibroBsucarAutorYOtrosDatosLibro(input);
                    break;
                case 12:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.defaultmensaje();
                    break;
            }
        } while (op != 12);

    }

}
