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
public class EjercicioExcepciones3AleatorioExcepcion {
    /*
    Escribe un programa que genere un número aleatorio e indique si el número generado es par o impar. 
    El programa utilizará para ello el lanzamiento de una excepción.
    */
    public static void main(String[] args) {
        try {
            System.out.println("Generando número aleatorio");
            int entero = (int) (Math.random() * 1000);
            if (entero % 2 == 0) {
                throw new Exception("Se genero un numero par: "+entero);
            } else {
                throw new Exception("Es impar: "+entero);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

/*
El programa utiliza el método random() de la clase Math para obtener un 
número aleatorio entre 0 y 999 (por poner un rango cualquiera).
A continuación, se determina si el número es par o impar y se lanza
una excepción con el correspondiente mensaje para indicarlo. 
El manejador de la excepción se limitará a mostrar el mensaje asociado a la excepción capturada.
*/
}
