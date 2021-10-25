/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author mrnov
 */
public class FicherosTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //ej1();
        
       // usandoASCII();
        
        ej2App();
    }
    
    //ej1.
    /*
    1) Crea un fichero de texto con el nombre y contenido que tu quieras. 
    Ahora crea una aplicación que lea este fichero de texto carácter a carácter 
    y muestre su contenido por pantalla  sin espacios. 
    
    Por ejemplo, si un fichero tiene el siguiente texto “Esto es una prueba”, 
    deberá mostrar “Estoesunaprueba”.

    Captura las excepciones que veas necesario.
    */
    
    public static void ej1(){
        final String nomFichero="pruebasEj1.txt";
        String mensaje = ""; 
        
        File fich = new File("pruebasEj1.txt");
        if(fich.exists()){
            try(FileReader fr=new FileReader (nomFichero)){

                int valor=fr.read();
                while(valor!=-1){//Mientras el fichero no se acabe
                    //Si el caracter es un espacio(valor 32) no lo escribe
                    if(valor!=32){//también quita lineas en blanco
                        System.out.print((char)valor);
                        mensaje+=((char)valor);
                    }
                    valor=fr.read();
                }
                
                JOptionPane.showMessageDialog(null, mensaje);
            }catch(IOException e){
                //System.out.println("Problemas con el E/S "+e);
            }
        }
        else{
            //System.out.println("No Existe.Debe Crearlo");
            
        }       
    }
    
    //Lectura FicheroTexto con caracteres ASCII
    public static void usandoASCII(){
        String ruta=JOptionPane.showInputDialog("Introduce la ruta del fichero");
        String texto=JOptionPane.showInputDialog("Introduce el texto que quieras escribir en el fichero");
        
        escribirFichero(ruta, texto);
 
        mostrarFicheroMay(ruta);
    }
    
    public static void escribirFichero(String nomFich, String texto){
        try(FileWriter fw=new FileWriter(nomFich);){
 
            //Escribimos el texto en el fichero
            fw.write(texto);
 
        }catch(IOException e){
            System.out.println("Problemas en la escritura E/S "+e);
        }
    }
    
    public static void mostrarFicheroMay(String nomFich){
        String mensaje ="";
        try(FileReader fr=new FileReader (nomFich)){
 
            int valor=fr.read();
 
            while(valor!=-1){
 
                //Solo cambiara el caracter si es una minuscula o una mayuscula
                char caracter=(char)valor;
                if(caracter>=97 && caracter<=122){
                    caracter-=32;
                }else if(caracter>=65 && caracter<=90){
                    caracter+=32;
                }
                System.out.print(caracter);
                mensaje+=caracter;
                valor=fr.read();
            }
 
            JOptionPane.showMessageDialog(null, mensaje);
        }catch(IOException e){
            System.out.println("Problema con la E/S "+e);
        }
    }
 

    
    //ej2
    /*
    Crea una aplicación que pida la ruta de dos ficheros de texto y de una 
    ruta de destino (solo la ruta, sin fichero al final). Debes copiar el 
    contenido de los dos ficheros en uno, este tendrá el nombre de los 
    dos ficheros separados por un guion bajo, este se guardara en la ruta donde
    le hayamos indicado por teclado.

    Para unir los ficheros en uno, crea un método donde le pases como parámetro 
    todas las rutas. En este método, aparte de copiar debe comprobar que 
    si existe el fichero de destino, nos muestre un mensaje informándonos de 
    si queremos sobrescribir el fichero. Te recomiendo usar la clase File y JOptionPane.

    Por ejemplo, si tengo un fichero A.txt con “ABC” como contenido, 
    un fichero B.txt con “DEF” y una ruta de destino D:\, 
    el resultado sera un fichero llamado A_B.txt en la ruta D:\ o la actual con el contenido “ABCDEF”.
    */
    
    public static void ej2App(){
        //Introducimos los datos
        String rutaFichero1=JOptionPane.showInputDialog("Indica la ruta del primer fichero");
        String rutaFichero2=JOptionPane.showInputDialog("Indica la ruta del segundo fichero");
        String rutaDestino=JOptionPane.showInputDialog("Indica la ruta donde quieres guardarlo");
 
        //Creamos dos objetos File para que nos sea mas sencillo manejarlos
        File fichero1=new File(rutaFichero1);
        File fichero2=new File(rutaFichero2);
 
        //Troceamosl el nombre del primer fichero para que se quede sin extension
        String primerFichero=fichero1.getName().substring(0, fichero1.getName().length()-4);
 
        //Crear el nombre de salida del fichero
        String nombreFicheroFinal=primerFichero+"_"+fichero2.getName();
 
        rutaDestino+="\\"+nombreFicheroFinal;
 
        File destino=new File(rutaDestino);
 
        UneFicheros(fichero1, fichero2, destino);
    }
    
    public static void UneFicheros (File fich1, File fich2, File destino){
 
        try (BufferedReader br=new BufferedReader(new FileReader(fich1));
            BufferedReader br2=new BufferedReader(new FileReader(fich2))){
 
            int eleccion=-1;
 
            if(destino.exists()){
                eleccion=JOptionPane.showConfirmDialog(null, "El fichero ya existe, ¿Quieres sobrescribir el fichero "+destino.getName()+"?",
                        "Sobrescribir",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
            if(eleccion!=JOptionPane.CANCEL_OPTION){
 
                /*
                 * Lo creamos aquí, ya que si lo hacemos arriba
                 * siempre existira porque se crea al abrir el Stream
                 */
 
                BufferedWriter bw=new BufferedWriter(new FileWriter(destino));
 
                //Copiamos el contenido al fichero destino
                //OPCION1
//                copiar(bw, br);
//                bw.flush();
//                
//                copiar(bw, br2);
//                bw.flush();
                
                //OPCION2
                copiar(bw, br);
                
                copiar(bw, br2);
                bw.flush();
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
 
    }
 
    private static void copiar(BufferedWriter bw, BufferedReader br) throws IOException{
 
        String linea=br.readLine();
        while(linea!=null){

            bw.write(linea);

            linea=br.readLine();
        }
 
    }
}
