/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 *
 * @author Estefania
 */
public class Conexion {

    public static ODB odb;

    private Conexion(ODB odb) {
        this.odb = odb;
    }

    public static ODB getConexion() {

        if (odb == null) {

            odb = ODBFactory.openClient("localhost", 8000, "libreria");
        }
        return odb;
    }

}
