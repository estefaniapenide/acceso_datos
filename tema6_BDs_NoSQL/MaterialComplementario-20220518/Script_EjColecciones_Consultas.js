db.getCollection("amigosfile").find({})

-------------------------------------------------------
--Colección amigos

use mibasedatos;
db.amigos.drop();
Amigo1={nombre:'Ana',teléfono:545656885,curso:'1DAM', nota:7};
Amigo2={nombre:'Marleni',teléfono:3446500,curso:'1DAM',nota:8};
db.amigos.save(Amigo1);
db.amigos.save(Amigo2);
db.amigos.insert({nombre:'Juanito', teléfono:55667788,curso:'2DAM', nota:6 });
db.amigos.find();

//-------------------------------------------------------
//Colección libros:
db.libros.drop();
db.libros.insert({codigo:1,nombre:"Acceso a datos", pvp: 35, editorial:"Garceta", temas:["Base de datos", "Hibernate","Neodatis"]})
db.libros.insert({codigo:2,nombre:"Entornos de desarrollo", pvp: 27, editorial:"Garceta", temas:["UML", "Subversión", "ERMaster"]})
db.libros.insert({codigo:3,nombre:"Programación de Servicios", pvp: 25,  editorial:"Garceta", temas:["SOCKET", "Multihilo"]})
db.libros.find();

//-------------------------------------------------------
//Colección artículos:
db.articulos.drop();
db.articulos.insert({código:1,denominación:"Portatil Acer", pvp: 500, categoría:"Informática", uv:10, stock: 20})
db.articulos.insert({código:2,denominación:"Pala Pádel", pvp: 100, categoría:"Deportes", uv:5, stock: 30})
db.articulos.insert({código:3,denominación:"Caja Lápices", pvp: 6, categoría:"Escritorio", uv:10, stock: 6})
db.articulos.insert({código:4,denominación:"Marcadores", pvp: 10, categoría:"Escritorio", uv:20, stock: 19})
db.articulos.insert({código:5,denominación:"Memoria 32GB", pvp: 120, categoría:"Informática", uv:8, stock: 10})
db.articulos.insert({código:6,denominación:"Micro Intel", pvp: 150, categoría:"Informática", uv:4, stock: 10})
db.articulos.insert({código:7,denominación:"Bolas Pádel", pvp: 5, categoría:"Deportes", uv:15, stock: 30})
db.articulos.insert({código:8,denominación:"Falda Pádel", pvp: 15, categoría:"Deportes", uv:10, stock: 10})
db.articulos.find()


//-------------------------------------------------------
//Creo colecciones emple y depart, cada elemento con su _id manual.
//Colección emple, con 4 empleados.
db.emple.drop();
db.emple.insert({_id:'emp1',nombre:"Juan", salario:1000, fechaalta:"10/10/1999"})
db.emple.insert({_id:'emp2',nombre:"Alicia", salario:1400, fechaalta:"07/08/2000", oficio: "Profesora"})
db.emple.insert({_id:'emp3',nombre:"María Jesús", salario:1500, fechaalta: "05/01/2005", oficio: "Analista", comisión:100})
db.emple.insert({_id:'emp4',nombre:"Alberto", salario:1100, fechaalta:"15/11/2001"})
db.emple.find();

//Colección depart con dos departamentos, asignamos los dos primeros //empleados al primer departamento, y al segundo el resto de emple
db.depart.drop();
db.depart.insert({_id:'dep1',nombre:"Informática",loc:'Madrid', emple:['emp1', 'emp2']})
db.depart.insert({_id:'dep2',nombre:"Gestión",loc:'Talavera', emple:['emp3', 'emp4' ]})
db.depart.find()

-------------------------------------------------------
--Colección Trabajadores
db.trabajadores.drop();
db.trabajadores.insert({nombre: {nomb:"Alicia",ape1:"Ramos", ape2:"Martín"},
                        direccion: {población: "Madrid", calle : "Avda Toledo 10"},
						salario: 1200,
						oficios:["Profesora", "Analista"],
						primas: [20,30,40],
						edad:50
						})
						
