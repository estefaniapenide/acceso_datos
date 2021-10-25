/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectoSpa2;

import POJO.Usos;
import POJO.Actividades;
import POJO.Socios;
import POJO.Spa;
import controltipos.ControlData;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Estefania
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Spa relax = new Spa("RELAX S.L", "1111111111A");

        ArrayList<Socios> socios = new ArrayList<Socios>();

        ArrayList<Actividades> actividades = new ArrayList<Actividades>();

        Actividades libre = new Actividades("libre", 0);
        Actividades grupo = new Actividades("grupo", 2);
        Actividades espacio = new Actividades("espacio", 4);

        actividades.add(libre);
        actividades.add(grupo);
        actividades.add(espacio);

        relax.setActividades(actividades);

        Scanner input = new Scanner(System.in);

        int opcion;
        do {

            printMenuInicio();

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
int a;
                    do {

                        System.out.println("            ALTA SOCIO             \n"
                                + "1.-Nuevo socio\n"
                                + "0.-Volver al menú principal\n");

                        a = ControlData.leerInt(input);
                        switch (a) {
                            case 1:
                                System.out.println("\tNUEVO SOCIO");
                                System.out.println("Nombre y apellidos: ");
                                String nuevoSocio = ControlData.leerString(input);

                                boolean socioYaRegistrado = false;
                                for (int i = 0; i < socios.size(); i++) {
                                    if (nuevoSocio.equals(socios.get(i).getNombre())) {
                                        socioYaRegistrado = true;
                                        System.out.println(nuevoSocio + " ya es miembro.\n" + socios.get(i));
                                    }
                                }
                                String codigoSocio = "";
                                if (!socioYaRegistrado) {
                                    int codSocio = socios.size() + 1;
                                    codigoSocio = String.valueOf(codSocio);

                                    System.out.println("Cuota mensual fija(€): ");
                                    float cuotaFijaMensual = ControlData.leerFloat(input);

                                    Socios socio = new Socios(codigoSocio, nuevoSocio, cuotaFijaMensual);
                                    socios.add(socio);
                                    System.out.println(socio);

                                    ArrayList<Usos> usos = new ArrayList<Usos>();

                                    socio.setUsos(usos);

                                    int b;
                                    do {
                                        System.out.println("Tipo de actividad a realizar: \n"
                                                + "1.-Libre\n"
                                                + "2.-Grupo\n"
                                                + "3.-Reserva espacio\n\n"
                                                + "0.-No añadir más tipos de actividades\n");
                                        b = ControlData.leerInt(input);

                                        switch (b) {
                                            case 1:
                                                int c;
                                                do {
                                                    System.out.println("Actividad: \n"
                                                            + "1.-Aparatos\n"
                                                            + "2.-Jacuzzi\n"
                                                            + "3.-Piscina\n\n"
                                                            + "0.-No añadir más actividades\n");
                                                    c = ControlData.leerInt(input);

                                                    switch (c) {
                                                        case 1:
                                                            System.out.println("FECHA ");
                                                            System.out.println("Día:");
                                                            int day = ControlData.leerDia(input);
                                                            System.out.println("Mes(número):");
                                                            int month = ControlData.leerInt(input);
                                                            System.out.println("Año:");
                                                            int year = ControlData.leerInt(input);
                                                            year = year - 1900;
                                                            Date fecha = new Date(year, month, day);
                                                            System.out.println("Hora inicio: ");
                                                            System.out.println("Hora fin: ");
                                                            break;
                                                        case 2:
                                                            break;
                                                        case 3:
                                                            break;
                                                        case 0:
                                                            break;
                                                        default:
                                                            System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                                            break;
                                                    }

                                                } while (c != 0);

                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 0:
                                                break;
                                        }
                                    } while (b != 0);
                                }
                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                                break;
                        }

                    } while (a != 0);

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("El número introducido no se corresponde con ninguna de las opciones.");
                    break;

            }

        } while (opcion != 0);

        input.close();

    }

    public static void printMenuInicio() {

        System.out.println("------------------------------------------------------\n"
                + "                        SPA RELAX S.L.                           \n\n"
                + "Introduzaca el número de una de las siguientes opciones:\n"
                + "1.-Alta de varios socios con actividades distintas\n"
                + "2.-Cambio de una actidad de un socio\n"
                + "3.-Cálculo de la cuantía anual de pago de socio\n\n"
                + "0.-Salir\n");
    }

}
