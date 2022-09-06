/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cadenas;

/**
 *
 * @author Estefania
 */
public class Cadenas {

    //MENÚS
    public static void menu() {
        System.out.println("------------------------------------------------------------------------------------------------------------\n"
                + "\t\tMENÚ LIBRERÍA\n\n"
                + "1.- Altas de autor con todos sus libros.\n"
                + "2.- Añadir un libro nuevo a un autor ya existente.\n"
                + "3.- Modificación de la dirección de un autor determinado, recibiendo su dni.\n"
                + "4.- Modificación del precio de un libro determinado, recibiendo el título y el nombre del autor.\n"
                + "5.- Borrado de libros, introduciendo el nombre de un autor y el código del libro.\n"
                + "6.- Consulta de todos los autores cuya nacionalidad sea ITALIANA.\n"
                + "7.- Consulta de los libros escritos por un autor determinado entre dos fechas.\n"
                + "8.- Visualiza todos los autores cuya nacionalidad sea ESPAÑOLA y su edad sea < 60 años.\n"
                + "9.- Visualiza por cada nación el número de autores.\n"
                + "10.- Introduciendo el nombre de un autor, se visualizan todos sus libros.\n"
                + "11.- Consultas.'Introduciendo el título de un libro visualice los datos del libro y autor'.\n\n"
                + "12.- FIN\n"
                + "-------------------------------------------------------------------------------------------------------------");
    }

    public static void addLibros() {
        System.out.println("\nAÑADIR LIBRO\n"
                + "1.-SI\n"
                + "2.-NO");
    }

    public static void confirmarBorradoLibro() {
        System.out.println("CONFIRMAR BORRADO LIBRO:\n"
                + "1.-SI\n"
                + "2.-NO\n");
    }

    //TÍTULOS
    public static void m1AltaAutorLibros() {
        System.out.println("\tALTA DE AUTOR CON TODOS SUS LIBROS");
    }

    public static void m2AddLibroAutor() {
        System.out.println("\tAÑADIR LIBRO A AUTOR YA EXISTENTE");
    }

    public static void m3ModificarDireccionAutor() {
        System.out.println("\tMODIFICAR LA DIRECCIÓN DE UN AUTOR");
    }

    public static void m4ModificarPrecioLibro() {
        System.out.println("\tMODIFICAR EL PRECIO DE UN LIBRO DADO SU TÍTULO Y SU AUTOR");
    }

    public static void m5BorrarLibro() {
        System.out.println("\tBORRADO DE LIBROS DADO EL NOMBRE AUTOR Y EL CÓDIGO DEL LIBRO");
    }

    public static void m6AutoresNacionalidadItalina() {
        System.out.println("\tAUTORES DE NACIONALIDAD ITALIANA");
    }

    public static void m7LibrosAutorEntreDosFechas() {
        System.out.println("\tLIBROS DE UN AUTOR ENTRE DOS FECHAS");
    }

    public static void m8AutoresEspanolesMenores60() {
        System.out.println("\tAUTORES DE NACIONALIDAD ESPAÑOLA MENORES DE 60 AÑOS");
    }

    public static void m9NumeroAutoresNacionalidad() {
        System.out.println("\tNÚMERO DE AUTORES POR NACIONALIDAD");
    }

    public static void m10LibrosAutor() {
        System.out.println("\tLIBROS DE UN AUTOR DETERMINADO");
    }

    public static void m11TituloLibroDatosLibroYAutor() {
        System.out.println("\tINTRODUCINEDO EL TÍTULO DE UN LIBRO OBTENER LOS DATOS DEL LIBRO Y SU AUTOR");
    }

    //DATOS AUTOR
    public static void datosAutor() {
        System.out.println("\nDATOS DEL AUTOR");
    }

    public static void dni() {
        System.out.println("DNI:");
    }

    public static void nombre() {
        System.out.println("NOMBRE:");
    }

    public static void direccion() {
        System.out.println("DIRECCIÓN:");
    }

    public static void nuevaDireccion() {
        System.out.println("NUEVA DIRECCIÓN:");
    }

    public static void edad() {
        System.out.println("EDAD:");
    }

    public static void nacionalidad() {
        System.out.println("NACIONALIDAD:");
    }

