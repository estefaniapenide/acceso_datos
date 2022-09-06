/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Modelo;

import java.util.List;
import java.util.Set;

/**
 *
 * @author a20estefaniapc
 */
public class C_CuentaPlazo extends C_Cuenta {

    private int intereses;
    private String fechaVencimiento;
    private float depositoPlazo;

    public C_CuentaPlazo() {
        super();
    }

    public C_CuentaPlazo(int numero, String sucursal, float saldoActual, int intereses, String fechaVencimiento, float depositoPlazo) {
        super(numero, sucursal, saldoActual);
        this.intereses = intereses;
        this.fechaVencimiento = fechaVencimiento;
        this.depositoPlazo = depositoPlazo;
    }

    /**
     * @return the intereses
     */
    public int getIntereses() {
        return intereses;
    }

    /**
     * @param intereses the intereses to set
     */
    public void setIntereses(int intereses) {
        this.intereses = intereses;
    }

    /**
     * @return the fechaVencimiento
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the depositoPlazo
     */
    public float getDepositoPlazo() {
        return depositoPlazo;
    }

    /**
     * @param depositoPlazo the depositoPlazo to set
     */
    public void setDepositoPlazo(float depositoPlazo) {
        this.depositoPlazo = depositoPlazo;
    }
    
     @Override
    public String toString() {
        String cuentaPlazo = "\n\tCUENTA PLAZO"
                + "\nNÚMERO DE CUENTA: " + getNumero()
                + "\nSUCURSAL: " + getSucursal()
                + "\nSALDO ACTUAL(€): " + getSaldoActual() + "\n";
        return cuentaPlazo;
    }

}
