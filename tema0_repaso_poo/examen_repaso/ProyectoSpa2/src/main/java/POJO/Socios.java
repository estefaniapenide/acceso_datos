/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.ArrayList;

/**
 *
 * @author Estefania
 */
public class Socios {

    //atributos
    private String codigo;
    private String nombre;
    private float cuotaFija;
    private ArrayList<Usos> usos;

    //constructor
    public Socios(){}
    
    public Socios(String cod, String nom, float quo) {
        this.codigo = cod;
        this.nombre = nom;
        this.cuotaFija = quo;
    }

    //getters y setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public float getCuotaFija() {
        return cuotaFija;
    }

    public void setCuotaFija(float cuotaFija) {
        this.cuotaFija = cuotaFija;
    }
    
    public ArrayList<Usos> getUsos() {
        return usos;
    }

    public void setUsos(ArrayList<Usos> usos) {
        this.usos = usos;
    }

}
