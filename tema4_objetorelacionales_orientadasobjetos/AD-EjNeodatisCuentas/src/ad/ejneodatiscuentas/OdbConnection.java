/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBRuntimeException;

/**
 *
 * @author a20armandocb
 */
public class OdbConnection {
    private final static String BASE_DATOS = "Libreria.DB";
    private static ODB odb;
    
    private OdbConnection(){
        
    }

    public static ODB getOdb() throws Exception{
        if(odb == null || odb.isClosed()){
            try{               
                odb = ODBFactory.openClient("localhost", OdbServer.PORT,OdbServer.BASE_DATOS);
            }catch(ODBRuntimeException e){ //TODO tratar excepciones en AccionesApp.
                throw new Exception("Error al conectarse a la base de datos. ODBRuntimeException");
            }
        }        
        return odb;
    }
        
}
