/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a20estefaniapc
 */
public class C_Cliente {

    private String dni;
    private String nombre, direccion;
    private ArrayList<C_Cuenta> cuentas = new ArrayList<C_Cuenta>();

    public C_Cliente() {
    }

    public C_Cliente(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the cuentas
     */
    public List getCuentas() {
        return cuentas;
    }

    /**
     * @param cuentas the cuentas to set
     */
    public void setCuentas(ArrayList<C_Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    @Override
    public String toString() {
        String cliente = "\n\tCLIENTE"
                + "\nDNI: " + dni
                + "\nNOMBRE: " + nombre
                + "\nDIRECCIÓN: " + direccion + "\n";
        return cliente;
    }

}
