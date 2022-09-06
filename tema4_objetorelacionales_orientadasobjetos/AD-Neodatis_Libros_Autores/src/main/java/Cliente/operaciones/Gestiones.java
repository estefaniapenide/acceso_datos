/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente.operaciones;

import java.util.Scanner;
import Cadenas.Cadenas;
import POO.Autor;
import POO.Libro;
import Cliente.controldata.ControlData;
import java.sql.Date;

/**
 *
 * @author Estefania
 */
public class Gestiones {

    //Menu 1
    private static boolean autorYaGuardado = false;

    public static void altaAutorLibros(Scanner input) {

        Cadenas.m1AltaAutorLibros();

        Autor autor = null;

        autor = nuevoAutor(input);

        if (!autorYaGuardado) {
            addLibros(input, autor);
            if (!autorYaGuardado) {
                Crud.storeAutor(autor);
            }
            Cadenas.autorLibrosGuardados();
        }
    }

    private static Autor nuevoAutor(Scanner input) {

        Autor autor = null;
        autorYaGuardado = false;

        Cadenas.datosAutor();
        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        autor = Crud.buscarAutorPorDni(dni);

        if (autor != null) {
            Cadenas.elAutorDniYaDadoAlta(dni);
            Crud.imprimirAutorPorDni(dni);
            autorYaGuardado = true;
        } else {
            Cadenas.nombre();
            String nombre = ControlData.leerString(input).toUpperCase();

            Cadenas.direccion();
            String direccion = ControlData.leerString(input).toUpperCase();

            Cadenas.edad();
            int edad = ControlData.leerInt(input);

            Cadenas.nacionalidad();
            String nacionalidad = ControlData.leerString(input).toUpperCase();

            autor = new Autor(dni, nombre, direccion, edad, nacionalidad);
            autorYaGuardado = false;
        }
        return autor;

    }

    private static void addLibros(Scanner input, Autor autor) {

        byte op = 2;
        do {
            Cadenas.addLibros();
            op = ControlData.leerByte(input);
            switch (op) {
                case 1:
                    nuevoLibro(input, autor);
                    break;
                case 2:
                    break;
                default:
                    Cadenas.defaultmensaje();
                    break;
            }
        } while (op != 2);

    }

    private static void nuevoLibro(Scanner input, Autor autor) {

        Libro libro = null;

        Cadenas.datosLibro();
        Cadenas.codigo();
        int cod = ControlData.leerInt(input);

        libro = Crud.buscarLibroPorCodigo(cod);

        if (libro != null) {
            Cadenas.elLibroCodYaDadoAlta(cod);
            Crud.imprimirLibroPorCodigo(cod);
        } else {
            Cadenas.titulo();
            String titulo = ControlData.leerString(input).toUpperCase();

            Cadenas.categoria();
            String categoria = ControlData.leerString(input).toUpperCase();

            Cadenas.precio();
            float precio = ControlData.leerFloat(input);

            Cadenas.fechaPublicacion();
            String fecha = ControlData.leerFecha(input);
            Date date = Date.valueOf(fecha);

            libro = new Libro(cod, titulo, categoria, precio, date);

            if (autorYaGuardado) {
                Crud.addLibroAAutor(autor, libro);
            } else {
                autor.getLibros().add(libro);
                Crud.storeAutor(autor);
                autorYaGuardado = true;
            }

            Cadenas.libroregistrado();
        }

    }

    //Menu 2
    public static void addLibroAAutor(Scanner input) {

        Cadenas.m2AddLibroAutor();

        Cadenas.datosAutor();
        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        Autor autor = Crud.buscarAutorPorDni(dni);

        if (autor != null) {
            Crud.imprimirAutorPorDni(dni);

            Cadenas.datosLibro();
            Cadenas.codigo();
            int cod = ControlData.leerInt(input);

            Libro libro = Crud.buscarLibroPorCodigo(cod);

            if (libro == null) {
                Cadenas.titulo();
                String titulo = ControlData.leerString(input).toUpperCase();

                Cadenas.categoria();
                String categoria = ControlData.leerString(input).toUpperCase();

                Cadenas.precio();
                float precio = ControlData.leerFloat(input);

                Cadenas.fechaPublicacion();
                String fecha = ControlData.leerFecha(input);
                Date date = Date.valueOf(fecha);

                libro = new Libro(cod, titulo, categoria, precio, date);

                Crud.addLibroAAutor(autor, libro);

                Cadenas.libroregistrado();

            } else {
                Cadenas.elLibroCodYaExiste(cod);
                Crud.imprimirLibroPorCodigo(cod);
            }
        } else {
            Cadenas.elAutorDniNoExiste(dni);
        }
    }

    //Menú 3
    public static void modificarDireccionAutor(Scanner input) {

        Cadenas.m3ModificarDireccionAutor();

        Cadenas.datosAutor();
        Cadenas.dni();
        String dni = ControlData.leerDni(input);

        Autor autor = Crud.buscarAutorPorDni(dni);

        if (autor != null) {

            Crud.imprimirAutorPorDni(dni);

            Cadenas.nuevaDireccion();
            String nuevaDireccion = ControlData.leerString(input).toUpperCase();

            Crud.modificarDireccionAutor(nuevaDireccion, autor);

            Cadenas.direccionModificada();
            Crud.imprimirAutorPorDni(dni);

        } else {
            Cadenas.elAutorDniNoExiste(dni);
        }
    }

