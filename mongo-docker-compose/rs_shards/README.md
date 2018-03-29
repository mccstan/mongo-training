# Lancer les conteneurs 
docker-compose up -d

## Initialiser le cluster
./initiate

## Passer sur les routeurs
connection shell ou scope

## Activer le sharding sur une BD
use exampleDB
sh.enableSharding("exampleDB")

## Vérifier
use config
db.databases.find()



## Activer le sharding
use exampleDB
db.exampleCollection.ensureIndex( { _id : "hashed" } )
sh.shardCollection( "exampleDB.exampleCollection", { "_id" : "hashed" } )

## Tester
for (var i = 1; i <= 500; i++) db.exampleCollection.insert( { x : i } )