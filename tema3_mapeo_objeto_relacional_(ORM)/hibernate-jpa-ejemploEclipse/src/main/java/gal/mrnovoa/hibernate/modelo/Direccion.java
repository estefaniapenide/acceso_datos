package gal.mrnovoa.hibernate.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "DIRECCION")
public class Direccion {
	@Id
	@Column(name="ID_DIRECCION")
	private Long id;//Siempre para ser tratado como Entidad
	
	@Column(name="DIRECCION")
	private String direccion;
	
	@Column(name="LOCALIDAD")
	private String localidad;
	
	@Column(name="PROVINCIA")
	private String provincia;
	
	@Column(name="PAIS")
	private String pais;

	@OneToOne(mappedBy = "direccion",fetch = FetchType.LAZY)//nombre del campo en la clase Empleado
	private Empleado empleado;
	
	public Direccion() {}//Siempre para ser tratado como Entidad
	
	public Direccion(Long id, String direccion, String localidad, String provincia, String pais) {
		this.id = id;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}
	
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia="
				+ provincia + ", pais=" + pais + ", empleado=" + empleado.getCodigo()+"]";
	}

}
