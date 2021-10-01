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
public class Spa //implements Serializable
{

    //atributos
    private String cif;
    private String nombre;
    private ArrayList<Actividades> actividades;
    private ArrayList<Socios> socios;

    //constructores
    public Spa(){
        
    }
    
    public Spa(String cif, String nom) {
        this.cif = cif;
        this.nombre = nom;
    }

    //getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<Actividades> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividades> actividades) {
        this.actividades = actividades;
    }
    
    public ArrayList<Socios> getSocios() {
        return socios;
    }

    public void setCif(ArrayList<Socios> socios) {
        this.socios = socios;
    }

}
