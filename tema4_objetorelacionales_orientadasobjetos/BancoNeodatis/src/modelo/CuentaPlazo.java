package modelo;

import java.util.Set;

public class CuentaPlazo extends Cuenta {

	private int intereses;
	private String fechaVencimiento;
	private float depositoPlazo;

	public CuentaPlazo() {
	}

	public CuentaPlazo(int numero, String sucursal, float saldoActual, Set<Cliente> clientes, int intereses,
			String fechaVencimiento, float depositoPlazo) {
		super(numero, sucursal, saldoActual, clientes);
		this.intereses = intereses;
		this.fechaVencimiento = fechaVencimiento;
		this.depositoPlazo = depositoPlazo;
	}

	public int getIntereses() {
		return intereses;
	}

	public void setIntereses(int intereses) {
		this.intereses = intereses;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public float getDepositoPlazo() {
		return depositoPlazo;
	}

	public void setDepositoPlazo(float depositoPlazo) {
		this.depositoPlazo = depositoPlazo;
	}

}
