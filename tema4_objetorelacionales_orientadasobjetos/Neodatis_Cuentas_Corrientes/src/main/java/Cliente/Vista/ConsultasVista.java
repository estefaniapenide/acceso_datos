/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente.Vista;

import Cadenas.Cadenas;
import Cliente.Controlador.CRUD;
import ControlData.ControlData;
import POO.Modelo.C_Cuenta;
import POO.Modelo.C_CuentaCorriente;
import POO.Modelo.C_Movimiento;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class ConsultasVista {

    public static void visulaizarClientesEmpiezanPorLetra(String letra) {

        letra = letra.toUpperCase();
        Cadenas.m4ClientesC(letra);
        CRUD.imprimirClientesEmpiezanPorLetra(letra);
    }

    public static void visulaizarClientesSaldoCCSuperiorImporte(int importe) {

        Cadenas.m5ClientesSaldoCCSuperiorImporte(importe);
        CRUD.imprimirClientesSaldoSuperiorImporte(importe);
    }

    public static void numeroClientesNumerosRojos() {

        Cadenas.m6ClientesumerosRojos();
        CRUD.imprimirNumeroClientesNumerosRojos();
        System.out.println();
    }

    public static void saldoMedioCuentasPlazo() {

        Cadenas.m7SaldoMedioCuentasPlazo();
        CRUD.imprimirSaldoMedioCuentasPlazo();
        System.out.println();
    }

    public static void visualizacionMovimientosCCEntreDosFechas(Scanner input) {

        ArrayList<C_Movimiento> movimientos = new ArrayList<C_Movimiento>();

        Cadenas.m8ExtractoEntreFechas();
        
        Cadenas.datosCC();
        Cadenas.numeroCuenta();
        int numero = ControlData.leerInt(input);
        if (CRUD.existeCuentaPorNumero(numero)) {

            C_Cuenta cuenta = CRUD.obtenerCuentaPorNumero(numero);

            if (cuenta instanceof C_CuentaCorriente) {

                System.out.println("FECHA INICIO (AAAA-MM-DD):");
                String finicio = ControlData.leerFecha(input);
                Date dateInicio = Date.valueOf(finicio);

                System.out.println("FECHA FIN (AAAA-MM-DD):");
                String ffin = ControlData.leerFecha(input);
                Date dateFin = Date.valueOf(ffin);

                if (dateInicio.before(dateFin) || dateInicio.equals(dateFin)) {

                    C_CuentaCorriente c = (C_CuentaCorriente) cuenta;

                    //movimientos = CRUD.obtenerMovimientosPorCuentaEntreDosFechas(c, dateInicio, dateFin); 
                    
                    for (C_Movimiento mov : (ArrayList<C_Movimiento>) c.getMovimientos()) {
                        if ((mov.getFecha().after(dateInicio) || mov.getFecha().equals(dateInicio)) && ((mov.getFecha().before(dateFin) || mov.getFecha().equals(dateFin)))) {
                            movimientos.add(mov);
                        }
                    }

                    System.out.println();

                    if (!movimientos.isEmpty()) {

                        System.out.printf("%-21s %-9s %-10s %-9s %-20s %n", "NÚMERO DE CUENTA", "FECHA", "OPERACIÓN", "IMPORTE", "SALDO RESULTANTE");
                        for (C_Movimiento movimiento : movimientos) {
                            System.out.printf("%-18s %-16s %-8s %-10s %-20s %n", movimiento.getCuenta().getNumero(), movimiento.getFecha(), movimiento.getOperacion(), movimiento.getImporte(), movimiento.getSaldoResultante());
                        }

                        System.out.println();

                    } else {
                        System.out.println("NO HAY MOVIMIENTOS\n");
                    }

                } else {
                    System.out.println("\nFECHA INICIO DEBE SER ANTERIOR O IGUAL A FECHA FIN\n");
                }
            } else {
                System.out.println("\nLA CUENTA " + numero + " ES DE TIPO PLAZO. NO ES POSIBLE CONSULTAR MOVIMIENTOS\n");
            }
        } else {
            System.out.println("\nLA CUENTA CORRIENTE " + numero + " NO EXISTE\n");
        }

    }

}
