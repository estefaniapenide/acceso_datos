package modelo;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Movimiento {

	private Timestamp fecha;
	private Cuenta cuenta;
	private char operacion;
	private float importe;
	private float saldoResultante;

	public Movimiento() {
	}

	public Movimiento(Timestamp fecha, Cuenta cuenta, char operacion, float importe, float saldoResultante) {
		super();
		this.fecha = fecha;
		this.cuenta = cuenta;
		this.operacion = operacion;
		this.importe = importe;
		this.saldoResultante = saldoResultante;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public char getOperacion() {
		return operacion;
	}

	public void setOperacion(char operacion) {
		this.operacion = operacion;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public float getSaldoResultante() {
		return saldoResultante;
	}

	public void setSaldoResultante(float saldoResultante) {
		this.saldoResultante = saldoResultante;
	}

	public String toString() {
		return "Fecha: " + fecha + " Importe: " + importe + " Saldo resultante: " + saldoResultante;

	}

}
