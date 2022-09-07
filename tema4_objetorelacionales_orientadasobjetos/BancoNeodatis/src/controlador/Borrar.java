package controlador;

import java.util.Iterator;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.*;
import vista.Mensajes;
import vista.PedirDatos;

public class Borrar {

	public static void quitarCuenta(ODB odb) {
		String dni = PedirDatos.pedirDni();
		int numero = PedirDatos.pedirNumCuenta();
		IQuery query = new CriteriaQuery(Cliente.class, Where.equal("dni", dni));
		Cliente cl;

		try {
			cl = (Cliente) odb.getObjects(query).getFirst();
			for (Iterator<Cuenta> it = cl.getCuentas().iterator(); it.hasNext();) {
				if (it.next().getNumero() == numero) {
				}
				if (it.next() instanceof CuentaPlazo) {
					it.remove();
					Mensajes.cuentaBorrada();
				} else {
					Mensajes.noEsPlazo();
				}
			}
		} catch (ODBRuntimeException e) {
			Mensajes.cuentaNoAsignada();
		}

	}

}
