/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> opciones = new ArrayList<String>();
    private int numOpciones;

    public Menu(ArrayList opciones) {
        this.opciones = opciones;
        this.numOpciones = opciones.size();
    }

    /**
     * Imprime el menú por pantalla
     */
    public void printMenu() {
        for (int i = 1; i <= opciones.size(); i++) {
            System.out.println(i + ".- " + opciones.get(i - 1));
        }
    }

    /**
     * Comproba que un parámetro está dentro dun rango
     *
     * @param op Tipo int - valor a analizar como perteneciente o no al rango de
     * opciones del menú
     * @return Tipo boolean - true si está en el rango y false en caso contrario
     */
    public boolean rango(byte op) {
        boolean enrango = true;
        if (op < 1 || op > numOpciones) {
            enrango = false;
            System.out.print("\tERRO: debe introducir un valor dentro do rango de números posibles. "
                    + "\n\t\tVolva a introducir un número: \n");
        }
        return enrango;
    }

    public boolean rangoInt(int op) {
        boolean enrango = true;
        if (op < 1 || op > numOpciones) {
            enrango = false;
            System.out.print("\tERRO: debe introducir un valor dentro do rango de números posibles. "
                    + "\n\t\tVolva a introducir un número: \n");
        }
        return enrango;
    }

}
