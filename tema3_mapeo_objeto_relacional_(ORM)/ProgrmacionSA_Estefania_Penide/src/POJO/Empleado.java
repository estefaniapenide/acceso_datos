/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Estefania
 */
public abstract class Empleado {

    private String dni;
    private String nombre;
    private String telefono;
    private float porcentajeRetencion;

    public Empleado() {

    }

    public Empleado(String dni, String nombre, String telefono, float porcentajeRetencion) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.porcentajeRetencion = porcentajeRetencion;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the porcentajeRetencion
     */
    public float getPorcentajeRetencion() {
        return porcentajeRetencion;
    }

    /**
     * @param porcentajeRetencion the porcentajeRetencion to set
     */
    public void setPorcentajeRetencion(float porcentajeRetencion) {
        this.porcentajeRetencion = porcentajeRetencion;
    }

    public void calcularNomina() {}

}
