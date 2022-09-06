/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controldata;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author a20estefaniapc
 */
public class ControlData {

    public static String leerCodigo(Scanner sc) {
        String codigo = null;
        boolean codigoValido = true;
        do {
            codigo = sc.next();
            Pattern pat = Pattern.compile("[0-9]{3}[A-Z]{1}");
            Matcher mat = pat.matcher(codigo);
            if (mat.matches()) {
                codigoValido = true;
            } else {
                System.out.println("ERROR. El código debe cumplir el formato: 3 dígitos seguido de una letra mayúscula.");
                sc.nextLine();
                codigoValido = false;
            }
        } while (!codigoValido);
        
        return codigo;

    }

    /**
     * Comprueba que una fecha está escrita en formato aaaa-mm-dd y que es
     * válida.
     *
     * @param sc Tipo Scanner
     * @return Tipo String - la fecha introducida
     */
    public static String leerFecha(Scanner sc) {

        String fecha = null;
        boolean fechaValida = true;
        do {
            fecha = sc.next();
            Pattern pat = Pattern.compile("[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}");
            Matcher mat = pat.matcher(fecha);
            if (mat.matches()) {
                int dia = Integer.parseInt(Character.toString(fecha.charAt(8)) + Character.toString(fecha.charAt(9)));
                int mes = Integer.parseInt(Character.toString(fecha.charAt(5)) + Character.toString(fecha.charAt(6)));
                int ano = Integer.parseInt(Character.toString(fecha.charAt(0)) + Character.toString(fecha.charAt(1)) + Character.toString(fecha.charAt(2)) + Character.toString(fecha.charAt(3)));
                if (mes > 12 || mes < 1) {
                    fechaValida = false;
                } else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                    if (dia > 31 || dia < 1) {
                        fechaValida = false;
                    } else {
                        fechaValida = true;
                    }
                } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                    if (dia > 30 || dia < 1) {
                        fechaValida = false;
                    } else {
                        fechaValida = true;
                    }
                } else if (mes == 2) {
                    if (((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0))) && (dia <= 29 && dia > 0)) {
                        fechaValida = true;
                    } else if (dia <= 28 && dia > 0) {
                        fechaValida = true;
                    } else {
                        fechaValida = false;
                    }
                }

            } else {
                fechaValida = false;
            }
            if (!fechaValida) {
                System.out.println("ERROR. No ha introducido una fecha válida.\nEscriba otra fecha. Formato: yyyy-mm-dd");
                sc.nextLine();
            }

        } while (!fechaValida);

        return fecha;

    }

    /**
     * Comprueba que un dni es válido.
     *
     * @param sc Tipo Scanner
     * @return Tipo String - el dni introducido pasado a mayúsculas
     */
    public static String leerDni(Scanner sc) {

        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String dni = null;
        boolean dniValido = true;
        do {
            dni = sc.next();
            dni = dni.toUpperCase();
            if (dni.length() != 9) {
                dniValido = false;
            } else {
                String dniNumero = "";
                for (int i = 0; i < 8; i++) {
                    dniNumero = dniNumero + dni.charAt(i);
                }
                Pattern pat = Pattern.compile("[0-9]{8}");
                Matcher mat = pat.matcher(dniNumero);
                if (!mat.matches()) {
                    dniValido = false;
                } else {
                    int numero = Integer.parseInt(dniNumero);
                    if (numero % 23 < 0 || numero % 23 > 22) {
                        dniValido = false;
                    } else if (letras[numero % 23] == dni.charAt(8)) {
                        dniValido = true;
                    }

                }

            }

            if (!dniValido) {
                System.out.println("ERROR. No ha introducido un DNI válido.");
                sc.nextLine();

            }
        } while (!dniValido);

        return dni;

    }

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
