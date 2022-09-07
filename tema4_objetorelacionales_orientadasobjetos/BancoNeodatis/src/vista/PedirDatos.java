package vista;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

import modelo.Cliente;
import modelo.CuentaCorriente;
import modelo.CuentaPlazo;
import modelo.Movimiento;
import utilidades.ControlData;

public class PedirDatos {

	static Scanner sc = new Scanner(System.in);

	public static CuentaCorriente pedirCuentaCorriente() {
		System.out.println("Introduce el número de la cuenta");
		int numero = ControlData.lerInt(sc);
		System.out.println("Introduce la sucursal de la cuenta ");
		String sucursal = sc.nextLine();
		System.out.println("Introduce el saldo actual");
		float saldo = ControlData.lerFloat(sc);
		CuentaCorriente c = new CuentaCorriente(numero, sucursal, saldo, null);
		return c;
	}

	public static CuentaPlazo pedirCuentaPlazo() {
		System.out.println("Introduce el número de la cuenta");
		int numero = ControlData.lerInt(sc);
		System.out.println("Introduce la sucursal de la cuenta ");
		String sucursal = sc.nextLine();
		System.out.println("Introduce el saldo actual");
		float saldo = ControlData.lerFloat(sc);
		System.out.println("Introduce los intereses");
		int intereses = ControlData.lerInt(sc);
		System.out.println("Introduce la fecha de vencimiento, formato YYYY-MM-DD");
		String fechaVencimiento = sc.nextLine();
		System.out.println("Introduce el depósito a plazo");
		float depositoPlazo = ControlData.lerFloat(sc);
		CuentaPlazo c = new CuentaPlazo(numero, sucursal, saldo, null, intereses, fechaVencimiento, depositoPlazo);
		return c;
	}

	public static String pedirDni() {
		System.out.println("Introduce el Dni del cliente");
		String dni = sc.nextLine();
		return dni;
	}

	public static Cliente pedirCliente(String dni) {
		System.out.println("Introduce el nombre del cliente");
		String nombre = sc.nextLine();
		Cliente cl = new Cliente(dni, nombre, null);
		return cl;
	}

	public static Movimiento pedirMovimiento(CuentaCorriente c) {

		LocalDateTime l = LocalDateTime.now();
		Timestamp t = Timestamp.valueOf(l);
		char tipo;
		do {
			System.out.println("Introduce el tipo de movimiento: teclea a para ingreso o b para retirada");
			tipo = ControlData.lerChar(sc);
		} while (tipo != 'a' && tipo != 'b');

		System.out.println("Introduce el importe del movimiento");
		float importe = ControlData.lerFloat(sc);
		float saldoRestante = 0;
		if (tipo == 'a') {
			saldoRestante = c.getSaldoActual() - importe;
		} else {
			saldoRestante = c.getSaldoActual() + importe;
		}
		Movimiento m = new Movimiento(t, c, tipo, importe, saldoRestante);
		return m;
	}

	public static int pedirNumCuenta() {
		System.out.println("Introduce el número de la cuenta");
		int numero = ControlData.lerInt(sc);
		return numero;
	}

	public static int pedirIntereses() {
		System.out.println("Introduce los nuevos intereses");
		int intereses = ControlData.lerInt(sc);
		return intereses;
	}

	public static Timestamp pedirFechaInicio() {
		Timestamp timestamp = null;
		do {
			System.out.println("Introduce la fecha de inicio. FORMATO: yyyy-MM-dd hh:mm:ss");
			String fecha = sc.nextLine();
			try {
				var date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(fecha);
				timestamp = new Timestamp(date.getTime());		
			} catch (ParseException exception) {
				System.out.println("Formato incorrecto. FORMATO: yyyy-MM-dd hh:mm:ss");
			}
		} while (timestamp == null);

		return timestamp;
	}

	public static Timestamp pedirFechaFin() {
		Timestamp timestamp = null;
		do {
			System.out.println("Introduce la fecha de fin. FORMATO: yyyy-MM-dd hh:mm:ss");
			String fecha = sc.nextLine();
			try {
				var date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(fecha);
				timestamp = new Timestamp(date.getTime());

			} catch (ParseException exception) {
				System.out.println("Formato incorrecto. FORMATO: yyyy-MM-dd hh:mm:ss");

			}
		} while (timestamp == null);

		return timestamp;
	}

}
