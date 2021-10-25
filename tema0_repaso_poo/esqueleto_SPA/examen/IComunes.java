package examen;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public interface IComunes {

	File ficheroSec = new File("Secuencial.dat");
	File ficheroRand = new File("Random.dat");
	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
         
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-YYYY");
	SimpleDateFormat sdfT = new SimpleDateFormat("hh:mm:ss");
	final int maxSize = 400;
	
}