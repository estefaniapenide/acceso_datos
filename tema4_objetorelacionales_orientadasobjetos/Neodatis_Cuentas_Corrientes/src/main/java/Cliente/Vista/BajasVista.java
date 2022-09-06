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
public class BajasVista {

    public static void bajaCuentaPlazo(Scanner input) {

        boolean permitirBaja = false;

        Cadenas.m3BajaCienteCuentaPlazo();
        
        Cadenas.datosCP();
        Cadenas.numeroCuenta();
        int numero = ControlData.leerInt(input);

        if (CRUD.existeCuentaPorNumero(numero)) {

            C_Cuenta cuenta = CRUD.obtenerCuentaPorNumero(numero);

            if (cuenta instanceof C_CuentaPlazo) {

                Cadenas.datosCliente();
                Cadenas.dni();
                String dni = ControlData.leerDni(input);

                for (C_Cliente cliente : cuenta.getClientes()) {
                    if (cliente.getDni().equals(dni)) {
                        permitirBaja = true;
                    }
                }
                if (permitirBaja) {
                    
                    CRUD.eliminarCuenta(cuenta);
                    
                    System.out.println("\nLA CUENTA "+numero+" HA SIDO DADA DE BAJA\n");

                } else {
                    System.out.println("\nEL CLIENTE " + dni + " NO ES TITULAR DE LA CUENTA " + numero + ". NO PUEDE DARLA DE BAJA\n");
                }

            } else {
                System.out.println("\nLA CUENTA " + numero + " ES DE TIPO CORRIENTE. NO ES POSIBLE BORRARLA EN ESTA OPERACIÓN\n");
            }

        } else {
            System.out.println("\nLA CUENTA PLAZO " + numero + " NO EXISTE\n");
        }

    }

}
