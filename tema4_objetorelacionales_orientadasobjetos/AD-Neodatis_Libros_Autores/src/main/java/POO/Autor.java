/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.util.ArrayList;

/**
 *
 * @author a20estefaniapc
 */
public class Autor {

    private String dni;
    private String nombre;
    private String direccion;
    private int edad;
    private String nacionalidad;
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public Autor() {
    }

    public Autor(String dni, String nombre, String direccion, int edad, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the libros
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        String autor = "\tAUTOR\n"
                + "DNI: " + dni + "\n"
                + "NOMBRE: " + nombre + "\n"
                + "DIRECCIÓN: " + direccion + "\n"
                + "EDAD: " + edad + "\n"
                + "NACIONALIDAD: " + nacionalidad + "\n";
        return autor;
    }
}