    //Menú 4 
    public static void modificarPrecioLibroDadoAutorYTitulo(Scanner input) {

        Cadenas.m4ModificarPrecioLibro();

        Cadenas.datosAutor();
        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Autor autor = Crud.buscarAutorPorNombre(nombre);

        if (autor != null) {

            Cadenas.librosDe(nombre);
            Crud.mostrarLibrosDeAutor(autor);

            Cadenas.datosLibro();
            Cadenas.titulo();
            String titulo = ControlData.leerString(input).toUpperCase();

            Libro libro = Crud.buscarLibroPorTitulo(titulo);

            if (libro != null) {

                if (Crud.libroPerteneceAAutor(autor, libro)) {

                    Crud.imprimirLibroPorCodigo(libro.getCod());

                    Cadenas.nuevoPrecio();
                    float nuevoPrecio = ControlData.leerFloat(input);

                    Crud.modificarPrecioLibroDadoNombreAutorYTituloLibro(nuevoPrecio, nombre, titulo);
                    
                    Cadenas.librosDe(nombre);
                    Crud.mostrarLibrosDeAutor(autor);

                } else {
                    Cadenas.elLibroNoPerteneceAAutor(titulo, nombre);
                }
            } else {
                Cadenas.elLibroNoExiste(titulo);
            }
        } else {
            Cadenas.elAutorNoExiste(nombre);
        }

    }

    //Menú 5
    public static void borradoLibrosAutorCodigoLibro(Scanner input) {

        Cadenas.m5BorrarLibro();

        Cadenas.datosAutor();
        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Autor autor = Crud.buscarAutorPorNombre(nombre);

        if (autor != null) {

            Cadenas.librosDe(nombre);
            Crud.mostrarLibrosDeAutorConCodigo(autor);

            Cadenas.datosLibro();
            Cadenas.codigo();
            int cod = ControlData.leerInt(input);

            Libro libro = Crud.buscarLibroPorCodigo(cod);

            if (libro != null) {

                if (Crud.libroPerteneceAAutor(autor, libro)) {

                    Crud.imprimirLibroPorCodigo(cod);

                    byte op = 2;
                    do {
                        Cadenas.confirmarBorradoLibro();
                        op = ControlData.leerByte(input);
                        switch (op) {
                            case 1:
                                Crud.borrarLibro(libro, autor);
                                Cadenas.libroBorrado();
                                break;
                            case 2:
                                Cadenas.libroNoBorrado();
                                break;
                            default:
                                Cadenas.defaultmensaje();
                                break;
                        }
                    } while (op != 1 && op != 2);
                } else {
                    Cadenas.elLibroCodNoPerteneceAAutor(cod, nombre);
                }
            } else {
                Cadenas.elLibroCodNoExiste(cod);
            }
        } else {
            Cadenas.elAutorNoExiste(nombre);
        }
    }

    //Menú 6
    public static void autoresNacionalidadItaliana(Scanner input) {

        Cadenas.m6AutoresNacionalidadItalina();

        Crud.autoresNacionalidadDeterminada("ITALIANA");
    }

    //Menú 7
    public static void librosAutorEntreDosFechas(Scanner input) {

        Cadenas.m7LibrosAutorEntreDosFechas();

        Cadenas.datosAutor();
        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Autor autor = Crud.buscarAutorPorNombre(nombre);

        if (autor != null) {
            Cadenas.fechaInicio();
            String fechaInicio = ControlData.leerFecha(input);
            Date dateInicio = Date.valueOf(fechaInicio);

            Cadenas.fechaFin();
            String fechaFin = ControlData.leerFecha(input);
            Date dateFin = Date.valueOf(fechaFin);

            if (dateInicio.before(dateFin)) {
                Cadenas.librosDeEntreFechas(nombre, fechaInicio, fechaFin);
                Crud.librosAutorEntreDosFechas(autor, dateInicio, dateFin);

            } else {
                Cadenas.laFechaDeInicioDeberSerAnteriorAFin();
            }
        } else {
            Cadenas.elAutorNoExiste(nombre);
        }

    }

    //Menú 8
    public static void autoresNacionalidadEspanolaMenoresDe60(Scanner input) {

        Cadenas.m8AutoresEspanolesMenores60();

        Crud.autoresNacionalidadDeterminadaMenoresDeCiertaEdad("ESPAÑOLA", 60);
    }

    //Menú 9
    public static void numeroAutoresPorNacionalidad(Scanner input) {

        Cadenas.m9NumeroAutoresNacionalidad();

        Crud.numeroAutoresPorNacionalidad();
    }

    //Menú 10
    public static void mostrarLibrosAutor(Scanner input) {

        Cadenas.m10LibrosAutor();

        Cadenas.datosAutor();
        Cadenas.nombre();
        String nombre = ControlData.leerString(input).toUpperCase();

        Autor autor = Crud.buscarAutorPorNombre(nombre);

        if (autor != null) {

            Cadenas.librosDe(nombre);
            Crud.mostrarLibrosDeAutor(autor);

        } else {
            Cadenas.elAutorNoExiste(nombre);
        }
    }

    //Menú 11
    public static void dadoLibroBsucarAutorYOtrosDatosLibro(Scanner input) {

        Cadenas.m11TituloLibroDatosLibroYAutor();

        Cadenas.datosLibro();
        Cadenas.titulo();
        String titulo = ControlData.leerString(input).toUpperCase();

        Libro libro = Crud.buscarLibroPorTitulo(titulo);

        if (libro != null) {
            System.out.println(libro);
            Crud.imprimirAutorDadoLibro(libro);

        } else {
            Cadenas.elLibroNoExiste(titulo);
        }

    }

}
