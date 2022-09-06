/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO.Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author a20estefaniapc
 */
public class C_Movimiento {

    private Date fecha;
    //private Time hora;
    private C_Cuenta cuenta;
    private char operacion;
    private float importe;
    private float saldoResultante;

    public C_Movimiento() {
    }

    public C_Movimiento(Date fecha, C_Cuenta cuenta, char operacion, float importe) {
        this.fecha = fecha;
        this.cuenta = cuenta;
        this.operacion = operacion;
        this.importe = importe;
        setSaldoResultante();
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

//    /**
//     * @return the hora
//     */
//    public Time getHora() {
//        return hora;
//    }
//
//    /**
//     * @param hora the hora to set
//     */
//    public void setHora(Time hora) {
//        this.hora = hora;
//    }
    /**
     * @return the cuenta
     */
    public C_Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(C_Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the operacion
     */
    public char getOperacion() {
        return operacion;
    }

    /**
     * @param operacion the operacion to set
     */
    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    /**
     * @return the importe
     */
    public float getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(float importe) {
        this.importe = importe;
    }

    /**
     * @return the saldoResultante
     */
    public float getSaldoResultante() {
        return saldoResultante;
    }

    /**
     * @param saldoResultante the saldoResultante to set
     */
    public void setSaldoResultante() {
        if (operacion == 'I') {
            cuenta.setSaldoActual(cuenta.getSaldoActual()+importe);
            saldoResultante=cuenta.getSaldoActual();
        } else if (operacion == 'R') {
            cuenta.setSaldoActual(cuenta.getSaldoActual()-importe);
            saldoResultante=cuenta.getSaldoActual();
        }
    }

}
