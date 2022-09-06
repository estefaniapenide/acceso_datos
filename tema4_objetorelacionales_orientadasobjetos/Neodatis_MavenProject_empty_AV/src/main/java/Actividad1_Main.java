/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mrnov
 */
import clases.Jugadores;
import clases.Paises;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

//Principal 
public class Actividad1_Main {//CREACIÓN Y LLENADO DE BD

//Creacion y relleno de las clases en la bd db4o
    public static void main(String[] args) {
        //Instancias de paises para almacenar en la DB:
        Paises pais1 = new Paises(1, "España");
        Paises pais2 = new Paises(2, "Italia");
        Paises pais3 = new Paises(3, "Suiza");
        Paises pais4 = new Paises(4, "EEUU");
        //instancias de jugadores para almacenar en BD
        Jugadores j1 = new Jugadores("Maria", "voleibol", pais1, 14);
        Jugadores j2 = new Jugadores("Miguel", "tenis", pais2, 15);
        Jugadores j3 = new Jugadores("Mario", "baloncesto", pais3, 15);
        Jugadores j4 = new Jugadores("Alicia", "tenis", pais4, 14);
        /*La conexión la realizo con un objeto de clase ODB,
    en la que indico la ruta donde tengo la base de datos.
    Esto sirve para abrirla como para crear una nueva*/
//    ODB odb = ODBFactory.open("C:\\bds\\EQUIPOS.DB");

        ODB odb = ODBFactory.open("EQUIPOS.DB");
        //Almaceno los objetos en la BD
//    odb.store (j1);
//    odb.store (j2);
//    odb.store (j3);
//    odb.store (j4);

        //recupero todos los objetos
        Objects objectsJug = odb.getObjects(Jugadores.class);
        // Genero un conjunto de objetos y los traigo del ODB conectado
        // Objects<Jugadores> objectsJug=odb.getObjects(Jugadores.class);

        System.out.println("Hay " + objectsJug.size() + " Jugadores en la BD:");

        // JUGADORES
        int i = 1; //contador para mostrar listados los objetos

        //visualizar los objetos Jugador
        while (objectsJug.hasNext()) {
            // Creo un objeto Jugadores y almaceno ahí el objeto que recupero de la BD
            Jugadores jug = (Jugadores) objectsJug.next();
            // Imprimo las propiedades que me interesan de ese objeto
            System.out.println((i++) + " - " + "Nombre: " + jug.getNombre() + ", Deporte: " + jug.getDeporte() + ", Pais: " + jug.getPais().getNombrePais() + ", Edad: " + jug.getEdad());
        }

        //recupero todos los objetos Paises de la BD
        Objects objectsPaises = odb.getObjects(Paises.class);

        System.out.println("Hay " + objectsPaises.size() + " Paises en la BD:");

        //PAISES
        int j = 1; //contador para mostrar listados los objetos
        //visualizar los objetos
        while (objectsPaises.hasNext()) {
            // Creo un objeto Paises y almaceno ahí el objeto que recupero de la BD
            Paises pais = (Paises) objectsPaises.next();
            // Imprimo las propiedades que me interesan de ese objeto
            System.out.println((j++) + " - " + "ID: " + pais.getId() + ", Pais: " + pais.getNombrePais());
        }

        IQuery queryTenis = new CriteriaQuery(Jugadores.class, Where.equal("deporte", "tenis"));
        queryTenis.orderByAsc("nombre,edad");
        Objects<Jugadores> listaTenis = odb.getObjects(queryTenis);
        System.out.println("HAY " + listaTenis.size() + " JUGADORES DE TENIS:");
        int k = 1;
        while (listaTenis.hasNext()) {
            Jugadores jugadortenis = (Jugadores) listaTenis.next();
            System.out.println((k++) + " - " + "Nombre: " + jugadortenis.getNombre() + ", Deporte: " + jugadortenis.getDeporte());
        }

        ICriterion criterioEdad14 = Where.equal("edad", 14);
        IQuery queryEdad14 = new CriteriaQuery(Jugadores.class, criterioEdad14);
        queryEdad14.orderByAsc("nombre");
        Objects<Jugadores> listaEdad14 = odb.getObjects(queryEdad14);
        System.out.println("HAY " + listaEdad14.size() + " JUGADORES DE 14 AÑOS:");
        int m = 1;
        while (listaEdad14.hasNext()) {
            Jugadores jugadoredad14 = (Jugadores) listaEdad14.next();
            System.out.println((m++) + " - " + "Nombre: " + jugadoredad14.getNombre() + ", Edad: " + jugadoredad14.getEdad());
        }

        ICriterion criterioEEUUTenis = new And().add(Where.equal("pais.nombrePais", "EEUU"))
                .add(Where.equal("deporte", "tenis"));
        IQuery queryEEUUTenis = new CriteriaQuery(Jugadores.class, criterioEEUUTenis);
        queryEEUUTenis.orderByAsc("nombre");
        Objects<Jugadores> listaEEUUTenis = odb.getObjects(queryEEUUTenis);
        if (listaEEUUTenis.size() == 0) {
            System.out.println("NO HAY JUGADORES DE TENIS DE EEUU");
        } else {
            System.out.println("HAY " + listaEEUUTenis.size() + " JUGADORES DE EEUU DE TENIS:");
            int r = 1;
            while (listaEEUUTenis.hasNext()) {
                Jugadores jugadorEEUUTenis = (Jugadores) listaEEUUTenis.next();
                System.out.println((r++) + " - " + "Nombre: " + jugadorEEUUTenis.getNombre() + ", País: " + jugadorEEUUTenis.getPais() + ", Deporte: " + jugadorEEUUTenis.getDeporte());
            }
        }

        ICriterion criterio14yESoIToFR = new And().add(Where.equal("edad", 14))
                .add(new Or().add(Where.equal("pais.nombrePais", "España"))
                        .add(Where.equal("pais.nombrePais", "Italia"))
                        .add(Where.equal("pais.nombrePais", "Francia")));
        IQuery query14yESoIToFR = new CriteriaQuery(Jugadores.class, criterio14yESoIToFR);
        query14yESoIToFR.orderByAsc("nombre");
        Objects<Jugadores> lista14yESoIToFR = odb.getObjects(query14yESoIToFR);
        if (lista14yESoIToFR.size() == 0) {
            System.out.println("NO HAY JUGADORES DE 14 AÑOS DE ESPAÑA, ITALIA O FRANCIA");
        } else {
            System.out.println("HAY " + lista14yESoIToFR.size() + " JUGADORES 14 AÑOS DE ESPAÑA, ITALIA O FRANCIA:");
            int r = 1;
            while (lista14yESoIToFR.hasNext()) {
                Jugadores jugador14yESoIToFR = (Jugadores) lista14yESoIToFR.next();
                System.out.println((r++) + " - " + "Nombre: " + jugador14yESoIToFR.getNombre() + ", Edad: " + jugador14yESoIToFR.getEdad() + ", País: " + jugador14yESoIToFR.getPais());
            }
        }

        Values values = odb.getValues(new ValuesCriteriaQuery(Jugadores.class,
                new And().add(Where.equal("pais.nombrePais", "Italia"))
                        .add(Where.equal("edad", 15)))
                .field("nombre")
                .field("deporte"));
        if (values.size() == 0) {
            System.out.println("NO HAY JUGADORES DE 15 AÑOS DE ITALIA");
        } else {
            System.out.println("HAY " + values.size() + " JUGADORES DE 15 AÑOS DE ITALIA:");
            int p = 1;
            while (values.hasNext()) {
                ObjectValues jugador = (ObjectValues) values.nextValues();
                System.out.println((p++) + " - " + "Nombre: " + jugador.getByAlias("nombre") + ", Deporte: " + jugador.getByAlias("deporte"));
            }
        }

        //Obtener la suma de las edades
        Values v1 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad"));
        ObjectValues ov1 = (ObjectValues) v1.nextValues();
        BigDecimal valor1 = (BigDecimal) ov1.getByAlias("edad");
        System.out.println("Suma total de edades: " + valor1.longValue());

        //Obtener el número de jugadores
        Values v2 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).count("nombre"));
        ObjectValues ov2 = (ObjectValues) v2.nextValues();
        BigInteger valor2 = (BigInteger) ov2.getByAlias("nombre");
        System.out.println("Número de jugadores: " + valor2.intValue());

        //Obtener la edad media de los jugadores
        Values v3 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).avg("edad"));
        ObjectValues ov3 = (ObjectValues) v3.nextValues();
        BigDecimal valor3 = (BigDecimal) ov3.getByAlias("edad");
        System.out.println("Edad media de los jugadores: " + valor3.floatValue());

        //Obtener la edad máxima de los jugadores
        Values v4 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).max("edad", "edad_max"));//Se le puede poner un alias en el segundo parametro
        ObjectValues ov4 = (ObjectValues) v4.nextValues();
        BigDecimal valor4 = (BigDecimal) ov4.getByAlias("edad_max");
        System.out.println("Edad del jugador más mayor: " + valor4.floatValue());

        //Obtener la edad mínima de los jugadores
        Values v5 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad"));
        ObjectValues ov5 = (ObjectValues) v5.nextValues();
        BigDecimal valor5 = (BigDecimal) ov5.getByIndex(0);
        System.out.println("Edad del jugador más joven: " + valor5.floatValue());

        //Obtener  Contador, edadMax, edadMin, SumaEdades por país
        Values v6 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("pais.nombrePais").sum("edad").groupBy("pais.nombrePais"));
        while (v6.hasNext()) {
            ObjectValues ov6 = (ObjectValues) v6.nextValues();
            BigDecimal valor6 = (BigDecimal) ov6.getByAlias("edad");
            String pais = (String) ov6.getByAlias("pais.nombrePais");
            System.out.println(pais + " : " + valor6.floatValue());
        }

        //Actulaizar la edad del jugador por país -> Los jugadores de españa tendrán 2 años más
        IQuery query = new CriteriaQuery((Jugadores.class), Where.equal("pais.nombrePais", "España"));
        Objects obj = odb.getObjects(query);
        while (obj.hasNext()) {
            Jugadores jug = (Jugadores) obj.next();
            int edad_antigua = jug.getEdad();
            int edad_nueva = edad_antigua + 2;
            jug.setEdad(edad_nueva);
            odb.store(jug);
        }
        odb.commit();

        odb.close(); //Cerrar BD
    }

}
