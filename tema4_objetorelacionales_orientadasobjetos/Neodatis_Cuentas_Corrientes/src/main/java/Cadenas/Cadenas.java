/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadenas;

/**
 *
 * @author a20estefaniapc
 */
public class Cadenas {

    //MENÚS
    public static void menuPrincipal() {
        System.out.println("*********************************************************************************************************************\n"
                + "*************************************************** MENÚ CUENTAS ***************************************************\n"
                + "1.-Altas\n"
                + "2.-Modificación de los intereses en una cuenta plazo ya existente, recibiendo el nº cuenta y el dni del cliente.\n"
                + "3.-Baja de una cuenta plazo, recibiendo el nº de cuenta y el nombre del cliente.\n"
                + "4.-Visualización de todos los clientes cuyo nombre empiece por 'C'.\n"
                + "5.-Visualización de todos los clientes cuyo saldo en la cuenta corriente sea > 200.000€.\n"
                + "6.-Número de clientes en números rojos.\n"
                + "7.-Saldo medio de las cuentas plazo de todos los clientes.\n"
                + "8.-Extracto de los movimientos de una cuenta corriente entre dos fechas determinadas.\n\n"
                + "9.-FIN\n"
                + "*********************************************************************************************************************");
    }

    public static void menuAltas() {
        System.out.println("\t\tALTAS\n"
                + "1.-CUENTA CORRIENTE\n"
                + "2.-CUENTA PLAZO\n"
                + "3.-MOVIMIENTO\n\n"
                + "0.- VUELTA MENÚ PRINCIPAL");
    }

    public static void menuOperacion() {
        System.out.println("\tOPERACIÓN\n"
                + "1.-INGRESAR\n"
                + "2.-RETIRAR");
    }

    public static void defaultmensaje() {
        System.out.println("NO HA INTRODUCIDO NINGUNA DE LAS OPCIONES\n");
    }

    public static void fin() {
        System.out.println("\nPROGRAMA FINALIZADO");
    }

    public static void vueltaMenuAnterior() {
        System.out.println("\nVOLVIENDO AL MENÚ ANTERIOR...");
    }

    //TÍTULOS
    public static void m1_1AltaCuentaCorriente() {
        System.out.println("\tALTA CUENTA CORRIENTE");
    }

    public static void m1_2AltaCuentaPlazo() {
        System.out.println("\tALTA CUENTA PLAZO");
    }

    public static void m1_3AltaMovimiento() {
        System.out.println("\tALTA MOVIMIENTO");
    }

    public static void m2ModificacionInteres() {
        System.out.println("\tMODIFICACIÓN INTERESES");
    }

    public static void m3BajaCienteCuentaPlazo() {
        System.out.println("\tBAJA CLIENTE CUENTA PLAZO");
    }

    public static void m4ClientesC(String letra) {
        System.out.println("\tCLIENTES CUYO NOMBRE EMPIEZA POR " + letra);
    }

    public static void m5ClientesSaldoCCSuperiorImporte(int importe) {
        System.out.println("\tCLIENTES CON SALDO SUPERIOR A " + importe + " EN CUENTA CORRIENTE");
    }

    public static void m6ClientesumerosRojos() {
        System.out.print("\tNÚMERO DE CLIENTES EN NÚMEROS ROJOS: ");
    }

    public static void m7SaldoMedioCuentasPlazo() {
        System.out.print("\tSALDO MEDIO DE LAS CUENTAS PLAZO: ");
    }

    public static void m8ExtractoEntreFechas() {
        System.out.println("\tEXTRACTO MOVIMIENTO ENTRE FECHAS DETERMINADAS");
    }

    //DATOS CLIENTES
    public static void datosCliente() {
        System.out.println("\nDASTOS CLIENTE");
    }

    public static void dni() {
        System.out.println("DNI:");
    }

    public static void nombre() {
        System.out.println("NOMBRE:");
    }

    public static void direccion() {
        System.out.println("DIRECCIÓN:");
    }

    //DATOS CUENTAS
    public static void numeroCuenta() {
        System.out.println("NÚMERO DE CUENTA:");
    }

    public static void sucursal() {
        System.out.println("SUCURSAL:");
    }

    public static void saldoActual() {
        System.out.println("SALDO ACTUAL:");
    }

    //DATOS CUENTA CORRIENTE
    public static void datosCC() {
        System.out.println("\nDATOS CUENTA CORRIENTE");
    }

    public static void movimientos() {
        System.out.println("\nMOVIMIENTOS");
    }

    //DATOS CUENTA PLAZO
    public static void datosCP() {
        System.out.println("\nDATOS CUENTA PLAZO");
    }

    public static void intereses() {
        System.out.println("INTERESES:");
    }

    public static void fechaVencimiento() {
        System.out.println("FECHA DE VENCIMIENTO:");
    }

    public static void depositoPlazo() {
        System.out.println("DEPÓSITO:");
    }

    //DATOS MOVIMIENTOS
    public static void fecha() {
        System.out.println("FECHA(AAAA-MM-DD):");
    }

    public static void hora() {
        System.out.println("HORA:");
    }

    public static void operacion() {
        System.out.println("OPERACIÓN:");
    }

    public static void importe() {
        System.out.println("IMPORTE:");
    }

    public static void saldoResultante() {
        System.out.println("SALDO RESULTANTE:");
    }

    //OTROS MENSAJES
    public static void inicioServidor() {
        System.out.println("SERVIDOR INICIADO...");
    }

    public static void errorConexionServidor() {
        System.out.println("\nNO SE HA CONECTADO A NINGÚN SERVIDOR.\nINICIE EL SERVIDOR PARA PODER CONECTARSE.");
    }

    public static void CuentaCreada(String tipo) {
        System.out.println("CUENTA " + tipo + " CREADA.");
    }

    public static void CuentaYaExiste(int numeroCuenta) {
        System.out.println("\nNO ES POSIBLE DAR DE ALTA LA CUENTA. LA CUENTA " + numeroCuenta + " YA EXISTE");
    }

    public static void cuentaNoExiste(String tipo, int numero) {
        System.out.println("LA CUENTA " + tipo + numero + " NO EXISTE");
    }

    public static void movimientoAdded() {
        System.out.println("MOVIMIENTO AÑADIDO");
    }

    public static void cuentaPlazoNoMovimiento(int numero) {
        System.out.println("LA CUENTA " + numero + " ES DE TIPO PLAZO. NO ES POSIBLE REALIZAR MOVIMIENTOS.");
    }

}
