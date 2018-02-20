### Dépendances
```groovy
compile 'org.springframework.boot:spring-boot-starter-web:1.5.6.RELEASE'
compile 'org.springframework.data:spring-data-mongodb:1.10.6.RELEASE'
```

### Configurations : application.properties
```
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=mongo-training
```


### Tester les endpoints Rest
#### 1. Create

***Http Request avec Postman***
```http
http Request
POST /user HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "id" : "E01",
    "name" : "name 1",
    "age" : 20,
    "email" : "name1@gmail.com"
}
```

***Equivalent Curl***
```shell
curl -X POST \
  http://localhost:8080/user \
  -H 'content-type: application/json' \
  -d '{
    "id" : "E01",
    "name" : "name 1",
    "age" : 20,
    "email" : "name1@gmail.com"
}'
```


#### 2. Read

***Http Request avec Postman***
```http
GET /user/E01 HTTP/1.1
Host: localhost:8080

```

***Equivalent Curl***
```shell
curl -X GET \
  http://localhost:8080/user/E01 \
```

#### 3. Update

***Http Request avec Postman***
```http
PUT /user HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "id" : "E01",
    "_class" : "fr.soat.model.User",
    "name" : "name 1",
    "age" : 21,
    "email" : "name1@gmail.com"
}
```

***Equivalent Curl***
```shell
curl -X PUT \
  http://localhost:8080/user \
  -H 'content-type: application/json' \
  -d '{
    "id" : "E01",
    "_class" : "fr.soat.model.User",
    "name" : "name 1",
    "age" : 21,
    "email" : "name1@gmail.com"
}'
```



#### 4. Delete

***Http Request avec Postman***
```http
DELETE /user/E01 HTTP/1.1
Host: localhost:8080

```

***Equivalent Curl***
```shell
curl -X DELETE \
  http://localhost:8080/user/E01 \
```