db.trabajadores.insert({nombre: {nomb:"Juan",ape1:"Gil", ape2:"Sánchez"},
                        direccion: {población: "Madrid", calle : "Mayor 12"},
						salario: 1400,
						oficios:["Programador", "Analista"],
						primas: [120,130,40],
						edad: 30
						})

db.trabajadores.insert({nombre: {nomb:"Raquel",ape1:"García", ape2:"del Amo"},
                        direccion: {población: "Toledo", calle : "Ocaña 22"},
						salario: 1500,
						oficios:["Profesor"],
						primas: [60, 30, 80],
						edad: 45
						})
db.trabajadores.insert({nombre: {nomb:"Fernando",ape1:"Romo", ape2:"Pérez"},
                        direccion: {población: "Talavera", calle : "Las cañas 2"},
						salario: 1300,
						oficios:["Profesor", "Representante"],
						edad: 43
						})
db.trabajadores.insert({nombre: {nomb:"María",ape1:"Suárez", ape2:"Verdes"},
                        direccion: {población: "Toledo", calle : "Av Madrid 32"},
						salario: 1600,
						oficios:["Profesor", "Contable"],
						primas: [30, 70, 80],
						edad: 55
						})	

db.trabajadores.insert({nombre: {nomb:"Santiago",ape1:"Gómez", ape2:"Corregidor"},
                        direccion: {población: "Toledo", calle : "Av Madrid 32"},
						salario: 1600,
						edad: 55
						})	

-----------------------------------------------------------------------------
use centroeducativo;
Alumno1 = {nombre:'Ana',telefono:658121212,curso:'2º DAM', nota:7}
Alumno2 = {nombre:'Juan',telefono:687454545,curso:'2º DAM', nota:9}
db.alumnos.save(Alumno1);
db.alumnos.save(Alumno2);
db.alumnos.insert({nombre:'Marta',telefono:647989898,curso:'2º DAM', nota:10});
db.alumnos.insert({nombre:'Isabel', telefono:654858585, curso:'1º DAM', nota: 8});
db.alumnos.insert({nombre:'Lucía', telefono:619858585, curso:'1º DAM', nota: 'ocho'});
db.alumnos.insert({nombre:'Patricia', telefono:623585858, curso:'1º DAM', nota: 'nueve'});


db.libros.insert({
	codigo: 1, 
	titulo: 'Código Limpio', 
	precio: 35, 
	editorial: 'Anaya', 
	autor: 'Robert C. Martín', 
	temas: ['Nombres con sentido', 'Funciones', 'Comentarios','Formato']
})

db.libros.insert({
	codigo: 2, 
	titulo: 'Patrones de Diseño en Java', 
	precio: 32, editorial: 'Eni', 
	autor: 'Laurent Debrauwer', 
	temas: ['Patrones de construcción', 'Patrones de construcción', 'Patrones de comportamiento']
})

db.libros.insert({
	codigo: 3, 
	titulo: 'Java y Eclipse', 
	precio: 40, 
	editorial: 'Eni', 
	autor: 'Fréderic Delechamp', temas: ['Diseño', 'Conexion', 'MVC']
})

---CONSULTAS
show dbs;
use centroeducativo;
show collections;

db.alumnos.find().sort({nombre:-1});
db.alumnos.find().sort({nombre:1});
db.alumnos.find({nombre:'Juan'});
db.alumnos.find({nombre:'Juan'},{telefono:1});
db.alumnos.find({curso:'1º DAM'});
db.alumnos.find({curso:'1º DAM'},{nombre:1,nota:1});
db.alumnos.find({},{nombre:1,nota:1});
db.alumnos.find({},{_id:0,nombre:1,nota:1});
db.alumnos.insert({nombre:'Isabel',telefono:'654858585',curso:'1º DAM',nota:8});
db.alumnos.insert({ _id:1,nombre:'Pepe',telefono:'654999999',direccion:{calle: 'Avda. Galicia',numero: 33,ciudad: 'Vigo'},curso:'2º DAM',nota:9});

