/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author mrnov
 */
public class Paises {
 
// Propiedades
private int id;
private String nombrePais;
//Contructores
public Paises() {
}
 
public Paises(int id, String nombrePais) {
this.id = id;
this.nombrePais = nombrePais;
}
//Metodos Getter y Setter
public void setId(int id) {
this.id = id;
}
 
public int getId() {
return id;
}
 
public String getNombrePais() {
return nombrePais;
}
 
public void setNombrePais(String nombrePais) {
this.nombrePais = nombrePais;
}
 
@Override
public String toString (){
return nombrePais;
}
 
}
