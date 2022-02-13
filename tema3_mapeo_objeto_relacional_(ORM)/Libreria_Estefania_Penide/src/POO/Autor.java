/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author a20estefaniapc
 */
@Entity
@Table(name = "AUTORES")
public class Autor {

    @Id
    @Column(name = "DNI")
    private String dni;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NACIONALIDAD")
    private String nacionalidad;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "AUTORES_LIBROS", joinColumns = @JoinColumn(name = "DNI_AUTOR"), inverseJoinColumns = @JoinColumn(name = "ID_LIBRO"))
    private Set<Libro> libros = new HashSet<Libro>();

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Telefono telefono;

    public Autor() {
    }

    public Autor(String dni, String nombre, String nacionalidad) {
        this.dni = dni;
        this.nombre = nombre;
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
    public Set<Libro> getLibros() {
        return libros;
    }

    /**
     * @param libros the libros to set
     */
    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }

    /**
     * @return the telefono
     */
    public Telefono getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        String autor = "DNI: " + dni+"\n"
                + "NOMBRE: " + nombre+"\n"
                + "NACIONALIDAD: " + nacionalidad;
        return autor;
    }

}
