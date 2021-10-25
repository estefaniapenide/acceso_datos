/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java8;

import java.time.*;

/*
En marzo de 2014 apareció la versión estándar de Java 8 y con ella estas nuevas clases especializada

Este paquete java.time incluye muchas clases, pero las básicas son:

    LocalDate: representa a fechas sin la hora y nos facilita su manejo para declararlas, sumar y restar fechas y compararlas.
    LocalTime: es idéntica a la anterior pero para el manejo de horas, sin ninguna fecha asociada, pudiendo así compararlas, sumar o restar tiempo a las mismas...
    LocalDateTime: como puedes suponer, es una combinación de las dos anteriores, que permite hacer lo mismo con fechas y horas simultáneamente.
    Instant: es muy parecida a la anterior pero a la vez muy diferente. Se usa para almacenar un punto determinado en el tiempo, o sea con fecha y hora, pero guarda su valor como un timestamp de UNIX, es decir, en nanosegundos desde el epoch de UNIX (1/1/1970 a las 00:00) y usando la zona horaria UTC. Es muy útil para manejar momentos en el tiempo de manera neutra e intercambiarlo entre aplicaciones y sistemas, por lo que lo verás utilizado muy a menudo.
    ZonedDateTime: esta clase es como la LocalDateTime pero teniendo en cuenta una zona horaria concreta, ya que las anteriores no la tienen en cuenta.
    Period: esta clase auxiliar nos ayuda a obtener diferencias entre fechas en distintos periodos (segundos, minutos, días...) y también a añadir esas diferencias a las fechas.
    Duration: esta es muy parecida a la anterior pero para manejo de horas exclusivamente.

*/

/*
las de manejo de fechas y horas disponen de tres métodos importantes, que son:

    now(): crean instancias nuevas a partir de la fecha y hora actual.
    of(): construyen fechas y horas a partir de sus partes.
    with(): modifican la fecha u hora actual en función del parámetro que se le pase, con alguna cantidad (años, días, horas...) o alguna clase de ajuste
*/

import static Antes_Java8.Calculos_DiasEntreFechas.compararFechas;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author mrnovoa
 */
public class UsoJavaTime_ConTeoria {
     public static void main(String[] args){
         System.out.println("La fecha actual es: " + LocalDate.now());
        System.out.println( "La hora actual es: " + LocalTime.now() );
        System.out.println( "La fecha y hora actuales son: " + LocalDateTime.now() );
        System.out.println( "El instante actual es: " + Instant.now() );
        System.out.println( "La fecha y hora actuales con zona horaria son: " + ZonedDateTime.now() );

     //   Para controlar qué fechas y horas generamos podemos usar el método factoría of() que admite ciertos parámetros en función del tipo de dato utilizado. Por ejemplo:

System.out.println( "Fecha de mi cumpleaños: " + LocalDate.of(1918, Month.MAY, 23) );

/*
Es posible extraer cualquier parte de una fecha o una hora a través de los métodos getXXX() que ofrecen estas clases. Por ejemplo, getHour(), getMinute(), getMonth() o getDayOfWeek().
*/

/*
Según la clase que manejemos tendremos una serie de métodos para añadir o quitar intervalos al dato.

Por ejemplo, la clase LocalDate dispone de los métodos:

    plusDays() / minusDays(): para sumar o restar días a la fecha.
    plusWeeks() / minusWeeks(): ídem con semanas.
    plusMonths() / minusMonths(): para añadir o quitar meses.
    plusYears() / minusYears(): para sumar o restar años.

Del mismo modo LocalTime ofrece los métodos 
plusNanos(), plusSeconds(), plusMinutes() y plusHours() para sumar nanosegundos, segundos, minutos y horas a la hora actual respectivamente. Del mismo modo, tiene los mismos métodos, pero con el prefijo minus, para restarlas: minusNanos(), etc. Intuitivo y directo:
*/
System.out.println("La fecha dentro de 10 días: " + LocalDate.now().plusDays(10) );
System.out.println("La fecha y hora de hace 32 horas: " + LocalDateTime.now().minusHours(32) );


//para averiguar la fecha del primer día del mes que viene, podemos escribir:

System.out.println("El primer día del próximo mes es: " +
    LocalDate.now().with(
      TemporalAdjusters.firstDayOfNextMonth()
    ).getDayOfWeek() );
   
     
 //    O para saber la fecha del último día del mes actual:

System.out.println("El último día de este mes es: " +
    LocalDate.now().with(
      TemporalAdjusters.lastDayOfMonth() ));

     
     //Tiempo transcurrido entre fechas y horas
     
     /*
     obtener la diferencia entre dos fechas u horas, o sea, el tiempo transcurrido entre dos instantes de tiempo.

Para ello existe una interfaz java.time.temporal.TemporalUnit, 
     una enumeración ChronoUnit y un clase Period en ese mismo paquete que se encargan de facilitarnos la vida para esto. 
     Con sus métodos: between() y until() nos proporcionan respectivamente el tiempo transcurrido entre dos instantes de tiempo y el tiempo que falta para llegar a una fecha u hora determinadas. Vamos a verlo.

Por ejemplo, imaginemos que queremos saber cuánto tiempo ha transcurrido entre la fecha de tu nacimiento y el día de hoy. 
     Para averiguarlo sólo hay que hacer algo como esto:
     */
     
    LocalDate fNacimiento = LocalDate.of(1918, Month.MAY, 23);
System.out.println("Tu edad es de " +
  ChronoUnit.YEARS.between(fNacimiento, LocalDate.now())
  + " años."
); 

/*
ChronoUnit dispone de una serie de constantes que nos permiten obtener las unidades 
que nos interesen (que a su vez son también objetos de la clase ChronoUnit) y que, 
con su método between() nos permiten obtener el intervalo que nos interese. 
En este caso un número que representa la cantidad de años entre la fecha de mi nacimiento y el día de hoy, o sea, la edad.

Si quisiésemos, por ejemplo, saber cuánto tiempo falta para llegar a final de año, podemos sacar partido a la clase Period para lograrlo:
*/

LocalDate hoy = LocalDate.now();
LocalDate finDeAnio = hoy.with(TemporalAdjusters.lastDayOfYear());
Period hastaFinDeAnio = hoy.until(finDeAnio);
int meses = hastaFinDeAnio.getMonths();
int dias = hastaFinDeAnio.getDays();
System.out.println("Faltan " + meses + " meses y " + dias + " días hasta final de año."
);

/*
La clase Period también dispone del método estático between() para obtener el periodo entre dos elementos de tiempo, por lo que la línea 3 anterior se podría sustituir por esta:
*/

//Formatear fechas

//Las clases de java.time, por fortuna, ofrecen el método parse() que se ocupa de esto de manera trivial. Tiene dos sobrecargas, una que recibe la cadena a interpretar y, una segunda que además añade un formateador especializado si lo necesitamos:

hoy = LocalDate.parse("2021-03-15");
LocalDate seisNov = LocalDate.parse("6/11/2020", DateTimeFormatter.ofPattern("d/M/yyyy"));

LocalTime fechaConHora = LocalTime.now();
System.out.println("Formato por defecto: " + fechaConHora);
System.out.println("Formato ISO 8601 (explícito): " + fechaConHora.format(DateTimeFormatter.ISO_DATE_TIME));
DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
System.out.println("Formato español (manual): " + fechaConHora.format(esDateFormat));
 }
     
}
