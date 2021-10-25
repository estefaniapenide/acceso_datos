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
public class Ejemplo02Excepciones {
    public static void main(String[] args) {
    /*
    * El ejemplo captura 3 excepciones que se pueden producir. Cuando se encuentra
    * el primer error se produce un salto al bloque catch que maneja dicho error;
    * en este caso al encontrar la sentencia de asignación arraynum[10] = 20;
    * se lanza la excepción ArrayIndexOutOfBoundsException (ya que el array 4
    * está definido para 4 elementos y se da valor al elemento de la posición 10)
    *
    */
        String cad1 = "20", cad2 = "0", mensaje;
        int numerador, denominador, cociente;
        int[] arraynum = new int[4];
        try{
            //codigo que puede producir errores
            arraynum[10] = 20; //sentencia que produce la excepcion

            numerador = Integer.parseInt(cad1); //no se ejecuta
            denominador = Integer.parseInt(cad2);//no se ejecuta
            cociente = numerador/denominador; //no se ejecuta
            mensaje = String.valueOf(cociente); //no se ejecuta

        }catch(NumberFormatException nfe){
            mensaje = "Caracteres no numéricos";
        }catch (ArithmeticException ae) {
            mensaje = "División por cero";
        }catch (ArrayIndexOutOfBoundsException aio) {
            mensaje = "Array fuera de rango";
        }finally{
            System.out.println("finally Se ejecuta siempre");
        }
        System.out.println(mensaje); //si se ejecuta
    }// fin main
}// fin clase
