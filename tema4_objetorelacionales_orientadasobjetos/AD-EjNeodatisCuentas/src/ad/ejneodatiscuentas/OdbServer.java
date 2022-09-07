/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas;

import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

/**
 *
 * @author a20armandocb
 */
public class OdbServer {

    private static ODBServer server = null;
    public static final int PORT = 8000;
    public static final  String BASE_DATOS = "CuentasServer";
    private static boolean run = false;

    private OdbServer() {
    }

    public static boolean run() {
        if (server == null) {
            server = ODBFactory.openServer(8000);
            server.addBase(BASE_DATOS,BASE_DATOS + ".db");
            server.startServer(true);
            run = true;
            return true;
        }
        return false;
    }

    public static boolean stop() {
        if (server != null) {
            server.close();
            server = null;
            run = false;
            return true;
        }
        return false;
    }

    public static boolean isRun() {
        return run;
    }
    

}
