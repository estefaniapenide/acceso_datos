/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipofutbol_mongo;

import POJO.FutbolistaNew;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import static equipofutbol_mongo.ListasFutbolistas.addFutbolistasNew;
import static equipofutbol_mongo.ListasFutbolistas.futbolistasNew;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author a20estefaniapc
 */
public class FutbolistasNew_Mongo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        addFutbolistasNew();

// PASO 1: Conexión al Server de MongoDB Pasandole el host y el puerto
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build())
        );
        MongoClient mongoClient = new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
        System.out.println("\nCONEXIÓN ESTABLECIDA CON EL SERVER");
// PASO 2: Conexión a la base de datos
        MongoDatabase db = mongoClient.getDatabase("equipo");
        System.out.println("\nCONEXIÓN ESTABLECIDA CON LA BASE DE DATOS 'equipo'");

// PASO 3: Obtenemos una coleccion para trabajar con ella
        MongoCollection<FutbolistaNew> collectionObj = db.getCollection("futbolistas", FutbolistaNew.class);
        System.out.println("\nCOLECCIÓN 'futbolistas' OBTENIDA");
        

// PASO 4: CRUD (Create-Read-Update-Delete)
        System.out.println("\nCRUD");
    // PASO 4.1: "CREATE" -> Metemos los objetos
        collectionObj.insertMany(futbolistasNew);
        
    // PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
        System.out.println("\nLeemos todos los documentos de la base de datos");
        List<FutbolistaNew> leerTodo = collectionObj.find().into(new ArrayList<FutbolistaNew>());
        //recorremos la lista
        for (int i = 0; i < leerTodo.size(); i++) {//mostramos los documentos
            System.out.println(" ---- " + leerTodo.get(i).toString());
        }

    // PASO 4.2.2: "READ" -> Hacemos una Query con condiciones
        System.out.println("\nHacemos una Query con condiciones: 'Visualizar los porteros'");
        List<FutbolistaNew> consulta = collectionObj.find(Filters.eq("demarcacion", "portero")).into(new ArrayList<FutbolistaNew>());
        //recorremos la lista
        for (int i = 0; i < consulta.size(); i++) {//mostramos los documentos
            System.out.println(" ---- " + consulta.get(i).toString());
        }
        if (consulta.isEmpty()) {
            System.out.println("No existe");
        }
        
        //Usando el cursor
        MongoCursor <FutbolistaNew> cursor =collectionObj.find(Filters.eq("demarcacion", "portero")).iterator();
        System.out.println("Usando Cursor");
        while(cursor.hasNext()) {
            FutbolistaNew doc = cursor.next();
            System.out.println(doc);
        }
        //cerramos el cursor
        cursor.close();
        
        //Si solo queremos obtener el primer elemento utilizamos el método first()
        //obtenermos el primer documento
        //FutbolistaNew doc = collectionObj.find().first();
        //System.out.println("Primer documento");
        //System.out.println(doc);
        
        System.out.println("\nHacemos una Query con condiciones: 'Contar número de futbolistas internacionales'");
        
        int contador=0;
        MongoCursor <FutbolistaNew> cursor4 =collectionObj.find(Filters.eq("internacional",true)).iterator();
        while(cursor4.hasNext()) {
            FutbolistaNew doc = cursor4.next();
            contador++;
        }
        //cerramos el cursor
        cursor.close();
        System.out.println("Futbolistas internacionales: "+contador);
        
        
        System.out.println("\nHacemos una Query con condiciones: 'Media de edad de los futbolistas'");
        
        int cont=0;
        int suma=0;
        List<FutbolistaNew> consulta8 = collectionObj.find().into(new ArrayList<FutbolistaNew>());
        //recorremos la lista
        for (int i = 0; i < consulta8.size(); i++) {
            suma= suma+ consulta8.get(i).getEdad();
            cont++;
        }
        if (consulta8.isEmpty()) {
            System.out.println("No existe");
        }
        
        float media=suma/cont;
        System.out.println("Media: "+media);
        
        
        /*System.out.println("\nHacemos una Query con condiciones: 'Media de edad de los futbolistas'");
        
        Document operacion = new Document("_id", "")
                .append("media", new Document("$avg", "$edad"));
        //creamos el documento con $group
        Document group = new Document("$group", operacion);
        //creamos la aggregation
        List <Document> lista2 = Arrays.asList(group);
        
        List<FutbolistaNew> cursor2 = collectionObj.aggregate(lista2).into(new ArrayList<FutbolistaNew>());
        for (int i = 0; i < cursor2.size(); i++) {//mostramos los documentos
            System.out.println(" ---- " + cursor2.get(i).toString());
        }
        if (cursor2.isEmpty()) {
            System.out.println("No existe");
        }
        
        
       /* MongoCursor <FutbolistaNew> cursor2 = collectionObj.aggregate(lista2).iterator();
       // System.out.println("Calcular la suma y la nota media agrupada por curso.");
        //recorremos el cursor
        while(cursor2.hasNext()) {
            FutbolistaNew alumno = cursor2.next();
            System.out.println(alumno);
        }
        cursor2.close();*/
        
        
        System.out.println("\nHacemos una Query con condiciones: 'Visualizar futbolistas mayores de 22 años'");
        //Usando el cursor
        MongoCursor <FutbolistaNew> cursor3 =collectionObj.find(Filters.gt("edad", 22)).iterator();
        while(cursor3.hasNext()) {
            FutbolistaNew doc = cursor3.next();
            System.out.println(doc);
        }
        //cerramos el cursor
        cursor.close();
        
    // PASO 4.3: "UPDATE" -> Actualizamos
        System.out.println("\nActualizamos: 'Todos los porteros serán internacionales'");
         //creamos el documento para la busqueda de los porteros
        Document findDocument1 = new Document("demarcacion", "portero");
        //creamos el documento para la actualizacion
        Document updateDocument1 = new Document("$set", new Document("internacional", true));
        //ejecutamos la actualizacion
        UpdateResult update = collectionObj.updateMany(findDocument1,updateDocument1);
        
        //Mostramos el update
        List<FutbolistaNew> consulta2 = collectionObj.find(Filters.eq("demarcacion", "portero")).into(new ArrayList<FutbolistaNew>());
        //recorremos la lista
        for (int i = 0; i < consulta2.size(); i++) {//mostramos los documentos
            System.out.println(" ---- " + consulta2.get(i).toString());
        }
        if (consulta2.isEmpty()) {
            System.out.println("No existe");
        }
        
        
    // PASO 4.4: "DELETE" -> Borramos
        System.out.println("\nBorramos: 'Todos los delanteros'");
        //creamos el documento para la busqueda de todos los documentos
        Document findDocument2 = new Document("demarcacion", "delantero");
        DeleteResult deleteResult1 = collectionObj.deleteMany(findDocument2);
        
        //collectionObj.findOneAndDelete(Filters.eq("demarcacion","portero"));

// PASO FINAL: Cerrar la conexión

    }
}
