/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EMPLEADOSYDEPARTAMENTOS;

import Cadenas.Cadenas;
import ControlData.ControlData;
import java.util.Scanner;
import org.xmldb.api.base.XMLDBException;

/**
 *
 * @author Estefania
 */
public class AppXMLDBDepartamentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws XMLDBException, Exception {

        Scanner input = new Scanner(System.in);

        ConexionXMLBEmpleadosDepartamentos.coleccion = ConexionXMLBEmpleadosDepartamentos.obtenColeccion();

        byte op = 0;
        do {
            Cadenas.menuDepartamentos();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    CRUD.listarDepartamentos();
                    break;
                case 2:
                    CRUD.insertarDepartamento21();
                    System.out.println("DEPARTAMENTO AÑADIDO");
                    CRUD.consultarUnDepartamentos("21");
                    break;
                case 3:
                    System.out.println("Introduzca un número de departamento:");
                    String numDepartamento = ControlData.leerString(input);

                    CRUD.consultarUnDepartamentos(numDepartamento);
                    break;
                case 4:
                    System.out.println("Introduzca un número de departamento:");
                    String numDepart = ControlData.leerString(input);
                    
                    CRUD.modificarDepartamento(numDepart, "NOMBRE NUEVO");
                    
                    System.out.println("DEPARTAMENTO MODIFICADO");
                    CRUD.consultarUnDepartamentos(numDepart);
                    break;
                case 5:
                    System.out.println("Introduzca un número de departamento:");
                    String numDepar = ControlData.leerString(input);
                    
                    CRUD.borrarDepartamento(numDepar);
                    System.out.println("DEPARTAMENTO BORRADO");
                    break;
                case 0:
                    Cadenas.fin();
                    break;
                default:
                    Cadenas.mensajeDefault();
                    break;
            }

        } while (op != 0);

        ConexionXMLBEmpleadosDepartamentos.coleccion.close();
    }

}
