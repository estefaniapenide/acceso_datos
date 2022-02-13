package gal.mrnovoa.hibernate.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//makigas:tutoriales programacion - JAVA: JPA+Hibernate

@Entity
@Table (name = "EMPLEADO")
// @NamedQueries

//4.Serializable
public class Empleado implements Serializable{
	
	@Id
	@Column(name = "COD_EMPLEADO") 
	private Long codigo;

	@Column(name = "APELLIDOS") 
	private String apellidos;
	
	@Column(name = "NOMBRE") 
	private String nombre;
	
	@Column(name = "FECHA_NACIMIENTO") 
	//private Date fechaNacimiento;
	private java.time.LocalDate fechaNacimiento;//java 8
	
	@OneToOne(cascade = {CascadeType.ALL})//para que la actualización de dirección se propague en Insert/Delete..
	@JoinColumn(name = "ID_DIRECCION")//columna en la TablaEmpleado
	private Direccion direccion;
	
	//Relaciones
	//@Many
	
	//Dependiendo de lo que tengamos q procesar->puede ser muy pesado
	//JPA->2 formas carga:
	//FORMA1 :EAGER - temprana (recuperar todos los datos a la vez desde principio)
	//FORMA2 :LAZY - perezosa (por defecto en JPA - sólo cuando se hace get)
	
	//private List<Factura> facturas;
	//private List<Cliente> clientes;

	//conversión en Bean
	//1.Constructor vacío
	public Empleado() {}
	
	public Empleado(Long codigo, String apellidos, String nombre, LocalDate fechaNacimiento) {
		this.codigo = codigo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}

	//2.
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", apellidos=" + apellidos + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + "]";
	}
}
