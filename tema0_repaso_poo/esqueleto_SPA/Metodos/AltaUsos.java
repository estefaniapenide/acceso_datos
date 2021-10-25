package Metodos;
import Pojos.*;
import examen.Auxiliar;
import examen.IComunes;
import examen.Secuenciales;
import java.io.*;
import java.util.*;
//import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AltaUsos implements IComunes {
	
    public static void AltaUsos() throws IOException, ClassNotFoundException, FileNotFoundException, ParseException {
    spa spa = null;

    Socios socio = null;
    int opcion = 0;

    // Date dia = new Date();
    Date dia = sdfDate.parse(sdfDate.format(new Date()));
//    System.out.println(sdfDate.format(new Date()));
    System.out.println(dia);

    Date horaS = null,horaE = null;

   /* if (ficheroSec.exists()){
        spa = Secuenciales.lee(); //trae el spa del fichero.
    }*/

    if (spa==null){
            System.out.println("No existe un spa creado.");
            System.out.println("Bienvenido/a a altas de usos."+
        "\n Introduzca CODIGO de spa para proceder.");
        String codigo=entrada.readLine(); 


        System.out.println("Introduzca Nombre de spa para proceder.");
        String nombre=entrada.readLine(); 

        spa = new spa(codigo,nombre);
    }	

    else{
        System.out.println("Bienvenido/a a altas de usos.Spa."+
    "\n Introduzca CODIGO de socio para proceder.");
    String codigo=entrada.readLine(); 

        for (Socios s: spa.getSocios()){
            if (s.getCodigo().equalsIgnoreCase(codigo))
                socio=s;}
    }
    if (socio==null)
    {
        System.out.println("No existe un socio con ese código.");

            System.out.println("Bienvenido/a a altas de usos.Socio."+
        "\n Introduzca CODIGO de socio para proceder.");
        String codigo=entrada.readLine(); 

        System.out.println("Introduzca Nombre de socio para proceder.");
        String nombre=entrada.readLine(); 

        System.out.println("Introduzca cuota de socio para proceder.");
        String cuota=entrada.readLine(); 

        socio = new Socios (codigo,nombre,Float.parseFloat(cuota));

        spa.getSocios().add(socio);
    }	


    System.out.println("Datos del socio:"+
    "Código: "+socio.getCodigo()+" Nombre: "+socio.getNombre()+"");	

    System.out.println("¿Qué tipo de uso desea registrar?" +
    "\n[1] - De libre horario." +	
    "\n[2] - Actividad en grupo." +	
    "\n[3] - Actividad en espacio." );

    opcion=Auxiliar.Elige(3);
    String tipo="";
    int modificador=0;

    switch(opcion){
            case 1: tipo="Libre"; modificador=0; break;
            case 2: tipo="Grupo"; modificador=2; break;
            case 3: tipo="Espacio"; modificador=4; break;
    }

    Boolean error=false;
    do{
        error=false;	
        System.out.println("Introduzca hora de entrada: formato hh:mm:ss ");
        try{
        horaE=(Date) sdfT.parse(entrada.readLine()); //usamos un tipo Date con formato horario, a falta de saber los metodos del Time.
        }catch(ParseException e){error=true;}
    }while(error==true);

    do{
        error=false;	
        System.out.println("Introduzca hora de salida: hh:mm:ss ");
        try{
        horaS=(Date) sdfT.parse(entrada.readLine());
        }catch(ParseException e){error=true;}
    }while(error==true);

    float horas= ((horaS).getTime()-horaE.getTime())/(60*60*1000); //la diferencia son las horas que van de una fecha a otra
    float importeTotal=horas*modificador; //nº horas x precioHora;

    System.out.println("Resumen del uso:" +
    "\nTipo: "+tipo+"" +
    "\nHoras:	"+horas+"" +
    "\nImporte total "+importeTotal+"€" +
    "\n¿Confirma que desea crear este uso? " +
    "\n[1]- Si"+
    "\n[2]- No");

    Usos auxU=null;
    opcion=Auxiliar.Elige(2);

    if (opcion==1){
            
            auxU=new Usos(tipo, importeTotal,dia, horaE.getTime(), horaS.getTime());  //creamos nuevo uso
            socio.getUsos().add(auxU); //lo añadimos al array del socio, esto deberia actualizar ya el mismo spa ya que el paso es por ref

            spa.getSocios().remove(socio);

            spa.getSocios().add(socio);

           // Secuenciales.graba(spa); //grabamos de nuevo el gimnasio 
            System.out.println("Operacion completada.");}	

    else System.out.println("Operacion cancelada a petición del ususario.");
   
    }

    //System.out.println("Fin de la operación.");
    public static String obtenerFechaFormateada(Date fecha, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        return sdf.format(fecha);
    }
 
}