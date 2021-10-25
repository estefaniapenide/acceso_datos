package examen;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;
import java.text.ParseException;


public class Pedir {

    private static final BufferedReader LEE = new BufferedReader(new InputStreamReader(System.in));
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String dni() {
        String dni="";
        boolean error;
        do{
                error = false;
                try {
                        System.out.printf("DNI: ");
                        dni = LEE.readLine();
                } catch (IOException e) {
                        error=true;
                        System.out.println("Error en la entrada: "+e.getMessage());
                }
        } while(error);
        return dni;
    }
    
    public static String nombre(String nombre) {
        //String nombre="";
        boolean error;
        do{
                error = false;
                try {
                        System.out.printf(nombre+": ");
                        nombre = LEE.readLine();
                } catch (IOException e) {
                        error=true;
                        System.out.println("Error en la entrada: "+e.getMessage());
                }
        } while(error);
        return nombre;
    }

    public static String telefono() {
        String telefono="";
        boolean error;
        do{
                error = false;
                try {
                        System.out.printf("Telefono: ");
                        telefono = LEE.readLine();
                } catch (IOException e) {
                        error=true;
                        System.out.println("Error en la entrada: "+e.getMessage());
                }
        } while(error);
        return telefono;
    }
      
    public static Date fecha() throws ParseException {
        Date fecha = null;
        boolean error;
        do {
                error=false;
                try {
                        System.out.printf("Fecha(dd/MM/yyyy): ");
                        fecha = dateFormat.parse(LEE.readLine());
                } catch(IOException | ParseException e) {
                        System.out.println("Error en la entrada: "+e.getMessage());
                }
        } while(error);
        return fecha;
    }

    public static int opcion() {
        int opt = 0;
        boolean error;
        do {
                error=false;
                try {
                        System.out.printf("Opción: ");
                        opt = Integer.parseInt(LEE.readLine());
                } catch (NumberFormatException | IOException e) {
                        error=true;
                        System.out.println("Error en la entrada: "+e.getMessage());
                }
        } while(error);
        return opt;
    }

    public static boolean confirmacion() {
        boolean confirma=false;
        char sn;
        boolean error;
        do{
            error=false;
            try{
                System.out.printf("Confirma? (S/n)");
                sn = LEE.readLine().toLowerCase().charAt(0);
                switch (sn) {
                    case 's':
                        confirma=true;
                        break;
                    case 'n':
                        confirma=false;
                        break;
                    default:
                        error=true;
                        System.err.println("\nCarácter no válido, introduce de nuevo.\n");
                }
            } catch(StringIndexOutOfBoundsException e) {
                confirma=true;
            } catch(IOException e){
                error=true;
                System.err.println("\nError en la entrada!\n");
            }
        } while(error);
        return confirma;
    }

}