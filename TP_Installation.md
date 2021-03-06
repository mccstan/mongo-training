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

### Déplacer les fichiers extrait dans le dossier où mongo db va être lancé

```shell
mkdir -p mongodb
cp -R mongodb-linux-x86_64-3.4.9/* mongodb/
```

### Ajouter mongo db dans les variables d'environnement

Le plus simple c'est d'ajouter l'instruction suivante dans le fichier ~/.bashrc

```shell
export PATH=<mongodb-install-directory>/bin:$PATH
```

### Créer le dossier pour le stockage des données

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


## Installer Weave scope
sudo curl -L git.io/scope -o /usr/local/bin/scope
sudo chmod a+x /usr/local/bin/scope


## Lancer : par défaut sur le port 4040
scope launch
## lancer avec un autre port et/ou adresse
scope launch --app.http.address=127.0.0.1:9000