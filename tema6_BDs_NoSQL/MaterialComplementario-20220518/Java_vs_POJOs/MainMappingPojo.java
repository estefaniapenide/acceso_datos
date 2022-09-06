package MongoJava_ejemplo;

//import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
//import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
/*import static com.mongodb.client.model.Filters.gte;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
        */
import static com.mongodb.client.model.Updates.addToSet;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.inc;
//import static com.mongodb.client.model.Updates.push;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;

public class MainMappingPojo {

    public static void main(String args[]) {
        //Creación del listado 
        ArrayList<FutbolistaNew> futbolistas = new ArrayList<FutbolistaNew>();

        futbolistas.add(new FutbolistaNew("Iker", "Casillas", 33, new ArrayList<String>(Arrays.asList("Portero")), true,1));
        futbolistas.add(new FutbolistaNew("Carles", "Puyol", 36, new ArrayList<String>(Arrays.asList("Central", "Lateral")), true,2));
        futbolistas.add(new FutbolistaNew("Sergio", "Ramos", 28, new ArrayList<String>(Arrays.asList("Lateral", "Central")), true,3));
        futbolistas.add(new FutbolistaNew("Andrés", "Iniesta", 30, new ArrayList<String>(Arrays.asList("Centrocampista", "Delantero")), true,4));
        futbolistas.add(new FutbolistaNew("Fernando", "Torres", 30, new ArrayList<String>(Arrays.asList("Delantero")), true,5));
        futbolistas.add(new FutbolistaNew("Leo", " Baptistao", 22, new ArrayList<String>(Arrays.asList("Delantero")), false,6));

        Bson filterU, filterD;
        UpdateResult updateResult;
        DeleteResult result;
        
        JsonWriterSettings prettyPrint = JsonWriterSettings.builder().indent(true).build();
        //toJson(prettyPrint);
        
    try //( // PASO 1: Conexión al Server de MongoDB Pasandole el host y el puerto
            //MongoClient cliente = new MongoClient("localhost", 27017)) 
    {
        //Gestión del CodecRegistry para hacer uso de los objetos definidos
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries
        (MongoClient.getDefaultCodecRegistry(),
        CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            // PASO 2.1: Conexión con el servidor Mongo
            try (MongoClient cliente = new MongoClient("localhost", 
                    MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build())) {
                // PASO 2.2: Conexión a la base de datos
                MongoDatabase db = cliente.getDatabase("Futbol");
                
                // PASO 3: Obtenemos una coleccion para trabajar con ella
                MongoCollection<Document> FutCollection = db.getCollection("Futbolistas1");
                MongoCollection<FutbolistaNew> collectionObj = db.getCollection("Futbolistas1",FutbolistaNew.class);
                // PASO 4: CRUD (Create-Read-Update-Delete)
                // PASO 4.1: "CREATE" -> Metemos los objetos futbolistas (o documentos en Mongo) en la coleccion Futbolista
        for (FutbolistaNew fut : futbolistas) {
            collectionObj.insertOne(fut);
        }
        
       //Con CodecRegistry 
       //FutCollection.insertMany(Arrays.asList(futbolistas));

        // PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
        int numDocumentos2 = (int) FutCollection.countDocuments();
        int numDocumentos = (int) collectionObj.countDocuments();

        System.out.println("Número de documentos en la colección Futbolistas3: " + numDocumentos +" - "+ numDocumentos2 + "\n");

        // Busco todos los documentos de la colección y los imprimo
        ArrayList<FutbolistaNew> futbolistasCol = collectionObj.find().into(new ArrayList<>());
        Iterator it = futbolistasCol.iterator();

        System.out.println("futbolistasList Futbolista list with an ArrayList-Futbolista-while:");
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }

        // find a list of documents and use a List object instead of an iterator
        List<Document> futbolistasList = FutCollection.find().into(new ArrayList<>());

        System.out.println("futbolistasList Document list with an ArrayList-Document-for:");
        for (Document fut : futbolistasList) {
            System.out.println(fut.toJson());
        }

        System.out.println("futbolistasList Document list with LambdaExp-forEach:");
        //Lambda Expression
        futbolistasList.forEach(fut -> System.out.println(fut.toJson()));
            
        // PASO 4.2.2: "READ" -> Hacemos una Query con condiciones
        //(Buscar Futbolistas que sean delanteros) y lo pasamos a un objeto Java
        System.out.println("\nFutbolistas que juegan en la posición de Delantero");

        FindIterable iterable = collectionObj.find(eq("demarcacion", "Delantero"));
        //MongoCursor<Document> cursor = iterable.iterator();
        Iterator it2= iterable.iterator();

        System.out.println("Futbolista Delantero list without a cursor: ");
        while (it2.hasNext()) {
            System.out.println(it2.next().toString());
        }

        // PASO 4.3: "UPDATE" -> Actualizamos la edad de los jugadores.
        //Sumamos 100 años a los jugadores que tengan mas de 30 años

        //Encontrar el primero de 30 años
        FutbolistaNew futbolista = collectionObj.find(gt("edad", 30)).first();
        //FutbolistaNew futbolista = FutCollection.find(gt("edad", 30)).first();
        
        System.out.println("Futballer first found:\t" + futbolista);

        FindIterable iterable2 = collectionObj.find(gt("edad", 30));
        //MongoCursor<Document> cursor2 = iterable2.iterator();
        Iterator it3= iterable2.iterator();
        System.out.println("Futbolista list without a cursor1: ");
        while (it3.hasNext()) {
            System.out.println(it3.next().toString());
        }

        ArrayList<FutbolistaNew> futbolistasCol2 = collectionObj.find(gt("edad", 30)).into(new ArrayList<>());
        Iterator it4 = futbolistasCol2.iterator();
        System.out.println("Futbolista >30 list without a cursor2: ");
        while (it4.hasNext()) {
            System.out.println(it4.next().toString());
        }

        ArrayList<FutbolistaNew> futbolistasMas30 = collectionObj.find(gt("edad", 30)).into(new ArrayList<>());
        //System.out.println("futbolistasList Futbolista list with an ArrayList-FutbolistaMas30-while:");
        for(FutbolistaNew fut: futbolistasMas30){
            fut.setEdad(fut.getEdad()+100);
        }

        Iterator itMas30 = futbolistasMas30.iterator();
        System.out.println("futbolistasList Futbolista list with an ArrayList-FutbolistaMas30+100-while:");
        while (itMas30.hasNext()) {
            System.out.println(itMas30.next().toString());
        }
        
        //update many documents
        //Sin/con CodecRegistry
        filterU = gt("edad", 30);
               
        //The same way I was able to update one document with updateOne(), I can update multiple documents with updateMany()
        
        Bson update1 = inc("edad", 100); // increment x by 10. As x doesn't exist yet, x=10.
        Bson update5 = addToSet("comments", "This comment is uniq"); // using addToSet so no effect.
        Bson updates = combine(update1, update5);
        

        System.out.println("\n=> Updating all the documents with {\"edad\">30}.");
        
          //codecRegistry
          updateResult = collectionObj.updateMany(filterU, updates);
          
          //updateResult = FutCollection.updateMany(filterU, updates);
          
        // PASO 4.4: "DELETE" -> Borramos todos los futbolistas que sean internacionales (internacional = true)
        //MongoCollection<Futbolista> collectionD = db.getCollection("Futbolistas",Futbolista.class);
        FindIterable iterable3 = FutCollection.find(eq("internacional", true));

        Iterator it5= iterable3.iterator();
        System.out.println("Futbolista internacional list without a cursor: ");
        while (it5.hasNext()) {
            System.out.println(it5.next().toString());
        }   

          
        // delete many documents
        
            filterD = eq("internacional", true);
            //Sin CodecRegistry
            //result = FutCollection.deleteMany(filterD);
            //codecRegistry
            result = collectionObj.deleteMany(filterD);
            
            // result = FutCollection.deleteMany(filterD);
            System.out.println("\n=> Updating all the documents with{\"international\"true}.");
            //System.out.println(result);
           
        } 
           
        }
        finally{
    
        }
    
    /*BÚSQUEDAS
    Operadores de comparación: eq, gt, gte, lt, lte, ne, in, nin
    Operadores lógicos: or, and, not
    */
    
    /*MODIFICACIONES
    I also used this example to show you a bunch of update operators:

    Upsert
An upsert is a mix between an insert operation and an update one. It happens when you want to update a document, assuming it exists, but it actually doesn't exist yet in your database.
     the static method Updates.push() to push a new value in my array comments which does not exist yet, so I'm creating an array of one element in this case.
    updateOperation = push("comments", "You will learn a lot if you read the MongoDB blog!");
    UpdateOptions options = new UpdateOptions().upsert(true);
    updateResult = gradesCollection.updateOne(filter, updateOperation, options);
    
    set will set a value,
    inc will increment a value,
    rename will rename a field,
    mul will multiply the value by the given number,
    addToSet is similar to push but will only push the value in the array if the value doesn't exist already.
    
    */

    }
    
}
