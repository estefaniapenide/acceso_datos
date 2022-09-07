/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas.pojos;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author a20armandocb
 */
public class CuentaCorriente extends Cuenta {

    private List<Movimiento> movimientos = new ArrayList<Movimiento>();

    public CuentaCorriente() {

    }

    public CuentaCorriente(int numero, String sucursal, float saldoActual) {
        super(numero, sucursal, saldoActual);
    }

    public CuentaCorriente(int numero, String sucursal, float saldoActual, Set<Cliente> clientes) {
        super(numero, sucursal, saldoActual, clientes);
    }

    public CuentaCorriente(List movimientos, int numero, String sucursal, float saldoActual, Set<Cliente> clientes) {
        super(numero, sucursal, saldoActual, clientes);
        this.movimientos = movimientos;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List movimientos) {
        this.movimientos = movimientos;
    }

    public boolean addMovimientos(Movimiento movimiento) {
        if (!movimientos.contains(movimiento)) {
            switch (movimiento.getOperacion()) {
                case Movimiento.OP_INGRESO:
                    setSaldoActual(getSaldoActual() + movimiento.getImporte());
                    movimiento.setSaldoResultante(getSaldoActual());
                    break;
                case Movimiento.OP_RETIRADA:                                        
                    setSaldoActual(getSaldoActual()- movimiento.getImporte());
                    movimiento.setSaldoResultante(getSaldoActual());
                    break;
                default:
                    return false;
            }          
            this.movimientos.add(movimiento);
            return true;
        }
        return false;
    }

}
