package conexion;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class ClienteODB  {

	public static ODB iniciarCliente() {
		ODB odb=ODBFactory.openClient("localhost", 8001, "BANCO.DB");		
		System.out.println("Cliente conectado");	
		return odb;	
	}
	
}
