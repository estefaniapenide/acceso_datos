package Cliente;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;


public class LlenaBDneodatisServer_1 {	
	public static void main(String[] args) {
	  // Crear instancias para almacenar en BD
	  Jugadores j1 = new Jugadores("Maria","voleibol", "Madrid",14);
	  Jugadores j2 = new Jugadores("Miguel","tenis", "Madrid",15);
	  Jugadores j3 = new Jugadores("Mario", "baloncesto","Guadalajara",15);
	  Jugadores j4 = new Jugadores("Alicia","tenis","Madrid",14);
		 		
	  ODB odb = ODBFactory.open("neodatisServer.test");// Abrir BD
		 
	  // Almacenamos objetos
	  odb.store(j1); 
	  odb.store(j2);
	  odb.store(j3);
	  odb.store(j4);
				
        //recuperamos todos los objetos
        Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
        System.out.printf("%d Jugadores: %n", objects.size());
        
	  int i = 1;
	  // visualizar los objetos		
        while(objects.hasNext()){
	     Jugadores jug = objects.next();
           System.out.printf("%d: %s, %s, %s %n",
        		   i++, jug.getNombre(), jug.getDeporte(),
        		   jug.getCiudad(), jug.getEdad());
        }		
	  odb.close(); // Cerrar BD				
   }
}
