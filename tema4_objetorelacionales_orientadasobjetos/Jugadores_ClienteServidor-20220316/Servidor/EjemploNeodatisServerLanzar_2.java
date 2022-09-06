package Servidor;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

public class EjemploNeodatisServerLanzar_2 {

    public static void main(String[] args) {
            ODBServer server = null;
            // Crea el servidor en el puerto 8000
            server = ODBFactory.openServer(8000);
            // Abrir BD
            server.addBase("base1", "neodatisServer.test");
            // Se inicia el servidor ejecut�ndose en segundo plano
            server.startServer(true);
            System.out.println("Servidor iniciado....");
    }

}
