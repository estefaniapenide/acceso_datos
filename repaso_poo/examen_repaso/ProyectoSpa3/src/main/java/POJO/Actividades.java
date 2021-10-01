/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

//import java.io.Serializable;

/**
 *
 * @author Estefania
 */
public class Actividades 
//implements Serializable
{

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
        return this.tipo;
    }

    public float getCuota() {
        return this.cuota;
    }

    @Override
    public String toString() {
        String actividad = "Tipo: " + tipo + "\n"
                + "Cuota(€): " + cuota + "\n";

        return actividad;
    }

}
