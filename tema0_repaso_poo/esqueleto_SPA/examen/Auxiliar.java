package examen;
import java.io.*;

public class Auxiliar implements IComunes {

    public static int Elige(int max) throws IOException {

            boolean error=false;
            int opcion=0;

            do{
            try{		
            error=false;	
            opcion=Integer.parseInt(entrada.readLine());
            if (opcion>max || opcion<1) error=true;
            }catch(NumberFormatException e){error=true;}
            }while(error==true);

            return opcion;
    }

}