/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.sql.Date;

/**
 *
 * @author a20estefaniapc
 */
public class Libro {

    private int cod;
    private String titulo;
    private String categoria;
    private float precio;
    private Date fechaPublicacion;

    public Libro() {
    }

    public Libro(int cod, String titulo, String categoria, float precio, Date fechaPublicacion) {
        this.cod = cod;
        this.titulo = titulo;
        this.categoria = categoria;
        this.precio = precio;
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
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
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
     * @return the fechaPublicacion
     */
    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * @param fechaPublicacion the fechaPublicacion to set
     */
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    @Override
    public String toString() {
        String libro = "\tLIBRO\n"
                + "CÓDIGO: " + cod + "\n"
                + "TÍTULO: " + titulo + "\n"
                + "CATEGORÍA: " + categoria + "\n"
                + "PRECIO: " + precio + "\n"
                + "FECHA DE PUBLICACIÓN: " + fechaPublicacion + "\n";
        return libro;
    }

}
