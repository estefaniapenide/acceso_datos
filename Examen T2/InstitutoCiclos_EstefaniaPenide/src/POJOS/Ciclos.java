package Pojos;

import java.io.*;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author
 */
@Entity
@Table(name = "CICLOS")
public class Ciclos implements Serializable {

    @Id
    @Column(name = "CODIGO")
    private int codigo;

    @Column(name = "NOMBRE")
    private String nombre;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "ciclos", fetch = FetchType.EAGER)
    private Set<Institutos> institutos;
    
    
    private Set<Talleres> talleres;

    public Ciclos() {
    }

    public Ciclos(String nombre) {
        this.nombre = nombre;
        this.institutos = new HashSet();
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

    public Set<Institutos> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(Set<Institutos> institutos) {
        this.institutos = institutos;
    }

    public Set<Talleres> getTalleres() {
        return talleres;
    }

    public void setTalleres(Set<Talleres> talleres) {
        this.talleres = talleres;
    }

}
