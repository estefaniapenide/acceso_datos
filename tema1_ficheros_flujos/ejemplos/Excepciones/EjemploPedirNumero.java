/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UD1Excepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mrnov
 */
public class EjemploPedirNumero {
    //Introducción de número entre 1 y 10
    //Comprobar que se ha hecho una introducción correcta
    public static void main(String[] args) {
        int numero = -1;
        int intentos = 0;
        String linea;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.println("Introduzca un numero entre 1 y 10");
                linea = teclado.readLine();
                numero = Integer.parseInt(linea);
            } catch (IOException ex) {
                System.out.println("Error al leer del teclado");
            } catch (NumberFormatException f) {
                System.out.println("Debes introducir un numero entre 1 y 10");
            } finally {
                intentos++;
            }
        } while (numero <= 0 || numero > 10);
        System.out.println("El numero es: " + numero);
        System.out.println("Intentos: " + intentos);
    }

}
