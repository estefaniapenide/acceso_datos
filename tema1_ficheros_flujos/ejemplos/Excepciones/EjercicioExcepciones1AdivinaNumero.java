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
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjercicioExcepciones1AdivinaNumero {
/*
Escribe un programa que juegue con el usuario a adivinar un número. 
El ordenador debe generar un número entre 1 y 500, 
y el usuario tiene que intentar adivinarlo. 
Para ello, cada vez que el usuario introduce un valor, el ordenador debe 
decirle al usuario si el número que tiene  que adivinar es mayor o menor 
que el que ha introducido el usuario. Cuando consiga adivinarlo, 
debe indicárselo e imprimir en pantalla el número de veces 
que el usuario ha intentado adivinar el número. 
Si el usuario introduce algo que no es un número, debe indicarlo en pantalla, 
y contarlo como un intento.
*/
    
public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    int numeroAdivinar = (int) (Math.random() * 500);
    // debe ser entre 1 y 500, por lo que se incrementa en 1;
    int numero = 0;
    int intentos = 0;
    do {
        boolean leido;
        do {
            System.out.println("Introduzca un numero (1-500)");
            try {
                intentos++;
                numero = teclado.nextInt();
                System.out.println("El numero introducido es: " + numero);
                leido = true;
            } catch (InputMismatchException ex) {
                System.out.println("No ha introducido un numero entero");
                teclado.next(); // se lee el elemento no reconocido para
                                // eliminarlo
                leido = false;
            }
        } while (leido == false);
        if (numero > numeroAdivinar) {
            System.out.println("El numero es menor. Sigue intentando");
        }
        if (numero < numeroAdivinar) {
            System.out.println(numeroAdivinar+" El numero es mayor. Sigue intentandolo");
        }
    } while (numero != numeroAdivinar);
    System.out.println("Enhorabuena. Has acertado, ya que el numero es: " + numeroAdivinar);
    System.out.println("Lo has conseguido tras todos estos intentos: " + intentos);
    }   
    
}
