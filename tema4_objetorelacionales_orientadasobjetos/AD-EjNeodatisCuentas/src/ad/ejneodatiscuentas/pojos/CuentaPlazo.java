/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas.pojos;

import java.util.Set;

/**
 *
 * @author a20armandocb
 */
public class CuentaPlazo extends Cuenta {

    private int intereses;
    private String fechaVencimiento;
    private float depositoPlazo;

    public CuentaPlazo() {
    }

    public CuentaPlazo(int intereses, String fechaVencimiento, float depositoPlazo, int numero, String sucursal, float saldoActual) {
        super(numero, sucursal, saldoActual);
        this.intereses = intereses;
        this.fechaVencimiento = fechaVencimiento;
        this.depositoPlazo = depositoPlazo;
    }

    public CuentaPlazo(int intereses, String fechaVencimiento, float depositoPlazo, int numero, String sucursal, float saldoActual, Set<Cliente> clientes) {
        super(numero, sucursal, saldoActual, clientes);
        this.intereses = intereses;
        this.fechaVencimiento = fechaVencimiento;
        this.depositoPlazo = depositoPlazo;
    }

    public int getIntereses() {
        return intereses;
    }

    public void setIntereses(int intereses) {
        this.intereses = intereses;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public float getDepositoPlazo() {
        return depositoPlazo;
    }

    public void setDepositoPlazo(float depositoPlazo) {
        this.depositoPlazo = depositoPlazo;
    }

}
