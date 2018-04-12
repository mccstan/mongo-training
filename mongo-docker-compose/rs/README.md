# Lancer les conteneurs 
docker-compose up -d

## Initialiser le cluster
./initiate

## Statut du cluster
rs.status()

## Ecrire de la donnée sur le maître
for (var i = 1; i <= 500; i++) db.exampleCollection.insert( { x : i } )

## Lire la donnée sur un slave
rs.slaveOk()

## statut du slave
rs.printSlaveReplicationInfo()