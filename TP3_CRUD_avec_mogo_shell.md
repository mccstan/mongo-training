# Formation Mongo DB

## Opérations CRUD

### CREATE : Insertion de documents

Insérer un document

<img src="./imgs/crud-mongodb-insertOne.svg">

Exemple

```js
use mongo-training
db.trainings.insertOne(
    {
        nom : "Formation Mongo DB",
        description : "Une formation introductive",
        date : new Date(),
        nb_participants : 10
    }
)
```

Aquitement

```js
{
        "acknowledged" : true,
        "insertedId" : ObjectId("5a01860ed4dba15e9353bf53")
}
```

`Imaginez d'autres formations et insérer les .... puis utilisez la fonction find pour afficher après chaque insertion.`

Utiliser la fonction insertMany pour réinsérer les documents précédents

```js
db.trainings.insertMany(
    [ <document 1> , <document 2>, ... , <document n>]
)
```

**Exemple**
```js
db.trainings.insertMany([
    {
        nom : "Formation Mongo DB",
        description : "Une formation introductive",
        date : new Date("2018-01-25"),
        nb_participants : 10
    },
    {
        nom : "Formation Mongo DB",
        description : "Une formation introductive",
        date : new Date(),
        nb_participants : 10
    },
    {
        nom : "Formation Cassandra",
        description : "Une formation introductive à Cassandra",
        date : new Date("2017-11-07"),
        nb_participants : 150
    },
    {
        nom : "Formation HD Insight",
        description : "Une formation introductive à HD Insight",
        date : new Date("2017-11-08"),
        nb_participants : 15
    },
    {
        nom : "Formation Spark",
        description : "Une formation introductive à Spark",
        date : new Date("2017-11-09"),
        nb_participants : 9
    }
])
```

### READ : requêtes sur les documents

Rechercher un ou plusieurs documents

<img src="./imgs/crud-mongodb-find.svg">

### Projection 

La projection est soit *`inclusive`* ou *`exclusive`*, pas les deux : on peut soit spécifier un ensemble de colonnes souhaitées dans résultat, ou un ensemble de colonnes à exclure du résultat.

**Inclusion**
```js
{ <field1>: 1, <field2>: 1 ... }
```

**Exclusion**
```js
{ <field1>: 0, <field2>: 0 ... }
```

Exemple : Les colonnes `id` et `nom`

```js
db.trainings.find({},{_id: 1, nom: 1})

```

Exemple : Tous les attributs sauf `_id`

```js
db.trainings.find({},{_id: 0})
```

Si vous essayer les deux vous aurez une erreur
```js
db.trainings.find({},{_id: 1, nom: 0})
Error: error: {
        "ok" : 0,
        "errmsg" : "Projection cannot have a mix of inclusion and exclusion.",
        "code" : 2,
        "codeName" : "BadValue"
}
```


#### Les filtres

**Avec opérateur**
```js
{ <field>: { $operator: <value> } }
```

**Sans opérateur : égalité**
```js
{ <field>: <value> }
```

Pour appliquer des filtres dans les requêtes, plusieur opérateurs existent

| criterion |Description |
|---------|------------|
| $eq     | Matches values that are equal to a specified value.|
| $gt     | Matches values that are greater than a specified value.|
| $gte    | Matches values that are greater than or equal to a specified value.|
| $in     | Matches any of the values specified in an array.|
| $lt     | Matches values that are less than a specified value.|
| $lte    | Matches values that are less than or equal to a specified value.|
| $ne     | Matches all values that are not equal to a specified value.|
| $nin    | Matches none of the values specified in an array.|

**Exemples**

* **#1**
    * Correspondance SQL

        ```SQL
        SELECT * FROM table
        ```

    * Filtre appliqué : fonction find sans paramètres 

        ```js
        db.trainings.find()
        ```

* **#2**
    * Correspondance SQL

        ```SQL
        SELECT * FROM table WHERE nom = "Mongo"
        ```

    * Mongo shell

        ```js
        db.trainings.find({nom : Mongo},{})
        ```
        `ou`
        ```js
        db.trainings.find({nom : {$eq: "Mongo"}}, {})
        ```

* **#3**
    * Correspondance SQL

        ```SQL
        SELECT * FROM table WHERE nom LIKE "%Mongo%"
        ```

    * Mongo

        ```SQL
        db.trainings.find({nom : /Mongo/}, {})
        ```

