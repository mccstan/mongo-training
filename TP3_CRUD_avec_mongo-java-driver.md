# Formation Mongo DB

### Dépendance

**Maven**
```xml
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongo-java-driver</artifactId>
    <version>3.5.0</version>
</dependency>

```

**Gradle**
```groovy
compile group: 'org.mongodb', name: 'mongo-java-driver', version: '3.5.0'
```


### Les imports
```java
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.MongoCredential;
import com.mongodb.MongoClientOptions;

import java.util.Arrays;
```

### Connection à la base de données
**MongoClient**
```java
// Connection par défaut à localhost:27017
MongoClient mongoClient = new MongoClient();

// Connection à un hôte en utilisant l'hôte le port par défaut : 27017
MongoClient mongoClient = new MongoClient( "host1" );

// Connection à un hôte spécifique sur un port spécifique
MongoClient mongoClient = new MongoClient( "host1" , 27017 );

// Connection en utilisant une URL de connection
MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://host1:27017"));

// Connection à un Replica set
MongoClient mongoClient = new MongoClient(
Arrays.asList(new ServerAddress("host1", 27017),
              new ServerAddress("host2", 27017),
              new ServerAddress("host3", 27017)));

```


### 
