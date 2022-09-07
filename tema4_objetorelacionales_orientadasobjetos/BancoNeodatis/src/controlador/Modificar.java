package controlador;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBRuntimeException;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.CuentaPlazo;
import vista.Mensajes;
import vista.PedirDatos;

public class Modificar {

	public static void modificarIntereses(ODB odb) {
		int numero = PedirDatos.pedirNumCuenta();
		try {
			IQuery query = new CriteriaQuery(CuentaPlazo.class, Where.equal("numero", numero));
			int intereses = PedirDatos.pedirIntereses();
			CuentaPlazo c = (CuentaPlazo) odb.getObjects(query).getFirst();
			c.setIntereses(intereses);
			odb.store(c);
			odb.commit();
			Mensajes.interesesModificados(c);
		} catch (ODBRuntimeException e) {
			Mensajes.cuentaNoExiste();
		}
	}

}
