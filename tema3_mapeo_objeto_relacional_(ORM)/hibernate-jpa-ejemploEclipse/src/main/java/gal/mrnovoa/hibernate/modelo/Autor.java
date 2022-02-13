package gal.mrnovoa.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AUTOR")
public class Autor {

	@Id
	@Column(name="AUTOR_ID")
	private Long id;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="NACIONALIDAD")
	private String nacionalidad;
	
	//1Autor - NLibros
	//@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)//mappedBy - Nombre del campoUnion en la otra Entity
															  //cascadeType.ALL - pej. para que se guarden los libros automáticamente cuando se crea el autor
															 //fetch - no será necesario, ya que por defecto en JPA es Lazy en @OneToOne y @OneToMany
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch=FetchType.EAGER)//OJO.No recomendable...para solucionar que el lazy no cargue datos necesarios
	
	private List<Libro> libros = new ArrayList<Libro>();
	
	public Autor() {}
	
	public Autor(Long id, String nombre, String nacionalidad) {
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	/*public List<Libro> setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	*/
	
	
	
	public List<Libro> getLibros() {
		return libros;
	}
	
	//Solución1 a asignar a cada libro su autor
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
		
		for(Libro l:libros) {
			l.setAutor(this);
		}
	}
	
	//Solución2 a asignar a cada libro su autor
	public void addLibro(Libro l) {
		if(!libros.contains(l)) {
			libros.add(l);
			l.setAutor(this);
		}
	}
	
	//Solución2 pasará lo mismo en el borrado - desasignar a cada libro su autor
	public void removeLibro(Libro libro) {
		if (libros.contains(libro)) {
			libros.remove(libro);
			libro.setAutor(null);
		}
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
