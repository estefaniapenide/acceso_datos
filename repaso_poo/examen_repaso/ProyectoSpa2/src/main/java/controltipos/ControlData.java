/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controltipos;

import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class ControlData {

    /**
     * Comproba que un parámetro está dentro dun rango
     *
     * @param l1 Tipo int - límite inferior del rango de números
     * @param l2 Tipo int - límite superior del rango de números
     * @param op Tipo int - valor a analizar como perteneciente o no al rango
     * l1..l2
     * @return Tipo boolean - true si está en el rango y false en caso contrario
     */
    public static boolean rango(int l1, int l2, int op) {
        boolean enrango = true;
        if (op < l1 || op > l2) {
            enrango = false;
            System.out.println("\tERROR: debe introducir un valor dentro do rango de números posibles. "
                    + "\n\t\tVuelva a introducir un número: \n");
        }
        return enrango;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo byte - valor de tipo byte introducido por teclado
     */
    public static byte leerByte(Scanner sc) {

        byte valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextByte();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca un número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;

    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return valor Tipo short - valor de tipo short introducido por teclado
     */
    public static short leerShort(Scanner sc) {
        short valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextShort();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca un número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo int - valor de tipo int introducido por teclado
     */
    public static int leerInt(Scanner sc) {
        int valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextInt();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca un número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo long - valor de tipo long introducido por teclado
     */
    public static long leerLong(Scanner sc) {
        long valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextLong();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca otro número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo float - valor de tipo float introducido por teclado
     */
    public static float leerFloat(Scanner sc) {
        float valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca otro número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo double - valor de tipo double introducido por teclado
     */
    public static double leerDouble(Scanner sc) {
        double valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextDouble();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca otro número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo boolean - valor de tipo boolean introducido por teclado
     */
    public static boolean leerBoolean(Scanner sc) {
        boolean valor = false;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextBoolean();
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca otro 'true' o 'false': ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo String - valor de tipo String introducido por teclado
     */
    public static String leerString(Scanner sc) {
        String resultado = null;

        do {
            resultado = sc.nextLine();
        } while (resultado.isEmpty());

        return resultado;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo char - valor de tipo char introducido por teclado
     */
    public static char leerChar(Scanner sc) {
        String resultado = null;

        do {
            resultado = sc.nextLine();
        } while (resultado.isEmpty());

        return resultado.charAt(0);
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo char - valor de la pimera letra que se introduce por teclado
     */
    public static char leerLetra(Scanner sc) {
        char caracter = '\0';

        do {
            caracter = (sc.nextLine()).charAt(0);
        } while (!Character.isLetter(caracter));

        return caracter;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo String - valor de tipo String introducido por teclado
     */
    public static String leerNome(Scanner sc) {
        String nome = null;
        boolean repetir = true;

        do {
            nome = sc.nextLine();
            if (nome.isEmpty() || !nome.toUpperCase().matches("[A-ZÁÉÍÓÚÜÑ\\-\\s]*")) {
                System.out.println("\tERROR: debe introducir algún nombre válido "
                        + "\n\t\tVuelva a introducir: ");
            } else {
                repetir = false;
            }
        } while (repetir);

        return nome;
    }

    /**
     * Controla a introdución correcta dunha variable tipo byte utilizando unha
     * variable Scanner que se pasa por parámetro
     *
     * @param sc Tipo Scanner
     * @return Tipo int - valor de tipo int introducido por teclado
     */
    public static int leerDia(Scanner sc) {
        int valor = 0;
        boolean correcto;

        do {
            correcto = true;
            try {
                valor = sc.nextInt();
                if (valor < 1 || valor > 31) {
                    System.out.println("ERROR. No ha introducido un valor válido. Introduzca un número entre 1 y 31: ");
                    correcto = false;
                }
            } catch (Exception e) {
                System.out.println("ERROR. No ha introducido un valor válido. Introduzca un número: ");
                sc.next();
                correcto = false;
            }
        } while (!correcto);

        return valor;
    }
}
