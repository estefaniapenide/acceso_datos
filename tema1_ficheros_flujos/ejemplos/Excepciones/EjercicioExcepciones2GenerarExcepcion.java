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
public class EjercicioExcepciones2GenerarExcepcion {
    //Escribe un programa que lance y capture una excepción.
    public static void main(String[] args) {
        try {
            System.out.println("Mensaje mostrado por pantalla");
            Exception e = new Exception("Esto es un objeto Exception");
            throw e;
        } catch (Exception ex) {
            System.out.println("Excepcion capturada con mensaje: " + ex.getMessage());
        }
        System.out.println("Programa terminado");
    }
    
    /*
    El programa abre un bucle try{} en el que comienza mostrando un mensaje por pantalla. 
    A continuación, crea un objeto de la clase Exception, indicando en su constructor
    un mensaje explicativo. Se procede a continuación a su lanzamiento utilizando 
    la sentencia  throw. El bloque catch{} asociado al bloque try{} anterior 
    constituye el manejador de la excepción e incluye las sentencias necesarias 
    para su tratamiento. En este caso, se limita a mostrar por pantalla el mensaje 
    contenido en el objeto excepción capturado con ayuda del método getMessage().
    */
   
}
