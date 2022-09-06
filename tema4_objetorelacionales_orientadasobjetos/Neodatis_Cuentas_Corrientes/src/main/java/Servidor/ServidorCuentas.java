/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Cadenas.Cadenas;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a20estefaniapc
 */
public class ServidorCuentas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ODBServer server = null;

        server = ODBFactory.openServer(8000);

        server.addBase("BD_CUENTAS", "BD_CUENTAS.test");
        server.startServer(true);

        Cadenas.inicioServidor();
    }
    
}
