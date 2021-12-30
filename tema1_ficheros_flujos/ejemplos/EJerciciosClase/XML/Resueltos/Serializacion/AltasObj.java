package Serializacion;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author mrnovoa
 */
public class AltasObj {

    public static void altas(File fichero) throws IOException {
        
        ObjectOutputStream oos;
        if (fichero.exists()) {
            oos = new ObjectOutputStream(new FileOutputStream(fichero, true));
            
            String dni = JOptionPane.showInputDialog("Escribe dni del alumno");
            
            String nombre = JOptionPane.showInputDialog("Introduce el nombre del alumno");
            
            String telefono = JOptionPane.showInputDialog("Introduce el telefono del alumno");
            
            Alumno al = new Alumno();
            al.dni=dni;
            al.nombre=nombre;
            al.telefono=telefono;
            
            oos.writeObject(al);
            oos.close();
        } else {
            System.out.println("FICHERO INEXISTENTE");

        }
    }
}
