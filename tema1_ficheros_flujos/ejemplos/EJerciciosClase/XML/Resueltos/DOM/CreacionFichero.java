package DOM;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class CreacionFichero {

    public static void crear(File fichero) throws IOException {
        int op;
        
        ObjectOutputStream oos;

        if (fichero.exists()) {
          
            op = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el fichero actual y crear uno nuevo?", "Alerta!", JOptionPane.YES_NO_OPTION);
            
            if(op==0){//resp 0 -> si
                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                oos.close();
                JOptionPane.showMessageDialog(null, "Ha dicho que SI se sobreescriba el fichero");
            }
            else{//resp 1 -> no
                JOptionPane.showMessageDialog(null, "Ha dicho que NO se sobreescriba el fichero");
            }
           
        } else {
            oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
            oos.close();
            JOptionPane.showMessageDialog(null, "FICHERO CREADO");
        }
    }
}
