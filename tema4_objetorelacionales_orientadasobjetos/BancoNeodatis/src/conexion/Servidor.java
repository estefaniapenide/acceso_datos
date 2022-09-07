package conexion;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

public class Servidor {

	public static ODBServer crearServidor() {
		ODBServer server=null;
		server=ODBFactory.openServer(8001);
		server.addBase("BANCODB", "banco.test");
		server.startServer(true);
		System.out.println("Servidor iniciado");
		return server;
	
	}
	
	
}
