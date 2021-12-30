/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.util.ArrayList;

/**
 *
 * @author a20estefaniapc
 */
public class Bibliotecas {
    
    private String cif;
    private String nombre;
    private String tf;
    private ArrayList<Libros> L;
    
    public Bibliotecas(){
    }
    
    public Bibliotecas(String cif, String nombre, String tf, ArrayList<Libros> L){
    this.cif=cif;
    this.nombre=nombre;
    this.tf=tf;
    this.L=L;
    }

    /**
     * @return the cif
     */
    public String getCif() {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(String cif) {
        this.cif = cif;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tf
     */
    public String getTf() {
        return tf;
    }

    /**
     * @param tf the tf to set
     */
    public void setTf(String tf) {
        this.tf = tf;
    }

    /**
     * @return the L
     */
    public ArrayList<Libros> getL() {
        return L;
    }

    /**
     * @param L the L to set
     */
    public void setL(ArrayList<Libros> L) {
        this.L = L;
    }
    
}
