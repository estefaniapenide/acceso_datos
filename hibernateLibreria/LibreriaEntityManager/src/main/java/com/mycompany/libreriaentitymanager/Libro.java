/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libreriaentitymanager;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Coolbay
 */
@Entity
@Table(name = "Libro")
public class Libro implements Serializable {
    @Id
    
    @Column(name="idLibro",updatable = false, nullable = false)
    private int codigo;
     @Column(name="titulo")
    private String titulo;
      @Column(name="precio")
    private float precio;
     @ManyToOne(fetch = FetchType.LAZY)
     //se especifica que es lazy para que no se cargue el autor en la base de datos hasta que se haga un getautor 
     @JoinColumn(name="id_autor") //columna donde se va a guardar el id del autor que "posea" el libro
    private Autor autor; //un autor porque es el que ha creado el libro  

    public Libro() {
    }

    public Libro(int codigo, String titulo, float precio, Autor autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.precio = precio;
        this.autor = autor;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
    

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", titulo=" + titulo + ", precio=" + precio + ", autor=" + autor + '}';
    }
    
    
}
