/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.sql.Date;
import java.util.Set;

/**
 *
 * @author Estefania
 */
public class Temporal extends Empleado {

    private Date fechaInicio;
    private Date fechaFin;
    private float pagoDia;
    
    private float sueldo;
    
    private Set<Venta> ventas;

    public Temporal() {
        super();
    }

    public Temporal(String dni, String nombre, String telefono, float porcentajeRetencion, Date fechaInicio, Date fechaFin, float pagoDia) {
        super(dni, nombre, telefono, porcentajeRetencion);
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pagoDia = pagoDia;

    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /**
     * @return the pagoDia
     */
    public float getPagoDia() {
        return pagoDia;
    }

    /**
     * @param pagoDia the pagoDia to set
     */
    public void setPagoDia(float pagoDia) {
        this.pagoDia = pagoDia;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * @return the ventas
     */
    public Set<Venta> getVentas() {
        return ventas;
    }

    /**
     * @param ventas the ventas to set
     */
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
    
    @Override
    public void calcularNomina(){
    sueldo =pagoDia*(fechaFin-fechaInicio)-pagoDia*(fechaFin-fechaInicio)*getPorcentajeRetencion()+suplemento;
    }

}
