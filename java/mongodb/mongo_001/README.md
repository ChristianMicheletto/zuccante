# Java e MongoDB

Prima di tutto di sia un'occhiata alla documentazione del driver: [qui](http://mongodb.github.io/mongo-java-driver/2.13/getting-started/quick-tour/). Con IDEA si procede agevolmente come indicato [qui](http://mongodb.github.io/mongo-java-driver/2.13/getting-started/installation-guide/).
```
dependencies {
      compile 'org.mongodb:mongo-java-driver:2.13.3'
  }
```
per il driver Java e
```
dependencies {
      compile 'org.mongodb:bson:2.13.3'
  }
```
per BSON. La nostra installazione di MongoDB viene fatta senza alcuna restrizione, usando la shell abbiamo eseguito le seguenti istruzioni
```
$ mongo testdb
...
connecting to: testdb
> db
testdb
> db.cars.insert({name: "Audi", price: 52642})
> db.cars.insert({name: "Mercedes", price: 57127})
> db.cars.insert({name: "Skoda", price: 9000})
> db.cars.insert({name: "Volvo", price: 29000})
> db.cars.insert({name: "Bentley", price: 350000})
> db.cars.insert({name: "Citroen", price: 21000})
> db.cars.insert({name: "Hummer", price: 41400})
> db.cars.insert({name: "Volkswagen", price: 21600})
```
abbiamo cioè creato il DB `testdb` con la collezione `cars` ed abbiamo inserito vari documenti.
- API: [qui](http://mongodb.github.io/mongo-java-driver/3.4/javadoc/).
- Per l'ggetto `Document`: [qui](http://mongodb.github.io/mongo-java-driver/3.4/bson/documents/).
- per partire: [qui](http://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/). 

# Shell di MongoDB

Come i DBMS relazionali, vedi MariaDB e MySQL, anche MongoDB ha una sua [shell](https://docs.mongodb.com/getting-started/shell/client/), vediamo un uso (oltre a quanto visto sopra)
```
> show dbs
admin   0.000GB
local   0.000GB
testdb  0.000GB
> show databases
admin   0.000GB
local   0.000GB
testdb  0.000GB
> use testdb
switched to db testdb
> show collections
cars
> 
```
e quindi
```
> db.cars.find()
{ "_id" : ObjectId("5896013eb8ecba9579ff1a8f"), "name" : "Audi", "price" : 52642 }
{ "_id" : ObjectId("58960148b8ecba9579ff1a90"), "name" : "Mercedes", "price" : 57127 }
{ "_id" : ObjectId("58960156b8ecba9579ff1a91"), "name" : "Skoda", "price" : 9000 }
{ "_id" : ObjectId("58960160b8ecba9579ff1a92"), "name" : "Volvo", "price" : 29000 }
{ "_id" : ObjectId("58960168b8ecba9579ff1a93"), "name" : "Bentley", "price" : 350000 }
{ "_id" : ObjectId("58960171b8ecba9579ff1a94"), "name" : "Citroen", "price" : 21000 }
{ "_id" : ObjectId("5896017cb8ecba9579ff1a95"), "name" : "Hummer", "price" : 41400 }
{ "_id" : ObjectId("58960189b8ecba9579ff1a96"), "name" : "Volkswagen", "price" : 21600 }
{ "_id" : ObjectId("5896125a4ccef25e43b4dca8"), "name" : "Scassona", "price" : 0 }
```
una quesry
```
> db.cars.find({name: "Scassona"})
{ "_id" : ObjectId("5896125a4ccef25e43b4dca8"), "name" : "Scassona", "price" : 0 }
```
per cancellare
```
> db.cars.find({name: "Scassona"})
{ "_id" : ObjectId("5896125a4ccef25e43b4dca8"), "name" : "Scassona", "price" : 0 }
> db.cars.remove({name: "Scassona"})
WriteResult({ "nRemoved" : 1 })
```
