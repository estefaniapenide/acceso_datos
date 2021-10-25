/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD1Excepciones;

/**
 *
 * @author mrnov
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
public class Ejemplo04Excepciones {
    
    public static void main(final String[] args) {
        FileInputStream fs = null;
        ObjectInputStream os = null;
        System.out.println("Nombre \t Edad" );
        try{
            fs = new FileInputStream("Personas01.txt");
            os = new ObjectInputStream(fs);
            while(true){ // lectura del fichero
            // os debe realizar un casting al tipo original
            Ejemplo04ExcepcionesPersona p =
            (Ejemplo04ExcepcionesPersona)os.readObject();
            System.out.println(p.getNombre() +"\t"
            +p.getEdad());
            }
        }catch(ClassNotFoundException cnf){

            System.out.println("Error la clase");
        }catch(FileNotFoundException fnfe){
            System.out.println("Error en el fichero");
        }catch(IOException ioe){
            System.out.println("Error E/L");
        }finally{
            try{
                os.close();
            }catch(IOException ioe){
                System.out.println("Error E/L");
            }catch(NullPointerException np){
                System.out.println("NullPointer");
            }
        }
    }
}
