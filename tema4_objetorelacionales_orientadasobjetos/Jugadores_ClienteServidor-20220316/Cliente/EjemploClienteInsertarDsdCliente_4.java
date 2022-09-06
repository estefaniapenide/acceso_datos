package Cliente;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class EjemploClienteInsertarDsdCliente_4 {
	public static void main(String[] args) {
		ODB odb = null;
		try{
		odb = ODBFactory.openClient("localhost", 8000, "base1");
			Jugadores j4 = new Jugadores("Andrea", "padel", "Guadalajara", 14);
			odb.store(j4);
			odb.commit();
			System.out.println("Jugador Insertado...");
		} finally {
			if (odb != null) {
				odb.close();				
			}
		}
	}// --main
}
