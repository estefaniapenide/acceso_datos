package teis.dam.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Autor")
public class Autor{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAutor", updatable = false, nullable = false)
    private int id;
    private String nombre, nacionalidad;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    
	@JoinTable(
			name = "Autor_Libro",
			joinColumns = @JoinColumn(name = "IdAutor"),
			inverseJoinColumns = @JoinColumn(name = "IdLibro")
	)
    private Set<Libro> libros = new HashSet<Libro>();

    public Autor() {//Hace falta para HQL
    }

    
    public Autor(String nombre, String nacionalidad) {
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

    public void addLibro(Libro libro) {
		this.libros.add(libro);
    }
    
    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
    
    

}
