
package Pojos;

import java.io.*;
import java.util.*;

/**
 *
 * @author 
 */
public class Institutos implements Serializable {
    
    private int codigo;
    private String nombre;
    private String telefono;
    private Set<Ciclos> ciclos;
    private Set<Talleres> talleres;

    public Institutos() {
    }

    public Institutos(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.ciclos = new HashSet();
        this.talleres = new HashSet();
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Ciclos> getCiclos() {
        return ciclos;
    }

    public void setCiclos(Set<Ciclos> ciclos) {
        this.ciclos = ciclos;
    }

    public Set<Talleres> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Talleres> talleres) {
        this.talleres = talleres;
    }
    
    
    
}
