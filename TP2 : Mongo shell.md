# Formation Mongo DB


## TP2 : Décourverte du shell Mongo
### Afficer la base de données en utilisation
```js
db
```
Cela devrait afficher test qui est la base de données par défaut.


### Afficher la bases de données disponibles
```js
show dbs
``````

### Utiliser une base de données
```shell
use <database>
```
Il est possible d'utiliser une base de données ou une collection inexitante.Par exemple le code suivant créer la base `myNewDatabase` et la collection `myCollection` pendant l'opération `insertOne()` 
```js
use myNewDatabase
db.myCollection.insertOne( { x: 1 } );
db.myCollection.insertOne( { x: 2 } );
db.myCollection.insertOne( { x: 3 } );
db.myCollection.insertOne( { x: 4 } );
db.myCollection.insertOne( { x: 5, y : {a : 1, b : 2} } );
```
Un acquitement est reçu pour confirmer l'insertion
```js
> db.myCollection.insertOne( { x: 1 } );
{
        "acknowledged" : true,
        "insertedId" : ObjectId("59f1abceb6729ac81ebf5755")
}
```

`db` fait réference à la base de données en utilisation 
`myCollection` est le nom de la collection

### Afficher les collections disponibles
```js
show collections
```

### Obtenir de l'aide sur les fonctions disponibles pour manipuler la collection
Utiliser le nom de la fonction sans parenthèses
On obtient une aide détaillée sur la fonction find
```js
> db.myCollection.find
function (query, fields, limit, skip, batchSize, options) {
    var cursor = new DBQuery(this._mongo,
                             this._db,
                             this,
                             this._fullName,
                             this._massageObject(query),
                             fields,
                             limit,
                             skip,
                             batchSize,
                             options || this.getQueryOptions());

    var connObj = this.getMongo();
    var readPrefMode = connObj.getReadPrefMode();
    if (readPrefMode != null) {
        cursor.readPref(readPrefMode, connObj.getReadPrefTagSet());
    }

    var rc = connObj.getReadConcern();
    if (rc) {
        cursor.readConcern(rc);
    }

    return cursor;
}
```

### La fonction find
affiche l'ensemble des documents de la collection
```js
> db.myCollection.find()
{ "_id" : ObjectId("59f1abceb6729ac81ebf5755"), "x" : 1 }
{ "_id" : ObjectId("59f1dadb24d9ac7cc4c3e468"), "x" : 2 }
{ "_id" : ObjectId("59f1dadb24d9ac7cc4c3e469"), "x" : 3 }
{ "_id" : ObjectId("59f1dae724d9ac7cc4c3e46a"), "x" : 4 }
{ "_id" : ObjectId("59f1dcb224d9ac7cc4c3e46b"), "x" : 5, "y" : { "a" : 1, "b" : 2 } }
```
### Formatter l'affichage avec la fonction pretty
Affichage hierarchique ...
```js
> db.myCollection.find().pretty()
{ "_id" : ObjectId("59f1abceb6729ac81ebf5755"), "x" : 1 }
{ "_id" : ObjectId("59f1dadb24d9ac7cc4c3e468"), "x" : 2 }
{ "_id" : ObjectId("59f1dadb24d9ac7cc4c3e469"), "x" : 3 }
{ "_id" : ObjectId("59f1dae724d9ac7cc4c3e46a"), "x" : 4 }
{
        "_id" : ObjectId("59f1dcb224d9ac7cc4c3e46b"),
        "x" : 5,
        "y" : {
                "a" : 1,
                "b" : 2
}
```


### Opérations sur plusieurs lignes
```js
> var i = 12
> if (i> 5){
... print(i);
... print(i - 5);
... }
12
7
```