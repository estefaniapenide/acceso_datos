//Usa JS
//el prompt muestre el nombre de la base de datos activa, esto lo logramos asignando la siguiente función:

prompt = function() {
  return db+"> ";
};

//Podemos utilizar la funcionalidad de JavaScript en el shell de MongoDB para poblar una colección con datos de prueba por //ejemplo:

use base1
db.articulos.drop()
for(i = 1; i <= 10; i++) {
  db.articulos.insertOne(
    {
      _id: i,  
      nombre: 'nombre'+i
    }
  );
}
db.articulos.find().pretty();

//Podemos desplegar el código JavaScript de cada método visto en conceptos anteriores simplemente indicando su nombre desde //el shell:

use base1
db.articulos.insertOne