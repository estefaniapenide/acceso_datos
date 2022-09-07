/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas.pojos;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author a20armandocb
 */
public class Cliente {

    private String dni, nombre, direccion;
    private Set<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String direccion, Set<Cuenta> cuentas) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = cuentas;
    }

    public Cliente(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new HashSet<Cuenta>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(Set<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public boolean addCuenta(Cuenta cuenta) {
        if (!cuentas.contains(cuenta)) {
            this.cuentas.add(cuenta);
            return true;
        }
        return false;
    }

    public boolean removeCuenta(Cuenta cuenta) {
        if (cuentas.contains(cuenta)) {
            this.cuentas.remove(cuenta);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + "}";
    }
    
}
