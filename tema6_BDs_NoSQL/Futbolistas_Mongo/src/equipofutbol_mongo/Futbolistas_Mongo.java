/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipofutbol_mongo;

import POJO.Futbolista;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import static equipofutbol_mongo.ListasFutbolistas.addFutbolistas;
import static equipofutbol_mongo.ListasFutbolistas.futbolistas;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author a20estefaniapc
 */
public class Futbolistas_Mongo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        addFutbolistas();

//PASO 1:cONEXIÓN AL SERVER DE MongoDB pasandole el host al puerto
        MongoClient mongoClient = new MongoClient("localhost", 27017);

// PASO 2: Conexión a la base de datos
        DB db = mongoClient.getDB("equipo");

// PASO 3: Obtenemos una coleccion para trabajar con ella
        DBCollection collection = (DBCollection) db.getCollection("futbolistas");

// PASO 4: CRUD (Create-Read-Update-Delete)
        
        // PASO 4.1: "CREATE" -> Metemos los objetos
        List<BasicDBObject> futbolistasDBObject = new ArrayList<BasicDBObject>();
        for (Futbolista futb : futbolistas) {
            futbolistasDBObject.add(futb.toDBObjectFutbolista());
        }
        collection.insert(futbolistasDBObject);

        //Usando Document como en centroeducativo:
        
        // PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
        // PASO 4.2.2: "READ" -> Hacemos una Query con condiciones
        // PASO 4.3: "UPDATE" -> Actualizamos
        // PASO 4.4: "DELETE" -> Borramos
        // PASO FINAL: Cerrar la conexión
    }

}
