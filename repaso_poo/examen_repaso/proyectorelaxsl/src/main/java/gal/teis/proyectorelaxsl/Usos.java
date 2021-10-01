/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectorelaxsl;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Estefania
 */
public class Usos {

    //atributos
    private String actividad;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;
    private float importe;

    //constructor
    public Usos(String nombreActividad, float importeUso, Date fecha, Time horaInicio, Time horaFin) {
        this.actividad = nombreActividad;
        this.importe = importeUso;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    //getters y setters
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoarFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    //métodos
    public float calcularImporte() {
        float calculo=0;
        calculo = (horaFin.getTime() - horaInicio.getTime())*importe;
        return calculo;
        
    }
    

}
