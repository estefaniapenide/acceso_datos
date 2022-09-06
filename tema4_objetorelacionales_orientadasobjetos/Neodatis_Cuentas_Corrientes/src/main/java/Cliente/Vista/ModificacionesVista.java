/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente.Vista;

import Cadenas.Cadenas;
import Cliente.Controlador.CRUD;
import ControlData.ControlData;
import POO.Modelo.C_Cliente;
import POO.Modelo.C_Cuenta;
import POO.Modelo.C_CuentaPlazo;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class ModificacionesVista {

    public static void modificarIntereses(Scanner input) {

        boolean permitirModificacion = false;

        Cadenas.m2ModificacionInteres();
        Cadenas.datosCP();
        Cadenas.numeroCuenta();
        int numero = ControlData.leerInt(input);

        if (CRUD.existeCuentaPorNumero(numero)) {

            C_Cuenta cuenta = CRUD.obtenerCuentaPorNumero(numero);

            if (cuenta instanceof C_CuentaPlazo) {

                Cadenas.datosCliente();
                Cadenas.nombre();
                String nombre = ControlData.leerString(input).toUpperCase();

                for (C_Cliente cliente : cuenta.getClientes()) {
                    if (cliente.getNombre().equals(nombre)) {
                        permitirModificacion = true;
                    }
                }

                if (permitirModificacion) {
                    
                    System.out.println(cuenta);
                    
                    System.out.println("NUEVOS INTERESES:");
                    int intereses = ControlData.leerInt(input);
                    
                    CRUD.modificarIntereses(cuenta, intereses);
                    
                    System.out.println("LOS INTERESES HAN SIDO MODIFICADOS");

                } else {
                    System.out.println("\nEL CLIENTE " + nombre + " NO ES TITULAR DE LA CUENTA " + numero + ". NO PUEDE MODIFICARLA\n");
                }

            } else {
                System.out.println("\nLA CUENTA " + numero + " ES DE TIPO CORRIENTE. NO ES POSIBLE TIENE INSTERESES\n");
            }

        } else {
            System.out.println("\nLA CUENTA PLAZO " + numero + " NO EXISTE\n");
        }
    }
}
