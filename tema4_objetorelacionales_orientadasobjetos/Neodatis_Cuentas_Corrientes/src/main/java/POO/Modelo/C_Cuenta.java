/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author a20estefaniapc
 */
public abstract class C_Cuenta implements Serializable{

    private int numero;
    private String sucursal;
    private float saldoActual;
    private ArrayList<C_Cliente> clientes = new ArrayList<C_Cliente>();

    public C_Cuenta() {
    }

    public C_Cuenta(int numero, String sucursal, float saldoActual) {
        this.numero = numero;
        this.sucursal = sucursal;
        this.saldoActual = saldoActual;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the sucursal
     */
    public String getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the saldoActual
     */
    public float getSaldoActual() {
        return saldoActual;
    }

    /**
     * @param saldoActual the saldoActual to set
     */
    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    /**
     * @return the clientes
     */
    public ArrayList<C_Cliente> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ArrayList<C_Cliente> clientes) {
        this.clientes = clientes;
    }

}
