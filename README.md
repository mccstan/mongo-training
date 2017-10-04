# Formation Mongo DB

## TP1 : Installation (Ubuntu  avec tarball)

### Récupérer le tarball
```shell
curl -O https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-3.4.9.tgz
```

### Extraire le contenu
```shell
tar -zxvf mongodb-linux-x86_64-3.4.9.tgz
```

### Déplacer les fichiers extrait dans le dossier ou Mongo DD va être lancé
```shell
mkdir -p mongodb
cp -R mongodb-linux-x86_64-3.4.9/* mongodb/
```

### Ajouter Mongo DB dans les variables d'environnement
Le plus simple c'est d'ajouter l'instruction suivante dans le fichier ~/.bashrc

```shell
export PATH=<mongodb-install-directory>/bin:$PATH
```

### Créer le dossier des données
Il faut s'assurer des permissions en lecture et en écriture sur ce dossier

```shell
mkdir -p /data/db
```


### Démarrer le serveur

```shell
mongod
```

### Lancer Mongo Shell

```shell
mongo
```


## TP2 : Décourverte du shell Mongo
### Afficer la base de données en utilisation
```js
db
```
Cela devrait afficher test qui est la base de données par défaut.


### Afficher la bases de données disponibles
```js
show dbs
```

### Utiliser une base de données
```shell
use <database>
```
Il est possible d'utiliser une base de données ou une collection inexitante.Par exemple le code suivant créer la base `myNewDatabase` et la collection `myCollection` pendant l'opération `insertOne()` 
```js
use myNewDatabase
db.myCollection.insertOne( { x: 1 } );
```
`db` fait réference à la base de données en utilisation 
`myCollection` est le nom de la collection

























# Import mongo dataset
```shell
mongoimport --db mongo-training --collection companies --file companies.json
```