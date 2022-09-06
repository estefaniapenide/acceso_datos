
package Pojos;

import java.io.*;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author 
 */
public class Usos implements Serializable {
    
    private Ciclos ciclo;
    private Talleres taller;
    private Date fecha;
    private Time hora;

    public Usos() {
    }
    
    public Usos(Ciclos ciclo, Talleres taller, Date fecha, Time hora) {
        this.ciclo = ciclo;
        this.taller = taller;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Ciclos getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclos ciclo) {
        this.ciclo = ciclo;
    }

    public Talleres getTaller() {
        return taller;
    }

    public void setTaller(Talleres taller) {
        this.taller = taller;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    
    
}
