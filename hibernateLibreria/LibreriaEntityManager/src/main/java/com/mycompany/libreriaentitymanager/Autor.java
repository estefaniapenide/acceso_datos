/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreriaentitymanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Coolbay
 */

@Entity
@Table(name = "Autor")
public class Autor implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="idAutor", updatable = false, nullable = false)
    private int id;
    @Column(name="nombre", updatable = false, nullable = false)
    private String nombre;
    @Column(name="nacionalidad", updatable = false, nullable = false)
    private String nacionalidad;
    //One es la clase de arriba en este caso autor y many la otra que no es esta tu saes
    @OneToMany(mappedBy = "autor", cascade= CascadeType.ALL, orphanRemoval = true) // con mapped le vamos a decir que libros tiene que agrupar aquellos libros en los que autor sea igual a this
    // es decir en la clase libro linea 29 le llamo autor por eso es mappedby="autor" es el campo de tipo autor que está en libros basicamente
    //el cascadetype indica que si se crea un autor con libros se guarda automaticamente
    private List<Libro> libros = new ArrayList<>();
    
    public Autor() {
    }

    public Autor(int id, String nombre, String nacionalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
        //si queremos asignar un libro a un autor cuando los creamos por separado podemos hacer un metodo addlibro o lo siguiente
        //for (Libro l : libros) {
        //  l.setAutor(this);
        //}
    }
    //Si queremos hacer le metodo porque queda más mejor ponemos
    public void addlibro(Libro libro){
        if(!libros.contains(libro)) { //Si no contiene el libro que vamos añadir
            libros.add(libro); //lo añadimos
            libro.setAutor(this); //y le ponemos este autor
        }
    }
    
    public void removeLibro(Libro libro){
        if(!libros.contains(libro)) { //Si no contiene el libro que vamos añadir
            libros.remove(libro); //lo borramos
            libro.setAutor(null); //le indicamos null 
        }
    }
    
    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
}
