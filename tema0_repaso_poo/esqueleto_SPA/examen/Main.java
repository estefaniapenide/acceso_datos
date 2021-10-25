package examen;
import Db4o.ConsultaBBDD;
import static Db4o.ConsultaBBDD.ConsultaBBDD;
import static Db4o.ConsultaBBDD.CrearBBDDOO;
import GUI.CrearTabla;
import static Metodos.AltaUsos.AltaUsos;
import static Metodos.BajaSocios.BajaSocios;
import static Metodos.consultasSec.consultasSoc;
import MetodosRandom.Aleatorios;
import static MetodosRandom.Aleatorios.AleatoriosInserta;
import Pojos.Socios;
import Pojos.SociosRandom;
import java.io.*;
import static java.lang.System.exit;
import java.text.ParseException;
import java.util.*;

public class Main implements IComunes {

public static void main (String []Args) throws IOException,
        FileNotFoundException, ClassNotFoundException, ParseException {

    int opcion=0;
	Secuenciales.crea(); //creación física del fichero.
	
	do{
		System.out.println("Ejercicio examen. Introduzca comando: "+
		"\n[1] - Secuenc.Alta de usos."+
		"\n[2] - Secuenc.Bajas de socios."+
		"\n[3] - Secuenc.Consultas."+
                "\n[4] - Aleat.Modifica Dirección Socio."+
                "\n[5] - DB4o."+
                "\n[6] - GUI-Swing."+
		"\n[7] - Salir.");
		
		opcion=Auxiliar.Elige(7);
		
		switch (opcion){
			//case 7: break;
			case 1: AltaUsos(); break;
			case 2: BajaSocios(); break;
			case 3: consultasSoc(); break;
                        case 4: 
                            break;
                        case 5:
                           
                            break;
                        case 6:
                           
                            break;
                            
                        default:exit(0); break; 
			
		}		
	}while(opcion!=0);

    }
}