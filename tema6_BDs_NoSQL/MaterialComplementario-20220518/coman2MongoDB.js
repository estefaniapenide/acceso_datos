
//use base1	
db = db.getSiblingDB('base1')

//show dbs, show databases	
db.adminCommand('listDatabases')

//salidas por pantalla
printjson(db.adminCommand('listDatabases'))

//show collections	
db.getCollectionNames()

//show users	
db.getUsers()

//show roles	
db.getRoles({showBuiltinRoles: true})

//show log	
db.adminCommand({ 'getLog' : '' })

//show logs	
db.adminCommand({ 'getLog' : '*' })

//it	
cursor = db.collection.find();
while ( cursor.hasNext() ) {
   printjson( cursor.next() );
}

//db.dropDatabase()
//help