    //DATOS LIBRO
    public static void datosLibro() {
        System.out.println("\nDATOS DEL LIBRO");
    }

    public static void codigo() {
        System.out.println("CÓDIGO:");
    }

    public static void titulo() {
        System.out.println("TITULO:");
    }

    public static void categoria() {
        System.out.println("CATEGORÍA:");
    }

    public static void precio() {
        System.out.println("PRECIO:");
    }

    public static void nuevoPrecio() {
        System.out.println("NUEVO PRECIO:");
    }

    public static void fechaPublicacion() {
        System.out.println("FECHA DE PUBLICACIÓN(aaaa-mm-dd):");
    }

    //OTROS MENSAJES
    public static void defaultmensaje() {
        System.out.println("NO HA INTRODUCIDO NINGUNA DE LAS OPCIONES\n");
    }

    public static void fin() {
        System.out.println("\nPROGRAMA FINALIZADO");
    }

    public static void inicioServidor() {
        System.out.println("SERVIDOR INICIADO...");
    }

    public static void conexionServidor() {
        System.out.println("\nCONEXIÓN CON SERVIDOR ESTABLECIDA");
    }

    public static void errorConexionServidor() {
        System.out.println("\nNO SE HA CONECTADO A NINGÚN SERVIDOR.\nINICIE EL SERVIDOR PARA PODER CONECTARSE.");
    }

    public static void libroregistrado() {
        System.out.println("\nEL LIBRO HA SIDO REGISTRADO CORRECTAMENTE");
    }

    public static void libroNoBorrado() {
        System.out.println("\nLIBRO NO BORRADO");
    }

    public static void libroBorrado() {
        System.out.println("\nLIBRO BORRADO");
    }

    public static void fechaInicio() {
        System.out.println("FECHA DE INICIO(aaaa-mm-dd):");
    }

    public static void fechaFin() {
        System.out.println("FECHA DE FIN(aaaa-mm-dd):");
    }

    public static void laFechaDeInicioDeberSerAnteriorAFin() {
        System.out.println("\nLA FECHA DE INICIO DEBE SER ANTERIOR A LA FECHA DE FIN");
    }

    public static void librosDe(String nombre) {
        System.out.println("\nLIBROS DE " + nombre);
    }

    public static void librosDeEntreFechas(String nombre, String fechaInicio, String fechaFin) {
        System.out.println("\nLIBROS DE " + nombre + " ENTRE " + fechaInicio + " Y " + fechaFin);
    }

    public static void elLibroCodYaExiste(int cod) {
        System.out.println("\nEL LIBRO CON CÓDIGO " + cod + " YA EXISTE");
    }

    public static void elLibroCodNoExiste(int cod) {
        System.out.println("\nEL LIBRO CON CÓDIGO " + cod + " NO EXISTE");
    }

    public static void elLibroNoExiste(String titulo) {
        System.out.println("\nEL LIBRO " + titulo + " NO EXISTE");
    }

    public static void elLibroCodNoPerteneceAAutor(int cod, String nombre) {
        System.out.println("\nEL LIBRO CON CÓDIGO" + cod + " NO PERTENECE AL AUTOR " + nombre);
    }

    public static void elLibroNoPerteneceAAutor(String titulo, String nombre) {
        System.out.println("\nEL LIBRO " + titulo + " NO PERTENECE AL AUTOR " + nombre);
    }

    public static void elLibroCodYaDadoAlta(int cod) {
        System.out.println("\nEL LIBRO CON CÓDIGO " + cod + " YA ESTÁ DADO DE ALTA");
    }

    public static void elAutorDniNoExiste(String dni) {
        System.out.println("\nEL AUTOR CON DNI " + dni + " NO EXISTE");
    }

    public static void elAutorNoExiste(String nombre) {
        System.out.println("\nEL AUTOR " + nombre + " NO EXISTE");
    }

    public static void elAutorDniYaDadoAlta(String dni) {
        System.out.println("\nEL AUTOR CON DNI " + dni + " YA ESTÁ DADO DE ALTA");
    }

    public static void direccionModificada() {
        System.out.println("\nLA DIRECCIÓN HA SIDO MODIFICADA");
    }

    public static void autorLibrosGuardados() {
        System.out.println("\nAUTOR Y LIBROS GUARDADOS");
    }
}
