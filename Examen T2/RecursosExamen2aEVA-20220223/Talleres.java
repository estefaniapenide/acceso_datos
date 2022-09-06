
package Pojos;

import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class Talleres implements Serializable {
    
    private int codigo;
    private String nombre;
    private Institutos instituto;
    private Set<Usos> usos;

    public Talleres() {
    }

    public Talleres(String nombre, Institutos instituto) {
        this.nombre = nombre;
        this.instituto = instituto;
        this.usos = new HashSet();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Institutos getInstituto() {
        return instituto;
    }

    public void setInstituto(Institutos instituto) {
        this.instituto = instituto;
    }

    public Set<Usos> getUsos() {
        return usos;
    }

    public void setUsos(Set<Usos> usos) {
        this.usos = usos;
    }
    
    
    
}
