
package Pojos;

import java.io.*;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author 
 */
@Entity
@Table(name="INSTITUTOS")
public class Institutos implements Serializable {
    
    @Id
    @Column(name="CODIGO")
    private int codigo;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="TELEFONO")
    private String telefono;
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "INSTITUTOS_CICLOS", joinColumns = @JoinColumn(name = "CODIGO_INSTITUTO"), inverseJoinColumns = @JoinColumn(name = "CODIGO_CICLO"))
    private Set<Ciclos> ciclos;
    
    //private Set<Talleres> talleres;

    public Institutos() {
    }

    public Institutos(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
       // this.ciclos = new HashSet();
      //  this.talleres = new HashSet();
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

//    public Set<Talleres> getTalleres() {
//        return talleres;
//    }
//
//    public void setTalleres(Set<Talleres> talleres) {
//        this.talleres = talleres;
//    }
    
    
    
}
