package Metodos;
import Pojos.*;
import examen.Auxiliar;
import examen.IComunes;
import examen.Secuenciales;
import java.io.*;
import java.util.*;

public class BajaSocios implements IComunes {
	
	public static void BajaSocios() throws IOException, FileNotFoundException, ClassNotFoundException {
	spa spa = new spa();
	//spa = Secuenciales.lee();
	Socios socio = null;
	int opcion = 0;
	
	System.out.println("Bajas de socios. Introduzca el CODIGO del socio a eliminar:");
	String codigo=entrada.readLine();
	
	for (Socios s: spa.getSocios()){
	if (s.getCodigo().equalsIgnoreCase(codigo))
            socio=s;}	
	
	if (socio==null) System.out.println("No existe un socio con ese código.");	
	else {
	System.out.println("¿Confirma que desea eliminar al socio "+socio.getCodigo()+" "+socio.getNombre()+
	"\n[1] - Si." +
	"\n[2] - No.");
	
	opcion=Auxiliar.Elige(2);
	if (opcion==1) {
            spa.getSocios().remove(socio); // borra socio
          //  Secuenciales.graba(spa); //reescribe spa
            System.out.println("Operación completada con éxito.");
	}
	else System.out.println("Operación cancelada a petición del usuario");
	} 
	System.out.println("Operación finalizada.");
	
	}
	
	
}