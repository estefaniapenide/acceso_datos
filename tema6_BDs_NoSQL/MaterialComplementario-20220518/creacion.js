db.articulos.drop()
for(i = 1; i <= 10; i++) {
  db.articulos.insertOne(
    {
      _id: i,  
      nombre: 'nombre'+i
    }
  )
}

//para ejecutar, en la consola:
//load("c:\\ubicacion\\..\\creacion.js")

//comprobacion funcionamiento en consola
//db.articulos.find().pretty()

cursor = db.articulos.find();
while ( cursor.hasNext() ) {
   printjson(cursor.next());
}