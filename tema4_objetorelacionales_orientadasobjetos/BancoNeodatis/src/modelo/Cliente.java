package modelo;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

	private String dni;
	private String nombre;
	private Set<Cuenta> cuentas;

	public Cliente() {
	}

	public Cliente(String dni, String nombre, Set<Cuenta> cuentas) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.cuentas = cuentas;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void addCuenta(Cuenta cuenta) {
		if (cuentas == null) {
			Set<Cuenta> nuevaCuenta = new HashSet<>();
			nuevaCuenta.add(cuenta);
			cuentas = nuevaCuenta;
		} else {
			this.cuentas.add(cuenta);
		}
	}

	public String toString() {
		return "Nombre: " + nombre + "       DNI: " + dni;
	}

}
