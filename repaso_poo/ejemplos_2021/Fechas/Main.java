/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparativa;

//AntesJava8
import Antes_Java8.Calculos_DiasEntreFechas;
import static Antes_Java8.Calculos_DiasEntreFechas.pedirFecha;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;//(Date,Calendar)
import java.text.SimpleDateFormat;

//Con Java8
import java.time.*;//(format,temporal)
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrnov
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        //antes8();
         
        en8();
    }   
     
    public static void antes8() throws ParseException{

        //Cálculo de diferencia (en milisegundos y días) 
        //entre 2 fechas introducidas por teclado.

        System.out.printf("¿Desde que fecha?");
        Date desde = pedirFecha();

        System.out.printf("¿Hasta que fecha?");
        Date hasta = pedirFecha();
        
        difFechas(desde,hasta);
        
        
         //Cálculo de fecha de devolución de libro prestado(15 días)
        //Cálculo de tiempo de entrega de examen (3h)
        //Datos iniciales introducidos por teclado 
        
        UsandoCalendar();
  
    }
    
     public static Date pedirFecha() throws ParseException {
        Date fecha = null;
        boolean error;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        BufferedReader LEE = new BufferedReader(new InputStreamReader(System.in));
        
        do {
                error=false;
                
                        System.out.printf("Fecha(dd/MM/yyyy): ");
            try {
                fecha = dateFormat.parse(LEE.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Calculos_DiasEntreFechas.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } while(error);
        return fecha;
    }
     
    public static void difFechas(Date fechaInicial,Date fechaFinal ){  
         System.out.println("----------------------------------"); 
        long fechaInicialMs = fechaInicial.getTime();
        long fechaFinalMs = fechaFinal.getTime();
        
        long diferencia = fechaFinalMs - fechaInicialMs;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
        
        System.out.println(dias);
    }
     
    public static void UsandoCalendar() throws ParseException{
       
      // String fecha1 = "12/04/2020";  
       
        System.out.printf("¿Desde que fecha el préstamo?");
        Date fecha1 = pedirFecha();
 
  //Es importante que Dentro de las comillas los meses estén en mayúscula y
    // los días y años en minúscula  
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
       String fechaFormat=sdf.format(fecha1); 
       Date fechai = sdf.parse(fechaFormat);
       
       
       System.out.println("\n CALENDAR     SUMAR    DÍAS A una fecha");
       Calendar calendar=Calendar.getInstance();
       calendar.setTime(fechai);
        System.out.println("la FECHA del Préstamo es "+ calendar.getTime());
       calendar.add(Calendar.DAY_OF_YEAR,15);
       
        System.out.println("la FECHA de DEVOLUCIón es "+  (calendar.getTime()));
      
       
       System.out.println("\n CALENDAR 3 HORAS  EXAMEN");
       calendar=Calendar.getInstance();
       Date objDate_now = new Date(); 
       calendar.setTime(objDate_now);
        System.out.println("la FECHA y HORA INICIO del Examen son: "+ calendar.getTime());
       calendar.add(Calendar.HOUR,3);
       
        System.out.println("la HORA de ENTREGA es                : "+  (calendar.getTime()));
   
    }
    
    public static void en8() throws ParseException{
        //Mismos ejercicios que en el caso anterior
        System.out.printf("¿Desde que fecha?");
        LocalDate desde = pedirFechaEn8();

        System.out.printf("¿Hasta que fecha?");
        LocalDate hasta = pedirFechaEn8();
    
        //Period DesdeHata = desde.until(hasta);

        //También valdría lo siguiente (descomenta y comenta lo anterior)
        Period DesdeHata = Period.between(desde, hasta);

        int meses = DesdeHata.getMonths();
        int dias = DesdeHata.getDays();
        System.out.println("Faltan " + meses + " meses y " + dias + " días hasta fecha final."
        );
        
        //Suma y resta de periodos de tiempo
        System.out.printf("¿Desde que fecha el préstamo?");
        LocalDate fechaDsd = pedirFechaEn8();
        
        System.out.println("La fecha dentro de 15 días: " + fechaDsd.plusDays(15) );
        System.out.println("La fecha y hora de dentro de 3 horas: " + LocalDateTime.now().plusHours(3) );
    }
    
     public static LocalDate pedirFechaEn8() throws ParseException {
        LocalDate fecha = null;
        boolean error;

        BufferedReader LEE = new BufferedReader(new InputStreamReader(System.in));
        
        do {
                error=false;
                
                        System.out.printf("Fecha(dd/MM/yyyy): ");
            try {
                
                fecha = LocalDate.parse(LEE.readLine(), DateTimeFormatter.ofPattern("d/M/yyyy"));
            } catch (IOException ex) {
                Logger.getLogger(Calculos_DiasEntreFechas.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        } while(error);
        return fecha;
    }
}
