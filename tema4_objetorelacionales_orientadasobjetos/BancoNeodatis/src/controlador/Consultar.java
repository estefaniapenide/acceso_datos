package controlador;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

import modelo.*;
import vista.ConsultasVista;
import vista.Mensajes;
import vista.PedirDatos;

public class Consultar {

	public static void clientesEmpiezanC(ODB odb) {

		ICriterion criterio = Where.like("nombre", "C%");
		IQuery query = new CriteriaQuery(Cliente.class, criterio);
		Objects clientes = odb.getObjects(query);

		Mensajes.empiezanConC();
		while (clientes.hasNext()) {
			Cliente cliente = (Cliente) clientes.next();
			ConsultasVista.imprimirCliente(cliente);
		}

	}

	public static void clientesRicos(ODB odb) {

		ICriterion criterio = Where.ge("saldoActual", 201000);
		IQuery query = new CriteriaQuery(CuentaCorriente.class, criterio);
		Objects cuentas = odb.getObjects(query);

//El Set es necesario para que no salga duplicado un cliente con dos cuentas corrientes seleccionadas
		if (!cuentas.isEmpty()) {
			Set<Cliente> clientesRicos = new HashSet<>();
			Mensajes.clientesRicos();

			while (cuentas.hasNext()) {
				CuentaCorriente cuenta = (CuentaCorriente) cuentas.next();
				for (Cliente c : cuenta.getClientes()) {

					clientesRicos.add(c);
				}
			}
			for (Cliente c : clientesRicos) {
				ConsultasVista.imprimirCliente(c);
			}

		} else {
			Mensajes.sinClientesRicos();
		}
	}

	public static void clientesNumerosRojos(ODB odb) {

		// ICriterion criterio = Where.lt("saldoActual", 0);
		// IQuery query = new CriteriaQuery(Cuenta.class, criterio);

		IQuery query = new CriteriaQuery(Cliente.class);
		Objects clientes = odb.getObjects(query);
		int saldoTotalCliente = 0;
		boolean flag = false;

		if (!clientes.isEmpty()) {
			Mensajes.clientesNumRojosCabecera();
			while (clientes.hasNext()) {
				Cliente cliente = (Cliente) clientes.next();
				saldoTotalCliente = 0;
				if (cliente.getCuentas() != null) {
					for (Cuenta c : cliente.getCuentas()) {
						saldoTotalCliente += c.getSaldoActual();
					}
					if (saldoTotalCliente < 0) {
						ConsultasVista.imprimirCliente(cliente);
						flag = true;
					}
				}
			}
			if (!flag) {
				Mensajes.sinClientesNumerosRojos();
			}

		} else {
			Mensajes.sinClientes();
		}

	}

	public static void saldoMedioCuentasPlazo(ODB odb) {

		try {
			Values val = odb.getValues(new ValuesCriteriaQuery(CuentaPlazo.class).avg("saldoActual"));
			ObjectValues ov = ov = val.nextValues();
			Mensajes.saldoMedioCuentasPlazo(ov);
		} catch (ArithmeticException e) {
			Values val2 = odb
					.getValues(new ValuesCriteriaQuery(CuentaPlazo.class).sum("saldoActual").count("saldoActual"));
			ObjectValues ov2 = val2.nextValues();
			float media;
			BigDecimal sumaSaldo = (BigDecimal) ov2.getByIndex(0);
			BigInteger cuentas = (BigInteger) ov2.getByIndex(1);
			media = sumaSaldo.floatValue() / cuentas.floatValue();
			Mensajes.saldoMedioCuentasPlazo(media);
		}

	}
	
	/* Sin Values Query
	public static void saldoMedioCuentasPlazo(ODB odb) {
		IQuery query = new CriteriaQuery(CuentaPlazo.class);
		Objects cuentas = odb.getObjects(query);
		CuentaPlazo c;
		float saldoTotal = 0;
		int numCuentas = 0;

		while (cuentas.hasNext()) {
			c = (CuentaPlazo) cuentas.next();
			numCuentas++;
			saldoTotal += c.getSaldoActual();
		}
		float saldoMedio = saldoTotal / numCuentas;
		Mensajes.saldoMedioCuentasPlazo(saldoMedio);
	}
*/

	public static void extractoMovimientos(ODB odb) {

		int numero = PedirDatos.pedirNumCuenta();
		IQuery query = new CriteriaQuery(CuentaCorriente.class, Where.equal("numero", numero));
		CuentaCorriente c;
		boolean flag = false;
		try {
			c = (CuentaCorriente) odb.getObjects(query).getFirst();
			Timestamp t1 = PedirDatos.pedirFechaInicio();
			Timestamp t2 = PedirDatos.pedirFechaFin();
			for (Movimiento m : c.getMovimientos()) {
				if (m.getFecha().after(t1) && m.getFecha().before(t2)) {
					ConsultasVista.imprimirMovimiento(m);
					flag = true;
				}
			}
			if (!flag) {
				Mensajes.sinMovimientos();
			}

		} catch (ODBRuntimeException e) {
			Mensajes.cuentaNoExiste();
		}

	}

	public static void verTodo(ODB odb) {
		IQuery query = new CriteriaQuery(Cuenta.class).setPolymorphic(true);
		Objects cuentas = odb.getObjects(query);
		Cuenta c;

		while (cuentas.hasNext()) {
			c = (Cuenta) cuentas.next();
			ConsultasVista.imprimirCuenta(c);
		}

	}

}
