package main;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBServer;

import conexion.ClienteODB;
import conexion.Servidor;
import vista.VerMenu;

public class Main {
	public static void main(String[] args) {
		ODBServer server = Servidor.crearServidor();
		ODB odb = ClienteODB.iniciarCliente();
		//CrearBase.crear(odb);
		VerMenu.menuPrincipal(odb);
		odb.commit();
		odb.close();
		server.close();
	}
	
}
