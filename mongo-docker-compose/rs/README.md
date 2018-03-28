# Lancer les conteneurs 
docker-compose up -d

## Initialiser le cluster
./initiate

## Statut du cluster
rs.status()

## Ecrire de la donnée sur le maître

## Lire la donnée sur un slave
rs.slaveOk()

## statut du slave
rs.printSlaveReplicationInfo()