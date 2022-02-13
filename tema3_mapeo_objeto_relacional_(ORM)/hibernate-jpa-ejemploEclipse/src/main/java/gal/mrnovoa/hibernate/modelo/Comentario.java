package gal.mrnovoa.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMENTARIO")
public class Comentario {
	
	@Id
	@Column(name="COMENTARIO_ID")
	private Long id;
	
	@Column(name="MENSAJE")
	private String mensaje;

		
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn //no tiene sentido si se quiere permitir comentarios descolgados-violacion 1FN
				//más coherente usar JoinTable
	@JoinColumn(name = "PUBLICACION_ID")//Nexo de unión entre las 2 Entities
	private Publicacion publicacion;
	
	

	public Comentario() {
		super();
	}

	public Comentario(Long id, String mensaje) {
		this.id = id;
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", mensaje=" + mensaje + ", publicacion=" + publicacion + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	

}
