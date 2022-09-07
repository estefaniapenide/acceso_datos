/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.ejneodatiscuentas.pojos;

import java.util.Date;
//import java.sql.Time;

/**
 *
 * @author a20armandocb
 */
public class Movimiento {

    private Date fecha;
    //private Time hora;
    private Cuenta cuenta;
    private char operacion;
    private float importe;
    private float saldoResultante;
    public final static char OP_INGRESO = 'I';
    public final static char OP_RETIRADA = 'R';

    public Movimiento() {
    }

    public Movimiento(Date fecha, Cuenta cuenta, char operacion, float importe) {
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.operacion = operacion;
        this.importe = importe;
    }

    public Movimiento(Date fecha, Cuenta cuenta, char operacion, float importe, float saldoResultante) {
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.operacion = operacion;
        this.importe = importe;
        this.saldoResultante = saldoResultante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public char getOperacion() {
        return operacion;
    }

    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getSaldoResultante() {
        return saldoResultante;
    }

    public void setSaldoResultante(float saldoResultante) {
        this.saldoResultante = saldoResultante;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "fecha=" + fecha + ", cuenta=" + cuenta + ", operacion=" + operacion + ", importe=" + importe + ", saldoResultante=" + saldoResultante + '}';
    }
    
}
