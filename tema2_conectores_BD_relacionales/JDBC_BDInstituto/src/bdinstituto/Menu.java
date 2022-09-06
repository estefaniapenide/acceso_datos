
package bdinstituto;

import java.io.*;

/**
 *
 * @author mrnovoa
 */
public class Menu {
    
    public static byte principal(BufferedReader leer) throws IOException{
        byte opcion;
        
        System.out.println("\nIntroduce una de las opciones: "
                + "\n 1 - Insertar nuevas filas"
                + "\n 2 - Borrar filas"
                + "\n 3 - Modificar nota de alumno"
                + "\n 4 - Consultas"
                + "\n 0 - Salir");
        opcion = Byte.parseByte(leer.readLine());
        
        return opcion;
    }
    
}
