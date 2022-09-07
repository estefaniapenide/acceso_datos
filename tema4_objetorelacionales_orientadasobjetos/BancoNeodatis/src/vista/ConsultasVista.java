package vista;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Movimiento;

public class ConsultasVista {

	public static void imprimirCliente(Cliente c) {
		System.out.println(c.toString());
		
	}

	public static void imprimirMovimiento(Movimiento m) {
		System.out.println(m.toString());
		
	}

	public static void imprimirCuenta(Cuenta c) {
		System.out.println(c.toString());
		
	}

}
