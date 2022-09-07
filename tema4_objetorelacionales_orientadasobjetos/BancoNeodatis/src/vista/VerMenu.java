
package vista;

import java.util.ArrayList;
import java.util.Scanner;

import org.neodatis.odb.ODB;

import controlador.Borrar;
import controlador.Consultar;
import controlador.Insertar;
import controlador.Modificar;
import utilidades.ControlData;
import utilidades.Menu;

public class VerMenu {

	static Scanner sc = new Scanner(System.in);
	static byte op;
	static Menu menuAltas = new Menu(altas());
	static byte opMenu;

	public static void menuPrincipal(ODB odb) {

		Menu menuPrincipal = new Menu(opciones());

		System.out.println("*********************************************************************");
		System.out.println("****************************BIENVENIDO*********************** ");

		do {
			System.out.println("*********************************************************************");
			System.out.println("Introduzca la opción que desee realizar:");
			menuPrincipal.printMenu();
			opMenu = ControlData.lerByte(sc);
			switch (opMenu) {
			case 1:
				menuAltas(odb);
				break;
			case 2:
				Modificar.modificarIntereses(odb);
				break;
			case 3:
				Borrar.quitarCuenta(odb);
				break;
			case 4:
				Consultar.clientesEmpiezanC(odb);
				break;
			case 5:
				Consultar.clientesRicos(odb);
				break;
			case 6:
				Consultar.clientesNumerosRojos(odb);
				break;
			case 7:
				Consultar.saldoMedioCuentasPlazo(odb);
				break;
			case 8:
				Consultar.extractoMovimientos(odb);
				break;

			}
		} while (opMenu != 9);
	}

	public static void menuAltas(ODB odb) {

		menuAltas.printMenu();
		opMenu = ControlData.lerByte(sc);
		switch (opMenu) {
		case 1:
			Insertar.insertarCuentaCorriente(odb);
			break;
		case 2:
			Insertar.insertarCuentaPlazo(odb);
			break;
		case 3:
			Insertar.insertarMovimiento(odb);
			break;
		}

	}

	static ArrayList<String> opciones() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Altas");
		opciones.add("Modificar intereses en Cuenta a plazo");
		opciones.add("Dar de baja un cliente en una Cuenta a Plazo");
		opciones.add("Mostrar clientes cuyo nombre empiece por C");
		opciones.add("Mostrar clientes con una cuenta corriente con más de 200.000 euros");
		opciones.add("Mostrar clientes en números rojos");
		opciones.add("Consultar saldo medio cuentas a plazo");
		opciones.add("Obtener extracto movimientos de una cuenta corriente");
		opciones.add("Salir");
		return opciones;
	}

	static ArrayList<String> altas() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Cuenta corriente");
		opciones.add("Cuenta a Plazo");
		opciones.add("Movimientos");
		opciones.add("Salir");
		return opciones;
	}

}
