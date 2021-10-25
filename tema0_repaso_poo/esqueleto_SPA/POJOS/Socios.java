package Pojos;
import java.io.Serializable;
import java.util.*;

public class Socios {
	//implements Serializable{

    private String codigo;
    private String nombre;
    private float cuotaFija;
    private ArrayList<Usos> usos;

    public Socios(){
    }

    public Socios(String cod, String nom, float quo){
    nombre=nom;
    codigo=cod;
    cuotaFija=quo;
    usos=new ArrayList();
    }

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