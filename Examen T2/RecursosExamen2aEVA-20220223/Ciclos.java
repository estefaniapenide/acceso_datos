
package Pojos;

import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class Ciclos implements Serializable {
    
    private int codigo;
    private String nombre;
    private Set<Institutos> institutos;
    private Set<Usos> usos;

    public Ciclos() {
    }

    public Ciclos(String nombre) {
        this.nombre = nombre;
        this.institutos = new HashSet();
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

    public Set<Institutos> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(Set<Institutos> institutos) {
        this.institutos = institutos;
    }

    public Set<Usos> getUsos() {
        return usos;
    }

    public void setUsos(Set<Usos> usos) {
        this.usos = usos;
    }
    
    
    
}
