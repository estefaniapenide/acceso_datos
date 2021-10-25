/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java8;

/**
 *
 * @author mrnovoa
 */
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.Locale;

class Ejemplos_8_JavaTime {
  
  //Cambio OUTPUT
   /*
    tools->options->miscellaneous->output
    */
  
    //Constantes para escribir a otro color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_GREEN = "\u001B[32m";
  
    //public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    //public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    //public static final String ANSI_WHITE = "\u001B[37m";

    public static final String FBLANCO = "\u001b[40m";
    public static final String FROJO = "\u001b[41m";
    public static final String FVERDE = "\u001b[42m";
    public static final String FAMARILLO = "\u001b[43m";
    public static final String FAZUL = "\u001b[44m";
    public static final String FMAGENTA = "\u001b[45m";
    public static final String FCYAN = "\u001b[46m";
    public static final String FGRIS = "\u001b[47m";
    public static final String CNFB = "\u001b[30;40m";

  public static void main(String[] args) {

    
    //Uso del método now() en varias de estas clases
    System.out.println(FGRIS + "Uso del metodo now():" + ANSI_RESET);
    //Fecha local, referenciándola en una variable
    System.out.println("La fecha actual es: " + LocalDate.now());
    //Hora local, uso directo
    System.out.println( "La hora actual es: " + LocalTime.now() );
    //Fecha y hora locales
    System.out.println( "La fecha y hora actuales son: " + LocalDateTime.now() );
    //Instante en el tiempo
    System.out.println( "El instante actual es: " + Instant.now() );
    //Fecha y hora con zona horaria
    System.out.println( "La fecha y hora actuales con zona horaria son: " + ZonedDateTime.now() );


    //Uso del método factoría of()
    System.out.println(ANSI_BLUE + "\nUso del metodo factoría of():" + ANSI_RESET);
    System.out.println( "Fecha de mi cumpleaños: " + LocalDate.of(1972, Month.MAY, 23) );
    System.out.println( "Con la hora exacta: " + LocalDateTime.of(1972, Month.MAY, 23, 20, 01, 15, 0023) );
    //Produce un error porque 2019 no fue un año bisiesto (descomenta para probar)
    //System.out.println( "Día bisiesto de 2019: " + LocalDate.of(2019, Month.FEBRUARY, 29) );

    //Transformando fechas y horas
    System.out.println(ANSI_RED + "\nSuma y resta de periodos de tiempo:" + ANSI_RESET);
    //Suma y resta de periodos de tiempo
    System.out.println("La fecha dentro de 10 días: " + LocalDate.now().plusDays(10) );
    System.out.println("La fecha y hora de hace 32 horas: " + LocalDateTime.now().minusHours(32) );


    //Ajustadores
    System.out.println(FMAGENTA + "\nUso de ajustadores:" + ANSI_RESET);
    System.out.println("El primer día del próximo mes es: " + 
        LocalDate.now().with(
          TemporalAdjusters.firstDayOfNextMonth()
        ).getDayOfWeek() );
    System.out.println("El último día de este mes es: " + 
        LocalDate.now().with(
          TemporalAdjusters.lastDayOfMonth() ));

    //Intervalos de tiempo
    /*
    la diferencia entre dos fechas u horas, o sea, el tiempo transcurrido entre dos instantes de tiempo.

Para ello existe una interfaz java.time.temporal.TemporalUnit, 
    una enumeración ChronoUnit y un clase Period 
    en ese mismo paquete que se encargan de facilitarnos la vida para esto. 
    Con sus métodos: ChronoUnit-between() y Period-until() nos proporcionan respectivamente 
    el tiempo transcurrido entre dos instantes de tiempo y 
    el tiempo que falta para llegar a una fecha u hora determinadas. 
    */
    
    
    System.out.println(ANSI_CYAN + "\nIntervalos de tiempo:" + ANSI_RESET);
    LocalDate fNacimiento = LocalDate.of(1918, Month.MAY, 23);
    System.out.println("Mi edad es de " +  
      ChronoUnit.YEARS.between(fNacimiento, LocalDate.now())
      + " años."
    );
    
    //Periodos
    LocalDate hoy = LocalDate.now();
    LocalDate finDeAnio = hoy.with(TemporalAdjusters.lastDayOfYear());
    Period hastaFinDeAnio = hoy.until(finDeAnio);
    
    //También valdría lo siguiente (descomenta y comenta lo anterior)
    //Period hastaFinDeAnio = Period.between(hoy, finDeAnio);
    
    int meses = hastaFinDeAnio.getMonths();
    int dias = hastaFinDeAnio.getDays();
    System.out.println("Faltan " + meses + " meses y " + dias + " días hasta final de año."
    );

    //Parseando fechas
    System.out.println(ANSI_PURPLE + "\nParseado de fechas:" + ANSI_RESET);
    //Formato ISO 8601
    LocalDate fecha1 = LocalDate.parse("2020-07-06");
    System.out.println("Fecha parseada: " + fecha1);
    //Con hora + uso de método getXXX()
    LocalDateTime fechaConHora = LocalDateTime.parse("2020-07-06T20:40:15");
    System.out.println("Día de la semana de la fecha parseada: " + fechaConHora.getDayOfWeek());
    //Parseando un formato personalizado
    LocalDate seisNov = LocalDate.parse("6/11/2020", DateTimeFormatter.ofPattern("d/M/yyyy") );
    System.out.println("Fecha parseada en formato español: " + seisNov);

    //Formato personalizado de conversión a texto
    System.out.println(ANSI_GREEN + "\nFormato personalizado de conversión a texto:" + ANSI_RESET);
    System.out.println("Formato por defecto: " + fechaConHora);
    System.out.println("Formato ISO 8601 (explícito): " + fechaConHora.format(DateTimeFormatter.ISO_DATE_TIME));
    
    DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
    System.out.println("Formato español (manual): " + fechaConHora.format(esDateFormat));
    
    DateTimeFormatter esDateFormatLargo = 
    DateTimeFormatter
      .ofPattern("EEEE, dd 'de' MMMM 'de' yyyy 'a las' hh:mm:ss")
      .withLocale(new Locale("es", "ES"));
    System.out.println("Formato español (largo, localizado): " + fechaConHora.format(esDateFormatLargo));

    String idiomaLocal = System.getProperty("user.language");
    String paisLocal = System.getProperty("user.country");
    System.out.println("Formato actual del sistema (" + idiomaLocal + "-" + paisLocal + "): " + 
      fechaConHora.format(
        //Nota: LONG o FULL no funcionan por ser un dato sin zona horaria
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
          .withLocale(
            new Locale(idiomaLocal, paisLocal)
          )
        )
      );
  }
}
