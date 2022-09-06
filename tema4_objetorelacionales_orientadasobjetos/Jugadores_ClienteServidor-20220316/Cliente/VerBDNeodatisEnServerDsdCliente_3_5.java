package Cliente;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class VerBDNeodatisEnServerDsdCliente_3_5 {
	public static void main(String[] args) {
		ODB odb = null;
		try {
                    
			odb = ODBFactory.openClient("localhost", 8000, "base1");
			Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
			System.out.printf("%d Jugadores: %n", objects.size());
			int i = 1;
			// visualizar los objetos
			while (objects.hasNext()) {
				Jugadores jug = objects.next();
				System.out.printf("%d: %s, %s, %s %n", i++, jug.getNombre(), jug.getDeporte(), jug.getCiudad(),
						jug.getEdad());
			}

		} finally {
			if (odb != null) 
				odb.close();
			
		}
	}

}
