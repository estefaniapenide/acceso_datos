/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

import java.util.ArrayList;

/**
 *
 * @author a20estefaniapc
 */
public class LibrosOcio extends Libros {

    private ArrayList<Prestamos> P;

    public LibrosOcio() {
        super();
    }

    public LibrosOcio(ArrayList<Prestamos> P) {
        this.P = P;
    }

    public LibrosOcio(ArrayList<Prestamos> P, String ref, String titulo, float precio, boolean estado) {
        super(ref, titulo, precio, estado);
        this.P = P;

    }

    /**
     * @return the P
     */
    public ArrayList<Prestamos> getP() {
        return P;
    }

    /**
     * @param P the P to set
     */
    public void setP(ArrayList<Prestamos> P) {
        this.P = P;
    }
    


}