db.alumnos.find({curso:'1º DAM'}).count();
db.alumnos.find({curso:'2º DAM'}).count();
db.alumnos.find().pretty();
db.alumnos.findOne();

--Selectores Búsquedas Comparación
$eq,$ne
db.alumnos.find({nota:{$ne:7}});
$gt,$lt
$gte,$lte
db.alumnos.find({nota:{$gte:7}});
$in,$nin
db.alumnos.find({nota:{$in:[6,8,9]}});
db.alumnos.find({nota:{$nin:[6,8,9]}});

db.alumnos.find({nota:{$type:2}},{nombre:1,nota:1});
db.alumnos.find({nota:{$type:1}},{nombre:1,nota:1});

--Selectores Búsquedas Lógicos
db.alumnos.find({$or:[{nota:{$gt:8}},{curso:'1º DAM'}]});
db.alumnos.find({$and:[{nota:7},{curso:'2º DAM'}]});
db.alumnos.find({nota:{$gte:7}},{curso:'2º DAM'});
db.alumnos.find({nota:{$not:{$gt:8}}});

db.alumnos.find({$nor:[{nota:{$gt:8}},{curso:'1º DAM'}]});

-- dos alumnos sin nota
db.alumnos.insert({nombre:'Alumno1',telefono:699111111,curso:'2º DAM'});
db.alumnos.insert({nombre:'Alumno2',telefono:699222222,curso:'2º DAM'});
db.alumnos.find({nota:{$exists:false}});
db.alumnos.find({nota:{$exists:true}});

db.alumnos.save({nombre:'Eloy',telefono:699333333,curso:'2º DAM', nota:7});

db.alumnos.update({nombre: "Ana"}, {nombre: "Ana María"});
db.alumnos.update({nombre: "Ana María"}, {$set: {nota: 8, direccion:"Vigo"}});

db.alumnos.update({nombre: "Ana María"}, {$unset: {direccion:"Bilbao"}}, {multi: true})

db.alumnos.update({nombre: "Ana María"}, {$inc: {nota: 2}})

db.libros.find({temas: "Formato"})

db.libros.update({titulo: "Java y Eclipse"}, {$set:{"temas.5" :"Análisis"}})
db.libros.find({titulo: "Java y Eclipse"}).pretty()

db.libros.update({titulo: "Java y Eclipse", temas: "Modelo Vista Controlador"}, {$set:{"temas.$" : "MVC"}})

//Colección empleados, con 4 empleados.
use empresa;

db.empleados.drop();
db.empleados.insert({_id:'emp1',nombre:"Juan", salario:1000,
fechaalta:"10/10/1999"})
db.empleados.insert({_id:'emp2',nombre:"Alicia", salario:1400,
fechaalta:"07/08/2000", oficio: "Profesora"})
db.empleados.insert({_id:'emp3',nombre:"María Jesús", salario:1500,
fechaalta: "05/01/2005", oficio: "Analista", comisión:100})
db.empleados.insert({_id:'emp4',nombre:"Alberto", salario:1100,
fechaalta:"15/11/2001"})
db.empleados.find();
//Colección departamentos con dos departamentos, asignamos los dos primeros
//empleados al primer departamento, y al segundo el resto de empleados
db.departamentos.drop();
db.departamentos.insert({_id:'dep1',nombre:"Informática",loc:'Madrid', emple:['emp1', 'emp2']})
db.departamentos.insert({_id:'dep2',nombre:"Gestión",loc:'Talavera',emple:['emp3', 'emp4' ]})

db.departamentos.find()

departrabajo = db.departamentos.findOne({_id: "dep1"})

-- Recuperamos los empleados cuyo _id se encuentre enlazado a este departamento(departrabajo en el ejemplo)
empleadosDepartamento = db.empleados.find({_id: {$in: departrabajo.emple }} )

-- Obtener los empleados del departamento dep2 que tienen un salario > que 1400.
-- Se carga el departamento:

departrabajo = db.departamentos.findOne({_id: "dep2"})
--Y después obtenemos los empleados
empleDepartamento = db.empleados.find({_id: {$in:
                                    departrabajo.emple},salario:{$gt: 1400}}).toArray()

