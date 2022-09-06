
package Pojos;

import java.io.*;
import java.util.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author 
 */
@Entity
@Table(name="TALLERES")
public class Talleres implements Serializable {
    
    @Id
    @Column(name="CODIGO")
    private int codigo;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    private Set<Ciclos> ciclos;
    
    //private Institutos instituto;
    //private Set<Usos> usos;

    public Talleres() {
    }

    public Talleres(String nombre, Institutos instituto) {
        this.nombre = nombre;
        //this.instituto = instituto;
        //this.usos = new HashSet();
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

//    public Institutos getInstituto() {
//        return instituto;
//    }
//
//    public void setInstituto(Institutos instituto) {
//        this.instituto = instituto;
//    }
//
//    public Set<Usos> getUsos() {
//        return usos;
//    }
//
//    public void setUsos(Set<Usos> usos) {
//        this.usos = usos;
//    }

    /**
     * @return the ciclos
     */
    public Set<Ciclos> getCiclos() {
        return ciclos;
    }

    /**
     * @param ciclos the ciclos to set
     */
    public void setCiclos(Set<Ciclos> ciclos) {
        this.ciclos = ciclos;
    }
    
    
    
}
