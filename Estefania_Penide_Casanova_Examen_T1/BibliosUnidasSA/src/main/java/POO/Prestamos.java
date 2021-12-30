/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author a20estefaniapc
 */
public class Prestamos implements Serializable {
    
    private Date fechaPrestamo;
    private Date fecahDevolucion;
    private String dniLector;
    
    public Prestamos(){
    }
    
    public Prestamos(Date fechaPrestamo, Date fechaDevolucion, String dniLector){
    this.fechaPrestamo=fechaPrestamo;
    this.fecahDevolucion=fechaDevolucion;
    this.dniLector=dniLector;
    }

    /**
     * @return the fechaPrestamo
     */
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the fecahDevolucion
     */
    public Date getFecahDevolucion() {
        return fecahDevolucion;
    }

    /**
     * @param fecahDevolucion the fecahDevolucion to set
     */
    public void setFecahDevolucion(Date fecahDevolucion) {
        this.fecahDevolucion = fecahDevolucion;
    }

    /**
     * @return the dniLector
     */
    public String getDniLector() {
        return dniLector;
    }

    /**
     * @param dniLector the dniLector to set
     */
    public void setDniLector(String dniLector) {
        this.dniLector = dniLector;
    }
    
    
}
