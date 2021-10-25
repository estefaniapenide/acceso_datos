/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD1Excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author mrnov
 */
public class EjercicioExcepcionesLecturaEnteros {
    //Tratamiento de excepciones para la lectura por teclado de cuatro números enteros.
    //Este ejemplo lo vamos a resolver de tres formas diferentes.
    
    //Solución 1: Un solo bloque try que contiene la lectura de todos los números. El inconveniente de hacerlo de esta forma es que si hay un error en la lectura de uno de los números se deben introducir todos de nuevo.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, z = 0, k = 0;
        boolean repetir;
        do {
            repetir = false;
            try {
                System.out.print("Introduce primer número entero: ");                                             
                x = sc.nextInt();

                System.out.print("Introduce segundo número entero: ");
                y = sc.nextInt();

                System.out.print("Introduce tercer número entero: ");
                z = sc.nextInt();

                System.out.print("Introduce cuarto número entero: ");
                k = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido" + e.toString());                                             
                sc.nextLine();
                repetir = true;
            }
        } while (repetir);
        System.out.println("int introducido -> " + x);
        System.out.println("int introducido -> " + y);
        System.out.println("int introducido -> " + z);
        System.out.println("int introducido -> " + k);
    }
        
    //Solución 2: Un bloque try..catch para cada lectura. En este caso la ventaja respecto a la solución anterior es que si hay un error en la lectura de uno de los números solamente se vuelve a pedir el número erróneo. El inconveniente de hacerlo de esta forma es la duplicidad de código.
//        public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = 0, y = 0, z = 0, k = 0;
//        boolean repetir;
//        do {
//            repetir = false;
//            try {
//                System.out.print("Introduce primer número entero: ");
//                x = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Valor no válido" + e.toString());                                             
//                sc.nextLine();
//                repetir = true;
//            }
//        } while (repetir);
//        do {
//            repetir = false;
//            try {
//                System.out.print("Introduce segundo número entero: ");
//                y = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Valor no válido" + e.toString());
//                sc.nextLine();
//                repetir = true;
//            }
//        } while (repetir);
//        do {
//            repetir = false;
//            try {
//                System.out.print("Introduce tercer número entero: ");
//                z = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Valor no válido" + e.toString());
//                sc.nextLine();
//                repetir = true;
//            }
//        } while (repetir);
//        do {
//            repetir = false;
//            try {
//                System.out.print("Introduce cuarto número entero: ");                                             
//                k = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Valor no válido" + e.toString());
//                sc.nextLine();
//                repetir = true;
//            }
//        } while (repetir);
//        System.out.println("int introducido -> " + x);
//        System.out.println("int introducido -> " + y);
//        System.out.println("int introducido -> " + z);
//        System.out.println("int introducido -> " + k);
//        }
        
        //Solución 3: Escribir un método para realizar la lectura del número entero. Dentro del método será donde se controle la excepción. La ventaja de hacerlo así que sque si hay un error solo se vuelve a pedir el número no válido y además evitamos la duplicidad de código.

//        static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//
//        int x = 0, y = 0, z = 0, k = 0;
//        
//        x = leerEntero("Introduce primer número entero: ");
//        y = leerEntero("Introduce segundo número entero: ");
//        z = leerEntero("Introduce tercer número entero: ");
//        k = leerEntero("Introduce cuarto número entero: ");                                                       
//
//        System.out.println("int introducido -> " + x);
//        System.out.println("int introducido -> " + y);
//        System.out.println("int introducido -> " + z);
//        System.out.println("int introducido -> " + k);
//    }
//
//    public static int leerEntero(String s) {
//        boolean repetir;
//        int n = 0;
//        do {
//            repetir = false;
//            try {
//                System.out.print(s);
//                n = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Valor no válido");                                                            
//                repetir = true;
//                sc.nextLine();
//            } 
//        } while (repetir);
//        return n;
//    }
//    }
}
