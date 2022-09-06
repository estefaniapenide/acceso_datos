/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author a20estefaniapc
 */
public class C_CuentaCorriente extends C_Cuenta {

    private ArrayList<C_Movimiento> movimientos = new ArrayList<C_Movimiento>();

    public C_CuentaCorriente() {
        super();
    }

    public C_CuentaCorriente(int numero, String sucursal, float saldoActual) {
        super(numero, sucursal, saldoActual);
    }

    /**
     * @return the movimientos
     */
    public List getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(ArrayList<C_Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void actualizarSaldo() {
        super.setSaldoActual(movimientos.get(movimientos.size() - 1).getSaldoResultante());
    }

    @Override
    public String toString() {
        String cuentaCorriente = "\n\tCUENTA CORRIENTE"
                + "\nNÚMERO DE CUENTA: " + getNumero()
                + "\nSUCURSAL: " + getSucursal()
                + "\nSALDO ACTUAL(€): " + getSaldoActual() + "\n";
        return cuentaCorriente;
    }

}
