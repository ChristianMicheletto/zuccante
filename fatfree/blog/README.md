# Blog

Per prima cosa creiamo le tabelle
```
MariaDB [fatblog]> CREATE TABLE Articles (
    -> id INT NOT NULL AUTO_INCREMENT,
    -> timestamp DATETIME NOT NULL,
    -> title VARCHAR(120) NOT NULL,
    -> summary VARCHAR(120) NOT NULL,
    -> content TEXT NOT NULL,
    -> author VARCHAR(120) NOT NULL,
    -> PRIMARY KEY(id));
```
per gli utenti abbiamo
```
MariaDB [fatblog]> CREATE TABLE Users(
    -> id INT NOT NULL AUTO_INCREMENT,
    -> name VARCHAR(200) NOT NULL,
    -> password VARCHAR(20) NOT NULL,
    -> PRIMARY KEY(id));
```

