package Metodos;
import Pojos.*;
import java.io.*;
import java.util.*;

import Pojos.*;
import examen.IComunes;
import examen.Secuenciales;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class consultasSec implements IComunes {

	public static void consultasSoc() throws IOException, FileNotFoundException, ClassNotFoundException{
	System.out.println("Introduzca CODIGO de socio:");
	String codigo=entrada.readLine();
        
	boolean error=true;
        
        Date fechaF = null,fechaI = null;
        
        spa spa = new spa();
        Socios socio = new Socios();
        
	
       // spa= Secuenciales.lee();
        
	System.out.println("spa: "+ spa.getNombre());
        System.out.println("NumSocios: "+ spa.getSocios().size());
        
	
	for (Socios s: spa.getSocios()){
            if (s.getCodigo().equalsIgnoreCase(codigo) )
                socio=s;
            else System.out.println("SocioCod: "+ socio.getCodigo()+" SocioNom: "+ socio.getNombre());
        }	
	
	if (socio==null) System.out.println("No existe un socio con ese código.");	
	else {

            System.out.println("Datos del socio:"+
            "Código: "+socio.getCodigo()+"	Nombre: "+socio.getNombre()+"");	

            
            System.out.println("Introduzca fecha de INICIO de comprobación \"dd-mm-yyyy\":");

            do{
            try{
                error=false;
                fechaI= sdfDate.parse(entrada.readLine());
            }catch(ParseException e){error=true;}
            }while(error==true);

            System.out.println("Introduzca fecha de FIN de comprobación \"dd-mm-yyyy\":");

            do{
            try{
                error=false;
                fechaF= sdfDate.parse(entrada.readLine());
            }catch(ParseException e){error=true;}
            }while(error==true);

            System.out.println("I: "+fechaI.toString());
            System.out.println("F: "+fechaF.toString());
            
            float acumulador = 0 ;

            System.out.println("Usos: "+socio.getUsos().size());
            
            for (Usos u: socio.getUsos()){         
                System.out.println("Fecha: "+  u.getFecha());
                if ((u.getFecha().before(fechaF) && u.getFecha().after(fechaI))||(u.getFecha().equals(fechaI))||(u.getFecha().equals(fechaF))) 
                    acumulador= acumulador + u.getImporte();
                    //System.out.println("Pasa.");
            }

                float total = socio.getCuotaFija()+acumulador;

                System.out.println("El socioCod " +socio.getCodigo()+" "+socio.getNombre()+" tiene una factura pendiente de "+total+" €");
                System.out.println("Operación Desglosada: "+ "Cuota Fija: " + socio.getCuotaFija() + " Cuota Calulada: "+ acumulador);
        }

            System.out.println("Operación finalizada.");
    }
        
}