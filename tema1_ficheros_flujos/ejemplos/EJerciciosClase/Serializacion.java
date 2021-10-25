/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros.ejercicios;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author mrnov
 */
public class Serializacion {
    
    /*5)
    Mismo ejercicio que Fich. Binarios - flujo Datos pero con serialización, 
    para ello, crea una simple clase Vehiculo
    con los atributos matricula, marca, tamaño del deposito y modelo, 
    con sus respectivos métodos get y el constructor se invocara con todos los atributos.

    El atributo tamañoDeposito no se incluirá en el fichero (aun así debemos pedirlo), 
    debemos indicarlo en la clase (recuerda el uso de transient).

    Recuerda que al usar la clase ObjectOutputStream, si vamos a añadir varios objetos 
    en distintas ejecuciones, debemos crear nuestra propia versión de ObjectOutputStream. 
    */
    
    public static void main(String[] args) {
 
        //File fichero=new File("C:\\fich\\vehiculos_obj.ddr");
        File fichero=new File("vehiculos_obj.ddr");
        
        String matricula=JOptionPane.showInputDialog("Introduce la matricula");
        String marca=JOptionPane.showInputDialog("Introduce la marca");
        String texto=JOptionPane.showInputDialog("Introduce el tamaño del deposito");
        double tamañoDeposito=Double.parseDouble(texto);
        String modelo=JOptionPane.showInputDialog("Introduce el modelo");
 
        /*
         * No creamos los objetos para manejar objetos,
         * ya que sino siempre existiria el fichero
         */
 
        try{
 
            Vehiculo vehiculo=new Vehiculo(matricula, marca, tamañoDeposito ,modelo);
 
            //Si el fichero está vacío, usamos nuestra clase de Object y sino usamos la original
            //if(fichero.length()!=0){
            if(fichero.exists()){
                MiObjectOutputStream moos=new MiObjectOutputStream(new FileOutputStream(fichero, true));
                moos.writeObject(vehiculo);
                moos.close();
            }else{
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero));
                oos.writeObject(vehiculo);
                oos.close();
            }
 
            //Creamos despues este objeto para asegurarnos que no de un error, en caso de no existir el fichero
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois=new ObjectInputStream(fis);
            //muestraDatos(ois);
            
            muestraDatos(fis,ois);
 
        }catch(ClassNotFoundException e){
 
        }catch(EOFException e){
            System.out.println("fin");
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
 
    public static void muestraDatos(ObjectInputStream ois) throws IOException, ClassNotFoundException {
 
        //Cuando se acabe el fichero saltara la excepcion EOFException
        while(true){
            Vehiculo ref=(Vehiculo)ois.readObject();
 
            JOptionPane.showMessageDialog(null, "El vehiculo tiene una matricula "+ref.getMatricula()+
            ", su marca es "+ref.getMarca()+" y su modelo es "+ref.getModelo());
        }
    }
    
    public static void muestraDatos(FileInputStream fis,ObjectInputStream ois) throws IOException, ClassNotFoundException {
 
        //Cuando se acabe el fichero saltara la excepcion EOFException
        while(fis.available() > 0){
            Vehiculo ref=(Vehiculo)ois.readObject();
 
            JOptionPane.showMessageDialog(null, "El vehiculo tiene una matricula "+ref.getMatricula()+
            ", su marca es "+ref.getMarca()+" y su modelo es "+ref.getModelo());
        }
    }
    
    
}
