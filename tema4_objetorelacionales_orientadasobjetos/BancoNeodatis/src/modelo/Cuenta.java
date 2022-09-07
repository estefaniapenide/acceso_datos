package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public abstract class Cuenta implements Serializable {

	private int numero;
	private String sucursal;
	private float saldoActual;
	private Set<Cliente> clientes;

	public Cuenta() {
	}

	public Cuenta(int numero, String sucursal, float saldoActual, Set<Cliente> clientes) {
		super();
		this.numero = numero;
		this.sucursal = sucursal;
		this.saldoActual = saldoActual;
		this.clientes = clientes;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSucursal() {
		return sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	public float getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void addCliente(Cliente cliente) {
		if (clientes == null) {
			Set<Cliente> nuevoCliente = new HashSet<>();
			nuevoCliente.add(cliente);
			clientes = nuevoCliente;
		} else {
			this.clientes.add(cliente);
		}
	}

	public String toString() {
		String respuesta="Número: "+numero+" Saldo actual: "+saldoActual+" Clientes: ";
		for(Cliente x:clientes) {
			respuesta+="\n";
			respuesta+=x.toString();		
		}
		return respuesta;
	}
	
	
	
	
	
	
}
