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



## 