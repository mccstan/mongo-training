# Formation Mongo DB

## Installation (UUbuntu  avec tarball)

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

