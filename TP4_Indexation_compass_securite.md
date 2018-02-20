# Formation Mongo DB


## TP4 : Indexation

### Afficher les index disponibles sur une collection

```js
use mongo-training
db.restaurants.getIndexes()
```

### Requête sans index

```js
> db.restaurants.find({cuisine:"American"}).explain()
{
        "queryPlanner" : {
                "plannerVersion" : 1,
                "namespace" : "mongo-training.restaurants",
                "indexFilterSet" : false,
                "parsedQuery" : {
                    "cuisine" : {
                        "$eq" : "American"
                        }
                },
                "winningPlan" : {
                        "stage" : "COLLSCAN",
                        "filter" : {
                                "cuisine" : {
                                        "$eq" : "American"
                                }
                        },
                        "direction" : "forward"
                },
                "rejectedPlans" : [ ]
        },
        "serverInfo" : {
                "host" : "DESKTOP-1P1NJ6T",
                "port" : 27017,
                "version" : "3.4.7",
                "gitVersion" : "cf38c1b8a0a8dca4a11737581beafef4fe120bcd"
        },
        "ok" : 1
}
```

### Créer un index sur cuisine

```js
> db.restaurants.createIndex({cuisine: 1})
{
        "createdCollectionAutomatically" : false,
        "numIndexesBefore" : 1,
        "numIndexesAfter" : 2,
        "ok" : 1
}
```


### On requête à nouveau

```js
> db.restaurants.find({cuisine:"American"}).explain()
{
        "queryPlanner" : {
                "plannerVersion" : 1,
                "namespace" : "mongo-training.restaurants",
                "indexFilterSet" : false,
                "parsedQuery" : {
                        "cuisine" : {
                                "$eq" : "American"
                        }
                },
                "winningPlan" : {
                        "stage" : "FETCH",
                        "inputStage" : {
                                "stage" : "IXSCAN",
                                "keyPattern" : {
                                        "cuisine" : 1
                                },
                                "indexName" : "cuisine_1",
                                "isMultiKey" : false,
                                "multiKeyPaths" : {
                                        "cuisine" : [ ]
                                },
                                "isUnique" : false,
                                "isSparse" : false,
                                "isPartial" : false,
                                "indexVersion" : 2,
                                "direction" : "forward",
                                "indexBounds" : {
                                        "cuisine" : [
                                                "[\"American\", \"American\"]"
                                        ]
                                }
                        }
                },
                "rejectedPlans" : [ ]
        },
        "serverInfo" : {
                "host" : "DESKTOP-1P1NJ6T",
                "port" : 27017,
                "version" : "3.4.7",
                "gitVersion" : "cf38c1b8a0a8dca4a11737581beafef4fe120bcd"
        },
        "ok" : 1
}
```

## TP4 : Sécurité - RBAC

### Démarrer mongo DB sans contrôle d'accès activé
```shell
mongod
```


### Se connecter à l'instance
```shell
mongo
```

### Créer l'administrateur des utilisateurs
Il faut créer un utilisateur avec le rôle `userAdminAnyDatabase` dans la base de données `admin` qui sera la *`Base de données d'authentification`* pour les utilisateurs.

```js
use admin
db.createUser(
  {
    user: "admin",
    pwd: "admin",
    roles: [ { role: "userAdminAnyDatabase", db: "admin" } ]
  }
)
```

### Redémarrer l'instance mongo avec l'option --auth

```js
mongod --auth
```

### Se connecter et s'authentifier
Pendant la connection
```js
mongo -u "admin" -p "admin" --authenticationDatabase "admin"
```

Après la connection
```js
mongo
use admin
db.auth("admin", "admin" )
```


### Créer un utilisateur
Pendant la connection
```js
use admin
db.createUser(
  {
    user: "mccstan",
    pwd: "stan",
    roles: [ { role: "readWrite", db: "mongo-training" }]
  }
)
```

### Se connecter avec le nouvel utilisateur
Pendant la connection
```js
mongo -u "mccstan" -p "stan" --authenticationDatabase "admin"
db.restaurants.find().limit(2)
```

