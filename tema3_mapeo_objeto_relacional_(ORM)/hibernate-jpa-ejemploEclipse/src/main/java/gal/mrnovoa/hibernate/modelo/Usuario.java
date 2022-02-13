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
@Table(name="USUARIO")
public class Usuario {

		@Id
		@Column(name="AUTOR_ID")
		private Long id;
		
		@Column(name="NOMBRE")
		private String nombre;
		
		//1Autor - NPublicacions
		//@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)//mappedBy - Nombre del campoUnion en la otra Entity
																  //cascadeType.ALL - pej. para que se guarden los Publicacions automáticamente cuando se crea el autor
																 //fetch - no será necesario, ya que por defecto en JPA es Lazy en @OneToOne y @OneToMany
		
		@OneToMany(mappedBy = "autor")//OJO.Por defecto Lazy...para solucionar que el lazy no cargue datos necesarios
		
		private List<Publicacion> publicaciones = new ArrayList<Publicacion>();//publicaciones escritas por un autor
		
		public Usuario() {}
		
		public Usuario(Long id, String nombre) {
			this.id = id;
			this.nombre = nombre;
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
		
		
		public List<Publicacion> getPublicacions() {
			return publicaciones;
		}
		
		//Solución1 a asignar a cada Publicacion su autor
		public void setPublicaciones(List<Publicacion> Publicaciones) {
			this.publicaciones = Publicaciones;
			
			for(Publicacion p:Publicaciones) {
				p.setAutor(this);
			}
		}
		
		//Solución2 a asignar a cada Publicacion su autor
		public void addPublicacion(Publicacion p) {
			if(!publicaciones.contains(p)) {
				publicaciones.add(p);
				p.setAutor(this);
			}
		}
		
		//Solución2 pasará lo mismo en el borrado - desasignar a cada Publicacion su autor
		public void removePublicacion(Publicacion Publicacion) {
			if (publicaciones.contains(Publicacion)) {
				publicaciones.remove(Publicacion);
				Publicacion.setAutor(null);
			}
		}
		
		@Override
		public String toString() {
			return "Autor [id=" + id + ", nombre=" + nombre + "]";
		}
		
}
