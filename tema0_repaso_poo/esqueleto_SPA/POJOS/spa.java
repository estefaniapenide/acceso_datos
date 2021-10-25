package Pojos;
import java.io.*;
import java.util.*;

public class spa {
//	implements Serializable {

	private String CIF;
	private String nombre;
	private ArrayList<Actividades> actividades;
	private ArrayList<Socios> socios;
        private String direccion;

        public spa(){

	}
        
	public spa(String cif, String nom){
	CIF=cif;
	nombre=nom;
	socios=new ArrayList();
	actividades=new ArrayList();
        direccion="";
	}

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public void setSocios(ArrayList<Socios> socios) {
        this.socios = socios;
    }
        
}