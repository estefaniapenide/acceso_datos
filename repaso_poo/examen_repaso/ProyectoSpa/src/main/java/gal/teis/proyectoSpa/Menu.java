/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectoSpa;

import POJO.Spa;
import POJO.Socios;
import POJO.Usos;
import POJO.Actividades;
import POJO.SociosRamdom;
import controltipos.ControlData;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;
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
        ArrayList<SociosRamdom> clientesCasuales = new ArrayList<SociosRamdom>();

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

            System.out.println(menuInicio());

            opcion = ControlData.leerInt(input);

            switch (opcion) {
                case 1:
                    int a;
                    do {

                        System.out.println(menuSocio());

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
                                        System.out.println("\n" + nuevoSocio + " ya es miembro.\n" + socios.get(i));
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
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                                break;
                        }

                    } while (a != 0);

                    break;
                case 2:
                    int b;
                    do {

                        System.out.println(menuSocioNoSocio());
                        b = ControlData.leerInt(input);

                        switch (b) {
                            case 1:
                                System.out.println("\nIntroduce nombre y apellidos del socio: ");
                                String socio = ControlData.leerString(input);

                                boolean socioYaRegistrado = false;
                                for (int i = 0; i < socios.size(); i++) {
                                    if (socio.equals(socios.get(i).getNombre())) {
                                        socioYaRegistrado = true;

                                        ArrayList<Usos> usos = new ArrayList<Usos>();
                                        socios.get(i).setUsos(usos);

                                        int c;
                                        do {
                                            System.out.println(menuActividad());
                                            c = ControlData.leerInt(input);
                                            boolean actividadRepetida = false;

                                            switch (c) {
                                                case 1:
                                                    for (int d = 0; d < usos.size(); d++) {
                                                        if (actividades.get(0).getTipo().equals(usos.get(d).getActividad())) {
                                                            actividadRepetida = true;
                                                            System.out.println("\n" + socios.get(i).getNombre() + " ya tiene registrada una actividad tipo " + actividades.get(0).getTipo() + "\nEscoja otro tipo de actividad.");
                                                        }
                                                    }
                                                    if (!actividadRepetida) {
                                                        System.out.println(menuActividadLibre());
                                                        int lib = ControlData.leerInt(input);
                                                        switch (lib) {
                                                            case 1:
                                                                //recogidaFechaHora();

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
                                                                int horaI = ControlData.leerInt(input);
                                                                Time horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                int horaF = ControlData.leerInt(input);
                                                                Time horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(0).getTipo(), actividades.get(0).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("FECHA ");
                                                                System.out.println("Día:");
                                                                day = ControlData.leerDia(input);
                                                                System.out.println("Mes(número):");
                                                                month = ControlData.leerInt(input);
                                                                System.out.println("Año:");
                                                                year = ControlData.leerInt(input);
                                                                year = year - 1900;
                                                                fecha = new Date(year, month, day);
                                                                System.out.println("Hora inicio: ");
                                                                horaI = ControlData.leerInt(input);
                                                                horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                horaF = ControlData.leerInt(input);
                                                                horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(0).getTipo(), actividades.get(0).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.println("FECHA ");
                                                                System.out.println("Día:");
                                                                day = ControlData.leerDia(input);
                                                                System.out.println("Mes(número):");
                                                                month = ControlData.leerInt(input);
                                                                System.out.println("Año:");
                                                                year = ControlData.leerInt(input);
                                                                year = year - 1900;
                                                                fecha = new Date(year, month, day);
                                                                System.out.println("Hora inicio: ");
                                                                horaI = ControlData.leerInt(input);
                                                                horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                horaF = ControlData.leerInt(input);
                                                                horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(0).getTipo(), actividades.get(0).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            default:
                                                                System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    for (int d = 0; d < usos.size(); d++) {
                                                        if (actividades.get(1).getTipo().equals(usos.get(d).getActividad())) {
                                                            actividadRepetida = true;
                                                            System.out.println("\n" + socios.get(i).getNombre() + " ya tiene registrada una actividad tipo " + actividades.get(1).getTipo() + "\nEscoja otro tipo de actividad.");
                                                        }
                                                    }
                                                    if (!actividadRepetida) {
                                                        System.out.println(menuActividadLibre());
                                                        int grp = ControlData.leerInt(input);
                                                        switch (grp) {
                                                            case 1:
                                                                //recogidaFechaHora();

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
                                                                int horaI = ControlData.leerInt(input);
                                                                Time horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                int horaF = ControlData.leerInt(input);
                                                                Time horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(1).getTipo(), actividades.get(1).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("FECHA ");
                                                                System.out.println("Día:");
                                                                day = ControlData.leerDia(input);
                                                                System.out.println("Mes(número):");
                                                                month = ControlData.leerInt(input);
                                                                System.out.println("Año:");
                                                                year = ControlData.leerInt(input);
                                                                year = year - 1900;
                                                                fecha = new Date(year, month, day);
                                                                System.out.println("Hora inicio: ");
                                                                horaI = ControlData.leerInt(input);
                                                                horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                horaF = ControlData.leerInt(input);
                                                                horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(1).getTipo(), actividades.get(1).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            default:
                                                                System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    for (int d = 0; d < usos.size(); d++) {
                                                        if (actividades.get(2).getTipo().equals(usos.get(d).getActividad())) {
                                                            actividadRepetida = true;
                                                            System.out.println("\n" + socios.get(i).getNombre() + " ya tiene registrada una actividad tipo " + actividades.get(2).getTipo() + "\nEscoja otro tipo de actividad.");
                                                        }
                                                    }
                                                    if (!actividadRepetida) {
                                                        System.out.println(menuActividadGrupo());
                                                        int esp = ControlData.leerInt(input);
                                                        switch (esp) {
                                                            case 1:
                                                                //recogidaFechaHora();

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
                                                                int horaI = ControlData.leerInt(input);
                                                                Time horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                int horaF = ControlData.leerInt(input);
                                                                Time horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(2).getTipo(), actividades.get(2).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.println("FECHA ");
                                                                System.out.println("Día:");
                                                                day = ControlData.leerDia(input);
                                                                System.out.println("Mes(número):");
                                                                month = ControlData.leerInt(input);
                                                                System.out.println("Año:");
                                                                year = ControlData.leerInt(input);
                                                                year = year - 1900;
                                                                fecha = new Date(year, month, day);
                                                                System.out.println("Hora inicio: ");
                                                                horaI = ControlData.leerInt(input);
                                                                horaIn = new Time(horaI, 0, 0);
                                                                System.out.println("Hora fin: ");
                                                                horaF = ControlData.leerInt(input);
                                                                horaFi = new Time(horaF, 0, 0);

                                                                usos.add(new Usos(actividades.get(2).getTipo(), actividades.get(2).getCuota(), fecha, horaIn, horaFi));
                                                                System.out.println("\n" + socios.get(i));
                                                                for (int e = 0; e < usos.size(); e++) {
                                                                    System.out.println(socios.get(i).getUsos().get(e));
                                                                }
                                                                break;
                                                            default:
                                                                System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case 0:
                                                    System.out.println("Volviendo al menú principal...");
                                                    break;
                                                default:
                                                    System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                                                    break;

                                            }
                                        } while (c != 0);
                                    }
                                }
                                if (!socioYaRegistrado) {
                                    System.out.println("\n" + socio + " no es miembro. Debe ser dado de alta como socio o registrado como cliente casual.");
                                }
                                break;
                            case 2:
                                System.out.println("\nIntroduce nombre y apellidos del cliente: ");
                                String cliente = ControlData.leerString(input);

                                boolean clienteYaRegistrado = false;
                                for (int i = 0; i < socios.size(); i++) {
                                    if (cliente.equals(socios.get(i).getNombre())) {
                                        clienteYaRegistrado = true;
                                        System.out.println("\n" + cliente + " es un socio registrado.\nPara añadir una actividad debe selecccionar como 'Socio' en 'Tipo de cliente'");
                                    }
                                }
                                if (!clienteYaRegistrado) {
                                    //Crear socioRamdom con ese nombre y añadirlo al arrayList clientesCasuales
                                }
                                break;
                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                                break;
                        }

                    } while (b != 0);
                    break;
                case 3:
                    System.out.println("\nIntroduce código de socio: ");
                    int socio = ControlData.leerInt(input);
                    String soc = Integer.toString(socio);
                    float importeTotal = 0;
                    boolean socioYaRegistrado = false;
                    for (int i = 0; i < socios.size(); i++) {
                        if (soc.equals(socios.get(i).getCodigo())) {
                            socioYaRegistrado = true;
                            System.out.println(socios.get(i));
                            if (Objects.isNull(socios.get(i).getUsos())) {
                                importeTotal = importeTotal + socios.get(i).getCuotaFija();
                                System.out.println("Actividades registradas: 0");
                                System.out.println("Importe total(€): " + importeTotal);
                            } else {
                                for (int f = 0; f < socios.get(i).getUsos().size(); f++) {
                                    importeTotal = importeTotal + socios.get(i).getUsos().get(f).calcularImporte();
                                }
                                importeTotal = importeTotal + socios.get(i).getCuotaFija();
                                System.out.println(socios.get(i).getUsos());
                                System.out.println("Importe total(€): " + importeTotal);
                            }
                        }
                    }
                    if (!socioYaRegistrado) {
                        System.out.println("El código " + socio + " no se corresponde con ningún socio registrado.");
                    }
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("\nEl número introducido no se corresponde con ninguna de las opciones.");
                    break;

            }

        } while (opcion != 0);

        input.close();

    }

    public static String menuInicio() {

        String menuInicio = "------------------------------------------------------\n"
                + "                        SPA RELAX S.L.                           \n\n"
                + "Introduzaca el número de una de las siguientes opciones:\n"
                + "1.-Alta de socios\n"
                + "2.-Alta de usos\n"
                + "3.-Consultas\n"
                + "4.-Baja de socios\n\n"
                + "0.-Salir\n";

        return menuInicio;
    }

    public static String menuSocio() {

        String menuSocio = "\n            ALTA SOCIO             \n"
                + "1.-Nuevo socio\n\n"
                + "0.-Volver al menú principal\n";

        return menuSocio;
    }

    public static String menuSocioNoSocio() {

        String menuSocioNoSocio = "\nTipo de cliente: \n"
                + "1.-Socio\n"
                + "2.-Cliente casual\n\n"
                + "0.-Volver al menú principal\n";

        return menuSocioNoSocio;
    }

    public static String menuActividad() {

        String menuActividad = "\nTipo de actividad a realizar: \n"
                + "1.-Libre\n"
                + "2.-Grupo\n"
                + "3.-Reservar espacio\n\n"
                + "0.-No añadir más tipos de actividades\n";

        return menuActividad;
    }

    public static String menuActividadLibre() {

        String menuActividadLibre = "\nActividad libre: \n"
                + "1.-Aparatos\n"
                + "2.-Jacuzzi\n"
                + "3.-Piscina\n";

        return menuActividadLibre;
    }

    public static String menuActividadGrupo() {

        String menuActividadGrupo = "\nActividad en grupo: \n"
                + "1.-Yoga\n"
                + "2.-Pilates\n";

        return menuActividadGrupo;
    }

    public static String menuActividadReservaEspacio() {

        String menuActividadReservaEspacio = "\nAlquiler de un espacio: \n"
                + "1.-Pista de tenis\n"
                + "2.-Pista de pádel\n";

        return menuActividadReservaEspacio;
    }

//    public static void recogidaFechaHora() {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("FECHA ");
//        System.out.println("Día:");
//        int day = ControlData.leerDia(input);
//        System.out.println("Mes(número):");
//        int month = ControlData.leerInt(input);
//        System.out.println("Año:");
//        int year = ControlData.leerInt(input);
//        year = year - 1900;
//        Date fecha = new Date(year, month, day);
//        System.out.println("Hora inicio: ");
//        int horaI = ControlData.leerInt(input);
//        Time horaIn = new Time(horaI, 0, 0);
//        System.out.println("Hora fin: ");
//        int horaF = ControlData.leerInt(input);
//        Time horaFi = new Time(horaF, 0, 0);
//
//        input.close();
//
//    }

}
