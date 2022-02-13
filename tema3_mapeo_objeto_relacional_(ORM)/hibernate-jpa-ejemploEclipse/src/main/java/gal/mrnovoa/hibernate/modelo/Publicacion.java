package gal.mrnovoa.hibernate.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICACION")
public class Publicacion {
	@Id
	@Column(name="PUBLICACION_ID")
	private Long id;
	
	@Column (name= "TITULO")
	private String titulo;
	
	@OneToMany(mappedBy = "publicacion",cascade=CascadeType.ALL,orphanRemoval=true)
	//orphanRemoval- en eliminación.indica que no puede existir un comentario que no pertenezca a una publicación
	//el cascade actúa en la publicación, no en el comentario que quedaría colgando.
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
	
	@ManyToOne
	@JoinColumn//es una FK foreignKey
	private Usuario autor;

	public Publicacion() {
		super();
	}

	public Publicacion(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void insertarComentario(Comentario c1) {
		if(!comentarios.contains(c1)) {
			comentarios.add(c1);
			c1.setPublicacion(this);
		}
	}
	
	//orrado - desasignar a cada comentario l publicacion
	public void eliminarComentario(Comentario c1) {
		if (comentarios.contains(c1)) {
			comentarios.remove(c1);
			c1.setPublicacion(null);
		}
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Publicacion [id=" + id + ", titulo=" + titulo + "]";
	}
	
	
	
	
}
