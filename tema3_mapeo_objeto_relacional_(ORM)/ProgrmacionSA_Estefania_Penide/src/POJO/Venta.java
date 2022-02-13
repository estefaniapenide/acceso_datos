/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Estefania
 */
public class Venta {

    private Date fechaVenta;
    private Time hora;
    private String codigoArticulo;
    private int numeroUnidades;
    private float importe;

    public Venta() {

    }

    public Venta(Date fechaVenta, Time hora, String codigoArticulo, int numeroUnidades, float importe) {
        this.fechaVenta = fechaVenta;
        this.hora = hora;
        this.codigoArticulo = codigoArticulo;
        this.numeroUnidades = numeroUnidades;
        this.importe = importe;
    }

    /**
     * @return the fechaVenta
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * @param fechaVenta the fechaVenta to set
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * @return the hora
     */
    public Time getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * @return the codigoArticulo
     */
    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    /**
     * @param codigoArticulo the codigoArticulo to set
     */
    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    /**
     * @return the numeroUnidades
     */
    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    /**
     * @param numeroUnidades the numeroUnidades to set
     */
    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

}
