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
public class EjercicioExcepcionesLecturaEnteroDouble {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int x = 0, y = 0;
        double m = 0, n = 0;
        String s;

        x = leerEntero("Introduce un número entero: ");
        y = leerEntero("Introduce otro número entero: ");
        
        System.out.print("Introduce un texto: ");
        s = sc.nextLine();
        
        m = leerDouble("Introduce un número double: ");
        n = leerDouble("Introduce otro número double: ");

        System.out.println("primer int introducido -> " + x);
        System.out.println("segundo int introducido -> " + y);
        System.out.println("primer double introducido -> " + m);
        System.out.println("segundo double introducido -> " + n);                                                 
        System.out.println("Texto introducido: " + s);
    }

    //Método para leer un número de tipo int y controlar la excepción
    public static int leerEntero(String s) {
        boolean repetir;
        int n=0;
        do {
            repetir = false;
            try {
                System.out.print(s);
                n = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");
                repetir = true;
            }finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }
    
    //Método para leer un número de tipo double y controlar la excepción
    public static double leerDouble(String s) {
        boolean repetir;
        double n=0;
        do {
            repetir = false;
            try {
                System.out.print(s);
                n = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor no válido");                                                            
                repetir = true;
            }finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }
}


