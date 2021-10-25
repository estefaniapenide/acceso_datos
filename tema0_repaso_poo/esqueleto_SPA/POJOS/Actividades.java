package Pojos;

import java.io.Serializable;

public class Actividades{
//implements Serializable{

    private String tipo;
    private float cuota;

    public Actividades(String tip, float quo){
    tipo=tip;
    cuota=quo;
    }

    public Actividades() {
    }

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
        
}