package PruebasXMLDB_XQJ.principal;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class pruebaexcepcionesxqj {

	public static void main(String[] args) {
		XQConnection conn = null;
		XQDataSource server = new ExistXQDataSource();
		XQPreparedExpression consulta = null;
		XQResultSequence rs = null, resultado = null;
		try {
			server.setProperty("serverName", "localhost");
			server.setProperty("port", "8080");
		} catch (XQException e) {
			System.out.println("Error en el servidor. Mensaje : " + e.getMessage());
			System.out.println("Error en el servidor. Causa :  " + e.getCause());
		}
		try {
			conn = server.getConnection();
		} catch (XQException e) {
			System.out.println("Error en la conexi�n : " + e.getMessage());
		}

		System.out.println("--------Ejemplo Consulta Productos -----------------");
		try {
			consulta = conn.prepareExpression("for $de in /db/ColeccionesXML/BDProductosXML/productos/produc return $de");
		} catch (XQException e) {
			System.out.println("Error en la expresi�n. Mensaje : " + e.getMessage());
			System.out.println("Error en la expresi�n. Causa : " + e.getCause());
		}

		try {
			resultado = consulta.executeQuery();
			while (resultado.next()) {
				System.out.println("Elemento " + resultado.toString());
			}
		} catch (XQException e) {
			System.out.println("Error en la ejecuci�n. Mensaje: " + e.getMessage());
			System.out.println("Error en la ejecuci�n. Causa: " + e.getCause());
		}

		try {
			conn.close();
		} catch (XQException e) {
			System.out.println("Error al cerrar la conexi�n.");
		}
	} // FIn maim
}// FIN CLASS PruebaXQJExcepciones
