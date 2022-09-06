/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cadenas;

/**
 *
 * @author a20estefaniapc
 */
public class Cadenas {
    
        public static void menuDepartamentos() {
        System.out.println("............................................................\n"
                + ". 1.- Listar todos los departamentos. \n"
                + ". 2.- Insertar un departamento (inserta 21, 'El 21’,Vigo'). \n"
                + ". 3.- Consultar un departamento.\n"
                + ". 4.- Modificar un departamento (cambia el nombre por ‘NOMBRE NUEVO').\n"
                + ". 5.- Borrar un departamento.\n"
                + ". 0.- SALIR.\n"
                + "............................................................\n");
    }

    public static void mensajeDefault() {
        System.out.println("No ha introducido ninguna de las opciones.\n");
    }
    
    public static void fin(){
    System.out.println("Programa finalizado.");
    }
    
}
