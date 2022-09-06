/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Servidor;

import Cadenas.Cadenas;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author Estefania
 */
public class ServidorLibreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ODBServer server = null;

        server = ODBFactory.openServer(8000);

        server.addBase("libreria", "libreria.test");
        server.startServer(true);

        Cadenas.inicioServidor();
    }

}
