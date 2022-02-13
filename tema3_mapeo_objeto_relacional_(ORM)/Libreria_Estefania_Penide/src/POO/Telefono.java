/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Estefania
 */
@Entity
@Table(name = "TELEFONOS")
public class Telefono {

    @Id
    @Column(name="DNI_AUTOR")
    private String dniAutor;
    
    
    @Column(name = "TELEFONO")
    private String numTelf;

    public Telefono() {

    }

    public Telefono(String dniAutor, String numTelf){
         this.dniAutor=dniAutor;
        this.numTelf=numTelf;
       
    }

    /**
     * @return the dniAutor
     */
    public String getDniAutor() {
        return dniAutor;
    }

    /**
     * @param dniAutor the dniAutor to set
     */
    public void setDniAutor(String dniAutor) {
        this.dniAutor = dniAutor;
    }

    /**
     * @return the numTelf
     */
    public String getNumTelf() {
        return numTelf;
    }

    /**
     * @param numTelf the numTelf to set
     */
    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }



}
