/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

/**
 *
 * @author Estefania
 */
public class Fijo extends Empleado {

    private int salarioBase;
    private int trienios;
    
    private float sueldo;

    public Fijo() {
        super();
    }

    public Fijo(String dni, String nombre, String telefono, float porcentajeRetencion, int salarioBase, int trienios) {
        super(dni, nombre, telefono, porcentajeRetencion);
        this.salarioBase = salarioBase;
        this.trienios = trienios;
    }

    /**
     * @return the salarioBase
     */
    public int getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(int salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * @return the trienios
     */
    public int getTrienios() {
        return trienios;
    }

    /**
     * @param trienios the trienios to set
     */
    public void setTrienios(int trienios) {
        this.trienios = trienios;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    @Override
    public void calcularNomina() {
       sueldo = (salarioBase + trienios) - (salarioBase + trienios) * getPorcentajeRetencion();
    }

}
