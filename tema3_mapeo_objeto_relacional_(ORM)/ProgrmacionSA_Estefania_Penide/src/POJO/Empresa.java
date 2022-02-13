/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.util.Set;

/**
 *
 * @author Estefania
 */
public class Empresa {
    
    private String cif;
    private String nombre;
    private String direccion;
    private String telefono;
    private Set<Producto> productos;
    private Set<Empleado> empleados;
    
    public Empresa(){
    
    }
    
    public Empresa(String cif, String nombre, String direccion, String telefono){
        this.cif=cif;
        this.nombre=nombre;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
     * @return the productos
     */
    public Set<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    /**
     * @return the empleados
     */
    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }
}