* **#4**
    * Correspondance SQL

        ```js
        SELECT * FROM table WHERE nom LIKE "Formation%"
        ```

    * Mongo

        ```SQL
        db.trainings.find({nom : /^Formation/}, {})
        ```



* **#5**
    * Correspondance SQL

        ```SQL
        SELECT * FROM table WHERE nb_participants > 10
        ```

    * Mongo

        ```js
        db.trainings.find({nb_participants : { $gt: 10}}, {})
        ```

* **#6**
    * Correspondance SQL

        ```SQL
        SELECT * FROM table WHERE date = "2017-11-08"
        ```

    * Mongo

        ```js
        db.trainings.find({date : { $eq: new Date("2017-11-08")}}, {})
        ```

### UPDATE : Mettre à jour un ou plusiuers documents 

Trois méthodes pour mettre à jour des documents :

```js
db.collection.updateOne(<filter>, <update>, <options>)
db.collection.updateMany(<filter>, <update>, <options>)
db.collection.replaceOne(<filter>, <replacement>, <options>)
```


**Le filtre est précisé comme avec la fonction `find`**

**La mise à jour uodate est ensuite précisée en utilisant un opérateur**

| update operator | Description |
| --- | --- |
| $currentDate | Sets the value of a field to current date, either as a Date or a Timestamp. |
| $inc | Increments the value of the field by the specified amount. |
| $min | Only updates the field if the specified value is less than the existing field value. |
| $max | Only updates the field if the specified value is greater than the existing field value. |
| $mul | Multiplies the value of the field by the specified amount. |
| $rename | Renames a field. |
| $set | Sets the value of a field in a document. |
| $setOnInsert | Sets the value of a field if an update results in an insert of a document. Has no effect on update operations that modify existing documents. |
| $unset | Removes the specified field from a document. |


**Expemples**

* **#1 : Mettre à jour la description de la formation "Formation Mongo DB"**
La foncption updateOne applique la mise à jour au premier document qui match avec le filtre, et dont la nouvelle valeur est différente de la précédente .

    ```js
        db.trainings.updateOne(
            {nom : /Formation Mongo DB/},
            {
                $set: { description: "Une formation introductive à Mongo DB"},
            }

        )
    ```
    Un aquitement précise le nombre de match et le nombre de documents mis à jour
    ```js 
    { "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }
    ```

* **#2 : Mettre à jour la description des formations dont le nom contient "Mongo"**
La foncption updateMany applique la mise à jour à tous les documents qui match le filtre, et dont la nouvelle valeur est différente de la précédente.
*

    ```js
        db.trainings.updateMany(
            {nom : /Mongo/},
            {
                $set: { description: "Une formation introductive à Mongo DB"},
            }

        )
    ```
    Un aquitement précise le nombre de match et le nombre de documents mis à jour
    ```js 
    { "acknowledged" : true, "matchedCount" : 2, "modifiedCount" : 2 }
    ```

* **#3 : Remplacer le document dont le nom match avec  "Mongo"**
La foncption ReplaceOne applique la mise à jour au premier document qui match le filtre
*

    ```js
        db.trainings.replaceOne(
            {nom : /Mongo/},
            {
                nom : "Formation Mongo DB",
                description : "Une formation introductive à Mongo DB chez SOAT",
                date : new Date("2017-11-25"),
                nb_participants : 20
            }

        )
    ```
    Un aquitement précise le nombre de match et le nombre de documents mis à jour
    ```js 
    { "acknowledged" : true, "matchedCount" : 1, "modifiedCount" : 1 }
    ```

### DELETE : Supprimer un ou plusieurs documents

Deux fonctions : Pour supprimer il faut juste préciser le filtre
```js
db.collection.deleteMany() // Supprime tous les documents qui match le filtre
db.collection.deleteOne() // Supprime le premier document qui match le filtre
```

Supprimer le document de nom "Formation Cassandra"
```js
db.trainings.deleteOne(
    {nom : /Formation Cassandra/}
)
```

Supprimer toutes les formations Mongo
```js
db.trainings.deleteMany(
    {nom : /Mongo/}
)
```


Supprimer tous les documents
```js
db.trainings.deleteMany({})
```