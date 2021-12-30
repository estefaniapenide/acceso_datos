/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

/**
 *
 * @author a20estefaniapc
 */
//Antes esta clase era abstracta pero para poder hacer el ejercicio 3 ha sido modificada
public class Libros {

    private String ref;
    private String titulo;
    private float precio;
    private boolean estado;
    private int tamMax=140;

    public Libros() {
    }

    public Libros(String ref, String titulo, float precio, boolean estado) {
        this.ref = ref;
        this.titulo = titulo;
        this.precio = precio;
        this.estado = estado;
    }

    /**
     * @return the ref
     */
    public String getRef() {
        return ref;
    }

    /**
     * @param ref the ref to set
     */
    public void setRef(String ref) {
        this.ref = ref;
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
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    public int getTamMax(){
    return tamMax;
    }
    
    public int getTamReal(){
        int tamReal=(this.ref.length()*2+this.titulo.length()*2+4+1);
    return tamReal;
    }

}
