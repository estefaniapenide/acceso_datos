/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author a20estefaniapc
 */
@Entity
@Table(name="LIBROS")
public class Libro {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    
    @Column(name="TITULO")
    private String titulo;
    
    @Column(name="PRECIO")
    private float precio;
    
    @ManyToMany(cascade= {CascadeType.ALL},mappedBy="libros",fetch = FetchType.EAGER)
    private Set<Autor> autores = new HashSet<Autor>();
    
    public Libro(){
    
    }
    
    public Libro(String titulo, float precio){
        this.titulo=titulo;
        this.precio=precio;
    }
    
        /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the autores
     */
    public Set<Autor> getAutores() {
        return autores;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(Set<Autor> autores) {
        this.autores = autores;
    }
    
    public String toString(){
        String libro = "ID: " + id+"\n"
                + "TÍTULO: " + titulo+"\n"
                + "PRECIO(€): " + precio;
        return libro;
    }
    
}
