package DOM;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class CPersona {
    private static final int tamMax = 140;
    
    private int clave;
    private String nombre;
    private float edad;
   
    public CPersona() {
    }

    public CPersona(int clave, String nombre, float edad) {
        this.clave = clave;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getEdad() {
        return edad;
    }

    public void setEdad(float edad) {
        this.edad = edad;
    }

          public int getLongitud(){
        
        return 2+
               this.nombre.length()*2+
               4;
}

    public int getTamMax() {
        return tamMax;
    }
}
