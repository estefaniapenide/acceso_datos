package controlador;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.*;
import vista.Mensajes;
import vista.PedirDatos;

public class Insertar {

	public static void insertarCuentaCorriente(ODB odb) {
		CuentaCorriente c = PedirDatos.pedirCuentaCorriente();
		IQuery query = new CriteriaQuery(Cuenta.class, Where.equal("numero", c.getNumero())).setPolymorphic(true);
		Objects cuentasRepetidas = odb.getObjects(query);
		if (cuentasRepetidas.isEmpty()) {
			Cliente cl = recuperarCliente(odb);
			cl.addCuenta(c);
			c.addCliente(cl);	
			odb.store(c);
			odb.commit();
			Mensajes.cuentaCreada();
		} else {
			Mensajes.cuentaRepetida();
		}
	}

	
	public static void insertarCuentaPlazo(ODB odb) {
		CuentaPlazo c = PedirDatos.pedirCuentaPlazo();
		IQuery query = new CriteriaQuery(Cuenta.class, Where.equal("numero", c.getNumero())).setPolymorphic(true);
		Objects cuentasRepetidas = odb.getObjects(query);
		if (cuentasRepetidas.isEmpty()) {
			Cliente cl = recuperarCliente(odb);
			cl.addCuenta(c);
			c.addCliente(cl);
			odb.store(c);
			odb.commit();
			Mensajes.cuentaCreada();
		} else {
			Mensajes.cuentaRepetida();
		}

	}

	public static Cliente recuperarCliente(ODB odb) {
		String dni = PedirDatos.pedirDni();
		IQuery query = new CriteriaQuery(Cliente.class, Where.equal("dni", dni));
		Cliente cliente;
		try {
			cliente = (Cliente) odb.getObjects(query).getFirst();
		} catch (ODBRuntimeException e) {
			cliente = PedirDatos.pedirCliente(dni);
		}
		return cliente;
	}

	public static void insertarMovimiento(ODB odb) {
		int numero = PedirDatos.pedirNumCuenta();
		IQuery query = new CriteriaQuery(CuentaCorriente.class, Where.equal("numero", numero));
		CuentaCorriente c;
		try {
			c = (CuentaCorriente) odb.getObjects(query).getFirst();
			Movimiento m = PedirDatos.pedirMovimiento(c);
			c.setSaldoActual(m.getSaldoResultante());
			c.addMovimiento(m);
			odb.store(c);
			odb.commit();
			Mensajes.movimientoGuardado();
		} catch (ODBRuntimeException e) {
			Mensajes.cuentaNoExiste();
		}

	}

}
