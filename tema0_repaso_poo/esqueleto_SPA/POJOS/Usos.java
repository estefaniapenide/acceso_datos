package Pojos;
import examen.IComunes;
import java.io.Serializable;
import java.util.*;
//import java.sql.*;

public class Usos {
	//implements IComunes, Serializable{

	private String actividad;
	private Date fecha;
	private long horaInicio;
	private long horaFin;
	private float importe;

        public Usos(String nombreActividad, float importeUso,Date fecha, long horaInicio, long horaFin) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.actividad = nombreActividad;
        this.importe = importeUso;
    }
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public long getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(long horaInicio) {
        this.horaInicio = horaInicio;
    }

    public long getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(long horaFin) {
        this.horaFin = horaFin;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    //Si no se hubiese calculado al dar de alta el uso
//    public float calcularImporte(){
//            float importe=0;
//            long time1=horaInicio;
//            long time2=horaFin;
//
//            long numHoras=((time2-time1)/(1000*60*60));//de miliseg a horas
//
//            System.out.println("Horas: "+numHoras);
//            
//            if (actividad.equalsIgnoreCase("libre")){
//                    //aqui el importe se mantiene en 0
//            } else if(actividad.equalsIgnoreCase("grupo")){
//                    importe=numHoras*2;
//            } else if(actividad.equalsIgnoreCase("alquila")){
//                    importe=numHoras*4;
//            }
//
//            return importe;
//    }
                
	
}