/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO;

/**
 *
 * @author a20estefaniapc
 */
public class LibrosTexto extends Libros{
    
    private String especialidad;
    
    public LibrosTexto(){
    super();
    }
    
    public LibrosTexto(String especialidad){
        this.especialidad=especialidad;
    }
    
    public LibrosTexto(String especialidad, String ref, String titulo, float precio, boolean estado){
    super(ref,titulo,precio,estado);
    this.especialidad=especialidad;
   
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
   
    
}
