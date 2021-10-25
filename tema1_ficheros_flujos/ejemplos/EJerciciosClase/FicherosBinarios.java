/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros.ejercicios;

import Secuenciales.FlujosDeDatos.LeerDatos;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author mrnov
 */
public class FicherosBinarios {
     public static void main(String[] args) {
         
       ej3();
         
       //ej4();
    
     }
     
    /*BYTES
    Crea una aplicación que copie un fichero binario a otra localización. 
    En lugar de leer y escribir byte a byte, crea un array de bytes con el 
    tamaño del fichero de origen (utiliza el método available()), 
    copia el contenido del fichero a este array y escribe a partir de este array.

    Recuerda que debes controlar las excepciones que puedan aparecer. 
    En caso de error, mostrar una ventana de dialogo con información del error.
    */
    
    public static void ej3() {
        //Pedimos las rutas
        String origen=JOptionPane.showInputDialog("Escribe la ruta del origen");
        String destino=JOptionPane.showInputDialog("Escribe la ruta del destino");
 
        copiaFicheros(origen, destino);
 
    }
        
    public static void copiaFicheros (String origen, String destino){
 
        try(FileInputStream fis=new FileInputStream(origen);
            FileOutputStream fos=new FileOutputStream(destino)){         

            //Creamos un array de bytes con el tamaño del fichero de origen
            byte byteA[]=new byte[fis.available()];//Número de bytes por leer

            //Copia todos los bytes del fichero al array
            fis.read(byteA);

            //Escribe todos los bytes en el fichero de destino
            //OPCION1
            fos.write(byteA);
            
            //OPCION2
//            DataOutputStream dos = new DataOutputStream(fos);
//            dos.flush();
                 
            //Si se quiere leer el destino
            //BufferedReader br=new BufferedReader(new FileReader(destino));
            //FicheroTextoBufferedApp.leeFichero(br);
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void muestraDatosFichTextODatos(DataInputStream dis) throws IOException {
        //Cuando se acabe el fichero saltara la excepcion
        while(true){
            JOptionPane.showMessageDialog(null, "Línea del fichero copiado "+dis.readUTF());
        }
    }
    
    /*DATOS
    Crea una aplicación que almacene los datos básicos de un vehículo como 
    la matricula(String), marca (String), tamaño de deposito (double) y modelo (String) 
    en ese orden y de uno en uno usando la clase DataInputStream.

    Los datos anteriores datos se pedirán por teclado y se irán añadiendo al 
    fichero (no se sobrescriben los datos) cada vez que ejecutemos la aplicación.

    El fichero siempre sera el mismo, en todos los casos.

    Muestra todos los datos de cada coche en un cuadro de dialogo, es decir, 
    si tenemos 3 vehículos mostrara 3 cuadros de dialogo con sus respectivos datos. 
    
    Un ejemplo de salida de información puede ser este:
    
    El vehiculo tiene una matrícula 6691PJ, su marca es Opel, el tamaño depósito 
    es de 45.0 litros y su modelo es Astra.
    */
    
    public static void ej4(){
        //final String RUTA="C:\\fich\\vehiculos.ddr";
        
        final String RUTA="vehiculos.ddr";
 
        String matricula=JOptionPane.showInputDialog("Introduce la matricula");
        String marca=JOptionPane.showInputDialog("Introduce la marca");
        String texto=JOptionPane.showInputDialog("Introduce el tamaño del deposito");
        double tamañoDeposito=Double.parseDouble(texto);
        String modelo=JOptionPane.showInputDialog("Introduce el modelo");
 
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(RUTA,true));
            DataInputStream dis=new DataInputStream(new FileInputStream(RUTA))){
 
            introduceDatos(dos, matricula, marca, tamañoDeposito, modelo);
 
            muestraDatos(dis);
            
        }catch(EOFException e){
 
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
    
    public static void introduceDatos(DataOutputStream dos,
                                        String matricula,
                                        String marca,
                                        double tamañoDeposito,
                                        String modelo) throws IOException{
 
        dos.writeUTF(matricula);
        dos.writeUTF(marca);
        dos.writeDouble(tamañoDeposito);
        dos.writeUTF(modelo);
 
    }
 
    public static void muestraDatos(DataInputStream dis) throws IOException {
        //Cuando se acabe el fichero saltara la excepcion
        while(true){
            JOptionPane.showMessageDialog(null, "El vehiculo tiene una matricula "+dis.readUTF()+
            ", su marca es "+dis.readUTF()+", el tamaño del deposito es de "+dis.readDouble()+" " +
            "litros y su modelo es "+dis.readUTF());
        }
    }
}
