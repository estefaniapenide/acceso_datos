/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente.Vista;

import Cadenas.Cadenas;
import Cliente.Controlador.CRUD;
import ControlData.ControlData;
import POO.Modelo.C_Cliente;
import POO.Modelo.C_Cuenta;
import POO.Modelo.C_CuentaCorriente;
import POO.Modelo.C_CuentaPlazo;
import POO.Modelo.C_Movimiento;
import java.sql.Time;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author a20estefaniapc
 */
public class AltasVista {
    
//Controlar porque estoy guardando duplicados!!!! Al menos al dar de alta movimientos, pero tengo que controlar el resto
    public static void altas(Scanner input) {
        byte op = 0;
        do {
            Cadenas.menuAltas();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    altaCuentaCorriente(input);
                    break;
                case 2:
                    altaCuentaPlazo(input);
                    break;
                case 3:
                    AltaMovimiento(input);
                    break;
                case 0:
                    Cadenas.vueltaMenuAnterior();
                    break;
                default:
                    Cadenas.defaultmensaje();
                    break;
            }
        } while (op != 0);
    }
    
     
    private static void altaCliente(Scanner input, C_Cuenta cuenta, String tipo) {

        Cadenas.datosCliente();
        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        if (!CRUD.existeClientePorDni(dni)) {
            Cadenas.nombre();
            String nombre = ControlData.leerString(input).toUpperCase();

            Cadenas.direccion();
            String direccion = ControlData.leerString(input).toUpperCase();

            C_Cliente cliente = new C_Cliente(dni, nombre, direccion);
            cliente.getCuentas().add(cuenta);

            cuenta.getClientes().add(cliente);

            CRUD.guardarCuenta(cuenta);
            
            Cadenas.CuentaCreada(tipo);
           

        } else {

            CRUD.imprimirClientePorDni(dni);

            C_Cliente cliente = CRUD.obtenerClientePorDni(dni);
            
            CRUD.addClienteACuenta(cliente, cuenta);

            Cadenas.CuentaCreada(tipo);
        }
    }

    private static void altaCuentaCorriente(Scanner input) {

        Cadenas.m1_1AltaCuentaCorriente();

        Cadenas.datosCC();
        Cadenas.numeroCuenta();
        int numeroCuenta = ControlData.leerInt(input);

        if (!CRUD.existeCuentaPorNumero(numeroCuenta)) {
            Cadenas.sucursal();
            String sucursal = ControlData.leerString(input).toUpperCase();

            Cadenas.saldoActual();
            float saldoActual = ControlData.leerFloat(input);

            C_Cuenta cuentaCorriente = new C_CuentaCorriente(numeroCuenta, sucursal, saldoActual);
            
            altaCliente(input, cuentaCorriente, "CORRIENTE");

        } else {

            Cadenas.CuentaYaExiste(numeroCuenta);
            CRUD.imprimirCuentaPorNumero(numeroCuenta);
        }

    }

    private static void altaCuentaPlazo(Scanner input) {

        Cadenas.m1_2AltaCuentaPlazo();

        Cadenas.datosCP();
        Cadenas.numeroCuenta();
        int numeroCuenta = ControlData.leerInt(input);

        if (!CRUD.existeCuentaPorNumero(numeroCuenta)) {
            Cadenas.sucursal();
            String sucursal = ControlData.leerString(input).toUpperCase();

            Cadenas.saldoActual();
            float saldoActual = ControlData.leerFloat(input);

            Cadenas.intereses();
            int intereses = ControlData.leerInt(input);

            Cadenas.fechaVencimiento();
            String fechaVencimiento = ControlData.leerFecha(input);

            Cadenas.depositoPlazo();
            float depositoPlazo = ControlData.leerFloat(input);

            C_Cuenta cuentaPlazo = new C_CuentaPlazo(numeroCuenta, sucursal, saldoActual, intereses, fechaVencimiento, depositoPlazo);
            
            altaCliente(input, cuentaPlazo, "PLAZO");

        } else {

            Cadenas.CuentaYaExiste(numeroCuenta);

            CRUD.imprimirCuentaPorNumero(numeroCuenta);
        }

    }

    private static char elegirMovimiento(Scanner input) {

        char operacion = 'I';

        byte op = 0;
        do {
            Cadenas.menuOperacion();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    operacion = 'I';
                    break;
                case 2:
                    operacion = 'R';
                    break;
                default:
                    Cadenas.defaultmensaje();
                    break;
            }
        } while (op != 1 && op != 2);

        return operacion;
    }

    public static void AltaMovimiento(Scanner input) {

        Cadenas.m1_3AltaMovimiento();

        Cadenas.datosCC();
        Cadenas.numeroCuenta();
        int numero = ControlData.leerInt(input);

        if (CRUD.existeCuentaPorNumero(numero)) {

            C_Cuenta cuenta = CRUD.obtenerCuentaPorNumero(numero);

            if (cuenta instanceof C_CuentaCorriente) {

                Cadenas.movimientos();
                
                char operacion=elegirMovimiento(input);
                
                Cadenas.importe();
                float importe = ControlData.leerFloat(input);
                
                Date fecha = new Date(new java.util.Date().getTime());
                Time hora = new Time(fecha.getTime());
                
                C_Movimiento movimiento = new C_Movimiento(fecha,cuenta,operacion,importe);
                
                CRUD.addMovimientoCuenta(cuenta, movimiento);
                
                Cadenas.movimientoAdded();

            } else {
                Cadenas.cuentaPlazoNoMovimiento(numero);
            }
        } else {
            Cadenas.cuentaNoExiste("CORRIENTE", numero);
        }

    }

}
