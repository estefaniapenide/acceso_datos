/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gal.teis.proyectorelaxsl;

/**
 *
 * @author Estefania
 */
public class Actividades {

    //atributos
    private String tipo;
    private float cuota;

    //constructor
    public Actividades(String tip, float quo) {
        this.tipo = tip;
        this.cuota = quo;
    }

    //getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    //toString
    @Override
    public String toString() {
        String actividades = "Tipo: " + tipo + "\n"
                + "Cuota(€/h): " + cuota + "\n";
        return actividades;
    }

}
